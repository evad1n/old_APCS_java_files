
/**
 * Write a description of class dStar here.
 * 
 *  Will Dickinson
 * 10/20/15
 */
public class dStar
{
   public static void main (String[] args)
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
}
