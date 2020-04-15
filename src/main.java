import java.util.Random;
import java.util.Scanner;
public class main {
    public static Random rand = new Random();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\"------ Rest easy. I am here to help... it seems that you can't speak." +
                "\n In fact, it seems like you can't do anything at the moment. You've sustained severe damage." +
                "\n Not to worry, I'll act as your eyes and ears for now. Hold still... oh right, you can't move yet." +
                "\n sorry.\"");
        System.out.println("... INTEGRATION OF FOREIGN ENTITY COMPLETE");
        System.out.println("Done! Now I can give you information on your surroundings. Lets get started!");
        breakText();
        System.out.println("You're in a dimly lit room. Debris is strewn about, and the only window reveals the cloudy night sky and " +
                "crescent moon." +
                "\n You rest in a small crater beneath the window. Your left arm, left leg, and right leg are severed, " +
                "and nowhere to be seen." +
                "\n Your right arm is mostly intact. The rooms only door has been kicked inwards and leads into a dark corridor");
        breakText();

    }

    public static void breakText() {
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
}
