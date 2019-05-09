public class Class {

    private String name;
    private int hitdice, str_Dice, dex_Dice, con_Dice, int_Dice, wis_Dice, cha_Dice, skill_Points;
    private double BAB_Type;
    private Class next_Class;

    public Class(String name, int hitdice, int skill_Points) {
        super();
        this.name = name;
        this.hitdice = hitdice;
        this.skill_Points = skill_Points;

    }
    public String getName() {       //Creating getter and setter
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHitdice() {
        return hitdice;
    }
    public void setHitdice(int hitdice) {
        this.hitdice = hitdice;
    }
    public int getStr_Dice() {
        return str_Dice;
    }
    public void setStr_Dice(int str_Dice) {
        this.str_Dice = str_Dice;
    }
    public int getDex_Dice() {
        return dex_Dice;
    }
    public void setDex_Dice(int dex_Dice) {
        this.dex_Dice = dex_Dice;
    }
    public int getCon_Dice() {
        return con_Dice;
    }
    public void setCon_Dice(int con_Dice) {
        this.con_Dice = con_Dice;
    }
    public int getInt_Dice() {
        return int_Dice;
    }
    public void setInt_Dice(int int_Dice) {
        this.int_Dice = int_Dice;
    }
    public int getWis_Dice() {
        return wis_Dice;
    }
    public void setWis_Dice(int wis_Dice) {
        this.wis_Dice = wis_Dice;
    }
    public int getCha_Dice() {
        return cha_Dice;
    }
    public void setCha_Dice(int cha_Dice) {
        this.cha_Dice = cha_Dice;
    }
    public int getSkill_Points() {
        return skill_Points;
    }
    public void setSkill_Points(int skill_Points) {
        this.skill_Points = skill_Points;
    }
    public double getBAB_Type() {
        return BAB_Type;
    }
    public Class getNext_Class() {
        return next_Class;
    }
    public void setNext_Class(Class next_Class) {
        this.next_Class = next_Class;
    }


}


