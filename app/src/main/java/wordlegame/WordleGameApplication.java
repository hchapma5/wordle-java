package wordlegame;

import wordlegame.controller.GameController;
import wordlegame.model.GameModel;
import wordlegame.view.GameView;

import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;

public class WordleGameApplication {
    private static int CLIENT_WIDTH = 800;
    private static int CLIENT_HEIGHT = 800;

    public static void main(String[] args) {
        FlatCarbonIJTheme.setup();
        GameModel model = new GameModel();
        GameView view = new GameView(
                CLIENT_WIDTH,
                CLIENT_HEIGHT,
                model.getMaxGuesses(),
                model.getWordLength());
        new GameController(model, view);
    }
}
