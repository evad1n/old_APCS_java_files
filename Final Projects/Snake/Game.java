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
    private Router game;
    private int s = 0, direct1 = 0, direct2 = 0, p = 1;
    private JLabel score, end;
    private boolean lose = false;;
    
    
    public Game (JLabel points, int players, JLabel retry, int delay)
    {
        this.resize(500,500);
        game = new Router(board, players);
        p = players;
        setBackground(Color.black);
        score = points;
        end = retry;
        score.setBackground(Color.black);
        score.setForeground(Color.white);
        score.setOpaque(true);
        if(p == 1)
        {
            score.setVisible(true);
        }
        else
        {
            score.setVisible(false);
        }
        game.setDifficulty(delay);
        try {
            Thread.sleep(1000 / (8 - delay));
        }
        catch(Exception ex) {
            System.exit(0);
        }
    }
    
    public void setAcceleration(boolean accel, int rate)
    {
        game.setAcceleration(accel, rate);
    }
    
    public void setDirection(int d, int snake)
    {
        if(snake == 1)
        {
            direct1 = d;
        }
        else if(snake == 2)
        {
            direct2 = d;
        }
    }
    
    public void setPlayerColors(Color one, Color two)
    {
        board.setPlayerColors(one, two);
    }
    
    public int getDirection(int snake)
    {
        return game.getDirection(snake);
    }
    
    public boolean getLoss()
    {
        return lose;
    }
    
    public void setScore(int x)
    {
        s = x;
    }
    
    public void paint(Graphics g)
    {
        if(game.loss())
        {
            lose = true;
            this.stop();
            end.setText(game.getMessage());
            end.setVisible(true);
        }
        else
        {
            g.setColor(Color.white);
            g.drawLine(0, 500, 500, 500);
            board.paint(g);
            if(p == 1)
            {
                game.setDirection(direct1, 1);
                s += game.moveSinglePlayer();
                score.setText("" + s);
            }
            else if(p == 2)
            {
                game.setDirection(direct1, 1);
                game.setDirection(direct2, 2);
                game.moveTwoPlayer();
            }
            repaint();
        }
    }
    
    public void update(Graphics g)
    {
        paint(g);
    }
}
