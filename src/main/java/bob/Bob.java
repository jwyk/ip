package bob;

import java.util.ArrayList;

import bob.task.Task;

public class Bob {
    private static ArrayList<Task> list;

    //Initializer for Bob
    public Bob() {
        list = new ArrayList<Task>();
    }

    //Takes in a string input and prints outputs depending on the input string

    public static void main(String[] args) throws BobException {
        System.out.println("____________________________________________________________");
        System.out.println("Hello I'm Bob\n" + "What can I do for you?");
        System.out.println("____________________________________________________________");

        Bob Tasks = new Bob();
        Parser.getInput(list);

    }
}
