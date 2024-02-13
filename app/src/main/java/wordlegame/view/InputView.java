package wordlegame.view;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InputView extends JPanel {
    private JTextField inputField;
    private JLabel promptLabel;
    private JLabel gameStateLabel;
    private JButton submitGuessButton;
    
    public InputView() {
        setLayout(new BorderLayout(10, 10));
        initializeComponents();
        styleComponents();
        setupEnterKeyAction();
        layoutComponents();
    }

    private void initializeComponents() {
        inputField = new JTextField();
        promptLabel = new JLabel("Word: ");
        gameStateLabel = new JLabel(" ");
        submitGuessButton = new JButton("Enter");
    }

    private void styleComponents() {
        Font font = new Font("Serif", Font.BOLD, 14);
        JComponent[] components = {inputField, promptLabel, gameStateLabel, submitGuessButton};
        for (JComponent component : components) {
            component.setFont(font);
        }
    }

    private void setupEnterKeyAction() {
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitGuessButton.doClick();
            }
        };
        submitGuessButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        submitGuessButton.getActionMap().put("Enter", action);
    }

    private void layoutComponents() {
        add(gameStateLabel, BorderLayout.NORTH);
        add(promptLabel, BorderLayout.WEST);
        add(inputField, BorderLayout.CENTER);
        add(submitGuessButton, BorderLayout.EAST);
    }

    public String getInputText() {
        return inputField.getText();
    }

    public void clearInputField() {
        inputField.setText("");
    }

    public JLabel getGameStateLabel() {
        return gameStateLabel;
    }

    public JButton getSubmitGuessButton() {
        return submitGuessButton;
    }
}
