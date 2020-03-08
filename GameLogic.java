import java.util.Scanner;

public class GameLogic {
    public static Player[] setPlayers(Player[] players){
        String tempName;
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 2; i++){
            System.out.println("Player "+(i+1) + " please enter your name: ");
            tempName = in.nextLine();
            players[i].setName(tempName);
        }
        players[0].setPiece('X');
        players[1].setPiece('O');
        
        return players;
    }
    
    public static Player gameLoop(Board board, Player players[]){
        int i = 0;
        Scanner in = new Scanner(System.in);
        String tempPos;
        while(!board.checkWin()){
            System.out.println(players[i%2].getName() + "'s turn");
            tempPos = in.nextLine();
            System.out.println(tempPos.length());
            if(tempPos.length() == 3 && tempPos.charAt(1) == ','){
                try {
                    board.placePiece(players[i%2], tempPos.charAt(0)-'0', tempPos.charAt(2)-'0');
                } catch (IllegalArgumentException e) {
                    System.out.println("Position out of bounds");
                    i--;
                }
                board.printBoard();
                i++;
            }
            else{
                System.out.println("Invalid Position");
            }
        }
        return players[i%2];
    }

    

    
}