import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {
    
    public GUI(int InArray[][][]){
        //create a test 3d array to display

        int array[][][] = InArray;


        

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Grid App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1600, 1600); // Adjust the size as needed

            GridPanel gridPanel = new GridPanel(100, 100, array);
            frame.add(gridPanel);

            frame.setVisible(true);
        });
    }
}

class GridPanel extends JPanel {
    private int rows;
    private int cols;
    int arr[][][];
    public GridPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int cellWidth = getWidth() / cols;
                int cellHeight = getHeight() / rows;

                int clickedRow = e.getY() / cellHeight;
                int clickedCol = e.getX() / cellWidth;

                System.out.println("Clicked on cell: (" + clickedRow + ", " + clickedCol + ")");
            }
        });
    }    public GridPanel(int rows, int cols, int worldArr[][][]) {
        this.arr = worldArr;
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
                Color  clr   = new Color(arr[j][i][0], arr[j][i][1], arr[j][i][2]);
        

         
                
                g.setColor(clr);
                g.fillRect(x, y, cellWidth, cellHeight);
                
                g.setColor(Color.BLACK);
                

                g.drawRect(x, y, cellWidth, cellHeight);
            }
        }
    }
}
