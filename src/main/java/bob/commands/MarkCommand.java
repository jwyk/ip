package bob.commands;

import static bob.parser.Parser.convertToInt;

import bob.exception.BobException;
import bob.storage.TaskList;
import bob.tasks.Task;
import bob.ui.Ui;

/**
 * Represents a command to mark a specific task in the task list as completed.
 * The task to be marked is identified by its position in the list.
 */
public class MarkCommand extends Command {

    protected final int position;

    /**
     * Constructs a {@code MarkCommand} object.
     *
     * @param input The user input containing the position of the task to be marked.
     * @throws BobException If the input is invalid (e.g., missing a number or contains non-numeric characters).
     */
    public MarkCommand(String input) throws BobException {
        int taskPosition = input.indexOf(' ');

        if (taskPosition == -1) {
            throw new BobException("Okay we are checking... there's no number." +
                    "Please type a number."); //Index  doesn't exist
        }

        this.position = convertToInt(input, taskPosition);
        if (position == -1) {
            throw new BobException("Okay we are checking... there's no number." +
                    "Please type a number."); //Alphabetical input
        }
    }

    /**
     * Executes the mark command by marking the task at the specified position as completed.
     * The updated task list and the marked task are displayed to the user.
     *
     * @param taskList The task list containing the task to be marked.
     * @throws BobException If the specified position is invalid or an error occurs during execution.
     */
    public void execute(TaskList taskList) throws BobException {
        Task task = taskList.mark(position);
        Ui.showMark(taskList, task);
    }
}
