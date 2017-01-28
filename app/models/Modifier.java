package models;

public class Modifier {
    private int value;
    private String type;
    
    public int getValue()
    {
	return value;
    }
    
    public boolean isBonus()
    {
	return value >= 0;
    }
    
    public boolean isPenalty()
    {
	return value < 0;
    }
    
    public String getType()
    {
	return type;
    }
}
