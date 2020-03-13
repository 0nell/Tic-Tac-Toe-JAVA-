/*TODO Thread runs after game ends
    Can only play one game
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
import java.net.Socket;

public class Test extends Application {
    Stage window;
    Scene game, end, start;
    Board board = new Board();
    Player player = new Player();


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        String hostName = "10.10.2.223";
        int portNumber = 4444;
        Socket tSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(tSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(tSocket.getInputStream()));
        player.setPiece(in.readLine());

        Scenes menus = new Scenes();

        window = primaryStage;
        //Start scene

        menus.getCloseButton().setOnAction(e -> window.close());
        menus.getStartButton().setOnAction(actionEvent -> {
            window.setScene(game);
            board.resetBoard();
            getFromServer(menus, in);
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
        window.setTitle("Tic-Tac-Toe - " + player.getPiece());
        window.show();


    }

    private void getFromServer(Scenes menus, BufferedReader in) {
        Runnable task = () -> runTask(menus, in);

        Thread backgroundThread = new Thread(task);

        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }

    private void runTask(Scenes menus, BufferedReader in) {
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
                            window.setScene(end);
                        }
                    });

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}