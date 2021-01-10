package game;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class SecondPage extends Pane {

    protected final Pane pane;
    protected final Button button;
    protected final Button Back;
    protected final Button button1;

    public SecondPage() {

        pane = new Pane();
        button = new Button();
        Back = new Button();
        button1 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        pane.setLayoutX(14.0);
        pane.setLayoutY(88.0);
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);

        button.setLayoutX(169.0);
        button.setLayoutY(148.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(80.0);
        button.setPrefWidth(275.0);
        button.setText("Easy");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#1f3682"));
        button.setFont(new Font(36.0));

        Back.setLayoutX(169.0);
        Back.setLayoutY(277.0);
        Back.setMnemonicParsing(false);
        Back.setPrefHeight(80.0);
        Back.setPrefWidth(275.0);
        Back.setText("Back");
        Back.setTextFill(javafx.scene.paint.Color.valueOf("#1f3682"));
        Back.setFont(new Font(36.0));

        button1.setLayoutX(169.0);
        button1.setLayoutY(26.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(80.0);
        button1.setPrefWidth(275.0);
        button1.setText("Hard");
        button1.setTextFill(javafx.scene.paint.Color.valueOf("#1f3682"));
        button1.setFont(new Font(37.0));

        getChildren().add(pane);
        getChildren().add(button);
        getChildren().add(Back);
        getChildren().add(button1);
        
        
        setStyle("-fx-background-color: #333333;");

    }
}
