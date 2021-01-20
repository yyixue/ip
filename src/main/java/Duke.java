import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("----------------------------------------------------");
        System.out.println(logo);
        System.out.println("Aloha! I'm Duke");
        System.out.println("What can I do for you today?");
        System.out.println("Enter 'Bye' if you'll like to leave.");
        System.out.println("----------------------------------------------------");

        // obtain string input
        String action = input.nextLine();
        do{
            System.out.println("----------------------------------------------------");
            System.out.println(action);
            System.out.println("----------------------------------------------------");
            action = input.nextLine();
        } while (!action.equalsIgnoreCase("Bye"));

        System.out.println("----------------------------------------------------");
        System.out.println("Bye! Hope you have a wonderful day.");
        System.out.println("----------------------------------------------------");

    }
}