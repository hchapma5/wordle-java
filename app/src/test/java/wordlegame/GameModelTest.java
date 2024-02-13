package wordlegame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wordlegame.model.GameModel;

import static org.junit.jupiter.api.Assertions.*;

class GameModelTest {
    private GameModel gameModel;

    @BeforeEach
    void setUp() {
        gameModel = new GameModel();
    }

    @Test
    void initGame() {
        gameModel.initGame();
        assertEquals(0, gameModel.getUserGuessCount());
        assertEquals("", gameModel.getCurrentGuess());
    }

    @Test
    void setUserGuess() {
        String guess = "apple";
        gameModel.setUserGuess(guess);
        assertEquals(guess, gameModel.getCurrentGuess());
    }

    @Test
    void incrementUserGuessCount() {
        gameModel.incrementUserGuessCount();
        assertEquals(1, gameModel.getUserGuessCount());
    }

    @Test
    void getWordLength() {
        assertEquals(5, gameModel.getWordLength());
    }

    @Test
    void getMaxGuesses() {
        assertEquals(6, gameModel.getMaxGuesses());
    }

    @Test
    void isGuessValid() {
        gameModel.setUserGuess("apple");
        assertTrue(gameModel.isGuessValid());
    }

    @Test
    void isGameOver() {
        gameModel.setUserGuess("apple");
        assertFalse(gameModel.isGameOver());
        for (int i = 0; i < gameModel.getMaxGuesses(); i++) {
            gameModel.incrementUserGuessCount();
        }
        assertTrue(gameModel.isGameOver());
    }

    @Test
    void isGameWon() {
        gameModel.setUserGuess("apple");
        assertFalse(gameModel.isGameWon());
        gameModel.setUserGuess(gameModel.getGameWord());
        assertTrue(gameModel.isGameWon());
    }

    @Test
    void getGameWord() {
        assertNotNull(gameModel.getGameWord());
    }

    @Test
    void getCurrentGuess() {
        assertNotNull(gameModel.getCurrentGuess());
    }

    @Test
    void getUserGuessCount() {
        assertEquals(0, gameModel.getUserGuessCount());
    }

    @Test
    void getLetterColours() {
        gameModel.setUserGuess("apple");
        assertNotNull(gameModel.getLetterColours());
        assertEquals(gameModel.getWordLength(), gameModel.getLetterColours().length);
    }
}