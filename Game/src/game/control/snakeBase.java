package game.control;

import javafx.scene.control.*;
import java.lang.*;
import javafx.scene.layout.*;

public class snakeBase extends AnchorPane {

    protected final Label label;

    public snakeBase() {

        label = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(182.0);
        label.setLayoutY(167.0);
        label.setPrefHeight(21.0);
        label.setPrefWidth(340.0);
        label.setText("snake scene");

        getChildren().add(label);

    }
}
