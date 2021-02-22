package ui;

import tasklist.TaskList;
import task.Task;

import java.util.Scanner;
public class TextUi {

    private static final String LINE_BREAK = "----------------------------------------------------";

    private static final Scanner input = new Scanner(System.in);

    public static void showWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(LINE_BREAK);
        System.out.println(logo);
        System.out.println("Aloha! I'm Duke");
        System.out.println("What would you like to do today?");
        System.out.println("Enter 'Bye' when done.");
        System.out.println(LINE_BREAK);
    }

    public static void showGoodbyeMessage() {
        System.out.println(LINE_BREAK);
        System.out.println("Bye! Hope you have a wonderful day.");
        System.out.println(LINE_BREAK);
    }

    public static String getUserCommand() {
        String action = null;
        if(!input.hasNext() || (action = input.nextLine()).isEmpty()) System.exit(0);
        return action;
    }

    public static void taskAddedMessage(Task t) {
        System.out.println(LINE_BREAK);
        System.out.println("Got it. I've added this task:");
        t.toString();
        System.out.println("Now you have " + TaskList.allTasks.size() + " tasks in the list.");
        System.out.println(LINE_BREAK);
    }

    public static void showTaskList() {
        int taskNum;
        System.out.println("Your current tasks: ");
        for(int i=0; i < TaskList.allTasks.size(); i++) {
            if (TaskList.allTasks.get(i) != null) {
                taskNum = i + 1;
                System.out.println(taskNum + ". " + TaskList.allTasks.get(i).toString());
            }
        }
        System.out.println(LINE_BREAK);
    }

    public static void taskDoneMessage(int taskNum) {
        System.out.println("You've completed " + TaskList.allTasks.get(taskNum).getTask() + "!");
        System.out.println(LINE_BREAK);
    }

    public static void taskDeleteMessage(int taskNum) {
        System.out.println("Noted. I have removed this task:");
        System.out.println(TaskList.allTasks.get(taskNum).toString());
        System.out.println("Now you have " + (TaskList.allTasks.size() - 1) + " tasks in the list.");
    }

    public static void showInvalidInputMessage() {
        System.out.println(LINE_BREAK);
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
        System.out.println(LINE_BREAK);
    }

}
