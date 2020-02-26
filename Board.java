public class Board{
    Square squares[][];

    void resetBoard(){
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                squares[i][j].clearSquare();
            }
        }
    }
    Board(){
        squares = new Square[3][3];
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                squares[i][j] = new Square();
            }
        }
    }

    void printBoard(){
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(squares[i][j].drawSquare());
            }
            System.out.print("|\n");
        }

    }
    void placePiece(Player player, int r, int c){
        if(r <3 && r >=0 && c >=0 && c < 3 )
            squares[r][c].setPiece(player.getPiece());
        else
            throw new IllegalArgumentException("Position out of bounds");
    }

    boolean checkWin(){
        for(int i = 0; i < 3; i++){
            if(squares[i][0].getPiece() == squares[i][1].getPiece() && squares[i][1].getPiece() == squares[i][2].getPiece() && squares[i][0].getPiece() != ' '){
                System.out.println(i);
                return true;
            }
            if(squares[0][i].getPiece() == squares[1][i].getPiece() && squares[0][i].getPiece() == squares[2][i].getPiece() && squares[0][i].getPiece() != ' '){
                return true;
            }
        }
        if(squares[0][0].getPiece() == squares[1][1].getPiece() && squares[1][1].getPiece() == squares[2][2].getPiece() && squares[0][0].getPiece() != ' '){
            return true;
        }
        if(squares[2][0].getPiece() == squares[1][1].getPiece() && squares[1][1].getPiece() == squares[0][2].getPiece() && squares[0][2].getPiece() != ' '){
            return true;
        }
        return false;
        
    }

}