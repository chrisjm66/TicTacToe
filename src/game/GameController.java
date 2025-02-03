package game;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
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
    private ArrayList<GameButton> gameButtons;

    public GameController() {
        headerText = new Text("Click any tile to start a game");
        grid = new GridPane();
        gameButtons = new ArrayList<GameButton>();

        setupGameButtons();
        setupVBox();
    }

    private void setupGameButtons() {
        for(int i = 0; i < 9; i++){
            gameButtons.add(new GameButton(TILE_WIDTH, TILE_HEIGHT)); 
            GameButton button = gameButtons.get(i);
            grid.add(button, i % 3, i / 3);

            button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                processButtonClick(button);
            });
        }
    }

    private void processButtonClick(GameButton button) {
        button.setText("X");
        headerText.setText("AI Thinking...");
        disableGameButtons();
            
        wait(2);

        enableGameButtons();
    }

    private void disableGameButtons() {
        for(int i = 0; i < gameButtons.size(); i++) {
            gameButtons.get(i).disable();
        }
    }

    private void enableGameButtons() {
        for(int i = 0; i < gameButtons.size(); i++) {
            if (gameButtons.get(i).getText().equals("")) {
                gameButtons.get(i).enable();
            } else {
                gameButtons.get(i).disable();
            }
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

    public static void wait(int s)
    {
        try
        {
            TimeUnit.SECONDS.sleep(s);
        }
        catch(InterruptedException ex)
        {
            
        }
    }
}
