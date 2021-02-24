package parser;

import task.Deadline;
import task.Event;
import task.Todo;
import tasklist.TaskList;
import ui.TextUi;
import storage.Storage;

import java.io.IOException;

/**
 * Represents all methods to make sense of the user command and execute.
 */
public class Parser {

    private static final String DONE_COMMAND = "done";

    private static final String DELETE_COMMAND = "delete";

    private static final String LIST_COMMAND = "list";

    private static final String TODO_COMMAND = "todo";

    private static final String DEADLINE_COMMAND = "deadline";

    private static final String EVENT_COMMAND = "event";

    /**
     * Parses user input for execution.
     * @param userInput full user input string.
     */
    public static void parseCommand(String userInput) {

        String[] actionArr = userInput.split(" ", 2);
        int taskNum;
        switch(actionArr[0].toLowerCase()) {

            case TODO_COMMAND:
                try {
                    if (actionArr.length == 1) {
                        throw new ParseException("OOPS!!! The description of a todo cannot be empty.");
                    }
                } catch (ParseException b){
                    System.out.println(b);
                    break;
                }
                createTodo(actionArr[1]);
                taskNum = TaskList.allTasks.size();
                storeTask(taskNum);
                break;

            case DEADLINE_COMMAND:
                try {
                    if (actionArr.length == 1) {
                        throw new ParseException("OOPS!!! Deadline description cannot be empty.");
                    }
                } catch (ParseException c){
                    System.out.println(c);
                    break;
                }
                createDeadline(actionArr[1]);
                taskNum = TaskList.allTasks.size();
                storeTask(taskNum);
                break;

            case EVENT_COMMAND:
                try {
                    if (actionArr.length == 1) {
                        throw new ParseException("OOPS!!! Event description cannot be empty.");
                    }
                } catch (ParseException e){
                    System.out.println(e);
                    break;
                }
                createEvent(actionArr[1]);
                taskNum = TaskList.allTasks.size();
                storeTask(taskNum);
                break;

            case LIST_COMMAND:
                TextUi.showTaskList();
                break;

            case DONE_COMMAND:
                try {
                    if (actionArr.length == 1) {
                        throw new ParseException("OOPS!!! Please indicate the task you want to mark as done.");
                    }
                } catch (ParseException a){
                    System.out.println(a);
                    break;
                }
                taskNum = Integer.parseInt(actionArr[1]);
                try {
                    if (taskNum > TaskList.allTasks.size()) {
                        throw new IllegalValueException("OOPS!! Please enter a valid integer for the task index.");
                    }
                } catch (IllegalValueException k) {
                    System.out.println(k);
                    break;
                }
                taskNum = taskNum - 1;
                TaskList.allTasks.get(taskNum).setDone();
                TextUi.taskDoneMessage(taskNum);
                for(int i=0; i < TaskList.allTasks.size(); i++) {
                    taskNum = i + 1;
                    storeTask(taskNum);
                }
                break;

            case DELETE_COMMAND:
                try {
                    if (actionArr.length == 1) {
                        throw new ParseException("OOPS!!! Please indicate the task you want to mark as done.");
                    }
                } catch (ParseException a){
                    System.out.println(a);
                    break;
                }
                taskNum = Integer.parseInt(actionArr[1]);
                try {
                    if (taskNum > TaskList.allTasks.size()) {
                        throw new IllegalValueException("OOPS!! Please enter a valid integer for the task index.");
                    }
                } catch (IllegalValueException k) {
                    System.out.println(k);
                    break;
                }
                taskNum = taskNum - 1;
                TextUi.taskDeleteMessage(taskNum);
                TaskList.allTasks.remove(taskNum);
                for(int i=0; i < TaskList.allTasks.size(); i++) {
                    taskNum = i + 1;
                    storeTask(taskNum);
                }
                break;

            default:
                TextUi.showInvalidInputMessage();
        }
    }

    private static void createTodo(String todoDescription) {
        Todo t = new Todo(todoDescription);
        TaskList.allTasks.add(t);
        TextUi.taskAddedMessage(t);
    }

    private static void createDeadline(String deadlineDescription) {
        String[] deadlineParts = deadlineDescription.split("/by");
        try {
            if (deadlineParts.length == 1) {
                throw new ParseException("OOPS!! You did not include a deadline using /by. :(");
            }
        } catch (ParseException d){
            System.out.println(d);
        }
        Deadline d = new Deadline(deadlineParts[0], deadlineParts[1]);
        TaskList.allTasks.add(d);
        TextUi.taskAddedMessage(d);
    }

    private static void createEvent(String eventDescription) {
        String[] eventParts = eventDescription.split("/at");
        try {
            if (eventParts.length == 1) {
                throw new ParseException("OOPS!! You did not include an event date using /at. :(");
            }
        } catch (ParseException z){
            System.out.println(z);
        }
        Event e = new Event(eventParts[0], eventParts[1]);
        TaskList.allTasks.add(e);
        TextUi.taskAddedMessage(e);
    }


    private static void storeTask(int taskNum) {
        if (taskNum==1) {
            try {
                Storage.writeToFile(taskNum + ". " + TaskList.allTasks.get(0).toString() + "\n");
            } catch (IOException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        } else {
            try {
                Storage.appendToFile(taskNum + ". " + TaskList.allTasks.get(taskNum-1).toString() + "\n");
            } catch (IOException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }
    }

    /**
     * Signals that the user input could not be parsed.
     */
    public static class ParseException extends Exception {
        ParseException(String message) {
            super(message);
        }
    }

    /**
     * Signals that the user's input task number does not exist in the task list.
     */
    public static class IllegalValueException extends Exception {
        IllegalValueException(String message) {
            super(message);
        }
    }

}
