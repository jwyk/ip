package bob.commands;

import bob.BobException;
import bob.TaskList;
import bob.ui.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList taskList) throws BobException {
        taskList.list();
        Ui.showLine();
    }
}
