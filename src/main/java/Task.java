/**
 * Represent a todo task with a description, and completion status
 */

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a todo task with a description, start date and end date
     * By default, sets isDone to false
     *
     * @param description Todo details
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
     * Returns a String representation of the todo task
     */
    @Override
    public String toString() {
        return "[T]" + this.getStatusIcon() + " " + this.description;
    }

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
}