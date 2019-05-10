
package GUI;

import Main.Engine;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GamePanel extends JPanel {
    
    private TitlePanel titlePanel;
    private GameBoard gameBoard;
    
    public GamePanel() {
        super();
        new Engine();
        titlePanel = new TitlePanel();
        gameBoard = new GameBoard();
        
        this.setLayout(new BorderLayout());
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(gameBoard, BorderLayout.CENTER);
        
    }
    
    public class TitlePanel extends JPanel {   
        private JLabel title;
        
        public TitlePanel() {
            super();
            title = new JLabel();
            App.applyAppStyle(this, 0);
            App.applyAppStyle(title, 0);
            this.setBorder(BorderFactory.createEtchedBorder());
            this.add(title);        
            update(0);
        }

        public void update(int gold) {
            title.setText("                          Game Title             Gold: " + gold);
        }
        
    }
    
    public class GameBoard extends JPanel implements ActionListener {
    
        private CardButton[] buttons;

        public GameBoard() {
            super();
            this.setBorder(BorderFactory.createCompoundBorder());
            this.setLayout(new GridLayout(3,3,3,3));
            App.applyAppStyle(GamePanel.this, 0);
            buttons = new CardButton[9];
            for (int i=0; i<9; i++) {   
                buttons[i] = new CardButton();
                buttons[i].addActionListener(GamePanel.GameBoard.this);
                add(buttons[i]);
            }
            refreshButtons();   
        }

        public void actionPerformed(ActionEvent ae) {
            int position = getButtonPosition((JButton) ae.getSource());
            Engine.actionAt(position);
            refreshButtons();
            if (Engine.isGameOver())  {
                Engine.delay(2000);
                App.getAppReference(this).moveToPanel(App.MENU);
            }
        }

        public int getButtonPosition(JButton source) {
            for (int i=0; i<9; i++) {
                if (source == buttons[i])
                    return i;
            }
            return -1;
        }   

        public void refreshButtons() {
            for (int i=0; i<9; i++) {
                buttons[i].setBackground(Engine.getCard(i).getColor());
                buttons[i].setIcon(Engine.getCard(i).getIcon());
                buttons[i].setText(Engine.getCard(i).toString());
            }
            if (!Engine.isGameOver())
                titlePanel.update(Engine.getPlayer().getGold());

            this.validate();
            this.repaint();
        }
        
    }
    
    public class CardButton extends JButton {
    
        private JPanel imagePanel;
        private JLabel imageLabel;
        private JPanel textPanel;
        private JLabel textLabel;

        public CardButton() {
            super();

            imagePanel = new JPanel();
            imageLabel = new JLabel();
            textPanel = new JPanel();
            textLabel = new JLabel();
            this.setLayout(new BorderLayout());
            textPanel.setLayout(new BorderLayout());
            imagePanel.add(imageLabel);
            textPanel.add(textLabel);
            this.add(textPanel, BorderLayout.SOUTH);
            this.add(imagePanel, BorderLayout.CENTER);
        }

        public void setIcon(Icon icon) {
            imageLabel.setIcon(icon);
        }

        public void setText(String text) {
            textLabel.setText(text);
        }

    }
    
}
