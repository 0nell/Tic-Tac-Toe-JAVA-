package First;
public class Player{
    char piece;
    String name;

    public char getPiece() {
        return piece;
    }
    public void setPiece(char piece) {
        piece = Character.toUpperCase(piece);
        if(piece == 'X' || piece == 'O')
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