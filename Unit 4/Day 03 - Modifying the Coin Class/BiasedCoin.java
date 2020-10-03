/*
 * 11/16/15 Will Dickinson
 * 11/17/15 Added bias visibility
 */

import java.util.Random;

public class BiasedCoin
{
   private final int HEADS = 0;
   private final int TAILS = 1;
   
   private double bias;

   private int face;

   //-----------------------------------------------------------------
   //  Sets up the coin by flipping it initially.
   //-----------------------------------------------------------------
   public BiasedCoin ()
   {
      bias = 0.5;
      flip();
   }
   
   
   //-----------------------------------------------------------------
   //  Sets up the coin with a bias.
   //-----------------------------------------------------------------
   public BiasedCoin (double theBias)
   {
      if(0<=bias && bias<=1)
      bias = theBias;
      else
      bias = 0.5;
      flip();
   }

   //-----------------------------------------------------------------
   //  Flips the coin by randomly choosing a face value.
   //-----------------------------------------------------------------
   public void flip ()
   {
      if(Math.random() < bias)
        face = HEADS;
      else
        face = TAILS;
   }
  

   //-----------------------------------------------------------------
   //  Returns true if the current face of the coin is heads.
   //-----------------------------------------------------------------
   public boolean isHeads ()
   {
      return (face == HEADS);
   }

   //-----------------------------------------------------------------
   //  Returns the current face of the coin as a string.
   //-----------------------------------------------------------------
   @Override
   public String toString()
   {
      String faceName;
      if (face == HEADS)
         faceName = "Heads";
      else
         faceName = "Tails";

      return faceName;
   }
   
   public String toStringBias()
   {
       String biasName;
       biasName = "" + bias;
       return biasName;
   }
}