package game.view;

import javafx.scene.effect.*;
import javafx.scene.image.*;
import java.lang.*;
import javafx.scene.layout.*;

public class EasyHardConfig extends AnchorPane {

    protected final ImageView background;
    protected final GaussianBlur gaussianBlur;
    public final ImageView back;
    protected final ImageView normal;
    protected final DropShadow dropShadow;
    protected final ImageView hard;
    protected final DropShadow dropShadow0;

    public EasyHardConfig() {

        background = new ImageView();
        gaussianBlur = new GaussianBlur();
        back = new ImageView();
        normal = new ImageView();
        dropShadow = new DropShadow();
        hard = new ImageView();
        dropShadow0 = new DropShadow();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(900.0);

        background.setFitHeight(626.0);
        background.setFitWidth(943.0);
        background.setLayoutX(-27.0);
        background.setLayoutY(-11.0);
        background.setPickOnBounds(true);
        background.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backgroundxo.PNG").toExternalForm()));

        background.setEffect(gaussianBlur);

        back.setFitHeight(66.0);
        back.setFitWidth(61.0);
        back.setLayoutX(22.0);
        back.setLayoutY(519.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backarrow2.png").toExternalForm()));

        normal.setFitHeight(148.0);
        normal.setFitWidth(368.0);
        normal.setLayoutX(253.0);
        normal.setLayoutY(111.0);
        normal.setPickOnBounds(true);
        normal.setImage(new Image(getClass().getClassLoader().getResource("game/pic/easy.png").toExternalForm()));

        dropShadow.setHeight(80.08);
        dropShadow.setRadius(38.765);
        dropShadow.setWidth(76.98);
        normal.setEffect(dropShadow);

        hard.setFitHeight(137.0);
        hard.setFitWidth(360.0);
        hard.setLayoutX(261.0);
        hard.setLayoutY(300.0);
        hard.setPickOnBounds(true);
        hard.setImage(new Image(getClass().getClassLoader().getResource("game/pic/hard.jpg").toExternalForm()));

        dropShadow0.setHeight(86.3);
        dropShadow0.setRadius(35.655);
        dropShadow0.setWidth(58.32);
        hard.setEffect(dropShadow0);

        getChildren().add(background);
        getChildren().add(back);
        getChildren().add(normal);
        getChildren().add(hard);

    }
}
