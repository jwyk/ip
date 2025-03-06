package bob.ui;

import java.util.List;

import bob.storage.TaskList;
import bob.tasks.Task;

/**
 * Handles the user interface and displays messages in response to user actions.
 * Provides feedback for actions such as adding, marking, unmarking, deleting,
 * and finding tasks.
 */
public class Ui {

    /**
     * Displays a horizontal line as a visual separator.
     */
    public static void showLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a farewell message when exiting the application.
     */
    public static void showBye() {
        System.out.println("Bye dude, see you soon again!");
        showLine();
    }

    /**
     * Displays a confirmation message after adding a task.
     *
     * @param list The current {@link TaskList} after adding the task.
     */
    public static void showAdd(TaskList list) {
        System.out.println("Okay, we are checking... done! Task added.");
        System.out.println("added: " + list.get(list.size() - 1));
        System.out.println("Current number of tasks: " + list.size());
        showLine();
    }

    /**
     * Displays a confirmation message after marking a task as done.
     *
     * @param list       The current {@link TaskList}.
     * @param markedTask The task that was marked as done.
     */
    public static void showMark(TaskList list, Task markedTask) {
        System.out.println("Okay, we are checking... done! Task marked.");
        System.out.println(markedTask);
        showLine();
    }

    /**
     * Displays a confirmation message after unmarking a task as not done.
     *
     * @param list         The current {@link TaskList}.
     * @param unmarkedTask The task that was unmarked.
     */
    public static void showUnmark(TaskList list, Task unmarkedTask) {
        System.out.println("Okay, we are checking... done! Task unmarked.");
        System.out.println(unmarkedTask);
        showLine();
    }

    /**
     * Displays a confirmation message after deleting a task.
     *
     * @param list        The current {@link TaskList} after deletion.
     * @param deletedTask The task that was deleted.
     */
    public static void showDelete(TaskList list, Task deletedTask) {
        System.out.println("Okay, we are checking... done! Task deleted.");
        System.out.println("deleted: " + deletedTask);
        System.out.println("Current number of tasks: " + list.size());
        showLine();
    }

    /**
     * Displays a greeting message when the application starts.
     */
    public static void showHi() {
        showLine();
        System.out.println("Hello I'm Bob\n" + "What can I do for you?");
        showLine();
    }

    /**
     * Displays a list of tasks that match a given keyword.
     *
     * @param filterList The list of tasks containing the keyword.
     * @param keyword    The keyword used for filtering tasks.
     */
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
