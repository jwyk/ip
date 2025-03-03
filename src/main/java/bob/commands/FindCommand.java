package bob.commands;

import java.util.List;

import bob.BobException;
import bob.TaskList;
import bob.tasks.Task;
import bob.ui.Ui;

public class FindCommand  extends Command {
    private final String keyword;
    public FindCommand(String input) throws BobException {
        int taskPosition = input.indexOf(' ');

        if (taskPosition == -1) {
            throw new BobException("Okay we are checking... there's no description." +
                    "Please type a description."); //Description doesn't exist
        }

        this.keyword = input.substring(taskPosition).trim();
        if (this.keyword.isBlank()) {
            throw new BobException("Okay we are checking... there's no description." +
                    "Please type a description."); //Only whitespace
        }
    }

    @Override
    public void execute(TaskList taskList) throws BobException {
        List<Task> tasks = taskList.find(keyword);
        Ui.showFind(tasks,keyword);
    }

}
