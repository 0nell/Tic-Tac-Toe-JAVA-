package First;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TicServer {
    public static void main(String[] args) {
        int portNumber = 4444;
        int i = 0;
        TicProtocol ticProtocol = new TicProtocol();


        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket1 = serverSocket.accept();
                PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
                BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
                Socket clientSocket2 = serverSocket.accept();
                PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);
                BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()))
        ) {

            ticProtocol.setPlayers(ticProtocol.players[0], in1, out1);
            ticProtocol.setPlayers(ticProtocol.players[1], in2, out2);
            String inputLine;


            while(!ticProtocol.checkGameEnd() && !(inputLine = ticProtocol.players[i % 2].getIn().readLine()).equals("exit")) {
                if(!inputLine.equals("null")) {
                    System.out.print(1);
                    if(ticProtocol.board[inputLine.charAt(0) - 48][inputLine.charAt(1) - 48].equals("")) {
                        System.out.print(2);
                        ticProtocol.board[inputLine.charAt(0) - 48][inputLine.charAt(1) - 48]
                                = ticProtocol.players[i % 2].getPiece();
                        ticProtocol.players[0].getOut().println(inputLine + ticProtocol.players[i % 2].getPiece());
                        ticProtocol.players[1].getOut().println(inputLine + ticProtocol.players[i % 2].getPiece());
                        i++;
                    }

                }
            }
            ticProtocol.players[0].getOut().println(ticProtocol.winner);
            ticProtocol.players[1].getOut().println(ticProtocol.winner);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}