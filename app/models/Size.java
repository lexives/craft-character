package models;

public enum Size {
    FINE(8), DIMINUTIVE(4), TINY(2), SMALL(1), MEDIUM(0), LARGE_TALL(-1), LARGE_LONG(-1),
    HUGE_TALL(-2), HUGE_LONG(-2), GARGANTUAN_TALL(-4), GARGANTUAN_LONG(-4), COLOSSAL_TALL(-8), COLOSSAL_LONG(-8);
    
    private byte modifier;
    
    private Size(int modifier)
    {
	this.modifier = (byte) modifier;
    }
    
    public int getModifier()
    {
	return modifier;
    }
}
