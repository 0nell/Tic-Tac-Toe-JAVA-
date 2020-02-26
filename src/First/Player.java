package First;
public class Player{
    String piece;
    String name;

    public String getPiece() {
        return piece;
    }
    public void setPiece(String piece) {
        piece.toUpperCase();
        if(piece == "X" || piece == "O")
            this.piece = piece;
        else
            throw new IllegalArgumentException("Wrong character input");
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

}