
/**
 * This class will make a face.
 * 
 * Will
 * 9/8/15
 * 
 */
public class MyFace
{
    //The main drives this program
    public static void main (String[] args)
    {
        int i = 0;
         //Say something
        System.out.println("This is your face.");
        //Create a face in another window
        Canvas.getCanvas();
        //Head
        Circle head = new Circle();
        head.makeVisible();
        head.changeColor("yellow");
        head.slowMoveHorizontal(30);
        head.changeSize(200);
        //Left eye
        Square eye1 = new Square();
        eye1.makeVisible();
        eye1.slowMoveVertical(65);
        eye1.slowMoveHorizontal(30);
        //Right eye
        Square eye2 = new Square();
        eye2.makeVisible();
        eye2.slowMoveVertical(65);
        eye2.slowMoveHorizontal(120);
        //Nose
        Triangle nose = new Triangle();
        nose.makeVisible();
        nose.slowMoveVertical(130);
        nose.slowMoveHorizontal(100);
        //Left side of mouth
        Square mouth1 = new Square();
        mouth1.makeVisible();
        mouth1.changeColor("magenta");
        mouth1.slowMoveVertical(150);
        mouth1.slowMoveHorizontal(60);
        //Right side of mouth
        Square mouth2 = new Square();
        mouth2.makeVisible();
        mouth2.changeColor("magenta");
        mouth2.slowMoveVertical(150);
        mouth2.slowMoveHorizontal(90);
        //Change colors to something crazy
        head.changeColor("blue");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("black");
        mouth1.changeColor("green");
        mouth2.changeColor("green");
        /*System.out.println("\nYour face is malfunctioning.");
        //Go through a repeating sequence *w* times
        int w = 10;
        while (i < w)
            {
                i++;
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        head.changeColor("yellow");
        eye1.changeColor("red");
        eye2.changeColor("blue");
        nose.changeColor("yellow");
        mouth1.changeColor("green");
        mouth2.changeColor("blue");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change colors to something crazy
        head.changeColor("blue");
        eye1.changeColor("black");
        eye2.changeColor("blue");
        nose.changeColor("yellow");
        mouth1.changeColor("magenta");
        mouth2.changeColor("blue");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change everything to red
        head.changeColor("red");
        eye1.changeColor("red");
        eye2.changeColor("red");
        nose.changeColor("red");
        mouth1.changeColor("red");
        mouth2.changeColor("red");
        //Change everything to black
        head.changeColor("black");
        eye1.changeColor("black");
        eye2.changeColor("black");
        nose.changeColor("black");
        mouth1.changeColor("black");
        mouth2.changeColor("black");
        //Change colors to something crazy
        head.changeColor("red");
        eye1.changeColor("yellow");
        eye2.changeColor("blue");
        nose.changeColor("magenta");
        mouth1.changeColor("green");
        mouth2.changeColor("brown");
            }*/
    }
}
