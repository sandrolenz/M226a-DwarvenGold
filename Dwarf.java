import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dwarf here.
 * 
 * @author Sandro Lenz, Daniel Fankhauser
 * @version 0.1
 */
public class Dwarf extends Actor
{
    GreenfootImage imgFacingRight = new GreenfootImage("dwarf-right.png");
    GreenfootImage imgFacingLeft = new GreenfootImage("dwarf-left.png");
    
    /**
     * Act - do whatever the Dwarf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkKeyPress();
        scanBlocks();
    }
    
    /**
     * Prüft, ob eine Taste auf der Tastatur gedrückt wurde, und
     * reagiert, falls dies zutrifft.     
     */
    private void checkKeyPress() {       
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY()-4);
            if(checkCollision("up")) {
            }
        }
        
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY()+4);
            if(checkCollision("down")) {
            }
        }
        
        if (Greenfoot.isKeyDown("a")) {
            setImage(imgFacingLeft);
            setLocation(getX()-4, getY());
            if(checkCollision("left")) {
            }
        }
        
        if (Greenfoot.isKeyDown("d")) {
            setImage(imgFacingRight);
                setLocation(getX()+4, getY());
            if(checkCollision("right")) {
            }
        }
    }
    
    private boolean checkCollision(String direction) {        
        // Check if Dwarf is touching blocks that are not mined
        if(isTouching(Dirt.class)) {
            switch(direction) {
                case "up":
                    setLocation(getX(), getY()+8);
                    break;
                case "down":
                    setLocation(getX(), getY()-8);
                    break;
                case "left":
                    setLocation(getX()+8, getY());
                    break;
                case "right":
                    setLocation(getX()-8, getY());
                    break;
                default:
                    return false;
            }
            return false;
        }
        // Check if Dwarf is touching stone
        if(isTouching(Stone.class)) {
            setLocation(getX(), getY()-4);
            return false;
        }
        return true; // true means no collision
    }
    
    public void scanBlocks() {
        for (Dirt dirt : getObjectsInRange(150, Dirt.class))
        {
            if(dirt.isOre) {
                dirt.showOre();
            }
        }
    }
    
}
