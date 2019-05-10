package GUI;

import Main.Data;
import Main.ImageHandler;
import java.awt.*;
import javax.swing.*;

public class App extends JFrame {
    
    public static final int MENU = 0;
    public static final int SHOP = 1;
    public static final int GAME = 2;
    
    private JPanel currentPanel;
        
    public App() {
        
        super("Card Maze");
        new ImageHandler();
        new Data();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(240,320);
        this.setResizable(false);
        
        currentPanel = new MenuPanel();
        this.add(currentPanel);
        
        this.setVisible(true);
    }
    
    
    public void moveToPanel(int state) {
        Data.saveData();
        getContentPane().removeAll();
        switch (state) {
            case MENU:
                currentPanel = new MenuPanel();
                break;
            case SHOP:
                currentPanel = new ShopPanel();
                break;
            case GAME:
                currentPanel = new GamePanel();
                break;
            default:
                currentPanel = new MenuPanel();
                break;
        }
        this.add(currentPanel);
        this.validate();
        this.repaint();
    }

    public static GridBagConstraints setConstraints(int gx, int gy, int gw, int gh, int fill, int i) {
        GridBagConstraints out = new GridBagConstraints();
        out.fill = fill;
        out.gridx = gx;
        out.gridy = gy;
        out.gridwidth = gw;
        out.gridheight = gh;
        out.weightx = 0.5;
        out.insets = new Insets(i,i,i,i);
        return out;
    }    
    
    public static void applyAppStyle(JPanel target, int style) {
        switch (style) {
            case 0:
                target.setBackground(Color.darkGray);
                break;
            case 1:
                target.setBackground(new Color(100,100,100));
                break;
        }
    }
    
    
    public static void applyAppStyle(JLabel target, int style) {
        switch (style) {
            case 0:            
                target.setFont(new Font(null,Font.BOLD,12));
                target.setForeground(new Color(230,180,80));
                break;
            case 1:
                target.setForeground(new Color(230,180,80));
                target.setFont(new Font("Calibri",Font.ITALIC,20));
                target.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case 2:
                target.setForeground(new Color(230,180,80));
                target.setFont(new Font("Calibri",Font.BOLD,18));
                target.setHorizontalAlignment(SwingConstants.CENTER);
                break;
        }
    } 
    
    
    public static App getAppReference(Container current) {
        while (current instanceof App == false) { 
            current = current.getParent();
        }
        return (App) current;
    }
    
    
    public void update() {
        //currentPanel.update();
    }
    
}
