
/**
 * Write a description of class go here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class go
{
    private static Scanner scan = new Scanner(System.in);
    private static retard player;
    private static boolean loss = false;
    
    public static void main (String[] args)
    {
        String input = "";
        System.out.println("Welcome to Rape Simulator 2016");
        System.out.println("What is your name?");
        player = new retard(10, scan.nextLine());
        player.hello();
        System.out.println("The goal of this game is to successfully rape as many victims as possible. \nEvery time you rape someone you have a chance to be successful. \nThe higher your IQ, the higher your rape chance.");
        System.out.println("You can raise your IQ through various activites provided in the game.");
        //timer(7);
        System.out.println("Oh look a victim - um I mean a person!");
        retard npc = new retard(0,"Fred");
        System.out.println("Will you rape them?(y/n)");
        if(scan.nextLine().equals("y"))
        {
            player.rape(npc);
            timer(2);
            System.out.println("Oh no you didn't have enough IQ! \nHere have some free IQ!");
            player.raiseIQ(5);
            System.out.println("Your IQ is now " + player.getIQ());
            timer(2);
        }
        else
        {
            lose();
        }
        while(!loss)
        {
            System.out.println("Now what will you do?");
            options();
        }
    }
    
    public static void rapeScenario(String name)
    {
        System.out.println("Oh look another victim!");
        retard npc = new retard(0,name);
        System.out.println("Will you rape them?(y/n)");
        if(scan.nextLine().equals("y"))
        {
            player.rape(npc);
            player.raiseIQ(5);
            System.out.println("Your IQ is now " + player.getIQ());
        }
        else
        {
            lose();
        }
    }
    
    public static void options()
    {
        int answer;
        System.out.println("[0] Check your baby count");
        System.out.println("[1] Read a book (IQ+?)");
        System.out.println("[2] Sexual Education Class(IQ+20)");
        System.out.println("[3] Masturbate(IQ-5)");
        System.out.println("[4] Look for a victim");
        System.out.println("[5] Sleep");
        answer = scan.nextInt();
        if(player.getActions() > 2)
        {
            System.out.println("You don't have enough energy!");
            options();
        }
        else if(answer == 0)
        {
            player.getBabies();
        }
        else if(answer == 1)
        {
            player.book();
        }
        else if(answer == 2)
        {
            player.sexEd();
        }
        else if(answer == 3)
        {
            player.masturbate();
        }
        else if(answer == 4)
        {
            rapeScenario("fred");
        }
        else if(answer == 5)
        {
            player.sleep();
        }
    }
    
    public static void timer(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch(Exception e) {
            System.exit(0);
        }
    }
    
    public static void lose()
    {
        System.out.println("Oh no the cops shot you!");
        System.out.println("YOU LOSE!");
        System.exit(0);
    }
}
