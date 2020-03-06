
public class Main {
    public static void main(String args[]) {
        Board board = new Board();
        Player players[] = new Player[2];
        players = GameLogic.setPlayers(players);
        Player winner;
        for(int i = 0; i < 2; i++){
            System.out.println(players[i].getName() + ": " + players[i].getPiece());
        }
        System.out.println("Start Game");
        System.out.println("\nPlease enter Co-ordinates in the for of x,y\n");
        winner = GameLogic.gameLoop(board, players);
        System.out.println(winner.getName() + " Won!");
        
    }
}