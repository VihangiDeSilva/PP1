import java.util.Scanner;
public class Character  extends CW2 {

    String characterType;
    Class characterClass;
    int methordType;
    String[] attribute = {"Level", "Str", "Dex", "Con", "Int", "Wis", "Cha", "HP"};       //declaration, instantiation and initialization attribute
    int[] inputVariable = new int[7];           //declaration and instantiation  inputVariable
    int[] bonusVariable = new int[7];          //declaration and instantiation  bonusVariable

    public Character(String characterType, int level) {
        super();
        this.characterType = characterType;
        this.methordType = methordType;
        generateStats(level);
    }
    int level;

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterName(String characterName) {

        this.characterType = characterName;
    }

    public Class getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(Class characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    Scanner sc = new Scanner(System.in);                // initialize the Scanner

    private int hitDice() {         // for calculate Hit Dice for all characters
        int output = 0;

        if (this.characterType.equals("Barbarian")) {
            output = (int) (Math.random() * 12 + 1);            // calculate Hit Dice for Barbarian
        } else if (this.characterType.equals("Bard")) {
            output = (int) (Math.random() * 8 + 1);             // calculate Hit Dice for Bard
        } else if (this.characterType.equals("Cleric")) {
            output = (int) (Math.random() * 8 + 1);             // calculate Hit Dice for Cleric
        } else if (this.characterType.equals("Druid")) {
            output = (int) (Math.random() * 8 + 1);             // calculate Hit Dice for Druid
        } else if (this.characterType.equals("Fighter")) {
            output = (int) (Math.random() * 10 + 1);            // calculate Hit Dice for Fighter
        } else if (this.characterType.equals("Monk")) {
            output = (int) (Math.random() * 8 + 1);             // calculate Hit Dice for Monk
        } else if (this.characterType.equals("Paladin")) {
            output = (int) (Math.random() * 10 + 1);             // calculate Hit Dice for paldin
        } else if (this.characterType.equals("Ranger")) {
            output = (int) (Math.random() * 10 + 1);            // calculate Hit Dice for Ranger
        } else if (this.characterType.equals("Rogue")) {
            output = (int) (Math.random() * 8 + 1);             // calculate Hit Dice for Rogue
        } else if (this.characterType.equals("Sorcerer")) {
            output = (int) (Math.random() * 6 + 1);             // calculate Hit Dice for Sorcerer
        } else if (this.characterType.equals("Warlock")) {
            output = (int) (Math.random() * 8 + 1);             // calculate Hit Dice for Warlock
        } else if (this.characterType.equals("Wizard")) {
            output = (int) (Math.random() * 6 + 1);             // calculate Hit Dice for Wizard
        }
        return output;
    }
    public void generateStats(int level) {
        boolean go = false;
        while (go) {
            for (int i = 1; i < 7; i++) {
                if (this.methordType == 1) {                     // If user select method 1, can entering the attributes directly
                    System.out.println("Enter integer to Str: ");
                    inputVariable[1] = sc.nextInt();      // getting an integer for Str
                    System.out.println("Enter integer to Dex: ");
                    inputVariable[2] = sc.nextInt();      // getting an integer for Dex
                    System.out.println("Enter integer to Con: ");
                    inputVariable[3] = sc.nextInt();      // getting an integer for Con
                    System.out.println("Enter integer to Int: ");
                    inputVariable[4] = sc.nextInt();      // getting an integer for Int
                    System.out.println("Enter integer to Wis: ");
                    inputVariable[5] = sc.nextInt();      // getting an integer for Wis
                    System.out.println("Enter integer to Cha: ");
                    inputVariable[6] = sc.nextInt(); // getting an integer for Cha

                    if (inputVariable[i] < 0) {
                        System.out.println("Invalid input");
                        System.exit(0);                        //terminating the program when user inputs minus values
                    }

                } else if (this.methordType == 2) {              // If user select method 2, can roll 4d6 and discard the lowest value
                    int diceA, diceB, diceC, diceD;
                    // Roll 4d6
                    diceA = (int) (Math.random() * 1000 % 6 + 1);
                    diceB = (int) (Math.random() * 1000 % 6 + 1);
                    diceC = (int) (Math.random() * 1000 % 6 + 1);
                    diceD = (int) (Math.random() * 1000 % 6 + 1);

                    // Find lowest dice
                    if ((diceA < diceB) && (diceA < diceC) && (diceA < diceD)) {
                        inputVariable[i] = diceB + diceC + diceD;               // assign total value to input variable
                    } else if ((diceC < diceA) && (diceC < diceB) && (diceC < diceD)) {
                        inputVariable[i] = diceA + diceB + diceD;               // assign total value to input variable
                    } else if ((diceB < diceA) && (diceB < diceD) && (diceB < diceC)) {
                        inputVariable[i] = diceA + diceC + diceD;               // assign total value to input variable
                    } else {
                        inputVariable[i] = diceA + diceB + diceC;               // assign total value to input variable
                    }

                } else if (this.methordType == 3) {
                    int output;                                     // If user select method 3, can Roll 4d6 and discard the lowest value and if
                    int diceA, diceB, diceC, diceD;                     // the attribute is 16 or higher, add the value of an additional 1d6
                    // Roll 4d6
                    diceA = (int) (Math.random() * 1000 % 6 + 1);
                    diceB = (int) (Math.random() * 1000 % 6 + 1);
                    diceC = (int) (Math.random() * 1000 % 6 + 1);
                    diceD = (int) (Math.random() * 1000 % 6 + 1);

                    // Find lowest dice
                    if ((diceA < diceB) && (diceA < diceC) && (diceA < diceD)) {
                        output = diceB + diceC + diceD;               // assign total value to input variable
                    } else if ((diceB < diceA) && (diceB < diceD) && (diceB < diceC)) {
                        output = diceA + diceC + diceD;               // assign total value to input variable
                    } else if ((diceC < diceA) && (diceC < diceB) && (diceC < diceD)) {
                        output = diceA + diceB + diceD;               // assign total value to input variable
                    } else {
                        output = diceA + diceB + diceC;               // assign total value to input variable
                    }

                    if (inputVariable[i] >= 16) {
                        inputVariable[i] = output + (int) (Math.random() * 1000 % 6 + 1);       //If input variable >= 16, add additional 1d6
                    } else {
                        inputVariable[i] = output;                                              // else input variable = output
                    }

                } else {                                                                     // If you select methord 4, can use "Methord IX"
                    int output;
                    int highest[] = new int[9];         // roll characters for 9d6
                    for (int j = 0; j < highest.length; j++) {
                        highest[j] = (int) (Math.random() * 1000 % 6 + 1);

                        int k, first, second, third;                        // find highest 3 values
                        third = first = second = Integer.MAX_VALUE;
                        for (k = 0; k < highest.length; k++) {
                            if (highest[k] > first) {
                                third = second;
                                second = first;
                                first = highest[k];
                            } else if (highest[k] > second) {
                                third = second;
                                second = highest[k];
                            } else if (highest[k] > third)
                                third = highest[k];
                        }
                        output = first + second + third;    // calculate the sum of highest 3 values

                        if (this.characterType.equals("Barbarian")) {
                            inputVariable[1] = output;        // asign sum to each character suitable varible
                        } else if (this.characterType.equals("Bard")) {
                            inputVariable[6] = output;
                        } else if (this.characterType.equals("Cleric")) {
                            inputVariable[5] = output;
                        } else if (this.characterType.equals("Druid")) {
                            inputVariable[2] = output;
                        } else if (this.characterType.equals("Fighter")) {
                            inputVariable[1] = output;
                        } else if (this.characterType.equals("Monk")) {
                            inputVariable[2] = output;
                        } else if (this.characterType.equals("Paladin")) {
                            inputVariable[1] = output;
                        } else if (this.characterType.equals("Ranger")) {
                            inputVariable[1] = output;
                        } else if (this.characterType.equals("Rogue")) {
                            inputVariable[2] = output;
                        } else if (this.characterType.equals("Sorcerer")) {
                            inputVariable[6] = output;
                        } else if (this.characterType.equals("Warlock")) {
                            inputVariable[6] = output;
                        } else if (this.characterType.equals("Wizard")) {
                            inputVariable[4] = output;
                        }
                    }
                    int output2;
                    int highest2[] = new int[8];         // roll characters for 8d6
                    for (int j = 0; j < highest2.length; j++) {
                        highest2[j] = (int) (Math.random() * 1000 % 6 + 1);

                        int k, first, second, third;                        // find highest 3 values
                        third = first = second = Integer.MAX_VALUE;
                        for (k = 0; k < highest2.length; k++) {
                            if (highest2[k] > first) {
                                third = second;
                                second = first;
                                first = highest2[k];
                            } else if (highest2[k] > second) {
                                third = second;
                                second = highest2[k];
                            } else if (highest2[k] > third)
                                third = highest2[k];
                        }
                        output2 = first + second + third;       // calculate the sum of highest 3 values

                        if (this.characterType.equals("Barbarian")) {
                            inputVariable[1] = output2;       // asign sum to each character suitable varible
                        } else if (this.characterType.equals("Bard")) {
                            inputVariable[2] = output2;
                        } else if (this.characterType.equals("Cleric")) {
                            inputVariable[3] = output2;
                        } else if (this.characterType.equals("Druid")) {
                            inputVariable[5] = output2;
                        } else if (this.characterType.equals("Fighter")) {
                            inputVariable[2] = output2;
                        } else if (this.characterType.equals("Monk")) {
                            inputVariable[5] = output2;
                        } else if (this.characterType.equals("Paladin")) {
                            inputVariable[2] = output2;
                        } else if (this.characterType.equals("Ranger")) {
                            inputVariable[5] = output2;
                        } else if (this.characterType.equals("Rogue")) {
                            inputVariable[4] = output2;
                        } else if (this.characterType.equals("Sorcerer")) {
                            inputVariable[3] = output2;
                        } else if (this.characterType.equals("Warlock")) {
                            inputVariable[3] = output2;
                        } else if (this.characterType.equals("Wizard")) {
                            inputVariable[3] = output2;
                        }
                    }
                    int output3;
                    int highest3[] = new int[7];         // roll characters for 7d6
                    for (int j = 0; j < highest3.length; j++) {
                        highest3[j] = (int) (Math.random() * 1000 % 6 + 1);

                        int k, first, second, third;                        // find highest 3 values
                        third = first = second = Integer.MAX_VALUE;
                        for (k = 0; k < highest3.length; k++) {
                            if (highest3[k] > first) {
                                third = second;
                                second = first;
                                first = highest3[k];
                            } else if (highest3[k] > second) {
                                third = second;
                                second = highest3[k];
                            } else if (highest3[k] > third)
                                third = highest3[k];
                        }
                        output3 = first + second + third;           // calculate the sum of highest 3 values

                        if (this.characterType.equals("Barbarian")) {
                            inputVariable[2] = output3;           // asign sum to each character suitable varible
                        } else if (this.characterType.equals("Bard")) {
                            inputVariable[3] = output3;
                        } else if (this.characterType.equals("Cleric")) {
                            inputVariable[1] = output3;
                        } else if (this.characterType.equals("Druid")) {
                            inputVariable[3] = output3;
                        } else if (this.characterType.equals("Fighter")) {
                            inputVariable[6] = output3;
                        } else if (this.characterType.equals("Monk")) {
                            inputVariable[3] = output3;
                        } else if (this.characterType.equals("Paladin")) {
                            inputVariable[6] = output3;
                        } else if (this.characterType.equals("Ranger")) {
                            inputVariable[3] = output3;
                        } else if (this.characterType.equals("Rogue")) {
                            inputVariable[3] = output3;
                        } else if (this.characterType.equals("Sorcerer")) {
                            inputVariable[2] = output3;
                        } else if (this.characterType.equals("Warlock")) {
                            inputVariable[2] = output3;
                        } else if (this.characterType.equals("Wizard")) {
                            inputVariable[2] = output3;
                        }
                    }
                    int output4;
                    int highest4[] = new int[6];         // roll characters for 6d6
                    for (int j = 0; j < highest4.length; j++) {
                        highest4[j] = (int) (Math.random() * 1000 % 6 + 1);

                        int k, first, second, third;                        // find highest 3 values
                        third = first = second = Integer.MAX_VALUE;
                        for (k = 0; k < highest4.length; k++) {
                            if (highest4[k] > first) {
                                third = second;
                                second = first;
                                first = highest4[k];
                            } else if (highest4[k] > second) {
                                third = second;
                                second = highest4[k];
                            } else if (highest4[k] > third)
                                third = highest4[k];
                        }
                        output4 = first + second + third;       // calculate the sum of highest 3 values

                        if (this.characterType.equals("Barbarian")) {
                            inputVariable[5] = output4;           // asign sum to each character suitable varible
                        } else if (this.characterType.equals("Bard")) {
                            inputVariable[5] = output4;
                        } else if (this.characterType.equals("Cleric")) {
                            inputVariable[2] = output4;
                        } else if (this.characterType.equals("Druid")) {
                            inputVariable[4] = output4;
                        } else if (this.characterType.equals("Fighter")) {
                            inputVariable[3] = output4;
                        } else if (this.characterType.equals("Monk")) {
                            inputVariable[1] = output4;
                        } else if (this.characterType.equals("Paladin")) {
                            inputVariable[3] = output4;
                        } else if (this.characterType.equals("Ranger")) {
                            inputVariable[2] = output4;
                        } else if (this.characterType.equals("Rogue")) {
                            inputVariable[6] = output4;
                        } else if (this.characterType.equals("Sorcerer")) {
                            inputVariable[5] = output4;
                        } else if (this.characterType.equals("Warlock")) {
                            inputVariable[5] = output4;
                        } else if (this.characterType.equals("Wizard")) {
                            inputVariable[5] = output4;
                        }
                    }
                    int output5;
                    int highest5[] = new int[5];         // roll characters for 5d6
                    for (int j = 0; j < highest5.length; j++) {
                        highest5[j] = (int) (Math.random() * 1000 % 6 + 1);

                        int k, first, second, third;                        // find highest 3 values
                        third = first = second = Integer.MAX_VALUE;
                        for (k = 0; k < highest5.length; k++) {
                            if (highest5[k] > first) {
                                third = second;
                                second = first;
                                first = highest5[k];
                            } else if (highest5[k] > second) {
                                third = second;
                                second = highest5[k];
                            } else if (highest5[k] > third)
                                third = highest5[k];
                        }
                        output5 = first + second + third;       // calculate the sum of highest 3 values

                        if (this.characterType.equals("Barbarian")) {
                            inputVariable[6] = output5;           // asign sum to each character suitable varible
                        } else if (this.characterType.equals("Bard")) {
                            inputVariable[1] = output5;
                        } else if (this.characterType.equals("Cleric")) {
                            inputVariable[6] = output5;
                        } else if (this.characterType.equals("Druid")) {
                            inputVariable[6] = output5;
                        } else if (this.characterType.equals("Fighter")) {
                            inputVariable[5] = output5;
                        } else if (this.characterType.equals("Monk")) {
                            inputVariable[4] = output5;
                        } else if (this.characterType.equals("Paladin")) {
                            inputVariable[5] = output5;
                        } else if (this.characterType.equals("Ranger")) {
                            inputVariable[4] = output5;
                        } else if (this.characterType.equals("Rogue")) {
                            inputVariable[5] = output5;
                        } else if (this.characterType.equals("Sorcerer")) {
                            inputVariable[1] = output5;
                        } else if (this.characterType.equals("Warlock")) {
                            inputVariable[1] = output5;
                        } else if (this.characterType.equals("Wizard")) {
                            inputVariable[1] = output5;
                        }
                    }
                    int output6;
                    int highest6[] = new int[4];         // roll characters for 4d6
                    for (int j = 0; j < highest6.length; j++) {
                        highest6[j] = (int) (Math.random() * 1000 % 6 + 1);

                        int k, first, second, third;                    // find highest 3 values
                        third = first = second = Integer.MAX_VALUE;
                        for (k = 0; k < highest6.length; k++) {
                            if (highest6[k] > first) {
                                third = second;
                                second = first;
                                first = highest6[k];
                            } else if (highest6[k] > second) {
                                third = second;
                                second = highest6[k];
                            } else if (highest6[k] > third)
                                third = highest6[k];
                        }
                        output6 = first + second + third;           // calculate the sum of highest 3 values

                        if (this.characterType.equals("Barbarian")) {
                            inputVariable[4] = output6;           // asign sum to each character suitable varible
                        } else if (this.characterType.equals("Bard")) {
                            inputVariable[4] = output6;
                        } else if (this.characterType.equals("Cleric")) {
                            inputVariable[4] = output6;
                        } else if (this.characterType.equals("Druid")) {
                            inputVariable[1] = output6;
                        } else if (this.characterType.equals("Fighter")) {
                            inputVariable[4] = output6;
                        } else if (this.characterType.equals("Monk")) {
                            inputVariable[6] = output6;
                        } else if (this.characterType.equals("Paladin")) {
                            inputVariable[4] = output6;
                        } else if (this.characterType.equals("Ranger")) {
                            inputVariable[6] = output6;
                        } else if (this.characterType.equals("Rogue")) {
                            inputVariable[1] = output6;
                        } else if (this.characterType.equals("Sorcerer")) {
                            inputVariable[4] = output6;
                        } else if (this.characterType.equals("Warlock")) {
                            inputVariable[4] = output6;
                        } else if (this.characterType.equals("Wizard")) {
                            inputVariable[4] = output6;
                        }
                    }
                }
            }
            public int generateBonus(int total){
                for (int i = 0; i < 6; i++) {               // calculating bonus variables
                    int bonus = 0;
                    if (inputVariable[i + 1] == 10) {
                        bonus = 0;
                    } else if (inputVariable[i + 1] > 10) {
                        bonus = (inputVariable[i + 1] - 10) / 2;
                    } else if (inputVariable[i + 1] < 10) {
                        if (inputVariable[i + 1] % 2 == 0) {
                            bonus = -1 * (inputVariable[i + 1] / 2);
                        } else {
                            bonus = -1 * ((inputVariable[i + 1] + 1) / 2);
                        }
                    }
                    bonusVariable[i] = bonus;
                }
            }

            bonusVariable[6] = 0;

            for (int i = 0; i < inputVariable[0]; i++) {      // calculate Hit points
                bonusVariable[6] += this.hitDice() + bonusVariable[2];
            }

            System.out.print("Level : " + String.valueOf(inputVariable[0]) + " ");

            for (int i = 0; i < 6; i++) {       // for printing input and bonus variables before reroll as a one block of six
                if (bonusVariable[i] <= 0) {
                    System.out.print(attribute[i + 1] + " : " + String.valueOf(inputVariable[i + 1]) + " " + String.valueOf(bonusVariable[i]) + " ");
                } else {
                    System.out.print(attribute[i + 1] + " : " + String.valueOf(inputVariable[i + 1]) + " +" + String.valueOf(bonusVariable[i]) + " ");
                }
            }
            public int calculateHitPoints() {
                for (int i = 0; i < inputVariable[0]; i++) {      // calculate Hit points
                    bonusVariable[6] += this.hitDice() + bonusVariable[2];
                }

            }

            public int calculateSkillPoints() {
                int intBonus =  this.generateBonus(characterClass.getInt_Dice());
                //The first level should get 4 times the number of skill-points but only the first level
                if(level ==1){
                    return this.characterClass.getSkill_Points()*4;
                }else{
                    //If the Int bonus is negative this should be a minimum of 1 skill-point for each level
                    int points = (intBonus >= 0? this.characterClass.getSkill_Points()+intBonus : 1)*this.level+3;
                    //Each skill should have a maximum number of skill-points allocated to it of Level + 3.
                    return (points);
                }

            }

            public int  calculateBAB(){
                if(this.getCharacterType().equals("Barbarian") || this.getCharacterType().equals("Fighter")){
                    return level;
                } else if (this.getCharacterType().equals("Ranger") || this.getCharacterType().equals("Bard")){
                    return level*3/4;
                } else {
                    return level/2;
                }
            }

            public int  calculateCombat(){
                return calculateBAB()+this.generateBonus(characterClass.getStr_Dice());
            }

            public int  calculateDamage(){
                return this.generateBonus(characterClass.getStr_Dice());
            }



            System.out.print(attribute[7] + " : " + String.valueOf(bonusVariable[6]) + " ");
            System.out.println();
            System.out.print("Do you want to re-roll the stats ? (0 - No / 1 - Yes) : ");   // asking from user wants to re roll

            int goValue = sc.nextInt();

            if (goValue == 0) {
                go = false;
            } else if (goValue == 1) {
                go = true;
            }
        }
    }

    public void printStat() {
        System.out.println("Level : " + String.valueOf(inputVariable[0]));      // for printing level

        for (int i = 0; i < 6; i++) {           // for printing input and bonus variables
            if (bonusVariable[i] <= 0) {
                System.out.println(attribute[i + 1] + " : [" + String.valueOf(inputVariable[i + 1]) + "] [" + String.valueOf(bonusVariable[i]) + "]");
            } else {
                System.out.println(attribute[i + 1] + " : [" + String.valueOf(inputVariable[i + 1]) + "] [+" + String.valueOf(bonusVariable[i]) + "]");
            }
        }

        System.out.println(attribute[7] + " : [" + String.valueOf(bonusVariable[6]) + "]");     // for printing Hit Points
    }

}













