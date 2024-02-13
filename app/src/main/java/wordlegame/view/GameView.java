package wordlegame.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameView extends JFrame {
    private InputView inputView;
    private GridView gridView;
    private JButton resetButton;

    public GameView(int gameWidth, int gameHeight, int gridRows, int gridCols) {
        initializeFrame(gameWidth, gameHeight);
        initalizeComponents(gridRows, gridCols);
        layoutComponents();
        setVisible(true);
    }

    private void initializeFrame(int w, int h) {
        setTitle("Wordle Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        setSize(w, h);

        // create margin around the frame
        Border margin = BorderFactory.createEmptyBorder(75, 150, 75, 150);
        ((JComponent) getContentPane()).setBorder(margin);
    }

    private void initalizeComponents(int gridRows, int gridCols) {
        inputView = new InputView();
        gridView = new GridView(gridRows, gridCols);
        resetButton = new JButton("Reset Game");
    }

    private void layoutComponents() {
        add(inputView, BorderLayout.NORTH);
        add(gridView, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);
    }

    public void addGuessListener(ActionListener listener) {
        inputView.getSubmitGuessButton().addActionListener(listener);
    }

    public void addResetListener(ActionListener listener) {
        resetButton.addActionListener(listener);
    }

    public void updateGrid(String word, int row, Color[] colours) {
        for (int i = 0; i < word.length(); i++) {
            gridView.setLetterAt(row, i, word.charAt(i), colours[i]);
        }
    }

    public String getUserGuess() {
        return inputView.getInputText();
    }

    public void resetGrid() {
        gridView.clearGrid();
    }

    public void clearInputField() {
        inputView.clearInputField();
    }

    public void setGameStateLabel(String text) {
        inputView.getGameStateLabel().setText(text);
    }

}
