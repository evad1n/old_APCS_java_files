
/**
 * Write a description of class PigLatin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class PigLatin
{
    public static void main (String[] args)
    {
        String sentence, result, another = "y";
        Scanner scan = new Scanner (System.in);
        PigLatinTranslator translator = new PigLatinTranslator();
        
        while (another.equalsIgnoreCase("y"))
        {
            System.out.println ();
            System.out.println ("Enter a sentence (no punctuation):");
            sentence = scan.nextLine();
            
            System.out.println ();
            result = translator.translate (sentence);
            System.out.println ("That sentence in Pig Latin is:");
            System.out.println (result);
            
            System.out.println ();
            System.out.println ("Translate another sentence (y/n)? ");
            another = scan.nextLine();
        }
    }
}
