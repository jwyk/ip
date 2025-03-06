package bob.commands;

import static bob.parser.Parser.convertToInt;

import bob.exception.BobException;
import bob.storage.TaskList;
import bob.tasks.Task;
import bob.ui.Ui;

/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand extends Command {
    protected final int position;

    /**
     * Constructs a DeleteCommand object with the specified task position.
     *
     * @param input The user input containing the delete command and task position.
     * @throws BobException If the task position is missing or invalid.
     */
    public DeleteCommand(String input) throws BobException {
        int taskPosition = input.indexOf(' ');

        if (taskPosition == -1) {
            throw new BobException("Okay we are checking... there's no number." +
                    "Please type a number."); //Index doesn't exist
        }

        this.position = convertToInt(input, taskPosition);
        if (position == -1) {
            throw new BobException("Okay we are checking... there's no number." +
                    "Please type a number."); //Alphabetical input
        }
    }

    /**
     * Executes the delete command by removing the specified task from the task list.
     *
     * @param taskList The task list from which the task will be deleted.
     * @throws BobException If an error occurs during deletion.
     */
    @Override
    public void execute(TaskList taskList) throws BobException {
        Task task = taskList.delete(position);
        Ui.showDelete(taskList, task);
    }
}
