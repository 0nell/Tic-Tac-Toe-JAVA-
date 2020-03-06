import java.io.*;
import java.net.*;


public class TicClient{
    public static void main(String[] args) throws IOException{
        String hostName = "10.10.2.223";
        int portNumber = 4444;

        try (
            Socket tSocket = new Socket(InetAddress.getByName(hostName), portNumber);
            PrintWriter out = new PrintWriter(tSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(tSocket.getInputStream()));
        ) {
            BufferedReader stdIn = 
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            
            
            while ((fromServer = in.readLine()) != null){
                if(!fromServer.equals("input"))
                    System.out.println(fromServer);
                
                else{
                    fromUser = stdIn.readLine();
                    if(fromUser != null){
                        out.println(fromUser);
                    }
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