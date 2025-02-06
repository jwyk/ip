public class Deadline extends Task {
    protected String dueDate;

    public Deadline(String description, String dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + this.description + " (by: " + this.dueDate + ")";
    }

    public void setDueDate(String date) {
        this.dueDate = date;
    }

}
