import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PairTest {

    @Test
    public void thatTwoStringsCanBeCollectedAsPair() {
        Pair pair = new Pair("hello", "there");
        assertEquals("hello", pair.first);
        assertEquals("there", pair.last);
    }

}
