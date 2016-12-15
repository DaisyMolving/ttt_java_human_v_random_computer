import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class CliDisplayTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final ByteArrayInputStream input = new ByteArrayInputStream("string data\n".getBytes());

    @Before
    public void beginIOStreams() {
        System.setOut(new PrintStream(output));
        System.setIn(input);
    }

    @After
    public void wipeStreams() {
        System.setOut(null);
        System.setIn(System.in);
    }

    @Test
    public void cliDisplayPrintsOutputToConsole() {
        CliDisplay cliOutput = new CliDisplay();
        cliOutput.printMessage("Hi There!");
        assertEquals("Hi There!", output.toString());
    }

    @Test
    public void cliDisplayGetsInputFromConsole() {
        CliDisplay cliInput = new CliDisplay();
        assertEquals("string data", cliInput.getResponse("Hi There!"));
    }
}
