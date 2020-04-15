package CombatBetas;

import java.util.Random;
import java.util.Scanner;


//now has mana. the enemy can now heal themselves a limited # of times, and higher hp. player now has a magical attack.
//*needs to be fine-tuned in a couple places. you'll see when you run it
public class CombatSemiAdvancedBeta {
    public static Random rand = new Random();
    public static Scanner input = new Scanner(System.in);
    public static int playerHealth = 50, playerHealthMax = 50, playerMana = 40, playerMeleeDmgMax = 10, playerFireballDmgMax = 12, playerHealMax = 9;
    public static int playerFireBallCost = 15, playerHealCost = 12;
    public static String enemyName = "Goblin Slave";
    public static int enemyHealth = 40, enemyHealthMax, enemyMana = 20, enemyAttackDamageMax = 9, enemyHealMax = 7, enemyHealCost = 10;
    public static void main(String[] args) {
        System.out.println(enemyName+ " approached you.");
        attackEnemy();
    }

    public static int attackEnemy(){
        int action;
        try {
            System.out.println("[1] Melee Attack \n[2] Fireball (cost: " + playerFireBallCost + " mana)\n[3] Heal (cost: " + playerHealCost + " mana)");
            action = input.nextInt();
        }
        catch(Exception x){
            System.out.println("Error. Invalid Entry. Try again");
            System.out.println("[1] Melee Attack \n[2] Fireball (cost: " + playerFireBallCost + " mana)\n[3] Heal (cost: " + playerHealCost + " mana)");
            action = input.nextInt();
        }
        switch(action){
            case 1:
                int attack = rand.nextInt(playerMeleeDmgMax);
                enemyHealth -= attack;
                if(enemyHealth <= 0){
                    enemyHealth = 0;
                    System.out.println(enemyName+ " has been defeated.");
                }
                else{
                    System.out.println("You attacked for " +attack+ " damage. "+enemyName+ " has " +enemyHealth+ " hp remaining.");
                    attackPlayer();
                    return enemyHealth;
                }
                return enemyHealth;
            case 2:
                attack = rand.nextInt(playerFireballDmgMax);
                if(playerMana-playerFireBallCost < 0){
                    System.out.println("You don't have enough mana.");
                    attackEnemy();
                }
                else{
                    enemyHealth -= attack;
                    playerMana -= playerFireBallCost;
                    if(enemyHealth <= 0){
                        enemyHealth = 0;
                        System.out.println(enemyName+ " has been defeated");
                    }
                    else {
                        System.out.println("You attacked for " + attack + " damage. " + enemyName + " has " + enemyHealth + " hp remaining");
                        attackPlayer();
                    }
                    return playerMana;
                }
                return enemyHealth;
            case 3:
                int heal = rand.nextInt(playerHealMax);
                if(playerHealth-playerHealCost < 0){
                    System.out.println("You don't have enough mana.");
                    attackEnemy();
                }
                else{
                    playerHealth += heal;
                    playerHealth = (playerHealth > playerHealthMax) ? playerHealthMax:playerHealth;
                    System.out.println("You healed yourself for " +heal+ " hp. You now have " +playerHealth);
                    attackPlayer();
                }
                return playerHealth;
        }
        return enemyHealth;
    }

    public static int attackPlayer(){
        if(enemyHealth <=10 && enemyMana-enemyHealCost>=0){
            int heal = rand.nextInt(enemyHealMax);
            enemyMana -= enemyHealCost;
            enemyHealth += heal;
            System.out.println(enemyName+ " healed for " +heal+ " hp. " +enemyName+ " now has " +enemyHealth+ " hp.");
            attackEnemy();
            return enemyHealth;
        }
        else{
            int attack = rand.nextInt(enemyAttackDamageMax);
            playerHealth -= attack;
            if(playerHealth <= 0){
                playerHealth = 0;
                System.out.println("You dieded, fucking dumbass.");
            }
            else{
                System.out.println(enemyName+ " attacked you for " +attack+ " damamge. You have " +playerHealth+ " hp remaining.");
                attackEnemy();
                return playerHealth;
            }
        }
        return playerHealth;
    }

}