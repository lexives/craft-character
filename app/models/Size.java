package models;


public enum Size {
    
	FINE(new Modifier("Size", 8), "Fine"),
	DIMINUTIVE(new Modifier("Size", 4), "Diminutive"),
	TINY(new Modifier("Size", 2), "Tiny"),
	SMALL(new Modifier("Size", 1), "Small"),
	MEDIUM(new Modifier("Size", 0), "Medium"),
	LARGE(new Modifier("Size", -1), "Large"),
	HUGE(new Modifier("Size", -2), "Huge"),
	GARGANTUAN(new Modifier("Size", -4), "Gargantuan"),
	COLOSSAL(new Modifier("Size", -8), "Colossal");

    private final Modifier mod;
    private final String str;
    
    private Size(Modifier mod, String str)
    {
    	this.mod = mod;
    	this.str = str;
    }
    
    public Modifier getMod() {
    	return mod;
    }
    
    @Override
    public String toString()
    {
    	return str;
    }
}
