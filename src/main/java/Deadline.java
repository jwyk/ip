/**
 * Represent a deadline task with a description, and due date
 */

public class Deadline extends Task {
    protected String dueDate;

    /**
     * Constructs a Deadline task with a description and due date
     *
     *
     * @param description Deadline details
     * @param dueDate Due Date/time
     */

    public Deadline(String description, String dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + " " + this.description + " (by: " + this.dueDate + ")";
    }

}
