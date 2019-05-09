import java.util.Scanner;
public class Workshop02 {
    public static void main(String[] args){

        Scanner myInput = new Scanner(System.in);       // initialize the Scanner

        String[] attribute = {"Level", "Str", "Dex", "Con", "Int", "Wis", "Cha", "HP"};        //declaration, instantiation and initialization attribute
        int[] inputVariable = new int[7];           //declaration and instantiation  inputVariable
        int[] bonusVariable = new int[7];           //declaration and instantiation  bonusVariable
        boolean check = true;       // creating boolean variable
        boolean go = true;          // creating boolean variable
        System.out.print(attribute[0] + " : ");         //printing attribute
        inputVariable[0] = myInput.nextInt();       //getting integer to level

        while(check) {
            if (inputVariable[0] <= 0 || inputVariable[0] >= 20) {
                check = true;
                System.out.println("Invalid input for level \n Re enter integer to level:");    //if user enter invalid input for level,
                inputVariable[0] = myInput.nextInt();                                                       // promt a message to user re enter level
            } else
                check = false;
        }

        while(go) {
            for (int i = 1; i < 7; i++) {   //for reading input variable
                // for calculating input variables
                inputVariable[i] = (int)(Math.random()*1000 %6+1) + (int)(Math.random()*1000 %6+1) + (int)(Math.random()*1000 %6+1);
            }

            for (int i = 0; i < 6; i++) {       // for calculate bonus
                int bonus = 0;
                if (inputVariable[i + 1] == 10) {
                    bonus = 0;
                }else if (inputVariable[i + 1] > 10) {
                    bonus = (inputVariable[i + 1] - 10) / 2;
                }else if (inputVariable[i + 1] < 10) {
                    if (inputVariable[i + 1] % 2 == 0) {
                        bonus = -1 * ((inputVariable[i + 1] / 2));
                    } else {
                        bonus = -1 * ((inputVariable[i + 1]  + 1) / 2);
                    }
                }

                bonusVariable[i] = bonus;
            }

            bonusVariable[6] = 0;
            for(int i = 0; i < inputVariable[0]; i++){      // for calculate hit points
                bonusVariable[6] += (int)(Math.random()*1000 %6+1) + bonusVariable[2];
            }

            System.out.print("Level : " + String.valueOf(inputVariable[0]) + " ");  // for printing level

            for (int i = 0; i < 6; i++) {       // for printing input and bonus variable before re roll
                if (bonusVariable[i] <= 0) {
                    System.out.print(attribute[i + 1] + " : " + String.valueOf(inputVariable[i + 1]) + " " + String.valueOf(bonusVariable[i]) + " ");
                } else {
                    System.out.print(attribute[i + 1] + " : " + String.valueOf(inputVariable[i + 1]) + " +" + String.valueOf(bonusVariable[i]) + " ");
                }
            }
            System.out.print(attribute[7] + " : " + String.valueOf(bonusVariable[6]) + " ");    // for printing Hit points before re roll
            System.out.println();

            System.out.print("Do you want to re-roll the stats ? (0 - No / 1 - Yes) : ");      // Asking from user to re roll the stats
            int value = myInput.nextInt();
            if(value == 0){
                go = false;
            } else if(value == 1){
                go = true;
            }
        }
        System.out.println("Level : " + String.valueOf(inputVariable[0]));

        for (int i = 0; i < 6; i++) {       // for printing final input and bonus variable
            if (bonusVariable[i] <= 0) {
                System.out.println(attribute[i + 1] + " : [" + String.valueOf(inputVariable[i + 1]) + "] [" + String.valueOf(bonusVariable[i]) + "]");
            } else {
                System.out.println(attribute[i + 1] + " : [" + String.valueOf(inputVariable[i + 1]) + "] [+" + String.valueOf(bonusVariable[i]) + "]");
            }
        }
        System.out.println(attribute[7] + " : [" + String.valueOf(bonusVariable[6]) + "]");     // for printing final Hit points
        System.out.println("\n------End Of Calculations------");
    }
}
