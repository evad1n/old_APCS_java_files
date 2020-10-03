
/**
 * Write a description of class GO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GO implements SnakeListener
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Menu");
        JFrame game = new JFrame("Game");
        Game g = new Game(game);
        JLabel title = new JLabel("SNAKE");
        JButton start = new JButton("START");
        JButton controls = new JButton("CONTROLS");
        //Difficulty Selector
        ButtonGroup difficulty = new ButtonGroup();
        JRadioButton easy = new JRadioButton("Easy");
        JRadioButton normal = new JRadioButton("Normal");
        JRadioButton hard = new JRadioButton("Hard");
        JRadioButton insane = new JRadioButton("Insane");
        difficulty.add(easy);
        difficulty.add(normal);
        difficulty.add(hard);
        difficulty.add(insane);
        
        frame.setLayout(null);
        frame.setSize(600,600);
        frame.setVisible(true);
        
        frame.add(title);
        frame.add(start);
        frame.add(controls);
        
        frame.add(easy);
        easy.setSize(80, 20);
        easy.setLocation(100, 400);
        frame.add(normal);
        normal.setSize(80, 20);
        normal.setLocation(200, 400);
        frame.add(hard);
        hard.setSize(80, 20);
        hard.setLocation(300, 400);
        frame.add(insane);
        insane.setSize(80, 20);
        insane.setLocation(400, 400);
        
        title.setSize(100, 50);
        title.setLocation(250, 130);
        start.setSize(100, 50);
        start.setLocation(225, 220);
        controls.setSize(100, 50);
        controls.setLocation(225, 320);
        
        KeyListener listener = new KeyListener()
        {
            int d = 0;
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode() == KeyEvent.VK_W && g.getDirection() != 2)
                {
                    d = 0;
                }
                else if(event.getKeyCode() == KeyEvent.VK_A && g.getDirection() != 3)
                {
                    d = 1;
                }
                else if(event.getKeyCode() == KeyEvent.VK_S && g.getDirection() != 0)
                {
                    d = 2;
                }
                else if(event.getKeyCode() == KeyEvent.VK_D && g.getDirection() != 1)
                {
                    d = 3;
                }
                g.setDirection(d);
            }
    
            public void keyReleased(KeyEvent event)
            {
            }
    
            public void keyTyped(KeyEvent event)
            {
            }
            
        };
        
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JLabel score = new JLabel("0");
                frame.setVisible(false);
                game.setVisible(true);
                game.setSize(600,600);
                game.add(g);
                game.addKeyListener(listener);
            }
            
        });
        
        controls.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Use WASD to control snake direction");
            }
            
        });
        
        easy.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                g.setDifficulty(1);
            }
        });
        
        normal.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                g.setDifficulty(2);
            }
        });
        
        hard.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                g.setDifficulty(3);
            }
        });
        
        insane.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                g.setDifficulty(4);
            }
        });
    }
    
    public void score()
    {
    }
}
