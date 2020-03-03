package First;

public class GameLogic {
    public static String turn = "X";


    public static void changeTurn() {
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }

    }

    public static String getTurn() {
        return turn;
    }

    public static void setTurn(String turn) {
        GameLogic.turn = turn;
    }

}