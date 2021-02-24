package task;

/**
 * Represents an event in the task list.
 */
public class Event extends Task{
    protected String at;

    /**
     * Create event.
     * @param task String description of the event.
     * @param at String date and time of the event.
     */
    public Event(String task, String at) {
        super(task);
        this.at = at;
    }

    /**
     * Add [E] symbol that represents an event.
     * @return String formatted task in text format with task type,
     * done status and task description.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}