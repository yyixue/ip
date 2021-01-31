import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

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
        String action = input.nextLine();


        do{
            String actionArr[] = action.split(" ", 2);
            switch(arr[0]){

                case "done":
                    // stuff

                    taskNum = Integer.parseInt(actionArr[1]);

                    taskNum = taskNum - 1;
                    allTasks[taskNum].setDone();
                    System.out.println("You've completed " + allTasks[taskNum].getTask() + "!");
                    taskNum = input.nextInt();

                    System.out.println("Your current tasks: ");
                    for(int i=0; i < allTasks.length; i++) {
                        if (allTasks[i] != null) {
                            taskNum = i + 1;
                            System.out.println(taskNum + ". " + allTasks[i].getDone() + " " + allTasks[i].getTask());
                        }
                    }
                    System.out.println("----------------------------------------------------");
                    break;
                case "list":
                    System.out.println("Your current tasks: ");
                    for(int i=0; i < allTasks.length; i++) {
                        if (allTasks[i] != null) {
                            taskNum = i + 1;
                            System.out.println(taskNum + ". " + allTasks[i].getDone() + " " + allTasks[i].getTask());
                        }
                    }
                    System.out.println("----------------------------------------------------");
                    break;
                default:

                    Task t = new Task(actionArr[1]);
                    allTasks[numTasks] = t;
                    System.out.println("Added: " + t.getTask());
                    numTasks ++;
                    System.out.println("----------------------------------------------------");
                    break;
            }

            action = input.nextLine();
        } while (!action.equalsIgnoreCase("Bye"));

        System.out.println("----------------------------------------------------");
        System.out.println("Bye! Hope you have a wonderful day.");
        System.out.println("----------------------------------------------------");

    }
}

