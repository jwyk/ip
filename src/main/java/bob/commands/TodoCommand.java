package bob.commands;

import bob.BobException;
import bob.TaskList;
import bob.tasks.Todo;
import bob.ui.Ui;

public class TodoCommand extends Command {
    private final Todo task;

    public TodoCommand(String input) throws BobException {
        int taskPosition = input.indexOf(' ');
        if (taskPosition == -1) {
            throw new BobException("Okay we are checking... there's no description." +
                    "Please add a description."); //Missing description
        }
        String description = input.substring(taskPosition + 1);
        task = new Todo(description);
    }

    @Override
    public void execute(TaskList taskList) throws BobException {
        taskList.add(task);
        Ui.showAdd(taskList);
    }
}
