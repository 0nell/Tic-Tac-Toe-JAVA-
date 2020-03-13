package First;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class TicProtocol {
    static int count = 0;
    String[][] board;
    String winner;
    Player[] players;

    TicProtocol() {
        board = new String[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
        players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();
    }

    public boolean checkGameEnd() {

        System.out.println(winner);
        return checkDraw() || checkWin();
    }

    boolean checkWin() {
        for(int i = 0; i < 3; i++) {
            if(board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals("")) {
                winner = board[i][0] + " Wins!!!";
                return true;
            }
            if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals("")) {
                winner = board[0][i] + " Wins!!!";
                return true;
            }
        }
        if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("")) {
            winner = board[0][0] + " Wins!!!";
            return true;
        }
        if(board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2]) && !board[0][2].equals("")) {
            winner = board[2][0] + " Wins!!!";
            return true;
        }
        return false;
    }

    boolean checkDraw() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j].isEmpty() || checkWin())
                    return false;
            }
        }
        winner = "It is a tie";
        return true;
    }

    public void setPlayers(Player player, BufferedReader in1, PrintWriter out1) {
        if(count == 0) {
            player.setPiece("X");
            count++;
        } else {
            player.setPiece("O");
        }

        player.setIn(in1);
        player.setOut(out1);
        out1.println(player.getPiece());
    }
}