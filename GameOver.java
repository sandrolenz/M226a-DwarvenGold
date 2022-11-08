import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The game over screen
 * 
 * @author Sandro Lenz, Daniel Fankhauser 
 * @version v1.1
 */

public class GameOver extends World {
    // Constructor for objects of class GameOver.
    public GameOver(String reason, int score) {    
        // Create a new world with 1700x900 cells with a cell size of 1x1 pixels.
        super(1700, 900, 1); 
        showText(reason, score);
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("R")) {
            Greenfoot.setWorld(new Mine());
        }
    }
    
    private void showText(String reason, int score) {
        switch(reason) {
            case "durability":
                showText("Your Pickaxe broke!", 850, 440);
                showText("Score: " + score, 850, 460);
                break;
            case "health":
                showText("You died!", 850, 440);
                showText("Score: " + score, 850, 460);
                break;
            default:
                showText("Something went wrong", 850, 440);
                showText("Please try again", 850, 460);
                break;
        }
    }
}
