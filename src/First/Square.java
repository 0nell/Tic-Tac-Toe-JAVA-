package First;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Square extends Button {
    String piece;
    Square(){
        piece = null;
        this.setPrefSize(100,100);
        this.setStyle("-fx-font-size: 30; ");
    }

    void setPiece(String piece) {
        piece.toUpperCase();
        if(piece == "X" || piece == "O" || piece == null){
            this.setText(piece);
            this.piece = piece;
        }
        else
            throw new IllegalArgumentException("Wrong character input");
        System.out.println(piece);
    }

    String getPiece(){
        return this.piece;
    }


    void clearSquare(){
        this.piece = null;
        this.setPiece(null);
    }
}