import java.io.*;
import java.net.*;


public class TicClient{
    public static void main(String[] args) throws IOException{
        String hostName = "Leo-Pred";
        int portNumber = 4444;

        try (
            Socket tSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(tSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(tSocket.getInputStream()));
        ) {
            BufferedReader stdIn = 
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            while ((fromServer = in.readLine()) != null){
                System.out.println(fromServer);

                fromUser = stdIn.readLine();
                if(fromUser != null){
                    out.println(fromUser);
                }
            }
            
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
}