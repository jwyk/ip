package bob.commands;

import java.time.LocalDateTime;

import bob.exception.BobException;
import bob.parser.DateParser;
import bob.storage.TaskList;
import bob.tasks.Event;
import bob.ui.Ui;

/**
 * Represents a command to add an event task to the task list.
 */
public class EventCommand extends Command {
    private final Event task;

    /**
     * Constructs an EventCommand object by parsing user input.
     *
     * @param input The user input containing the event description and time period.
     * @throws BobException If the input format is incorrect or missing required details.
     */
    public EventCommand(String input) throws BobException {
        int taskPosition = input.indexOf(" ");
        if (taskPosition == -1) {
            throw new BobException("Okay we are checking... there's no description." +
                    "Please add a description."); //Missing space before description
        }

        //Split the description and event
        String[] eventArray = input.substring(taskPosition).split("/from ", 2);
        if (eventArray.length != 2) {
            throw new BobException("Okay we are checking... there's no from." +
                    "Please add /from to demarcate the duration of the event.");
        }

        String[] fromToArray = eventArray[1].split(" /to", 2);
        //This error check needs to be split with the /from check, or you will get index out of bounds
        if (fromToArray.length != 2) {
            throw new BobException("Okay we are checking... there's no to." +
                    "Please add /to to demarcate the duration of the event.");
        }

        String eventName = eventArray[0].trim();
        String startDate = fromToArray[0].trim();
        String endDate = fromToArray[1].trim();

        LocalDateTime startLocalDateTime = DateParser.getDate(startDate);
        LocalDateTime endLocalDateTime = DateParser.getDate(endDate);
        if (startLocalDateTime == null || endLocalDateTime == null) {
            throw new BobException("The date and time input is not in the correct" +
                    " format. Please input it in: YYYY/MM/dd HHmm");
        }
        task = new Event(eventName, startLocalDateTime, endLocalDateTime);
    }

    /**
     * Executes the event command by adding the event task to the task list.
     *
     * @param taskList The task list to which the event task will be added.
     * @throws BobException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList taskList) throws BobException {
        taskList.add(task);
        Ui.showAdd(taskList);
    }
}
