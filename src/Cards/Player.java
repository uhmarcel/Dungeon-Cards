package Cards;

import Main.Data;
import Main.ImageHandler;
import java.awt.Color;
import javax.swing.Icon;

public class Player extends Card {
    
    public static final Color COLOR = new Color(255,80,90);
    
    public static final int NORMAL = 0;
    public static final int POISONED = 1;
    public static final int HEALING = 2;
    
    private int status;
    private int weapon;
    private int damage;
    private int gold;
    private int keys;
  
    public Player() {
        super(COLOR, Data.max_health);
        this.status = NORMAL;
        this.damage = 10;
        this.gold = 0;
        this.keys = 0;
    }
    
    public void update() {
        switch (status) {
            case NORMAL:
                break;
            case POISONED:
                if (getHealth() > 1)
                    setHealth(getHealth()-1);
                break;
            case HEALING:
                if (getHealth() < Data.max_health)
                    setHealth(getHealth()+1);
                else
                    status = NORMAL;
                break;
        }
    }
    
    public Color getColor() {
        switch (status) {
            case POISONED:
                return new PoisonPotion().getColor();
            case HEALING:
                return new RegenPotion().getColor();
            default:
                return COLOR;
        }
    }
    
    public void addKey() {
        this.keys++;
    }
    
    public void useKey() {
        this.keys--;
    }
    
    public boolean hasKey() {
        return keys > 0;
    }
    
    public int getStatus() {
        return status;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public int getGold() {
        return gold;
    }
    
    public Icon getIcon() {
        return ImageHandler.playerIcon;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public void setDamage(int weapon) {
        this.damage = weapon;
    }
    
    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public void setHealth(int health) {
        super.setHealth(health);
        if (this.getHealth() > Data.max_health)
            super.setHealth(Data.max_health);
    }
    
    public String toString() {
        return getHealth() + "   " + getDamage();
    }
    
}
