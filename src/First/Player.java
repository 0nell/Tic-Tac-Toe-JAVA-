package First;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Player {
    String piece;
    PrintWriter out;
    BufferedReader in;


    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }


    public void resetPlayer() {
        this.setPiece("");
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