public class Test{
    static boolean testSquare(){
        boolean pass = true;
        Square square = new Square();
        square.setPiece('X');
        if(!(square.getPiece() == 'X')){
            System.out.println("setPiece fails");
            pass = false;
        }
        square.setPiece('o');
        if(!(square.getPiece() == 'O')){
            System.out.println("setPiece fails");
            pass = false;
        }
        boolean error = false;
        try {
            square.setPiece('l');
        } catch (IllegalArgumentException e) {
            error = true;
        }
        if(!error){    
            System.out.println("setPiece fails");
            pass = false;
        }
        System.out.println(square.drawSquare());
    
        return pass;
    }
    static boolean testBoard(){
        Player player = new Player("Lleno");
        player.setPiece('X');
        boolean pass = true;
        boolean error = false;
        Board board = new Board();

        try {
            board.placePiece(player, 0, 5);
        } catch (IllegalArgumentException e) {
            error = true;
        }
        if(!error){    
            System.out.println("placePiece fails");
            pass = false;
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board.placePiece(player, i, j);
            }
        }
        
        System.out.println("Expect all squares filled");
        board.printBoard();

        board.placePiece(player, 0, 0);
        board.placePiece(player, 0, 1);
        board.placePiece(player, 0, 2);
        if(!board.checkWin()){
            System.out.println("1 checkWin fails");
            board.printBoard();
            pass = false;
        }
        board.resetBoard();
        board.placePiece(player, 1, 0);
        board.placePiece(player, 1, 1);
        board.placePiece(player, 1, 2);

        if(!board.checkWin()){
            System.out.println("2 checkWin fails");
            board.printBoard();
            pass = false;
        }
        board.resetBoard();
        board.placePiece(player, 2, 0);
        board.placePiece(player, 2, 1);
        board.placePiece(player, 2, 2);

        if(!board.checkWin()){
            System.out.println("3 checkWin fails");
            board.printBoard();
            pass = false;
        }
        board.resetBoard();
        board.placePiece(player, 0, 0);
        board.placePiece(player, 1, 1);
        board.placePiece(player, 2, 2);
        if(!board.checkWin()){
            System.out.println("4 checkWin fails");
            board.printBoard();
            pass = false;
        }
        board.resetBoard();
        board.placePiece(player, 0, 2);
        board.placePiece(player, 1, 1);
        board.placePiece(player, 2, 0);
        if(!board.checkWin()){
            System.out.println("5 checkWin fails");
            board.printBoard();
            pass = false;
        }
        board.resetBoard();
        board.placePiece(player, 0, 0);
        board.placePiece(player, 1, 1);
        board.placePiece(player, 2, 2);
        if(!board.checkWin()){
            System.out.println("6 checkWin fails");
            board.printBoard();
            pass = false;
        }
        board.resetBoard();
        board.placePiece(player, 0, 0);
        board.placePiece(player, 1, 0);
        board.placePiece(player, 2, 0);
        if(!board.checkWin()){
            System.out.println("7 checkWin fails");
            board.printBoard();
            pass = false;
        }
        board.resetBoard();
        board.placePiece(player, 0, 1);
        board.placePiece(player, 1, 1);
        board.placePiece(player, 2, 1);
        if(!board.checkWin()){
            System.out.println("8 checkWin fails");
            board.printBoard();
            pass = false;
        }
        board.resetBoard();
        board.placePiece(player, 0, 2);
        board.placePiece(player, 1, 2);
        board.placePiece(player, 2, 2);
        if(!board.checkWin()){
            System.out.println("9 checkWin fails");
            board.printBoard();
            pass = false;
        }
        return pass;
    }
    static boolean testPlayer(){
        boolean pass = true;
        Player player = new Player("Anya");
        player.setPiece('X');
        if(!(player.getPiece() == 'X')){
            System.out.println("setPiece fails");
            pass = false;
        }
        player.setPiece('o');
        if(!(player.getPiece() == 'O')){
            System.out.println("setPiece fails");
            pass = false;
        }
        boolean error = false;
        try {
            player.setPiece(' ');
        } catch (IllegalArgumentException e) {
            error = true;
        }
        if(!error){    
            System.out.println("setPiece fails");
            pass = false;
        }
    
        return pass;
    }
    
    public static void main(String args[]){
        if(testSquare()){
            System.out.println("Square Passes");
        }
        else{
            System.out.println("Square fails");
        }
        if(testBoard()){
            System.out.println("Board Passes");
        }
        else{
            System.out.println("Board fails");
        }
        if(testPlayer()){
            System.out.println("Player Passes");
        }
        else{
            System.out.println("Player fails");
        }
    }
}