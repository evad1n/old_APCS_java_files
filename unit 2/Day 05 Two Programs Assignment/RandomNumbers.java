//********************************************************************
//  RandomNumbers.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the import statement, and the creation of pseudo-
//  random numbers using the Random class.
//********************************************************************
//Will Dickinson 9/17/2015
public class RandomNumbers
{
   //-----------------------------------------------------------------
   //  Generates random numbers in various ranges.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      int num1 = (int)(Math.random()*10);
      System.out.println ("From 0 to 9: " + num1);

      num1 = (int)(Math.random()*10 + 1);
      System.out.println ("From 1 to 10: " + num1);

      num1 = (int)(Math.random()*15 + 20);
      System.out.println ("From 20 to 34: " + num1);

      num1 = (int)(Math.random()*20 + -10);
      System.out.println ("From -10 to 9: " + num1);

      double num2 = ((int)(Math.random()*10)/10.0);
      System.out.println ("A random double [between 0-1]: " + num2);

      num2 = (Math.random()*6);  // 0.0 to 5.999999
      num1 = (int) num2 + 1;
      System.out.println ("From 1 to 6: " + num1);
   }
}
/**
 * RandomNumbers.main({ })
From 0 to 9: 0
From 1 to 10: 5
From 20 to 34: 26
From -10 to 9: 9
A random double [between 0-1]: 0.4
From 1 to 6: 6
*/