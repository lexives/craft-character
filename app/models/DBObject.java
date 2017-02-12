package models;

import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.hibernate.annotations.Type;

@MappedSuperclass
public class DBObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "objectid")
    private String _id;
    
    public String getId()
    {
	return _id;
    }
    
    @Override
    public int hashCode()
    {
	return new ObjectId(_id).hashCode();
    }
    
    @Override
    public boolean equals(Object other)
    {
	return other instanceof DBObject && ((DBObject) other)._id.equals(_id);
    }
}
