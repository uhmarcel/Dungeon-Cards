
package Cards;

import Main.ImageHandler;
import java.awt.Color;
import java.util.Random;
import javax.swing.Icon;

public class PoisonPotion extends Card {

    public PoisonPotion() {
        super(new Color(230,120,255), new Random().nextInt(6)+1);
    }
    
    public Card interact(Player player) {
        if (player.getHealth() > this.getHealth())
            player.setHealth(player.getHealth()-this.getHealth());
        else
            player.setHealth(1);
        player.setStatus(Player.POISONED);
        return null;
    }
    
    public Icon getIcon() {
        return ImageHandler.poisonIcon;
    }
    
}
