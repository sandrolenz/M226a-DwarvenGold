import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main world
 * 
 * @author Sandro Lenz, Daniel Fankhauser 
 * @version v1.1
 */

public class Mine extends World {
    private int score;
    private int durability = 30;
    private int health = 4;

    // Constructor for objects of class Mine.
    public Mine() {    
        // Create a new world with 1700x900 cells with a cell size of 1x1 pixels.
        super(1700, 900, 1); 
        prepare();
        showScore();
        showDurability();
        showHealth();
    }

    // Basic world functions
    
    private void showScore() {
        showText("Score: " + score, 100, 25);
    }

    private void showDurability() {
        showText("Durability: " + durability, 100, 50);
    }

    private void showHealth() {
        showText("Health: " + health, 100, 75);
    }
    
    public void setScore(int amount) {
        score += amount;
        showScore();
    }
    
    public void setDurability(int amount) {
        durability += amount;
        if(durability == 0) {
            Greenfoot.playSound("pickaxeBreak.mp3");
            endGame("durability", score);
        }
        showDurability();
    }
    
    public void setHealth(int amount) {
        health += amount;
        if(health <= 0) {
            Greenfoot.playSound("dwarfScream.mp3");
            endGame("health", score);
        }
        showHealth();
    }
    
    private void endGame(String reason, int score) {
        Greenfoot.setWorld(new GameOver(reason, score));
    }

    // Prepare world

    private void prepare() {
        // Place Dirt
        int x = 50;
        while(x <= getWidth()-50) {
            int y = 50;
            while (y <= getHeight()-50) {
                int oreGenerator = Greenfoot.getRandomNumber(40);
                Dirt dirt = new Dirt(oreGenerator);
                addObject(dirt, x, y);
                y += 100;
            }
            x += 100;
        }
        // Place Stone border along the bottom
        x = 50;
        while(x <= getWidth()-50) {
            Stone stone = new Stone();
            addObject(stone, x, getHeight()-50);
            x += 100;
        }
        
        // Make the starting block mined
        Dirt startBlock = getObjects(Dirt.class).get(18);
        DirtMined dirtmined = new DirtMined();
        addObject(dirtmined, startBlock.getX(), startBlock.getY());
        removeObject(startBlock);
        
        // Place dwarf
        Dwarf dwarf = new Dwarf();
        addObject(dwarf, 250, 50);
        setPaintOrder(Dwarf.class);
    }
}
