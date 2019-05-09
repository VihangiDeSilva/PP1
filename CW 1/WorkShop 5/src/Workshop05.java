import java.util.Scanner;
public class Workshop05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // initialize the Scanner
        String characterType;
        int level;
            // for printing character names
        System.out.println("Select a character given below \n 1.Barbarian \n 2.Bard \n 3.Cleric \n 4.Druid \n 5.Fighter \n 6.Monk \n 7.Paladin \n 8.Ranger \n 9.Rogue \n 10.Sorcerer \n 11.Warlock \n 12.Wizard");

        System.out.print("Character Name : ");      // getting character name from user
        characterType = sc.next();

        boolean go = true;
        while(go) {
            // for checking character name if it is a given character or not
            if((characterType.equals("Barbarian") || characterType.equals("Bard")) || (characterType.equals("Cleric") || characterType.equals("Druid")) ||
                    (characterType.equals("Fighter")|| characterType.equals("Monk")) || (characterType.equals("Paladin") || characterType.equals("Ranger")) ||
                    (characterType.equals("Rogue")|| characterType.equals("Sorcerer")) || (characterType.equals("Warlock")|| characterType.equals("Wizard")) )
            {
                go = false;
            } else{
                go = true;
            }
        }
        System.out.print("Level : ");       // getting integer for level
        level = sc.nextInt();

                // to create character skill list
        Skill skillA = new Skill("Acrobatics", "good", "Acrobatics is a skill linked to Dexterity", 7, 5, null);
        Skill skillB = new Skill("Arcana", "good", "Arcana is a knowledge type skill linked to Intelligence", 6, 8, null);
        Skill skillC = new Skill("Athleticss", "good", "Athletics is linked to Strength", 2, 9, null);
        Skill skillD = new Skill("Bluff", "good", "Bluff is linked with Charisma", 4, 9, null);
        Skill skillE = new Skill("Diplomacy", "good", "Diplomacy is linked with Charisma", 7, 1, null);
        Skill skillF = new Skill("Dungeoneering", "good", "Dungeoneering is a knowledge type skill linked to Wisdom", 0, 9, null);
        Skill skillG = new Skill("Endurance", "good", "Endurance is linked to Constitution", 7, 9, null);
        Skill skillH = new Skill("Heal", "good", "Heal is linked to Wisdom", 7, 0, null);
        Skill skillI = new Skill("History", "good", "History is linked with Intelligence", 78, 14, null);
        Skill skillJ = new Skill("Insight", "good", "Insight is linked to Wisdom", 64, 10, null);
        Skill skillK = new Skill("Intimidate", "good", "Intimidate is a Charisma-based skill", 41, 1, null);
        Skill skillL = new Skill("Nature", "good", "Nature is a knowledge type skill linked to Intelligence", 7, 6, null);
        Skill skillM = new Skill("Perception", "good", "Perception is linked to Wisdom.", 4, 12, null);
        Skill skillN = new Skill("Religion", "good", "Religion is a knowledge type skill linked to Intelligence", 12, 1, null);
        Skill skillO = new Skill("Stealth", "good", "This skill is linked to Dexterity", 5, 87, null);
        Skill skillP = new Skill("Streetwise", "good", "This skill is linked to Charisma", 4, 51, null);
        Skill skillQ = new Skill("Thievery", "good", "This skill is linked to Dexterity", 64, 3, null);

        skillA.setNext_Skill(skillB);
        skillB.setNext_Skill(skillC);       // to call the next skill
        skillC.setNext_Skill(skillD);
        skillD.setNext_Skill(skillE);
        skillE.setNext_Skill(skillF);
        skillF.setNext_Skill(skillG);
        skillG.setNext_Skill(skillH);
        skillH.setNext_Skill(skillI);
        skillI.setNext_Skill(skillJ);
        skillJ.setNext_Skill(skillK);
        skillK.setNext_Skill(skillL);
        skillL.setNext_Skill(skillM);
        skillM.setNext_Skill(skillN);
        skillN.setNext_Skill(skillO);
        skillO.setNext_Skill(skillP);
        skillP.setNext_Skill(skillQ);
        skillQ.setNext_Skill(null);

        Skill current = skillA;
        while (current != null) {
            current.print();
            current = current.getNext_Skill();
        }
        Character obj = new Character(characterType, level);       // creating object for print the output
        obj.printStats();
    }

        private static Skill getNext_Skill() {

        return null;
            }
        }












