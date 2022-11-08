import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main character
 * 
 * @author Sandro Lenz, Daniel Fankhauser 
 * @version v1.1
 */

public class Dwarf extends Actor {
    GreenfootImage imgFacingRight = new GreenfootImage("dwarf-right.png");
    GreenfootImage imgFacingLeft = new GreenfootImage("dwarf-left.png");
    
    public void act() {
        checkKeyPress();
        scanBlocks();
    }
    
    // Check if WASD or Arrow Keys are pressed and move dwarf
    private void checkKeyPress() {       
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY()-4);
            checkCollision("up");
        }
        
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY()+4);
            checkCollision("down");
        }
        
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            setImage(imgFacingLeft);
            setLocation(getX()-4, getY());
            checkCollision("left");
        }
        
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
            setImage(imgFacingRight);
                setLocation(getX()+4, getY());
            checkCollision("right");
        }
    }
    
    private boolean checkCollision(String direction) {
        // Check if Dwarf is touching dirt that is not mined and move dwarf back
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
    
    // Loop through blocks in range to show where ores are
    private void scanBlocks() {
        for (Dirt dirt : getObjectsInRange(150, Dirt.class)) {
            if(dirt.isOre) {
                dirt.showOre();
            }
        }
    }
}
