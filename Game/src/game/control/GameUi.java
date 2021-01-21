package game.control;

import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import java.lang.*;
import javafx.scene.layout.*;

public class GameUi extends AnchorPane {

    protected final ImageView background;
    protected final GaussianBlur gaussianBlur;
    protected final ImageView board;
    public final ImageView back;
    protected final DropShadow dropShadow;
    protected final ImageView record;
    protected final ImageView reset;
    protected final ImageView r1c1;
    protected final ImageView r2c1;
    protected final ImageView r3c1;
    protected final ImageView r1c2;
    protected final ImageView r2c2;
    protected final ImageView r3c2;
    protected final ImageView r1c3;
    protected final ImageView r2c3;
    protected final ImageView r3c3;
    protected final ImageView player1icon;
    protected final ImageView player2icon;
    public final Label player1label;
    public final Label player2label;
    public final Label player1score;
    public final Label player2score;
    protected final Label xwins;
    protected final Label owins;
    protected final ImageView clap;
    protected final Label draw;

    public GameUi() {

        background = new ImageView();
        gaussianBlur = new GaussianBlur();
        board = new ImageView();
        back = new ImageView();
        dropShadow = new DropShadow();
        record = new ImageView();
        reset = new ImageView();
        r1c1 = new ImageView();
        r2c1 = new ImageView();
        r3c1 = new ImageView();
        r1c2 = new ImageView();
        r2c2 = new ImageView();
        r3c2 = new ImageView();
        r1c3 = new ImageView();
        r2c3 = new ImageView();
        r3c3 = new ImageView();
        player1icon = new ImageView();
        player2icon = new ImageView();
        player1label = new Label();
        player2label = new Label();
        player1score = new Label();
        player2score = new Label();
        xwins = new Label();
        owins = new Label();
        clap = new ImageView();
        draw = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);

        background.setFitHeight(500.0);
        background.setFitWidth(721.0);
        background.setLayoutX(-8.0);
        background.setPickOnBounds(true);
        background.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backgroundxo.PNG").toExternalForm()));

        gaussianBlur.setRadius(20.76);
        background.setEffect(gaussianBlur);

        board.setFitHeight(302.0);
        board.setFitWidth(663.0);
        board.setLayoutX(16.0);
        board.setLayoutY(112.0);
        board.setPickOnBounds(true);
        board.setImage(new Image(getClass().getClassLoader().getResource("game/pic/board3.jpg").toExternalForm()));

        back.setFitHeight(97.0);
        back.setFitWidth(57.0);
        back.setLayoutX(14.0);
        back.setLayoutY(429.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backarrow2.png").toExternalForm()));

        dropShadow.setHeight(120.51);
        dropShadow.setRadius(56.644999999999996);
        dropShadow.setSpread(0.21);
        dropShadow.setWidth(108.07);
        back.setEffect(dropShadow);

        record.setFitHeight(74.0);
        record.setFitWidth(102.0);
        record.setLayoutX(313.0);
        record.setLayoutY(421.0);
        record.setPickOnBounds(true);
        record.setPreserveRatio(true);
        record.setImage(new Image(getClass().getClassLoader().getResource("game/pic/record.png").toExternalForm()));

        reset.setFitHeight(57.0);
        reset.setFitWidth(74.0);
        reset.setLayoutX(622.0);
        reset.setLayoutY(429.0);
        reset.setPickOnBounds(true);
        reset.setPreserveRatio(true);
        reset.setImage(new Image(getClass().getClassLoader().getResource("game/pic/reset.png").toExternalForm()));

        r1c1.setFitHeight(66.0);
        r1c1.setFitWidth(144.0);
        r1c1.setLayoutX(64.0);
        r1c1.setLayoutY(136.0);
        r1c1.setPickOnBounds(true);

        r2c1.setFitHeight(66.0);
        r2c1.setFitWidth(144.0);
        r2c1.setLayoutX(71.0);
        r2c1.setLayoutY(230.0);
        r2c1.setPickOnBounds(true);

        r3c1.setFitHeight(66.0);
        r3c1.setFitWidth(144.0);
        r3c1.setLayoutX(71.0);
        r3c1.setLayoutY(324.0);
        r3c1.setPickOnBounds(true);

        r1c2.setFitHeight(66.0);
        r1c2.setFitWidth(144.0);
        r1c2.setLayoutX(276.0);
        r1c2.setLayoutY(136.0);
        r1c2.setPickOnBounds(true);

        r2c2.setFitHeight(66.0);
        r2c2.setFitWidth(144.0);
        r2c2.setLayoutX(276.0);
        r2c2.setLayoutY(230.0);
        r2c2.setPickOnBounds(true);

        r3c2.setFitHeight(66.0);
        r3c2.setFitWidth(144.0);
        r3c2.setLayoutX(281.0);
        r3c2.setLayoutY(324.0);
        r3c2.setPickOnBounds(true);

        r1c3.setFitHeight(66.0);
        r1c3.setFitWidth(144.0);
        r1c3.setLayoutX(490.0);
        r1c3.setLayoutY(136.0);
        r1c3.setPickOnBounds(true);

        r2c3.setFitHeight(66.0);
        r2c3.setFitWidth(144.0);
        r2c3.setLayoutX(490.0);
        r2c3.setLayoutY(230.0);
        r2c3.setPickOnBounds(true);

        r3c3.setFitHeight(66.0);
        r3c3.setFitWidth(144.0);
        r3c3.setLayoutX(490.0);
        r3c3.setLayoutY(324.0);
        r3c3.setPickOnBounds(true);

        player1icon.setFitHeight(49.0);
        player1icon.setFitWidth(42.0);
        player1icon.setLayoutX(22.0);
        player1icon.setLayoutY(14.0);
        player1icon.setPickOnBounds(true);
        player1icon.setImage(new Image(getClass().getClassLoader().getResource("game/pic/person.png").toExternalForm()));

        player2icon.setFitHeight(49.0);
        player2icon.setFitWidth(42.0);
        player2icon.setLayoutX(622.0);
        player2icon.setLayoutY(14.0);
        player2icon.setPickOnBounds(true);
        player2icon.setPreserveRatio(true);
        player2icon.setImage(new Image(getClass().getClassLoader().getResource("game/pic/person.png").toExternalForm()));

        player1label.setAlignment(javafx.geometry.Pos.CENTER);
        player1label.setLayoutX(78.0);
        player1label.setLayoutY(14.0);
        player1label.setPrefHeight(47.0);
        player1label.setPrefWidth(137.0);
        player1label.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        player1label.setText("Player 1");
        player1label.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        player1label.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        player2label.setAlignment(javafx.geometry.Pos.CENTER);
        player2label.setLayoutX(469.0);
        player2label.setLayoutY(14.0);
        player2label.setPrefHeight(47.0);
        player2label.setPrefWidth(137.0);
        player2label.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        player2label.setText("Player 2");
        player2label.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        player2label.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        player1score.setAlignment(javafx.geometry.Pos.CENTER);
        player1score.setLayoutX(22.0);
        player1score.setLayoutY(61.0);
        player1score.setPrefHeight(42.0);
        player1score.setPrefWidth(57.0);
        player1score.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        player1score.setText("0");
        player1score.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        player1score.setWrapText(true);
        player1score.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        player2score.setAlignment(javafx.geometry.Pos.CENTER);
        player2score.setLayoutX(615.0);
        player2score.setLayoutY(61.0);
        player2score.setPrefHeight(42.0);
        player2score.setPrefWidth(57.0);
        player2score.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        player2score.setText("0");
        player2score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player2score.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        player2score.setWrapText(true);
        player2score.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        xwins.setLayoutX(288.0);
        xwins.setLayoutY(367.0);
        xwins.setPrefHeight(47.0);
        xwins.setPrefWidth(137.0);
        xwins.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        xwins.setText("X WINS");
        xwins.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        xwins.setVisible(false);
        xwins.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        owins.setLayoutX(299.0);
        owins.setLayoutY(357.0);
        owins.setPrefHeight(47.0);
        owins.setPrefWidth(137.0);
        owins.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        owins.setText("O WINS");
        owins.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        owins.setVisible(false);
        owins.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        clap.setFitHeight(318.0);
        clap.setFitWidth(345.0);
        clap.setLayoutX(182.0);
        clap.setLayoutY(91.0);
        clap.setPickOnBounds(true);
        clap.setPreserveRatio(true);
        clap.setVisible(false);
        clap.setImage(new Image(getClass().getClassLoader().getResource("game/pic/clap4.gif").toExternalForm()));

        draw.setLayoutX(298.0);
        draw.setLayoutY(377.0);
        draw.setPrefHeight(47.0);
        draw.setPrefWidth(137.0);
        draw.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        draw.setText("DRAW");
        draw.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        draw.setVisible(false);
        draw.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        getChildren().add(background);
        getChildren().add(board);
        getChildren().add(back);
        getChildren().add(record);
        getChildren().add(reset);
        getChildren().add(r1c1);
        getChildren().add(r2c1);
        getChildren().add(r3c1);
        getChildren().add(r1c2);
        getChildren().add(r2c2);
        getChildren().add(r3c2);
        getChildren().add(r1c3);
        getChildren().add(r2c3);
        getChildren().add(r3c3);
        getChildren().add(player1icon);
        getChildren().add(player2icon);
        getChildren().add(player1label);
        getChildren().add(player2label);
        getChildren().add(player1score);
        getChildren().add(player2score);
        getChildren().add(xwins);
        getChildren().add(owins);
        getChildren().add(clap);
        getChildren().add(draw);

    }
}
