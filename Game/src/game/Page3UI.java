package game;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Page3UI extends Pane {

    protected final Label label;
    protected final Button Back;
    protected final Button Start;
    protected final Label label0;
    protected final TextField player1;
    protected final TextField player2;
    protected final RadioButton player2o;
    protected final RadioButton player2x;
    protected final RadioButton player1o;
    protected final RadioButton player1x;

    public Page3UI() {

        label = new Label();
        Back = new Button();
        Start = new Button();
        label0 = new Label();
        player1 = new TextField();
        player2 = new TextField();
        player2o = new RadioButton();
        player2x = new RadioButton();
        player1o = new RadioButton();
        player1x = new RadioButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(9.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(67.0);
        label.setPrefWidth(245.0);
        label.setText("Name Of Player 1 ");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(23.0));

        Back.setLayoutX(91.0);
        Back.setLayoutY(296.0);
        Back.setMnemonicParsing(false);
        Back.setPrefHeight(67.0);
        Back.setPrefWidth(82.0);
        Back.setText("Back");
        Back.setTextFill(javafx.scene.paint.Color.valueOf("#1e367f"));
        Back.setFont(new Font(21.0));

        Start.setLayoutX(350.0);
        Start.setLayoutY(296.0);
        Start.setMnemonicParsing(false);
        Start.setPrefHeight(67.0);
        Start.setPrefWidth(82.0);
        Start.setText("Start");
        Start.setTextFill(javafx.scene.paint.Color.valueOf("#1e367f"));
        Start.setFont(new Font(21.0));

        label0.setLayoutX(347.0);
        label0.setLayoutY(115.0);
        label0.setPrefHeight(67.0);
        label0.setPrefWidth(238.0);
        label0.setText("Name Of Player 2");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font(23.0));

        player1.setAlignment(javafx.geometry.Pos.CENTER);
        player1.setLayoutY(81.0);
        player1.setPrefHeight(54.0);
        player1.setText("Player1");
        player1.setPrefWidth(245.0);
        player1.setFont(new Font("System Bold", 26.0));

        player2.setAlignment(javafx.geometry.Pos.CENTER);
        player2.setLayoutX(337.0);
        player2.setLayoutY(182.0);
        player2.setText("Player2");
        player2.setPrefHeight(54.0);
        player2.setPrefWidth(257.0);
        player2.setFont(new Font("System Bold", 25.0));
        
        ToggleGroup palyer1symbol= new ToggleGroup();
        player2o.setToggleGroup(palyer1symbol);
        player2x.setToggleGroup(palyer1symbol);
        ToggleGroup palyer2symbol= new ToggleGroup();
        player1o.setToggleGroup(palyer2symbol);
        player1x.setToggleGroup(palyer2symbol);
     

        player2o.setLayoutX(476.0);
        player2o.setLayoutY(275.0);
        player2o.setMnemonicParsing(false);
        player2o.setText("  O");
        player2o.setTextFill(javafx.scene.paint.Color.WHITE);

        player2x.setLayoutX(476.0);
        player2x.setLayoutY(245.0);
        player2x.setMnemonicParsing(false);
        player2x.setText("  X");
        player2x.setTextFill(javafx.scene.paint.Color.WHITE);

        player1o.setLayoutX(22.0);
        player1o.setLayoutY(172.0);
        player1o.setMnemonicParsing(false);
        player1o.setText("  O");
        player1o.setTextFill(javafx.scene.paint.Color.WHITE);

        player1x.setLayoutX(22.0);
        player1x.setLayoutY(138.0);
        player1x.setMnemonicParsing(false);
        player1x.setText("  X");
        player1x.setTextFill(javafx.scene.paint.Color.WHITE);

        getChildren().add(label);
        getChildren().add(Back);
        getChildren().add(Start);
        getChildren().add(label0);
        getChildren().add(player1);
        getChildren().add(player2);
        getChildren().add(player2o);
        getChildren().add(player2x);
        getChildren().add(player1o);
        getChildren().add(player1x);
        
        
        setStyle("-fx-background-color: #333333;");

    }
}
