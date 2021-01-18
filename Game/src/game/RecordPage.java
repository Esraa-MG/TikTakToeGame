package game;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class RecordPage extends Pane {

    protected final Button button;
    protected final Button button0;
    protected final Button button1;

    public RecordPage() {

        button = new Button();
        button0 = new Button();
        button1 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        button.setLayoutY(340.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(49.0);
        button.setPrefWidth(111.0);
        button.setText("Back");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#24377f"));
        button.setFont(new Font(22.0));

        button0.setLayoutX(462.0);
        button0.setLayoutY(343.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(25.0);
        button0.setPrefWidth(59.0);
        button0.setText(">");
        button0.setTextFill(javafx.scene.paint.Color.valueOf("#23397f"));
        button0.setFont(new Font(19.0));

        button1.setLayoutX(527.0);
        button1.setLayoutY(343.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(25.0);
        button1.setPrefWidth(59.0);
        button1.setText("<");
        button1.setTextFill(javafx.scene.paint.Color.valueOf("#1f3682"));
        button1.setFont(new Font(19.0));

        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);

    }
}
