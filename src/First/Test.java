package First;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        Board board = new Board();
        /*Player players[] = GameLogic.setPlayers();
        Player winner;
        for(int i = 0; i < 2; i++){
            System.out.println(players[i].getName() + ": " + players[i].getPiece());
        }
        System.out.println("Start Game");
        System.out.println("\nPlease enter Co-ordinates in the for of x,y\n");
        int i = 0;
        while(!board.checkWin()){


            i++;
        }*/


        StackPane root = new StackPane();
        root.getChildren().add(board.printBoard());

        Scene scene = new Scene(root, 300, 300);

        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}