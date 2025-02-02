public class Event extends Task{
    protected String startDate;
    protected String endDate;

    public Event(String description) {
        super(description);
    }

    @Override
    public String getTaskIcon() {
        return "[E]";
    }

    @Override
    public String getTask() {
        return "[T]" + this.getStatusIcon() + this.description + "(from: "  + this.startDate + " to: " + this.endDate + ")";
    }

    public void setStartDate(String date) {
        this.startDate = date;
    }

    public void setEndDate(String date) {
        this.endDate = date;
    }

}
