package bob.tasks;

import java.time.LocalDateTime;

import bob.parser.DateParser;

/**
 * Represents an event task with a specific start and end date/time.
 * This class extends the {@code Task} class and adds functionality for handling event-specific details.
 */

public class Event extends Task {
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;

    /**
     * Constructs an {@code Event} task with a description, start date, and end date.
     *
     * @param description The details of the event.
     * @param startDate   The start date and time of the event.
     * @param endDate     The end date and time of the event.
     */
    public Event(String description, LocalDateTime startDate, LocalDateTime endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Returns a string representation of the event task, including its status, description,
     * and formatted start and end dates.
     *
     * @return A string representation of the event task.
     */
    @Override
    public String toString() {
        return "[E]" + this.getStatusIcon() + " " + this.description +
                " (from: " + DateParser.printDate(this.startDate) +
                " to: " + DateParser.printDate(this.endDate) + ")";
    }

    /**
     * Returns the start date of an event
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Returns the start date of an event
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

}
