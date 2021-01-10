package game;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class StartUI extends Pane {

    protected final Button Single;
    protected final Button Two;
    protected final Button Online;
    protected final Button button2;

    public StartUI() {

        Single = new Button();
        Two = new Button();
        Online = new Button();
        button2 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        Single.setLayoutX(205.0);
        Single.setLayoutY(44.0);
        Single.setMnemonicParsing(false);
        Single.setPrefHeight(55.0);
        Single.setPrefWidth(203.0);
        Single.setText("Single");
        Single.setTextFill(javafx.scene.paint.Color.valueOf("#1f3682"));
        Single.setFont(new Font(22.0));

        Two.setLayoutX(205.0);
        Two.setLayoutY(131.0);
        Two.setMnemonicParsing(false);
        Two.setPrefHeight(55.0);
        Two.setPrefWidth(203.0);
        Two.setText("Two Players");
        Two.setTextFill(javafx.scene.paint.Color.valueOf("#1f3682"));
        Two.setFont(new Font(22.0));

        Online.setLayoutX(205.0);
        Online.setLayoutY(212.0);
        Online.setMnemonicParsing(false);
        Online.setPrefHeight(55.0);
        Online.setPrefWidth(203.0);
        Online.setText("Online");
        Online.setTextFill(javafx.scene.paint.Color.valueOf("#1f3682"));
        Online.setFont(new Font(23.0));

        button2.setLayoutX(205.0);
        button2.setLayoutY(292.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(55.0);
        button2.setPrefWidth(203.0);
        button2.setText("Archives");
        button2.setTextFill(javafx.scene.paint.Color.valueOf("#1f3682"));
        button2.setFont(new Font(27.0));

        getChildren().add(Single);
        getChildren().add(Two);
        getChildren().add(Online);
        getChildren().add(button2);
        
        
        setStyle("-fx-background-color: #333333;");

    }
}
