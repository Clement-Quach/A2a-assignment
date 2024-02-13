import javax.swing.*;
import java.awt.*;

public class GUI {
    
    public static void main(String[] args) {
        //create a test 3d array to display
        int col = 100;
        int row = 100;
        int array[][][] = new int[col][row][3];

        for(int y = 0; y < row; y++){
            for (int x = 0; x < col; x++){
                int nm = RandomGenerator.nextNumber(100);
                if(nm < 30){
                    array[x][y][0] = 0;
                    array[x][y][1] = 255;
                    array[x][y][2] = 0;

                } else if ( nm >= 30 && nm < 45){
                    array[x][y][0] = 255;
                    array[x][y][1] = 255;
                    array[x][y][2] = 0;

                } else {
                    array[x][y][0] = 255;
                    array[x][y][1] = 255;
                    array[x][y][2] = 255;
                }
            }
        }
 
    
       
            

        

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
    public GridPanel(int rows, int cols, int worldArr[][][]) {
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
