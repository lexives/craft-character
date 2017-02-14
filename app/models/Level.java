package models;

import javax.persistence.Entity;

@Entity
public class Level extends DBObject
{
    private byte bab;
    private byte fort;
    private byte reflex;
    private byte will;
    
    public int getBAB() {
	return bab;
    }
    
    public int getFort() {
	return fort;
    }
    
    public int getReflex() {
	return reflex;
    }
    
    public int getWill() {
	return will;
    }
}
