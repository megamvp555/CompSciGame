import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Projectile
{
    private double speedFactor;
    private int time;
    private GreenfootSound bop;
    
    public Arrow()
    {
        getImage().scale(80, 40);
        speedFactor = 1.0;
        setRotation(180);
        bop = new GreenfootSound("hitsound.wav");
        bop.setVolume(80);
    }

    public Arrow(double sp)
    {
        this();
        speedFactor = sp;
    }

    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() + (int) (8*speedFactor), getY() + time/20);
        
        Actor hit = getOneIntersectingObject(Enemy.class);
        if(hit != null && speedFactor >= 1.0)
        {
            bop.play();
            ((MyWorld) getWorld()).incrementScore();
            if(((Enemy) hit).getlives() == 1)
                getWorld().removeObject(hit);
            else {
                ((Enemy) hit).declives();
            }
            getWorld().removeObject(this);
            return;
        }
        
        if(getX() + 8 > getWorld().getWidth() || getY() > getWorld().getHeight() - 75)
        {
            getWorld().removeObject(this);
            return;
        }
        time++;
    }    
}
