
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
    private final static int SNAKE_NODE = 10;
    private final static Color foodColor = Color.red;
    private final static Color defaultColor = Color.white;
    private final static Color snakeColor = Color.green;
    private final static int width = 10;
    private final static int height = 10;
    
    private int row, col;
    private int type;
    private int x, y;
    
    public Cell(int row, int col)
    {
        this.row = row;
        this.col = col;
        y = row*10;
        x = col*10;
        type = 0;
    }
    
    public void paint(Graphics g)
    {
        if(type == 0)
        {
            //g.setColor(defaultColor);
            //g.fillRect(x, y, width, height);
        }
        else if(type == 5)
        {
            g.setColor(foodColor);
            g.fillRect(x, y, width, height);
        }
        else
        {
            g.setColor(snakeColor);
            g.fillRect(x, y, width, height);
        }
    }
    
    public void setType(int type)
    {
        this.type = type;
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
