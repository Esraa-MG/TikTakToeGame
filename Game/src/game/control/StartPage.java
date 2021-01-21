package game.control;

import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import java.lang.*;
import java.util.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class StartPage extends AnchorPane {

    protected final ImageView background;
    protected final GaussianBlur gaussianBlur;
    public final ImageView moving;
    public final Button start;
    public final Label gameTime;

    public StartPage() {

        background = new ImageView();
        gaussianBlur = new GaussianBlur();
        moving = new ImageView();
        start = new Button();
        gameTime = new Label();

        setId("AnchorPane");
        setPrefHeight(500.0);
        setPrefWidth(700.0);

        background.setFitHeight(523.0);
        background.setFitWidth(700.0);
        background.setOpacity(0.59);
        background.setPickOnBounds(true);
        background.setImage(new Image(getClass().getClassLoader().getResource("game/pic/back2.jpg").toExternalForm()));

        background.setEffect(gaussianBlur);

        moving.setFitHeight(164.0);
        moving.setFitWidth(200.0);
        moving.setLayoutX(-135.0);
        moving.setLayoutY(331.0);
        moving.setPickOnBounds(true);
        moving.setPreserveRatio(true);
        moving.setImage(new Image(getClass().getClassLoader().getResource("game/pic/moving.png").toExternalForm()));

        start.setLayoutX(427.0);
        start.setLayoutY(418.0);
        start.setMnemonicParsing(false);
        start.setPrefHeight(47.0);
        start.setPrefWidth(128.0);
        start.setStyle("-fx-background-radius: 200; -fx-background-color: #adbce6;");
        start.setText("Start");
        start.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        start.setTextFill(javafx.scene.paint.Color.valueOf("#380101"));
        start.setVisible(false);
        start.setFont(new Font("Bell MT Bold", 34.0));

        gameTime.setLayoutX(230.0);
        gameTime.setLayoutY(366.0);
        gameTime.setPrefHeight(65.0);
        gameTime.setPrefWidth(248.0);
        gameTime.setStyle("-fx-background-radius: 2000;");
        gameTime.setText("Game Time");
        gameTime.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameTime.setTextFill(javafx.scene.paint.Color.valueOf("#b51717"));
        gameTime.setWrapText(true);
        gameTime.setFont(new Font("Berlin Sans FB Bold", 45.0));

        getChildren().add(background);
        getChildren().add(moving);
        getChildren().add(start);
        getChildren().add(gameTime);

    }
}
