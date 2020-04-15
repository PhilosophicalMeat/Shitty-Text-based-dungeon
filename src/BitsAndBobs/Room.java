package BitsAndBobs;

public class Room {
    public static String roomName;
    public static boolean hasVisited, isLooted;
    public static void main(String[] args) {

    }

    public String getName(String name){
        return roomName = name;
    }
    public boolean getVisitorStatus(boolean visitTemp){
        return hasVisited = visitTemp;
    }

    public boolean checkLooted(boolean lootedTemp){
        return isLooted = lootedTemp;
    }

    public void searchRoom(){
        if(isLooted){
            System.out.println("You have already looted the room");

        }
        else{

        }
    }

    public void getLoot(){

    }

}