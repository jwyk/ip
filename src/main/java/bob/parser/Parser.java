package bob.parser;

import java.io.IOException;
import java.util.Scanner;

import bob.BobException;
import bob.Storage;
import bob.TaskList;
import bob.commands.Action;
import bob.commands.ByeCommand;
import bob.commands.Command;
import bob.commands.DeadlineCommand;
import bob.commands.DeleteCommand;
import bob.commands.EventCommand;
import bob.commands.FindCommand;
import bob.commands.ListCommand;
import bob.commands.MarkCommand;
import bob.commands.TodoCommand;
import bob.commands.UnmarkCommand;

public class Parser {

    /**
     * Poll the CLI for user inputs until a COMMAND_BYE event is triggered
     *
     * @param taskList ArrayList containing Tasks
     */

    public static void getInput(TaskList taskList) {
        //Initialise input variables
        String line;
        Scanner in = new Scanner(System.in);
        boolean isExit = false;
        //Handle Cases, until the COMMAND_BYE is detected
        do {
            line = in.nextLine();
            try {
                Command c = parseString(line); //Parse inputs into different categories
                c.execute(taskList);
                Storage.save(taskList);
                isExit = c.isExit();
            } catch (BobException | IOException e) {
                System.out.println(e.getMessage());
            }
        } while (!isExit);
    }

    /**
     * Process the string input to different commands, and returns Command actions
     *
     * @param input User's input as a string
     */
    public static Command parseString(String input) throws BobException {
        System.out.println("____________________________________________________________");

        //Strip input into position and command
        String[] inputArray = input.split(" ", 2);
        String command = inputArray[0].toLowerCase();
        Action action = Action.fromString(command);

        return
                switch (action) {
                    case BYE -> new ByeCommand();
                    case MARK -> new MarkCommand(input);
                    case UNMARK -> new UnmarkCommand(input);
                    case LIST -> new ListCommand();
                    case DELETE -> new DeleteCommand(input);
                    case TODO -> new TodoCommand(input);
                    case DEADLINE -> new DeadlineCommand(input);
                    case EVENT -> new EventCommand(input);
                    case FIND -> new FindCommand(input);
                    default -> throw new BobException("Sorry, I didn't get that. Will come back to you...");
                };
    }

    /**
     * Return an integer of the task you want to mark
     *
     * @param input        User's input as a string
     * @param taskPosition Position of the first space
     * @return Integer of the task
     */
    public static int convertToInt(String input, int taskPosition) throws BobException {
        try {
            return Integer.parseInt(input.substring(taskPosition + 1));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            throw new BobException("Okay, we are checking.. there is an invalid number!" +
                    " This isn't a number, type a proper digit.");
        }
    }

}
