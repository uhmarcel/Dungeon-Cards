
package Main;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Data {
        
    private static final String filename = "saved.txt"; 
            
    public static int gold;
    public static int highscore;
    public static int max_health;
    public static int max_weapons;
    
    public Data() {
        try {
            loadData();
        }
        catch (IOException e) {
            gold = 0;
            highscore = 0;
            max_health = 10;
            max_weapons = 12;
        }
    }
    
    public static void loadData() throws IOException {
        Scanner scanner = new Scanner(new File(filename));
        gold = scanner.nextInt();
        highscore = scanner.nextInt();
        max_health = scanner.nextInt();
        max_weapons = scanner.nextInt();
        scanner.close();
    }
   
    public static void saveData() {
        try {
            PrintWriter writer = new PrintWriter(filename);
            writer.println(gold);
            writer.println(highscore);
            writer.println(max_health);
            writer.println(max_weapons);
            writer.close();
        }
        catch(IOException e) {
            System.out.println("Couldn't save data.");
        }
    }
}
