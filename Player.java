import java.io.*;
import java.net.*;

public class Player{
    char piece;
    String name;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public char getPiece() {
        return piece;
    }
    public void setPiece(char piece) {
        piece = Character.toUpperCase(piece);
        if(piece == 'X' || piece == 'O')
            this.piece = piece;
        else
            throw new IllegalArgumentException("Wrong character input");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    void setConnection(ServerSocket serverSocket){
        try {
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port or listening for a connection");
            System.out.println(e.getMessage());
        }    
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public PrintWriter getOut() {
        return out;
    }

    public BufferedReader getIn() {
        return in;
    }



}