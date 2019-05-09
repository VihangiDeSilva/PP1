public class Skill {

    private String characterName;
    private String optional;
    private String shortDesc;
    private int statAffinity;
    private int ranks;
    private Skill next_Skill;

    public Skill( String characterName, String optional, String shortDesc, int statAffinity, int ranks, Skill next_Skill) {
        super();
        this.characterName = characterName;
        this.optional = optional;
        this.shortDesc = shortDesc;
        this.statAffinity = statAffinity;
        this.ranks = ranks;
        this.next_Skill = next_Skill;
    }


    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public int getStatAffinity() {
        return statAffinity;
    }

    public void setStatAffinity(int statAffinity) {
        this.statAffinity = statAffinity;
    }

    public int getRanks() {
        return ranks;
    }

    public void setRanks(int ranks) {
        this.ranks = ranks;
    }

    public Skill getNext_Skill() {
        return next_Skill;
    }

    public void setNext_Skill(Skill next_Skill) {
        this.next_Skill = next_Skill;
    }

    public void print() {           // for printing character skills
        System.out.println("The Character name is:" + characterName);
        System.out.println("Optional:" + optional);
        System.out.println("The Short description:" + shortDesc);
        System.out.println("The statAffinity:" + statAffinity);
        System.out.println("The ranks:" + ranks);
    }
}

