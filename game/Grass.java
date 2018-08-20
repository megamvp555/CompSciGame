import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grass extends Actor
{
    public Grass()
    {
        getImage().scale(1280, 50);
    }
    
    /**
     * Act - do whatever the Grass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!((MyWorld) getWorld()).getstarted())
            return;
        setLocation(getX() - 3, getY());
    }    
}
