public class StatusMessagePair<X, Y> {

    public final X status;
    public final Y message;

    public StatusMessagePair(X status, Y message) {
        this.status = status;
        this.message = message;
    }

}
