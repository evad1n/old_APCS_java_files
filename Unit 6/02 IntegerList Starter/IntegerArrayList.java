// ****************************************************************
// IntegerListTest.java
//
//Will Dickinson
//2/4/2016
//          
// ****************************************************************
import java.util.ArrayList;

public class IntegerArrayList
{

    ArrayList<Integer> list = new ArrayList<Integer>(); //values in the list

    //-------------------------------------------------------
    //create a list of the given size
    // input: an int variable named size
    // output: none, this is a constructor
    // assign array to list; the number of elements in
    // list is stored in size 
    // THIS IS A CONSTRUCTOR
    //-------------------------------------------------------
    public IntegerArrayList()
    {
        
    }


    //-------------------------------------------------------
    //fill array with integers between 1 and 100, inclusive
    // input: none
    // output: none
    // modifies list array to populate the array as 
    // described above
    // THIS IS A SETTER (OR MODIFIER)
    //-------------------------------------------------------
    public void randomFill(int length)
    {
        for (int i=0; i < length; i++)
            list.add((int)(Math.random()*100) + 1);
    }


    //-------------------------------------------------------
    //print array elements with indices
    // input: none
    // output: none
    // prints using the following format:
    // if the array is [4, 7, 2, 10],
    // this method should print:
    //  0   4
    //  1   7
    //  2   2  
    //  3   10
    // THIS IS AN ACCESSOR (GETTER)
    //-------------------------------------------------------
    public void print()
    {
        for (int i=0; i<list.size(); i++)
            System.out.println(i + ":\t" + list.get(i).intValue());
    }


    //-------------------------------------------------------
    //return the index of the first occurrence of target in 
    //the list.
    // input: int target
    // output: location of target in list[], -1 if not found
    // uses sequential search algorithm
    // THIS IS AN ACCESSOR(GETTER)
    //-------------------------------------------------------
    public int search(int target)
    {
       int location = -1;
       for (int i=0; i<list.size() && location == -1; i++)
            if (list.get(i).intValue() == target)
                location = i;
    
       return location;
    }


    //-------------------------------------------------------
    //sort the list into ascending order using the selection 
    //sort algorithm
    // input: none, list is instance data
    // output: none, instance data is modified
    // THIS IS A MODIFIER (SETTER)
    //-------------------------------------------------------
    public void selectionSort()
    {
        int minIndex;
        for (int i=0; i < list.size()-1; i++)
        {
            //find smallest element in list starting at location i
            minIndex = i;
            for (int j = i+1; j < list.size(); j++)
                if (list.get(j).intValue() < list.get(minIndex).intValue())
                    minIndex = j;

            //swap list[i] with smallest element
            int temp = list.get(i).intValue();
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }
    
    public void sortDecreasing ()
    {
        int minIndex;
        for (int i=0; i < list.size()-1; i++)
        {
            //find largest element in list starting at location i
            minIndex = i;
            for (int j = i+1; j < list.size(); j++)
                if (list.get(j).intValue() > list.get(minIndex).intValue())
                    minIndex = j;

            //swap list[i] with largest
            int temp = list.get(i).intValue();
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }
    
    public void replaceFirst (int newVal, int location)
    {
        list.set(location, newVal);
    }
    
    public void replaceAll (int oldVal, int newVal)
    {
       for (int i=0; i < list.size(); i++)
            if (list.get(i).intValue() == oldVal)
                list.set(i,newVal);
    }
    
    public int binarySearch (int target, String sortType)
    {
        int low = 0;
        int high = list.size() - 1;
        while(high >= low)
        {
            int middle = (high + low)/2;
            if(list.get(middle).intValue() == target)
            {
                return middle;
            }
            if(sortType.equals("increasing"))
            {
                if(list.get(middle).intValue() > target)
                {
                    high = middle - 1;
                }
                if(list.get(middle).intValue() < target)
                {
                    low = middle + 1;
                }
            }
            if(sortType.equals("decreasing"))
            {
                if(list.get(middle).intValue() > target)
                {
                    low = middle + 1;
                }
                if(list.get(middle).intValue() < target)
                {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }
    
    public void insertionSort ()
    {
        for (int i = 1; i < list.size(); i++)
        {
            int key = list.get(i).intValue();
            int position = i;
            
            while (position > 0 && list.get(position-1).intValue() > key)
            {
                list.set(position, list.get(position-1).intValue());
                position--;
            }
            
            list.set(position, key);
        }
    }
}
