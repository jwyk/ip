package bob.commands;

import bob.BobException;
import bob.TaskList;
import bob.tasks.Event;
import bob.ui.Ui;

public class EventCommand extends Command {
    private final Event task;

    public EventCommand(String input) throws BobException {
        int taskPosition = input.indexOf(" ");
        if (taskPosition == -1) {
            throw new BobException("Okay we are checking... there's no description." +
                    "Please add a description."); //Missing space before description
        }
        String[] eventArray = input.substring(taskPosition).split("/from ", 2); //Split the description and event
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
        task = new Event(eventName, startDate, endDate);
    }

    @Override
    public void execute(TaskList taskList) throws BobException {
        taskList.add(task);
        Ui.showAdd(taskList);
    }
}
