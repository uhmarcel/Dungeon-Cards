
package Cards;

import Main.ImageHandler;
import java.util.Random;
import javax.swing.Icon;

public class Chest extends Card {

    public Chest() {
        super(new Coin().getColor(), 1);
    }
    
    public Card interact(Player player) {
        Card out;
        switch (new Random().nextInt(6)) {
            case 0:
                out = new HealthPotion();
                break;
            case 1: 
                out = new RegenPotion();
                break;
            case 2:
                out = new Weapon();
                break;
            default:
                out = new Coin(new Random().nextInt(40)+1);
                break;
        }
        return out;
    }
    
    public Icon getIcon() {
        return ImageHandler.chestIcon;
    }
    
    public String toString() {
        return new String();
    }
}
