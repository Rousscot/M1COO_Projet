package gui.exception;

/**
 * todo
 */
public class NoActionForCommand extends NullPointerException{
    protected final String command;

    public NoActionForCommand(String command) {
        this.command = command;
    }

    public String command() {
        return this.command;
    }
}
