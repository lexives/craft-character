package models;

public class Level extends MongoObject
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
