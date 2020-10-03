
/**
 * Write a description of class retard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class retard
{
    private static int IQ;
    private int babies = 0;
    private int actions = 0;
    private String name;
    
    public retard(int iq, String nombre)
    {
        IQ = iq;
        name = nombre;
    }
    
    public void hello()
    {
        System.out.println("My name is " + name + " and I am a retard. My IQ is " + IQ);
    }
    
    public void rape(retard other)
    {
        int r = (int)(Math.random()*this.IQ);
        System.out.println(this.name + " rapes " + other.name);
        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {
            System.exit(0);
        }
        if(r < (5 + this.IQ/2))
        {
            System.out.println("Rape unsuccessful");
        }
        else
        {
            System.out.println(other.name + " is now pregnant. Rape successful!");
            babies++;
        }
    }
    
    public void book()
    {
        int r = (int)(Math.random()*5);
        System.out.println("You just read a book");
        if(r == 0)
        {
            System.out.println("It was about cooking!");
            raiseIQ(5);
        }
        else if(r == 1)
        {
            System.out.println("It was about dinosaurs!");
            raiseIQ(10);
        }
        else if(r == 2)
        {
            System.out.println("It was the Magic Treehouse!");
            raiseIQ(3);
        }
        else if(r == 3)
        {
            System.out.println("It was about Donald Trump!");
            raiseIQ(-5);
        }
        else if(r == 4)
        {
            System.out.println("It was about Rocket Science!");
            raiseIQ(20);
        }
        actions++;
    }
    
    public void sexEd()
    {
        
        actions++;
    }
    
    public void sleep()
    {
        actions = 0;
    }
    
    public void masturbate()
    {
        System.out.println("Oh yeh that feels good! \nYour IQ decreased by 5!");
        actions++;
    }
    
    public static void raiseIQ(int iq)
    {
        IQ += iq;
        System.out.println("Your IQ increased by " + iq + "! \nYour IQ is now" + IQ);
    }
    
    public int getBabies()
    {
        return babies;
    }
    
    public int getActions()
    {
        return actions;
    }
    
    public int getIQ()
    {
        return IQ;
    }
}
