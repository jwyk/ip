/**
 * Represent an event task with a start and end date
 */

public class Event extends Task {
    protected String startDate;
    protected String endDate;

    /**
     * Constructs an Event task with a description, start date and end date
     *
     * @param description Event details
     * @param startDate   Event starting date/time
     * @param endDate     Event ending date/time
     */
    public Event(String description, String startDate, String endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return "[E]" + this.getStatusIcon() + " " + this.description + " (from: " + this.startDate + " to: " + this.endDate + ")";
    }

    public void setStartDate(String date) {
        this.startDate = date;
    }

    public void setEndDate(String date) {
        this.endDate = date;
    }

}
