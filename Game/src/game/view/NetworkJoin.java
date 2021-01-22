package game.view;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import java.lang.*;
import javafx.scene.layout.*;

public class NetworkJoin extends AnchorPane {

    protected final ImageView background;
    protected final GaussianBlur gaussianBlur;
    public final Button join;
    public final ImageView start;
    public final ImageView back;
    protected final Label playerName;
    public final TextField player;
    public final TextField ip;
    public final Label hostip;
    public final Button create;
    protected final Label iplabel;

    public NetworkJoin() {

        background = new ImageView();
        gaussianBlur = new GaussianBlur();
        join = new Button();
        start = new ImageView();
        back = new ImageView();
        playerName = new Label();
        player = new TextField();
        ip = new TextField();
        hostip = new Label();
        create = new Button();
        iplabel = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(900.0);

        background.setFitHeight(615.0);
        background.setFitWidth(917.0);
        background.setLayoutX(-8.0);
        background.setLayoutY(-8.0);
        background.setPickOnBounds(true);

        background.setEffect(gaussianBlur);
        background.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backgroundxo.PNG").toExternalForm()));

        join.setLayoutX(312.0);
        join.setLayoutY(270.0);
        join.setMnemonicParsing(false);
        join.setPrefHeight(60.0);
        join.setPrefWidth(212.0);
        join.setStyle("-fx-background-color: #adbce6; -fx-background-radius: 2000;");
        join.setText("Join ");
        join.setTextFill(javafx.scene.paint.Color.valueOf("#a12828"));
        join.setFont(new Font("Berlin Sans FB Bold", 25.0));

        start.setFitHeight(150.0);
        start.setFitWidth(200.0);
        start.setLayoutX(726.0);
        start.setLayoutY(436.0);
        start.setPickOnBounds(true);
        start.setPreserveRatio(true);
        start.setImage(new Image(getClass().getClassLoader().getResource("game/pic/start.png").toExternalForm()));
        start.setVisible(false);
        
        back.setFitHeight(60.0);
        back.setFitWidth(60.0);
        back.setLayoutX(14.0);
        back.setLayoutY(526.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backarrow2.png").toExternalForm()));

        playerName.setAlignment(javafx.geometry.Pos.CENTER);
        playerName.setLayoutX(33.0);
        playerName.setLayoutY(68.0);
        playerName.setPrefHeight(47.0);
        playerName.setPrefWidth(359.0);
        playerName.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        playerName.setText("Enter Your Name");
        playerName.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        playerName.setFont(new Font("Book Antiqua Bold Italic", 32.0));

        player.setAlignment(javafx.geometry.Pos.CENTER);
        player.setLayoutX(484.0);
        player.setLayoutY(74.0);
        player.setPrefHeight(47.0);
        player.setPrefWidth(359.0);
        player.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 5000;");
        player.setText("player");
        player.setFont(new Font("Baskerville Old Face", 20.0));
        player.setCursor(Cursor.TEXT);

        ip.setAlignment(javafx.geometry.Pos.CENTER);
        ip.setLayoutX(484.0);
        ip.setLayoutY(173.0);
        ip.setPrefHeight(47.0);
        ip.setPrefWidth(359.0);
        ip.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 5000;");
        ip.setFont(new Font("Baskerville Old Face", 20.0));
        ip.setCursor(Cursor.TEXT);

        hostip.setAlignment(javafx.geometry.Pos.CENTER);
        hostip.setLayoutX(33.0);
        hostip.setLayoutY(389.0);
        hostip.setPrefHeight(47.0);
        hostip.setPrefWidth(359.0);
        hostip.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        hostip.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        hostip.setFont(new Font("Book Antiqua Bold Italic", 30.0));

        create.setLayoutX(312.0);
        create.setLayoutY(466.0);
        create.setMnemonicParsing(false);
        create.setPrefHeight(60.0);
        create.setPrefWidth(212.0);
        create.setStyle("-fx-background-color: #adbce6; -fx-background-radius: 2000;");
        create.setText("Create");
        create.setTextFill(javafx.scene.paint.Color.valueOf("#a12828"));
        create.setFont(new Font("Berlin Sans FB Bold", 25.0));

        iplabel.setAlignment(javafx.geometry.Pos.CENTER);
        iplabel.setLayoutX(33.0);
        iplabel.setLayoutY(173.0);
        iplabel.setPrefHeight(47.0);
        iplabel.setPrefWidth(359.0);
        iplabel.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        iplabel.setText("Enter Host IP");
        iplabel.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        iplabel.setFont(new Font("Book Antiqua Bold Italic", 32.0));

        getChildren().add(background);
        getChildren().add(join);
        getChildren().add(start);
        getChildren().add(back);
        getChildren().add(playerName);
        getChildren().add(player);
        getChildren().add(ip);
        getChildren().add(hostip);
        getChildren().add(create);
        getChildren().add(iplabel);

    }
}
