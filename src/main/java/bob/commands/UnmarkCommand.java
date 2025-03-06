package bob.commands;

import bob.exception.BobException;
import bob.storage.TaskList;
import bob.tasks.Task;
import bob.ui.Ui;

/**
 * Represents a command to unmark a specific task in the task list as incomplete.
 * The task to be unmarked is identified by its position in the list.
 * This class extends {@code MarkCommand} to reuse the logic for parsing the task position.
 */
public class UnmarkCommand extends MarkCommand {

    /**
     * Constructs an {@code UnmarkCommand} object.
     *
     * @param input The user input containing the position of the task to be unmarked.
     * @throws BobException If the input is invalid (e.g., missing a number or contains non-numeric characters).
     */
    public UnmarkCommand(String input) throws BobException {
        super(input);
    }

    /**
     * Executes the unmark command by unmarking the task at the specified position as incomplete.
     * The updated task list and the unmarked task are displayed to the user.
     *
     * @param taskList The task list containing the task to be unmarked.
     * @throws BobException If the specified position is invalid or an error occurs during execution.
     */
    @Override
    public void execute(TaskList taskList) throws BobException {
        Task task = taskList.unmark(super.position);
        Ui.showUnmark(taskList, task);

    }
}
