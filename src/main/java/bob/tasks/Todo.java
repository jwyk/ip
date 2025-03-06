package bob.tasks;

/** Represent a todo task with a description, and completion status */
public class Todo extends Task {
    /**
     * Constructs a todo task with a description, start date and end date By default, sets isDone to
     * false
     *
     * @param description Todo details
     */
    public Todo(String description) {
        super(description);
    }

    /** Returns a String representation of the todo task */
    @Override
    public String toString() {
        return "[T]" + this.getStatusIcon() + " " + this.description;
    }
}
