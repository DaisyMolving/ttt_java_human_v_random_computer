import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    private Validator validator = new Validator();

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
        assertTrue(validator.withinConfinesOfTheBoard("1"));
        assertTrue(validator.withinConfinesOfTheBoard("9"));
    }

    @Test
    public void returnsFalseIfTurnInputIsOutOfBounds() {
        assertFalse(validator.withinConfinesOfTheBoard("a"));
        assertFalse(validator.withinConfinesOfTheBoard("-1"));
    }

}
