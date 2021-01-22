package game.view;

import javafx.scene.image.*;
import java.lang.*;
import javafx.scene.layout.*;

public class GameChoicePage extends AnchorPane {

    protected final ImageView imageView;
    public final ImageView snake;
    public final ImageView xo;

    public GameChoicePage() {

        imageView = new ImageView();
        snake = new ImageView();
        xo = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(900.0);

        imageView.setFitHeight(613.0);
        imageView.setFitWidth(916.0);
        imageView.setOpacity(0.78);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getClassLoader().getResource("game/pic/back1.jpg").toExternalForm()));

        snake.setFitHeight(118.0);
        snake.setFitWidth(106.0);
        snake.setLayoutX(209.0);
        snake.setLayoutY(133.0);
        snake.setPickOnBounds(true);
        snake.setPreserveRatio(true);
        snake.setImage(new Image(getClass().getClassLoader().getResource("game/pic/snake.png").toExternalForm()));

        xo.setFitHeight(118.0);
        xo.setFitWidth(116.0);
        xo.setLayoutX(587.0);
        xo.setLayoutY(133.0);
        xo.setPickOnBounds(true);
        xo.setPreserveRatio(true);
        xo.setImage(new Image(getClass().getClassLoader().getResource("game/pic/xo.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(snake);
        getChildren().add(xo);

    }
}
