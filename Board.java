public class Board {
    Square squares[][];
    char winner;

    void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares[i][j].clearSquare();
            }
        }
    }

    Board() {
        squares = new Square[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares[i][j] = new Square();
            }
        }
    }

    void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(squares[i][j].drawSquare());
            }
            System.out.print("|\n");
        }

    }

    void placePiece(Player player, int r, int c) {
        if (r < 3 && r >= 0 && c >= 0 && c < 3){
            if(squares[r][c].getPiece() == ' ')
                squares[r][c].setPiece(player.getPiece());
            else
                throw new IllegalArgumentException("Square is taken");
        }
 
        else
            throw new IllegalArgumentException("Position out of bounds");
    }

    boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (squares[i][0].getPiece() == squares[i][1].getPiece()
                    && squares[i][1].getPiece() == squares[i][2].getPiece() && squares[i][0].getPiece() != ' ') {
                winner = squares[i][0].getPiece();
                return true;
            }
            if (squares[0][i].getPiece() == squares[1][i].getPiece()
                    && squares[0][i].getPiece() == squares[2][i].getPiece() && squares[0][i].getPiece() != ' ') {
                        winner = squares[0][i].getPiece();
                        return true;
            }
        }
        if (squares[0][0].getPiece() == squares[1][1].getPiece() && squares[1][1].getPiece() == squares[2][2].getPiece()
                && squares[0][0].getPiece() != ' ') {
                    winner = squares[0][0].getPiece();
                    return true;
        }
        if (squares[2][0].getPiece() == squares[1][1].getPiece() && squares[1][1].getPiece() == squares[0][2].getPiece()
                && squares[0][2].getPiece() != ' ') {
                    winner = squares[2][0].getPiece();
                    return true;
        }
        return false;

    }

    @Override
    public String toString() {
        return squares[0][0].drawSquare() + squares[0][1].drawSquare() + squares[0][2].drawSquare() + "|\n"
            +  squares[1][0].drawSquare() + squares[1][1].drawSquare() + squares[1][2].drawSquare() + "|\n"
            +  squares[2][0].drawSquare() + squares[2][1].drawSquare() + squares[2][2].drawSquare() + "|\n";

    }

	public char getWinner() {
		return winner;
    }
    
    boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (squares[i][j].getPiece() == ' ' || checkWin())
                    return false;
            }
        }
        return true;
    }

}