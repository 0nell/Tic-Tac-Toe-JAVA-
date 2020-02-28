package First;
//Cannot quit after starting game before inputting name, remove names (unnecessary)

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {
    Stage window;
    Scene game, end, start;

    @Override
    public void start(Stage primaryStage) {
        //GameLogic gameLogic = new GameLogic();
        Board board = new Board();
        final Player[][] players = new Player[1][2];
        Scenes menus = new Scenes();

        window = primaryStage;
        //Start scene

        menus.getCloseButton().setOnAction(e -> window.close());
        menus.getStartButton().setOnAction(actionEvent -> {
            window.setScene(game);
            board.resetBoard();
            players[0] = GameLogic.setPlayers();

        });


        start = new Scene(menus.getStartPane(), 300, 300);
        // Game scenel
        game = new Scene(board.printBoard(), 300, 300);

        menus.getEndButton().setOnAction(e -> window.setScene(start));
        menus.getEndCloseButton().setOnAction(e -> window.close());
        end = new Scene(menus.getEndPane(), 300, 300);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalJ = j;
                int finalI = i;
                board.squares[i][j].setOnAction(event -> {
                    try {
                        board.squares[finalI][finalJ].setPiece(players[0][GameLogic.getTurn()].getPiece());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e);
                    }


                    if (board.checkWin()) {
                        GameLogic.changeTurn();
                        menus.getEndLabel().setText("The winner is " + players[0][GameLogic.getTurn()].getName());
                        window.setScene(end);
                    }
                    if (board.checkDraw()) {
                        GameLogic.changeTurn();
                        menus.getEndLabel().setText("It is a Tie!");
                        board.resetBoard();
                        window.setScene(end);

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