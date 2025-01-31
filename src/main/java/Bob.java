import java.util.Scanner;

public class Bob {
    private static int current;
    private static Task[] list;

    //Initializer for Bob
    public Bob() {
        current = 0;
        list = new Task[100];
    }

    //Takes in a string input and prints outputs depending on the input string
    public static void parseString(String input) {
        System.out.println("____________________________________________________________");

        //Strip input into position and command
        int taskPosition = input.indexOf(' ');
        String command = "";
        int position = -1;
        if (taskPosition != -1) {
            command = input.substring(0, input.indexOf(' '));
            position = Integer.parseInt(input.substring(taskPosition + 1));
        } else {
            command = input;
        }

        switch (command) {
        case "bye":
            System.out.println("Bye dude, see you soon again!");
            break;
        case "list":
            for (int i = 0; i < current; i++) {
                System.out.println(i + 1 + ". " + "[" + list[i].getStatusIcon() + "]" + list[i].description);
            }
            break;
        case "mark":
            if (taskPosition == -1) {
                System.out.println("Okay, we are checking... this is invalid! No number detected");
            } else {
                System.out.println("Okay, we are checking... okay marked as done!");
                list[position - 1].markAsDone();
                System.out.println("[" + list[position - 1].getStatusIcon() + "]" + list[position - 1].description);
            }
            break;
        case "unmark":
            if (taskPosition == -1) {
                System.out.println("Okay, we are checking... this is invalid! No number detected");
            } else {
                System.out.println("Okay, we are checking... okay unmarked the task!");
                list[position - 1].markAsUndone();
                System.out.println("[" + list[position - 1].getStatusIcon() + "]" + list[position - 1].description);
            }
            break;
        default:
            list[current] = new Task(input);
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
