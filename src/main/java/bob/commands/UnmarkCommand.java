package bob.commands;

import bob.BobException;
import bob.TaskList;
import bob.tasks.Task;
import bob.ui.Ui;

public class UnmarkCommand extends MarkCommand{

    public UnmarkCommand(String input) throws BobException {
        super(input);
    }

    @Override
    public void execute(TaskList taskList) throws BobException {
        Task task = taskList.unmark(super.position);
        Ui.showUnmark(taskList,task);

    }
}
