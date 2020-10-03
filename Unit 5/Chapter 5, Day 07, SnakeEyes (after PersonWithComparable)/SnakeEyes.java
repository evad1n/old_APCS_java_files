//********************************************************************
//  SnakeEyes.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of a class with overloaded constructors.
//
//  12/1/15 Will D. Added counters to keep track of doubles, and if the dice were smaller/larger
//  12/2/15 Will D. Formatted to appear nicer
//  12/3/15 Will D. Added ratio of larger to smaller with explanation
//********************************************************************

public class SnakeEyes
{
   //-----------------------------------------------------------------
   //  Creates two die objects, then rolls both dice a set number of
   //  times, counting the number of snake eyes that occur.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      final int ROLLS = 500;
      int snakeEyes = 0, doubleCounter = 0, largerCounter = 0, smallerCounter = 0;

      Die die1 = new Die();    // creates a six-sided die
      Die die2 = new Die(20);  // creates a twenty-sided die

      for (int roll = 1; roll <= ROLLS; roll++)
      {
          System.out.println("Roll: " + roll);
          die1.roll();
          die2.roll();
          System.out.println("Die 1: " + die1);
          System.out.println("Die 2: " + die2);
          if ((die1.compareTo(die2)) == 0)
          {
                if(die1.equals(1))
                {
                    snakeEyes++;
                    doubleCounter++;
                    System.out.println("------------------------SNAKE EYES------------------------");
                }
                else
                {
                    doubleCounter++;
                    System.out.println("Die 1 and Die 2 are the same, but not 1.");
                }
          }
          else if(die1.compareTo(die2) == 1)
          {
              System.out.println("Die 1 is greater than Die 2.");
              largerCounter++;
          }
          else
          {
                System.out.println("Die 1 is less than Die 2.");
                smallerCounter++;
          }
          System.out.println();
      }

      System.out.println ("Total number of rolls: " + Die.getRollCall());
      System.out.println ("Number of snake eyes: " + snakeEyes);
      System.out.println ("Ratio of snake eyes to rolls: " + (double)snakeEyes/ROLLS);
      System.out.println("Numeber of doubles: " + doubleCounter);
      System.out.println ("Ratio of snake eyes to doubles: " + (double)snakeEyes/doubleCounter);
      System.out.println("Number of times Die 1 was smaller: " + smallerCounter);
      System.out.println("Number of times Die 1 was larger: " + largerCounter);
      System.out.println("\nThe ratio of the # of times Die 1 was larger to the ratio of the");
      System.out.println("# of times Die 1 was smaller(accounting for the # of times there");
      System.out.println("were doubles) is: " + (double)(largerCounter + doubleCounter/2)/(smallerCounter + doubleCounter/2));
      System.out.println("\nIf the numFaces of Die 1 is 1.5*numFaces of die 2, then as rolls approaches infinity, the ratio above approaches 2.");
   }
}
