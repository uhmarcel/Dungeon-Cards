
package GUI;

import Main.Data;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class ShopPanel extends JPanel implements ActionListener {

    private ItemPanel items[];
    private JLabel goldLabel;
    private ReturnButton exit;
    
    public ShopPanel() {
        super();
        goldLabel = new JLabel();
        items = new ItemPanel[2];        
        items[0] = new ItemPanel();
        items[1] = new ItemPanel();
        exit = new ReturnButton();
        
        App.applyAppStyle(this, 0);
        App.applyAppStyle(goldLabel,1);
        setLayout(new GridLayout(0,1,0,20));
        
        add(goldLabel);
        add(items[0]);
        add(items[1]);
        add(exit);
        
        update();
    }
    
    
    private void update() {
        goldLabel.setText("Gold: " + Data.gold);
        items[0].update("Max health = "+Data.max_health,(Data.max_health-9)*20);
        items[1].update("Better weapons = "+Data.max_weapons,(Data.max_weapons-11)*10);
       
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        JButton source = (JButton) ae.getSource();
        int cost = Integer.parseInt(source.getText());
        if (Data.gold < cost)
            return;
        Data.gold -= cost;
        if (source == items[0].getButton())
            Data.max_health += 1;     
        else if (source == items[1].getButton()) 
            Data.max_weapons += 1;
        update();           
    }
    
    
    private class ItemPanel extends JPanel {
        private JLabel label;
        private JButton button;
        public String tag;
        
        public ItemPanel() {
            super();
            this.setLayout(new BorderLayout());
            label = new JLabel();
            App.applyAppStyle(label, 2);
            App.applyAppStyle(this, 1);
            button = new JButton();
            button.addActionListener(ShopPanel.this);
            this.add(label, BorderLayout.CENTER);
            this.add(button, BorderLayout.EAST);
        }
        
        public void update(String text, int cost) {
            label.setText(text);
            button.setText(Integer.toString(cost));
        }
        
        public JButton getButton() {
            return button;
        }
    }
    
    private class ReturnButton extends JPanel implements ActionListener {
        private JButton button;
        public ReturnButton() {
            super();
            App.applyAppStyle(this, 0);
            button = new JButton("Return");
            button.addActionListener(ShopPanel.ReturnButton.this);
            this.add(button);
        }
        
        public void actionPerformed(ActionEvent ae) {
            App.getAppReference(this).moveToPanel(App.MENU);
        }
    }

}

    
    