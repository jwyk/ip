package bob;

import java.io.IOException;

import bob.parser.Parser;
import bob.ui.Ui;

public class Bob {
    private static TaskList taskList;
    private Storage storage;

    public static void main(String[] args) throws BobException {
        Ui.showHi();
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
