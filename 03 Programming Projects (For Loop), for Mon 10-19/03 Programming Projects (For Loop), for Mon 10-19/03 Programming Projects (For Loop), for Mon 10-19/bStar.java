
/**
 * Write a description of class bStar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bStar
{
   public static void main (String[] args)
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
}
