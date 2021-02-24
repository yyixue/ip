package task;

/**
 * Represents a task in the task list.
 */
public class Task {

    protected boolean done;
    protected String task;

    public Task(String task) {
        this.done = false;
        this.task = task;
    }

    /**
     * Formats the task description as text.
     * @return String task.
     */
    public String getTask() {
        return task;
    }

    /**
     * Mark the task as done.
     */
    public void setDone() {
        done = true;
    }

    /**
     * Format the done status of the task as text.
     * @return String done status.
     */
    public String getDone() {
        if (done) {
            return "[X]";
        } else {
            return "[ ]";
        }
    }

    /**
     * Format the entire task and done status as text.
     * @return String done status and task.
     */
    public String toString() {
        return getDone() + " " + task;
    }


}