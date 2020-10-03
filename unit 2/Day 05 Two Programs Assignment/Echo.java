//********************************************************************
//  Echo.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of the nextLine method of the Scanner class
//  to read a string from the user.
//********************************************************************
//Will Dickinson 9/17/2015
import java.util.Scanner;

public class Echo
{
   //-----------------------------------------------------------------
   //  Reads a character string from the user and prints it.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      String message, mutation1, mutation2, mutation3, mutation4, mutation5, mutation6, mutation7;;
      Scanner scan = new Scanner (System.in);
      int length;
      char char1;

      System.out.println ("Enter a line of text:");

      message = scan.nextLine();
      
      length = message.length();

      System.out.println ("You entered: \"" + message + "\"");
      
      mutation1 = message.concat (" and you smell like one too");
      mutation2 = mutation1.toUpperCase();
      mutation3 = mutation2.substring(4, 20);
      mutation4 = mutation3 + length;
      mutation5 = mutation4.substring(7, 15);
      
      System.out.println ("Mutation 1: " + mutation1);
      System.out.println ("Mutation 2: " + mutation2);
      System.out.println ("Mutation 3: " + mutation3);
      System.out.println ("Mutation 4: " + mutation4);
      System.out.println ("Mutation 5: " + mutation5);
   }
}
/**
Echo.main({ })
Enter a line of text:
can i have a cookie
You entered: "can i have a cookie"
Mutation 1: can i have a cookie and you smell like one too
Mutation 2: CAN I HAVE A COOKIE AND YOU SMELL LIKE ONE TOO
Mutation 3: I HAVE A COOKIE 
Mutation 4: I HAVE A COOKIE 19
Mutation 5: A COOKIE
 */