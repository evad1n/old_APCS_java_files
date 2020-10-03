
// ****************************************************************
// IntegerListTest.java
//
//Will Dickinson
//2/4/2016
//          
// ****************************************************************
import java.util.Scanner;

public class Extra_Credit
{
    public static IntegerArrayList list = new IntegerArrayList();
    public static Scanner scan = new Scanner(System.in);
    
    private static boolean sorted = false;
    private static String sortType = "";
    
    //-------------------------------------------------------
    // Create a list, then repeatedly print the menu and do what the
    // user asks until they quit
    //-------------------------------------------------------
    public static void main(String[] args)
    {
        printMenu();
        int choice = scan.nextInt();
        while (choice != 0)
        {
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
        }
        System.out.println("Bye!");
    }

    //-------------------------------------------------------
    // Do what the menu item calls for
    //-------------------------------------------------------
    public static void dispatch(int choice)
    {
        int loc;
        int oldVal, newVal;

        if (choice == 1)
        {   
            System.out.println("How big should the list be?");
            int size = scan.nextInt();
            list.randomFill(size);
        }
        else if (choice == 2)
        {
            list.selectionSort();
            sorted = true;
            sortType = "increasing";
        }
        else if (choice == 3)
        {
            System.out.print("Enter the value to look for: ");
            loc = list.search(scan.nextInt());
            if (loc != -1)
                System.out.println("Found at location " + loc);
            else
                System.out.println("Not in list");
        }
        else if (choice == 4)
        {
            list.print();
        }
        else if (choice == 5)
        {
            list.sortDecreasing();
            sorted = true;
            sortType = "decreasing";
        }
        else if (choice == 6)
        {
            System.out.println("Please enter a value to be replaced");
            oldVal = scan.nextInt();
            System.out.println("Please enter a value to replace it with");
            newVal = scan.nextInt();
            loc = list.search(oldVal);
            if(loc == -1)
            {
                System.out.println("That number is not in the list");
            }
            else
            {
                list.replaceFirst(newVal, loc);
            }
            
            sorted = false;
        }
        else if (choice == 7)
        {
            System.out.println("Please enter the value to be replaced");
            oldVal = scan.nextInt();
            System.out.println("Please enter a value to replace it with");
            newVal = scan.nextInt();
            loc = list.search(oldVal);
            if (loc == -1)
                System.out.println("Not in list");
            else
                list.replaceAll(oldVal, newVal);
                
            sorted = false;
        }
        else if(choice == 8)
        {
            if(sorted)
            {
                System.out.print("Enter the value to look for: ");
                loc = scan.nextInt();
                if (sortType.equals("increasing"))
                {
                    if(list.binarySearch(loc, "increasing") < 0)
                    {
                        System.out.println("This element is not in the list");
                    }
                    else
                    {
                        System.out.println("Found at location " + list.binarySearch(loc, "increasing"));
                    }
                }
                else
                {
                    if(list.binarySearch(loc, "decreasing") < 0)
                    {
                        System.out.println("This element is not in the list");
                    }
                    else
                    {
                        System.out.println("Found at location " + list.binarySearch(loc, "decreasing"));
                    }
                }
            }
            else
                System.out.println("This list is not sorted");
        }
        else if(choice == 9)
        {
            list.insertionSort();
            sorted = true;
            sortType = "increasing";
        }
        else
        {
            System.out.println("Sorry, invalid choice");
        }
    }

    //-------------------------------------------------------
    // Print the user's choices
    // You'll need to add more choices to accomplish this
    // lab.  Be sure to update these comments with your
    // modifications.
    //-------------------------------------------------------
    public static void printMenu()
    {
        System.out.println("\n   Menu   ");
        System.out.println("   ====");
        System.out.println("0: Quit");
        System.out.println("1: Create a new list (** do this first!! **)");
        System.out.println("2: Sort the list using selection sort(increasing order)");
        System.out.println("3: Find an element in the list using sequential search");
        System.out.println("4: Print the list");
        System.out.println("5: Sort the list in decreasing order");
        System.out.println("6: Replace the first occurence of a number with a different one");
        System.out.println("7: Replace all the occurences of a number with a different one");
        System.out.println("8: Search for a target element with a binary search");
        System.out.println("9: Sort the list using insertion sort(increasing order)");
        System.out.print("\nEnter your choice: ");
    }
}