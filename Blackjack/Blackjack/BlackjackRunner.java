
/**
 * Write a description of class BlackjackRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class BlackjackRunner
{
    public static void main (String[] args)
    {
        String another = "y", hit;
        int userTotal;
        Scanner scan = new Scanner (System.in);
        System.out.println("Welcome to Blackjack.");
        Blackjack game = new Blackjack();
        while (another.equalsIgnoreCase("y"))
        {
            game.bet();
            userTotal = game.initialize();
            if(userTotal == 21)
            {
               System.out.println("You got Blackjack!");
               hit = "n";
            }
            else
            {
               System.out.println("Do you want to hit?(y/n)");
               hit = scan.nextLine();
            }   
            while(hit.equalsIgnoreCase("y"))
            {
                userTotal = game.hit(userTotal);
                if(userTotal < 21)
                {
                    System.out.println("Do you want to hit again?(y/n)");
                    hit = scan.nextLine();
                }
                else if(userTotal == 21)
                {
                    System.out.println("You got Blackjack!");
                    hit = "n";
                }
                else
                {
                    hit = "n";
                    System.out.println("You busted!");
                }
            }
            game.computerPlay();
            game.getWinner();
            if((game.getMoney() > 0))
            {
                System.out.println("Do you want to play again?(y/n)");
                another = scan.nextLine();
            }
            else
            {
                System.out.println("You ran out of money!");
                another = "n";
            }
        }
    }
}
