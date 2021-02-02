public class Task {

    protected boolean done;
    protected String task;
    protected int id;
    protected static int numberOfTasks = 0;

    public Task(String task) {
        this.done = false;
        this.task = task;
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

    public String toString() {
        return getDone() + " " + task;
    }


}