package game.view;

import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import java.lang.*;
import javafx.scene.layout.*;

public class GameUi extends AnchorPane {

    protected final ImageView background;
    protected final GaussianBlur gaussianBlur;
    protected final ImageView board;
    public final ImageView back;
    protected final DropShadow dropShadow;
    protected final ImageView record;
    public final ImageView reset;
    public final ImageView r1c1;
    public final ImageView r2c1;
    public final ImageView r3c1;
    public final ImageView r1c2;
    public final ImageView r2c2;
    public final ImageView r3c2;
    public final ImageView r1c3;
    public final ImageView r2c3;
    public final ImageView r3c3;
    protected final ImageView player1icon;
    protected final ImageView player2icon;
    public final Label player1label;
    public final Label player2label;
    public final Label player1score;
    public final Label player2score;
    public final Label xwins;
    public final Label owins;
    public final ImageView clap;
    public final Label draw;
    public final ImageView dance;
    public final ImageView cry;
    public final Label player1label1;
    protected final AnchorPane anchorPane;
    protected final ImageView saveback;
    protected final GaussianBlur gaussianBlur0;
    protected final Label question;
    protected final Button no;
    protected final Button yes;
    protected final AnchorPane anchorPane0;
    protected final ImageView imageView;
    protected final GaussianBlur gaussianBlur1;
    protected final Label player1label2;
    protected final Button button;

    public GameUi() {

        background = new ImageView();
        gaussianBlur = new GaussianBlur();
        board = new ImageView();
        back = new ImageView();
        dropShadow = new DropShadow();
        record = new ImageView();
        reset = new ImageView();
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
        player1score = new Label();
        player2score = new Label();
        xwins = new Label();
        owins = new Label();
        clap = new ImageView();
        draw = new Label();
        dance = new ImageView();
        cry = new ImageView();
        player1label1 = new Label();
        anchorPane = new AnchorPane();
        saveback = new ImageView();
        gaussianBlur0 = new GaussianBlur();
        question = new Label();
        no = new Button();
        yes = new Button();
        anchorPane0 = new AnchorPane();
        imageView = new ImageView();
        gaussianBlur1 = new GaussianBlur();
        player1label2 = new Label();
        button = new Button();

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
        board.setLayoutY(180.0);
        board.setPickOnBounds(true);
        board.setImage(new Image(getClass().getClassLoader().getResource("game/pic/board3.jpg").toExternalForm()));

        back.setFitHeight(97.0);
        back.setFitWidth(57.0);
        back.setLayoutX(36.0);
        back.setLayoutY(508.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getClassLoader().getResource("game/pic/backarrow2.png").toExternalForm()));

        dropShadow.setHeight(120.51);
        dropShadow.setRadius(56.644999999999996);
        dropShadow.setSpread(0.21);
        dropShadow.setWidth(108.07);
        back.setEffect(dropShadow);

        record.setFitHeight(66.0);
        record.setFitWidth(70.0);
        record.setLayoutX(420.0);
        record.setLayoutY(514.0);
        record.setPickOnBounds(true);
        record.setPreserveRatio(true);
        record.setImage(new Image(getClass().getClassLoader().getResource("game/pic/record.png").toExternalForm()));

        reset.setFitHeight(57.0);
        reset.setFitWidth(74.0);
        reset.setLayoutX(800.0);
        reset.setLayoutY(514.0);
        reset.setPickOnBounds(true);
        reset.setPreserveRatio(true);
        reset.setImage(new Image(getClass().getClassLoader().getResource("game/pic/reset.png").toExternalForm()));

        r1c1.setFitHeight(66.0);
        r1c1.setFitWidth(144.0);
        r1c1.setLayoutX(105.0);
        r1c1.setLayoutY(209.0);
        r1c1.setPickOnBounds(true);

        r2c1.setFitHeight(66.0);
        r2c1.setFitWidth(144.0);
        r2c1.setLayoutX(115.0);
        r2c1.setLayoutY(306.0);
        r2c1.setPickOnBounds(true);

        r3c1.setFitHeight(66.0);
        r3c1.setFitWidth(144.0);
        r3c1.setLayoutX(115.0);
        r3c1.setLayoutY(409.0);
        r3c1.setPickOnBounds(true);

        r1c2.setFitHeight(66.0);
        r1c2.setFitWidth(144.0);
        r1c2.setLayoutX(375.0);
        r1c2.setLayoutY(209.0);
        r1c2.setPickOnBounds(true);

        r2c2.setFitHeight(66.0);
        r2c2.setFitWidth(144.0);
        r2c2.setLayoutX(375.0);
        r2c2.setLayoutY(306.0);
        r2c2.setPickOnBounds(true);

        r3c2.setFitHeight(66.0);
        r3c2.setFitWidth(144.0);
        r3c2.setLayoutX(376.0);
        r3c2.setLayoutY(409.0);
        r3c2.setPickOnBounds(true);

        r1c3.setFitHeight(66.0);
        r1c3.setFitWidth(144.0);
        r1c3.setLayoutX(653.0);
        r1c3.setLayoutY(209.0);
        r1c3.setPickOnBounds(true);

        r2c3.setFitHeight(66.0);
        r2c3.setFitWidth(144.0);
        r2c3.setLayoutX(632.0);
        r2c3.setLayoutY(306.0);
        r2c3.setPickOnBounds(true);

        r3c3.setFitHeight(66.0);
        r3c3.setFitWidth(144.0);
        r3c3.setLayoutX(643.0);
        r3c3.setLayoutY(409.0);
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

        player1score.setAlignment(javafx.geometry.Pos.CENTER);
        player1score.setLayoutX(29.0);
        player1score.setLayoutY(105.0);
        player1score.setPrefHeight(40.0);
        player1score.setPrefWidth(70.0);
        player1score.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        player1score.setText("0");
        player1score.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        player1score.setWrapText(true);
        player1score.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        player2score.setAlignment(javafx.geometry.Pos.CENTER);
        player2score.setLayoutX(776.0);
        player2score.setLayoutY(105.0);
        player2score.setPrefHeight(40.0);
        player2score.setPrefWidth(70.0);
        player2score.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        player2score.setText("0");
        player2score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player2score.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        player2score.setWrapText(true);
        player2score.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        xwins.setAlignment(javafx.geometry.Pos.CENTER);
        xwins.setLayoutX(497.0);
        xwins.setLayoutY(524.0);
        xwins.setPrefHeight(47.0);
        xwins.setPrefWidth(156.0);
        xwins.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        xwins.setText("X WINS");
        xwins.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        xwins.setVisible(false);
        xwins.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        owins.setAlignment(javafx.geometry.Pos.CENTER);
        owins.setLayoutX(497.0);
        owins.setLayoutY(519.0);
        owins.setPrefHeight(47.0);
        owins.setPrefWidth(156.0);
        owins.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        owins.setText("O WINS");
        owins.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        owins.setVisible(false);
        owins.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        clap.setFitHeight(318.0);
        clap.setFitWidth(309.0);
        clap.setLayoutX(321.0);
        clap.setLayoutY(157.0);
        clap.setPickOnBounds(true);
        clap.setPreserveRatio(true);
        clap.setVisible(false);
        clap.setImage(new Image(getClass().getClassLoader().getResource("game/pic/clap4.gif").toExternalForm()));

        draw.setAlignment(javafx.geometry.Pos.CENTER);
        draw.setLayoutX(497.0);
        draw.setLayoutY(519.0);
        draw.setPrefHeight(47.0);
        draw.setPrefWidth(156.0);
        draw.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        draw.setText("DRAW");
        draw.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        draw.setVisible(false);
        draw.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        dance.setFitHeight(266.0);
        dance.setFitWidth(338.0);
        dance.setLayoutX(278.0);
        dance.setLayoutY(192.0);
        dance.setPickOnBounds(true);
        dance.setVisible(false);
        dance.setImage(new Image(getClass().getClassLoader().getResource("game/pic/celebrate.gif").toExternalForm()));

        cry.setFitHeight(234.0);
        cry.setFitWidth(304.0);
        cry.setLayoutX(295.0);
        cry.setLayoutY(222.0);
        cry.setPickOnBounds(true);
        cry.setVisible(false);
        cry.setImage(new Image(getClass().getClassLoader().getResource("game/pic/4tyl.gif").toExternalForm()));

        player1label1.setAlignment(javafx.geometry.Pos.CENTER);
        player1label1.setLayoutX(304.0);
        player1label1.setLayoutY(97.0);
        player1label1.setPrefHeight(45.0);
        player1label1.setPrefWidth(250.0);
        player1label1.setStyle("-fx-background-color: #90ee90; -fx-background-radius: 2000;");
        player1label1.setText("Your Turn");
        player1label1.setTextFill(javafx.scene.paint.Color.valueOf("#005127"));
        player1label1.setVisible(false);
        player1label1.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        anchorPane.setDisable(true);
        anchorPane.setLayoutX(208.0);
        anchorPane.setLayoutY(157.0);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(496.0);
        anchorPane.setVisible(false);

        saveback.setFitHeight(209.0);
        saveback.setFitWidth(503.0);
        saveback.setPickOnBounds(true);
        saveback.setImage(new Image(getClass().getClassLoader().getResource("game/pic/Captu11re.PNG").toExternalForm()));

        saveback.setEffect(gaussianBlur0);

        question.setAlignment(javafx.geometry.Pos.CENTER);
        question.setLayoutX(120.0);
        question.setLayoutY(27.0);
        question.setPrefHeight(45.0);
        question.setPrefWidth(250.0);
        question.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        question.setText("Save Game?");
        question.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        question.setFont(new Font("Book Antiqua Bold Italic", 35.0));

        no.setLayoutX(88.0);
        no.setLayoutY(113.0);
        no.setMnemonicParsing(false);
        no.setStyle("-fx-background-color: #adbce6; -fx-background-radius: 2000;");
        no.setText("Yes");
        no.setFont(new Font("System Bold", 29.0));

        yes.setLayoutX(310.0);
        yes.setLayoutY(113.0);
        yes.setMnemonicParsing(false);
        yes.setPrefHeight(63.0);
        yes.setPrefWidth(97.0);
        yes.setStyle("-fx-background-color: #adbce6; -fx-background-radius: 2000;");
        yes.setText("No");
        yes.setFont(new Font("System Bold", 29.0));

        anchorPane0.setDisable(true);
        anchorPane0.setLayoutX(295.0);
        anchorPane0.setLayoutY(206.0);
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(389.0);
        anchorPane0.setVisible(false);

        imageView.setFitHeight(200.0);
        imageView.setFitWidth(406.0);
        imageView.setLayoutX(-10.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getClassLoader().getResource("game/pic/Captu11re.PNG").toExternalForm()));

        imageView.setEffect(gaussianBlur1);

        player1label2.setAlignment(javafx.geometry.Pos.CENTER);
        player1label2.setLayoutX(20.0);
        player1label2.setLayoutY(22.0);
        player1label2.setPrefHeight(49.0);
        player1label2.setPrefWidth(346.0);
        player1label2.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 2000;");
        player1label2.setText("Please Connect DataBase");
        player1label2.setTextFill(javafx.scene.paint.Color.valueOf("#0a5b68"));
        player1label2.setFont(new Font("Book Antiqua Bold Italic", 24.0));

        button.setLayoutX(166.0);
        button.setLayoutY(100.0);
        button.setMnemonicParsing(false);
        button.setStyle("-fx-background-radius: 2000; -fx-background-color: #90ee90;");
        button.setText("OK");
        button.setFont(new Font("System Bold", 24.0));

        getChildren().add(background);
        getChildren().add(board);
        getChildren().add(back);
        getChildren().add(record);
        getChildren().add(reset);
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
        getChildren().add(player1score);
        getChildren().add(player2score);
        getChildren().add(xwins);
        getChildren().add(owins);
        getChildren().add(clap);
        getChildren().add(draw);
        getChildren().add(dance);
        getChildren().add(cry);
        getChildren().add(player1label1);
        anchorPane.getChildren().add(saveback);
        anchorPane.getChildren().add(question);
        anchorPane.getChildren().add(no);
        anchorPane.getChildren().add(yes);
        getChildren().add(anchorPane);
        anchorPane0.getChildren().add(imageView);
        anchorPane0.getChildren().add(player1label2);
        anchorPane0.getChildren().add(button);
        getChildren().add(anchorPane0);

    }
}
