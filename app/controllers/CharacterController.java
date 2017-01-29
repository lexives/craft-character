package controllers;

import play.libs.Json;
import play.mvc.Result;

import java.util.List;

import javax.inject.Inject;

import org.bson.types.ObjectId;

import com.mongodb.WriteResult;

import models.Character;

public class CharacterController extends DBController<Character> {
    
    @Inject
    public CharacterController() {
	super(Character.class);
    }

    public Result create()
    {
	Character c = new Character();
	db().insert(c);
	return created(Json.toJson(c));
    }

    public Result update(String id)
    {
	try
	{
	    Character c = getBody();
	    WriteResult wr = db().update(new ObjectId(id)).with(c);
	    c = find(id);
	    if (!wr.isUpdateOfExisting())
	    {
		return created(Json.toJson(c));
	    }
	    else 
	    {
		return ok(Json.toJson(c));
	    }
	}
	catch (IllegalArgumentException iae)
	{
	    return badRequest("ID is not valid");
	}
	catch (IllegalStateException ise)
	{
	    return badRequest("Body is not a properly formatted JSON.");
	}
    }

    public Result delete(String id)
    {
	try
	{
	    Character c = find(id);
	    if (c != null)
	    {
		db().remove(new ObjectId(id));
		return ok(Json.toJson(c));
	    }
	    else 
	    {
		return notFound("No character with the ID " + id);
	    }
	}
	catch (IllegalArgumentException iae)
	{
	    return badRequest("ID is not valid");
	}
    }
    
    public Result list()
    {
	List<Character> c = find();
	if (c.size() > 0)
	{
	    return ok(Json.toJson(c));
	}
	else
	{
	    return notFound("You do not have any characters.");
	}
    }
    
    public Result get(String id)
    {
	try
	{
	    Character c = find(id);
	    if (c != null)
	    {
		return ok(Json.toJson(c));
	    }
	    else
	    {
		return notFound("No character with the ID " + id);
	    }
	}
	catch (IllegalArgumentException iae)
	{
	    return badRequest("ID is not valid");
	}
    }
}
