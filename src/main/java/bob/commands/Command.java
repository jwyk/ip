package bob.commands;

import bob.exception.BobException;
import bob.storage.TaskList;

/**
 * Contains the base abstract Command Class
 */
public abstract class Command {

    /**
     * Returns whether to exit the application
     * This method is only overridden by the ByeCommand subclass
     */

    public boolean isExit() {
        return false;
    }

    /**
     * Executes the given command.
     * This method is intended to be implemented by
     * subclasses to perform its associated actions
     */

    public abstract void execute(TaskList taskList) throws BobException;
}
