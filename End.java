import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends World
{
    private EndScore score;
    /**
     * Constructor for objects of class End.
     * 
     */
    public End(int enemiesKilled)
    {    
        super(1280, 720, 1); 
        score = new EndScore(enemiesKilled);
        addObject(score, 640, 360);
    }
}
