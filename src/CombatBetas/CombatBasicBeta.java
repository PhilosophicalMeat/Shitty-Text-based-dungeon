package CombatBetas;

import java.util.Random;
import java.util.Scanner;

//the  enemy can only attack, and the player only  has a melee attack and the ability to heal
public class CombatBasicBeta {
    public static Random rand = new Random();
    public static Scanner input = new Scanner(System.in);
    public static int playerHealth = 20, playerDamageMax = 10, playerHealMax = 8;
    public static void main(String[] args) {
        createEnemy("Goblin", 12,6);
    }

    public static void createEnemy(String enemyName, int enemyHealth, int enemyDamageMax){
        System.out.println("You have encountered " +enemyName);
        playerAttack(enemyName, playerDamageMax, enemyHealth, enemyDamageMax);
    }
    public static int enemyAttack(String enemyName, int maxDmg, int enemyHpTemp){
        System.out.println(enemyName+ "'s turn.");
        int attack = rand.nextInt(maxDmg);
        playerHealth -= attack;
        if(playerHealth <= 0){
            playerHealth = 0;
            System.out.println("You lost the fight");
        }
        else{
            System.out.println(enemyName+ " attacked you for " +attack+ " damage. " +playerHealth+ " Hp remaining.");
            playerAttack(enemyName, playerDamageMax, enemyHpTemp, maxDmg);
        }
        return playerHealth;
    }
    public static void playerAttack(String enemyName, int playerDmgTemp, int enemyHpTemp, int enemyAttackDmg){
        System.out.println("Your turn: \n[1] Attack \n[2] Heal");
        int numIn = input.nextInt();
        if(numIn == 1){
            int attack = rand.nextInt(playerDmgTemp);
            enemyHpTemp -= attack;
            if (enemyHpTemp <= 0) {
                enemyHpTemp = 0;
                System.out.println("You have defeated " + enemyName);
            } else {
                System.out.println("You attacked " + enemyName + " for " + attack + " damage. Enemy has " + enemyHpTemp + " hp remaining.");
                enemyAttack(enemyName, enemyAttackDmg, enemyHpTemp);
            }
        }
        else if(numIn == 2){
            int heal = rand.nextInt(playerHealMax);
            playerHealth += heal;
            playerHealth = (playerHealth > 20) ? 20:playerHealth;
            System.out.println("Player has regained " +heal+ " hp. You now have " +playerHealth+ " hp.");
            enemyAttack(enemyName, enemyAttackDmg, enemyHpTemp);
        }
    }

}

/*
class Enemy{
    public static Random randEnemy = new Random(2);
    public static String enemyName;
    public static int enemyHealth, enemyDamageMax, enemyHealMax;
    public static String getName(String nameTemp){
        return enemyName = nameTemp;
    }

    public static void getStats(int hpTemp, int dmgTemp, int healTemp){
        enemyHealth = hpTemp;
        enemyDamageMax = dmgTemp;
        enemyHealMax = healTemp;
    }
    public void attack(int playerHealth){
        int attackDamage = randEnemy.nextInt(enemyDamageMax);

    }
}*/
