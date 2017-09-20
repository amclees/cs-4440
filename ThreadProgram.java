import javax.swing.*;
import java.awt.*;

class Ball extends Thread {
  MainWindow mainWindow;
  int x, y;

  public Ball(MainWindow mainWindow, int x, int y) {
    this.mainWindow = mainWindow;
    this.x = x;
    this.y = y;
  }

  public void run() {
    while (true) {
      
    }
  }
}

class MainWindow extends JFrame {
  public MainWindow() {
    setSize(600, 600);
    setVisible(true);
  }

  public void paint(Graphics g) {
    int x = 0;
    int y = 0;
    g.setColor(Color.RED);
    g.fillOval(x, y, 50, 50);
    Thread.sleep(500);
    g.setColor(Color.WHITE);
    g.fillOval(x, y, 50, 50);
    y = y + 10;
  }
}

public class ThreadProgram {
  public static void main(String[] args) {
    new MainWindow();
  }
}
