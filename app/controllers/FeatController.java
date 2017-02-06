package controllers;

import play.libs.Json;
import play.mvc.Result;

import java.util.List;

import javax.inject.Inject;

import org.bson.types.ObjectId;

import com.mongodb.WriteResult;

import models.Feat;

public class FeatController extends DBController<Feat> {
    
    @Inject
    public FeatController()
    {
	super(Feat.class);
    }

    public Result create()
    {
	Feat f;
	try
	{
	    f = getBody();
	}
	catch (IllegalStateException ise)
	{
	    f = new Feat();
	}
	db().insert(f);
	return created(Json.toJson(f));
    }

    public Result update(String id)
    {
	try
	{
	    Feat f = getBody();
	    WriteResult wr = db().update(new ObjectId(id)).with(f);
	    f = find(id);
	    if (!wr.isUpdateOfExisting())
	    {
		return created(Json.toJson(f));
	    }
	    else 
	    {
		return ok(Json.toJson(f));
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
	    Feat f = find(id);
	    if (f != null)
	    {
		db().remove(new ObjectId(id));
		return ok(Json.toJson(f));
	    }
	    else 
	    {
		return notFound("No feat with the ID " + id);
	    }
	}
	catch (IllegalArgumentException iae)
	{
	    return badRequest("ID is not valid");
	}
    }
    
    public Result list()
    {
	List<Feat> f = find();
	if (f.size() > 0)
	{
	    return ok(Json.toJson(f));
	}
	else
	{
	    return notFound("You do not have any feats.");
	}
    }
    
    public Result get(String id)
    {
	try
	{
	    Feat f = find(id);
	    if (f != null)
	    {
		return ok(Json.toJson(f));
	    }
	    else
	    {
		return notFound("No feat with the ID " + id);
	    }
	}
	catch (IllegalArgumentException iae)
	{
	    return badRequest("ID is not valid");
	}
    }
}
