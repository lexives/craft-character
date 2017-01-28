package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;

import models.Test;
import play.mvc.Controller;
import play.mvc.Result;
import uk.co.panaxiom.playjongo.PlayJongo;

@Singleton
public class DBTestController extends Controller {
    
    private PlayJongo db;

    @Inject
    public DBTestController(PlayJongo jongo) {
	db = jongo;
    }
 

    public Result put() {
	Test tmp = play.libs.Json.fromJson(request().body().asJson(), Test.class);
	db.getCollection("test").insert(tmp);
        return ok(play.libs.Json.toJson(tmp));
    }
}
