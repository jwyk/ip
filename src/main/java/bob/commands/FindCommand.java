package bob.commands;

import bob.BobException;
import bob.TaskList;
import bob.tasks.Task;
import bob.ui.Ui;

import java.util.List;

public class FindCommand extends Command {
    protected final String keyword;

    public FindCommand(String input) throws BobException {
        int taskPosition = input.indexOf(' ');

        if (taskPosition == -1) {
            throw new BobException(
                    "Okay we are checking... there's no description."
                            + "Please type a description."); // No description
        }

        this.keyword = input.substring(taskPosition).trim();

        if (keyword.isBlank()) {
            throw new BobException(
                    "Okay we are checking... there's no description."
                            + "Please type a description."); // Whitespace only
        }
    }

    @Override
    public void execute(TaskList taskList) throws BobException {
        List<Task> tasks = taskList.find(keyword);
        Ui.showFind(tasks, keyword);
    }
}
