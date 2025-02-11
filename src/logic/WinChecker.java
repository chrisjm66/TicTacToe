package logic;

import java.util.ArrayList;

import game.GameButton;

public class WinChecker {
    private static boolean checkPlayerWin(ArrayList<GameButton> buttons){
       // TODO
        return false;
    }

    private static boolean checkPlayerLose(ArrayList<GameButton> buttons){
        // TODO
        return false;
    }

    private static boolean checkTie(ArrayList<GameButton> buttons) {
        // TODO
        return false;
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
