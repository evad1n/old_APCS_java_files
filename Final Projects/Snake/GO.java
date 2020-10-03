
/**
 * Write a description of class GO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GO
{
    final static JLabel score = new JLabel("score");
    final static JFrame loss = new JFrame();
    private static int y = 0;
    private static int d = 2;
    private static int d1 = 0;
    private static int mode = 1;
    private static int d2 = 0;
    private static int a = -1;
    private static Game g;
    private static boolean accel = false;
    
    public static void main(String[] args)
    {
        final JFrame frame = new JFrame("Menu");
        final JFrame game = new JFrame("Game");
        final JLabel title = new JLabel("SNAKE");
        final JButton start = new JButton("START");
        final JButton controls = new JButton("CONTROLS");
        
        //Difficulty Selector
        ButtonGroup difficulty = new ButtonGroup();
        JRadioButton easy = new JRadioButton("Easy");
        JRadioButton normal = new JRadioButton("Normal");
        JRadioButton hard = new JRadioButton("Hard");
        JRadioButton insane = new JRadioButton("Insane");
        final JCheckBox acceleration = new JCheckBox("Acceleration");
        final JSpinner accelRate = new JSpinner();
        difficulty.add(easy);
        difficulty.add(normal);
        difficulty.add(hard);
        difficulty.add(insane);
        
        //Multiplayer selector
        ButtonGroup multiplayer = new ButtonGroup();
        JRadioButton one = new JRadioButton("1-Player");
        JRadioButton two = new JRadioButton("2-Player");
        multiplayer.add(one);
        multiplayer.add(two);
        frame.add(one);
        one.setSize(80,20);
        one.setLocation(200,230);
        one.setForeground(Color.white);
        one.setOpaque(false);
        frame.add(two);
        two.setSize(80,20);
        two.setLocation(300,230);
        two.setForeground(Color.white);
        two.setOpaque(false);
        
        final JButton color = new JButton("Choose Color");
        final JColorChooser palette1 = new JColorChooser(Color.green);
        palette1.setLocation(250,400);
        final JColorChooser palette2 = new JColorChooser(Color.blue);
        palette2.setLocation(750,400);
        final JLabel player1 = new JLabel("Player 1");
        player1.setSize(100, 50);
        player1.setLocation(250, 0);
        final JLabel player2 = new JLabel("Player 2");
        player2.setSize(100, 50);
        player2.setLocation(750, 0);
        
        frame.setLayout(null);
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
        
        frame.add(title);
        frame.add(start);
        frame.add(controls);
        frame.add(color);
        
        frame.add(easy);
        easy.setSize(80, 20);
        easy.setLocation(100, 350);
        easy.setForeground(Color.white);
        easy.setOpaque(false);
        frame.add(normal);
        normal.setSize(80, 20);
        normal.setLocation(200, 350);
        normal.setForeground(Color.white);
        normal.setOpaque(false);
        frame.add(hard);
        hard.setSize(80, 20);
        hard.setLocation(300, 350);
        hard.setForeground(Color.white);
        hard.setOpaque(false);
        frame.add(insane);
        insane.setSize(80, 20);
        insane.setLocation(400, 350);
        insane.setForeground(Color.white);
        insane.setOpaque(false);
        
        frame.add(acceleration);
        acceleration.setSize(100, 20);
        acceleration.setLocation(225, 400);
        acceleration.setForeground(Color.red);
        acceleration.setOpaque(false);
        frame.add(accelRate);
        accelRate.setSize(30, 25);
        accelRate.setLocation(325, 400);
        
        title.setSize(200, 100);
        title.setLocation(225, 50);
        title.setForeground(Color.red);
        title.setFont(new Font("Serif", Font.PLAIN, 30));
        start.setSize(100, 50);
        start.setLocation(225, 150);
        controls.setSize(100, 50);
        controls.setLocation(225, 270);
        color.setSize(150, 50);
        color.setLocation(200, 450);
        
        final KeyListener listener = new KeyListener()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode() == KeyEvent.VK_W && g.getDirection(1) != 2)
                {
                    d1 = 0;
                }
                else if(event.getKeyCode() == KeyEvent.VK_A && g.getDirection(1) != 3)
                {
                    d1 = 1;
                }
                else if(event.getKeyCode() == KeyEvent.VK_S && g.getDirection(1) != 0)
                {
                    d1 = 2;
                }
                else if(event.getKeyCode() == KeyEvent.VK_D && g.getDirection(1) != 1)
                {
                    d1 = 3;
                }
                else if(event.getKeyCode() == KeyEvent.VK_UP && mode == 2 && g.getDirection(2) != 2)
                {
                    d2 = 0;
                }
                else if(event.getKeyCode() == KeyEvent.VK_LEFT && mode == 2 && g.getDirection(2) != 3)
                {
                    d2 = 1;
                }
                else if(event.getKeyCode() == KeyEvent.VK_DOWN && mode == 2 && g.getDirection(2) != 0)
                {
                    d2 = 2;
                }
                else if(event.getKeyCode() == KeyEvent.VK_RIGHT && mode == 2 && g.getDirection(2) != 1)
                {
                    d2 = 3;
                }
                
                if(mode == 1)
                {
                    g.setDirection(d1, 1);
                }
                else if(mode == 2)
                {
                    g.setDirection(d1, 1);
                    g.setDirection(d2, 2);
                }
            }
    
            public void keyReleased(KeyEvent event)
            {
            }
    
            public void keyTyped(KeyEvent event)
            {
            }
            
        };
        
        final JButton retry = new JButton("RETRY");
        retry.setSize(100, 50);
        retry.setLocation(200, 510);
        final JLabel end = new JLabel();
        end.setSize(300,200);
        end.setFont(new Font("Serif", Font.PLAIN, 20));
        end.setLocation(200,150);
        end.setForeground(Color.red);
        end.setBackground(new java.awt.Color(0, 0, 0, 255));
        end.setOpaque(true);
        final JLabel length = new JLabel("Length: ");
        length.setSize(50,50);
        length.setLocation(25, 510);
        length.setBackground(new java.awt.Color(0, 0, 0, 255));
        length.setForeground(Color.white);
        length.setOpaque(true);
        score.setSize(50,50);
        score.setLocation(75,510);
        game.setSize(515,600);
        game.add(score);
        game.add(length);
        game.add(retry);
        game.add(end);
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                end.setVisible(false);
                if(mode == 1)
                {
                    length.setVisible(true);
                }
                else
                {
                    length.setVisible(false);
                }
                g = new Game(score, mode, end, d);
                g.setAcceleration(acceleration.isSelected(),(int)accelRate.getValue());
                d2 = 0;
                d1 = 0;
                game.addKeyListener(listener);
                frame.setVisible(false);
                g.setScore(0);
                g.setPlayerColors(palette1.getColor(), palette2.getColor());
                game.add(g);
                game.setVisible(true);
                retry.setFocusable(true);
                game.setFocusable(true);
            }
        });
        
        retry.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                game.remove(g);
                game.setVisible(false);
                game.setFocusable(false);
                retry.setFocusable(false);
                frame.setVisible(true);
            }
            
        });
        
        color.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFrame left = new JFrame("Player 1");
                JFrame right = new JFrame("Player 2");
                left.setSize(600, 400);
                right.setSize(600, 400);
                left.add(palette1);
                right.add(palette2);
                left.setVisible(true);
                right.setVisible(true);
            }
            
        });
        
        one.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mode = 1;
            }
        });
        
        two.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mode = 2;
            }
        });
        
        controls.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFrame help = new JFrame("Controls");
                JLabel info = new JLabel("<html>Single Player:<br>Use WASD to control snake direction.<br>Collect the red dots to increase your length.<br><br>2-Player:<br>Player 1 uses WASD to move.<br>Player 2 uses the arrow keys to move.<br>The goal is to not run into the other snake.<br>If there is a collision then the bigger snake will win.<br>If both snakes are the same size it is a kamikaze.<html>");
                info.setSize(300,300);
                info.setLocation(100,150);
                help.setSize(300, 300);
                help.add(info);
                help.setVisible(true);
            }
            
        });
        
        easy.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                d = 1;
            }
        });
        
        normal.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                d = 2;
            }
        });
        
        hard.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                d = 3;
            }
        });
        
        insane.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                d = 4;
            }
        });
    }
}
