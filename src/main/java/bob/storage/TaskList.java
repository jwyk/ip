package bob.storage;

import java.util.ArrayList;
import java.util.List;

import bob.exception.BobException;
import bob.tasks.Task;

/*
 * Contains an ArrayList of Tasks with ability to print out contents
 */

public class TaskList {
    ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public void add(Task task) {
        taskList.add(task);
    }

    /**
     * Lists out all the tasks present in the list in the following format:
     * For Todo Tasks: [isDone][T] description
     * <p>
     * For Deadline Tasks: [isDone][D] description (by: deadline)
     * <p>
     * For Event Tasks: [isDone][E] description (from: fromDate to: dueDate)
     */
    public void list() {
        if (taskList.isEmpty()) {
            System.out.println("There are no tasks. Maybe add a few more.");
        } else {
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(i + 1 + ". " + taskList.get(i));
            }
        }
    }

    /**
     * Marks 1 task specified at index from the TaskList as completed
     *
     * @param index Position of the task to mark as done in the TaskList
     * @throws BobException Index is out of bounds
     */

    public Task mark(int index) throws BobException {
        if (taskList.isEmpty()) {
            throw new BobException("There are no tasks to mark. Maybe add a few more."); //Not within list range
        }

        if (index > taskList.size() || index <= 0) {
            throw new BobException("Okay, we are checking... there is an invalid number! " +
                    "Type something within the list range."); //Not within list range
        }

        taskList.get(index - 1).markAsDone();
        return taskList.get(index - 1);
    }

    /**
     * Unmarks 1 task specified at index from the TaskList as unfinished
     *
     * @param index Position of the task to mark as undone in the TaskList
     * @throws BobException Index is out of bounds
     */

    public Task unmark(int index) throws BobException {
        if (taskList.isEmpty()) {
            throw new BobException("There are no tasks to unmark. Maybe add a few more."); //Not within list range
        }

        if (index > taskList.size() || index <= 0) {
            throw new BobException("Okay, we are checking... there is an invalid number! " +
                    "Type something within the list range."); //Not within list range
        }

        taskList.get(index - 1).markAsUndone();
        return taskList.get(index - 1);
    }

    /**
     * Deletes and returns 1 task specified at index from the TaskList
     *
     * @param index Position of the task to be deleted in the TaskList
     * @throws BobException Index is out of bounds
     */
    public Task delete(int index) throws BobException {
        if (taskList.isEmpty()) {
            throw new BobException("There are no tasks to delete. Maybe add a few more."); //Not within list range
        }

        if (index > taskList.size() || index <= 0) {
            throw new BobException("Okay, we are checking... there is an invalid number! " +
                    "Type something within the list range."); //Not within list range
        }

        return taskList.remove(index - 1);
    }


    /**
     * Returns the number of tasks
     */
    public int size() {
        return taskList.size();
    }

    /**
     * Returns a task at the specified index
     */
    public Task get(int index) {
        return taskList.get(index);
    }

    /**
     * Returns a List of Tasks containing the filtered keyword
     * in their description
     *
     * @param keyword String containing the description to filter for
     */

    public List<Task> find(String keyword) {
        List<Task> tasks = new ArrayList<Task>();
        for (Task task: taskList) {
            if(task.getDescription().contains(keyword)) {
                tasks.add(task);
            }
        }
        return tasks;
    }
}
