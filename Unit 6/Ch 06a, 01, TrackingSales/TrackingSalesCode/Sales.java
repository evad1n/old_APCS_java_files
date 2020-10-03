// ****************************************************************
// Sales.java
//
// Reads in and stores sales for each of 5 salespeople. Displays
// sales entered by salesperson id and total sales for all salespeople.
//
// 12/11/15 Will D.
// ****************************************************************
import java.util.Scanner;

public class Sales
{
    public static void main(String[] args)
    {
        int salespeople = 5;
        int sum, max = 0, maxPerson = 1, min = 0, minPerson = 1;
        int cutoff, peopleOver = 0;
        Scanner scan = new Scanner(System.in);
        Scanner name = new Scanner(System.in);
        
        System.out.println("How many sales would you like to enter?");
        salespeople = scan.nextInt();
        String[] names = new String[salespeople];
        int[][] sales = new int[salespeople][2];
        for (int i=0; i<sales.length; i++)
        {
            System.out.println("Enter the name of salesperson " + (i+1) + ": ");
            names[i] = name.nextLine();
            System.out.print("Enter sales for " + names[i] + ": ");
            sales[i][1] = scan.nextInt();
        }
        System.out.println("\nSalesperson Sales");
        System.out.println("--------------------");
        System.out.println("ID# Name    Sales");
        sum = 0;
        min = sales[0][1];
        max = sales[0][1];
        for (int i=0; i<sales.length; i++)
        {
            if(sales[i][1] < 0)
                System.out.println(" " + (i+1) + "  " + names[i] + "     -$" + Math.abs(sales[i][1]));
            else
                System.out.println(" " + (i+1) + "  " + names[i] + "      $" + sales[i][1]);
            sum += sales[i][1];
            if(sales[i][1] > max)
            {
                max = sales[i][1];
                maxPerson = (i+1);
            }
            if(sales[i][1] < min)
            {
                min = sales[i][1];
                minPerson = (i+1);
            }
        }
        System.out.println("\nTotal sales: " + sum);
        System.out.println("Average sale: " + sum/sales.length);
        System.out.println("Salesperson " + maxPerson + " had the highest sale with $" + max);
        if(min < 0)
            System.out.println("Salesperson " + minPerson + " had the lowest sale with -$" + Math.abs(min));
        else
            System.out.println("Salesperson " + minPerson + " had the lowest sale with $" + min);
        
        System.out.println("Please enter a cutoff value for the sales");
        cutoff = scan.nextInt();
        System.out.println("The following salespeople's sales exceeded that value\n");
        for (int i=0; i<sales.length; i++)
        {
            sum += sales[i][1];
            if(sales[i][1] > cutoff)
            {
                System.out.println(i+1);
                peopleOver++;
            }
        }
        System.out.println("\nThe total number of salespeople whose sales exceeded that value is " + peopleOver);
        
        for (int i=0; i<sales.length; i++)
        {
            if(sales[i][0] > 0)
                sales[i][0] = (3*(sales[i][1]/2))/3;
        }
        
        for (int i=0; i<sales.length; i++)
        {
            System.out.print("Name: " + names[i]);
            System.out.print("\tSales: " + sales[i][1]);
            System.out.print("\tWages: " + sales[i][0]);
            System.out.println();
        }
    }
}