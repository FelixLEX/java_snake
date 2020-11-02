import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    public static int WIDTH = 400;
    public static int HEIGHT = 600;

    private Thread thread;
    private boolean running;

    private BufferedImage image;
    private Graphics2D g;

    private int FPS = 10;
    private double averageFPS;

    private PlayerSnake snakePlayer;
    private Food food;

    // Constructor
    public  GamePanel()
    {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }
    
    // Functions
    public void addNotify()
    {
        super.addNotify();

        if(thread == null)
        {
            thread = new Thread(this);
            thread.start();
        }

        addKeyListener(this);
    }

    public void run()
    {
        running = true;

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        Vector2i initialPos = new Vector2i(200, 200);

        snakePlayer = new PlayerSnake(initialPos);
        food = new Food(WIDTH, HEIGHT);

        long startTime;
        long URDTimeMillis;
        long waitTime;
        long totalTime = 0;

        int frameCount = 0;
        int maxFrameCount = 30;

        long targetTime = 1000 / FPS;




        //Game Loop
        while (running)
        {
            startTime = System.nanoTime();

            gameUpdate();
            gameRender();
            gameDraw();

            URDTimeMillis = (System.nanoTime() - startTime) / 1000000;

            waitTime = targetTime - URDTimeMillis;

            try {
                Thread.sleep(waitTime);
            }
            catch (Exception e)
            {
            }

            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if(frameCount == maxFrameCount)
            {
                averageFPS = 1000.0 / ((totalTime / frameCount)/ 1000000);
                frameCount = 0;
                totalTime = 0;
            }
        }

    }

    private void gameUpdate()
    {
        snakePlayer.update();
        boolean hasEaten = snakePlayer.eats(food.foodPos);
        if (hasEaten)
        {
            food.generateNewPosition(WIDTH, HEIGHT);
        }
    }


    private void gameRender()
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(averageFPS), 100, 100);
        snakePlayer.draw(g);
        food.draw(g);

    }

    private void gameDraw()
    {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

    public void keyTyped(KeyEvent key) {
        int keyCode = key.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT)
        {
            snakePlayer.setLeft(true);
            snakePlayer.setRight(false);
            snakePlayer.setUpp(false);
            snakePlayer.setDown(false);
        }
        if(keyCode == KeyEvent.VK_RIGHT)
        {
            snakePlayer.setLeft(false);
            snakePlayer.setRight(true);
            snakePlayer.setUpp(false);
            snakePlayer.setDown(false);
        }
        if(keyCode == KeyEvent.VK_UP)
        {
            snakePlayer.setLeft(false);
            snakePlayer.setRight(false);
            snakePlayer.setUpp(true);
            snakePlayer.setDown(false);
        }
        if(keyCode == KeyEvent.VK_DOWN)
        {
            snakePlayer.setLeft(false);
            snakePlayer.setRight(false);
            snakePlayer.setUpp(false);
            snakePlayer.setDown(true);
        }
    }

    public void keyReleased(KeyEvent key)
    {
        int keyCode = key.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT)
        {
            snakePlayer.setLeft(true);
            snakePlayer.setRight(false);
            snakePlayer.setUpp(false);
            snakePlayer.setDown(false);
        }
        if(keyCode == KeyEvent.VK_RIGHT)
        {
            snakePlayer.setLeft(false);
            snakePlayer.setRight(true);
            snakePlayer.setUpp(false);
            snakePlayer.setDown(false);
        }
        if(keyCode == KeyEvent.VK_UP)
        {
            snakePlayer.setLeft(false);
            snakePlayer.setRight(false);
            snakePlayer.setUpp(true);
            snakePlayer.setDown(false);
        }
        if(keyCode == KeyEvent.VK_DOWN)
        {
            snakePlayer.setLeft(false);
            snakePlayer.setRight(false);
            snakePlayer.setUpp(false);
            snakePlayer.setDown(true);
        }
    }

    public void keyPressed(KeyEvent key)
    {
        int keyCode = key.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT)
        {
            snakePlayer.setLeft(true);
        }
        if(keyCode == KeyEvent.VK_RIGHT)
        {
            snakePlayer.setRight(true);
        }
        if(keyCode == KeyEvent.VK_UP)
        {
            snakePlayer.setUpp(true);
        }
        if(keyCode == KeyEvent.VK_DOWN)
        {
            snakePlayer.setDown(true);;
        }
    }

}
