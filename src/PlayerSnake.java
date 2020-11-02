import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;



public class PlayerSnake {

    Deque<Vector2i> body = new LinkedList<>();

    private int xVelocity =  0;
    private int yVelocity = 0;

    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    private Color bodyColor = Color.GREEN;

    public PlayerSnake(Vector2i position)
    {
        body.add(position);
        Vector2i p1, p2;
        p1 = new Vector2i(position.x, position.y + 20);
        p2 = new Vector2i(position.x, position.y + 40 );
        body.addLast(p1);
        body.addLast(p2);
    }


    public Vector2i getHeadPos()
    {
        return body.getFirst();
    }


    public void setLeft(boolean b) {left = b; }
    public void setRight(boolean b) {right = b; }
    public void setUpp(boolean b) {up = b; }
    public void setDown(boolean b) {down = b; }

    public void update()
    {
        if(down)
        {
            if(yVelocity != -20)
            {
                yVelocity = 20;
                xVelocity = 0;
            }
        }
        if(up)
        {
            if(yVelocity != 20)
            {
                yVelocity = -20;
                xVelocity = 0;
            }
        }
        if(right)
        {
            if(xVelocity != -20)
            {
                yVelocity = 0;
                xVelocity = 20;
            }
        }
        if(left)
        {
            if(xVelocity != 20)
            {
                yVelocity = 0;
                xVelocity = -20;
            }
        }

        // Movement here
        Vector2i tempHead;
        Vector2i newHead;

        switch (xVelocity)
        {
            case 20:
                tempHead = body.pollFirst();
                newHead = new Vector2i(tempHead.x, tempHead.y);
                newHead.x += 20;
                body.removeLast();
                body.addLast(newHead);
                body.addLast(tempHead);

//                System.out.println("TempHead x = " + tempHead.x + " TempHead y = "+ tempHead.y);
//                System.out.println("NewHead x = " + newHead.x + " NewpHead y = "+ newHead.y);

                for (int i = 0; i < body.size() - 2; i++)
                {
                    Vector2i temp;
                    temp = body.pollFirst();
                    body.addLast(temp);
                }
                break;

            case -20:
                tempHead = body.pollFirst();
                newHead = new Vector2i(tempHead.x, tempHead.y);
                newHead.x -= 20;
                body.removeLast();
                body.addLast(newHead);
                body.addLast(tempHead);

//                System.out.println("TempHead x = " + tempHead.x + " TempHead y = "+ tempHead.y);
//                System.out.println("NewHead x = " + newHead.x + " NewpHead y = "+ newHead.y);

                for (int i = 0; i < body.size() - 2; i++)
                {
                    Vector2i temp;
                    temp = body.pollFirst();
                    body.addLast(temp);
                }
                break;
        }

        switch (yVelocity)
        {
            case 20:
                tempHead = body.pollFirst();
                newHead = new Vector2i(tempHead.x, tempHead.y);
                newHead.y += 20;
                body.removeLast();
                body.addLast(newHead);
                body.addLast(tempHead);

//                System.out.println("TempHead x = " + tempHead.x + " TempHead y = "+ tempHead.y);
//                System.out.println("NewHead x = " + newHead.x + " NewpHead y = "+ newHead.y);

                for (int i = 0; i < body.size() - 2; i++)
                {
                    Vector2i temp;
                    temp = body.pollFirst();
                    body.addLast(temp);
                }
                break;

            case -20:
                tempHead = body.pollFirst();
                newHead = new Vector2i(tempHead.x, tempHead.y);
                newHead.y -= 20;
                body.removeLast();
                body.addLast(newHead);
                body.addLast(tempHead);

//                System.out.println("TempHead x = " + tempHead.x + " TempHead y = "+ tempHead.y);
//                System.out.println("NewHead x = " + newHead.x + " NewpHead y = "+ newHead.y);

                for (int i = 0; i < body.size() - 2; i++)
                {
                    Vector2i temp;
                    temp = body.pollFirst();
                    body.addLast(temp);
                }
                break;
        }
    }

    public boolean eats(Vector2i foodPos)
    {
        Vector2i Head = getHeadPos();
        if ( Head.equals(foodPos) )
        {
            Vector2i newLast = body.getLast();
            body.addLast(newLast);
            return true;
        }
        return false;
    }

    public void draw(Graphics2D g)
    {
        Vector2i temp;

        g.setColor(bodyColor);

        for (int i = 0; i < body.size(); i++)
        {
            temp = body.pollFirst();
            g.fillRect(temp.x, temp.y, 20, 20);
            System.out.println("Bucata" + i + " = " + temp.x + " " + temp.y);
            body.addLast(temp);
        }
    }

}
