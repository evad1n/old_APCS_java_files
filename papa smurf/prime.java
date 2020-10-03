
/**
 * Write a description of class prime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class prime
{
    public static void main (String[] args)
    {
        int number;
        String another = "y";
        boolean isPrime = true;
        Scanner scan = new Scanner (System.in);
        System.out.println("This program tests if a number is prime");
        while(another.equalsIgnoreCase("y"))
        {
            System.out.println("Please enter a number.");
            number = scan.nextInt();
            for (int count=2; count < number; count++)
            {
                if(number%count == 0)
                {
                    isPrime = false;
                }
            }
            if(isPrime)
            {
                System.out.println("This number is a prime.");
            }
            else
            {
                System.out.println("This number is NOT a prime.");
            }
            System.out.println("Would you like to test another number?(y/n)");
            another = scan.nextLine();
        }
    }
}
