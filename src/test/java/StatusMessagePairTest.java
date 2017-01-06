import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatusMessagePairTest {

    @Test
    public void thatTwoStringsCanBeCollectedAsPair() {
        StatusMessagePair pair = new StatusMessagePair("ok", "hello there");
        assertEquals("ok", pair.status);
        assertEquals("hello there", pair.message);
    }

}
