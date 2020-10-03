
/**
 * Write a description of class TowersOfHanoi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowersOfHanoi
{
    private static int totalDisks, step = 0;
    private Disk startDisk = new Disk ();
    private Disk endDisk = new Disk ();
    
    public Disk[][] system;
    
    public TowersOfHanoi (int disks)
    {
        totalDisks = disks;
        system = new Disk[totalDisks+2][3];
        
        for(int row = totalDisks+1; row >= 0; row--)
        {
            for(int column = 0; column < 3; column++)
            {
                system[row][column] = new Disk ();
                system[row][column].setScale(totalDisks+4);
                system[row][column].setActive(false);;
            }
        }
 
        for(int row = totalDisks-1; row >= 0; row--)
        {
            system[row][0].setDiskSize((totalDisks + 1) - row);
            system[row][0].setActive(true);
        }
        
        for(int row = totalDisks+1; row >= 0; row--)
        {
            for(int column = 0; column < 3; column++)
            {
                System.out.print(system[row][column]);
            }
            System.out.println();
        }
    }
    
    public void solve ()
    {
        moveTower (totalDisks, 1, 3, 2);
    }
    
    public void moveTower (int numDisks, int start, int end, int temp)
    {
        if(numDisks == 1)
            moveOneDisk(start, end); 
        else
        {
            moveTower(numDisks-1, start, temp, end);
            moveOneDisk(start, end);
            moveTower(numDisks-1, temp, end, start);
        }   
    }
    
    public void moveOneDisk (int start, int end)
    {
        step++;
        System.out.println("Step " + step + ": Move one disk from " + start + " to " + end + ".");
        
        startDisk = findStart(start-1);
        endDisk = findEnd(end-1);
        
        endDisk.swap(startDisk);
        endDisk.setActive(true);
        startDisk.setActive(false);
        
        for(int row = totalDisks+1; row >= 0; row--)
        {
            for(int column = 0; column < 3; column++)
            {
                System.out.print(system[row][column]);
            }
            System.out.println();
        }
    }
    
    private Disk findStart (int start)
    {
        for(int row = totalDisks+1; row >= 0; row--)
        {
            if(system[row][start].checkForDisk())
            {
                return system[row][start];
            }
        }
        return system[0][0];
    }
    
    private Disk findEnd (int end)
    {
        for(int row = totalDisks+1; row >= 0; row--)
        {
            if(system[row][end].checkForDisk())
            {
                return system[row+1][end];
            }
        }
        return system[0][end];
    }
}