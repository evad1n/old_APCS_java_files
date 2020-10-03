
/**
 * Write a description of class hex here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class hex
{
    public static void main (String[] args)
    {
        String answer = "y";
        while(answer.equals("y"))
        {
            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            int input;
            String output = "";
            System.out.println("Please enter a number");
            input = scan.nextInt();
            output = hexConverter(input);
            System.out.print("Hexadecimal Version:");
            System.out.println(output);
            System.out.println("Binary Version:");
            System.out.println();
            System.out.println("Again? (y/n)");
            answer = scan2.nextLine();
        }
    }
    
    private static String hexConverter (int x)
    {
        int a, b;
        a = x/16;
        if(a > 15)
        {
            return hexConverter(a) + hexConverter(x%16);
        }
        if(a != 0)
        {
            x = x%16;
            return translate(a) + hexConverter(x);
        }
        x = x%16;

        return translate(x);
    }
    
    private static String translate(int y)
    {
        String output = "";
        if(y < 10)
            output += y;
        else if(y == 10)
            output += "A";
        else if(y == 11)
            output += "B";
        else if(y == 12)
            output += "C";
        else if(y == 13)
            output += "D";
        else if(y == 14)
            output += "E";
        else if(y == 15)
            output += "F";
        else if(y == 16)
            output += "10";
        return output;
    }
}
