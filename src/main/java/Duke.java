import java.io.FileNotFoundException;
import java.util.ArrayList;
import task.*;

import tasklist.TaskList;
import ui.TextUi;
import parser.Parser;
import storage.Storage;

public class Duke {

    private static final String EXIT_COMMAND = "bye";

    public static ArrayList<Task> allTasks = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        TaskList taskList = new TaskList(allTasks);
        String filePath = "/Users/yanyixue/Desktop/year3/sem2/CS2113/ip/tasks.txt";
        Storage storage = new Storage(filePath);

        run();

    }

    public static void run() {
        TextUi.showWelcomeMessage();
        TaskList.allTasks = Storage.getSavedTasks();
        runLoopUntilExitCommand();
        exit();
    }

    private static void exit() {
        TextUi.showGoodbyeMessage();
        System.exit(0);
    }

    private static void runLoopUntilExitCommand() {
        String userInput;
        do {
            userInput = TextUi.getUserCommand();
            Parser.parseCommand(userInput);

        } while (!userInput.equalsIgnoreCase(EXIT_COMMAND));
    }
}


