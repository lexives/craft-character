package controllers;

import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.Result;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import models.Character;
import models.Feat;

public class CharacterController extends DBController<Character> {
    
    @Inject
    public CharacterController() {
	super(Character.class);
    }

    public Result create()
    {
	Character c = new Character();
	JPA.em().persist(c);
	return created(Json.toJson(c));
    }
	
    public Result addFeats(String id, List<String> newFeatIds)
    {
	Character c;
	try
	{
	    c = find(id);
	}
	catch (IllegalArgumentException iae)
	{
	    return badRequest("Character ID is not valid");
	}
	if (c != null)
	{
	    try
	    {
		List<Feat> newFeats = new LinkedList<>();
		newFeatIds.forEach((String feat) -> {
		    Feat f = JPA.em().find(Feat.class, feat);
		    if (f == null)
		    {
			throw new NullPointerException("Feat ID "+feat+" does not exist");
		    }
		    newFeats.add(f);
		});
		newFeats.forEach(feat -> c.addFeat(feat));
		JPA.em().merge(c);
		return ok(Json.toJson(c));
	    }
	    catch (IllegalArgumentException iae)
	    {
		return badRequest("Feat ID is not valid");
	    }
	    catch (NullPointerException npe)
	    {
		return notFound(npe.getMessage());
	    }
	}
	else
	{
	    return notFound("No character with the ID " + id);
	}
    }

    public Result update(String id)
    {
	try
	{
	    Character c = getBody();
	    JPA.em().merge(c);
	    c = find(id);
	    return ok(Json.toJson(c));
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
		JPA.em().remove(c);
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
