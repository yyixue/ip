package task;

/**
 * Represents a deadline in the task list.
 */
public class Deadline extends Task{
    protected String by;

    /**
     * Create deadline.
     * @param task String description of the deadline.
     * @param by String date and time of the deadline.
     */
    public Deadline(String task, String by) {
        super(task);
        this.by = by;
    }

    /**
     * Add [D] symbol that represents a deadline.
     * @return String formatted task in text format with task type,
     * done status and task description.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}