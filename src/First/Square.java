package First;

import javafx.scene.control.Button;

public class Square{
    String piece;
    Button btn;
    Square(){
        piece = null;
        btn = new Button();
    }
    void setPiece(String piece) {
        piece = Character.toUpperCase(piece);
        if(piece == "X" || piece == "O")
            this.btn.setText(piece);
        else
            throw new IllegalArgumentException("Wrong character input");
    }

    String getPiece(){
        return this.piece;
    }

    B
    void clearSquare(){
        this.piece = null;
    }
}