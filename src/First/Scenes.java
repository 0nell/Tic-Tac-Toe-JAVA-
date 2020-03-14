package First;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Scenes {

    private Label endLabel;
    private StackPane endPane;
    private Button endCloseButton;
    private Button endButton;
    private Button startButton;
    private Button closeButton;
    private Button hostButton;
    private StackPane startPane;

    public Scenes() {
        Label startLabel = new Label("Welcome to the game");

        startButton = new Button("Start Game");
        closeButton = new Button("Quit");
        hostButton = new Button("Host Game");
        //GridPane
        GridPane gridPane1 = new GridPane();
        gridPane1.setMinWidth(30);
        gridPane1.setHgap(17);
        gridPane1.setPrefWidth(20);
        gridPane1.add(startButton, 5, 10, 1, 1);
        gridPane1.add(closeButton, 6, 10, 1, 1);
        gridPane1.add(hostButton, 5, 11, 1, 1);


        startPane = new StackPane();
        startPane.getChildren().addAll(gridPane1, startLabel);

        //end Scene
        endLabel = new Label();
        endButton = new Button("Main menu");
        endCloseButton = new Button("Quit");

        //GridPane
        GridPane gridPane2 = new GridPane();
        gridPane2.setMinWidth(30);
        gridPane2.setHgap(17);
        gridPane2.add(endButton, 5, 10, 1, 1);
        gridPane2.add(endCloseButton, 6, 10, 1, 1);


        endPane = new StackPane();
        endPane.getChildren().addAll(gridPane2, endLabel);
    }

    public Label getEndLabel() {
        return endLabel;
    }

    public StackPane getEndPane() {
        return endPane;
    }

    public Button getEndCloseButton() {
        return endCloseButton;
    }

    public Button getEndButton() {
        return endButton;
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public Button getHostButton() {
        return hostButton;
    }

    public StackPane getStartPane() {
        return startPane;
    }


}
