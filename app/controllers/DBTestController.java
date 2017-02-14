package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;

import models.Test;
import play.db.jpa.Transactional;
import play.mvc.Result;

@Singleton
public class DBTestController extends DBController<Test> {

    @Inject
    public DBTestController() {
	super(Test.class);
    }
 
    @Transactional()
    public Result put() {
	Test tmp = play.libs.Json.fromJson(request().body().asJson(), Test.class);
	em().persist(tmp);
        return ok(play.libs.Json.toJson(tmp));
    }
}
