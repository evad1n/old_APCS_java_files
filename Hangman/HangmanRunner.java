
/**
 * Write a description of class HangmanRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class HangmanRunner
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner (System.in);
        char letter;
        int response, length, wrong = 0;
        String guess; 
        //******PUT ANSWER HERE****************************
        String answer = "elephants eat bananas"; // put the answer here
        //******PUT ANSWER HERE****************************
        Hangman game = new Hangman(answer);
        System.out.println("Welcome to Hangman!");
        System.out.println("5 wrong guesses and you're out!");
        System.out.println("The word is " + answer.length() + " letters long");
        game.printFiller();
        while(!game.checkWin())
        {
            System.out.println("Would you like to guess a letter or the whole word?");
            System.out.println("[1] Letter");
            System.out.println("[2] Word");
            response = scan.nextInt();
            if(response==1)
            {
                System.out.println("Please enter a letter to guess.");
                letter = scan.next().charAt(0);
                wrong += game.guessLetter(letter);
                if(game.checkWin())
                    System.out.println("You got all the letters!");
            }
            else if(response==2)
            {
                System.out.println("Please enter your guess for the whole word.");
                guess = scan.nextLine();
                guess = scan.nextLine();
                wrong += game.guessWord(guess);
                if(game.checkWin())
                {
                    System.out.println("You got it!");
                }
            }
            else
                System.out.println("That is not an option");
            if(wrong >= 6)
                game.guessWord(answer);
            game.drawHangman(wrong);
        }
        if(wrong < 6)
        {
            System.out.println("The answer was " + answer + ".");
            System.out.println("Nice job!");
        }
        else
        {
            System.out.println("You got hung!");
        }
    }
}
