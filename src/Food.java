import java.awt.*;
import java.util.Random;

public class Food {

    public Vector2i foodPos;

    private Color foodColor = Color.RED;

    public Food(int width, int height)
    {
        int x = new Random().nextInt(width - 20 + 1);
        if ((x /10) % 2 != 0)
        {
            x = x / 10 * 10 + 10;
        }
        else
        {
            x = x / 10 * 10;
        }
        int y = new Random().nextInt(height - 20 + 1);
        if ((y /10) % 2 != 0)
        {
            y = y / 10 * 10 + 10;
        }
        else
        {
           y = y / 10 * 10;
        }

        foodPos = new Vector2i(x, y);
    }

    public void generateNewPosition(int width, int height)
    {
        int x = new Random().nextInt(width - 20 + 1);
        if ((x /10) % 2 != 0)
        {
            x = x / 10 * 10 + 10;
        }
        else
        {
            x = x / 10 * 10;
        }
        int y = new Random().nextInt(height - 20 + 1);
        if ((y /10) % 2 != 0)
        {
            y = y / 10 * 10 + 10;
        }
        else
        {
            y = y / 10 * 10;
        }

        foodPos = new Vector2i(x, y);
    }


    public void draw(Graphics2D g)
    {
        g.setColor(foodColor);
        g.fillRect(foodPos.x, foodPos.y, 20, 20);
    }

}
