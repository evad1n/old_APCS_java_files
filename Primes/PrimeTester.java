
/**
 * Write a description of class www here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class PrimeTester
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner (System.in);
        int num = 97;
        boolean isPrime = true;
        System.out.println("Tests if a number is prime.");
        System.out.println("Please enter a number.");
        num = scan.nextInt();
        for(int i = 2; i < num; i++)
        {
            if(num % i == 0)
                isPrime = false;
        }
        if(isPrime)
            System.out.println(num + " is prime.");
        else
            System.out.println(num + " is not prime.");
    }
}
