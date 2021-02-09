import java.util.Scanner;
import task.*;

class DukeException extends Exception {
    public DukeException(String errorMessage) {
        super(errorMessage);
    }
}

public class Duke {
    public static void main(String[] args){

        String action = null;
        Scanner input = new Scanner(System.in);
        Task[] allTasks = new Task[100];
        int numTasks = 0;
        int taskNum = 0;

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("----------------------------------------------------");
        System.out.println(logo);
        System.out.println("Aloha! I'm Duke");
        System.out.println("What would you like to do today?");
        System.out.println("Enter 'Bye' when done.");
        System.out.println("----------------------------------------------------");

        // obtain string input
        if(!input.hasNext() || (action = input.nextLine()).isEmpty()) System.exit(0);

        while (!action.equalsIgnoreCase("Bye")){
            String actionArr[] = action.split(" ", 2);
            switch(actionArr[0].toLowerCase()){

                case "done":
                    try {
                        if (actionArr.length == 1) {
                            throw new DukeException("OOPS!!! Please indicate the task you want to mark as done.");
                        }
                    } catch (DukeException a){
                        System.out.println(a);
                        break;
                    }
                    taskNum = Integer.parseInt(actionArr[1]);
                    taskNum = taskNum - 1;
                    allTasks[taskNum].setDone();
                    System.out.println("You've completed " + allTasks[taskNum].getTask() + "!");
                    System.out.println("----------------------------------------------------");
                    break;
                case "list":
                    System.out.println("Your current tasks: ");
                    for(int i=0; i < allTasks.length; i++) {
                        if (allTasks[i] != null) {
                            taskNum = i + 1;
                            System.out.println(taskNum + ". " + allTasks[i].toString());
                        }
                    }
                    System.out.println("----------------------------------------------------");
                    break;
                case "todo":
                    try {
                        if (actionArr.length == 1) {
                            throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                        }
                    } catch (DukeException b){
                        System.out.println(b);
                        break;
                    }
                    Todo t = new Todo(actionArr[1]);
                    allTasks[numTasks] = t;
                    System.out.println("----------------------------------------------------");
                    System.out.println("Got it. I've added this task:");
                    t.toString();
                    numTasks++;
                    System.out.println("Now you have " + String.valueOf(numTasks) + " tasks in the list.");
                    System.out.println("----------------------------------------------------");
                    break;
                case "deadline":
                    try {
                        if (actionArr.length == 1) {
                            throw new DukeException("OOPS!!! Deadline description cannot be empty.");
                        }
                    } catch (DukeException c){
                        System.out.println(c);
                        break;
                    }
                    String[] deadlineParts = actionArr[1].split("/by");
                    try {
                        if (deadlineParts.length == 1) {
                            throw new DukeException("OOPS!! You did not include a deadline using /by. :(");
                        }
                    } catch (DukeException d){
                        System.out.println(d);
                        break;
                    }
                    Deadline d = new Deadline(deadlineParts[0], deadlineParts[1]);
                    allTasks[numTasks] = d;
                    System.out.println("----------------------------------------------------");
                    System.out.println("Got it. I've added this task:");
                    d.toString();
                    numTasks ++;
                    System.out.println("Now you have "+ String.valueOf(numTasks) +" tasks in the list.");
                    System.out.println("----------------------------------------------------");
                    break;
                case "event":
                    try {
                        if (actionArr.length == 1) {
                            throw new DukeException("OOPS!!! Event description cannot be empty.");
                        }
                    } catch (DukeException e){
                        System.out.println(e);
                        break;
                    }
                    String[] eventParts = actionArr[1].split("/at");
                    try {
                        if (eventParts.length == 1) {
                            throw new DukeException("OOPS!! You did not include an event date using /at. :(");
                        }
                    } catch (DukeException f){
                        System.out.println(f);
                        break;
                    }
                    Event e = new Event(eventParts[0], eventParts[1]);
                    allTasks[numTasks] = e;
                    System.out.println("----------------------------------------------------");
                    System.out.println("Got it. I've added this task:");
                    e.toString();
                    numTasks ++;
                    System.out.println("Now you have "+ String.valueOf(numTasks) +" tasks in the list.");
                    System.out.println("----------------------------------------------------");
                    break;
                default:
                    System.out.println("----------------------------------------------------");
                    System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                    System.out.println("----------------------------------------------------");
                    break;

            }
            if(!input.hasNext() || (action = input.nextLine()).isEmpty()) System.exit(0);
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Bye! Hope you have a wonderful day.");
        System.out.println("----------------------------------------------------");

    }
}

