package controllers;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

import com.fasterxml.jackson.databind.JsonNode;

import models.MongoObject;
import play.libs.Json;
import play.mvc.Controller;
import uk.co.panaxiom.playjongo.PlayJongo;

public class DBController<T extends MongoObject> extends Controller {
    
    @Inject
    private PlayJongo db;

    @NotNull
    private final Class<T> clazz;
    
    protected DBController(@NotNull Class<T> clazz)
    {
	this.clazz = clazz;
    }

    @NotNull
    protected MongoCollection db()
    {
	return db.getCollection(clazz.getSimpleName());
    }

    @NotNull
    protected List<T> find()
    {
	List<T> res = new LinkedList<>();
	db().find().as(clazz).forEach((T a) -> res.add(a));
	return res;
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
	return db().findOne(new ObjectId(id)).as(clazz);
    }
}
