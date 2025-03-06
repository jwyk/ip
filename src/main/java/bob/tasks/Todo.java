package bob.tasks;

/**
 * Represent a Todo task with a description, and completion status
 * This class extends the {@code Task} class and provides specific functionality for Todo tasks.
 */

public class Todo extends Task {
    /**
     * Constructs a Todo task with a description, start date and end date
     * By default, the task is marked as not done.
     *
     * @param description The details of the Todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a String representation of the Todo task, including its status and description.
     *
     * @return A string representation of the Todo task.
     */
    @Override
    public String toString() {
        return "[T]" + this.getStatusIcon() + " " + this.description;
    }
}