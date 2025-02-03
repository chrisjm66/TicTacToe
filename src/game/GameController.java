package game;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.WinChecker;

public class GameController extends VBox {
    // Constants
    private int TILE_WIDTH = 150;
    private int TILE_HEIGHT = 150;

    // Objects
    private Text headerText;
    private GridPane grid;
    private ArrayList<GameButton> gameButtons;
    private Button reset;

    public GameController() {
        headerText = new Text("Click any tile to start a game");
        grid = new GridPane();
        gameButtons = new ArrayList<GameButton>();
        reset = new Button("Reset Game");

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

        // reset button
        reset.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            resetGame();
            headerText.setText("Your Turn");
        });
    }

    private void processButtonClick(GameButton button) {
        button.setPlayerSelected();
        String gameResult = WinChecker.getGameResult(gameButtons);

        switch(gameResult) {
            case "win":
                disableGameButtons();
                headerText.setText("You win!");
                break;
            case "lose":
                disableGameButtons();
                headerText.setText("You lose!");
                break;
            case "tie":
                disableGameButtons();
                headerText.setText("Tie!");
                break;
            case "none":
                int bestMove = WinChecker.getBestMove(gameButtons);
                System.out.println(bestMove);
                gameButtons.get(bestMove).setAISelected();
                headerText.setText("Your turn!");
                break;
        }
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

    private void resetGame() {
        headerText.setText("Your turn!");
        for(int i = 0; i < gameButtons.size(); i++) {
            gameButtons.get(i).reset();
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
        this.getChildren().addAll(headerText, grid, reset);
    }

}
