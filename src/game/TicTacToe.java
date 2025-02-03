package game;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToe extends Pane {
	// Constants
	private int SCREEN_WIDTH = 800;
	private int SCREEN_HEIGHT = 800;
	
	// Objects/variables
	private BorderPane gameScreen;
	private Stage primaryStage;
	private GameController gameController;
	private HBox header;
	Text headerText;
	
	public TicTacToe() {
		// all game objects instantiated here
		gameScreen = new BorderPane();
		gameController = new GameController();
		header = new HBox();
		headerText = new Text("TicTacToe!");

		setupHeader();
		setupPane();
		showGame();
	}
	
	private void setupHeader() {
		// Style objectgs
		header.setAlignment(Pos.CENTER);
		headerText.setFont(new Font(36));

		// Add objects
		header.getChildren().addAll(headerText);
	}

	private void setupPane() {
		gameScreen.setTop(header);
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
