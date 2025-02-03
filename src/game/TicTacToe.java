package game;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TicTacToe extends Pane {
	// Constants
	private int SCREEN_WIDTH = 800;
	private int SCREEN_HEIGHT = 800;
	
	// Objects/variables
	private BorderPane gameScreen;
	private Stage primaryStage;
	private GameController gameController;
	
	public TicTacToe() {
		gameScreen = new BorderPane();
		gameController = new GameController();

		setupHeader();
		setupGameScreen();
		showGame();
	}
	
	

	private void setupGameScreen() {
		gameScreen.setCenter(gameController);
	}

	private void showGame(){
        Scene scene = new Scene(gameScreen, SCREEN_WIDTH, SCREEN_HEIGHT); // gets passed a BorderPane object
        primaryStage = new Stage();
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene); // set scene as child of stage
        primaryStage.show();
    }
}
