package game;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ArvhievePage extends ScrollPane {

    protected final ScrollPane scrollPane;
    protected final VBox vBox;
    protected final Button button;

    public ArvhievePage() {

        scrollPane = new ScrollPane();
        vBox = new VBox();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        scrollPane.setLayoutX(5.0);
        scrollPane.setLayoutY(-1.0);
        scrollPane.setPrefHeight(400.0);
        scrollPane.setPrefWidth(589.0);

        vBox.setPrefHeight(331.0);
        vBox.setPrefWidth(570.0);

        button.setMnemonicParsing(false);
        button.setPrefHeight(69.0);
        button.setPrefWidth(559.0);
        button.setText("kerooooo : 1           Habiba : 0           Date :  8  / 11 / 1998");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#20307b"));
        button.setFont(new Font(19.0));
        scrollPane.setContent(vBox);

        vBox.getChildren().add(button);
        getChildren().add(scrollPane);

    }
}
