package bob.commands;

import bob.BobException;

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
    FIND("find"),
    DELETE("delete");

    private final String actionString;

    Action(String actionString) {
        this.actionString = actionString;
    }

    /**
     * Return an Action value from a given input string
     *
     * @param input Input String from the console
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
