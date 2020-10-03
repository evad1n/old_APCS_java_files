
/**
 * Write a description of class SolveTowers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class SolveTowers
{
    private static int totalDisks;
    public static void main (String[] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println("This program will solve the Towers of Hanoi Puzzle using recursion.");
        System.out.println("How many disks do you want?");
        totalDisks = scan.nextInt();
        TowersOfHanoi towers = new TowersOfHanoi (totalDisks);
        towers.solve();
    }
}
