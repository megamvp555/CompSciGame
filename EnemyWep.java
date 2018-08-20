import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyWep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyWep extends Projectile
{
    private int t;
    private int timesBounced;
    
    public EnemyWep()
    {
        getImage().scale(40, 40);
        t = 0;
        timesBounced = 0;
    }
    
    /**
     * Act - do whatever the EnemyWep wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() - 4, getY()+ t/3);
        if(getX() < -20)
        {
            getWorld().removeObject(this);
            return;
        }
        if(timesBounced < 5 && Math.abs(getY() - (getWorld().getHeight() - 75)) < 20)
        {
            t = -25;
            timesBounced++;
        }
        t++;
    }    
}
