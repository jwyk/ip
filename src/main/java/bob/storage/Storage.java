package bob.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import bob.exception.BobException;
import bob.tasks.Deadline;
import bob.tasks.Event;
import bob.tasks.Task;
import bob.tasks.Todo;

/**
 * Handles storage of tasks to and from a file.
 * <p>
 * This class provides methods to save and load tasks from a text file,
 * ensuring persistence between program executions. The tasks are stored
 * in a structured format, with each field separated by a delimiter.
 */

public class Storage {
    private static final String filePath = "bob.txt";
    private static final String DIV = "|";

    /**
     * Checks if the save file exists.
     *
     * @return {@code true} if the file exists, {@code false} otherwise.
     */

    public static boolean exists() {
        File f = new File(filePath);
        return f.exists();
    }

    /**
     * Saves the given list of tasks to a text file.
     *
     * @param list The {@link TaskList} containing tasks to be saved.
     * @throws BobException If an error occurs during the saving process.
     * @throws IOException  If an I/O error occurs.
     */

    public static void save(TaskList list) throws BobException, IOException {
        File f = new File(filePath);
        FileWriter fw = new FileWriter(filePath);
        try {
            for (Task temp : list.taskList) {
                //Handle saving each respective task type
                if (temp instanceof Todo) {
                    fw.write("T" + DIV + temp.getStatus() +
                            DIV + temp.getDescription() + DIV);
                } else if (temp instanceof Deadline) {
                    fw.write("D" + DIV + temp.getStatus() +
                            DIV + temp.getDescription() + DIV +
                            ((Deadline) temp).getDueDate());
                } else if (temp instanceof Event) {
                    fw.write("E" + DIV + temp.getStatus() +
                            DIV + temp.getDescription() + DIV +
                            ((Event) temp).getStartDate() + DIV +
                            ((Event) temp).getEndDate());
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new BobException(e.getMessage());
        }

    }

    /**
     * Loads tasks from the save file into the given task list.
     *
     * @param list The {@link TaskList} to populate with loaded tasks.
     * @throws IOException If an I/O error occurs while reading the file.
     */

    public static void load(TaskList list) throws IOException {
        File f = new File(filePath);
        Scanner scanner = new Scanner(f);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] temp = line.split("\\|", 5); //Delimited by |
            switch (temp[0]) {
            case "T":
                Todo tempTodo = new Todo(temp[2]);
                if (temp[1].equals("true")) {
                    tempTodo.markAsDone();
                }
                list.add(tempTodo);
                break;
            case "D":
                Deadline tempDeadline = new Deadline(temp[2],
                        LocalDateTime.parse(temp[3]));
                if (temp[1].equals("true")) {
                    tempDeadline.markAsDone();
                }
                list.add(tempDeadline);
                break;
            case "E":
                Event tempEvent = new Event(temp[2],
                        LocalDateTime.parse(temp[3]),
                        LocalDateTime.parse(temp[4]));
                if (temp[1].equals("true")) {
                    tempEvent.markAsDone();
                }
                list.add(tempEvent);
                break;
            }
        }

    }
}
