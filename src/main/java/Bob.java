import java.util.Scanner;

public class Bob {
    private static int current;
    private static String[] list;

    //Initializer for Bob
    public Bob() {
        current = 0;
        list = new String[100];
    }

    //Takes in a string input and prints outputs depending on the input string
    public static void parseString(String input) {
        System.out.println("____________________________________________________________");
        switch (input) {
        case "bye":
            System.out.println("Bye dude, see you soon again!");
            break;
        case "list":
            for (int i = 0; i < current; i++) {
                System.out.println(i + 1 + ". " + list[i]);
            }
            break;
        default:
            list[current] = input;
            System.out.println("added: " + input);
            current++;
            break;
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
        Bob Tasks = new Bob();

        //Handle Cases
        do {
            in = new Scanner(System.in);
            line = in.nextLine();
            parseString(line);
        } while (!line.equals("bye"));

    }
}
