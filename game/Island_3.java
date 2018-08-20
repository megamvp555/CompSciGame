import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Island_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Island_3 extends Island
{
    private Enemy e1;
    private Enemy e2;
    private Enemy e3;

    public Island_3()
    {
        e1 = new Enemy();
        e2 = new Enemy();
        e3 = new Enemy();
        getImage().scale(300, 300);
    }

    public void addEnemies()
    {
        getWorld().addObject(e1, getX()-50, getY()-36);
        getWorld().addObject(e2, getX()+100, getY()-170);
        getWorld().addObject(e3, getX()+25, getY()+104);
    }
}
