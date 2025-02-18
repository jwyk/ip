package bob;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import bob.task.Task;

public class Storage {
    private static final String filePath = "data/bob.txt";

    /**
     * Saves the list into a text file, each separated by 1 line
     *
     * @param list ArrayList containing Tasks
     */

    public static void save(ArrayList<Task> list) throws BobException, IOException {
        File f = new File(filePath);
        FileWriter fw = new FileWriter(filePath);
        try {
            for (Task temp : list) {
                String save = temp.toString();
                fw.write(save + "\n");
            }
            fw.close();
        } catch (FileNotFoundException e) {
            throw new BobException("File not found.");
        } catch (IOException e) {
            throw new BobException(e.getMessage());
        }

    }

}
