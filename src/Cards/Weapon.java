package Cards;

import Main.Data;
import Main.ImageHandler;
import java.awt.Color;
import java.util.Random;
import javax.swing.Icon;

public class Weapon extends Card {
    
    public Weapon() {
        super(new Color(160,160,240), (new Random().nextInt(Data.max_weapons)+1));
    }
    
    public Weapon(Color color, int value) {
        super(color, value);
    }
    
    public Icon getIcon() {
        if (this.BASE_VALUE < 8)
            return ImageHandler.bowIcon;
        else 
            return ImageHandler.swordIcon;
    }
    
    public Card interact(Player player) {
        if (player.getDamage() < this.getHealth()) 
            player.setDamage(this.getHealth());
        return null;
    }
    
}
