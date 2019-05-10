package Cards;

import Main.ImageHandler;
import java.awt.Color;
import java.util.Random;
import javax.swing.Icon;

public class Coin extends Card {
    
    public static final Color color = new Color(255,255,100);
    
    public Coin() {
        super(color, (new Random().nextInt(11)+1));
    }
    
    public Coin(int value) {
        super(color, value + (new Random().nextInt(5)-2));
        if (getHealth() < 1)
            setHealth(1);
    }
    
    public Icon getIcon() {
        if (BASE_VALUE<13) 
            return ImageHandler.coin1Icon;
        else if (BASE_VALUE<21)
            return ImageHandler.coin2Icon;
        else
            return ImageHandler.coin3Icon;
    }
    
    public Card interact(Player player) {
        
        player.setGold(player.getGold() + this.getHealth());
        return null;
        
    }
    
}
