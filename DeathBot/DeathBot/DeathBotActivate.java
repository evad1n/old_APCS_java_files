import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class DeathBotActivate
{

    /**
     * Create a Magpie, give it user input, and print its replies.
     */
    public static void main(String[] args)
    {
        DeathBot death = new DeathBot();
        
        System.out.println (death.getGreeting());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();
        
        while (death.findKeyword(statement, "bye")<0
            && death.findKeyword(statement, "kill yourself")<0
            && death.findKeyword(statement, "cya")<0)
        {
            System.out.println (death.getResponse(statement));
            statement = in.nextLine();
        }
    }

}
