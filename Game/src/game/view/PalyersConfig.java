package game.view;

import javafx.scene.*;
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
    public final ImageView start;
    protected final DropShadow dropShadow0;
    public final RadioButton palyer1o;
    public final RadioButton palyer2x;
    protected final ToggleGroup palyer2;
    public final RadioButton palyer2o;
    protected final ToggleGroup palyer21;

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
        start = new ImageView();
        dropShadow0 = new DropShadow();
        palyer1o = new RadioButton();
        palyer2x = new RadioButton();
        palyer2 = new ToggleGroup();
        palyer2o = new RadioButton();
        palyer21 = new ToggleGroup();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(900.0);

        background.setFitHeight(607.0);
        background.setFitWidth(914.0);
        background.setLayoutX(-13.0);
        background.setPickOnBounds(true);
        background.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backgroundxo.PNG").toExternalForm()));

        gaussianBlur.setRadius(13.06);
        background.setEffect(gaussianBlur);

        back.setFitHeight(97.0);
        back.setFitWidth(59.0);
        back.setLayoutX(30.0);
        back.setLayoutY(507.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backarrow2.png").toExternalForm()));

        dropShadow.setHeight(104.96);
        dropShadow.setRadius(54.3125);
        dropShadow.setSpread(0.4);
        dropShadow.setWidth(114.29);
        back.setEffect(dropShadow);

        imageView.setFitHeight(280.0);
        imageView.setFitWidth(231.0);
        imageView.setLayoutX(330.0);
        imageView.setLayoutY(119.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getClassLoader().getResource("game/pic/vs.png").toExternalForm()));

        player1label.setAlignment(javafx.geometry.Pos.CENTER);
        player1label.setLayoutX(30.0);
        player1label.setLayoutY(40.0);
        player1label.setPrefHeight(45.0);
        player1label.setPrefWidth(289.0);
        player1label.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        player1label.setText("Enter Player 1 Name");
        player1label.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        player1label.setFont(new Font("Book Antiqua Bold Italic", 28.0));

        palyer2label.setAlignment(javafx.geometry.Pos.CENTER);
        palyer2label.setLayoutX(554.0);
        palyer2label.setLayoutY(40.0);
        palyer2label.setPrefHeight(45.0);
        palyer2label.setPrefWidth(289.0);
        palyer2label.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        palyer2label.setText("Enter Player 2 Name");
        palyer2label.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        palyer2label.setFont(new Font("Book Antiqua Bold Italic", 28.0));

        player1text.setAlignment(javafx.geometry.Pos.CENTER);
        player1text.setLayoutX(30.0);
        player1text.setLayoutY(119.0);
        player1text.setPrefHeight(47.0);
        player1text.setPrefWidth(200.0);
        player1text.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 5000;");
        player1text.setText("player1");
        player1text.setFont(new Font("Baskerville Old Face", 20.0));
        player1text.setCursor(Cursor.TEXT);

        player2text.setAlignment(javafx.geometry.Pos.CENTER);
        player2text.setLayoutX(643.0);
        player2text.setLayoutY(119.0);
        player2text.setPrefHeight(47.0);
        player2text.setPrefWidth(200.0);
        player2text.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 5000;");
        player2text.setText("player2");
        player2text.setFont(new Font("Baskerville Old Face", 20.0));
        player2text.setCursor(Cursor.MOVE);

        palyer1x.setLayoutX(81.0);
        palyer1x.setLayoutY(217.0);
        palyer1x.setMnemonicParsing(false);
        palyer1x.setPrefHeight(55.0);
        palyer1x.setPrefWidth(80.0);
        palyer1x.setStyle("-fx-background-radius: 2000;");
        palyer1x.setText("X");
        palyer1x.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        palyer1x.setTextFill(javafx.scene.paint.Color.valueOf("#220ebc"));

        palyer1x.setToggleGroup(palyer1);
        palyer1x.setFont(new Font("System Bold", 40.0));

        start.setFitHeight(128.0);
        start.setFitWidth(163.0);
        start.setLayoutX(691.0);
        start.setLayoutY(436.0);
        start.setPickOnBounds(true);
        start.setPreserveRatio(true);
        start.setImage(new Image(getClass().getClassLoader().getResource("game/pic/start.png").toExternalForm()));

        dropShadow0.setHeight(62.2);
        dropShadow0.setRadius(26.7125);
        dropShadow0.setSpread(0.1);
        dropShadow0.setWidth(46.65);
        start.setEffect(dropShadow0);

        palyer1o.setLayoutX(82.0);
        palyer1o.setLayoutY(311.0);
        palyer1o.setMnemonicParsing(false);
        palyer1o.setPrefHeight(55.0);
        palyer1o.setPrefWidth(80.0);
        palyer1o.setStyle("-fx-background-radius: 2000;");
        palyer1o.setText("O");
        palyer1o.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        palyer1o.setTextFill(javafx.scene.paint.Color.valueOf("#220ebc"));
        palyer1o.setToggleGroup(palyer1);
        palyer1o.setFont(new Font("System Bold", 40.0));

        palyer2x.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        palyer2x.setLayoutX(708.0);
        palyer2x.setLayoutY(217.0);
        palyer2x.setMnemonicParsing(false);
        palyer2x.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
        palyer2x.setPrefHeight(55.0);
        palyer2x.setPrefWidth(80.0);
        palyer2x.setStyle("-fx-background-radius: 2000;");
        palyer2x.setText("X");
        palyer2x.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        palyer2x.setTextFill(javafx.scene.paint.Color.valueOf("#220ebc"));
        palyer2x.setFont(new Font("System Bold", 40.0));

        palyer2x.setToggleGroup(palyer2);

        palyer2o.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        palyer2o.setLayoutX(706.0);
        palyer2o.setLayoutY(311.0);
        palyer2o.setMnemonicParsing(false);
        palyer2o.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
        palyer2o.setPrefHeight(55.0);
        palyer2o.setPrefWidth(80.0);
        palyer2o.setStyle("-fx-background-radius: 2000;");
        palyer2o.setText("O");
        palyer2o.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        palyer2o.setTextFill(javafx.scene.paint.Color.valueOf("#220ebc"));
        palyer2o.setFont(new Font("System Bold", 40.0));

        palyer2o.setToggleGroup(palyer21);

        getChildren().add(background);
        getChildren().add(back);
        getChildren().add(imageView);
        getChildren().add(player1label);
        getChildren().add(palyer2label);
        getChildren().add(player1text);
        getChildren().add(player2text);
        getChildren().add(palyer1x);
        getChildren().add(start);
        getChildren().add(palyer1o);
        getChildren().add(palyer2x);
        getChildren().add(palyer2o);

    }
}
