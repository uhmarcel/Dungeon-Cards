
package Cards;

import Main.ImageHandler;
import java.awt.Color;
import javax.swing.Icon;


public class Powder extends Card {
        
        public Powder() {
            super(Color.darkGray, 1);
        }
        
        public Card interact(Player player) {
            return null;
        }
        
        public void update() {
                //setHealth(0);
        }
        
        public Icon getIcon() {
            return ImageHandler.powderIcon;
        }
        
        public String toString() {
            return new String();
        }
        
    }