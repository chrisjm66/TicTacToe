package game;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class GameButton extends Button {
    public GameButton(int width, int height) {
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setMinHeight(height);
        this.setMinWidth(width);
        this.setFont(Font.font(70));
        this.setFocusTraversable(false);
    }

    public void setAISelected() {
        this.setText("O");
        this.setDisable(true);
    }

    public void enable() {
        this.setDisable(false);
    }

    public void disable() {
        this.setDisable(true);
    }
}
