import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author Sandro Lenz & Daniel Fankhauser 
 * @version 0.1
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1700, 900, 1); 
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Mine());
        }
    }
}
