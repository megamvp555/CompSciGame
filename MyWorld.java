import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Player player;
    private Dirt dirt;
    private Dirt dirt2;
    private Grass grass;
    private Grass grass2;
    private Enemy boss;
    private Island_1 level1;
    private Island_2 level2;
    private Island_3 level3;
    private Island bufferIsland;
    private int count;
    private boolean started;
    private boolean gameOver;
    private BeginText text;
    private int enemiesKilled;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        setPaintOrder(Grass.class, Dirt.class, Player.class, Enemy.class, Projectile.class, Island.class, Tree.class, Cloud.class);
        player = new Player();
        dirt = new Dirt();
        dirt2 = new Dirt();
        grass = new Grass();
        grass2 = new Grass();
        Sky bg = new Sky();
        text = new BeginText();
        count = 1;
        enemiesKilled = 0;

        addObject(player, 250, 591);
        player.initiateHealth();
        showText("Shot Charge", 100, 175);
        showText("Score: ", 1000, 175);
        setBackground(bg.getImage());

        //All Level Initiation
        boss = new Enemy(1.5);
        level1 = new Island_1();
        level2 = new Island_2();
        level3 = new Island_3();
        //SCENERY STUFF

        addObject(dirt, 640, 720);
        addObject(dirt2, 1920, 720);
        addObject(grass, 640, 645);
        addObject(grass2, 1920, 645);
        
        started = false;
        gameOver = false;
        addObject(text, 640, 320);
    }

    public void act()
    {        
        if(Greenfoot.isKeyDown("ENTER"))
        {
            removeObject(text);
            started = true;
        }
        if(!started)
            return;
        if(gameOver)
            Greenfoot.setWorld(new End(enemiesKilled));
        double x = Math.random();
        if(x < 0.01)
        {
            double y = Math.random();
            if(y < 0.5)
                addObject(new Cloud1(), 1400, 0);
            else
                addObject(new Cloud2(), 1400, 0);
        }

        double n = Math.random();
        if(n < 0.005)
        {
            double m = Math.random();
            if(m < 0.33)
                addObject(new Tree1(), 1400, 545);
            else if (m < 0.67)
                addObject(new Tree2(), 1400, 525);
            else
                addObject(new Tree3(), 1400, 560);
        }
        int rand = (int) (Math.random() * 3 + 1);
        if(dirt.getX() < -640)
        {
            dirt.setLocation(1920, 720);
            if(count % 10 != 0)
            {
                if(rand == 1)
                {
                    addObject(level1, 1920, 500);
                    level1.addEnemies();
                }
                if(rand == 2)
                {
                    addObject(level2, 1920, 520);
                    level2.addEnemies();
                }
                if(rand == 3)
                {
                    addObject(level3, 1920, 500);
                    level3.addEnemies();
                }
                count++;
            }
            else
            {
                addObject(boss, 1920, 505);
            }
        }
        if(dirt2.getX() < -640)
        {
            dirt2.setLocation(1920, 720);
        }
        if(grass.getX() < -640)
            grass.setLocation(1920, 645);
        if(grass2.getX() < -640)
            grass2.setLocation(1920, 645);
        showText(" " + enemiesKilled, 1100, 175);
    }

    public boolean getstarted()
    {
        return(started);
    }

    public boolean getgameOver()
    {
        return(gameOver);
    }
    
    public void setgameOver(boolean b)
    {
        gameOver = b;
    }
    
    public void incrementScore()
    {
        enemiesKilled++;
    }
}
