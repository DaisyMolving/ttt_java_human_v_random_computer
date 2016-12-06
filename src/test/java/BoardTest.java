import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void knowANewBoardGridHasNineCells() {
        assertEquals(new Board().grid.length, 9);
    }

}