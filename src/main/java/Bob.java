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
            for (int i = 0; i < current; i++) {
                System.out.println(i + 1 + ". " + list[i].getTask());
            }
            break;
        case "mark":
            if (taskPosition == -1) {
                System.out.println("Okay, we are checking... this is invalid! No number detected");
            } else {
                System.out.println("Okay, we are checking... okay marked as done!");
                position = Integer.parseInt(input.substring(taskPosition + 1));
                list[position - 1].markAsDone();
                System.out.println(list[position - 1].getTask());
            }
            break;
        case "unmark":
            if (taskPosition == -1) {
                System.out.println("Okay, we are checking... this is invalid! No number detected");
            } else {
                System.out.println("Okay, we are checking... okay unmarked the task!");
                position = Integer.parseInt(input.substring(taskPosition + 1));
                list[position - 1].markAsUndone();
                System.out.println(list[position - 1].getTask());
            }
            break;
        case "deadline":
            //Deadline
            String dueDate = input.substring(input.indexOf('/') + 1);
            input = input.substring(taskPosition + 1, input.indexOf('/') - 1);
            list[current] = new Deadline(input, dueDate);
            System.out.println("added: " + list[current].getTask());
            current++;
            System.out.println("Current number of tasks: " + current);
            break;

        case "event":
            //Event
            String startDate = input.substring(input.indexOf('/') + 1);
            int endPosition = startDate.indexOf('/') + 1;
            String endDate = startDate.substring(endPosition);
            startDate = startDate.substring(0, endPosition - 2);
            input = input.substring(taskPosition + 1, input.indexOf('/') - 1);
            list[current] = new Event(input,startDate,endDate);
            System.out.println("added: " + list[current].getTask());
            current++;
            System.out.println("Current number of tasks: " + current);
            break;

        case "todo":
            //Task
            list[current] = new Task(input);
            System.out.println("added: " + list[current].getTask());
            current++;
            System.out.println("Current number of tasks: " + current);
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
