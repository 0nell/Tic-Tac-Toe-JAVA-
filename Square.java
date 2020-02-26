public class Square{
    char piece;

    Square(){
        piece = ' ';
    }
    void setPiece(char piece) {
        piece = Character.toUpperCase(piece);
        if(piece == 'X' || piece == 'O' || piece == ' ')
            this.piece = piece;
        else
            throw new IllegalArgumentException("Wrong character input");
    }

    char getPiece(){
        return this.piece;
    }
    String drawSquare(){
        return "|" + this.piece;
    }

    void clearSquare(){
        this.setPiece(' ');
    }
}