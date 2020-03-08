import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TicProtocol {
    static int count = 0;

    public void setPlayer(Player player, BufferedReader in, PrintWriter out) {
        if (count == 0) {
            player.setPiece('X');
            count++;
        } else {
            player.setPiece('O');
        }
        player.setIn(in);
        player.setOut(out);
    }

    public String nameInstruction() {
        return "Please enter your name: ";
    }

    public String startInstruction() {
        return "Start Game\nPlease enter Co-ordinates in the for of x,y\n";
    }

    public Board oneTurn(Player player, String inputLine, Board board) {
        if (inputLine.length() == 3 && inputLine.charAt(1) == ',') {
            board.placePiece(player, inputLine.charAt(0) - '0', inputLine.charAt(2) - '0');    
        }
        else{
            throw new IllegalArgumentException("Not valid Input");
        }
        return board;
    }

    public String winInstruction(Board board) {
        if(board.checkDraw()){
            return "It's a Tie";
        }
        else{
            return board.winner + " won!";
        }
        
    }

    public Board serverLoop(Board board, Player players[]) {
        int i = 0;
        String inputLine = " ";
        players[0].getOut().println(board.toString());
        players[1].getOut().println(board.toString());

        while (!board.checkWin() && !board.checkDraw()) {

            players[i % 2].getOut().println("input");
            try {
                inputLine = players[i % 2].getIn().readLine();
            } catch (IOException e) {
                System.out.println("Exception caught when trying to listen on port ");
                System.out.println(e.getMessage());
            }
            try {
                board = oneTurn(players[i%2],inputLine, board);
                players[0].getOut().println(board.toString());
                players[1].getOut().println(board.toString());
                i++;
            } catch (IllegalArgumentException e) {
                players[i%2].getOut().println(e);
            } 

        }

        return board;        
    }


}