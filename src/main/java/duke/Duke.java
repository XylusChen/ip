package duke;

import duke.command.Command;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.exceptions.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * Represents a build instance of Duke.
 * A Duke object is created when Duke is run.
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructs a Duke instance to run Duke program.
     */
    public Duke() {
        ui = new Ui();
        storage = new Storage(ui);
        tasks = storage.load();
    }

    public static void main(String[] args) {
        new Duke().run();
    }

    /**
     * Duke Logic and Simulation.
     */
    public void run() {

        ui.showLine();
        ui.greet();
        ui.showLine();

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.nextInput();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, storage, ui);
                isExit = c.isGoodbye();
            } catch (DukeException e) {
                ui.showError(e);
            } finally {
                ui.showLine();
            }
        }
    }

    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            boolean isModify = true;
            if (c instanceof ListCommand || c instanceof FindCommand || c.isGoodbye()) {
                isModify = false;
            }
            String toReturn;
            if (c.isGoodbye()) {
                toReturn = "END_COMMAND" + c.execute(tasks, storage, ui);
            } else {
                toReturn = c.execute(tasks, storage, ui);
            }
            if (isModify) {
                storage.save(tasks);
            }
            return toReturn;
        } catch (DukeException de) {
            return ui.showError(de);
        } catch (Exception e) {

            return "Unaccounted for: " + e.getClass() + e.getMessage() + "\n";
        }
    }
}
