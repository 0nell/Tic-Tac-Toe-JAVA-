import java.net.*;
import java.io.*;

public class TicServer {

    public static void main(String[] args) throws IOException{
        int portNumber = 4444;
        Player players[] = new Player[2];
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
            outputLine = ticProtocol.nameInstruction();
            out1.println(outputLine);
            out2.println(outputLine);
                      
            inputLine = in1.readLine();
            ticProtocol.setName(players[0], inputLine);
            out1.println(players[0].getName() + ": " + players[0].getPiece());
            
            inputLine = in2.readLine();
            ticProtocol.setName(players[1], inputLine);
            out2.println(players[1].getName() + ": " + players[1].getPiece());

            

        } catch (Exception e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}