package logic;

import java.util.ArrayList;

import game.GameButton;

public class WinChecker {
    private static boolean checkPlayerWin(ArrayList<GameButton> buttons){
        // check rows
        for(int i = 0; i < 7; i+=3) {
            if(buttons.get(i).isPlayerSelected() && buttons.get(i+1).isPlayerSelected() && buttons.get(i+2).isPlayerSelected()) {
                return true;
            }
        }

        // check columns
        for(int i = 0; i < 3; i++) {
            if(buttons.get(i).isPlayerSelected() && buttons.get(i+3).isPlayerSelected() && buttons.get(i+6).isPlayerSelected()) {
                return true;
            }
        }

        // check diagonals manually
        if(buttons.get(0).isPlayerSelected() && buttons.get(4).isPlayerSelected() && buttons.get(8).isPlayerSelected()) {
            return true;
        } else if (buttons.get(2).isPlayerSelected() && buttons.get(4).isPlayerSelected() && buttons.get(6).isPlayerSelected()) {
            return true;
        }
        return false;
    }

    private static boolean checkPlayerLose(ArrayList<GameButton> buttons){
        // check rows
        for(int i = 0; i < 7; i+=3) {
            if(buttons.get(i).isAiSelected() && buttons.get(i+1).isAiSelected() && buttons.get(i+2).isAiSelected()) {
                return true;
            }
        }

        // check columns
        for(int i = 0; i < 3; i++) {
            if(buttons.get(i).isAiSelected() && buttons.get(i+3).isAiSelected() && buttons.get(i+6).isAiSelected()) {
                return true;
            }
        }

        // check diagonals manually
        if(buttons.get(0).isAiSelected() && buttons.get(4).isAiSelected() && buttons.get(8).isAiSelected()) {
            return true;
        } else if (buttons.get(2).isAiSelected() && buttons.get(4).isAiSelected() && buttons.get(6).isAiSelected()) {
            return true;
        }
        return false;
    }

    private static boolean checkTie(ArrayList<GameButton> buttons) {
        for(int i = 0; i < 9; i++) {
            if (!(buttons.get(i).isAiSelected() || buttons.get(i).isPlayerSelected())) {
                return false;
            }
        }
        return true;
    }

    public static String getGameResult(ArrayList<GameButton> buttons) {
        if (checkPlayerWin(buttons)) {
            return "win";
        } else if (checkPlayerLose(buttons)) {
            return "lose";
        } else if (checkTie(buttons)) {
            return "tie";
        } else {
            return "none";
        }
    }

    // maximizer: player
    public static int getBestMove(ArrayList<GameButton> buttons) {
        int bestMove = -1;
        int bestValue = 1000;

        for (int i = 0; i < 9; i++) {
            GameButton button = buttons.get(i);
            if (button.isEmpty()) {
                 // the buttons get selected so the alg can see what the result would be with this button selected
                button.setAISelected();
                int currentMoveValue = minimax(buttons, 0, false);
                button.reset();

                if (currentMoveValue < bestValue) {
                    bestMove = i;
                    bestValue = currentMoveValue;
                }
            }
        }
        System.out.println("Best Move: " + bestMove);
        System.out.println("Best Val: " + bestValue);
        return bestMove;
    }

    private static int minimax(ArrayList<GameButton> buttons, int depth, boolean isMaximizer) {
        if (checkPlayerWin(buttons)) {
            System.out.println("max");
            return 10;
        } else if (checkPlayerLose(buttons)) {
            System.out.println("min");
            return -10;
        } else if (checkTie(buttons)) {
            System.out.println("tie");
            return 0;
        }
        
        if(isMaximizer) {
            int best = -1000;
            for (int i = 0; i < 9; i++) {
                GameButton button = buttons.get(i);
                if(button.isEmpty()) {
                    // the buttons get selected so the alg can see what the result would be with this button selected
                    button.setAISelected();
                    System.out.println("minimax " + i + " depth " + depth + "best " + best);
                    best = Math.max(best, minimax(buttons, depth + 1, !isMaximizer));
                    button.reset();
                }
            }
            return best;
        } else {
            int best = 1000;
            for (int i = 0; i < 9; i++) {
                GameButton button = buttons.get(i);
                if(button.isEmpty()) {
                    // the buttons get selected so the alg can see what the result would be with this button selected
                    button.setPlayerSelected();
                    System.out.println("minimax " + i + " depth " + depth + "best " + best);
                    best = Math.min(best, minimax(buttons, depth + 1, !isMaximizer));
                    button.reset();
                }
            }
            return best;
        }


    }


}
