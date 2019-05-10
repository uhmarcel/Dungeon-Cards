
package Cards;


import Main.Engine;
import Main.ImageHandler;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;

public class Bomb extends Card {
    
    private int timer;
    
    public Bomb() {
        super(Color.darkGray, new Random().nextInt(10)+1);        
        timer = 4;
    }
    
    public void update() {
        timer--;
        if (timer == 0) {
            explode();
            setHealth(0);            
        }
    }
   
    public Icon getIcon() {
        return ImageHandler.bombIcon;
    }
    
    public String toString() {
        return timer+"      "+this.getHealth();
    }
    
    public Card interact(Player player) {
        int i = Engine.getPosition(player);
        Engine.getCards()[i] = this;
        return player;
    }
    
    private void explode() {
        ArrayList<Card> targets = Engine.getAdjacentCards(this);
        for (Card current : targets) {
            current.setHealth(current.getHealth() - this.getHealth());
        }
    }   
  
}
