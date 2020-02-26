package First;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                btn.setText("Hello World'");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}




/*import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Board board = new Board();
        Player players[] = GameLogic.setPlayers();
        Player winner;
        for(int i = 0; i < 2; i++){
            System.out.println(players[i].getName() + ": " + players[i].getPiece());
        }
        System.out.println("Start Game");
        System.out.println("\nPlease enter Co-ordinates in the for of x,y\n");
        winner = GameLogic.gameLoop(board, players);
        System.out.println(winner.getName() + " Won!");
        
    }
}*/