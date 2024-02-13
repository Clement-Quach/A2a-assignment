import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Game {



 public static void main(String[] args) {
  World world = new World(100,100);

  
  
  
  GUI gui = new GUI(world.getCellArr());




 }
}