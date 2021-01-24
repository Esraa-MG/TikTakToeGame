package game.view;

import java.lang.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Replay extends AnchorPane {

    protected final ImageView background;
    protected final GaussianBlur gaussianBlur;
    protected final ImageView board;
    protected final ImageView back;
    protected final DropShadow dropShadow;
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
    protected final Label player1label;
    protected final Label player2label;
    protected final ImageView prev;
    protected final ImageView next;

    public Replay() {

        background = new ImageView();
        gaussianBlur = new GaussianBlur();
        board = new ImageView();
        back = new ImageView();
        dropShadow = new DropShadow();
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
        prev = new ImageView();
        next = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(900.0);

        background.setFitHeight(600.0);
        background.setFitWidth(911.0);
        background.setLayoutX(-8.0);
        background.setPickOnBounds(true);
        background.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backgroundxo.PNG").toExternalForm()));

        gaussianBlur.setRadius(20.76);
        background.setEffect(gaussianBlur);

        board.setFitHeight(318.0);
        board.setFitWidth(828.0);
        board.setLayoutX(36.0);
        board.setLayoutY(157.0);
        board.setPickOnBounds(true);
        board.setImage(new Image(getClass().getClassLoader().getResource("game/pic/board3.jpg").toExternalForm()));

        back.setFitHeight(97.0);
        back.setFitWidth(57.0);
        back.setLayoutX(26.0);
        back.setLayoutY(514.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backarrow2.png").toExternalForm()));

        dropShadow.setHeight(120.51);
        dropShadow.setRadius(56.644999999999996);
        dropShadow.setSpread(0.21);
        dropShadow.setWidth(108.07);
        back.setEffect(dropShadow);

        r1c1.setFitHeight(66.0);
        r1c1.setFitWidth(144.0);
        r1c1.setLayoutX(115.0);
        r1c1.setLayoutY(184.0);
        r1c1.setPickOnBounds(true);

        r2c1.setFitHeight(66.0);
        r2c1.setFitWidth(144.0);
        r2c1.setLayoutX(115.0);
        r2c1.setLayoutY(283.0);
        r2c1.setPickOnBounds(true);

        r3c1.setFitHeight(66.0);
        r3c1.setFitWidth(144.0);
        r3c1.setLayoutX(115.0);
        r3c1.setLayoutY(382.0);
        r3c1.setPickOnBounds(true);

        r1c2.setFitHeight(66.0);
        r1c2.setFitWidth(144.0);
        r1c2.setLayoutX(378.0);
        r1c2.setLayoutY(184.0);
        r1c2.setPickOnBounds(true);

        r2c2.setFitHeight(66.0);
        r2c2.setFitWidth(144.0);
        r2c2.setLayoutX(376.0);
        r2c2.setLayoutY(283.0);
        r2c2.setPickOnBounds(true);

        r3c2.setFitHeight(66.0);
        r3c2.setFitWidth(144.0);
        r3c2.setLayoutX(369.0);
        r3c2.setLayoutY(382.0);
        r3c2.setPickOnBounds(true);

        r1c3.setFitHeight(66.0);
        r1c3.setFitWidth(144.0);
        r1c3.setLayoutX(640.0);
        r1c3.setLayoutY(184.0);
        r1c3.setPickOnBounds(true);

        r2c3.setFitHeight(66.0);
        r2c3.setFitWidth(144.0);
        r2c3.setLayoutX(632.0);
        r2c3.setLayoutY(283.0);
        r2c3.setPickOnBounds(true);

        r3c3.setFitHeight(66.0);
        r3c3.setFitWidth(144.0);
        r3c3.setLayoutX(632.0);
        r3c3.setLayoutY(382.0);
        r3c3.setPickOnBounds(true);

        player1icon.setFitHeight(49.0);
        player1icon.setFitWidth(42.0);
        player1icon.setLayoutX(22.0);
        player1icon.setLayoutY(34.0);
        player1icon.setPickOnBounds(true);
        player1icon.setImage(new Image(getClass().getClassLoader().getResource("game/pic/person.png").toExternalForm()));

        player2icon.setFitHeight(49.0);
        player2icon.setFitWidth(42.0);
        player2icon.setLayoutX(803.0);
        player2icon.setLayoutY(34.0);
        player2icon.setPickOnBounds(true);
        player2icon.setPreserveRatio(true);
        player2icon.setImage(new Image(getClass().getClassLoader().getResource("game/pic/person.png").toExternalForm()));

        player1label.setAlignment(javafx.geometry.Pos.CENTER);
        player1label.setLayoutX(83.0);
        player1label.setLayoutY(36.0);
        player1label.setPrefHeight(45.0);
        player1label.setPrefWidth(250.0);
        player1label.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        player1label.setText("Player 1");
        player1label.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        player1label.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        player2label.setAlignment(javafx.geometry.Pos.CENTER);
        player2label.setLayoutX(526.0);
        player2label.setLayoutY(41.0);
        player2label.setPrefHeight(45.0);
        player2label.setPrefWidth(250.0);
        player2label.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        player2label.setText("Player 2");
        player2label.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        player2label.setFont(new Font("Book Antiqua Bold Italic", 32.0));

        prev.setFitHeight(83.0);
        prev.setFitWidth(106.0);
        prev.setLayoutX(466.0);
        prev.setLayoutY(501.0);
        prev.setPickOnBounds(true);
        prev.setImage(new Image(getClass().getClassLoader().getResource("game/pic/prev.jpeg").toExternalForm()));

        next.setFitHeight(83.0);
        next.setFitWidth(106.0);
        next.setLayoutX(712.0);
        next.setLayoutY(502.0);
        next.setPickOnBounds(true);
        next.setImage(new Image(getClass().getClassLoader().getResource("game/pic/next.jpeg").toExternalForm()));

        getChildren().add(background);
        getChildren().add(board);
        getChildren().add(back);
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
        getChildren().add(prev);
        getChildren().add(next);

    }
}
