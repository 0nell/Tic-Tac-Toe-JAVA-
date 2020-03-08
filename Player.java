import java.io.*;

public class Player{
    char piece;
    String name;
    PrintWriter out;
    BufferedReader in;

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

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

}