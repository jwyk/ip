import java.util.Scanner;

public class Bob {

    //Takes in a string input and prints outputs depending on the input string
    public static void parseString(String input) {
        System.out.println("____________________________________________________________");
        switch (input) {
        case "bye":
            System.out.println("Bye dude, see you soon again!");
            break;
        default:
            System.out.println(input);
        }
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
        System.out.println("____________________________________________________________");
        System.out.println("Hello I'm Bob\n" + "What can I do for you?");
        System.out.println("____________________________________________________________");

        //Initialise input variables
        String line;
        Scanner in;

        //Handle Cases
        do {
            in = new Scanner(System.in);
            line = in.nextLine();
            parseString(line);
        } while (!line.equals("bye"));

    }
}
