import javax.swing.JOptionPane;
import java.util.Scanner;
public class tempMovementClass{

    public static String roomName, previousRoomName, moveAction1, moveAction2, moveAction3, moveAction4, tempStringPlayerActionInput;
    public static boolean hasLoot, hasEnemy, haveVisited;
    public static int roomArrayIndex, hallwayArrayIndex, playerActionInput = 0;
    public static Scanner playerInput = new Scanner(System.in);
    //Section A Room Array
    public static String[][] AR = {{"AR1", "false", "true", "AH1", null, null, null, "false"},
            {"AR2", "false", "false", null, null, null, "AH3","false"}, {"AR3", "false", "false", null, null, null, "AH6", "false"},
            {"AR4", "false", "false", "AH5", null, null, null,"false"}, {"AR5", "false", "false", null, "AH6", null, null,"false"},
            {"AR6", "false", "false", "AH7", null, null, null,"false"}, {"AR7", "false", "false", null, null, "AH8", null,"false"},
            {"AR8", "false", "false", null, "AH10", null, null,"false"}, {"AR9", "false", "false", "AH12", null, null, null,"false"},
            {"AR10", "false", "false", null, null, null, "AH14","false"}, {"AR11", "false", "false", null, null, "AH9", null,"false"},
            {"AR12", "false", "false", null, "AH11", null, null,"false"}, {"AR13", "false", "false", null, null, null, "AH17","false"},
            {"AR14", "false", "false", null, null, "AH18", null,"false"}, {"AR15", "false", "false", "AH15", null, null, null,"false"},
            {"AR16", "false", "false", null, null, null, "AH21","false"}, {"AR17", "false", "false", "AH22", null, null, null,"false"},
            {"AR18", "false", "false", null, "AH19", null, null,"false"}, {"AR19", "false", "false", null, null, null, "AH24","false"},
            {"AR20", "false", "false", "AH29", null, null, null,"false"}, {"AR21", "false", "false", "AH28", null, null, null,"false"},
            {"AR22", "false", "false", null, "AH25", null, null,"false"}, {"AR23", "false", "false", "AH30", null, null, null,"false"},
            {"AR24", "false", "false", null, null, null, "AH35","false"}, {"AR25", "false", "false", "AH32", null, null, null,"false"},
            {"AR26", "false", "false", null, null, "AH33", null,"false"}, {"AR27", "false", "false", null, null, "AH38", null,"false"},
            {"AR28", "false", "false", "AH39", null, null, null,"false"}, {"AR29", "false", "false", "AH37", null, null, null,"false"},
            {"AR30", "false", "false", null, "AH40", null, null,"false"}, {"AR31", "false", "false", "AH41", null, null, null,"false"},
            {"AR32", "false", "false", null, "AH42", null, null,"false"}, {"AR33", "false", "false", null, "AH43", null, null,"false"}};
    //Section A Hallway Array
    public static String[][] AH = {{"AH1", null, "AR1", null, "AH2","false"}, {"AH2", "AH3", null, "AH4", null, "false"},
            {"AH3", null, "AR2", "AH2", "AH8","false"}, {"AH4", "AH2", null, "AH5", "AR3","false"},
            {"AH5", "AH4", null, "AR4", "AH12","false"}, {"AH6", null, "AR3", "AH7", "AR5","false"},
            {"AH7", "AH6", null, "AR6", "AH13","false"}, {"AH8", "AR7", "AH3", null, "AH9","false"},
            {"AH9", "AR11", "AH8", "AH10", "AH15","false"}, {"AH10", "AH9", "AR8", "AH11", null,"false"},
            {"AH11", "AH10", null, "AH12", "AR12","false"}, {"AH12", "AH11", "AH5", "AR9", "AH16","false"},
            {"AH13", null, "AH7", "AH14", null,"false"}, {"AH14", "AH13", "AR10", null, "AH18","false"},
            {"AH15", null, "AH9", "AR15", "AH19","false"}, {"AH16", null, "AH12", "AH17", null,"false"},
            {"AH17", "AH16", "AR13", null, "AH20","false"}, {"AH18", "AR14", "AH14", null, "AH22","false"},
            {"AH19", null, "AH15", "AH23", "AR18","false"}, {"AH20", null, "AH17", "AH21", "AH29","false"},
            {"AH21", "AH20", "AR16", "AH26", null,"false"}, {"AH22", null, "AH18", "AR17", "AH27","false"},
            {"AH23", "AH19", null, "AH24", "AH31","false"}, {"AH24", "AH23", "AR19", "AH25", null,"false"},
            {"AH25", "AH24", null, "AH29", "AR22","false"}, {"AH26", "AH21", null, "AH27", "AH30","false"},
            {"AH27", "AH26", "AH22", null, null,"false"}, {"AH28", null, "AH23", "AR21", "AH31","false"},
            {"AH29", "AH25", "AH20", "AR20", "AH32","false"}, {"AH30", null, "AH26", "AR23", "AH33","false"},
            {"AH31", null, "AH28", null, "AH34","false"}, {"AH32", null, "AH29", "AR25", "AH36","false"},
            {"AH33", "AR26", "AH30", null, "AH39","false"}, {"AH34", "AS1", "AH31", "AH35", "AH37","false"},
            {"AH35", "AH34", "AR24", "AH36", null,"false"}, {"AH36", "AH35", "AH32", null, "AH38","false"},
            {"AH37", null, "AH34", "AR29", "AH40","false"}, {"AH38", "AR27", "AH36", null, "AH42","false"},
            {"AH39", null, "AH33", "AR28", "AH43","false"}, {"AH40", null, "AH37", "AH41", "AR30","false"},
            {"AH41", "AH40", null, "AR31", "HR#","false"}, //this one is IMPORTANT,
            {"AH42", null, "AH38", "AH43", "AR32"}, {"AH43", "AH42", "AH39", null, "AR33","false"}};
            //Section B Room Array
            public static String[][] BR = {{"BR1", null, null, null, "BH1","false"}, {"BR2",null,null,null,"BH5","false"},
                    {"BR3",null,null,null,"BH7","false"}, {"BR","BH8",null,null,null,"false"},
                    {"BR5",null,"BH5",null,null,"false"}, {"BR6",null,null,"BH9",null,"false"},
                    {"BR7",null,null,null,"BH10","false"}, {"BR8",null,null,"BH11",null,"false"},
                    {"BR9",null,null,null,"BH11","false"}, {"BR10","BH12",null,null,null,"false"},
                    {"BR11",null,null,"BH13",null,"false"}, {"BR12",null,"BH14",null,null,"false"},
                    {"BR13",null,null,"BH18",null,"false"}, {"BR14","BH18",null,null,null,"false"},
                    {"BR15",null,null,null,"BH19","false"}, {"BR16","BH15",null,null,null,"false"},
                    {"BR17",null,null,"BH16",null,"false"}, {"BR18","BH16",null,null,null,"false"},
                    {"BR19",null,null,"BH17",null,"false"}, {"BR20","BH17",null,null,null,"false"},
                    {"BR21",null,null,"BH22",null,"false"}, {"BR22","BH22",null,null,null,"false"},
                    {"BR23","BH23",null,null,null,"false"}, {"BR24",null,null,"BH24",null,"false"}};
    //main method
    public static void main(String[] args){
        roomName = "AR1";
        getMoveActionLocation();
    }
    //ACTION CLASSES
    private static void getRoomActions(){
        previousRoomName = roomName;
        roomName = AR[roomArrayIndex][0];
        hasLoot = Boolean.parseBoolean(AR[roomArrayIndex][1]);
        hasEnemy = Boolean.parseBoolean(AR[roomArrayIndex][2]);
        moveAction1 = AR[roomArrayIndex][3];
        moveAction2 = AR[roomArrayIndex][4];
        moveAction3 = AR[roomArrayIndex][5];
        moveAction4 = AR[roomArrayIndex][6];
        AR[roomArrayIndex][7]="true";

        System.out.println("You are in room "+roomName+".");
        //getting the player's available options
        System.out.println("------------- Your Available Options: -------------");
        if(moveAction1!=null){
            System.out.print("[1]     Move to " +moveAction1+ "     (WEST)");
            checkHasVisited(moveAction1);
            checkPreviousIndex(moveAction1);
            System.out.println();
        }
        if(moveAction2!=null){
            System.out.print("[2]     Move to " +moveAction2+ "       (NORTH)");
            checkHasVisited(moveAction2);
            checkPreviousIndex(moveAction2);
            System.out.println();
        }
        if(moveAction3!=null){
            System.out.print("[3]     Move to " +moveAction3+ "       (EAST)");
            checkHasVisited(moveAction3);
            checkPreviousIndex(moveAction3);
            System.out.println();
        }
        if(moveAction4!= null){
            System.out.print("[4]     Move to " +moveAction4+ " (SOUTH)");
            checkHasVisited(moveAction4);
            checkPreviousIndex(moveAction4);
            System.out.println();
        }
        /*if(hasLoot){
            System.out.println("[5]     Search the place for LOOT");
        }*/
        System.out.println("What will you do?");
        tempStringPlayerActionInput = playerInput.nextLine();
        /*
        String tempIn = JOptionPane.showInputDialog("What will you do?");
        tempStringPlayerActionInput = tempIn;
        */
        //USE THE TWO LINES OF CODE ABOVE WHEN TESTING IS DONE. KINDA COOL LOOKING

        try{
            playerActionInput = Integer.parseInt(tempStringPlayerActionInput);
            switch(playerActionInput){
                //move WEST case
                case 1: if(moveAction1!=null){
                    roomName = moveAction1;
                    getMoveActionLocation();
                }
                else{
                    System.out.println("ERROR: INVALID ENTRY");
                    getRoomActions();
                }
                    //move NORTH case
                case 2: if(moveAction2!=null){
                    roomName = moveAction2;
                    getMoveActionLocation();
                }
                else{
                    System.out.println("ERROR: INVALID ENTRY");
                    getRoomActions();
                }
                    //move EAST case
                case 3: if(moveAction3!=null){
                    roomName = moveAction3;
                    getMoveActionLocation();
                }
                else{
                    System.out.println("ERROR: INVALID ENTRY");
                    getRoomActions();
                }
                    //move SOUTH case
                case 4: if(moveAction4!=null){
                    roomName = moveAction4;
                    getMoveActionLocation();
                }
                else{
                    System.out.println("ERROR: INVALID ENTRY");
                    getRoomActions();
                }
                /*//LOOT case
                case 5: if(hasLoot){
                    searchRoomAction();
                }
                else{
                    System.out.println("ERROR: INVALID ENTRY");
                    getRoomActions();
                }*/
            }
        }
        catch(Exception e){
            System.out.println("ERROR: NON-INTEGER PLAYER INPUT.");
            playerActionInput = 0;
            getRoomActions();
        }



    }

    //HALLWAY ACTION CLASS
    private static void getHallwayActions(){
        //updating variables
        roomName = AH[hallwayArrayIndex][0];
        moveAction1 = AH[hallwayArrayIndex][1];
        moveAction2 = AH[hallwayArrayIndex][2];
        moveAction3 = AH[hallwayArrayIndex][3];
        moveAction4 = AH[hallwayArrayIndex][4];
        AH[hallwayArrayIndex][5]="true";
        haveVisited = true;
        hasLoot = false; //hallways don't have loot
        hasEnemy = false; //hallways don't have enemies (FOR NOW)
        //necessary prints
        System.out.println("You have entered hallway "+roomName+".\n ---------- Your Available Options ----------");
        if(moveAction1!=null){
            System.out.print("[1]     Move to "+moveAction1+"   (WEST)");
            checkHasVisited(moveAction1);
            checkPreviousIndex(moveAction1);
            System.out.println();
        }
        if(moveAction2!=null){
            System.out.print("[2]     Move to "+moveAction2+"     (NORTH)");
            checkHasVisited(moveAction2);
            checkPreviousIndex(moveAction2);
            System.out.println();
        }
        if(moveAction3!=null){
            System.out.print("[3]     Move to "+moveAction3+"     (EAST)");
            checkHasVisited(moveAction3);
            checkPreviousIndex(moveAction3);
            System.out.println();
        }
        if(moveAction4!=null){
            System.out.print("[4]     Move to "+moveAction4+"     (SOUTH)");
            checkHasVisited(moveAction4);
            checkPreviousIndex(moveAction4);
            System.out.println();
        }
        System.out.println("What will you do?");
        tempStringPlayerActionInput = playerInput.nextLine();
        try{
            playerActionInput = Integer.parseInt(tempStringPlayerActionInput);
            switch(playerActionInput){
                case 1:
                    if(moveAction1!=null){
                        System.out.println("Moving to "+moveAction1);
                        roomName = moveAction1;
                        getMoveActionLocation();
                    }
                    else{
                        System.out.println("ERROR: INVALID ENTRY");
                        getHallwayActions();
                    }
                case 2:
                    if(moveAction2!=null){
                        System.out.println("Moving to "+moveAction2);
                        roomName = moveAction2;
                        getMoveActionLocation();
                    }
                    else{
                        System.out.println("ERROR: INVALID ENTRY");
                        getHallwayActions();
                    }
                case 3:
                    if(moveAction3!=null){
                        System.out.println("Moving to "+moveAction3);
                        roomName = moveAction3;
                        getMoveActionLocation();
                    }
                    else{
                        System.out.println("ERROR: INVALID ENTRY");
                        getHallwayActions();
                    }
                case 4:
                    if(moveAction4!=null){
                        System.out.println("Moving to "+moveAction4);
                        roomName = moveAction4;
                        getMoveActionLocation();
                    }
                    else{
                        System.out.println("ERROR: INVALID ENTRY");
                        getHallwayActions();
                    }
                default:
                    System.out.println("ERROR: ENTRY INVALID");
                    getHallwayActions();
            }
        }
        catch(Exception e){
            System.out.println("ERROR: NON-INTEGER VALUE");
            playerActionInput = 0;
            getHallwayActions();
        }


    }

    //CLASS FOR MARKING THE PREVIOUS ROOM
    private static void checkPreviousIndex(String tempMoveAction){
        if(tempMoveAction.equals(previousRoomName)){
            System.out.print(",(previous location)");
        }
    }


    /*public static void searchRoomAction(){//not even touching this until I make an efficient movement system
        System.out.println("Room searched; you jack shit, boi");
        if(roomName.contains("AR")){
            AR[roomArrayIndex][1].equals("false");
        }
    }*/
    //COMBAT CLASSES (not working on until completely done level movement)
   /* public static void startCombat(){

    }*/


    //CHECK IF THE PLAYER HAS VISITED A LOCATION BEFORE
    private static void checkHasVisited(String tempMoveAction){
        String tempHaveVisited = "";
        for (int i = 0; i < AR.length; i++) {
            if(AR[i][0].equals(tempMoveAction)){
                tempHaveVisited = AR[i][7];
            }
        }
        if(tempHaveVisited.equals("")){
            for (int i = 0; i < AH.length; i++) {
                if(AH[i][0].equals(tempMoveAction)){
                    tempHaveVisited=AH[i][5];
                }
            }
        }
        if(tempHaveVisited.equals("true")){
            System.out.print(", (Explored)");
        }
        else if(tempHaveVisited.equals("false")){
            System.out.print(", (Unexplored)");
        }
    }


    //CHECK THE PLAYERS MOVE ACTION
    private static void getMoveActionLocation(){
        if(roomName.contains("AR")){
            for (int i = 0; i < AR.length; i++) {
                if(roomName.equals(AR[i][0])){
                    roomArrayIndex=i;
                    getRoomActions();
                }
            }
        }
        else if(roomName.contains("AH")){
            for (int i = 0; i < AH.length; i++) {
                if(roomName.equals(AH[i][0])){
                    hallwayArrayIndex=i;
                    getHallwayActions();
                }
            }
        }
    }
}
