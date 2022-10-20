import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dirt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dirt extends Actor
{
    GreenfootImage textureSilver = new GreenfootImage("texture_ore-silver.png");
    GreenfootImage textureGold = new GreenfootImage("texture_ore-gold.png");
    GreenfootImage textureMined = new GreenfootImage("texture_dirt-mined.png");
    String ore;
    boolean isOre;
    boolean isMined = false;
    int value;
    public Dirt(int oreType) {
        switch(oreType) {
            case 1:
                isOre = true;
                ore = "silver";
                value = 10;
                setImage(textureSilver);
                break;
            case 2:
                isOre = true;
                ore = "gold";
                value = 20;
                setImage(textureGold);
                break;
            default:
                isOre = false;
                ore = "none";
                value = 0;
                break;
        }
    }
    
    /**
     * Act - do whatever the Dirt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        checkClick();
    }
    
    public void mine() {
        isMined = true;
        setImage(textureMined);
        Mine mine = (Mine)getWorld();
        mine.setDurability(-1);
        mine.setScore(this.value);
    }
    
    private void checkClick() {
        if (Greenfoot.mouseClicked(this)) {
            if(this.isMined == false) {
                this.mine();
            }
        }
    }
}
