package bob;

import java.util.ArrayList;

import bob.task.Task;

/*
 * Contains an ArrayList of Tasks with ability to print out contents
 */

public class TaskList extends ArrayList <Task> {

    public void list() {
        if (this.isEmpty()) {
            System.out.println("There are no tasks. Maybe add a few more.");
        } else {
            for (int i = 0; i < this.size(); i++) {
                System.out.println(i + 1 + ". " + this.get(i));
            }
        }
    }

}
