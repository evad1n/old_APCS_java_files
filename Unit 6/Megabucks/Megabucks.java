
/**
 * Write a description of class Megabucks here.
 * 
 * Will D.
 * 1/12/16
 * This class contains the body of the megabucks program. It contains:
 * userNumbers() to get user input
 * drawNumbers() to generate random number lottery numbers
 * update() to update frequencies and winners
 * getWinners() to print winners and number of winners per category
 * getFrequencies() to print frequencies of the random numbers and the average frequency
 * toString() to format winning numbers
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Megabucks
{
    Scanner scan = new Scanner(System.in);
    
    private static ArrayList<Integer> winNumbers = new ArrayList<Integer>();
    private ArrayList<Integer> drawing = new ArrayList<Integer>();
    private static ArrayList<Double> winners = new ArrayList<Double>();
    private static ArrayList<Double> winType = new ArrayList<Double>();
    private static int[] frequencies = new int[42];
    private static int[] userFrequencies = new int[6];
    private static int[] winnerCount = new int[8];
    private static boolean win = false, end = false;
    private static double week = 1;
    private static int winnings = 0;
    
    public static boolean JACKPOT; //Only used for finding jackpot                                                 
    
    public Megabucks ()
    {
    }
    //Get winning numbers for the user
    public void userNumbers ()
    {
        int userChoice = 0;
        System.out.println("Welcome to Megabucks, the Tri-State jackpot!");
        System.out.println("Would you like to select your winning numbers manually or using the \nEasy Pick automated selection?");
        System.out.println("Enter [0] for manual selection and [1] for Easy Pick selection.");
        userChoice = scan.nextInt();
        //Manual selection of winning numbers
        if(userChoice == 0)
        {
            System.out.println("Enter your 6 winning numbers (1-42). There cannot be any duplicates.");
            System.out.println("Enter your first number");
            winNumbers.add(0,scan.nextInt());
            while(winNumbers.get(0).intValue() > 42 || winNumbers.get(0).intValue() < 1)
                {
                    winNumbers.remove(0);
                    System.out.println("That is not a valid number. Make sure it is between 1 and 42 inclusive. \nPlease enter your number again.");
                    winNumbers.add(0,scan.nextInt());
                }
            for(int i = 1; i < 6; i++)
            {
                if(i<5)
                    System.out.println("Enter your next number");
                else
                    System.out.println("Enter your final number");
                winNumbers.add(i,scan.nextInt());
                for(int j = 0; j < i; j++)
                {
                    while((winNumbers.get(i).intValue() == winNumbers.get(j).intValue()) || winNumbers.get(i).intValue() > 42 || winNumbers.get(i).intValue() < 1)
                    {
                        winNumbers.remove(i);
                        System.out.println("That is not a valid number. Make sure it is between 1 and 42 inclusive. \nThere cannot be any duplicates. Please enter your number again.");
                        winNumbers.add(i,scan.nextInt());
                    }
                }
            }
        }
        //Easy Pick (EP) option to automatically select 6 winning numbers
        if(userChoice == 1)
        {
            for(int i = 0; i < 6; i++)
            {
                winNumbers.add(i,(int)((Math.random()*42)+1));
                for(int j = 0; j < i; j++)
                {
                    while(winNumbers.get(i).intValue() == winNumbers.get(j).intValue())
                    {
                        winNumbers.remove(i);
                        winNumbers.add(i,(int)((Math.random()*42)+1));
                    }
                }
            }
        }
        System.out.println();
    }
    
    public boolean drawNumbers ()
    {
        boolean winWeek = false;
        
        week++;
        
        for(int i = 0; i < 7; i++)
        {
            drawing.add(i,(int)((Math.random()*42)+1));
            for(int j = 0; j < i; j++)
            {
                while(drawing.get(i).intValue() == drawing.get(j).intValue())
                {
                    drawing.remove(i);
                    drawing.add(i,(int)((Math.random()*42)+1));
                }
            }
            if(i <6)
                System.out.print(drawing.get(i).intValue() + " ");
            else
                System.out.println("BONUS: " + drawing.get(i).intValue());
        }
        winWeek = update();
        if(winWeek)
        {
            System.out.println("\\          /  |  |\\   |  |\\   |  |-----  |--\\     ");
            System.out.println(" \\        /   |  | \\  |  | \\  |  |_____  |__/     ");
            System.out.println("  \\  /\\  /    |  |  \\ |  |  \\ |  |       |  \\     ");
            System.out.println("   \\/  \\/     |  |   \\|  |   \\|  |-----  |   \\    ");
        }
        return winWeek;
    }
    
    private boolean update ()
    {
        int[] original = new int[6];
        int x = 0;
        boolean BONUS = false;
        
        win = false;
        
        for(int i = 0; i < 6; i++)
        {
            original[i] = userFrequencies[i];
        }
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                if(drawing.get(i).intValue() == winNumbers.get(j).intValue())
                {
                    userFrequencies[j]++;
                }
            }
        }
        for(int i = 0; i < 7; i++)
        {
            for(int j = 1; j < 43; j++)
            {
                if(drawing.get(i).intValue() == j)
                {
                    frequencies[j-1]++;
                }
            }
        }
        
        //***************************************************************************
        //Check for win and win type
        //***************************************************************************
        for(int i = 0; i < 6; i++)
        {
            if(original[i]+1 == userFrequencies[i])
            {
                x++;
            }
            if(winNumbers.get(i).intValue()==drawing.get(6).intValue())
            {
                x--;
                BONUS = true;
            }
            else
                BONUS = false;
        }
        if(x==6)
        {
            win = true;
            winners.add((Double)(week/2));
            winType.add(6.0);
            winnings+=1000000;
            winnerCount[7]++;
            JACKPOT = true;
        }
        else if(x==5 && BONUS)
        {
            win = true;
            winners.add((Double)(week/2));
            winType.add(5.5);
            winnings+=10000;
            winnerCount[6]++;
        }
        else if(x==5)
        {
            win = true;
            winners.add((Double)(week/2));
            winType.add(5.0);
            winnings+=1000;
            winnerCount[5]++;
        }
        else if(x==4 && BONUS)
        {
            win = true;
            winners.add((Double)(week/2));
            winType.add(4.5);
            winnings+=50;
            winnerCount[4]++;
        }
        else if(x==4)
        {
            win = true;
            winners.add((Double)(week/2));
            winType.add(4.0);
            winnings+=40;
            winnerCount[3]++;
        }
        else if(x==3 && BONUS)
        {
            win = true;
            winners.add((Double)(week/2));
            winType.add(3.5);
            winnings+=5;
            winnerCount[2]++;
        }
        else if(x==2 && BONUS)
        {
            win = true;
            winners.add((Double)(week/2));
            winType.add(2.5);
            winnings+=2;
            winnerCount[1]++;
        }
        else if(x==3)
        {
            win = true;
            winners.add((Double)(week/2));
            winType.add(3.0);
            winnings+=1;
            winnerCount[0]++;
        }
        return win;
    }
    //Prints each week you won and the type of win you got. Also counts how many wins for each type
    public void getWinners ()
    {
        System.out.println("_W_I_N_N_I_N_G_S_");
        if(winners.size()>0)
        {
            for(int i = 0; i < winners.size(); i++)
            {
                if(winners.get(i).doubleValue() > (int)winners.get(i).doubleValue())
                    System.out.print("During the end of week " + (int)winners.get(i).doubleValue());
                else
                    System.out.print("During the start of week " + (int)winners.get(i).doubleValue());
                if(winType.get(i).doubleValue() == 6.0)
                {
                    System.out.println(" you won the JACKPOT!");
                }
                else if(winType.get(i).doubleValue() == 5.5)
                {
                    System.out.println(" you won the $10000 cash prize for 5 matching numbers and the bonus!");
                }
                else if(winType.get(i).doubleValue() == 5.0)
                {
                    System.out.println(" you won the $1000 cash prize for 5 matching numbers!");
                }
                else if(winType.get(i).doubleValue() == 4.5)
                {
                    System.out.println(" you won the $50 cash prize for 4 matching numbers and the bonus!");
                }
                else if(winType.get(i).doubleValue() == 4.0)
                {
                    System.out.println(" you won the $40 cash prize for 4 matching numbers!");
                }
                else if(winType.get(i).doubleValue() == 3.5)
                {
                    System.out.println(" you won the $5 cash prize for 3 matching numbers and the bonus!");
                }
                else if(winType.get(i).doubleValue() == 2.5)
                {
                    System.out.println(" you won the $2 cash prize for 2 matching numbers and the bonus!");
                }
                else if(winType.get(i).doubleValue() == 3.0)
                {
                    System.out.println(" you won the $1 free ticket for 3 matching numbers!");
                }
            }
        }
        else
        {
            System.out.println("Sorry, looks like you were out of luck and didn't win. Come back next year and try again!\n");
        }
        System.out.println();
        
        System.out.println("You won the free $1 ticket " + winnerCount[0] + " times");
        System.out.println("You won the $2 cash prize " + winnerCount[1] + " times");
        System.out.println("You won the $5 cash prize " + winnerCount[2] + " times");
        System.out.println("You won the $40 cash prize " + winnerCount[3] + " times");
        System.out.println("You won the $50 cash prize " + winnerCount[4] + " times");
        System.out.println("You won the $1000 cash prize " + winnerCount[5] + " times");
        System.out.println("You won the $10000 cash prize " + winnerCount[6] + " times");
        System.out.println("You won the jackpot " + winnerCount[7] + " times");
        System.out.println();
        
        System.out.println("The total money won is $" + winnings);
        System.out.println();
    }
    //Prints out the frequencies for each number
    public static void getFrequencies ()
    {
        int average = 0;
        System.out.println("_F_R_E_Q_U_E_N_C_I_E_S_");
        System.out.println("The frequencies for your winning numbers are:");
        for(int i = 0; i < 6; i++)
        {
            System.out.print(winNumbers.get(i).intValue() + ": " + userFrequencies[i] + "\n");
        }
        
        System.out.println("\nThe frequencies for all numbers are:");
        for(int i = 0; i < 42; i++)
        {
            System.out.print(i+1 + ": " + frequencies[i] + "\n");
        }
        
        for(int i = 0; i < frequencies.length; i++)
        {
            average+=frequencies[i];
        }
        average = Math.round(average/frequencies.length);
        System.out.println("\nThe average frequency is " + average);
    }
    //Prints out the winning numbers
    public String toString ()
    {
        String thing = "";
        for(int i = 0; i < 6; i++)
        {
            thing = thing + "" + winNumbers.get(i).intValue() + " ";
        }
        return thing;
    }
}
