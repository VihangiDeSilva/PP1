import java.util.Scanner;
public class Workshop01 {
    public static void main(String []args) {

        int Str;          // creating variables
        int Dex;          // creating variables
        int Con;          // creating variables
        int Int;          // creating variables
        int Wis;          // creating variables
        int Cha;          // creating variables
        int Level;        // creating variables
        double Hitpoints; // creating Hitpoints
        int Bonus;        // creating bonus variable
        boolean check = true; // creating boolean condition

        // initialize the Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Enter integer to Level: ");     // getting an integer for level
        Level = input.nextInt();
        while (check){                         // for checking level boundaries
            if(Level<= 0 || Level >= 20 ){
                check = true;
                System.out.println("Invalid input for level \n Re \"enter integer\" to level:");    //if user enter invalid input for level,
                Level = input.nextInt();                                                       // promt a message to user re enter level
            } else
                check = false;
        }

        System.out.println("Enter integer to Str: ");
        Str = input.nextInt();      // getting an integer for Str
        System.out.println("Enter integer to Dex: ");
        Dex = input.nextInt();      // getting an integer for Dex
        System.out.println("Enter integer to Con: ");
        Con = input.nextInt();      // getting an integer for Con
        System.out.println("Enter integer to Int: ");
        Int = input.nextInt();      // getting an integer for Int
        System.out.println("Enter integer to Wis: ");
        Wis = input.nextInt();      // getting an integer for Wis
        System.out.println("Enter integer to Cha: ");
        Cha = input.nextInt(); // getting an integer for Cha

        System.out.println("level :  [" +Level + "]" );         // for printing level

        if(Str == 10){
            System.out.println( "Str   :  ["  + Str + "]   [" + "0" + "]" );          //calculating bonus for str
        }                                                                              // printing value of str and bonus
        else if (Str % 2 == 0 && Str > 10){
            Bonus = (Str / 2) - 5;
            System.out.println( "Str   :  [" + Str + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Str % 2 == 1 && Str > 10){
            Bonus = (Str - 10)/2;
            System.out.println( "Str   :  [" + Str + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Str < 0){
            System.out.println("Input is invalid");
        }
        else if (Str < 10 && Str % 2 == 0){
            Bonus = -1 * (Str / 2);
            System.out.println( "Str   :  [" + Str + " ]   [" +  + Bonus + "]" );
        }
        else if (Str < 10 && Str % 2 == 1){
            Bonus = -1 * ((Str + 1) / 2);
            System.out.println( "Str   :  [" + Str + " ]   [" +  + Bonus + "]" );
        }

        if(Dex == 10){
            System.out.println( "Dex   :  ["  + Dex + "]   [" + "0" + "]" );        //calculating bonus for dex
        }                                                                              // printing value of dex and bonus
        else if (Dex % 2 == 0 && Dex > 10){
            Bonus = (Dex - 10)/2 ;
            System.out.println( "Dex   :  [" + Dex + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Dex % 2 == 1 && Dex > 10){
            Bonus = (Dex - 10)/2;
            System.out.println( "Dex   :  [" + Dex + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Dex < 0){
            System.out.println("Input is invalid");
        }
        else if (Dex < 10 && Dex % 2 == 0){
            Bonus = -1 * (Dex / 2);
            System.out.println( "Dex   :  [" + Dex + " ]   [" +  + Bonus + "]" );
        }
        else if (Dex < 10 && Dex % 2 == 1){
            Bonus = -1 * ((Dex + 1) / 2);
            System.out.println( "Dex   :  [" + Dex + " ]   [" +  + Bonus + "]" );
        }

        if(Con == 10){
            System.out.println( "Con   :  ["  + Con + "]   [" + "0" + "]" );         //calculating bonus for con
        }                                                                              // printing value of con and bonus
        else if (Con % 2 == 0 && Con > 10){
            Bonus = (Con - 10)/2;
            System.out.println( "Con   :  [" + Con + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Con % 2 == 1 && Con > 10){
            Bonus = (Con - 10)/2;
            System.out.println( "Con   :  [" + Con + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Con < 0){
            System.out.println("Input is invalid");
        }
        else if (Con < 10 && Con % 2 == 0){
            Bonus = -1 * (Con / 2);
            System.out.println( "Con   :  [" + Con + " ]   [" +  + Bonus + "]" );
        }
        else if (Con < 10 && Con % 2 == 1){
            Bonus = -1 * ((Con + 1) / 2);
            System.out.println( "Con   :  [" + Con + " ]   [" +  + Bonus + "]" );
        }

        if(Int == 10){
            System.out.println( "Int   :  ["  + Int + "]   [" + "0" + "]" );         //calculating bonus for int
        }                                                                              // printing value of int and bonus
        else if (Int % 2 == 0 && Int > 10){
            Bonus = (Int - 10)/2;
            System.out.println( "Int   :  [" + Int + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Int % 2 == 1 && Int > 10){
            Bonus = (Int - 10)/2;
            System.out.println( "Int   :  [" + Int + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Int < 0){
            System.out.println("Input is invalid");
        }
        else if (Int < 10 && Int % 2 == 0){
            Bonus = -1 * (Int / 2);
            System.out.println( "Int   :  [" + Int + " ]   [" +  + Bonus + "]" );
        }
        else if (Int < 10 && Int % 2 == 1){
            Bonus = -1 * ((Int + 1) / 2);
            System.out.println( "Int   :  [" + Int + " ]   [" +  + Bonus + "]" );
        }

        if(Wis == 10){
            System.out.println( "Wis   :  ["  + Wis + "]   [" + "0" + "]" );         //calculating bonus for wis
        }                                                                              // printing value of wis and bonus
        else if (Wis % 2 == 0 && Wis > 10){
            Bonus = (Wis - 10)/2;
            System.out.println( "Wis   :  [" + Wis + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Wis % 2 == 1 && Wis > 10){
            Bonus = (Wis - 10)/2;
            System.out.println( "Wis   :  [" + Wis + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Wis < 0){
            System.out.println("Input is invalid");
        }
        else if (Wis < 10 && Wis % 2 == 0){
            Bonus = -1 * (Wis / 2);
            System.out.println( "Wis   :  [" + Wis + " ]   [" +  + Bonus + "]" );
        }
        else if (Wis < 10 && Wis % 2 == 1){
            Bonus = -1 * ((Wis + 1) / 2);
            System.out.println( "Wis   :  [" + Wis + " ]   [" +  + Bonus + "]" );
        }

        if(Cha == 10){
            System.out.println( "Cha   :  ["  + Cha + "]   [" + "0" + "]" );         //calculating bonus for cha
        }                                                                              // printing value of cha and bonus
        else if (Cha % 2 == 0 && Cha > 10){
            Bonus = (Cha - 10)/2;
            System.out.println( "Cha   :  [" + Cha + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Cha % 2 == 1 && Cha > 10){
            Bonus = (Cha - 10)/2;
            System.out.println( "Cha   :  [" + Cha + " ]   [" + "+" + Bonus + "]" );
        }
        else if (Cha < 0){
            System.out.println("Input is invalid");
        }
        else if (Cha < 10 && Cha % 2 == 0){
            Bonus = -1 * (Cha / 2);
            System.out.println( "Cha   :  [" + Cha + " ]   [" +  + Bonus + "]" );
        }
        else if (Cha < 10 && Cha % 2 == 1){
            Bonus = -1 * ((Cha + 1) / 2);
            System.out.println( "Cha   :  [" + Cha + " ]   [" +  + Bonus + "]" );
        }
        Hitpoints = Level * ((Math.random()*1000 %6+1));            // calculating Hitpoints
        System.out.println( "HP    :  [" +Hitpoints + "]"  );       // for printing Hitpoints
        System.out.println("\n------End Of Calculations------");
    }
}



