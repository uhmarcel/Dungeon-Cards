
package Main;

import Cards.*;
import java.util.ArrayList;
import java.util.Random;



public class Engine {
    
    private static Card[] cards;
    
    private static int playerPosition;
    private static int complexity;
    private static int counter;  // **** //
    private static boolean gameOver;
    
    private static final int NORTH = 0;
    private static final int SOUTH = 1;
    private static final int EAST = 2;
    private static final int WEST = 3; 
    
    private static final int INVALID = -1;

    
    public Engine() {
        
        cards = new Card[9];
        playerPosition = 4;
        complexity = 1;
        gameOver = false;
        
        for (int i=0; i<9; i++)
            cards[i] = generateCard();
        
        cards[4] = new Player();
        
        counter = 1; //*****
    }
    
    public static void actionAt(int pos) {
        if (isActionValid(pos)) {
            cards[pos] = cards[pos].interact(getPlayer());
            if (cards[pos] == null)
                rearrangeCards(getDirection(pos));
            updateAll();
        }
    }
    
    public static void updateAll() {
        for (int i=0; i<9; i++) {
            if (cards[i] instanceof Player)
                playerPosition = i;
            cards[i].update();
        }
        
        if (getPlayer().getGold()/(counter*40) >= 1) {  //******
            Engine.incrementComplexity();
            counter++;
            System.out.println(+complexity);
        }

        cleanBoard();
    }
        
    public static void cleanBoard() {
        for (int i=0; i<9; i++) {
            if (cards[i].getHealth() <= 0) {
                if (cards[i] instanceof Enemy) {
                    cards[i] = new Coin(cards[i].BASE_VALUE);
                }  
                else if (cards[i] instanceof Player)
                        endgame();
                else
                    cards[i] = new BlankCard();
            }
        }
    }  
    
    public static void endgame() {
        Data.gold += getPlayer().getGold();
        if (Data.highscore < getPlayer().getGold())
            Data.highscore = getPlayer().getGold();
        cards[playerPosition] = new BlankCard();
        gameOver = true;
    }
    
    public static Card generateCard() {
        Random r = new Random();
        
        switch (r.nextInt(8)) {    
            case 0:  return new Enemy();
            case 1:
                switch (r.nextInt(6)) {
                    case 0:  return new Chest();
                    case 1:  return new LockChest();
                    case 2:  return new Key();
                    default: return new Coin();
                }
            case 2:  return new Weapon();
            case 3:
                switch (r.nextInt(5)) {
                    case 0:  return new PoisonPotion();
                    case 1:  return new RegenPotion();
                    default: return new HealthPotion();
                }
            case 4:  return new Bomb();
            default: return new BlankCard();
        }
    }    
    
    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } 
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
   
    private static boolean isActionValid(int pos) {
        if (cards[pos] instanceof LockChest && !getPlayer().hasKey())
            return false;
        ArrayList<Card> adjacent = getAdjacentCards(cards[pos]);
        for (Card current : adjacent) {
            if (current instanceof Player) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isGameOver() {
        return gameOver;
    }
    
    public static int getPosition(Card source) {
        for (int i=0; i<9; i++) {
            if (source == cards[i])
                return i;
        }
        return -1;
    }
    
    public static Player getPlayer() {
        return (Player) cards[playerPosition];
    }
     
    public static int getDirection(int position) {
        int difference = playerPosition - position;
        if (difference == 3)
            return NORTH;
        if (difference == -3)
            return SOUTH;
        if (position/3 == playerPosition/3) {
            if (difference == 1)
                return WEST;
            if (difference == -1)
                return EAST;
        }
        return INVALID;    
    }
    
    public static Card[] getCards() {
        return cards;
    }
    
    public static Card getCard(int position) {
        return cards[position];
    }

    public static int getComplexity() {
        return complexity;
    }
    
    public static void incrementComplexity() {
        complexity++;
    }
    
    public static ArrayList<Card> getAdjacentCards(Card source) {
        ArrayList<Card> output = new ArrayList<Card>();
        int p = getPosition(source);
        switch (p % 3) {
            case 0: 
                output.add(cards[p+1]); 
                break;
            case 1:
                output.add(cards[p-1]);
                output.add(cards[p+1]);
                break;
            case 2:
                output.add(cards[p-1]);
                break;
        }
        switch (p / 3) {
            case 0: 
                output.add(cards[p+3]); 
                break;
            case 1:
                output.add(cards[p-3]);
                output.add(cards[p+3]);
                break;
            case 2:
                output.add(cards[p-3]);
                break;
        }
        return output;
    }
    
    private static void rearrangeCards(int direction) {
        int position = playerPosition;        
        switch (direction) {
            case NORTH:
                if (position/3 == 1) {
                    cards[position-3] = cards[position];
                    cards[position] = cards[position+3];
                    cards[position+3] = generateCard();
                }
                else if (position/3 == 2) {
                    cards[position-3] = cards[position];
                    switch (position%3) {
                        case 0:
                            cards[position] = cards[position+1];
                            cards[position+1] = cards[position+2];
                            cards[position+2] = generateCard();
                            break;
                        case 1:
                            cards[position] = cards[position+1];
                            cards[position+1] = generateCard();
                            break;
                        case 2:
                            cards[position] = cards[position-1];
                            cards[position-1] = cards[position-2];
                            cards[position-2] = generateCard();
                            break;
                    }
                }
                break;
                
            case SOUTH:
                if (position/3 == 1) {
                    cards[position+3] = cards[position];
                    cards[position] = cards[position-3];
                    cards[position-3] = generateCard();
                }
                else if (position/3 == 0) {
                    cards[position+3] = cards[position];
                    switch (position%3) {
                        case 0:
                            cards[position] = cards[position+1];
                            cards[position+1] = cards[position+2];
                            cards[position+2] = generateCard();
                            break;
                        case 1:
                            cards[position] = cards[position-1];
                            cards[position-1] = generateCard();
                            break;
                        case 2:
                            cards[position] = cards[position-1];
                            cards[position-1] = cards[position-2];
                            cards[position-2] = generateCard();
                            break;
                    }
                }
                break;
                
            case WEST:
                if (position%3 == 1) {
                    cards[position-1] = cards[position];
                    cards[position] = cards[position+1];
                    cards[position+1] = generateCard();
                }
                else if (position%3 == 2) {
                    cards[position-1] = cards[position];
                    switch (position/3) {
                        case 0:
                            cards[position] = cards[position+3];
                            cards[position+3] = cards[position+6];
                            cards[position+6] = generateCard();
                            break;
                        case 1:
                            cards[position] = cards[position-3];
                            cards[position-3] = generateCard();
                            break;
                        case 2:
                            cards[position] = cards[position-3];
                            cards[position-3] = cards[position-6];
                            cards[position-6] = generateCard();
                            break;
                    }
                }
                break;
                
            case EAST:
                if (position%3 == 1) {
                    cards[position+1] = cards[position];
                    cards[position] = cards[position-1];
                    cards[position-1] = generateCard();
                }
                else if (position%3 == 0) {
                    cards[position+1] = cards[position];
                    switch (position/3) {
                        case 0:
                            cards[position] = cards[position+3];
                            cards[position+3] = cards[position+6];
                            cards[position+6] = generateCard();
                            break;
                        case 1:
                            cards[position] = cards[position+3];
                            cards[position+3] = generateCard();
                            break;
                        case 2:
                            cards[position] = cards[position-3];
                            cards[position-3] = cards[position-6];
                            cards[position-6] = generateCard();
                            break;
                    }
                }
                break;
        }   
    }
    
}
