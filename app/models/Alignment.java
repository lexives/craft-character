package models;

public enum Alignment {
    
    LAWFUL_GOOD((byte) 3, "Lawful Good"), LAWFUL_NEUTRAL((byte) 2, "Lawful Neutral"), LAWFUL_EVIL((byte) 6, "Lawful Evil"),
    NEUTRAL_GOOD((byte) 1, "Neutral Good"), TRUE_NEUTRAL((byte) 0, "True Neutral"), NEUTRAL_EVIL((byte) 4, "Neutral Evil"),
    CHAOTIC_GOOD((byte) 9, "Chaotic Good"), CHAOTIC_NEUTRAL((byte) 8, "Chaotic Neutral"), CHAOTIC_EVIL((byte) 12, "Chaotic Evil");

    private static byte GOOD = 1;
    private static byte EVIL = 4;
    private static byte LAWFUL = 2;
    private static byte CHAOTIC = 8;

    private final byte align;
    private final String str;
    
    private Alignment(byte b, String str)
    {
	align = b;
	this.str = str;
    }
    
    public boolean isGood()
    {
	return (align & GOOD) != 0;
    }
    
    public boolean isLawful()
    {
	return (align & LAWFUL) != 0;
    }
    
    public boolean isEvil()
    {
	return (align & EVIL) != 0;
    }
    
    public boolean isChaotic()
    {
	return (align & CHAOTIC) != 0;
    }
    
    @Override
    public String toString()
    {
	return str;
    }
}
