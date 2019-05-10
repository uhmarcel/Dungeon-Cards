package Cards;

import Main.ImageHandler;
import java.awt.Color;
import java.util.Random;
import javax.swing.Icon;

public class HealthPotion extends Card {
    
    public HealthPotion() {
        super(new Color(255,150,150), (new Random().nextInt(11)+1));
    }
    
    public Icon getIcon() {
        if (this.BASE_VALUE < 8)
            return ImageHandler.hpIcon;
        else 
            return ImageHandler.hp2Icon;
    }
    
    public Card interact(Player player) {
        player.setHealth(player.getHealth() + this.getHealth());
        if (player.getStatus() == Player.POISONED)
            player.setStatus(Player.NORMAL);
        return null;
    }
    
}
