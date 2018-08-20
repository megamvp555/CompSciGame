import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private boolean canShoot;
    private boolean wPressed;
    private int t;
    private boolean rising;
    private int wTimes;
    private boolean spacePressed;
    private boolean spaceHeldDown;
    private double spaceCount;
    private String toDisp;
    private int lives;
    private GreenfootSound ooh;
    private List<HP> pool;
    private boolean HPsetup;
    private int enemiesKilled;
    
    public Player()
    {
        canShoot = true;
        wPressed = false;
        t = 0;
        rising = true;
        wTimes = 0;
        spacePressed = false;
        spaceHeldDown = false;
        spaceCount = 0.0;
        toDisp = "";
        lives = 5;
        ooh = new GreenfootSound("ooh.mp3");
        pool = new ArrayList<HP>();
        for(int i = 0; i < lives; i++)
            pool.add(new HP());
        HPsetup = false;
        enemiesKilled = 0;
        
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!((MyWorld) getWorld()).getstarted())
            return;
        if(Greenfoot.isKeyDown("a"))
            setLocation(getX() - 8, getY());
        if(Greenfoot.isKeyDown("d"))
            setLocation(getX() + 8, getY());

        if(Greenfoot.isKeyDown("w") && !wPressed)
        {
            wPressed = true;
            wTimes++;
            t = 0;
        }

        if(wPressed)
        {
            setLocation(getX(), getY() - 30);
            if(getY() < 591)
                setLocation(getX(), getY() + 2*t);
            t++;
            if(t == 30) 
            {
                t = 0;
                wTimes--;
                wPressed = false;
            }
        }

        falling();

        if(Greenfoot.isKeyDown("SPACE") && spaceCount < 3.01)
        {
            if(spaceCount % 0.10 < 0.001)
                toDisp += "*";
            spaceCount += 0.05;
        }

        if(!Greenfoot.isKeyDown("SPACE") && spaceCount != 0.0)
        {
            List<Arrow> x = getWorld().getObjects(Arrow.class);
            if(x.size() == 0)
                getWorld().addObject(new Arrow(spaceCount), getX() + 100, getY() - 10);
            spaceCount = 0.0;
            toDisp = "";
        }

        getWorld().showText(toDisp, 100, 200);
        
        Actor hit = getOneIntersectingObject(EnemyWep.class);
        if(hit != null)
        {
            lives--;
            updateHealth();
            ooh.play();
            getWorld().removeObject(hit);
            if(lives == 0)
            {
                ((MyWorld) getWorld()).setgameOver(true);
                getWorld().removeObject(this);
                return;
            }
        }
    }

    public void falling()
    {
        if(getY() < 591)
            setLocation(getX(), getY() + 1);
    }

    public void initiateHealth()
    {
        if(!HPsetup)
            for(int i = 0; i < pool.size(); i++)
                getWorld().addObject(pool.get(i), (60 + 50*i), 100);
        HPsetup = true;
    }

    public void updateHealth()
    {
        for(int i = 0; i < pool.size(); i++)
            getWorld().removeObject(pool.get(i));
        pool.remove(pool.size() - 1);
        HPsetup = false;
        initiateHealth();
    }
    
    public void updateScore()
    {
        
    }
}
