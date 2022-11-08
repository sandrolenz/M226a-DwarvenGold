import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Blocks that contain dirt, silver, gold or an enemy and can be mined
 * 
 * @author Sandro Lenz, Daniel Fankhauser 
 * @version v1.1
 */

public class Dirt extends Actor {
    String ore;
    boolean isOre;
    boolean isEnemy;
    int value;
    public Dirt(int oreType) {
        switch(oreType) {
            case 1:
                isOre = true;
                ore = "silver";
                value = 10;
                break;
            case 2:
                isOre = true;
                ore = "gold";
                value = 20;
                break;
            case 3:
                isEnemy = true;
                value = 0;
                break;
            case 4:
                isEnemy = true;
                value = 0;
                break;
            default:
                isOre = false;
                ore = "none";
                value = 0;
                break;
        }
    }
    
    public void act() {
        checkClick();
    }
    
    // Mine dirt
    public void mine() {
        // Check if dwarf is in range
        if(!getObjectsInRange(200, Dwarf.class).isEmpty()) {
            Greenfoot.playSound("dirtMine.mp3");

            // Place DirtMined at the position of the block that is mined
            Mine mine = (Mine)getWorld();
            DirtMined dirtmined = new DirtMined();
            mine.addObject(dirtmined, this.getX(), this.getY());
            
            mine.setDurability(-1);

            // If the block is an ore, add value to score
            if (this.isOre) {
                mine.setScore(this.value);
                Greenfoot.playSound("oreMine.mp3");
            }

            // If the block is an enemy, reduce health and play damage sound
            if (this.isEnemy) {
                mine.setHealth(-1);
                Greenfoot.playSound("spiderAttack.mp3");
                Greenfoot.playSound("dwarfHurt.mp3");
            }

            // Remove the original Dirt
            mine.removeObject(this);
        }
    }
    
    // Change texture to show ore once dwarf is in range
    public void showOre() {
        setImage(new GreenfootImage("texture_ore-" + this.ore + ".png"));
    }
    
    // Check if mouse is clicked
    private void checkClick() {
        if (Greenfoot.mouseClicked(this)) {
            this.mine();
        }
    }
}
