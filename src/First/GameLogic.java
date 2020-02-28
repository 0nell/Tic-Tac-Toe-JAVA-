package First;

import java.util.Scanner;

public class GameLogic {
    public static int turn = 0;

    public static Player[] setPlayers(){
        Player[] players = new Player[2];
        String tempName;
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println("Player " + (i + 1) + " please enter your name: ");
            tempName = in.nextLine();
            players[i] = new Player(tempName);
        }
        players[0].setPiece("X");
        players[1].setPiece("O");
        for (int i = 0; i < 2; i++) {
            System.out.println(players[i].getName() + ": " + players[i].getPiece());
        }
        return players;
    }

    public static void changeTurn() {
        if (turn == 0) {
            turn = 1;
        } else {
            turn = 0;
        }

    }

    public static int getTurn() {
        return turn;
    }

    public static void setTurn(int turn) {
        GameLogic.turn = turn;
    }

}