public class Task {

    protected boolean done;
    protected String task;
    protected int id;
    protected static int numberOfTasks = 0;

    public Task(String action) {
        this.done = false;
        this.task = action;

        numberOfTasks++;
        id = numberOfTasks;
    }

    public int getID() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setDone() {
        done = true;
    }

    public String getDone() {
        if (done) {
            return "[X]";
        } else {
            return "[ ]";
        }
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }


}