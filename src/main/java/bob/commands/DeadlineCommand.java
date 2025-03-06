package bob.commands;

import java.time.LocalDateTime;

import bob.exception.BobException;
import bob.parser.DateParser;
import bob.storage.TaskList;
import bob.tasks.Deadline;
import bob.ui.Ui;

/**
 * Represents a command to create and add a Deadline task.
 */
public class DeadlineCommand extends Command {
    private final Deadline task;

    /**
     * Constructs a DeadlineCommand with the given user input.
     *
     * @param input The full user input string containing the description and deadline.
     * @throws BobException If the input format is incorrect.
     */
    public DeadlineCommand(String input) throws BobException {
        int taskPosition = input.indexOf(' ');
        if (taskPosition == -1) {
            throw new BobException("Okay we are checking... there's no description. " +
                    "Please add a description."); // Missing task description
        }

        // Split the input to extract the description and deadline
        String[] dueArray = input.substring(taskPosition).split("/by ", 2);
        if (dueArray.length != 2) {
            throw new BobException("Okay, we are checking... you didn't type in /by to demarcate the deadline. " +
                    "Please write it.");
        }

        String description = dueArray[0].trim(); // Extract and trim description
        String dueDate = dueArray[1].trim(); // Extract and trim deadline

        // Parse the deadline string into a LocalDateTime object
        LocalDateTime dueLocalDateTime = DateParser.getDate(dueDate);
        if (dueLocalDateTime == null) {
            throw new BobException("The date and time input is not in the correct format. " +
                    "Please input it in: YYYY/MM/dd HHmm");
        }

        // Create a new Deadline task
        task = new Deadline(description, dueLocalDateTime);
    }

    /**
     * Executes the command by adding the Deadline task to the task list.
     *
     * @param taskList The task list to which the Deadline task is added.
     * @throws BobException If an error occurs while adding the task.
     */
    @Override
    public void execute(TaskList taskList) throws BobException {
        taskList.add(task);
        Ui.showAdd(taskList);
    }
}
