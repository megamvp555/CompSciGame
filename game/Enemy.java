import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private double threshold;
    private int lives;
    private int count;
    public Enemy()
    {
        getImage().scale(80, 100);
        threshold = 0.005;
        lives = 1;
        count = 0;
    }

    public Enemy(double factor)
    {
        setImage("boss.png");
        getImage().scale((int)(getImage().getWidth() / factor), (int) (getImage().getHeight() / factor));
        threshold = 0.015;
        lives = 5;
        count = 0;
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!((MyWorld) getWorld()).getstarted())
            return;
        setLocation(getX() - 3, getY());
        double rand = Math.random();
        if(rand < threshold && count == 0)
        {
            EnemyWep x = new EnemyWep();
            getWorld().addObject(x, getX(), getY());
            count = 100;
        }

        if(getX() < -500)
        {
            getWorld().removeObject(this);
            return;
        }

        if(count > 0)
            count--;
    }

    public int getlives()
    {
        return(lives);
    }

    public void declives()
    {
        lives = lives -1;
    }
}
