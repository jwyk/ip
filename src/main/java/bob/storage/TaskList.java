package bob.storage;

import java.util.ArrayList;
import java.util.List;

import bob.exception.BobException;
import bob.tasks.Task;

/**
 * Represents a list of tasks with methods to manage them.
 * <p>
 * This class provides functionality to add, remove, mark, unmark,
 * list, and search for tasks.
 */

public class TaskList {
    ArrayList<Task> taskList;

    /**
     * Constructs an empty TaskList.
     */

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    /**
     * Adds a task to the task list.
     *
     * @param task The {@link Task} to be added.
     */

    public void add(Task task) {
        taskList.add(task);
    }

    /**
     * Lists all the tasks currently stored in the task list.
     * <p>
     * Tasks are displayed in the following format:
     * - Todo Tasks: [isDone][T] description
     * - Deadline Tasks: [isDone][D] description (by: deadline)
     * - Event Tasks: [isDone][E] description (from: startDate to: endDate)
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
     * Marks a task as completed at the specified index.
     *
     * @param index The position of the task to mark as done.
     * @return The updated {@link Task} that has been marked as done.
     * @throws BobException If the index is out of bounds.
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
     * Unmarks a task as incomplete at the specified index.
     *
     * @param index The position of the task to mark as undone.
     * @return The updated {@link Task} that has been marked as undone.
     * @throws BobException If the index is out of bounds.
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
     * Deletes a task at the specified index from the task list.
     *
     * @param index The position of the task to be deleted.
     * @return The removed {@link Task}.
     * @throws BobException If the index is out of bounds.
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
     * Returns the number of tasks in the task list.
     *
     * @return The size of the task list.
     */
    public int size() {
        return taskList.size();
    }

    /**
     * Retrieves a task at the specified index.
     *
     * @param index The index of the task.
     * @return The {@link Task} at the given index.
     */
    public Task get(int index) {
        return taskList.get(index);
    }

    /**
     * Finds tasks that contain the specified keyword in their description.
     *
     * @param keyword The keyword to filter tasks by.
     * @return A {@link List} of tasks that contain the keyword.
     */

    public List<Task> find(String keyword) {
        List<Task> tasks = new ArrayList<Task>();
        for (Task task : taskList) {
            if (task.getDescription().contains(keyword)) {
                tasks.add(task);
            }
        }
        return tasks;
    }
}
