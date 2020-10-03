/**
 * Rock.java  Original File
 * 
 * Play Rock, Paper, Scissors with the user
 * 9/27/15 Pseudocode
 * 9/28/15 Will Dickinson Scan user, generate computer choice, print user choice, print computer choice, then see who wins
 * Due Wednesday 9/30
 */

import java.util.Scanner;

public class Rock
{
    public static void main (String[] args)
    {
        String personPlay, computerPlay;   
        int computerInt;                        
        Scanner scan = new Scanner(System.in);
        System.out.println("Please choose Rock, Paper or Scissors (R/P/S)");
        personPlay = scan.nextLine();         //Get User input
        computerInt = (int)(Math.random()*3); //Generate a random number 0, 1, or 2
        //Assign the randomly generated number to the respective Rock, Paper, Scissors values.
        if(computerInt == 0)
        {
            computerPlay = "R";
        }
        else
        {
            if(computerInt == 1)
            {
                computerPlay = "P";
            }
            else
            {
                computerPlay = "S";
            }
        }
        //Print the User's play
        if(personPlay.equalsIgnoreCase("R"))
        {
            System.out.println("You chose rock.");
        }
        else
        {
            if(personPlay.equalsIgnoreCase("P"))
            {
                System.out.println("You chose paper.");
            }
             if(personPlay.equalsIgnoreCase("S"))
            {
                System.out.println("You chose scissors.");
            }
        }
        //Print the computer's play
          if(computerPlay.equalsIgnoreCase("R"))
        {
            System.out.println("The computer chose rock.");
        }
        else
        {
            if(computerPlay.equalsIgnoreCase("P"))
            {
                System.out.println("The computer chose paper.");
            }
             if(computerPlay.equalsIgnoreCase("S"))
            {
                System.out.println("The computer chose scissors.");
            }
        }
        //See who won and then print the result out
        if(personPlay.equalsIgnoreCase(computerPlay))
        {
            System.out.println("It's a tie!");
        }
        else
        {
           if(computerPlay.equals("S")&&(personPlay.equalsIgnoreCase("R")))
           {
               System.out.println("Rock crushes scissors. You win!");
           }
           if(computerPlay.equals("R")&&(personPlay.equalsIgnoreCase("S")))
           {
               System.out.println("Rock crushes scissors. You lose!");
           }
           if(computerPlay.equals("P")&&(personPlay.equalsIgnoreCase("R")))
           {
               System.out.println("Paper covers rock. You lose!");
           }
           if(computerPlay.equals("P")&&(personPlay.equalsIgnoreCase("S")))
           {
               System.out.println("Scissors cuts paper. You win!");
           }
           if(computerPlay.equals("S")&&(personPlay.equalsIgnoreCase("P")))
           {
               System.out.println("Scissors cuts paper. You lose!");
           }
           if(computerPlay.equals("R")&&(personPlay.equalsIgnoreCase("P")))
           {
               System.out.println("Paper covers rock. You win!");
           }
        }
    }
}
/**
 * Rock.main({ })
Please choose Rock, Paper or Scissors (R/P/S)
r
You chose rock.
The computer chose paper.
Paper covers rock. You lose!
 */