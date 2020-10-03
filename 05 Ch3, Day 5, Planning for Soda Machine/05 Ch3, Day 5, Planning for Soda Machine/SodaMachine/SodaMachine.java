
/**
 * Write a description of class SodaMachine here.
 * 
 * @author (your name) 
 *
 *10/6/15 (marsh) made makeChange, getTemp and tellPrice.
 *10/6/15 (dickinson) removed unnecessary stuff from main, created getMoney.
 *10/7/15 (marsh) created formatChange
 *10/7/15 (dickinson) worked on formatChange
 *10/8/15 (marsh) finished formatChange
 *10/8/15 (dickinson) finished formatChange
 *
 *@version (a version number or a date)
 */

import java.util.Scanner;
import java.text.NumberFormat;

public class SodaMachine
{
    private int temp;
    private double price;
    private boolean needChange;
    private double money;
    private double change;
    private boolean getSoda;
    private int quarter;
    private int nickel;
    private int dime;
    private int penny;
    private String changeMessage;
    private String quarterMessage;
    private String dimeMessage;
    private String nickelMessage;
    private String pennyMessage;
    private boolean noQuarter;
    private boolean noDime;
    private boolean noNickel;
    private boolean noPenny;
    private String flavor;
    private double flavorNum;
    
    Scanner scan = new Scanner (System.in);
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    
    //Creates the object SodaMachine
    public SodaMachine()
    {
    }
    //Creates a random temperature from 30-130
    public int getTemp()
    {
        System.out.println("Welcome to the Soda Machine place.");
        temp = (int)((Math.random()*60)+40);
        return temp;
    }
    //Determines price based off of temperature
    public double tellPrice()
    {
        if (temp < 50)
        {
            price = 0.50;
        }
        else
        {
            if(temp >= 50 && temp <= 60)
            {
                price = 0.55;
            }
            if(temp >= 61 && temp <= 65)
            {
                price = 0.60;
            }
            if(temp >= 66 && temp <= 70)
            {
                price = 0.65;
            }
            if(temp >= 71 && temp <= 75)
            {
                price = 0.75;
            }
            if(temp >= 76 && temp <= 80)
            {
                price = 0.80;
            }
            if(temp >= 81 && temp <= 85)
            {
                price = 0.85;
            }
            if(temp >= 86 && temp <= 90)
            {
                price = 0.90;
            }
            if(temp > 90)
            {
                price = 1.00;
            }
        }
        return price;
    }
    public String getFlavor()
    {
        System.out.println("Please select a flavor:");
        System.out.println("[0]Mountain Dew\n[1]Dr. Pepper\n[2]Gatorade\n[3]Dasani\n[4]Coke\n[5]Pepsi\n[6]Vitamin Water\n[7]Lemonade");
        flavorNum = scan.nextDouble();
        if(flavorNum == 0)
        {
            flavor = "Mountain Dew";
        }
        else
        {
            if(flavorNum == 1)
            {
                flavor = "Dr. Pepper";
            }
            else if(flavorNum == 2)
            {
                flavor = "Gatorade";
            }
            else if(flavorNum == 3)
            {
                flavor = "Dasani";
            }
            else if(flavorNum == 4)
            {
                flavor = "Coke";
            }
            else if(flavorNum == 5)
            {
                flavor = "Pepsi";
            }
            else if(flavorNum == 6)
            {
                flavor = "Vitamin Water";
            }
            else if(flavorNum == 7)
            {
                flavor = "Lemonade";
            }
            else
            {
                flavor = "blood";
            }
        }
        return flavor;
    }
    //Prompts the user for money and decides if you have enough money
    public boolean getMoney()
    {
        System.out.println("Temperature: " + temp + "   \tPrice: " + (fmt.format(price)));
        System.out.println("How much money do you have?");
        money = scan.nextDouble();
        if (money > price)
        {
            needChange = true;
            getSoda = true;
        }
        else
        {
            if(money == price)
            {
                needChange = false;
                getSoda = true;
            }    
            else
            {
                System.out.println("You have insufficient funds.");
                getSoda = false;
            }
        }
        return needChange;
    }
    //Calculates change and prints it out to the user
    public double makeChange()
    {
        if (needChange && getSoda)
        {
            change = money - price;
            
            System.out.println("Here is your change: " + (fmt.format(change)));
            System.out.println("Enjoy your " + flavor + "!");
        }
        else
        {
            change = 0;
        }
        return change;
    }
    //Formats change into quarters, nickels, dimes, and pennies
    public String formatChange()
    {
        change = Math.round(change * 100);
        quarter = (int)change/25;
        change -= quarter * 25;
        dime = (int)change/10;
        change -= dime * 10;
        nickel = (int)change/5;
        change -= nickel * 5;
        penny = (int)change/1;
        
        if (quarter<1)
        {
            quarterMessage = "";
            noQuarter = true;
        }
        else
        {
            if(quarter == 1)
            {
                quarterMessage = quarter + " quarter";
            }
            else
            {
                quarterMessage = quarter + " quarters";
            }
        }
                if (dime < 1)
        {
            dimeMessage = "";
            noDime = true;
        }
        else
        {
            if(dime == 1)
            {
                dimeMessage = dime + " dime";
            }
            else
            {
                dimeMessage = dime + " dimes";
            }
        }
                if (nickel < 1)
        {
            nickelMessage = "";
            noNickel = true;
        }
        else
        {
            if(nickel == 1)
            {
                nickelMessage = nickel + " nickel";
            }
            else
            {
                nickelMessage = nickel + " nickels";
            }
        }
                if (penny < 1)
        {
            pennyMessage = "";
            noPenny = true;
        }
        else
        {
            if(penny == 1)
            {
                pennyMessage = penny + " penny";
            }
            else
            {
                pennyMessage = penny + " pennies";
            }
        }
        
        if(noQuarter)
        {
            if(noDime)
            {
                if(noNickel)
                {
                    if(noPenny)
                    {
                        changeMessage = "You recieved no change";
                    }
                    else
                    {
                        changeMessage = "You recieved " + pennyMessage;
                    }
                }
                else
                {
                    if(noPenny)
                    {
                        changeMessage = "You recieved " + nickelMessage;
                    }
                    else
                    {
                        changeMessage = "You recieved " + nickelMessage + " and " + pennyMessage;
                    }
                }
            }
            else
            {
                if(noNickel)
                {
                    if(noPenny)
                    {
                        changeMessage = "You recieved " + dimeMessage;
                    }
                    else
                    {
                        changeMessage = "You recieved " + dimeMessage + " and " + pennyMessage;
                    }
                }
                else
                {
                    if(noPenny)
                    {
                        changeMessage = "You recieved " + dimeMessage + " and " + nickelMessage;
                    }
                    else
                    {
                        changeMessage = "You recieved " + dimeMessage + ", " + nickelMessage + "and " + pennyMessage;
                    }
                }
            }
        }
        else
        {
             if(noDime)
            {
                if(noNickel)
                {
                    if(noPenny)
                    {
                        changeMessage = "You recieved " + quarterMessage ;
                    }
                    else
                    {
                        changeMessage = "You recieved " + quarterMessage + " and " + pennyMessage;
                    }
                }
                else
                {
                    if(noPenny)
                    {
                        changeMessage = "You recieved " + quarterMessage + " and " + nickelMessage;
                    }
                    else
                    {
                        changeMessage = "You recieved " + quarterMessage + ", " + nickelMessage + " and " + pennyMessage;
                    }
                }
            }
            else
            {
                if(noNickel)
                {
                    if(noPenny)
                    {
                        changeMessage = "You recieved " + quarterMessage + " and " + dimeMessage;
                    }
                    else
                    {
                        changeMessage = "You recieved " + quarterMessage + ", " + dimeMessage + " and " + pennyMessage;
                    }
                }
                else
                {
                    if(noPenny)
                    {
                        changeMessage = "You recieved " + quarterMessage + ", " + dimeMessage + " and " + nickelMessage;
                    }
                    else
                    {
                        changeMessage = "You recieved " + quarterMessage + ", " + dimeMessage + ", " + nickelMessage + " and " + pennyMessage;
                    }
                }
            }
        }
        System.out.println(changeMessage);
        return changeMessage;
    }

}
