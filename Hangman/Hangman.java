
/**
 * Write a description of class Hangman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.applet.Applet;
import java.awt.*;

public class Hangman
{
    Scanner scan = new Scanner (System.in);
    String word, filler = "", temp;
    boolean win = false;
    
    public Hangman(String str)
    {
        word = str;
        filler = str.replaceAll("[^ ]", "-");
    }
    
    public void printFiller()
    {
        System.out.println(filler);
    }
    
    public int guessLetter(char letter)
    {
        int psn = 0, wrong = 0,count = 0;
        boolean already = false;
        for(int i = 0; i < word.length();i++)
        {
            if(word.charAt(psn)==letter)
            {
                if(filler.charAt(psn)!=letter)
                {
                    filler = filler.substring(0,psn) + letter + filler.substring(psn+1);
                    count++;
                }
                else
                {
                    already = true;
                    wrong ++;
                }
            }
            else
            {
                wrong++;
            }
            psn++;
        }
        System.out.println(filler);
        if(filler.equals(word))
            win = true;
        if(wrong == word.length())
        {
            if(!already)
            {
                System.out.println("Sorry that letter isn't in the word.");
            }
            else
                System.out.println("You already guessed " + letter + "!");
            return 1;
        }
        else
        {
            if(count == 1)
                System.out.println("There is " + count + " " + letter + " in this word");
            else
                System.out.println("There are " + count + " " + letter + "'s in this word");
            return 0;
        }
    }
    
    public int guessWord(String guess)
    {
        if(guess.equals(word))
        {
            win = true;
            return 0;
        }
        else
        {
            System.out.println("Nope, that's not the word.");
            return 1;
        }
    }
    
    public boolean checkWin()
    {
        return win;
    }
    
    public void drawHangman(int wrongs)
    {
        if(wrongs == 0)
        {
            System.out.println("  ___________");
            System.out.println("  |         |");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println(" ___");
        }
        else if(wrongs == 1)
        {
            System.out.println("  ___________");
            System.out.println("  |         |");
            System.out.println("  |        ( )      ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println(" ___");
        }
        else if(wrongs == 2)
        {
            System.out.println("  ___________");
            System.out.println("  |         |");
            System.out.println("  |        ( )      ");
            System.out.println("  |         |     ");
            System.out.println("  |         |     ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println(" ___");
        }
        else if(wrongs == 3)
        {
            System.out.println("  ___________");
            System.out.println("  |         |");
            System.out.println("  |        ( )      ");
            System.out.println("  |         |/     ");
            System.out.println("  |         |     ");
            System.out.println("  |             ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println(" ___");
        }
        else if(wrongs == 4)
        {
            System.out.println("  ___________");
            System.out.println("  |         |");
            System.out.println("  |        ( )      ");
            System.out.println("  |        \\|/     ");
            System.out.println("  |         |     ");
            System.out.println("  |             ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println(" ___");
        }
        else if(wrongs == 5)
        {
            System.out.println("  ___________");
            System.out.println("  |         |");
            System.out.println("  |        ( )      ");
            System.out.println("  |        \\|/     ");
            System.out.println("  |         |     ");
            System.out.println("  |        /    ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println(" ___");
        }
        else if(wrongs == 6)
        {
            System.out.println("  ___________");
            System.out.println("  |         |");
            System.out.println("  |        (x)      ");
            System.out.println("  |        \\|/     ");
            System.out.println("  |         |     ");
            System.out.println("  |        / \\  ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println("  |               ");
            System.out.println(" ___");
        }
    }
}
