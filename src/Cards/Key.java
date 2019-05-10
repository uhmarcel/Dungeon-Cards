
package Cards;

import Main.ImageHandler;
import javax.swing.Icon;

public class Key extends Card {
    
    public Key() {
        super(new Coin().getColor(), 1); 
    }
    
    public Card interact(Player player) {
        player.addKey();
        return null;
    }
    
    public Icon getIcon() {
        return ImageHandler.keyIcon;
    }
    
    public String toString() {
        return new String();
    }
    
}
