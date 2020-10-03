
/**
 * Write a description of class Router here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Router
{
    private final int BOARD_SIDE_LENGTH = 50;
    
    public static boolean loss = false;
    
    private static Snake snake;
    private static Board board;
    private static int speed = 4;
    private static Cell start, food;
    
    public Router (Board b)
    {
        board = b;
        start = new Cell(BOARD_SIDE_LENGTH/2, BOARD_SIDE_LENGTH/2);
        snake = new Snake(start);
        food = board.generateFood();
    }
    
    public void setDifficulty(int y)
    {
        speed = (2*y);
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
        System.out.println("You lose");
        System.exit(0);
    }
    
    public void move()
    {
        Cell from = snake.getPositions(0);
        int d = snake.getDirection();
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
            System.out.println("You crashed into a wall!");
            lose();
        }
        else if(snake.selfCollide())
        {
            System.out.println("You crashed into yourself!");
            lose();
        }
        else if(snake.getPositions(0).equals(food))
        {
            snake.setPosition(from);
            snake.grow(speed);
            food = board.generateFood();
        }
        else
            snake.setPosition(from);
        
        
        for(int r = 0; r < board.getRows(); r++)
        {
            for(int c = 0; c < board.getCols(); c++)
            {
                if(food.equals(board.getCell(r, c)))
                {
                    board.getCell(r, c).setType(5);
                }
                else
                {
                    board.getCell(r, c).setType(0);
                }
                for(int s = 0; s < snake.getSize(); s++)
                {
                    if(snake.getPositions(s).equals(board.getCell(r, c)))
                    {
                        board.getCell(r, c).setType(10);
                    }
                }
            }
        }
        
        timer(1);
    }
    
    public void setDirection(int d)
    {
        snake.setDirection(d);
    }
    
    public int getDirection()
    {
        return snake.getDirection();
    }
}
