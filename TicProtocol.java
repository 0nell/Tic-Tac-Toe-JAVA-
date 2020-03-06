public class TicProtocol {
    static int count = 0;
    
    public void setName(Player player, String name){
        player.setName(name);
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

}