import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class CliDisplayTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final ByteArrayInputStream input = new ByteArrayInputStream("string data\n".getBytes());
    private PrintStream systemOutput;

    @Before
    public void beginIOStreams() {
        systemOutput = System.out;
        System.setOut(new PrintStream(output));
        System.setIn(input);
    }

    @After
    public void wipeStreams() {
        System.setOut(systemOutput);
        System.setIn(System.in);
    }

    @Test
    public void cliDisplayPrintsOutputToConsole() {
        Display cliOutput = new CliDisplay();
        cliOutput.sendMessageToDisplay("Hi There!");
        assertEquals("Hi There!", output.toString());
    }

    @Test
    public void cliDisplayGetsInputFromConsole() {
        Display cliInput = new CliDisplay();
        assertEquals("string data", cliInput.getResponse(""));
    }
}