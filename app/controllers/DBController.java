package controllers;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.JsonNode;

import models.DBObject;
import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.Controller;

public class DBController<T extends DBObject> extends Controller {

    @NotNull
    private final Class<T> clazz;
    
    protected DBController(@NotNull Class<T> clazz)
    {
	this.clazz = clazz;
    }

    @NotNull
    @SuppressWarnings("unchecked")
    protected List<T> find()
    {
	return (List<T>) JPA.em().createNativeQuery("").getResultList();
    }
    
    @NotNull
    protected T getBody() throws IllegalStateException
    {
	JsonNode body = request().body().asJson();
	if (body != null)
	{
	    return Json.fromJson(body, clazz);
	}
	else
	{
	    throw new IllegalStateException("Request body is not a JSON.");
	}
    }
    
    protected T find(@NotNull String id) throws IllegalArgumentException
    {
	return JPA.em().find(clazz, id);
    }
}
