
package GUI;

import Main.Data;
import Main.ImageHandler;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MenuPanel extends JPanel implements ActionListener {
    
    private LogoPanel logoPanel;
    private ButtonsPanel buttonsPanel;
    
    public MenuPanel() {
        super();
        App.applyAppStyle(this, 1);
        this.setLayout(new GridBagLayout());
        logoPanel = new LogoPanel();
        buttonsPanel = new ButtonsPanel();
        this.add(logoPanel,App.setConstraints(0,0,1,2,GridBagConstraints.HORIZONTAL,0));
        this.add(buttonsPanel,App.setConstraints(0,2,1,3,GridBagConstraints.HORIZONTAL,0));
    }
    
    
    private class LogoPanel extends JPanel {
        private JLabel imageLabel;
        public LogoPanel() {
            super();
            App.applyAppStyle(this, 0);
            imageLabel = new JLabel();
            imageLabel.setIcon(ImageHandler.logoIcon);
            this.add(imageLabel);
        }
    }
    
    
    private class ButtonsPanel extends JPanel {
        private JLabel highscoreLabel;
        private JLabel goldLabel;
        private JButton[] buttons;
        public ButtonsPanel() {
            super();
 
            buttons = new JButton[3];
            App.applyAppStyle(this, 0);
            setLayout(new GridLayout(0,1,0,10));
            
            highscoreLabel = new JLabel();
            goldLabel = new JLabel();
            App.applyAppStyle(highscoreLabel,1);
            App.applyAppStyle(goldLabel,1);
            this.add(highscoreLabel);
            this.add(goldLabel);
            update();
            
            buttons[0] = new JButton("Play");
            buttons[1] = new JButton("Shop");
            buttons[2] = new JButton("Exit");
            
            for (JButton current : buttons) {
                current.addActionListener(MenuPanel.this);
                current.setFont(new Font(null,0,18));
                this.add(current);
            }
        }
        private void update() {
            highscoreLabel.setText("Highscore: " + Data.highscore);
            goldLabel.setText("Gold: " + Data.gold);
        }
    }
    
    public void update() {
        this.buttonsPanel.update();
        this.revalidate();
        this.repaint();
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        Container current = this;
        while (current instanceof App == false) 
            current = current.getParent();
        App reference = (App) current;
        JButton source = (JButton) ae.getSource();
        switch (source.getText()) {
            case "Play":
                reference.moveToPanel(App.GAME);
                break;
            case "Shop":
                reference.moveToPanel(App.SHOP);
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }
    
}
