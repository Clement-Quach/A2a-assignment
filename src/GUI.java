import javax.swing.*;
import java.awt.*;

public class GUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Grid App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800); // Adjust the size as needed

            GridPanel gridPanel = new GridPanel(100, 100);
            frame.add(gridPanel);

            frame.setVisible(true);
        });
    }
}

class GridPanel extends JPanel {
    private int rows;
    private int cols;

    public GridPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellWidth = getWidth() / cols;
        int cellHeight = getHeight() / rows;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int x = j * cellWidth;
                int y = i * cellHeight;
                Color  green   = new Color(0, 255,  0);
                Color definietlyYellow = new Color(255, 255, 100);

                if(j % 3 == 0){
                    g.setColor(definietlyYellow);
                } else if (j % 5 == 0){
                    g.setColor(green);

                }

                g.drawRect(x, y, cellWidth, cellHeight);
            }
        }
    }
}
