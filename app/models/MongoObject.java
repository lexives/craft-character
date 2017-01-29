package models;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class MongoObject {
    @MongoObjectId
    private String _id;
    
    public String getId()
    {
	return _id;
    }
}
