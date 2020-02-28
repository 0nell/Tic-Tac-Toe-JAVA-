package First;
public class Player{
    String piece;
    String name;

    public String getPiece() {
        return piece;
    }
    public void setPiece(String piece) {
        piece.toUpperCase();
        this.piece = piece;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }

    public void resetPlayer() {
        this.setPiece("");
        this.setName(null);
    }

}