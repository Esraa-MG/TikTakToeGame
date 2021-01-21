package game.control;

import javafx.scene.image.*;
import java.lang.*;
import javafx.scene.layout.*;
import javafx.scene.input.MouseEvent;

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
        setPrefHeight(500.0);
        setPrefWidth(700.0);

        imageView.setFitHeight(516.0);
        imageView.setFitWidth(710.0);
        imageView.setOpacity(0.78);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getClassLoader().getResource("game/pic/back1.jpg").toExternalForm()));

        snake.setFitHeight(110.0);
        snake.setFitWidth(120.0);
        snake.setLayoutX(134.0);
        snake.setLayoutY(126.0);
        snake.setPickOnBounds(true);
        snake.setPreserveRatio(true);
        snake.setImage(new Image(getClass().getClassLoader().getResource("game/pic/snake.png").toExternalForm()));
        
        
        xo.setFitHeight(110.0);
        xo.setFitWidth(138.0);
        xo.setLayoutX(437.0);
        xo.setLayoutY(126.0);
        xo.setPickOnBounds(true);
        xo.setPreserveRatio(true);
        xo.setImage(new Image(getClass().getClassLoader().getResource("game/pic/xo.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(snake);
        getChildren().add(xo);

    }
}
