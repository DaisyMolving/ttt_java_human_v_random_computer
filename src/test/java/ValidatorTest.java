import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ValidatorTest {

    private Validator validator = new Validator();

    @Test
    public void shouldValidateGameTypeIfValidInput() {
        assertEquals("a", validator.validateGameType("a"));
        assertEquals("b", validator.validateGameType("b"));
        assertEquals("c", validator.validateGameType("c"));
        assertEquals("d", validator.validateGameType("d"));
    }

    @Test
    public void shouldReturnInvalidMessageIfInvalidGameType() {
        assertTrue(validator.validateGameType("z").contains("invalid"));
        assertTrue(validator.validateGameType("1").contains("invalid"));
    }

    @Test
    public void shouldValidateTurnIfValidInput() {
        Board board = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
        assertEquals("1", validator.validateTurn("1", board));
        assertEquals("9", validator.validateTurn("9", board));
    }

    @Test
    public void shouldReturnInvalidMessageIfInvalidTurn() {
        Board board = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
        assertTrue(validator.validateTurn("z", board).contains("invalid"));
        assertTrue(validator.validateTurn("-1", board).contains("invalid"));
        assertTrue(validator.validateTurn("123", board).contains("invalid"));
    }

    @Test
    public void shouldReturnInvalidMessageIfCellIsTaken() {
        Board board = new Board(Arrays.asList("x", "", "", "", "", "", "", "", ""));
        assertTrue(validator.validateTurn("1", board).contains("invalid"));
    }

}
