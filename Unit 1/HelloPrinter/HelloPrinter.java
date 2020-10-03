
/**
 * HelloPrinter.
 * This is our first chance to "play" with BlueJ, comments, strings, and, eventually, 
 * strange operations.
 * 
 * @Corricelli 
 * @9/4/12
 */
public class HelloPrinter //defines class
{
   public static void main(String [] args) 
   {
       int x = 3;
       int y = 7;
       double d = 7.56;
       int z = (x + y);
       int w = (z * x * y);
       
       String bye = "Goodbye";
       System.out.println("Hello World!");
       System.out.println("Answer is " + 3);
       System.out.println("Answer is " + 3 + 2);
       System.out.println("Answer is " + (3 + 2));
       System.out.println(3 + 2 + " is Answer");
       System.out.println(d + " is a decimal");
       System.out.println(bye);//bye stores the string "Goodbye"
       System.out.println("x + y = z");
       System.out.println(x + " + " + y + " = " + z);
       System.out.println("w = x * y * z");
       System.out.println("What is w?");
       System.out.println(w);
       System.out.println("Hello\b\b\bHello");
       System.out.println("Hello\tHello");
       System.out.println("\t\b\bXXXXX\n\tX\tX\n\b\b\b\b\b\b\b\b((\b\bo\b\bo\b\b))\n\t|\b\b\b\\/\b\b|\n\t|\b\b===\b\b|\n\t\b\b-----");
    }
}

/**
 * HelloPrinter.main({ });
Hello World!
Answer is 3
Answer is 32
Answer is 5
5 is Answer
7.56 is a decimal
Goodbye
x + y = z
3 + 7 = 10
w = x * y * z
What is w?
210
HelloHello
Hello	Hello
	XXXXX
	X	   X 
((oo))
	|\/|
	|===|
	-----


 */
