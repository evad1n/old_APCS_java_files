
/**
 * Write a description of class loop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class loop
{
    public static void main (String[] args)
    {
        int limit;
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter a number you would like to count to.");
        limit = scan.nextInt();
        for (int count = 1;count <= limit; count++)
        {
            System.out.println(count);
        }
        System.out.println("Done.");
    }
}
