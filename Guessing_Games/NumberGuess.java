

import java.util.Scanner;

public class NumberGuess
{
    private static int answer;
    private static int guess;
    private static boolean higher = false;
    private static boolean lower = false;
    private static String another = "y";
    private static int guesses = 1;
    
    public static void main (String[] args)
    {
        Scanner playAgain = new Scanner (System.in);
        while(another.equals("y"))
        {
            System.out.println("I have picked a number 1-100 inclusive, try to guess my number.");
            System.out.println("You have 6 guesses.");
            answer = (int)(Math.random()*99+1);
            Guess();
            guesses = 1;
            while(guess != answer && guesses < 6)
            {
                System.out.println("Sorry that was incorrect");
                if(higher)
                    System.out.println("Guess higher");
                else
                    System.out.println("Guess lower");
                Guess();
                guesses++;
            }
            if(guesses >= 6 && guess != answer)
            {
                System.out.println("Sorry that was incorrect, the answer was " + answer);
                System.out.println("You ran out of guesses!");
            }
            else if(guess == answer)
            {
                System.out.println("Nice, you got it! The answer was " + answer + "!");
            }
            System.out.println("Do you want to play again?(y/n)");
            another = playAgain.nextLine();
        }
    }
  
    public static boolean Guess()
    {
        boolean error = false;
        higher = false;
        lower = false;
        Scanner scan = new Scanner (System.in);
        try
        {
            guess = scan.nextInt();
        }
        catch(Exception e)
        {
            //System.out.println("That isn't an integer");
            //System.out.println("Please enter an integer 1-100");
            scan.next();
            error = true;
        }
        if(guess < 1 || guess > 100)
        {
            System.out.println("That is out of the range 1-100");
            System.out.println("Please enter an integer 1-100");
            error = true;
        }
        while(error)
        {
            try
            {
                guess = scan.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("That isn't an integer");
                System.out.println("Please enter an integer 1-100");
                //scan.next();
            }
            if(scan.hasNextInt())
                error = false;
            if(guess < 1 || guess > 100)
            {
                System.out.println("That is out of the range 1-100");
                System.out.println("Please enter an integer 1-100");
                error = true;
            }
        }
        if(guess > answer)
            return lower = true;
        else
            return higher = true;
    }
}
