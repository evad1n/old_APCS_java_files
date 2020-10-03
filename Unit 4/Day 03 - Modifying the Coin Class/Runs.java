//**********************************************************************
// Runs.java
//
// 11/16/15 Will Dickinson
// 11/17/15 Added bias visibility
//
// Finds the length of the longest run of heads in 1000 flips of a coin.
//**********************************************************************


public class Runs
{
    public static void main (String[] args)
    {
        final int FLIPS = 100; // number of coin flips

        int currentRun = 0; // length of the current run of HEADS
        int maxRun = 0;     // length of the maximum run so far
        int temp = 0;

        // Create a coin object
        BiasedCoin aCoin = new BiasedCoin(0.75);

        // Flip the coin FLIPS times
        for (int i = 0; i < FLIPS; i++)
        {
            aCoin.flip();//flip the coin
            System.out.println("Coin flip " + (i+1) + 
                                " is: " + aCoin);
  
            // Update the run information
            if (aCoin.isHeads())
            {
                temp++;
                currentRun++;
                if (currentRun>maxRun)
                {
                    maxRun=currentRun;
                }
            }
            else
            {
                currentRun=0;
            }
        }

        System.out.println("Max run of heads is: " + maxRun);
        System.out.println("Number of heads is: " + temp);
        System.out.println("Number of tails is: " + (FLIPS-temp));
        System.out.println("The bias is: " + aCoin.toStringBias());
     }
}
