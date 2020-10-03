
/**
 * Write a description of class Disk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disk
{
    public int size = 0;
    public boolean hasDisk = false;
    public String output = "";
    public String disk = "";
    public String diskStart = "CO";
    public String diskEnd = "D";
    public String noDisk = "|";
    
    public Disk ()
    {
        disk = "       |       ";
    }
    
    public boolean setActive (boolean active)
    {
        if(active)
        {
            hasDisk = true;
            output = disk;
        }
        else
        {
            hasDisk = false;
            output = noDisk;
        }
        return hasDisk;
    }
    
    public String setDiskSize (int size)
    {
        int gap = 0;
        for(int i = 0; i < size; i++)
        {
            diskStart = diskStart + "OO";
        }
        while(disk.length() < noDisk.length())
        {
            diskStart = " " + diskStart;
            diskEnd = diskEnd + " ";
            disk = diskStart + diskEnd;
        }
        return disk;
    }
    
    public String setScale (int size)
    {
        for(int i = 0; i < size; i++)
        {
            noDisk = " " + noDisk + " ";
        }
        return noDisk;
    }
    
    public void swap (Disk d)
    {
        this.size = d.size;
        this.hasDisk = d.hasDisk;
        this.output = d.output;
        this.disk = d.disk;
        this.diskStart = d.diskStart;
        this.diskEnd = d.diskEnd;
        this.noDisk = d.noDisk;
    }
    
    public boolean checkForDisk ()
    {
        return hasDisk;
    }
    
    public String toString ()
    {
        return output;
    }
}
