import java.util.Scanner;
import java.util.ArrayList;

public class Bob {
    private static ArrayList<Task> list;

    //Initializer for Bob
    public Bob() {
        list = new ArrayList<Task>();
    }

    //Takes in a string input and prints outputs depending on the input string

    public static void main(String[] args) {
        System.out.println("____________________________________________________________");
        System.out.println("Hello I'm Bob\n" + "What can I do for you?");
        System.out.println("____________________________________________________________");

        //Initialise input variables
        String line;
        Scanner in = new Scanner(System.in);
        Bob Tasks = new Bob();

        //Handle Cases
        do {
            line = in.nextLine();
            Parser.parseString(line, list);
        } while (!line.equals("bye"));

    }
}
