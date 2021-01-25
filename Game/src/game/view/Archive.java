package game.view;

import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import java.lang.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.*;

public class Archive extends AnchorPane {

    protected final ImageView background;
    protected final GaussianBlur gaussianBlur;
    public final Label label;
    public final ImageView back;
    public final ScrollPane scrollPane;
    public final VBox vbox;
  

    public Archive() {

        background = new ImageView();
        gaussianBlur = new GaussianBlur();
        label = new Label();
        back = new ImageView();
        scrollPane = new ScrollPane();
        vbox = new VBox();
       

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(900.0);

        background.setFitHeight(608.0);
        background.setFitWidth(918.0);
        background.setLayoutX(-12.0);
        background.setLayoutY(-8.0);
        background.setPickOnBounds(true);
        background.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backgroundxo.PNG").toExternalForm()));

        background.setEffect(gaussianBlur);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(134.0);
        label.setLayoutY(212.0);
        label.setPrefHeight(86.0);
        label.setPrefWidth(630.0);
        label.setStyle("-fx-background-color: #add8e6; -fx-background-radius: 2000;");
        label.setText("Empty Archive");
        label.setFont(new Font("Bell MT", 76.0));

        back.setFitHeight(97.0);
        back.setFitWidth(59.0);
        back.setLayoutX(38.0);
        back.setLayoutY(499.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backarrow2.png").toExternalForm()));

        scrollPane.setLayoutX(49.0);
        scrollPane.setLayoutY(30.0);
        scrollPane.setPrefHeight(480.0);
        scrollPane.setPrefWidth(800.0);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent;");
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        
        vbox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vbox.setNodeOrientation(javafx.geometry.NodeOrientation.LEFT_TO_RIGHT);
        vbox.setPrefHeight(478.0);
        vbox.setPrefWidth(798.0);
        vbox.setSpacing(10.0);
        

       
        vbox.setOpaqueInsets(new Insets(0.0));
        vbox.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
        scrollPane.setContent(vbox);

        getChildren().add(background);
        getChildren().add(label);
        getChildren().add(back);
       
        getChildren().add(scrollPane);

    }
}
