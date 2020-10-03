
/**
 * Write a description of class aStar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class aStar
{
   public static void main (String[] args)
   {
      final int MAX_ROWS = 0;

      for (int row = 10; row >= MAX_ROWS; row--)
      {
         for (int star = row; star > 0; star--)
            System.out.print ("*");

         System.out.println();
      }
   }
}
