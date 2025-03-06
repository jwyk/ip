package bob.commands;

import java.util.List;
import bob.exception.BobException;
import bob.storage.TaskList;
import bob.tasks.Task;
import bob.ui.Ui;

/**
 * Represents a command to search for tasks in the task list that match a given keyword.
 * The command processes user input to extract the keyword and then searches for tasks
 * containing that keyword in their descriptions.
 */
public class FindCommand extends Command {
    protected final String keyword;

    /**
     * Constructs a {@code FindCommand} object.
     *
     * @param input The user input containing the keyword to search for.
     * @throws BobException If the input is empty, contains only whitespace, or does not contain a valid keyword.
     */
    public FindCommand(String input) throws BobException {
        int taskPosition = input.indexOf(' ');

        if (taskPosition == -1) {
            throw new BobException("Okay we are checking... there's no description." +
                    "Please type a description."); //No description
        }

        this.keyword = input.substring(taskPosition).trim();

        if (keyword.isBlank()) {
            throw new BobException("Okay we are checking... there's no description." +
                    "Please type a description."); //Whitespace only
        }

    }

    /**
     * Executes the find command by searching for tasks in the task list that match the keyword.
     * The matching tasks are then displayed to the user via the {@code Ui} class.
     *
     * @param taskList The task list to search for matching tasks.
     * @throws BobException If an error occurs during the search process.
     */
    @Override
    public void execute(TaskList taskList) throws BobException {
        List<Task> tasks = taskList.find(keyword);
        Ui.showFind(tasks, keyword);
    }
}
