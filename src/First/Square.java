package First;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Square extends Button {
    String piece;

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    boolean empty;
    Square(){
        piece = null;
        this.setEmpty(true);
        this.setPrefSize(100,100);
        this.setStyle("-fx-font-size: 30; ");
    }

    void setPiece(String piece) {
        piece.toUpperCase();
        if(this.isEmpty()){
            this.setText(piece);
            this.piece = piece;
            GameLogic.changeTurn();
            this.setEmpty(false);
        }
        else
            throw new IllegalArgumentException("Square is full");

    }

    String getPiece(){
        return this.piece;
    }


    void clearSquare(){
        this.piece = null;
        this.setPiece(null);
        this.setEmpty(true);
    }
}