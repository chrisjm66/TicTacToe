package game;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameController extends VBox {
    // Constants
    private int TILE_WIDTH = 150;
    private int TILE_HEIGHT = 150;

    // Objects
    private Text headerText;
    private GridPane grid;
    private Button[] gameButtons;

    public GameController() {
        headerText = new Text("Click any tile to start a game");
        grid = new GridPane();
        gameButtons = new Button[9];

        setupGameButtons();
        setupVBox();
    }

    private void setupGameButtons() {
        for(int i = 0; i < gameButtons.length; i++){
            gameButtons[i] = new Button("X");
            gameButtons[i].setPrefWidth(TILE_WIDTH);
            gameButtons[i].setPrefHeight(TILE_HEIGHT);
            gameButtons[i].setFont(Font.font(100));
            gameButtons[i].setFocusTraversable(false);
            

            grid.add(gameButtons[i], i % 3, i / 3);
        }
    }

    private void setupVBox() {
        // Apply styles
        
        headerText.setFont(Font.font(24));
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        grid.setPrefHeight(500);
        grid.setPrefWidth(500);

        // Add objects
        this.getChildren().addAll(headerText, grid);
    }
}
