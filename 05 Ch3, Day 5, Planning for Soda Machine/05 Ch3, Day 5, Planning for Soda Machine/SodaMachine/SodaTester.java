
/**
 * Write a description of class SodaTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class SodaTester
{
    public static void main (String[] args)
    {
        SodaMachine soda = new SodaMachine();
        soda.getTemp();
        soda.tellPrice();
        soda.getFlavor();
        soda.getMoney();
        soda.makeChange();
        soda.formatChange();
    }
}
