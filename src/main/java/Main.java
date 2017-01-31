public class Main {
    public static void main(String[] args) {
        Session newSession = new Session(new CliDisplay(), new Messenger(), new PlayerCreator(), new BoardCreator());
        newSession.start();
    }
}
