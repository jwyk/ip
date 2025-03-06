package bob.tasks;

import java.time.LocalDateTime;

import bob.parser.DateParser;

/**
 * Represent a deadline task with a description, and due date
 */

public class Deadline extends Task {
    protected LocalDateTime dueDate;

    /**
     * Constructs a Deadline task with a description and due date
     *
     * @param description Deadline details
     * @param dueDate     Due Date/time
     */

    public Deadline(String description, LocalDateTime dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + " " + this.description +
                " (by: " + DateParser.printDate(this.dueDate) + ")";
    }

    /**
     * Returns the due date of a deadline
     */
    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
