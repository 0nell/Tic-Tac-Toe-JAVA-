package First;

import javafx.geometry.Pos;
import javafx.scene.layout.TilePane;

import java.util.Objects;

public class Board {
    Square[][] squares;
    String winner;

    Board() {
        squares = new Square[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                squares[i][j] = new Square();
            }
        }

    }

    void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares[i][j].clearSquare();
            }
        }
        GameLogic.setTurn("X");
    }

    TilePane printBoard() {
        TilePane tilePane = new TilePane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tilePane.getChildren().add(squares[i][j]);
                tilePane.setTileAlignment(Pos.TOP_LEFT);
            }
        }

        return tilePane;
    }

    boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(squares[i][0].getPiece(), squares[i][1].getPiece()) && Objects.equals(squares[i][1].getPiece(), squares[i][2].getPiece()) && squares[i][0].getPiece() != null) {
                System.out.println(i);
                return true;
            }
            if (Objects.equals(squares[0][i].getPiece(), squares[1][i].getPiece()) && Objects.equals(squares[0][i].getPiece(), squares[2][i].getPiece()) && squares[0][i].getPiece() != null) {
                return true;
            }
        }
        if (Objects.equals(squares[0][0].getPiece(), squares[1][1].getPiece()) && Objects.equals(squares[1][1].getPiece(), squares[2][2].getPiece()) && squares[0][0].getPiece() != null) {
            return true;
        }
        return Objects.equals(squares[2][0].getPiece(), squares[1][1].getPiece()) && Objects.equals(squares[1][1].getPiece(), squares[0][2].getPiece()) && squares[0][2].getPiece() != null;

    }

    boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (squares[i][j].isEmpty() || checkWin())
                    return false;
            }
        }
        return true;
    }

}