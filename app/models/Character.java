package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Character extends DBObject
{
	private static int getModifier(byte num)
	{
		return num / 2 - 5;
	}

	// *** Character Info ********************************************
	private String name = "";
	private Alignment align = Alignment.TRUE_NEUTRAL;
	// private Player player;
	private String deity = "";
	private String homeland = "";
	// private Race race;
	private Size size = Size.MEDIUM;
	private String gender = "";
	private int age;
	private String height;
	private String weight;
	private String hair = "";
	private String eyes = "";

	// *** Ability Scores ********************************************
	private byte str = 10; //	Strength Score
	private byte dex = 10; //	Dexterity Score
	private byte con = 10; //	Constitution Score
	private byte inte = 10; //	Intelligence Score (Four letters because, "int," is a key word)
	private byte wis = 10; //	Wisdom Score
	private byte cha = 10; //	Charisma Score

	private List<Level> levels = new LinkedList<>();
	
	private Set<Feat> feats = new HashSet<>();
	
	private final transient Map<String, List<Modifier>> modifiers = new HashMap<>();
	
	// private transient Byte dr = 0; //	Damage Reduction
	private byte lethDmg = 0; //		Lethal Damage
	private byte nlethDmg = 0; //		Nonlethal Damage
	private byte hitPoints; //		Maximum Hit Points
	
	private transient byte landSpeed = 30; // Land Speed in feet/turn
	private transient byte flySpeed = 0; //	Flying Speed
	private transient byte swimSpeed = 0; // Swimming Speed
	private transient byte burrowSpeed = 0; // Burrowing Speed
	
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
	
	/*
	private Collection<> iacnventory;
	
	private Collection<> states;
	
	private Collection<Feat> feats;
	
	private Collection<Attack> attacks;
	*/
	
	private List<String> languages;
	
	// *** Ability Scores ********************************************
	
	// --- Strength --------------------------------------------------
	public void setStr(int num)
	{
	    str = (byte) num;
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
	    dex = (byte) num;
	}
	
	public int getDex()
	{
	    return dex;
	}
	
	public int getDexMod()
	{
	    return getModifier(dex);
	}
	
	// --- Constitution -----------------------------------------------
	public void setCon(int num)
	{
	    con = (byte) num;
	}
	
	public int getCon()
	{
	    return con;
	}
	
	public int getConMod()
	{
	    return getModifier(con);
	}
	
	// --- Intelligence -----------------------------------------------
	public void setInt(int num)
	{
	    inte = (byte) num;
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
	    wis = (byte) num;
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
	    cha = (byte) num;
	}
	
	public int getCha()
	{
	    return cha;
	}
	
	public int getChaMod()
	{
	    return getModifier(cha);
	}

	// *** Character Info ********************************************
	
	// --- Name ------------------------------------------------------
	public void setName(String name)
	{
	    this.name = name;
	}
	
	public String getName()
	{
	    return name;
	}

	// --- Alignment -------------------------------------------------
	/*public void setAlignment(String align)
	{
	    align = getAlignment(align);
	}*/
	
	public Alignment getAlignment()
	{
	    return align;
	}

	// --- Deity -----------------------------------------------------
	public String getDeity()
	{
	    return deity;
	}
	
	public void setDeity(String deity)
	{
	    this.deity = deity;
	}

	// --- Homeland --------------------------------------------------
	public String getHomeland()
	{
	    return homeland;
	}
	
	public void setHomeland(String homeland)
	{
	    this.homeland = homeland;
	}
	
	// --- Size-------------------------------------------------------
	public Size getSize() {
		return size;
	}
	
	public Modifier getSizeMod() {
		return size.getMod();
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	

	// --- Gender ----------------------------------------------------
	public String getGender()
	{
	    return gender;
	}
	
	public void setGender(String gender)
	{
	    this.gender = gender;
	}

	// --- Age -------------------------------------------------------
	public int getAge()
	{
	    return age;
	}
	
	public void setAge(int age)
	{
	    this.age = age;
	}

	// --- Hair ------------------------------------------------------
	public String getHair()
	{
	    return hair;
	}
	
	public void setHair(String hair)
	{
	    this.hair = hair;
	}

	// --- Eyes ------------------------------------------------------
	public String getEyes()
	{
	    return eyes;
	}
	
	public void setEyes(String eyes)
	{
	    this.eyes = eyes;
	}

	// --- Languages -------------------------------------------------
	public List<String> getLanguages()
	{
	    return languages;
	}
	
	public void setLanguages(List<String> languages)
	{
	    this.languages = languages;
	}

	// *** Saving Throws *********************************************
	
	// --- Fortitude -------------------------------------------------
	public int getFortSave()
	{
	    int fort = 0;
	    for (Level l : levels)
	    {
		fort += l.getFort();
	    }
	    return fort;
	}
	
	// --- Reflex ----------------------------------------------------
	public int getReflexSave()
	{
	    int reflex = 0;
	    for (Level l : levels)
	    {
		reflex += l.getReflex();
	    }
	    return reflex;
	}
	
	// --- Will ------------------------------------------------------
	public int getWillSave()
	{
	    int will = 0;
	    for (Level l : levels)
	    {
		will += l.getWill();
	    }
	    return will;
	}

	// *** Combat ****************************************************
	
	// --- Initiative ------------------------------------------------
	public int getInitative()
	{
	    return getDexMod();
	}
	
	// --- Base Attack Bonus -----------------------------------------
	public int getBaseAttackBonus()
	{
	    int bab = 0;
	    for (Level l : levels)
	    {
		bab += l.getBAB();
	    }
	    return bab;
	}

	// --- Combat Maneuver Bonus -------------------------------------
	public int getCMB()
	{
	    return getStrMod() + getBaseAttackBonus() - size.getMod().getValue();
	}

	// --- Armor Class -----------------------------------------------
	public int getAC()
	{
	    return 10 + getDexMod() + size.getMod().getValue();
	}

	// --- Touch Armor Class ------------------------------------------
	public int getTouch()
	{
	    return 10 + getDexMod() + size.getMod().getValue();
	}

	// --- Flat Footed Armor Class ------------------------------------
	public int getFlatFooted()
	{
	    return 10 + size.getMod().getValue();
	}

	// --- Combat Maneuver Defense -----------------------------------
	public int getCMD()
	{
	    return 10 + getStrMod() + getDexMod() + getBaseAttackBonus() - size.getMod().getValue();
	}
	// *** Feats *****************************************************

	public synchronized void addFeat(Feat f)
	{
	    if (feats.add(f))
	    {
		f.apply(this);
	    }
	}
	
	@JsonProperty("feats")
	private void setFeats(List<Feat> fs)
	{
	    fs.forEach(f -> addFeat(f));
	}

	@JsonProperty("feats")
	public synchronized Set<Feat> getFeats()
	{
	    return feats;
	}
	
	// *** Modifiers *************************************************
	
	public void addModifier(String skill, Modifier m)
	{
	    if (!modifiers.containsKey(skill))
	    {
		modifiers.put(skill, new LinkedList<>());
	    }
	    modifiers.get(skill).add(m);
	}
	
	public synchronized List<Modifier> getModifiers(String skill)
	{
	    if (!modifiers.containsKey(skill))
	    {
		modifiers.put(skill, new LinkedList<>());
	    }
	    return modifiers.get(skill);
	}
	
	// *** Skills ****************************************************

	// --- Acrobatics ------------------------------------------------
	public int getAcrobaticsRank()
	{
	    return acrobaticsRnk;
	}
	
	public void setAcrobaticsRank(int rnk)
	{
	    acrobaticsRnk = (byte) rnk;
	}
	
	public int getAcrobatics()
	{
	    int sum = 0;
	    for (Modifier m : getModifiers("acrobatics"))
	    {
		sum += m.getValue();
	    }
	    return acrobaticsRnk + getDexMod() + sum;
	}
}