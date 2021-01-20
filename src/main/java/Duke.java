import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] allTasks = new String[100];
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
        System.out.println("Enter the number for what you'll like me to do for you today :)");
        System.out.println("[1] AddTask || [2] CompleteTask || [3] ViewTasks || [4] Exit");
        System.out.println("----------------------------------------------------");

        // obtain string input
        String action = input.nextLine();
        do{
            System.out.println("----------------------------------------------------");
            // System.out.println(action);
            switch(action){
                case "1":
                    System.out.println("Please enter your tasks. Enter 'done' if all tasks added.");
                    action = input.nextLine();
                    do{
                        allTasks[numTasks] = action;
                        System.out.println("Added: " + action);
                        numTasks ++;
                        action = input.nextLine();
                    } while (!action.equalsIgnoreCase("done"));
                    System.out.println("What would you like to do next?");
                    System.out.println("[1] AddTask || [2] CompleteTask || [3] ViewTasks || [4] Exit");


                case "2":
                    // stuff
                    System.out.println("What would you like to do next?");
                    System.out.println("[1] AddTask || [2] CompleteTask || [3] ViewTasks || [4] Exit");
                    break;
                case "3":
                    System.out.println("Your current tasks: ");
                    for(int i=0; i < allTasks.length; i++) {
                        if (allTasks[i] != null) {
                            taskNum = i + 1;
                            System.out.println(taskNum + ". " + allTasks[i]);
                        }
                    }
                    System.out.println("What would you like to do next?");
                    System.out.println("[1] AddTask || [2] CompleteTask || [3] ViewTasks || [4] Exit");

            }
            System.out.println("----------------------------------------------------");
            action = input.nextLine();
        } while (!action.equalsIgnoreCase("4"));

        System.out.println("----------------------------------------------------");
        System.out.println("Bye! Hope you have a wonderful day.");
        System.out.println("----------------------------------------------------");

    }
}