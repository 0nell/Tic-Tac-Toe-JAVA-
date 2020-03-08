import java.net.*;
import java.io.*;

public class TicServer {

    public static void main(String[] args) throws IOException{
        int portNumber = 4444;
        Player players[] = new Player[2];
        
        Board board = new Board();
        players[0] = new Player();
        players[1] = new Player();

        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket1 = serverSocket.accept();
            PrintWriter out1 =
                new PrintWriter(clientSocket1.getOutputStream(), true);
            BufferedReader in1 = new BufferedReader(
                new InputStreamReader(clientSocket1.getInputStream()));
            Socket clientSocket2 = serverSocket.accept();
            PrintWriter out2 =
                new PrintWriter(clientSocket2.getOutputStream(), true);
            BufferedReader in2 = new BufferedReader(
                new InputStreamReader(clientSocket2.getInputStream()));
        ){
            String  outputLine;
            TicProtocol ticProtocol = new TicProtocol();
           
            //Set Players
            ticProtocol.setPlayer(players[0], in1, out1);
            ticProtocol.setPlayer(players[1], in2, out2);

            players[0].getOut().println("You're " + players[0].getPiece());
            players[1].getOut().println("You're " + players[1].getPiece());

            //Play game
            outputLine = ticProtocol.startInstruction();
            players[0].getOut().println(outputLine);
            players[1].getOut().println(outputLine);

            board = ticProtocol.serverLoop(board, players);
            
            outputLine = ticProtocol.winInstruction(board);
            players[0].getOut().println(outputLine);
            players[1].getOut().println(outputLine);

            
            
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

}