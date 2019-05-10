package Main;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

public final class ImageHandler {    // Class that holds all images
    

    public static ImageIcon logoIcon;
    public static ImageIcon playerIcon;      
    public static ImageIcon swordIcon;
    public static ImageIcon bowIcon;
    public static ImageIcon hpIcon;
    public static ImageIcon hp2Icon;
    public static ImageIcon regenIcon;
    public static ImageIcon poisonIcon;
    public static ImageIcon coin1Icon;
    public static ImageIcon coin2Icon;
    public static ImageIcon coin3Icon;
    public static ImageIcon chestIcon;
    public static ImageIcon lockchestIcon;
    public static ImageIcon keyIcon;
    public static ImageIcon bombIcon;
    public static ImageIcon powderIcon;
    public static ImageIcon swordlg1Icon;
    public static ImageIcon swordlg2Icon;
    public static ImageIcon swordlg3Icon;
    public static ImageIcon enemy_t2;
    public static ImageIcon enemy_t1;
    public static ImageIcon enemy_r1;
    public static ImageIcon enemy_s2;
    public static ImageIcon enemy_s1;
    public static ImageIcon enemy_d3;
    public static ImageIcon enemy_d2;
    public static ImageIcon enemy_d1;
    
    
    public ImageHandler() {
        
        logoIcon = loadImageIcon("logo.png");        
        playerIcon = loadImageIcon("player.png");
        swordIcon = loadImageIcon("sword.png");
        bowIcon = loadImageIcon("bow.png");
        hpIcon = loadImageIcon("hp.png");
        hp2Icon = loadImageIcon("hp2.png");
        regenIcon = loadImageIcon("regen.png");
        poisonIcon = loadImageIcon("poison.png");
        coin1Icon = loadImageIcon("coin1.png");
        coin2Icon = loadImageIcon("coin2.png");
        coin3Icon = loadImageIcon("coin3.png");
        chestIcon = loadImageIcon("chest.png");
        lockchestIcon = loadImageIcon("lockchest.png");
        keyIcon = loadImageIcon("key.png");
        bombIcon = loadImageIcon("bomb.png");
        powderIcon = loadImageIcon("powder.png");
        swordlg1Icon = loadImageIcon("sword_lg1.png");
        swordlg2Icon = loadImageIcon("sword_lg2.png");
        swordlg3Icon = loadImageIcon("sword_lg3.png");
        enemy_t2 = loadImageIcon("enemy_t2.png");
        enemy_t1 = loadImageIcon("enemy_t1.png");
        enemy_r1 = loadImageIcon("enemy_r1.png");
        enemy_s2 = loadImageIcon("enemy_s2.png");
        enemy_s1 = loadImageIcon("enemy_s1.png");
        enemy_d3 = loadImageIcon("enemy_d3.png");
        enemy_d2 = loadImageIcon("enemy_d2.png");
        enemy_d1 = loadImageIcon("enemy_d1.png");
        
    }
    
    
    private static ImageIcon loadImageIcon(String path) {   
            return new ImageIcon(Toolkit.getDefaultToolkit().getImage(ImageHandler.class.getResource("/resources/"+path)));
    }
    
}
