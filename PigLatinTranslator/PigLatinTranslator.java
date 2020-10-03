
/**
 * Write a description of class PigLatinTranslator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class PigLatinTranslator
{
    public String translate (String sentence)
    {
        String result = " ";
        
        sentence = sentence.toLowerCase();
        Scanner scan = new Scanner (sentence);
        
        while (scan.hasNext())
        {
            result += translateWord (scan.next());
            result += " ";
        }
        return result;
    }
    
    private String translateWord (String word)
    {
        String result = " ";
        
        if (beginsWithVowel(word))
            result = word + "yay";
        else
            if (beginsWithBlend(word))
                result = word.substring(2) + word.substring(0,2) + "ay";
            else
                result = word.substring(1) + word.charAt(0) + "ay";
        return result;
    }
    
    private boolean beginsWithVowel (String word)
    {
        String vowels = "aeiou";
        char letter = word.charAt(0);
        return (vowels.indexOf(letter) != -1);
    }
    
    private boolean beginsWithBlend (String word)
    {
        return ( word.startsWith ("bl") || word.startsWith ("sc") ||
                 word.startsWith ("br") || word.startsWith ("sh") ||
                 word.startsWith ("ch") || word.startsWith ("sk") ||
                 word.startsWith ("cl") || word.startsWith ("sl") ||
                 word.startsWith ("cr") || word.startsWith ("sn") ||
                 word.startsWith ("dr") || word.startsWith ("sm") ||
                 word.startsWith ("dw") || word.startsWith ("sb") ||
                 word.startsWith ("fl") || word.startsWith ("sq") ||
                 word.startsWith ("fr") || word.startsWith ("st") ||
                 word.startsWith ("gl") || word.startsWith ("sw") ||
                 word.startsWith ("gr") || word.startsWith ("th") ||
                 word.startsWith ("kl") || word.startsWith ("tr") ||
                 word.startsWith ("bh") || word.startsWith ("tw") ||
                 word.startsWith ("pl") || word.startsWith ("wh") ||
                 word.startsWith ("pr") || word.startsWith ("wr") );
    }
}
