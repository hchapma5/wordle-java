package wordlegame.view;

import javax.swing.*;

import java.awt.*;

public class GridView extends JPanel {
    private final int rows;
    private final int columns;
    private final JPanel[][] letterPanels;

    public GridView(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.letterPanels = new JPanel[rows][columns];
        setLayout(new GridLayout(rows, columns, 10, 10)); // Add some space between cells
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.setLayout(new BorderLayout());
                panel.setBackground(new Color(232, 228, 214));
                letterPanels[i][j] = panel;
                add(panel);
            }
        }
    }

    public void setLetterAt(int row, int col, char letter, Color colour) {
        JPanel panel = letterPanels[row][col];
        panel.removeAll(); 
        JLabel label = new JLabel(String.valueOf(letter).toUpperCase(), SwingConstants.CENTER);
        label.setOpaque(true);
        label.setFont(new Font("serif", Font.BOLD, 24));
        label.setForeground(Color.BLACK);
        label.setBackground(colour);
        panel.add(label, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }

    public void clearGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                letterPanels[i][j].removeAll();
                letterPanels[i][j].revalidate();
                letterPanels[i][j].repaint();
            }
        }
    }
}
