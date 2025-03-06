package bob.tasks;

/**
 * Represents a generic task with a description and a completion status.
 * This is an abstract class that serves as the base for specific task types.
 */

public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a task with a description.
     * By default, the task is marked as not done.
     *
     * @param description The details of the task.
     */

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns a string representation of the task's completion status.
     *
     * @return "[X]" if the task is done, "[ ]" otherwise.
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    /**
     * Returns a string representation of the event task, including its status, description.
     * <p>
     * Depending on the subclass, it also returns the starting and ending dates, or the due date.
     * <p>
     * This method is abstract and must be implemented by subclasses.
     *
     * @return A string representation of the event task.
     */
    public abstract String toString();

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done.
     */
    public void markAsUndone() {
        this.isDone = false;
    }

    /**
     * Returns the description of the task.
     *
     * @return The task's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the completion status of the task.
     *
     * @return {@code true} if the task is done, {@code false} otherwise.
     */
    public boolean getStatus() {
        return isDone;
    }
}