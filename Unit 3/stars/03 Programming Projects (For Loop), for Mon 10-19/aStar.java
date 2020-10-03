
/**
 * Write a description of class aStar here.
 * 
 *  Will Dickinson
 * 10/20/15
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
