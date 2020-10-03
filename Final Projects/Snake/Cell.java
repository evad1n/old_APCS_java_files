
/**
 * Write a description of class Cell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;

public class Cell
{
    private final static int EMPTY = 0;
    private final static int FOOD = 5;
    private final static int SNAKE1 = 10;
    private final static int SNAKE2 = 20;
    private final static Color foodColor = Color.red;
    private final static Color defaultColor = Color.black;
    private final static int width = 10;
    private final static int height = 10;
    
    private static Color snake1Color = Color.green;
    private static Color snake2Color = Color.blue;
    
    private int row, col;
    private int type;
    private int x, y, z;
    private int previousType = -5;
    private Color next = Color.black;
    
    public Cell(int row, int col)
    {
        this.row = row;
        this.col = col;
        y = row*10;
        x = col*10;
        type = 0;
    }
    
    public void setPlayerColors(Color one, Color two)
    {
        snake1Color = one;
        snake2Color = two;
    }
    
    public void paint(Graphics g)
    {  
        z = 5;
        if(previousType != type)
        {
            if(type == EMPTY)
            {
                g.setColor(defaultColor);
                g.fillRect(x, y, width, height);
            }
            else if(type == FOOD)
            {
                g.setColor(foodColor);
                g.fillRect(x, y, width, height);
            }
            else if(type == SNAKE1)
            {
                g.setColor(snake1Color);
                g.fillRect(x, y, width, height);
            }
            else if(type == SNAKE2)
            {
                g.setColor(snake2Color);
                g.fillRect(x, y, width, height);
            }
            previousType = type;
        }
    }
    
    public void setType(int t)
    {
        type = t;
    }
    
    public int getType()
    {
        return type;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
    
    public void setRow(int r)
    {
        this.row = r;
        y = row*10;
    }
    
    public void setCol(int c)
    {
        this.col = c;
        x = col*10;
    }
    
    public boolean equals (Cell other)
    {
        if(this.getRow() == other.getRow() && this.getCol() == other.getCol())
            return true;
        else
            return false;
    }
}
