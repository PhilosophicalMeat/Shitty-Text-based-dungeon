package CombatBetas;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//the enemy is smarter, damage, mana, and hp increased
public class CombatAdvancedBeta {
    public static Random rand = new Random();
    public static Scanner input = new Scanner(System.in);
    public static String enemyName = "Golbin Soldier";
    public static int playerHealth = 100, playerMana = 75;
    public static int playerHealthMax = 100, playerManaMax = 75, playerMeleeDamageMax = 20, playerFireBallDamageMax = 30, playerHealMax= 20;
    public static int playerFireBallCost = 20, playerHealCost = 18;
    public static int enemyHealthMax = 85, enemyMeleeDamageMax = 17;
    public static int[] playerStats;
    public static String[] tempTextStats;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Ethan\\Desktop\\why am i like this\\AdvancedCombatBetaStats.txt"));

    }



    /*public static void performPlayerAction(){
        try{
            System.out.println("------------------------------------------------------------------------------------" +
                    "\n[1] Melee Attack (Max Damage: "+playerMeleeDamageMax +
                    "\n[2] Fireball (Max Damage: "+playerFireBallDamageMax+ ", Mana Cost: " +playerFireBallCost+
                    "\n[3] Heal (Max Hp Restored: " +playerHealMax+ ", Mana Cost: " +playerHealCost);
            int action = input.nextInt();
        }
        catch(Exception action){
            System.out.println("Invalid entry. Please try again");
            performPlayerAction();
        }
*/



}
//*why not try to use classes and constructors this time?