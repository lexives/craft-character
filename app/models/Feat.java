package models;

import javax.persistence.Entity;
import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptException;

import com.fasterxml.jackson.annotation.JsonProperty;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

@Entity
public class Feat extends DBObject {
    
    private static final NashornScriptEngine scriptEv;
    
    static
    {
	scriptEv = (NashornScriptEngine) new NashornScriptEngineFactory().getScriptEngine();
    }
    
    private String name;
    private String summary;
    private String description;
    private transient CompiledScript cmped;
    private String code;
    
    public String getName()
    {
	return name;
    }
    
    public void setName(String name)
    {
	this.name = name;
    }
    
    public String getSummary()
    {
	return summary;
    }
    
    public void setSummary(String summary)
    {
	this.summary = summary;
    }
    
    public String getDescription()
    {
	return description;
    }
    
    public void setDescription(String description)
    {
	this.description = description;
    }

    @JsonProperty("code")
    public String getCode()
    {
	return code;
    }
    
    @JsonProperty("code")
    public void setCode(String code)
    {
	try
	{
	    this.code = code;
	    cmped = scriptEv.compile(code);
	}
	catch (ScriptException se)
	{
	    throw new IllegalArgumentException("Not a valid javascript code segment.");
	}
    }
    
    public void apply(Character c)
    {
	try
	{
	    Bindings b = scriptEv.createBindings();
	    b.put("character", c);
	    cmped.eval(b);
		
	}
	catch (ScriptException se)
	{
	    throw new IllegalStateException(String.format("Script is not valid: %s:%d %s",
		    se.getFileName(), se.getLineNumber(), se.getMessage()));
	}
    }
}
