package models;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class DBObject {
    @MongoObjectId
    private String _id;
    
    public String getId()
    {
	return _id;
    }
    
    @Override
    public int hashCode()
    {
	return _id.hashCode();
    }
    
    @Override
    public boolean equals(Object other)
    {
	return other instanceof DBObject && ((DBObject) other)._id.equals(_id);
    }
}
