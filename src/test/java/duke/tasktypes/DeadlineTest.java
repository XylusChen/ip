package duke.tasktypes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void testStringConversion_deadlineTaskUndone_success() {
        Deadline task = new Deadline("This is a test Deadline task.", "2023/01/01 1000");
        task.markDone();
        task.markUndone();
        String actualOutput = task.toString();
        assertEquals("[D][ ] This is a test Deadline task. (by: 1 Jan 2023, 10:00 AM)", actualOutput);
    }

    @Test
    public void testSaveFormatConversion_deadlineTaskUndone_success() {
        Deadline task = new Deadline("This is another test Deadline task.", "2023/01/01 1000");
        task.markDone();
        task.markUndone();
        String actualOutput = task.getSaveFormat();
        assertEquals("D,,0,,This is another test Deadline task.,,2023-01-01 1000", actualOutput);
    }
}