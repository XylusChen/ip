package duke.command;

import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * Represents a mark task as complete command.
 */
public class MarkCommand extends Command {

    private int toMark;

    /**
     * Constructs mark task as complete command.
     *
     * @param toMark Integer to specify task to be marked as complete.
     */
    public MarkCommand(int toMark) {
        this.toMark = toMark;
    }

    @Override
    public boolean isGoodbye() {
        return false;
    }

    /**
     * Marks specified task as complete.
     *
     * @param tasks Tasklist object.
     * @param storage Storage object.
     * @param ui Ui Object.
     */
    @Override
    public String execute(TaskList tasks, Storage storage, Ui ui) {
        return tasks.markTask(toMark);
    }
}
