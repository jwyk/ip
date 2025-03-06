package bob.ui;

import bob.TaskList;
import bob.tasks.Task;

import java.util.List;

/*
 *
 * Contains the UI display commands for each input the user makes
 */
public class Ui {
    public static void showLine() {
        System.out.println("____________________________________________________________");
    }

    public static void showBye() {
        System.out.println("Bye dude, see you soon again!");
        showLine();
    }

    public static void showAdd(TaskList list) {
        System.out.println("Okay, we are checking... done! Task added.");
        System.out.println("added: " + list.get(list.size() - 1));
        System.out.println("Current number of tasks: " + list.size());
        showLine();
    }

    public static void showMark(TaskList list, Task markedTask) {
        System.out.println("Okay, we are checking... done! Task marked.");
        System.out.println(markedTask);
        showLine();
    }

    public static void showUnmark(TaskList list, Task unmarkedTask) {
        System.out.println("Okay, we are checking... done! Task unmarked.");
        System.out.println(unmarkedTask);
        showLine();
    }

    public static void showDelete(TaskList list, Task deletedTask) {
        System.out.println("Okay, we are checking... done! Task deleted.");
        System.out.println("deleted: " + deletedTask);
        System.out.println("Current number of tasks: " + list.size());
        showLine();
    }

    public static void showHi() {
        showLine();
        System.out.println("Hello I'm Bob\n" + "What can I do for you?");
        showLine();
    }

    public static void showFind(List<Task> filterList, String keyword) {
        if (filterList.isEmpty()) {
            System.out.println("No tasks contain matching keyword \"" + keyword + "\"");
        } else {
            int count = 1;
            System.out.println("Tasks containing \"" + keyword + "\"");
            for (Task task : filterList) {
                System.out.println(count + "." + task);
                count++;
            }
        }
        showLine();
    }
}
