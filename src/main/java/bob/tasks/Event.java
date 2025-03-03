package bob.tasks;

import java.time.LocalDateTime;

import bob.parser.DateParser;

/**
 * Represent an event task with a start and end date
 */

public class Event extends Task {
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;

    /**
     * Constructs an Event task with a description, start date and end date
     *
     * @param description Event details
     * @param startDate   Event starting date/time
     * @param endDate     Event ending date/time
     */
    public Event(String description, LocalDateTime startDate, LocalDateTime endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * @inheritDoc
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
