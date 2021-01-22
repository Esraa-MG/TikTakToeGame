package game.view;

import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import java.lang.*;
import javafx.scene.layout.*;

public class SelectModeXO extends AnchorPane {

    protected final ImageView background;
    protected final GaussianBlur gaussianBlur;
    protected final ImageView sideimage;
    protected final DropShadow dropShadow;
    public final Button online;
    public final Button single;
    public final Button twoplayer;
    protected final Button archive;
    public final ImageView back;
    protected final DropShadow dropShadow0;

    public SelectModeXO() {

        background = new ImageView();
        gaussianBlur = new GaussianBlur();
        sideimage = new ImageView();
        dropShadow = new DropShadow();
        online = new Button();
        single = new Button();
        twoplayer = new Button();
        archive = new Button();
        back = new ImageView();
        dropShadow0 = new DropShadow();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(900.0);

        background.setFitHeight(610.0);
        background.setFitWidth(936.0);
        background.setLayoutX(-21.0);
        background.setPickOnBounds(true);
        background.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backgroundxo.PNG").toExternalForm()));

        gaussianBlur.setRadius(4.61);
        background.setEffect(gaussianBlur);

        sideimage.setFitHeight(300.0);
        sideimage.setFitWidth(300.0);
        sideimage.setLayoutX(68.0);
        sideimage.setLayoutY(191.0);
        sideimage.setPickOnBounds(true);
        sideimage.setPreserveRatio(true);
        sideimage.setImage(new Image(getClass().getClassLoader().getResource("game/pic/Captur11e.PNG").toExternalForm()));

        dropShadow.setBlurType(javafx.scene.effect.BlurType.GAUSSIAN);
        dropShadow.setHeight(107.3);
        dropShadow.setRadius(50.2325);
        dropShadow.setSpread(0.28);
        dropShadow.setWidth(95.63);
        sideimage.setEffect(dropShadow);

        online.setLayoutX(478.0);
        online.setLayoutY(328.0);
        online.setMnemonicParsing(false);
        online.setPrefHeight(67.0);
        online.setPrefWidth(243.0);
        online.setStyle("-fx-background-color: #adcbe6; -fx-background-radius: 2000;");
        online.setText("Online Mode");
        online.setTextFill(javafx.scene.paint.Color.valueOf("#a12828"));
        online.setFont(new Font("Berlin Sans FB Bold", 25.0));

        single.setLayoutX(471.0);
        single.setLayoutY(64.0);
        single.setMnemonicParsing(false);
        single.setPrefHeight(67.0);
        single.setPrefWidth(243.0);
        single.setStyle("-fx-background-color: #adbce6; -fx-background-radius: 2000;");
        single.setText("Single Mode");
        single.setTextFill(javafx.scene.paint.Color.valueOf("#a12828"));
        single.setFont(new Font("Berlin Sans FB Bold", 25.0));

        twoplayer.setLayoutX(471.0);
        twoplayer.setLayoutY(191.0);
        twoplayer.setMnemonicParsing(false);
        twoplayer.setPrefHeight(67.0);
        twoplayer.setPrefWidth(243.0);
        twoplayer.setStyle("-fx-background-color: adbce6; -fx-background-radius: 2000;");
        twoplayer.setText("Two Player Mode");
        twoplayer.setTextFill(javafx.scene.paint.Color.valueOf("#a12828"));
        twoplayer.setFont(new Font("Berlin Sans FB Demi Bold", 25.0));

        archive.setLayoutX(478.0);
        archive.setLayoutY(466.0);
        archive.setMnemonicParsing(false);
        archive.setPrefHeight(67.0);
        archive.setPrefWidth(243.0);
        archive.setStyle("-fx-background-color: adbce6; -fx-background-radius: 2000;");
        archive.setText("Archive");
        archive.setTextFill(javafx.scene.paint.Color.valueOf("#a12828"));
        archive.setFont(new Font("Berlin Sans FB Bold", 25.0));

        back.setFitHeight(97.0);
        back.setFitWidth(59.0);
        back.setLayoutX(38.0);
        back.setLayoutY(499.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backarrow2.png").toExternalForm()));

        dropShadow0.setHeight(98.74);
        dropShadow0.setRadius(48.0925);
        dropShadow0.setSpread(0.38);
        dropShadow0.setWidth(95.63);
        back.setEffect(dropShadow0);

        getChildren().add(background);
        getChildren().add(sideimage);
        getChildren().add(online);
        getChildren().add(single);
        getChildren().add(twoplayer);
        getChildren().add(archive);
        getChildren().add(back);

    }
}
