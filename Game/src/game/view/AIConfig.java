package game.view;

import javafx.scene.*;
import java.lang.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class AIConfig extends AnchorPane {

    protected final ImageView background;
    protected final GaussianBlur gaussianBlur;
    protected final ImageView palyerphoto;
    public final ImageView back;
    protected final ImageView robotphoto;
    public final ImageView start;
    protected final ImageView vs;
    protected final RadioButton palyer1o;
    protected final ToggleGroup palyer1;
    protected final RadioButton palyer1x;
    protected final TextField playername;
    protected final TextField robotname;

    public AIConfig() {

        background = new ImageView();
        gaussianBlur = new GaussianBlur();
        palyerphoto = new ImageView();
        back = new ImageView();
        robotphoto = new ImageView();
        start = new ImageView();
        vs = new ImageView();
        palyer1o = new RadioButton();
        palyer1 = new ToggleGroup();
        palyer1x = new RadioButton();
        playername = new TextField();
        robotname = new TextField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(900.0);

        background.setFitHeight(607.0);
        background.setFitWidth(908.0);
        background.setLayoutX(-7.0);
        background.setLayoutY(-6.0);
        background.setPickOnBounds(true);
        background.setSmooth(false);
        background.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backgroundxo.PNG").toExternalForm()));

        gaussianBlur.setRadius(12.65);
        background.setEffect(gaussianBlur);

        palyerphoto.setFitHeight(133.0);
        palyerphoto.setFitWidth(130.0);
        palyerphoto.setLayoutX(27.0);
        palyerphoto.setLayoutY(59.0);
        palyerphoto.setPickOnBounds(true);
        palyerphoto.setPreserveRatio(true);
        palyerphoto.setImage(new Image(getClass().getClassLoader().getResource("game/pic/pe.jpg").toExternalForm()));

        back.setFitHeight(69.0);
        back.setFitWidth(67.0);
        back.setLayoutX(14.0);
        back.setLayoutY(514.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backarrow2.png").toExternalForm()));

        robotphoto.setFitHeight(133.0);
        robotphoto.setFitWidth(130.0);
        robotphoto.setLayoutX(721.0);
        robotphoto.setLayoutY(59.0);
        robotphoto.setPickOnBounds(true);
        robotphoto.setPreserveRatio(true);
        robotphoto.setImage(new Image(getClass().getClassLoader().getResource("game/pic/robot.jpg").toExternalForm()));

        start.setFitHeight(143.0);
        start.setFitWidth(115.0);
        start.setLayoutX(721.0);
        start.setLayoutY(451.0);
        start.setPickOnBounds(true);
        start.setPreserveRatio(true);
        start.setImage(new Image(getClass().getClassLoader().getResource("game/pic/start.png").toExternalForm()));

        vs.setFitHeight(181.0);
        vs.setFitWidth(184.0);
        vs.setLayoutX(377.0);
        vs.setLayoutY(73.0);
        vs.setPickOnBounds(true);
        vs.setPreserveRatio(true);
        vs.setImage(new Image(getClass().getClassLoader().getResource("game/pic/vs.png").toExternalForm()));

        palyer1o.setLayoutX(79.0);
        palyer1o.setLayoutY(411.0);
        palyer1o.setMnemonicParsing(false);
        palyer1o.setPrefHeight(55.0);
        palyer1o.setPrefWidth(80.0);
        palyer1o.setStyle("-fx-background-radius: 2000;");
        palyer1o.setText("O");
        palyer1o.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        palyer1o.setTextFill(javafx.scene.paint.Color.valueOf("#220ebc"));

        palyer1o.setToggleGroup(palyer1);
        palyer1o.setFont(new Font("System Bold", 40.0));

        palyer1x.setLayoutX(78.0);
        palyer1x.setLayoutY(317.0);
        palyer1x.setMnemonicParsing(false);
        palyer1x.setPrefHeight(55.0);
        palyer1x.setPrefWidth(80.0);
        palyer1x.setStyle("-fx-background-radius: 2000;");
        palyer1x.setText("X");
        palyer1x.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        palyer1x.setTextFill(javafx.scene.paint.Color.valueOf("#220ebc"));
        palyer1x.setToggleGroup(palyer1);
        palyer1x.setFont(new Font("System Bold", 40.0));

        playername.setAlignment(javafx.geometry.Pos.CENTER);
        playername.setLayoutX(27.0);
        playername.setLayoutY(219.0);
        playername.setPrefHeight(47.0);
        playername.setPrefWidth(200.0);
        playername.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 5000;");
        playername.setText("player1");
        playername.setCursor(Cursor.TEXT);
        playername.setFont(new Font("Baskerville Old Face", 20.0));

        robotname.setAlignment(javafx.geometry.Pos.CENTER);
        robotname.setLayoutX(679.0);
        robotname.setLayoutY(219.0);
        robotname.setPrefHeight(47.0);
        robotname.setPrefWidth(200.0);
        robotname.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 5000;");
        robotname.setText("Robot");
        robotname.setCursor(Cursor.TEXT);
        robotname.setFont(new Font("Baskerville Old Face", 20.0));

        getChildren().add(background);
        getChildren().add(palyerphoto);
        getChildren().add(back);
        getChildren().add(robotphoto);
        getChildren().add(start);
        getChildren().add(vs);
        getChildren().add(palyer1o);
        getChildren().add(palyer1x);
        getChildren().add(playername);
        getChildren().add(robotname);

    }
}
