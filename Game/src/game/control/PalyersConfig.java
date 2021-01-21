package game.control;

import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import java.lang.*;
import javafx.scene.layout.*;

public class PalyersConfig extends AnchorPane {

    protected final ImageView background;
    protected final GaussianBlur gaussianBlur;
    public final ImageView back;
    protected final DropShadow dropShadow;
    protected final ImageView imageView;
    protected final Label player1label;
    protected final Label palyer2label;
    public final TextField player1text;
    public final TextField player2text;
    public final RadioButton palyer1x;
    protected final ToggleGroup palyer1;
    public final RadioButton palyer1o;
    public final RadioButton palyer2o;
    protected final ToggleGroup palyer2;
    public final RadioButton palyer2x;
    public final ImageView start;
    protected final DropShadow dropShadow0;

    public PalyersConfig() {

        background = new ImageView();
        gaussianBlur = new GaussianBlur();
        back = new ImageView();
        dropShadow = new DropShadow();
        imageView = new ImageView();
        player1label = new Label();
        palyer2label = new Label();
        player1text = new TextField();
        player2text = new TextField();
        palyer1x = new RadioButton();
        palyer1 = new ToggleGroup();
        palyer1o = new RadioButton();
        palyer2o = new RadioButton();
        palyer2 = new ToggleGroup();
        palyer2x = new RadioButton();
        start = new ImageView();
        dropShadow0 = new DropShadow();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);

        background.setFitHeight(509.0);
        background.setFitWidth(724.0);
        background.setLayoutX(-13.0);
        background.setPickOnBounds(true);
        background.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backgroundxo.PNG").toExternalForm()));

        gaussianBlur.setRadius(13.06);
        background.setEffect(gaussianBlur);

        back.setFitHeight(97.0);
        back.setFitWidth(59.0);
        back.setLayoutX(30.0);
        back.setLayoutY(407.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backarrow2.png").toExternalForm()));

        dropShadow.setHeight(104.96);
        dropShadow.setRadius(54.3125);
        dropShadow.setSpread(0.4);
        dropShadow.setWidth(114.29);
        back.setEffect(dropShadow);

        imageView.setFitHeight(110.0);
        imageView.setFitWidth(101.0);
        imageView.setLayoutX(300.0);
        imageView.setLayoutY(49.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getClassLoader().getResource("game/pic/vs.png").toExternalForm()));

        player1label.setLayoutX(30.0);
        player1label.setLayoutY(40.0);
        player1label.setPrefHeight(47.0);
        player1label.setPrefWidth(137.0);
        player1label.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        player1label.setText("Player 1");
        player1label.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        player1label.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        palyer2label.setLayoutX(528.0);
        palyer2label.setLayoutY(40.0);
        palyer2label.setPrefHeight(47.0);
        palyer2label.setPrefWidth(137.0);
        palyer2label.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        palyer2label.setText("Player 2");
        palyer2label.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        palyer2label.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        player1text.setLayoutX(14.0);
        player1text.setLayoutY(119.0);
        player1text.setPrefHeight(47.0);
        player1text.setPrefWidth(200.0);
        player1text.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 5000;");
        player1text.setText("player1");
        player1text.setFont(new Font("Baskerville Old Face", 20.0));

        player2text.setLayoutX(465.0);
        player2text.setLayoutY(119.0);
        player2text.setPrefHeight(47.0);
        player2text.setPrefWidth(200.0);
        player2text.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 5000;");
        player2text.setText("player2");
        player2text.setFont(new Font("Baskerville Old Face", 20.0));

        palyer1x.setLayoutX(80.0);
        palyer1x.setLayoutY(198.0);
        palyer1x.setMnemonicParsing(false);
        palyer1x.setStyle("-fx-background-radius: 2000;");
        palyer1x.setText("X");
        palyer1x.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        palyer1x.setTextFill(javafx.scene.paint.Color.valueOf("#ff4c4c"));

        palyer1x.setToggleGroup(palyer1);

        palyer1o.setLayoutX(79.0);
        palyer1o.setLayoutY(235.0);
        palyer1o.setMnemonicParsing(false);
        palyer1o.setStyle("-fx-background-radius: 2000;");
        palyer1o.setText("O");
        palyer1o.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        palyer1o.setTextFill(javafx.scene.paint.Color.valueOf("#ff4c4c"));
        palyer1o.setToggleGroup(palyer1);

        palyer2o.setLayoutX(534.0);
        palyer2o.setLayoutY(243.0);
        palyer2o.setMnemonicParsing(false);
        palyer2o.setStyle("-fx-background-radius: 2000;");
        palyer2o.setText("O");
        palyer2o.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        palyer2o.setTextFill(javafx.scene.paint.Color.valueOf("#ff4c4c"));

        palyer2o.setToggleGroup(palyer2);

        palyer2x.setLayoutX(535.0);
        palyer2x.setLayoutY(206.0);
        palyer2x.setMnemonicParsing(false);
        palyer2x.setStyle("-fx-background-radius: 2000;");
        palyer2x.setText("X");
        palyer2x.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        palyer2x.setTextFill(javafx.scene.paint.Color.valueOf("#ff4c4c"));
        palyer2x.setToggleGroup(palyer2);

        start.setFitHeight(128.0);
        start.setFitWidth(163.0);
        start.setLayoutX(393.0);
        start.setLayoutY(338.0);
        start.setPickOnBounds(true);
        start.setPreserveRatio(true);
        start.setImage(new Image(getClass().getClassLoader().getResource("game/pic/start.png").toExternalForm()));

        dropShadow0.setHeight(62.2);
        dropShadow0.setRadius(26.7125);
        dropShadow0.setSpread(0.1);
        dropShadow0.setWidth(46.65);
        start.setEffect(dropShadow0);

        getChildren().add(background);
        getChildren().add(back);
        getChildren().add(imageView);
        getChildren().add(player1label);
        getChildren().add(palyer2label);
        getChildren().add(player1text);
        getChildren().add(player2text);
        getChildren().add(palyer1x);
        getChildren().add(palyer1o);
        getChildren().add(palyer2o);
        getChildren().add(palyer2x);
        getChildren().add(start);

    }
}
