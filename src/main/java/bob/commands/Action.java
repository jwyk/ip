package bob.commands;

import bob.exception.BobException;

/**
 * Maps each action to an actionString typed in by the user
 */
public enum Action {
    BYE("bye"),
    LIST("list"),
    MARK("mark"),
    UNMARK("unmark"),
    DEADLINE("deadline"),
    TODO("todo"),
    EVENT("event"),
    DELETE("delete"),
    FIND("find");

    private final String actionString;

    /**
     * Constructs an {@code Action} with the specified command string.
     *
     * @param actionString The string representation of the action.
     */
    Action(String actionString) {
        this.actionString = actionString;
    }

    /**
     * Returns an {@code Action} corresponding to a given input string.
     *
     * @param input The user input string.
     * @return The corresponding {@code Action} enum value.
     * @throws BobException If no matching action is found.
     */
    public static Action fromString(String input) throws BobException {
        for (Action action : Action.values()) {
            //Ignore any case
            if (action.actionString.equalsIgnoreCase(input)) {
                return action;
            }
        }
        throw new BobException("No command with text " + input + " found");
    }

}
