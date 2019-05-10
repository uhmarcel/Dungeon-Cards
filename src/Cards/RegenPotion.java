
package Cards;

import Main.ImageHandler;
import java.awt.Color;
import java.util.Random;
import javax.swing.Icon;

public class RegenPotion extends Card {
    
    public RegenPotion() {
        super(new Color(110,80,255), new Random().nextInt(6));
    }
    
    public Card interact(Player player) {
        player.setHealth(player.getHealth()+this.getHealth());
        player.setStatus(Player.HEALING);
        return null;
    }
    
    public Icon getIcon() {
        return ImageHandler.regenIcon;
    }
    
}
