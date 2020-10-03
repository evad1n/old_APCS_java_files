
/**
 * Write a description of class Router here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Router
{
    private final int BOARD_SIDE_LENGTH = 50;
    
    public static boolean loss = false, accel = false;
    
    private static Snake snake1, snake2;
    private static Board board;
    private static int speed = 4;
    private static Cell start1, start2, food1, food2;
    private String msg = "";
    private int p, a;
    
    public Router (Board b, int players)
    {
        p = players;
        board = b;
        if(players == 1)
        {
            start1 = new Cell(BOARD_SIDE_LENGTH/2, BOARD_SIDE_LENGTH/2);
            snake1 = new Snake(start1);
            food1 = board.generateFood();
        }
        else if(players == 2)
        {
            start1 = new Cell(BOARD_SIDE_LENGTH/2, (BOARD_SIDE_LENGTH/2) - 5);
            start2 = new Cell(BOARD_SIDE_LENGTH/2, (BOARD_SIDE_LENGTH/2) + 5);
            snake1 = new Snake(start1);
            snake2 = new Snake(start2);
            food1 = board.generateFood();
            food2 = board.generateFood();
        }
    }
    
    public void setDifficulty(int y)
    {
        loss = false;
        speed = (2*y);
    }
    
    public void setAcceleration(boolean acc, int rate)
    {
        accel = acc;
        a = rate;
    }
    
    public static void timer(int seconds)
    {
        try {
            Thread.sleep((seconds * 1000)/(speed*speed));
        }
        catch(Exception e) {
            System.exit(0);
        }
    }
    
    public static void lose()
    {
        loss = true;
    }
    
    public static boolean loss()
    {
        return loss;
    }
    
    public void setDirection(int d, int snake)
    {
        if(snake == 2)
        {
            snake2.setDirection(d);
        }
        else
            snake1.setDirection(d);
    }
    
    public int getDirection(int snake)
    {
        if(snake == 2)
        {
            return snake2.getDirection();
        }
        else
            return snake1.getDirection();
    }
    
    public String getMessage()
    {
        if(p == 1)
        {
            return "GAME OVER";
        }
        else
        {
            return msg;
        }
    }
    
    public int moveSinglePlayer()
    {
        int length = 0;
        Cell from = new Cell(snake1.getPositions(0).getRow(),snake1.getPositions(0).getCol());
        int d = snake1.getDirection();
        if(d == 0)
            from.setRow((from.getRow())-1);
        else if(d == 1)
            from.setCol((from.getCol())-1);
        else if(d == 2)
            from.setRow((from.getRow())+1);
        else if(d == 3)
            from.setCol((from.getCol())+1);  
        
        if(from.getRow()<0 || from.getRow() > BOARD_SIDE_LENGTH - 1 || from.getCol()<0 || from.getCol() > BOARD_SIDE_LENGTH - 1)
        {
            lose();
        }
        else if(snake1.selfCollide())
        {
            lose();
        }
        else if(snake1.getPositions(0).equals(food1))
        {
            snake1.setPosition(from);
            snake1.grow(speed);
            length = speed;
            food1 = board.generateFood();
            if(accel)
            {
                speed += a;
            }
        }
        else
            snake1.setPosition(from);
        
        
        for(int r = 0; r < board.getRows(); r++)
        {
            for(int c = 0; c < board.getCols(); c++)
            {
                if(food1.equals(board.getCell(r, c)))
                {
                    board.getCell(r, c).setType(5);
                }
                else
                {
                    board.getCell(r, c).setType(0);
                }
                for(int s = 0; s < snake1.getSize(); s++)
                {
                    if(snake1.getPositions(s).equals(board.getCell(r, c)))
                    {
                        board.getCell(r, c).setType(10);
                    }
                }
            }
        }
        
        timer(1);
        return length;
    }
    
    public void moveTwoPlayer()
    {
        boolean death1 = false, death2 = false;
        Cell from1 = new Cell(snake1.getPositions(0).getRow(),snake1.getPositions(0).getCol());
        int d1 = snake1.getDirection();
        if(d1 == 0)
            from1.setRow((from1.getRow())-1);
        else if(d1 == 1)
            from1.setCol((from1.getCol())-1);
        else if(d1 == 2)
            from1.setRow((from1.getRow())+1);
        else if(d1 == 3)
            from1.setCol((from1.getCol())+1);  
        
        for(int i = 0; i < snake2.getSize(); i++)
        {
            if(snake1.getPositions(0).equals(snake2.getPositions(i)))
            {
                msg = "Player 2 wins!";
                death1 = true;
                lose();
            }
        }
        
        if(from1.getRow()<0 || from1.getRow() > BOARD_SIDE_LENGTH - 1 || from1.getCol()<0 || from1.getCol() > BOARD_SIDE_LENGTH - 1)
        {
            msg = "Player 2 wins!";
            death1 = true;
            lose();
        }
        else if(snake1.selfCollide())
        {
            msg = "Player 2 wins!";
            death1 = true;
            lose();
        }
        else if(snake1.getPositions(0).equals(food1))
        {
            snake1.setPosition(from1);
            snake1.grow(speed);
            food1 = board.generateFood();
            if(accel)
            {
                speed += a;
            }
        }
        else if(snake1.getPositions(0).equals(food2))
        {
            snake1.setPosition(from1);
            snake1.grow(speed);
            food2 = board.generateFood();
            if(accel)
            {
                speed += a;
            }
        }
        else
            snake1.setPosition(from1);
       
        Cell from2 = new Cell(snake2.getPositions(0).getRow(),snake2.getPositions(0).getCol());
        int d2 = snake2.getDirection();
        if(d2 == 0)
            from2.setRow((from2.getRow())-1);
        else if(d2 == 1)
            from2.setCol((from2.getCol())-1);
        else if(d2 == 2)
            from2.setRow((from2.getRow())+1);
        else if(d2 == 3)
            from2.setCol((from2.getCol())+1);  
            
        for(int i = 0; i < snake1.getSize(); i++)
        {
            if(snake2.getPositions(0).equals(snake1.getPositions(i)))
            {
                msg = "Player 1 wins!";
                death2 = true;
                lose();
            }
        }
        
        if(from2.getRow()<0 || from2.getRow() > BOARD_SIDE_LENGTH - 1 || from2.getCol()<0 || from2.getCol() > BOARD_SIDE_LENGTH - 1)
        {
            msg = "Player 1 wins!";
            death2 = true;
            lose();
        }
        else if(snake2.selfCollide())
        {
            msg = "Player 1 wins!";
            death2 = true;
            lose();
        }
        else if(snake2.getPositions(0).equals(food1))
        {
            snake2.setPosition(from2);
            snake2.grow(speed);
            food1 = board.generateFood();
            if(accel)
            {
                speed += a;
            }
        }
        else if(snake2.getPositions(0).equals(food2))
        {
            snake2.setPosition(from2);
            snake2.grow(speed);
            food2 = board.generateFood();
            if(accel)
            {
                speed += a;
            }
        }
        else
            snake2.setPosition(from2);
            
        for(int r = 0; r < board.getRows(); r++)
        {
            for(int c = 0; c < board.getCols(); c++)
            {
                if(food1.equals(board.getCell(r, c)) || food2.equals(board.getCell(r, c)))
                {
                    board.getCell(r, c).setType(5);
                }
                else
                {
                    board.getCell(r, c).setType(0);
                }
                for(int s = 0; s < snake1.getSize(); s++)
                {
                    if(snake1.getPositions(s).equals(board.getCell(r, c)))
                    {
                        board.getCell(r, c).setType(10);
                    }
                }
                for(int s = 0; s < snake2.getSize(); s++)
                {
                    if(snake2.getPositions(s).equals(board.getCell(r, c)))
                    {
                        board.getCell(r, c).setType(20);
                    }
                }
            }
        }
        
        if(death1 && death2)
        {
            if(snake1.getSize() > snake2.getSize())
            {
                msg = "Snake 1 wins!";
            }
            else if(snake1.getSize() < snake2.getSize())
            {
                msg = "Snake 2 wins!";
            }
            else
            {
                msg = "KAMIKAZE";
            }
            lose();
        }
        timer(1);
    }
}
