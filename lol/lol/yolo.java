
/**
 * Write a description of class yolo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class yolo
{
    public static void main(String[] args)
    {
     String name;
     int i;
     double w = 1000000 * 0.1;
     boolean done = false;
     Scanner nameScanner = new Scanner( System.in );
     System.out.println("What is your name?");
     name = nameScanner.nextLine();
     System.out.println("Now calculating whether I like you..");
       new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                int i = 0;
                while( i < w )
    {
        boolean done = false;
        System.out.println("Calculating...");
        i++ ;
        if( i == w )
        {
            done = true;
            System.out.println("I love " + name);
        }
    }
    if (done == true)
    {
    new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                System.out.println("JK, nobody likes " + name);
            }
        }, 
        4000 
);
    }    
            }
        }, 
        2000 
);

    }
}
