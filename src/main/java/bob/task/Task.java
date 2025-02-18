package bob.task;

/**
 * Represent a task with a description, and completion status
 */

public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a task with a description, start date and end date
     * By default, sets isDone to false
     *
     * @param description Task details
     */

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns a String representation of completion status
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    /**
     * Returns a String representation of the task
     */
    public abstract String toString();

    /**
     * Marks completion status as done
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks completion status as undone
     */
    public void markAsUndone() {
        this.isDone = false;
    }

    /**
     * Returns the description of a task
     */
    public String getDescription() {
        return description;
    }
}