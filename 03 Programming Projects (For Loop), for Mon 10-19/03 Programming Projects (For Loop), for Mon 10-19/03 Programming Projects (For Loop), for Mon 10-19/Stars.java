//********************************************************************
//  Stars.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of nested for loops.
//********************************************************************

public class Stars
{
   //-----------------------------------------------------------------
   //  Prints a triangle shape using asterisk (star) characters.
   //-----------------------------------------------------------------
   public Stars ()
   {
   }
   
   public static void origStar ()
   {
      final int MAX_ROWS = 10;

      for (int row = 1; row <= MAX_ROWS; row++)
      {
         for (int star = 1; star <= row; star++)
            System.out.print ("*");

         System.out.println();
      }
   }
   
   public static void aStar ()
   {
      final int MAX_ROWS = 0;

      for (int row = 10; row >= MAX_ROWS; row--)
      {
         for (int star = row; star > 0; star--)
            System.out.print ("*");

         System.out.println();
      }
   }
   
   public static void bStar ()
   {
      final int MAX_ROWS = 10;

      for (int row = 1; row <= MAX_ROWS; row++)
      {
        for (int spaces = (10-row); spaces > 0; spaces--)
        {
            System.out.print (" ");
        }
        for (int star = 1; star <= row; star++)
        {
            System.out.print ("*");
        }

        System.out.println();
      }
   }
   
   public static void cStar ()
   {
      final int MAX_ROWS = 0;

      for (int row = 10; row >= MAX_ROWS; row--)
      {
        for (int spaces = Math.abs(row - 10); spaces > 0; spaces--)
        {
            System.out.print (" ");
        }
        for (int star = row; star > 0; star--)
            System.out.print ("*");

         System.out.println();
      }
   }
   
   public static void dStar ()
   {
      final int MAX_ROWS = 5;

      for (int row = 1; row <= MAX_ROWS; row++)
      {
        for (int spaces = (5-row); spaces > 0; spaces--)
        {
            System.out.print (" ");
        }
        for (int star = 1; star <= (2*row-1); star++)
            System.out.print ("*");

         System.out.println();
      }
      for (int row = 1; row <= MAX_ROWS; row++)
      {
        for (int spaces = row-1; spaces > 0; spaces--)
        {
            System.out.print (" ");
        }
        for (int star = 10-(2*row-1); star > 0; star--)
            System.out.print ("*");

         System.out.println();
      }
   }
   
   public static void coolStar ()
   {
      final int MAX_ROWS = 10;

      for (int row = 1; row <= MAX_ROWS; row++)
      {
         for (int star = 1; star <= row; star++)
         {
            for (int spaces = 9; spaces >= (10 - row); spaces--)
            {
                System.out.print (" ");
            }
            System.out.print ("*");
        }

         System.out.println();
      }
   }
   
   public static void coolStarDown ()
   {
      final int MAX_ROWS = 10;

      for (int row = 1; row <= MAX_ROWS; row++)
      {
         for (int star = 9; star >= row; star--)
         {
            for (int spaces = 1; spaces <= (10 - row); spaces++)
            {
                System.out.print (" ");
            }
            System.out.print ("*");
        }

         System.out.println();
      }
   }
   
   public static void dStar2 ()
   {
      final int MAX_ROWS = 5;
      
      for (int row = -5; row <= MAX_ROWS; row++)
      {
          if(row == 0)
          row = 1;
          for (int spaces = Math.abs(row)-1; spaces > 0; spaces--)
              {
                  System.out.print (" ");
              }
          for (int star = 11-2*Math.abs(row); star >= 1; star--)
          {
              System.out.print ("*");
          }
           System.out.println();
      }
   }
   
   public static void arrowStar ()
   {
      final int MAX_ROWS = 5;
      
      for (int row = -5; row <= MAX_ROWS; row++)
      {
          for (int spaces = 2*Math.abs(row); spaces > 0; spaces--)
              {
                  System.out.print (" ");
              }
          for (int star = 23-4*Math.abs(row); star >= 1; star--)
          {
              if(star == 3 || star ==1)
              System.out.print ("*");
              else
              System.out.print(" ");
          }
           System.out.println();
      }
   }
   
      public static void circleStar ()
   {
      final int MAX_ROWS = 5;
      
      for (int row = -5; row <= MAX_ROWS; row++)
      {
          for (int spaces = 2*Math.abs(row); spaces > 0; spaces--)
              {
                  System.out.print (" ");
              }
          for (int star = 23-4*Math.abs(row); star >= 1; star--)
          {
              if(star == 23-4*Math.abs(row) || star ==1)
              System.out.print ("*");
              else
              System.out.print(" ");
          }
           System.out.println();
      }
   }
   
   public static void christmasStar ()
   {
      final int MAX_ROWS = 10;

      for (int row = 1; row <= MAX_ROWS; row++)
      {
        for (int spaces = (10-row); spaces > 0; spaces--)
        {
            System.out.print (" ");
        }
        for (int star = 1; star <= (2*row-1); star++)
            System.out.print ("*");

         System.out.println();
      }
      System.out.println("       *****");
      System.out.println("       *****");
   }   
    
   public static void yinYang ()
   {
      System.out.println("        *****");
      System.out.println("     ***********");
      System.out.println("   ************* *");
      System.out.println(" *****  *****       *");
      System.out.println("***********         *");
      System.out.println("*********           *");
      System.out.println("********            *");
      System.out.println(" *******          *");
      System.out.println("   *****    **  *");
      System.out.println("     ****     *");
      System.out.println("       ******");
   }
   
   public static void squares ()
   {
       for(int i=12; i>=1; i--)
       {
           for(int j=i; j>=1; j--)
           {
               String squared = (int)Math.pow(j, 2) + " ";
               int spaces = 4-squared.length();
               System.out.print(squared);
               for(int k=spaces; k>0; k--)
               System.out.print(" ");
           }
           System.out.println();
       }
   }
}
