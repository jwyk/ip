package bob.commands;

import bob.exception.BobException;
import bob.storage.TaskList;
import bob.tasks.Todo;
import bob.ui.Ui;

/**
 * Represents a command to add a new "To-Do" task to the task list.
 * The task is created using the description provided by the user.
 */
public class TodoCommand extends Command {
    private final Todo task;

    /**
     * Constructs a {@code TodoCommand} object.
     *
     * @param input The user input containing the description of the "To-Do" task.
     * @throws BobException If the input is invalid (e.g., missing a description).
     */
    public TodoCommand(String input) throws BobException {
        int taskPosition = input.indexOf(' ');
        if (taskPosition == -1) {
            throw new BobException("Okay we are checking... there's no description." +
                    "Please add a description."); //Missing description
        }
        String description = input.substring(taskPosition + 1);
        task = new Todo(description);
    }

    /**
     * Executes the "To-Do" command by adding the new task to the task list.
     * The updated task list is displayed to the user.
     *
     * @param taskList The task list to which the new task will be added.
     * @throws BobException If an error occurs while adding the task.
     */
    @Override
    public void execute(TaskList taskList) throws BobException {
        taskList.add(task);
        Ui.showAdd(taskList);
    }
}
