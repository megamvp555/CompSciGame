import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Island_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Island_2 extends Island
{
    private Enemy e1;
    private Enemy e2;
    private Enemy e3;

    public Island_2()
    {
        e1 = new Enemy();
        e2 = new Enemy();
        e3 = new Enemy();
        getImage().scale(340, 340);
    }  

    public void addEnemies()
    {
        getWorld().addObject(e1, getX()-100, getY()-57);
        getWorld().addObject(e2, getX()-50, getY()+84);
        getWorld().addObject(e3, getX()+100, getY()-99);
    }
}
