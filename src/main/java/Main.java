public class Main {
    public static void main(String[] args) {
        Session newSession = new Session(new CliDisplay(), new Messenger());
        newSession.start();
    }
}
