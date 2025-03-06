package bob.commands;

import bob.exception.BobException;
import bob.storage.TaskList;
import bob.ui.Ui;

public class ByeCommand extends Command {

    /**
     * Returns whether to exit the application
     * Overrides the default value to exit the application
     */
    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(TaskList taskList) throws BobException {
        Ui.showBye();
    }
}
