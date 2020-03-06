public class TicProtocol {
    static int count = 0;
    
    public void setPlayer(Player player){
        if(count == 0){
            player.setPiece('X');
            count++;
        }
        else{
            player.setPiece('O');
        }
    }

    public String nameInstruction(){
        return "Please enter your name: ";
    }

    public String startInstruction(){
        return "Start Game\nPlease enter Co-ordinates in the for of x,y\n";
    }


	public Board oneTurn(Player player, String inputLine, Board board) {
		if(inputLine.length() == 3 && inputLine.charAt(1) == ','){
            try {
                board.placePiece(player, inputLine.charAt(0)-'0', inputLine.charAt(2)-'0');
            } catch (IllegalArgumentException e) {
                System.out.println("Position out of bounds");
                return null;
            }
        }
        return board;
	}

	public String winInstruction(Player player) {
		return player.getPiece() + " won!!!";
	}


}