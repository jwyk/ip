package bob.parser;

import java.io.IOException;
import java.util.Scanner;

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
import bob.exception.BobException;
import bob.storage.Storage;
import bob.storage.TaskList;

/**
 * Handles parsing of user input and execution of commands.
 * <p>
 * The {@code Parser} class continuously listens for user input,
 * processes it into commands, and executes them accordingly.
 */

public class Parser {

    /**
     * Continuously listens for user input from the CLI until a "bye" command is issued.
     *
     * @param taskList The {@link TaskList} containing tasks to be managed.
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
     * Parses the user input string into a corresponding {@link Command}.
     *
     * @param input The user's input as a string.
     * @return A {@link Command} object representing the parsed command.
     * @throws BobException If the command is unrecognized.
     */
    public static Command parseString(String input) throws BobException {
        System.out.println("____________________________________________________________");

        //Strip input into position and command
        String[] inputArray = input.split(" ", 2);
        String command = inputArray[0].toLowerCase();
        Action action = Action.fromString(command);

        return switch (action) {
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
     * Converts a substring of the user input into an integer, representing a task index.
     *
     * @param input        The user's input as a string.
     * @param taskPosition The position of the first space in the input string.
     * @return The integer representation of the task index.
     * @throws BobException If the extracted string is not a valid integer.
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
