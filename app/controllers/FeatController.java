package controllers;

import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;

import java.util.List;

import javax.inject.Inject;

import models.Feat;

public class FeatController extends DBController<Feat> {
    
    @Inject
    public FeatController()
    {
	super(Feat.class);
    }

    @Transactional()
    public Result create()
    {
	Feat f;
	try
	{
	    f = getBody();
	}
	catch (IllegalStateException ise)
	{
	    return badRequest("Request body not a properly formed JSON");
	}
	em().persist(f);
	return created(Json.toJson(f));
    }

    @Transactional()
    public Result update(String id)
    {
	try
	{
	    Feat f = getBody();
	    em().merge(id);
	    f = find(id);
	    return ok(Json.toJson(f));
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

    @Transactional()
    public Result delete(String id)
    {
	try
	{
	    Feat f = find(id);
	    if (f != null)
	    {
		em().remove(f);
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

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
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
