import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cloud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cloud extends Actor
{
    public Cloud()
    {
        getImage().scale(295, 123);
    }
    
    public void act() 
    {
        if(!((MyWorld) getWorld()).getstarted())
            return;
        setLocation(getX() - 5, getY());
        if(getX() < -500)
            getWorld().removeObject(this);
    }    
}
