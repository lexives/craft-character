package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.mongodb.WriteResult;

import models.Test;
import play.mvc.Result;

@Singleton
public class DBTestController extends DBController<Test> {

    @Inject
    public DBTestController() {
	super(Test.class);
    }
 

    public Result put() {
	Test tmp = play.libs.Json.fromJson(request().body().asJson(), Test.class);
	WriteResult wr = db().insert(tmp);
        return ok(play.libs.Json.toJson(tmp));
    }
}
