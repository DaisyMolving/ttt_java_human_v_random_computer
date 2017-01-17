import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ValidatorTest {

    private Validator validator = new Validator(new Board(Arrays.asList("", "", "", "", "", "", "", "", "")), new Messenger());

    @Test
    public void shouldValidateGameTypeIfValidInput() {
        assertEquals("a", validator.validateGameType("a").message);
        assertEquals("b", validator.validateGameType("b").message);
        assertEquals("c", validator.validateGameType("c").message);
        assertEquals("d", validator.validateGameType("d").message);
    }

    @Test
    public void shouldReturnInvalidMessageIfInvalidGameType() {
        assertTrue(validator.validateGameType("z").message.contains("invalid"));
        assertEquals("invalid", validator.validateGameType("z").status);
        assertTrue(validator.validateGameType("1").message.contains("invalid"));
        assertEquals("invalid", validator.validateGameType("1").status);
    }

    @Test
    public void shouldValidateTurnIfValidInput() {
        assertEquals("1", validator.validateTurn("1").message);
        assertEquals("9", validator.validateTurn("9").message);
    }

    @Test
    public void shouldReturnInvalidMessageIfInvalidTurn() {
        assertTrue(validator.validateTurn("z").message.contains("invalid"));
        assertEquals("invalid", validator.validateTurn("z").status);
        assertTrue(validator.validateTurn("-1").message.contains("invalid"));
        assertEquals("invalid", validator.validateTurn("-1").status);
        assertTrue(validator.validateTurn("123").message.contains("invalid"));
        assertEquals("invalid", validator.validateTurn("123").status);
    }

    @Test
    public void shouldReturnInvalidMessageIfCellIsTaken() {
        Validator validator = new Validator(new Board(Arrays.asList("x", "", "", "", "", "", "", "", "")), new Messenger());
        assertTrue(validator.validateTurn("1").message.contains("invalid"));
        assertEquals("invalid", validator.validateTurn("1").status);
    }

}
