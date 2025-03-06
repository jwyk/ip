package bob.commands;

import bob.exception.BobException;
import bob.storage.TaskList;
import bob.ui.Ui;

/**
 * Represents a command to list all tasks in the task list.
 * This command retrieves and displays all tasks currently stored in the task list.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command by retrieving all tasks from the task list and displaying them to the user.
     * A line separator is shown after the list for better readability.
     *
     * @param taskList The task list containing the tasks to be displayed.
     * @throws BobException If an error occurs while retrieving or displaying the tasks.
     */
    @Override
    public void execute(TaskList taskList) throws BobException {
        taskList.list();
        Ui.showLine();
    }
}
