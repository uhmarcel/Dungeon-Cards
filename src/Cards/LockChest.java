
package Cards;

import Main.Data;
import Main.Engine;
import Main.ImageHandler;
import java.util.Random;
import javax.swing.Icon;

public class LockChest extends Card {
 
    public LockChest() {
        super(new Coin().getColor(), 1);
        if (isThereLockChestOnBoard(Engine.getCards()))
            setHealth(0);
    }
    
    public Card interact(Player player) {
        if (!player.hasKey())
            return this;
        player.useKey();
        Card out;
   /*     switch (new Random().nextInt(4)) {
            case 0:
                out = new HealthPotion();
                out.setHealth(Data.max_health);
                break;
            case 1: 
                out = new RegenPotion();
                out.setHealth(Data.max_health);
                break;
            case 2:
                out = new Weapon();
                out.setHealth(Data.max_weapons);
                break;
            default:
                out = new Coin(new Random().nextInt(80)+1);
                break;*/
        switch (new Random().nextInt(3)) {
            case 0:
                out = new LegenSwords.LegenSword1();
                break;
            case 1: 
                out = new LegenSwords.LegenSword2();
                break;
            case 2:
                out = new LegenSwords.LegenSword3();
                break;
            default:
                out = new Coin(new Random().nextInt(80)+1);
                break;
        }
        return out;
    }
    
    public static boolean isThereLockChestOnBoard(Card[] stack) {
        for (Card current : stack) {
            if (current instanceof LockChest)
                return true;
        }
        return false;
    }
    
    public Icon getIcon() {
        return ImageHandler.lockchestIcon;
    }
    
    public String toString() {
        return new String();
    }
}