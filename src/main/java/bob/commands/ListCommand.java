package bob.commands;

import bob.exception.BobException;
import bob.storage.TaskList;
import bob.ui.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList taskList) throws BobException {
        taskList.list();
        Ui.showLine();
    }
}
