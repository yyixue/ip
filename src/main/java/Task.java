public class Task {

    protected boolean done;
    protected String task;
    protected String taskType;
    protected int id;
    protected static int numberOfTasks = 0;

    public Task(String task) {
        this.done = false;
        this.


        numberOfTasks++;
        id = numberOfTasks;
    }

    public int getID() {
        return id;
    }

    public void getTaskType(){
        switch (this.taskType){
            case "todo":
                return "[T]";
            case "deadline":
                return "[D]";
            case "event":
                return "[E]";
        }
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