
package Cards;

import Main.Data;
import Main.ImageHandler;
import java.awt.Color;
import java.util.Random;
import javax.swing.Icon;


public class LegenSwords {
    
    public static final Color COLOR = new Coin().getColor();
    
    public static class LegenSword1 extends Weapon {
        public LegenSword1() {
            super(COLOR, new Random().nextInt(Data.max_weapons*2)+Data.max_weapons);
        }
        public Icon getIcon() {
            return ImageHandler.swordlg1Icon;
        }
    } 
    
    public static class LegenSword2 extends Weapon {
        public LegenSword2() {
            super(COLOR, new Random().nextInt(Data.max_weapons*2)+Data.max_weapons);
        }
        public Icon getIcon() {
            return ImageHandler.swordlg2Icon;
        }
    } 
    
    public static class LegenSword3 extends Weapon {
        public LegenSword3() {
            super(COLOR, new Random().nextInt(Data.max_weapons*2)+Data.max_weapons);
        }
        public Icon getIcon() {
            return ImageHandler.swordlg3Icon;
        }
    } 
    
}
