package bob.commands;

import bob.BobException;
import bob.TaskList;
import bob.tasks.Deadline;
import bob.ui.Ui;

public class DeadlineCommand extends Command {
    private final Deadline task;

    public DeadlineCommand(String input) throws BobException {
        int taskPosition = input.indexOf(' ');
        if (taskPosition == -1) {
            throw new BobException("Okay we are checking... there's no description." +
                    "Please add a description."); //Missing space before description
        }

        String[] dueArray = input.substring(taskPosition).split("/by ", 2); //Split the description and deadline
        if (dueArray.length != 2) {
            throw new BobException("Okay, we are checking... you didn't type in /by to demarcate the deadline." +
                    " Please write it.");
        }
        String description = dueArray[0].trim();
        String dueDate = dueArray[1].trim();
        task = new Deadline(description, dueDate);
    }

    @Override
    public void execute(TaskList taskList) throws BobException {
        taskList.add(task);
        Ui.showAdd(taskList);
    }
}
