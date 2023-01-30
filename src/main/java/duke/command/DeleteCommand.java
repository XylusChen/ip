package duke.command;

import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * Represents a delete task command.
 */
public class DeleteCommand extends Command {
    private int toDelete;

    /**
     * Constructs a delete task command.
     *
     * @param toDelete Integer index of task to be deleted from task collection.
     */
    public DeleteCommand(int toDelete) {
        this.toDelete = toDelete;
    }

    @Override
    public boolean isGoodbye() {
        return false;
    }

    /**
     * Deletes tasks from task collection.
     *
     * @param tasks Tasklist object.
     * @param storage Storage object.
     * @param ui Ui Object.
     */
    @Override
    public String execute(TaskList tasks, Storage storage, Ui ui) {
        return tasks.deleteTask(toDelete);
    }
}
