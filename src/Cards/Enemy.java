package Cards;


import Main.Engine;
import Main.ImageHandler;
import java.awt.Color;
import java.util.Random;
import javax.swing.Icon;

public class Enemy extends Card {
    
    private Icon icon;
    
    public Enemy() {
        super(new Color(100,180,100), new Random().nextInt(5*Engine.getComplexity()+1));
        this.icon = generateIcon();
    }
    
    public Icon generateIcon() {
        if (BASE_VALUE < 10) {
            switch (new Random().nextInt(3)) {
                case 0: return ImageHandler.enemy_r1;
                case 1: return ImageHandler.enemy_d1;
                case 2: return ImageHandler.enemy_s1;
            }
        }
        if (BASE_VALUE < 16) {
            switch (new Random().nextInt(2)) {
                case 0: return ImageHandler.enemy_d2;
                case 1: return ImageHandler.enemy_s2;
            }
        }
        if (BASE_VALUE < 22) {
            return ImageHandler.enemy_d3;
        }
        if (BASE_VALUE < 27) {
            return ImageHandler.enemy_t1;
        }
        else
            return ImageHandler.enemy_t2;
    }
    
    public Icon getIcon() {
        return icon;
    }
    
    
    public Card interact(Player player) {
        if (player.getDamage() >= this.getHealth()) {
            player.setDamage(player.getDamage()-this.getHealth());
            return new Coin(this.BASE_VALUE);
        }
        if (player.getDamage() < this.getHealth() && player.getDamage() != 0) {
            this.setHealth(this.getHealth()-player.getDamage());
            player.setDamage(0);
            return this;
        }
        if (player.getHealth() > this.getHealth()) {
            player.setHealth(player.getHealth() - this.getHealth());
            return null;
        }
        else  {
            setHealth(getHealth() - player.getHealth());
            player.setHealth(0);
            return this;
        }
            
    }
    
}
