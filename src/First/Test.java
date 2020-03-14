/*TODO Piece placed when not players turn carries over to their next turn
 */


package First;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test extends Application {
    Stage window;
    Scene game, end, start;
    Board board = new Board();
    Player player = new Player();
    Socket tSocket;
    PrintWriter out;
    BufferedReader in;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        Scenes menus = new Scenes();

        window = primaryStage;
        //Start scene
        menus.getHostButton().setOnAction(e -> {
            runServer();
            try {
                InetAddress inetAddress = InetAddress.getLocalHost();
                menus.getHostButton().setText("Host Name: " + inetAddress.getHostName());
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
            }

        });
        menus.getCloseButton().setOnAction(e -> window.close());
        menus.getStartButton().setOnAction(actionEvent -> {
            window.setScene(game);
            board.resetBoard();
            getFromServer(menus);
        });


        start = new Scene(menus.getStartPane(), 300, 300);
        // Game scene l
        game = new Scene(board.printBoard(), 300, 300);

        menus.getEndButton().setOnAction(e -> window.setScene(start));
        menus.getEndCloseButton().setOnAction(e -> window.close());
        end = new Scene(menus.getEndPane(), 300, 300);


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalJ = j;
                int finalI = i;
                board.squares[i][j].setOnAction(event -> out.println(finalI + "" + finalJ));
            }
        }

        window.setScene(start);
        window.setTitle("Tic-Tac-Toe");
        window.show();


    }

    private void runServer() {
        Runnable task = this::server;
        Thread serverThread = new Thread(task);
        serverThread.setDaemon(true);
        serverThread.start();
    }

    private void getFromServer(Scenes menus) {
        Runnable task = () -> {
            try {
                serverInput(menus);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        Thread backgroundThread = new Thread(task);

        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }

    private void serverInput(Scenes menus) throws IOException {
        String hostName = "Leo-Pred";
        int portNumber = 4444;
        tSocket = new Socket(hostName, portNumber);
        out = new PrintWriter(tSocket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(tSocket.getInputStream()));
        player.setPiece(in.readLine());
        String input;
        while(!board.checkWin()) {
            try {
                input = in.readLine();
                if(input != null) {
                    String finalInput = input;
                    Platform.runLater(() -> {
                        try {
                            board.squares[finalInput.charAt(0) - 48][finalInput.charAt(1) - 48].setPiece(finalInput.substring(2, 3));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            menus.getEndLabel().setText(finalInput);
                            menus.getHostButton().setText("Host");
                            window.setScene(end);
                        }
                    });

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void server() {
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
            System.out.println("Server Open");
            ticProtocol.setPlayers(ticProtocol.players[0], in1, out1);
            ticProtocol.setPlayers(ticProtocol.players[1], in2, out2);
            String inputLine;


            while(ticProtocol.gameRunning() && !(inputLine = ticProtocol.players[i % 2].getIn().readLine()).equals("exit")) {
                if(!inputLine.equals("null")) {

                    if(ticProtocol.board[inputLine.charAt(0) - 48][inputLine.charAt(1) - 48].equals("")) {

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
        System.out.println("Server Closed");
    }

}