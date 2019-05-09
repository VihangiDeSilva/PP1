import java.util.Scanner;
public class Workshop04 {
    public static void main(String[] args){

            Scanner sc = new Scanner(System.in);    // initialize the Scanner

            String characterType;
            int level;
                //for print character names
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

            System.out.print("Level : ");       // getting integer to level
            level = sc.nextInt();

            Character obj = new Character(characterType, level);    // creating object for print the output
            obj.printStats();
        }
    }





