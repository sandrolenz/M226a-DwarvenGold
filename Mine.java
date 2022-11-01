import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mine here.
 * 
 * @author Sandro Lenz, Daniel Fankhauser 
 * @version 0.1
 */
public class Mine extends World
{
    private int score;
    private int durability = 25;
    private int health = 4;
    /**
     * Constructor for objects of class Mine.
     * 
     */
    public Mine()
    {    
        // Create a new world with 1500x800 cells with a cell size of 1x1 pixels.
        super(1700, 900, 1); 
        prepare();
        showScore();
        showDurability();
        showHealth();
    }

    private void showScore() {
        showText("Score: " + score, 100, 25);
    }

    private void showDurability() {
        showText("Durability: " + durability, 100, 50);
    }

    private void showHealth() {
        showText("Health: " + health, 100, 75);
    }
    
    public void setDurability(int amount) {
        durability += amount;
        if(durability == 0) {
            showEndMessage("durability");
            Greenfoot.stop();
        }
        showDurability();
    }
    
    public void setScore(int amount) {
        score += amount;
        showScore();
    }
    
    public void setHealth(int amount) {
        health += amount;
        if(health <= 0) {
            showEndMessage("health");
            Greenfoot.stop();
        }
        showHealth();
    }
    
    private void showEndMessage(String reason) {
        if (reason == "durability") {
            showText("Your Pickaxe broke!", 850, 440);
            showText("Score: " + score, 850, 460);
            return;
        }
        if(reason == "health") {
            showText("You died!", 850, 440);
            showText("Score: " + score, 850, 460);
            return;
        }
    }

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
        // Place Stone border
        x = 50;
        while(x <= getWidth()-50) {
            Stone stone = new Stone();
            addObject(stone, x, getHeight()-50);
            x += 100;
        }
        
        Dirt startBlock = getObjects(Dirt.class).get(18);
        DirtMined dirtmined = new DirtMined();
        addObject(dirtmined, startBlock.getX(), startBlock.getY());
        removeObject(startBlock);
        
        Dwarf dwarf = new Dwarf();
        addObject(dwarf, 250, 50);
        
        setPaintOrder(Dwarf.class);
    }
}
