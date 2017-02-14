package controllers;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.JsonNode;

import models.DBObject;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;
import play.libs.Json;
import play.mvc.Controller;

public class DBController<T extends DBObject> extends Controller {
    
    @Inject
    protected JPAApi jpa;

    @NotNull
    private final Class<T> clazz;
    
    protected DBController(@NotNull Class<T> clazz)
    {
	this.clazz = clazz;
    }

    @NotNull
    protected EntityManager em()
    {
	return jpa.em();
    }

    @NotNull
    @SuppressWarnings("unchecked")
    protected List<T> find()
    {
	return (List<T>) em().createQuery(
			String.format("SELECT t FROM %s t", clazz.getSimpleName())
		).getResultList();
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
	return em().find(clazz, id);
    }
}
