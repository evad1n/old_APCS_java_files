
/**
 * Write a description of class ddd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class PrimeLister
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner (System.in);
        int LIMIT = 100;
        boolean isPrime = true;
        System.out.println("This program lists primes from 1 to the specified limit.");
        System.out.println("Please enter a limit.");
        LIMIT = scan.nextInt();
        for(int num = 1; num <= LIMIT; num++)
        {
            isPrime = true;
            for(int d = 2; d < num; d++)
            { 
                if(num % d == 0)
                {
                    isPrime = false;
                }
            }
            if(isPrime)
            {
                System.out.println(num);
            }
        }
        System.out.println("List of prime numbers 1-" + LIMIT);
    }
}
