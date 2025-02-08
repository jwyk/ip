import java.util.ArrayList;

public class Parser {


    /**
     * Process the string input to different commands
     *
     * @param input    User's input as a string
     * @param taskList Due Date/time
     */

    public static void parseString(String input, ArrayList<Task> taskList) {
        System.out.println("____________________________________________________________");

        //Strip input into position and command
        String[] inputArray = input.split(" ");
        String command = inputArray[0];
        //inputArray.length() == 0 ? command = input.substring(0, input.indexOf(' ')) : command = input;
        int taskPosition = input.indexOf(' ');
        int position;

        switch (command) {
        case "bye":
            System.out.println("Bye dude, see you soon again!");
            break;
        case "list":
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(i + 1 + ". " + taskList.get(i));
            }
            break;
        case "mark":
            try {
                position = convertToInt(input, taskPosition);
                taskList.get(position - 1).markAsDone();
                System.out.println("Okay, we are checking... okay marked as done!");
                System.out.println(taskList.get(position - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Okay, we are checking... there is an invalid number! " +
                        "Either you didn't type the number, or it's out of the range we have.");
            } catch (NumberFormatException e) {
                System.out.println("Okay, we are checking... that's not a number! " +
                        "You didn't give a proper number. Maybe try typing it properly.");
            }
            break;
        case "unmark":
            try {
                position = convertToInt(input, taskPosition);
                taskList.get(position - 1).markAsUndone();
                System.out.println("Okay, we are checking... okay unmarked the task!");
                System.out.println(taskList.get(position - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Okay, we are checking... there is an invalid number! " +
                        "Either you didn't type the number, or it's out of the range we have.");
            } catch (NumberFormatException e) {
                System.out.println("Okay, we are checking... that's not a number! " +
                        "You didn't give a proper number. Maybe try typing it properly.");
            }
            break;
        case "deadline":
            //Deadline
            String dueDate = input.substring(input.indexOf('/') + 1);
            input = input.substring(taskPosition + 1, input.indexOf('/') - 1);
            taskList.add(new Deadline(input, dueDate));
            System.out.println("added: " + taskList.get(taskList.size() - 1));
            System.out.println("Current number of tasks: " + taskList.size());
            break;

        case "event":
            //Event
            String startDate = input.substring(input.indexOf('/') + 1);
            int endPosition = startDate.indexOf('/') + 1;
            String endDate = startDate.substring(endPosition);
            startDate = startDate.substring(0, endPosition - 2);
            input = input.substring(taskPosition + 1, input.indexOf('/') - 1);
            taskList.add(new Event(input, startDate, endDate));
            System.out.println("added: " + taskList.get(taskList.size() - 1));
            System.out.println("Current number of tasks: " + taskList.size());
            break;

        case "todo":
            //Task
            input = input.substring(taskPosition + 1);
            taskList.add(new Todo(input));
            System.out.println("added: " + taskList.get(taskList.size() - 1));
            System.out.println("Current number of tasks: " + taskList.size());
            break;

        default:
            //None of the above commands met
            System.out.println("Sorry, I didn't get that. Will come back to you...");
        }
        System.out.println("____________________________________________________________");
    }

    /**
     * Return an integer version of the given task
     *
     * @param input        User's input as a string
     * @param taskPosition Position of the first space
     * @return Integer of the task
     */

    private static int convertToInt(String input, int taskPosition) {
        return Integer.parseInt(input.substring(taskPosition + 1));
    }

}
