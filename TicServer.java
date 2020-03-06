import java.net.*;
import java.io.*;

public class TicServer {

    public static void main(String[] args) throws IOException{
        int portNumber = 4444;
        Player players[] = new Player[2];
        int winner = 0;
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
            String inputLine, outputLine;
            TicProtocol ticProtocol = new TicProtocol();
           
            //Set Players
            ticProtocol.setPlayer(players[0]);
            ticProtocol.setPlayer(players[1]);
            out1.println("You're " + players[0].getPiece());
            out2.println("You're " + players[1].getPiece());

            //Play game
            outputLine = ticProtocol.startInstruction();
            out1.println(outputLine);
            out2.println(outputLine);
            out1.println(board.toString());
            out2.println(board.toString());

            while(!board.checkWin()){
                

                out1.println("input");
                inputLine = in1.readLine();
                board = ticProtocol.oneTurn(players[0],inputLine, board);
                winner = 0;
                out1.println(board.toString());
                out2.println(board.toString());
                
                if(!board.checkWin()){
                    out2.println("input"); 
                    inputLine = in2.readLine();
                    board = ticProtocol.oneTurn(players[1],inputLine, board);
                    winner = 1;
                }
                out1.println(board.toString());
                out2.println(board.toString());
            }

            outputLine = ticProtocol.winInstruction(players[winner]);
            out1.println(outputLine);
            out2.println(outputLine);

            
            
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

}