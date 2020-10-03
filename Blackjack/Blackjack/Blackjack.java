
/**
 * Write a description of class Blackjack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.text.NumberFormat;

public class Blackjack
{
    public int random, card, computerHit, hitCard, roll, userTotal, userTotalAce, computerTotal, computerTotalAce, cardValue, end, userCard1, userCard2, computerCard1, computerCard2;
    public double bet, money = 100000;
    public boolean aceScenario;
    public String winner, card1, card2, card3, cardFace;
    Scanner scan = new Scanner (System.in);
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    
    public Blackjack ()
    {
    }
    
    public double bet()
    {
        System.out.println("You have " + fmt.format(money) + ". How much do you want to bet?");
        bet = scan.nextDouble();
        while(bet>money)
        {
            System.out.println("You can only bet an amount equal to or less than your current money.");
            System.out.println("Please enter a valid bet.");
            bet = scan.nextDouble();
        }
        return bet;
    }
    
    public int initialize()
    {
        userCard1 = getCard();
        userCard2 = getCard();
        computerCard1 = getCard();
        computerCard2 = getCard();
        card1 = getCardFace(userCard1);
        card2 = getCardFace(userCard2);
        userTotal = userCard1 + userCard2;
        computerTotal = computerCard1 + computerCard2;
        System.out.println("You are dealt a hand");
        
        if(computerCard1 == 1 && computerCard2 != 1)
            computerTotalAce = computerTotal + 10;
        else if(computerCard1 == 1 && computerCard2 == 1)    
            computerTotalAce = computerTotal + 10;
        else if(computerCard1 != 1 && computerCard2 == 1)
            computerTotalAce = computerTotal + 10;
        else
            computerTotalAce = 0;
            
        if(userCard1 == 1 && userCard2 != 1)
            userTotalAce = userTotal + 10;
        else if(userCard1 == 1 && userCard2 == 1)    
            userTotalAce = userTotal + 10;
        else if(userCard1 != 1 && userCard2 == 1)
            userTotalAce = userTotal + 10;
        else
            userTotalAce = 0;
            
        System.out.println("You got a" + card1 + " and a" + card2 + ".");
        if(userTotalAce == 0)
            System.out.println("Your total is " + userTotal + ".");
        else
            System.out.println("Your total is " + userTotal + " (ace as 1) or " + userTotalAce + " (ace as 11).");
        if(userTotalAce == 21)
            userTotal = userTotalAce;
        return userTotal;
    }
    
    public int getCard()
    {
        card = (int)((Math.random()*13)+1);
        if(card == 1)
            cardValue = 1;
        else if(card == 2)
            cardValue = 2;
        else if(card == 3)
            cardValue = 3;
        else if(card == 4)
            cardValue = 4;
        else if(card == 5)
            cardValue = 5;
        else if(card == 6)
            cardValue = 6;
        else if(card == 7)
            cardValue = 7;
        else if(card == 8)
            cardValue = 8;
        else if(card == 9)
            cardValue = 9;
        else if(card == 10)
            cardValue = 10;
        else if(card == 11)
            cardValue = 10;
        else if(card == 12)
            cardValue = 10;
        else if(card == 13)
            cardValue = 10;
        return cardValue;
    }
    
    public String getCardFace(int card)
    {
        if(card == 1)
            cardFace = "n Ace";
        else if(card == 2)
            cardFace = " 2";
        else if(card == 3)
            cardFace = " 3";
        else if(card == 4)
            cardFace = " 4";
        else if(card == 5)
            cardFace = " 5";
        else if(card == 6)
            cardFace = " 6";
        else if(card == 7)
            cardFace = " 7";
        else if(card == 8)
            cardFace = "n 8";
        else if(card == 9)
            cardFace = " 9";
        else if(card == 10)
        {
            random = (int)(Math.random()*4);
            if(random == 0)
                cardFace = " 10";
            else if(random == 1)
                cardFace = " Jack";
            else if(card == 2)
                cardFace = " Queen";
            else
                cardFace = " King";
        }
        return cardFace;
    }
    
    public int hit(int start)
    {
        if(userTotalAce == 21)
        {
            userTotal = userTotalAce;
        }
        else
        {
            hitCard = getCard();
            if(userTotalAce + hitCard == 21)
            {
                userTotal = userTotalAce + hitCard;
            }
            else if(hitCard == 1)
            {
                userTotalAce = userTotal + 11;
                userTotal += 1;
            }
            else
            {
                userTotalAce += hitCard;
                userTotal += hitCard;
            }
            card3 = getCardFace(hitCard);
            if(userTotalAce < 22 && (hitCard == 1 || userCard1 == 1 || userCard2 == 1))
            {
                System.out.println("You got a" + card3);
                System.out.println("Now your total is " + userTotal + " (ace as 1) or " + userTotalAce + " (ace as 11)");
            }
            else
            {
                System.out.println("You got a" + card3);
                System.out.println("Now your total is " + userTotal + ".");
            }
            if(userTotalAce == 21)
            {
                userTotal = userTotalAce;
            }
        }
        return userTotal;
    }
    
    public int computerPlay()
    {
        if(computerTotalAce <= 21 && computerTotalAce >= 18)
        {
            aceScenario = true;
            computerTotal = computerTotalAce;
        }
        else
        {
            aceScenario = false;
        }
        while (computerTotal <= 17 && !aceScenario)
        {
            computerHit = getCard();
            if(computerTotalAce + computerHit == 21)
            {
                computerTotal = computerTotalAce + computerHit;
            }
            else if(hitCard == 1)
            {
                computerTotalAce = computerTotal + 11;
                computerTotal += 1;
            }
            else
            {
                computerTotalAce += computerHit;
                computerTotal += computerHit;
            }
            if(computerTotalAce <= 21 && computerTotalAce >= 18)
            {
                aceScenario = true;
                computerTotal = computerTotalAce;
            }
            else
            {
                aceScenario = false;
            }
        }
        return computerTotal;
    }
    
    public String getWinner()
    {
        if(userTotalAce < 22 && userTotalAce > userTotal)
        {
            userTotal = userTotalAce;
        }
        System.out.println("You had " + userTotal + " and the computer had " + computerTotal + ".");
        if(userTotal == computerTotal)
            winner = "It's a tie, the computer wins!";
        else if(userTotal > computerTotal && userTotal < 22)
            winner = "You win!";
        else if(computerTotal > userTotal && computerTotal == 21)
            winner = "The computer had Blackjack!. You lose!";
        else if(computerTotal > userTotal && computerTotal < 22)
            winner = "The computer wins!";            
        else if(computerTotal > 21 && userTotal < 22)
            winner = "You win!";
        else if(userTotal > 21 && computerTotal < 22)
            winner = "The computer wins!";
        else if(userTotal > 21 && computerTotal > 21)
            winner = "You both bust; the computer wins!";
        System.out.println(winner);
        return winner;
    }
    
    public double getMoney()
    {
        if(winner.equals("You win!"))
            money += bet;
        else
            money -= bet;
        System.out.println("You now have " + fmt.format(money) + ".");
        return money;
    }
}
