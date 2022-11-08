import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main menu screen
 * 
 * @author Sandro Lenz & Daniel Fankhauser 
 * @version v1.2
 */

public class MainMenu extends World {

    // Constructor for objects of class MainMenu.
    public MainMenu() {    
        // Create a new world with 1700x900 cells with a cell size of 1x1 pixels.
        super(1700, 900, 1); 
    }
    
    // Check if Enter is pressed, then change world
    public void act() {
        if(Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Mine());
        }
    }
}
