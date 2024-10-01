package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import org.junit.jupiter.api.Test;

public class RemarkCommandTest {

    private Model model;
    @Test
    public void execute() {
        assertCommandFailure(new RemarkCommand(), model, RemarkCommand.MESSAGE_NOT_IMPLEMENTED_YET);
    }

}
