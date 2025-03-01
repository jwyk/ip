package bob;

import java.io.IOException;

public class Bob {
    private static TaskList taskList;
    private Storage storage;
    //Initializer for Bob

    //Takes in a string input and prints outputs depending on the input string

    public static void main(String[] args) throws BobException {
        System.out.println("____________________________________________________________");
        System.out.println("Hello I'm Bob\n" + "What can I do for you?");
        System.out.println("____________________________________________________________");
        taskList = new TaskList();
        if (Storage.exists()) {
            try {
                Storage.load(taskList);
            } catch (IOException e) {
                System.out.print("Failed to load data. Will start with a new save file.");
            }
        }

        Parser.getInput(taskList);

    }
}
