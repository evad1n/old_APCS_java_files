
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;

public class Board
{
    private Cell[][] board;
    private int rows, cols;
    
    public Board (int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        board = new Cell[rows][cols];
        
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[0].length; c++)
            {
                board[r][c] = new Cell(r,c);
            }
        }
    }
    
    public void setPlayerColors(Color one, Color two)
    {
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[0].length; c++)
            {
                board[r][c].setPlayerColors(one, two);
            }
        }
    }
    
    public Cell generateFood()
    {
        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < cols; c++)
            {
                if(board[r][c].getType()==5)
                {
                    board[r][c].setType(0);
                }
            }
        }
        int r = (int)(Math.random()*rows);
        int c = (int)(Math.random()*cols);
        while(board[r][c].getType() == 10 || board[r][c].getType() == 20)
        {
            r = (int)(Math.random()*rows);
            c = (int)(Math.random()*cols);
        }
        board[r][c].setType(5);
        return board[r][c];
    }
    
    public void paint(Graphics g)
    {
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[0].length; c++)
            {
                board[r][c].paint(g);
            }
        }
    }
    
    public int getRows()
    {
        return rows;
    }
    
    public int getCols()
    {
        return cols;
    }
    
    public Cell getCell(int row, int col)
    {
        return board[row][col];
    }
}
