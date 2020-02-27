package First;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {
    Stage window;
    Scene game, winner, start;
    @Override
    public void start(Stage primaryStage) {
        GameLogic gameLogic = new GameLogic();
        Board board = new Board();
        Player players[] = GameLogic.setPlayers();

        window = primaryStage;
        //Start scene
        Label startLabel = new Label("Welcome to the game");

        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> window.setScene(game));
        Button closeButton = new Button("Quit");
        closeButton.setOnAction(e -> window.close());

        //GridPane
        GridPane gridPane1 = new GridPane();
        gridPane1.setMinWidth(30);
        gridPane1.setHgap(17);
        gridPane1.add(closeButton, 6,10,1,1);
        gridPane1.add(startButton,5,10,1,1);

        StackPane startPane = new StackPane();
        startPane.getChildren().addAll(gridPane1, startLabel);

        start = new Scene(startPane, 300, 300);
        // Game scenel
        game = new Scene(board.printBoard(), 300,300);

        //winner Scene
        Label label = new Label("It's a tie");
        StackPane layout = new StackPane();
        layout.getChildren().add(label);
        winner = new Scene(layout, 300, 300);

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                int finalJ = j;
                int finalI = i;
                board.squares[i][j].setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        try{
                            board.squares[finalI][finalJ].setPiece(players[GameLogic.getTurn()].getPiece());
                        }
                        catch (IllegalArgumentException e){
                            System.out.println(e);
                        }


                        if(board.checkWin()){
                            GameLogic.changeTurn();
                            label.setText("The winner is " + players[GameLogic.getTurn()].getName());
                            window.setScene(winner);
                        }
                    }
                });
            }
        }

        window.setScene(start);
        window.setTitle("Tic-Tac-Toe");
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}