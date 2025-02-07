import java.util.Scanner;
import java.util.ArrayList;

public class Bob {
    private static ArrayList<Task> list;

    //Initializer for Bob
    public Bob() {
        list = new ArrayList<Task>();
    }

    //Takes in a string input and prints outputs depending on the input string
    public static void parseString(String input) {
        System.out.println("____________________________________________________________");

        //Strip input into position and command
        int taskPosition = input.indexOf(' ');
        String command;
        int position;

        if (taskPosition != -1) {
            command = input.substring(0, input.indexOf(' '));
        } else {
            command = input;
        }

        switch (command) {
        case "bye":
            System.out.println("Bye dude, see you soon again!");
            break;
        case "list":
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ". " + list.get(i));
            }
            break;
        case "mark":
            if (taskPosition == -1) {
                System.out.println("Okay, we are checking... this is invalid! No number detected");
            } else {
                System.out.println("Okay, we are checking... okay marked as done!");
                position = Integer.parseInt(input.substring(taskPosition + 1));
                list.get(position - 1).markAsDone();
                System.out.println(list.get(position - 1));

            }
            break;
        case "unmark":
            if (taskPosition == -1) {
                System.out.println("Okay, we are checking... this is invalid! No number detected");
            } else {
                System.out.println("Okay, we are checking... okay unmarked the task!");
                position = Integer.parseInt(input.substring(taskPosition + 1));
                list.get(position - 1).markAsUndone();
                System.out.println(list.get(position - 1));
            }
            break;
        case "deadline":
            //Deadline
            String dueDate = input.substring(input.indexOf('/') + 1);
            input = input.substring(taskPosition + 1, input.indexOf('/') - 1);
            list.add(new Deadline(input, dueDate));
            System.out.println("added: " + list.get(list.size() - 1));
            System.out.println("Current number of tasks: " + list.size());
            break;

        case "event":
            //Event
            String startDate = input.substring(input.indexOf('/') + 1);
            int endPosition = startDate.indexOf('/') + 1;
            String endDate = startDate.substring(endPosition);
            startDate = startDate.substring(0, endPosition - 2);
            input = input.substring(taskPosition + 1, input.indexOf('/') - 1);
            list.add(new Event(input, startDate, endDate));
            System.out.println("added: " + list.get(list.size() - 1));
            System.out.println("Current number of tasks: " + list.size());
            break;

        case "todo":
            //Task
            input = input.substring(taskPosition + 1);
            list.add(new Task(input));
            System.out.println("added: " + list.get(list.size() - 1));
            System.out.println("Current number of tasks: " + list.size());
            break;

        default:
            //None of the above commands met
            System.out.println("Sorry, I didn't get that. Will come back to you...");
        }
        System.out.println("____________________________________________________________");
    }

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
            parseString(line);
        } while (!line.equals("bye"));

    }
}
