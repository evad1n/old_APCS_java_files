
/**
 * Write a description of class dStar2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dStar2
{
   public static void main (String[] args)
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
}
