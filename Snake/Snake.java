
/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.LinkedList;
import java.util.List;

public class Snake
{
    private int speed = 2;
    private int size = 5;
    private int direction = 0;
    private LinkedList<Cell> snake = new LinkedList<Cell>();
    private Cell head, temp;
    private List<SnakeListener> listeners;
    
    public Snake(Cell initialPosition)
    {
        head = new Cell(initialPosition.getRow(), initialPosition.getCol());
        for(int i = 0; i < size; i++)
        {
            temp = new Cell (head.getRow() + i, head.getCol());
            snake.add(temp);
        }
    }
    
    public Cell getPositions(int x)
    {
        if(x == 0)
            return head;
        else
            return snake.get(x);
    }
    
    public boolean selfCollide()
    {
        for(int i = 1; i < snake.size(); i++)
        {
            if(snake.get(0).equals(snake.get(i)))
            {
                return true;
            }
        }
        return false;
    }
    
    public void setPosition(Cell to)
    {
        snake.add(0, to);
        snake.remove(snake.getLast());
        head = new Cell(snake.get(0).getRow(), snake.get(0).getCol());
    }
    
    public void setDirection(int d)
    {
        this.direction = d;
    }
    
    public int getDirection()
    {
        return direction;
    }
    
    public void grow(int s)
    {
        int x = 0;
        if(direction == 0 || direction == 1)
        {
            x = 1;
        }
        else if(direction == 2 || direction == 3)
        {
            x = -1;
        }
        boolean vertical = true;
        Cell last = snake.getLast();
        Cell secondLast = snake.get(snake.size()-2);
        Cell temp;
        if(last.getRow()==secondLast.getRow())
        {
            vertical = false;
        }
        for(int i = 1; i <= s; i++)
        {
            if(vertical)
            {
                temp = new Cell(last.getRow()+(x*i), last.getCol());
                snake.add(temp);
            }
            else
            {
                temp = new Cell(last.getRow(), last.getCol()+(x*i));
                snake.add(temp);
            }
        }
        notifyListeners(s);
    }
    
    public int getSize()
    {
        return snake.size();
    }
    
    private void notifyListeners(int x)
    {
    }
}
