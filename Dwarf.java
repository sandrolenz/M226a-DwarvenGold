import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dwarf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dwarf extends Actor
{
    GreenfootImage imgFacingRight = new GreenfootImage("dwarf-right.png");
    GreenfootImage imgFacingLeft = new GreenfootImage("dwarf-left.png");
    public int health;
    public Dwarf(int health) {
        health = health;
    }
    
    /**
     * Act - do whatever the Dwarf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkKeyPress();
    }
    
    /**
     * Prüft, ob eine Taste auf der Tastatur gedrückt wurde, und
     * reagiert, falls dies zutrifft.     
     */
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) {
            if(checkCollision()) {
            setLocation(getX(), getY()-4);
            }
        }
        
        if (Greenfoot.isKeyDown("down")) {
            if(checkCollision()) {
            setLocation(getX(), getY()+4);
            }
        }
        
        if (Greenfoot.isKeyDown("left")) {
            setImage(imgFacingLeft);
            if(checkCollision()) {
            setLocation(getX()-4, getY());
            }
        }
        
        if (Greenfoot.isKeyDown("right")) {
            setImage(imgFacingRight);
            if(checkCollision()) {
                setLocation(getX()+4, getY());
            }
        }
    }
    
    private boolean checkCollision() {
        // Check if Dwarf is touching blocks that are not mined
        return true; // true means no collision
    }
}
