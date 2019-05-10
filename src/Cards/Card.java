
package Cards;

import java.awt.Color;
import javax.swing.Icon;

public abstract class Card {
    
    public final int BASE_VALUE;
    
    private int health;
    private Color color;
        
    public Card(Color color, int health) {
        super();
        BASE_VALUE = health;
        this.health = health;
        this.color = color;
    }
    
    public void update() {}
    
    public Card interact(Player player) {
        return null;
    }
    
    public Icon getIcon() {
        return null;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    public String toString() {
        return Integer.toString(health);
    }
}
