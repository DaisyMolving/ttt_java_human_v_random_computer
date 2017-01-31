import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    private Validator validator = new Validator();
    private Board board = new Board(3);

    @Test
    public void returnsTrueIsGameTypeInputIsValid() {
        assertTrue(validator.isExistingGameTypeOption("a"));
        assertTrue(validator.isExistingGameTypeOption("b"));
        assertTrue(validator.isExistingGameTypeOption("c"));
        assertTrue(validator.isExistingGameTypeOption("d"));
    }

    @Test
    public void returnsFalseIfGameTypeInputIsInvalid() {
        assertFalse(validator.isExistingGameTypeOption("z"));
        assertFalse(validator.isExistingGameTypeOption("1"));
    }

    @Test
    public void returnsTrueIfTurnInputIsWithinConfinesOfTheBoard() {
        assertTrue(validator.isExistingTurnOption(board, "1"));
        assertTrue(validator.isExistingTurnOption(board, "9"));
    }

    @Test
    public void returnsFalseIfTurnInputIsOutOfBounds() {
        assertFalse(validator.isExistingTurnOption(board, "a"));
        assertFalse(validator.isExistingTurnOption(board, "-1"));
    }

    @Test
    public void returnsFalseIfTurnRequestsUnavailablePosition() {
        Board currentBoard = new Board(Arrays.asList("x", "x", "o", "", "x", "o", "o", "", ""));
        assertFalse(validator.isExistingTurnOption(currentBoard, "1"));
        assertFalse(validator.isExistingTurnOption(currentBoard, "5"));

    }

}
