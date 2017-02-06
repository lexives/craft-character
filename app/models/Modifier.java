package models;

public class Modifier {
    
    private int value;
    private String type;
    
    public Modifier(int val, String tp)
    {
	value = val;
	type = tp;
    }
    
    public Modifier()
    {
    }
    
    public int getValue()
    {
	return value;
    }
    
    public void setValue(int val)
    {
	value = val;
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
