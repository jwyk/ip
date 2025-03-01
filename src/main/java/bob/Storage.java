package bob;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bob.task.Deadline;
import bob.task.Event;
import bob.task.Task;
import bob.task.Todo;

/**
 * Represents a storage class which saves in the following format
 * taskIcon|description|isDone
 * <p>
 * For Deadline tasks, the following is the format
 * taskIcon|description|isDone|dueDate
 * <p>
 * For Event tasks, the following is the format
 * taskIcon|description|isDone|startDate|endDate
 */

public class Storage {
    private static final String filePath = "bob.txt";
    private static final String DIV = "|";

    /**
     * Returns whether a save file exists or not
     */

    public static boolean exists() {
        File f = new File(filePath);
        return f.exists();
    }

    /**
     * Saves the list into a text file, each separated by 1 line
     *
     * @param list ArrayList containing Tasks
     */

    public static void save(TaskList list) throws BobException, IOException {
        File f = new File(filePath);
        FileWriter fw = new FileWriter(filePath);
        try {
            for (Task temp : list) {
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
     * Loads tasks from a text file, each separated by 1 line
     *
     * @param list ArrayList containing Tasks
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
                Deadline tempDeadline = new Deadline(temp[2], temp[3]);
                if (temp[1].equals("true")) {
                    tempDeadline.markAsDone();
                }
                list.add(tempDeadline);
                break;
            case "E":
                Event tempEvent = new Event(temp[2], temp[3], temp[4]);
                if (temp[1].equals("true")) {
                    tempEvent.markAsDone();
                }
                list.add(tempEvent);
                break;
            }
        }

    }
}
