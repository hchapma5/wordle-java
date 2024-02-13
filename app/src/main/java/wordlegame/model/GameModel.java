package wordlegame.model;

import java.awt.Color;

public class GameModel {
    private final int MAX_GUESSES = 6;
    private final int WORD_LENGTH = 5;
    private final Color CORRECT_LETTER_COLOUR = new Color(46, 139, 87);
    private final Color INCORRECT_INDEX_COLOUR = new Color(252, 245, 95);
    private final Color INCORRECT_LETTER_COLOUR = new Color(232, 228, 214);

    private String gameWord;
    private WordDictionary dictionary;
    public int userGuessCount;
    public String currentGuess;

    public GameModel() {
        this.dictionary = new WordDictionary();
        initGame();
    }

    public void initGame() {
        gameWord = dictionary.getRandomWord();
        userGuessCount = 0;
        currentGuess = "";
    }

    public void setUserGuess(String guess) {
        currentGuess = guess.toLowerCase();
    }

    public void incrementUserGuessCount() {
        userGuessCount++;
    }

    public int getWordLength() {
        return WORD_LENGTH;
    }

    public int getMaxGuesses() {
        return MAX_GUESSES;
    }

    public boolean isGuessValid() {
        return dictionary.isValid(currentGuess);
    }

    public boolean isGameOver() {
        return userGuessCount == MAX_GUESSES;
    }

    public boolean isGameWon() {
        return currentGuess.equals(gameWord);
    }

    public String getGameWord() {
        return gameWord;
    }

    public String getCurrentGuess() {
        return currentGuess;
    }

    public int getUserGuessCount() {
        return userGuessCount;
    }

    private boolean[] correctLetters() {
        boolean[] correctIndexes = new boolean[WORD_LENGTH];
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (currentGuess.charAt(i) == gameWord.charAt(i)) {
                correctIndexes[i] = true;
            } else {
                correctIndexes[i] = false;
            }
        }
        return correctIndexes;
    }

    private boolean[] correctLettersIncorrectIndexes() {
        boolean[] correctIndexes = correctLetters();
        boolean[] incorrectIndexes = new boolean[WORD_LENGTH];
        StringBuilder newGameWord = new StringBuilder(gameWord);
        for (int i = 0; i < correctIndexes.length; i++) {
            if (correctIndexes[i] == true) {
                newGameWord.setCharAt(i, ' ');
            }
        }
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (newGameWord.toString().contains(String.valueOf(currentGuess.charAt(i)))
                    && gameWord.charAt(i) != currentGuess.charAt(i)) {
                incorrectIndexes[i] = true;
            } else {
                incorrectIndexes[i] = false;
            }
        }
        return incorrectIndexes;
    }

    public Color[] getLetterColours() {
        boolean[] correctIndexes = correctLetters();
        boolean[] incorrectIndexes = correctLettersIncorrectIndexes();
        Color[] letterColours = new Color[WORD_LENGTH];
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (correctIndexes[i] == true) {
                letterColours[i] = CORRECT_LETTER_COLOUR;
            } else if (incorrectIndexes[i] == true) {
                letterColours[i] = INCORRECT_INDEX_COLOUR;
            } else {
                letterColours[i] = INCORRECT_LETTER_COLOUR;
            }
        }
        return letterColours;
    }
}