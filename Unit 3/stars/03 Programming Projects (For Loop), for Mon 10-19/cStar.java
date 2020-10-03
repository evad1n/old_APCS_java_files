
/**
 * Write a description of class cStar here.
 * 
 *  Will Dickinson
 * 10/20/15
 */
public class cStar
{
   public static void main (String[] args)
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
}
