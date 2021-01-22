import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Task[] allTasks = new Task[100];
        int numTasks = 0;
        int taskNum = 0;
        int markNum;

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("----------------------------------------------------");
        System.out.println(logo);
        System.out.println("Aloha! I'm Duke");
        System.out.println("Enter the number for what you'll like me to do for you today :)");
        System.out.println("[1] AddTask || [2] CompleteTask || [3] ViewTasks || [4] Exit");
        System.out.println("----------------------------------------------------");

        // obtain string input
        String action = input.nextLine();
        do{
            switch(action){
                case "1":
                    System.out.println("Please enter your tasks. Enter 'done' if all tasks added.");
                    action = input.nextLine();
                    do{
                        Task t = new Task(action);
                        allTasks[numTasks] = t;
                        System.out.println("Added: " + t.getTask());
                        numTasks ++;
                        action = input.nextLine();
                    } while (!action.equalsIgnoreCase("done"));
                    System.out.println("What would you like to do next?");
                    System.out.println("[1] AddTask || [2] CompleteTask || [3] ViewTasks || [4] Exit");
                    System.out.println("----------------------------------------------------");
                    break;
                case "2":
                    // stuff
                    System.out.println("Your current tasks: ");
                    for(int i=0; i < allTasks.length; i++) {
                        if (allTasks[i] != null) {
                            taskNum = i + 1;
                            System.out.println(taskNum + ". " + allTasks[i].getDone() + " " + allTasks[i].getTask());
                        }
                    }
                    System.out.println("Please enter the number of the task you have completed.");
                    System.out.println("Enter '0' if nothing else.");
                    markNum = input.nextInt();
                    do{
                        markNum = markNum - 1;
                        allTasks[markNum].setDone();
                        System.out.println("You've completed " + allTasks[markNum].getTask() + "!");
                        markNum = input.nextInt();

                    } while (markNum != 0);
                    System.out.println("Your current tasks: ");
                    for(int i=0; i < allTasks.length; i++) {
                        if (allTasks[i] != null) {
                            taskNum = i + 1;
                            System.out.println(taskNum + ". " + allTasks[i].getDone() + " " + allTasks[i].getTask());
                        }
                    }
                    System.out.println("What would you like to do next?");
                    System.out.println("[1] AddTask || [2] CompleteTask || [3] ViewTasks || [4] Exit");
                    System.out.println("----------------------------------------------------");
                    break;
                case "3":
                    System.out.println("Your current tasks: ");
                    for(int i=0; i < allTasks.length; i++) {
                        if (allTasks[i] != null) {
                            taskNum = i + 1;
                            System.out.println(taskNum + ". " + allTasks[i].getDone() + " " + allTasks[i].getTask());
                        }
                    }
                    System.out.println("What would you like to do next?");
                    System.out.println("[1] AddTask || [2] CompleteTask || [3] ViewTasks || [4] Exit");
                    System.out.println("----------------------------------------------------");
                    break;
            }

            action = input.nextLine();
        } while (!action.equalsIgnoreCase("4"));

        System.out.println("----------------------------------------------------");
        System.out.println("Bye! Hope you have a wonderful day.");
        System.out.println("----------------------------------------------------");

    }
}

