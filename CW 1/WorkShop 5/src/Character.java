import java.util.Scanner;
public class Character  extends Workshop05 {

        private String characterType;
        private String[] attribute = {"Level", "Str", "Dex", "Con", "Int", "Wis", "Cha", "HP"};       //declaration, instantiation and initialization attribute
        private int[] inputVariable = new int[7];           //declaration and instantiation  inputVariable
        private int[] bonusVariable = new int[7];          //declaration and instantiation  bonusVariable

        public Character(String characterType, int level){
            super();
            this.characterType = characterType;
            generateStats(level);
        }

        private int hitDice() {         // for calculate Hit Dice for all characters
            int output = 0;

            if(this.characterType.equals("Barbarian")) { output = (int)(Math.random() * 12 + 1) ;}           // calculate Hit Dice for Barbarian
            else if (this.characterType.equals("Bard")){ output = (int)(Math.random() * 8 + 1) ;}            // calculate Hit Dice for Bard
            else if (this.characterType.equals("Cleric")) { output = (int)(Math.random() * 8 + 1) ;}         // calculate Hit Dice for Cleric
            else if (this.characterType.equals("Druid")) { output = (int)(Math.random() * 8 + 1) ;}          // calculate Hit Dice for Druid
            else if (this.characterType.equals("Fighter")) { output = (int)(Math.random() * 10 + 1) ;}       // calculate Hit Dice for Fighter
            else if (this.characterType.equals("Monk")) { output = (int)(Math.random() * 8 + 1) ;}           // calculate Hit Dice for Monk
            else if (this.characterType.equals("Paladin")) { output = (int)(Math.random() * 10 + 1) ;}       // calculate Hit Dice for paldin
            else if (this.characterType.equals("Ranger")) { output = (int)(Math.random() * 10 + 1) ;}        // calculate Hit Dice for Ranger
            else if (this.characterType.equals("Rogue")) { output = (int)(Math.random() * 8 + 1) ;}          // calculate Hit Dice for Rogue
            else if (this.characterType.equals("Sorcerer")) { output = (int)(Math.random() * 6 + 1) ;}       // calculate Hit Dice for Sorcerer
            else if (this.characterType.equals("Warlock")) { output = (int)(Math.random() * 8  + 1) ;}       // calculate Hit Dice for Warlock
            else if (this.characterType.equals("Wizard")) { output = (int)(Math.random() * 6 + 1) ;}         // calculate Hit Dice for Wizard

            return output;
        }

        private void generateStats(int level){
            Scanner sc = new Scanner(System.in);    // initialize the Scanner
            boolean check = true;
            boolean go = true;
            inputVariable[0] = level;

            while(check) {
                if (inputVariable[0] <= 0 || inputVariable[0] >= 20) {
                    check = true;
                    System.out.println("Invalid input for level \n Re enter integer to level:");    //if user enter invalid input for level,
                    inputVariable[0] = sc.nextInt();                                                       // prompt a message to user re enter level
                } else
                    check = false;
            }

            while(go) {
                for (int i = 1; i < 7; i++) {
                    int diceA, diceB, diceC, diceD;
                    // Roll 4d6
                    diceA = (int)(Math.random() * 1000 % 6 + 1);
                    diceB = (int)(Math.random() * 1000 % 6 + 1);
                    diceC = (int)(Math.random() * 1000 % 6 + 1);
                    diceD = (int)(Math.random() * 1000 % 6 + 1);

                    // Find lowest dice
                    if ((diceA < diceB) && (diceA < diceC) && (diceA < diceD))
                        inputVariable[i] = diceB + diceC + diceD;    // assign total value to input variable
                    else if ((diceB < diceA) && (diceB < diceD) && (diceB < diceC))
                        inputVariable[i] = diceA + diceC + diceD;     // assign total value to input variable
                    else if ((diceC < diceA) && (diceC < diceB) && (diceC < diceD))
                        inputVariable[i] = diceA + diceB + diceD;     // assign total value to input variable
                    else
                        inputVariable[i] = diceA + diceB + diceC;     // assign total value to input variable
                }

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

                bonusVariable[6] = 0;

                for(int i = 0; i < inputVariable[0]; i++){      // calculate Hit points
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

                System.out.print(attribute[7] + " : " + String.valueOf(bonusVariable[6]) + " ");
                System.out.println();
                System.out.print("Do you want to re-roll the stats ? (0 - No / 1 - Yes) : ");   // asking from user wants to re roll

                int goValue = sc.nextInt();

                if(goValue == 0){
                    go = false;
                } else if(goValue == 1){
                    go = true;
                }
            }
        }
        public void printStats(){
            System.out.println("Level : " + String.valueOf(inputVariable[0]));      // for printing level

            for (int i = 0; i < 6; i++) {           // for printing input and bonus variables
                if (bonusVariable[i] <= 0) {
                    System.out.println(attribute[i + 1] + " : [" + String.valueOf(inputVariable[i + 1]) + "] [" + String.valueOf(bonusVariable[i]) + "]");
                } else {
                    System.out.println(attribute[i + 1] + " : [" + String.valueOf(inputVariable[i + 1]) + "] [+" + String.valueOf(bonusVariable[i]) + "]");
                }
            }

            System.out.println(attribute[7] + " : [" + String.valueOf(bonusVariable[6]) + "]");     // for printing Hit Points
            System.out.println("------End Of Calculations------");
        }
    }


