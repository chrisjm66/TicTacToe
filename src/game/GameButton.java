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

    public void setPlayerSelected() {
        this.setText("X");
        this.setDisable(true);
    }

    public boolean isPlayerSelected() {
        return this.getText().equalsIgnoreCase("X");
    }

    public boolean isAiSelected() {
        return this.getText().equalsIgnoreCase("O");
    }

    public boolean isEmpty() {
        return this.getText().equalsIgnoreCase("");
    }

    public void enable() {
        this.setDisable(false);
    }

    public void disable() {
        this.setDisable(true);
    }

    public void reset() {
        this.setText("");
        this.setDisable(false);
    }
}
