import java.io.IOException;

public interface Display {

    public void sendToTheDisplay(String message);
    public String getResponse(String request);
    public void clearDisplay();
}
