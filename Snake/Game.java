//http://yazalimbiraz.blogspot.com/2014/02/snake-game-written-in-java-full-source.html
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.*;
import java.applet.Applet;

public class Game extends Applet
{
    private final int BOARD_SIDE_LENGTH = 50;
    
    private Board board = new Board(BOARD_SIDE_LENGTH,BOARD_SIDE_LENGTH);
    private Router game = new Router(board);
    private JFrame gui;
    private int s = 0, direct = 0;
    JLabel score = new JLabel("Score: " + s);
    
    
    public Game (JFrame f)
    {
        gui = f;
        this.setSize(500,500);
        setBackground(Color.white);
    }
    
    public void setDirection(int d)
    {
        direct = d;
    }
    
    public int getDirection()
    {
        return game.getDirection();
    }
    
    public void setDifficulty(int y)
    {
        game.setDifficulty(y);
    }
    
    public void paint(Graphics g)
    {
        g.drawRect(0,0,500,500);
        score.setSize(50, 50);
        score.setLocation(525, 100);
        board.paint(g);
        gui.add(score);
        game.setDirection(direct);
        game.move();
        repaint();
    }
}
