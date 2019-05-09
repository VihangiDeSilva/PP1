import java.util.Scanner;
public class CW2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);                // initialize the Scanner

        String characterType;
        int methordType;
        int level;
        boolean go = true;
        boolean check = true;
        boolean checkM = true;

        System.out.print("Level : ");       // getting integer for level
        level = sc.nextInt();

        while (check){
            if (level <= 0 || level >17) {
                System.out.println("Invalid input for level \n Re enter integer to level:");    //if user enter invalid input for level,
                level = sc.nextInt();                                                       // prompt a message to user re enter value for level
            } else
                check = false;
        }

        System.out.println("Select a character given below : \n 1.Barbarian \n 2.Bard \n 3.Cleric \n 4.Druid \n 5.Fighter \n " +       // for display character list for user
                "6.Monk \n " + "7.Paladin \n 8.Ranger \n 9.Rogue \n 10.Sorcerer \n 11.Warlock \n 12.Wizard");

        String characterSkills[] = new String[]{"Acrobatics", "Arcana", "Athletics", "Bluff", "Diplomacy", "Dungeoneering",          //stores the character skills in an array
                "Endurance", "Heal", "History", "Insight", "Intimidate", "Nature", "Perception", "Religion", "Stealth", "Streetwise", "Thievery"};

        System.out.print("Character Name : ");          // getting character name from user
        characterType = sc.next();

        while (go) {
            if ((characterType.equals("Barbarian") || characterType.equals("Bard")) || (characterType.equals("Cleric") || characterType.equals("Druid")) ||
                    (characterType.equals("Fighter") || characterType.equals("Monk")) || (characterType.equals("Paladin") || characterType.equals("Ranger")) ||
                    (characterType.equals("Rogue") || characterType.equals("Sorcerer")) || (characterType.equals("Warlock") || characterType.equals("Wizard"))) {
                go = false;
            } else {
                System.out.print("Invalid character input \n re enter name for character:");      // getting  new character name from user
                characterType = sc.next();
            }
        }


        System.out.println("Select methord from here,");       // getting method type from user
        System.out.println("If you want,\n 1.Entering the attributes directly (enter 1) \n 2.Roll 4d6 and discard the lowest value (enter 2) \n " +
                "3.Roll 4d6 and discard the lowest value and if the attribute is 16 or higher, add the value of an additional 1d6 (enter 3) \n 4.Roll Method IX(enter 4)");
        System.out.print("Method Number :");
        methordType = sc.nextInt();

        while (checkM) {
            if (methordType <= 0 || methordType >= 5) {
                System.out.println("Invalid input for Method Type \n Re enter integer to Method Type:");    //if user enter invalid input for Method Type,
                methordType = sc.nextInt();                                                       // prompt a message to user re enter value for Method Type
            } else
                checkM = false;
        }


        Character object2 = new Character(characterType, level);
        object2.printStat();

        System.out.println("The skills :");
        int n = 1;
        for(int j=0; j<characterSkills.length;j++) {
            System.out.println(n + ". " + characterSkills[j]);         //displays the character skills for the user to select from
            System.out.println();
            n++;
        }

        CW2.selectSkills(Character);
        System.out.println("Base attack bonus : " + Character.calculateBAB());      //Displaying stats
        System.out.println("Skill Points :" +Character.calculateSkillPoints());
        System.out.println("Combat : " + Character.calculateCombat());
        System.out.println("Damage : " + Character.calculateDamage());

                System.out.println("---End of calculation---");            //Message to be displayed when the code terminates
            }
    private static void selectSkills(Character character) {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        Skill selectedFirstSkill = null;
        Skill selectedCurrentSkill = null;
        System.out.println("Enter the numbers of the selected Skills"); //Prompt for skills from user

        Skill displayFirstSkill= new GetSkillsAndClasses().getSkillsFromFile();
        Skill displayCurrentSkill= null;
        i=1;

        do {
            if(displayCurrentSkill==null){
                displayCurrentSkill= displayFirstSkill;
            }else{
                displayCurrentSkill= displayCurrentSkill.getNextSkill();
            }
            System.out.println("(" + i + ") " + displayCurrentSkill.getName());

            i++;
        } while (displayCurrentSkill.getNextSkill() != null);


        displayCurrentSkill = displayFirstSkill;
        i = 1;
        String[] selectedSkills= null;
        boolean error = false;

        do {
            error= false;
            System.out.println("\nPlease select " + character.getLevel() + " Skills");
            String selection = sc.next();
            selectedSkills = selection.split(",");
            if (selectedSkills.length != character.getLevel()) {
                System.out.println("Invalid input");
                error=true;
            }
        }while(error);

        System.out.println("\nSkills and Stats of " + character.CharacterClass.getName());

        while (displayCurrentSkill != null) {
            for (String index : selectedSkills) {
                int indexInt = Integer.parseInt(index);
                if (indexInt == i) {
                    System.out.println(
                            "Name = " + displayCurrentSkill.getName()+
                                    ", Optional = " + displayCurrentSkill.getOptional() +
                                    ", Short Description = " + displayCurrentSkill.getShortDescription() +
                                    ", Stat affinity = " + displayCurrentSkill.getStatAffinity() + ", Rank = " + displayCurrentSkill.getRanks() );

                    break;
                }
            }
            displayCurrentSkill = displayCurrentSkill.getNextSkill();
            i++;
        }

    }

    private static void rollDices(Character character) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Enter directly method");  //Selection of methods to generate attributes
        System.out.println("2.Roll Dice 4d6 method1");
        System.out.println("3.Roll Dice 4d6 method2");
        System.out.println("4.Roll Dice method IX");
        System.out.println("Choose a method from 1,2,3 or 4"); //Prompt for one method out of four

        int option = sc.nextInt();
        System.out.println("\n\nCalculating Attributes");
        switch (option) {
            case 1:
                character.enterDirectly();
                break;
            case 2:
                character.method2();
                break;
            case 3:
                character.method3();
                break;
            case 4:
                character.method4();
                break;

        }

    }

    private static Character generateCharacter() {
        Scanner sc = new Scanner(System.in);
        // Reading input data
        System.out.println("Enter Level value:");
        int level = sc.nextInt();
        if (level <= 0 || level > 17) {
            System.out.println("Invalid input");
            System.exit(0); // Terminating if the input is equal or less than
            // zero or greater than 17
        }


        Class classes = new GetSkillsAndClasses().getClassesFromFile();
        Class currentDisplayClass = classes;
        int i = 1;
        while (currentDisplayClass != null) {
            System.out.println("(" + i + ") " + currentDisplayClass.getName()); // Displaying character classes
            currentDisplayClass = currentDisplayClass.getNext_Class();
            i++;
        }
        int maxIndex = i-1;
        int selectedIndex =0;
        Character character = new Character(); //Creating character
        do{
            System.out.println("Enter the number of the Character class");
            selectedIndex= sc.nextInt();

            i = 1; // reset index to iterate again from first class
            currentDisplayClass = classes;

            while (currentDisplayClass != null) {
                if (i == selectedIndex) {
                    character.characterClass = currentDisplayClass;
                    currentDisplayClass.setNext_Class(null);
                    break;
                }
                currentDisplayClass = currentDisplayClass.getNext_Class();
                i++;
            }

        }while(selectedIndex> maxIndex);

        System.out.println(""+character.getCharacterClass().getName());

        System.out.println("Enter a number between 1-12 to choose your Character ");
        int name = sc.nextInt();
        if(name < 1 || name > 12){
            System.out.println("Invalid input"); //Terminating if the input is not in between 1-12
            System.exit(0);
        }
        character.characterName = new Integer(name).toString();
        character.level = level;
        return character;
    }


    private static Skill next_Skill () {
            return null;
        }
    }










