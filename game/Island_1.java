import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Island_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Island_1 extends Island
{
    private Enemy e1;
    private Enemy e2;
    private Enemy e3;
    
    public Island_1()
    {
        e1 = new Enemy();
        e2 = new Enemy();
        e3 = new Enemy();
    }
    
    public void addEnemies()
    {
        getWorld().addObject(e1, getX()+20, getY()-40);
        getWorld().addObject(e2, getX()-70, getY()-40);
        getWorld().addObject(e3, getX()-100, getY()+114);
    }
}
