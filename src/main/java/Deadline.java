public class Deadline extends Task {
    protected String dueDate;

    public Deadline(String description) {
        super(description);
    }

    @Override
    public String getTaskIcon() {
        return "[D]";
    }

    @Override
    public String getTask() {
        return "[T] " + getStatusIcon() + this.description + "(by: "  + this.dueDate;
    }


    public void setDueDate(String date) {
        this.dueDate = date;
    }

}
