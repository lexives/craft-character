package models;

public class Character
{
	private static int getModifier(byte num)
	{
		return num / 2 - 5;
	}
	
	private String name;
	private Alignment align;
	private Player player;
	private String deity;
	private String homeland;
	private Race race;
	private Size size;
	private String gender;
	private int age;
	private String height;
	private String weight;
	private String hair;
	private String eyes;
	
	private Collection<Level> levels;
	
	private byte str = 10; // Strength Score
	private byte dex = 10; // Dexterity Score
	private byte con = 10; // Consitution Score
	private byte inte = 10; // Inteligence Score (Four letters because, "int," is a key word)
	private byte wis = 10; // Wisdom Score
	private byte cha = 10; // Charisma Score
	
	private transient byte initMod = 0; // Initative Modifier
	private transient byte bab = 0; // Base Attack Bonus
	private transient byte ac = 10; // Armor Class
	private transient byte touch = 10; // Touch Armor Class
	private transient byte flatFooted = 10; // Flat Footed Armor Class
	private transient byte dr = 0; // Damage Reduction
	private transient byte cmb = 0; // Combat Manuver Bonus
	private transient byte cmd = 10; // Combat Manuver Defense
	private byte lethDmg = 0; // Lethal Damage
	private byte nlethDmg = 0; // Nonlethal Damage
	private byte hitPoints; // Maximum Hit Points
	
	private transient byte landSpeed = 30; // Land Speed in feet/turn
	private transient byte flySpeed = 0; // Flying Speed
	private transient byte swimSpeed = 0; // Swiming Speed
	private transient byte borrowSpeed = 0; // Burrowing Speed
	
	private transient byte splRes = 0; // Spell Resistance
	
	private transient byte fort; // Fortitude Save Base
	private transient byte refl; // Reflex Save Base
	private transient byte will; // Will Save Base
	
	private byte acrobaticsRnk = 0;
	private byte appraiseRnk = 0;
	private byte bluffRnk = 0;
	private byte climbRnk = 0;
	private Map<String, Byte> craftRnk;
	private byte diplomacyRnk;
	private byte disableDeviceRnk = 0;
	private byte disguiseRnk = 0;
	private byte escapeArtistRnk = 0;
	private byte flyRnk = 0;
	private byte handleAnimalRnk = 0;
	private byte healRnk = 0;
	private byte intimidateRnk = 0;
	private Map<String, Byte> knowledgeRnk;
	private byte linguisticsRnk = 0;
	private byte perceptionRnk = 0;
	private Map<String, Byte> professionRnk;
	private Map<String, Byte> preformRnk;
	private byte rideRnk = 0;
	private byte senseMotiveRnk = 0;
	private byte slightOfHandRnk = 0;
	private byte spellcraftRnk = 0;
	private byte stealthRnk = 0;
	private byte survivalRnk = 0;
	private byte swimRnk = 0;
	private byte useMagicDeviceRnk = 0;
	
	private Collection<> inventory;
	
	private Collection<> states;
	
	private Collection<Feat> feats;
	
	private Collection<Attack> attacks;
	
	private Collection<String> languages;
	
	// --- Strength --------------------------------------------------
	public void setStr(int num)
	{
		str = num;
	}
	
	public int getStr()
	{
		return str;
	}
	
	public int getStrMod()
	{
		return getModifier(str);
	}
	
	// --- Dexterity -------------------------------------------------
	public void setDex(int num)
	{
		dex = num;
	}
	
	public int getDex()
	{
		return dex;
	}
	
	public int getDexMod()
	{
		return getModifier(dex);
	}
	
	// --- Consitution -----------------------------------------------
	public void setCon(int num)
	{
		con = num;
	}
	
	public int getCon()
	{
		return con;
	}
	
	public int getConMod()
	{
		return getModifier(con);
	}
	
	// --- Inteligence -----------------------------------------------
	public void setInt(int num)
	{
		inte = num;
	}
	
	public int getInt()
	{
		return inte;
	}
	
	public int getIntMod()
	{
		return getModifier(inte);
	}
	
	// --- Wisdom ----------------------------------------------------
	public void setWis(int num)
	{
		wis = num;
	}
	
	public int getWis()
	{
		return wis;
	}
	
	public int getWisMod()
	{
		return getModifier(wis);
	}
	
	// --- Charisma --------------------------------------------------
	public void setCha(int num)
	{
		cha = num;
	}
	
	public int getCha()
	{
		return cha;
	}
	
	public int getChaMod()
	{
		return getModifier(cha);
	}
}