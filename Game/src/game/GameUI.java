package game;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class GameUI extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final GridPane gridPane1;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final ColumnConstraints columnConstraints6;
    protected final RowConstraints rowConstraints4;
    protected final Button button8;
    protected final Button reset;
    protected final Button Back;
    

    public GameUI() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        
        
        gridPane0 = new GridPane();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        gridPane1 = new GridPane();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        columnConstraints6 = new ColumnConstraints();
        rowConstraints4 = new RowConstraints();
        button8 = new Button();
        reset = new Button();
        Back = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setHgap(5.0);
        gridPane.setVgap(5.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        button.setMaxHeight(Double.MAX_VALUE);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMnemonicParsing(false);
        button.setFont(new Font("System Bold", 35.0));

        GridPane.setColumnIndex(button0, 1);
        button0.setMaxHeight(Double.MAX_VALUE);
        button0.setMaxWidth(Double.MAX_VALUE);
        button0.setMnemonicParsing(false);
        button0.setFont(new Font("System Bold", 35.0));

        GridPane.setColumnIndex(button1, 2);
        button1.setMaxHeight(Double.MAX_VALUE);
        button1.setMaxWidth(Double.MAX_VALUE);
        button1.setMnemonicParsing(false);
        button1.setFont(new Font("System Bold", 35.0));

        GridPane.setRowIndex(button2, 1);
        button2.setMaxHeight(Double.MAX_VALUE);
        button2.setMaxWidth(Double.MAX_VALUE);
        button2.setMnemonicParsing(false);
        button2.setFont(new Font("System Bold", 35.0));

        GridPane.setColumnIndex(button3, 1);
        GridPane.setRowIndex(button3, 1);
        button3.setMaxHeight(Double.MAX_VALUE);
        button3.setMaxWidth(Double.MAX_VALUE);
        button3.setMnemonicParsing(false);
        button3.setFont(new Font("System Bold", 35.0));

        GridPane.setColumnIndex(button4, 2);
        GridPane.setRowIndex(button4, 1);
        button4.setMaxHeight(Double.MAX_VALUE);
        button4.setMaxWidth(Double.MAX_VALUE);
        button4.setMnemonicParsing(false);
        button4.setFont(new Font("System Bold", 35.0));

        GridPane.setRowIndex(button5, 2);
        button5.setMaxHeight(Double.MAX_VALUE);
        button5.setMaxWidth(Double.MAX_VALUE);
        button5.setMnemonicParsing(false);
        button5.setFont(new Font("System Bold", 35.0));

        GridPane.setColumnIndex(button6, 1);
        GridPane.setRowIndex(button6, 2);
        button6.setMaxHeight(Double.MAX_VALUE);
        button6.setMaxWidth(Double.MAX_VALUE);
        button6.setMnemonicParsing(false);
        button6.setFont(new Font("System Bold", 35.0));

        GridPane.setColumnIndex(button7, 2);
        GridPane.setRowIndex(button7, 2);
        button7.setMaxHeight(Double.MAX_VALUE);
        button7.setMaxWidth(Double.MAX_VALUE);
        button7.setMnemonicParsing(false);
        button7.setFont(new Font("System Bold", 35.0));
        BorderPane.setMargin(gridPane, new Insets(25.0));
        setCenter(gridPane);

        BorderPane.setAlignment(gridPane0, javafx.geometry.Pos.CENTER);
        gridPane0.setPrefHeight(62.0);
        gridPane0.setPrefWidth(567.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(396.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(272.0);

        columnConstraints3.setHalignment(javafx.geometry.HPos.RIGHT);
        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(295.33331298828125);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(278.0);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label.setPrefHeight(24.0);
        label.setPrefWidth(294.0);
        label.setText(" ");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.WHITE);

        GridPane.setRowIndex(label0, 1);
        label0.setPrefHeight(26.0);
        label0.setPrefWidth(299.0);
        label0.setText("Score");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#f5f2f2"));

        GridPane.setColumnIndex(label1, 1);
        label1.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        label1.setPrefHeight(23.0);
        label1.setPrefWidth(226.0);
        label1.setText(" ");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label1.setTextFill(javafx.scene.paint.Color.WHITE);

        GridPane.setColumnIndex(label2, 1);
        GridPane.setRowIndex(label2, 1);
        label2.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        label2.setPrefHeight(26.0);
        label2.setPrefWidth(300.0);
        label2.setText("score ");
        label2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#f5f2f2"));
        BorderPane.setMargin(gridPane0, new Insets(0.0, 25.0, 0.0, 25.0));
        setTop(gridPane0);

        BorderPane.setAlignment(gridPane1, javafx.geometry.Pos.CENTER);
        gridPane1.setPrefHeight(30.0);
        gridPane1.setPrefWidth(558.0);

        columnConstraints4.setHalignment(javafx.geometry.HPos.LEFT);
        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(406.3333740234375);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(129.33334350585938);

        columnConstraints5.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(406.3333740234375);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(346.6666564941406);

        columnConstraints6.setHalignment(javafx.geometry.HPos.RIGHT);
        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMaxWidth(314.0);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPrefWidth(123.66668701171875);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(button8, 1);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(25.0);
        button8.setPrefWidth(121.0);
        button8.setText("Record ");
        button8.setFont(new Font(14.0));

        GridPane.setColumnIndex(reset, 2);
        reset.setMaxWidth(USE_PREF_SIZE);
        reset.setMnemonicParsing(false);
        reset.setPrefHeight(30.0);
        reset.setPrefWidth(121.0);
        reset.setText("Restart");
        reset.setFont(new Font(14.0));

        Back.setMnemonicParsing(false);
        Back.setPrefHeight(25.0);
        Back.setPrefWidth(121.0);
        Back.setText("Back");
        Back.setFont(new Font(15.0));
        BorderPane.setMargin(gridPane1, new Insets(0.0, 25.0, 25.0, 25.0));
        setBottom(gridPane1);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(button);
        gridPane.getChildren().add(button0);
        gridPane.getChildren().add(button1);
        gridPane.getChildren().add(button2);
        gridPane.getChildren().add(button3);
        gridPane.getChildren().add(button4);
        gridPane.getChildren().add(button5);
        gridPane.getChildren().add(button6);
        gridPane.getChildren().add(button7);
        gridPane0.getColumnConstraints().add(columnConstraints2);
        gridPane0.getColumnConstraints().add(columnConstraints3);
        gridPane0.getRowConstraints().add(rowConstraints2);
        gridPane0.getRowConstraints().add(rowConstraints3);
        gridPane0.getChildren().add(label);
        gridPane0.getChildren().add(label0);
        gridPane0.getChildren().add(label1);
        gridPane0.getChildren().add(label2);
        gridPane1.getColumnConstraints().add(columnConstraints4);
        gridPane1.getColumnConstraints().add(columnConstraints5);
        gridPane1.getColumnConstraints().add(columnConstraints6);
        gridPane1.getRowConstraints().add(rowConstraints4);
        gridPane1.getChildren().add(button8);
        gridPane1.getChildren().add(reset);
        gridPane1.getChildren().add(Back);
        
        
        setStyle("-fx-background-color: #333333;");
 

    }
}
    
