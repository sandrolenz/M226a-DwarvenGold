import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dirt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dirt extends Actor
{
    GreenfootImage textureEnemy = new GreenfootImage("texture_dirt-enemy.png");
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
    
    /**
     * Act - do whatever the Dirt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        checkClick();
    }
    
    public void mine() {
        Greenfoot.playSound("dirtMine.mp3");
        Mine mine = (Mine)getWorld();
        DirtMined dirtmined = new DirtMined();
        mine.addObject(dirtmined, this.getX(), this.getY());
        mine.setDurability(-1);
        if (this.isOre) {
            mine.setScore(this.value);
            Greenfoot.playSound("oreMine.mp3");
        }
        if (this.isEnemy) {
            mine.setHealth(-1);
            Greenfoot.playSound("spiderAttack.mp3");
            Greenfoot.playSound("dwarfHurt.mp3");
        }
        mine.removeObject(this);
    }
    
    public void showOre() {
        setImage(new GreenfootImage("texture_ore-" + this.ore + ".png"));
    }
    
    private void checkClick() {
        if (Greenfoot.mouseClicked(this)) {
            this.mine();
        }
    }
}
