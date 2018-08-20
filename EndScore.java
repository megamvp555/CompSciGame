import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScore extends Actor
{
    public EndScore(int score)
    {
        GreenfootImage gi = new GreenfootImage(" " + score + " ", 100, Color.BLUE, new Color(0, 0, 0, 0));
        setImage(gi);
    }
    
    /**
     * Act - do whatever the EndScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
