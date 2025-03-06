package bob.commands;

import static bob.parser.Parser.convertToInt;

import bob.BobException;
import bob.TaskList;
import bob.tasks.Task;
import bob.ui.Ui;

public class DeleteCommand extends Command {
    protected final int position;

    public DeleteCommand(String input) throws BobException {
        int taskPosition = input.indexOf(' ');

        if (taskPosition == -1) {
            throw new BobException(
                    "Okay we are checking... there's no number."
                            + "Please type a number."); // Index  doesn't exist
        }

        this.position = convertToInt(input, taskPosition);
        if (position == -1) {
            throw new BobException(
                    "Okay we are checking... there's no number."
                            + "Please type a number."); // Alphabetical input
        }
    }

    @Override
    public void execute(TaskList taskList) throws BobException {
        Task task = taskList.delete(position);
        Ui.showDelete(taskList, task);
    }
}
