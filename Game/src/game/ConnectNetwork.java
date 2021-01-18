package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ConnectNetwork extends AnchorPane {

    protected final Label label;
    protected final TextField textField;
    protected final Button button;
    protected final Button button0;
    protected final Label label0;
    protected final TextField textField0;
    protected final Button button1;
    protected final Label label1;
    protected final Button enterButton;

    public ConnectNetwork() {

        label = new Label();
        textField = new TextField();
        button = new Button();
        button0 = new Button();
        label0 = new Label();
        textField0 = new TextField();
        button1 = new Button();
        label1 = new Label();
        enterButton = new Button();
        enterButton.setDisable(true);

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(15.0);
        label.setLayoutY(38.0);
        label.setPrefHeight(21.0);
        label.setPrefWidth(172.0);
        label.setText("Name of player");
        label.setTextFill(javafx.scene.paint.Color.WHITE);

        textField.setLayoutX(8.0);
        textField.setLayoutY(68.0);
        textField.setPrefHeight(38.0);
        textField.setPrefWidth(247.0);

        button.setLayoutX(51.0);
        button.setLayoutY(280.0);
        button.setMnemonicParsing(false);
        button.setText("Back");

        button0.setLayoutX(351.0);
        button0.setLayoutY(156.0);
        button0.setMnemonicParsing(false);
        button0.setText("Host Game");

        label0.setLayoutX(351.0);
        label0.setLayoutY(106.0);
        label0.setPrefHeight(31.0);
        label0.setPrefWidth(228.0);

        textField0.setLayoutX(348.0);
        textField0.setLayoutY(265.0);

        button1.setLayoutX(441.0);
        button1.setLayoutY(325.0);
        button1.setMnemonicParsing(false);
        button1.setText("Join");

        label1.setLayoutX(351.0);
        label1.setLayoutY(218.0);
        label1.setPrefHeight(31.0);
        label1.setPrefWidth(172.0);
        label1.setText("Enter IP Address");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);

        enterButton.setLayoutX(172.0);
        enterButton.setLayoutY(325.0);
        enterButton.setMnemonicParsing(false);
        enterButton.setPrefHeight(38.0);
        enterButton.setPrefWidth(132.0);
        enterButton.setText("enter game");

        getChildren().add(label);
        getChildren().add(textField);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(label0);
        getChildren().add(textField0);
        getChildren().add(button1);
        getChildren().add(label1);
        getChildren().add(enterButton);
        setStyle("-fx-background-color: #333333;");

    }
}
