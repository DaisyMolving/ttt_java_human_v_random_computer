public class HumanPlayer {

    private String name = "";
    private String marker = "";

    public String getName() {
        return name;
    }

    public String getMarker() {
        return marker;
    }

    public void build(String name, String marker) {
        this.name = name;
        this.marker = marker;
    }

}
