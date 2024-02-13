package wordlegame.controller;

import wordlegame.model.GameModel;
import wordlegame.view.GameView;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
        view.addGuessListener(e -> processGuess());
        view.addResetListener(e -> resetGame());
    }

    private void processGuess() {
        if (model.isGameOver() || model.isGameWon()) {
            resetGame();
        }

        model.setUserGuess(view.getUserGuess());
        if (model.isGuessValid()) {
            view.updateGrid(model.getCurrentGuess(), model.getUserGuessCount(), model.getLetterColours());
            view.clearInputField();
            model.incrementUserGuessCount();
            checkGameState();
        } else {
            view.setGameStateLabel("Invalid word, try again!");
            view.clearInputField();
        }
    }

    private void resetGame() {
        model.initGame();
        view.resetGrid();
    }

    private void checkGameState() {
        if (model.isGameWon()) {
            view.setGameStateLabel("Congratuations, you win!");
        } else if (model.isGameOver()) {
            view.setGameStateLabel("Game over! The word was " + model.getGameWord());
        }
    }
}
