
/**
 * Write a description of class Runner here.
 * 
 * Will D.
 * 1/12/2016
 * This class runs the megabucks program and calls all the methods while looping through 52 weeks of lottery numbers.
 */
public class Runner
{
    public static void main (String[] boop)
    {
        Megabucks lottery = new Megabucks();
        lottery.userNumbers();
        System.out.println("Your winning numbers are " + lottery + "\n");
        for(int i = 0; i < 104; i++)
        {
            if(i % 2 == 0)
            {
                System.out.println("The winning numbers for the start of week " + (i+2)/2 + " are: ");
                lottery.drawNumbers();
            }
            else
            {
                System.out.println("The winning numbers for the end of week " + (i+2)/2 + " are: ");
                lottery.drawNumbers();
            }
            System.out.println("Your winning numbers are " + lottery + "\n");
        }
        lottery.getWinners();
        lottery.getFrequencies();
    }
}
