
/**
 * Write a description of class papaSmurf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class papaSmurf
{
    public static void main (String[] args)
    {
        String input, output, choice, another = "y";
        while (another.equalsIgnoreCase("y"))
        {
            input = "I like to eat, eat apples and bananas.";
            System.out.println(input);
            System.out.println("Enter a new vowel");
            Scanner scan = new Scanner (System.in);
            choice = scan.nextLine();
            output = input.replaceAll("a",choice);
            System.out.println(output);
            System.out.println("Would you like to choose another vowel? (y/n)");
            another = scan.nextLine();
        }
    }
}
