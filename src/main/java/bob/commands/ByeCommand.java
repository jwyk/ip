package bob.commands;

import bob.exception.BobException;
import bob.storage.TaskList;
import bob.ui.Ui;

/**
 * Represents a command to exit the application.
 */
public class ByeCommand extends Command {

    /**
     * Returns whether the command signals an exit from the application.
     * Overrides the default value to indicate application termination.
     *
     * @return true since this command exits the application.
     */
    @Override
    public boolean isExit() {
        return true;
    }

    /**
     * Executes the bye command by displaying the exit message.
     *
     * @param taskList The task list (not used in this command but required by the method signature).
     * @throws BobException Never thrown in this implementation.
     */
    @Override
    public void execute(TaskList taskList) throws BobException {
        Ui.showBye();
    }
}
