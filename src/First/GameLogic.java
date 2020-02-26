package First;
import java.util.Scanner;

public class GameLogic {
    public static String turn = "O";
    public static Player[] setPlayers(){
        Player players[] = new Player[2];
        String tempName;
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 2; i++){
            System.out.println("Player "+(i+1) + " please enter your name: ");
            tempName = in.nextLine();
            players[i] = new Player(tempName);
        }
        players[0].setPiece("X");
        players[1].setPiece("O");
        
        return players;
    }

    public static String changeTurn() {
        if(turn == "X"){
            turn = "O";
        }
        else{
            turn = "X";
        }
        return turn;
    }

    public static Player gameLoop(Board board, Player players[]){
        int i = 0;
        Scanner in = new Scanner(System.in);
        String tempPos;
        while(!board.checkWin()){


            i++;
        }
        return players[i%2];
    }
}