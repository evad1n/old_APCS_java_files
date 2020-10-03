//********************************************************************
//  Die.java       Author: Lewis/Loftus/Cocking
//
//  Represents one die (singular of dice) with faces showing values
//  between 1 and the number of faces on the die.
//
// 12/1/15 Will D. added implementation of Comparable interface
// 12/2/15 Will D. added toString and methods for Comparable interface
// 12/3/15 Added a static variable for roll count and a method to access that variable
//********************************************************************


public class Die implements Comparable
{
   private final int MIN_FACES = 4;

   private int numFaces;   // number of sides on the die
   private int faceValue;  // current value showing on the die

   private static int rollCall;

   //-----------------------------------------------------------------
   //  Defaults to a six-sided die. Initial face value is 1.
   //-----------------------------------------------------------------
   public Die ()
   {
      numFaces = 6;
      faceValue = 1;
   }

   //-----------------------------------------------------------------
   //  Explicitly sets the size of the die. Defaults to a size of
   //  six if the parameter is invalid.  Initial face value is 1. 
   //-----------------------------------------------------------------
   public Die (int faces)
   {
      if (faces < MIN_FACES)
         numFaces = 6;
      else
         numFaces = faces;

      faceValue = 1;
   }

   //-----------------------------------------------------------------
   //  Rolls the die and returns the result.
   //-----------------------------------------------------------------
   public int roll ()
   {
      rollCall++;
      faceValue = (int)((Math.random()*numFaces)+1);
      return faceValue;
   }
   // Compares the value of a die and an int
   public boolean equals (Object other)
   {
       int x = (int) other;
       if(this.faceValue == x)
            return true;
       return false;
   }
   // Compares the faceValues of 2 dice
   public int compareTo (Object other)
   {
       Die d = (Die) other;
       if(this.faceValue < d.faceValue)
            return -1;
       if(this.faceValue > d.faceValue)
            return 1;
       return 0;
   }
   //-----------------------------------------------------------------
   //  Returns the current die value.
   //-----------------------------------------------------------------
   public int getFaceValue ()
   {
      return faceValue;
   }
   //  Access static variable rollCall
   public static int getRollCall ()
   {
       return rollCall;
   }

   public String toString ()
   {
       return "" + faceValue;
   }
}
