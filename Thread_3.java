import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;

class Ball implements Runnable {
  MainWindow mainWindow;
  int x, y;
  Color ballColor;
  double timing;
  int dX;
  int dY;

  public Ball(MainWindow mainWindow, int x, int y, Color ballColor, double timing, int dX, int dY) {
    this.mainWindow = mainWindow;
    this.x = x;
    this.y = y;
    this.ballColor = ballColor;
    this.timing = timing;
    this.dX = dX;
    this.dY = dY;
  }

  public void run() {
    while (true) {
      try {
        Thread.sleep((int)Math.round(timing + (timing * Math.random() * 0.5)));
      } catch (Exception e) {}
      x = x + dX + (int)Math.round(Math.random() * 10 * (x % 12)) * (x % 7 < 2 ? -1 : 1);
      y = y + dY;
      mainWindow.repaint();
    }
  }

  public void draw(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillOval(x - dX, y - dY, 10, 10);

    g.setColor(ballColor);
    g.fillOval(x, y, 5, 5);
  }
}

class MainWindow extends JFrame {
  Ball[] ball;
  Thread[] thread;

  public MainWindow() {
    ball = new Ball[250];
    //thread = new Thread[ball.length];
    ExecutorService executor = Executors.newFixedThreadPool(ball.length);
    for (int i = 0; i < ball.length; i++) {
      ball[i] = new Ball(this, 8 * (i + 1), 50, Color.RED, (15 * (i + 1)) + 0.1, 0, 10);
      //thread[i] = new Thread(ball[i]);
      //thread[i].start();
      executor.execute(ball[i]);
    }
    setSize(600, 600);
    setVisible(true);
  }

  public void paint(Graphics g) {
    for (int i = 0; i < ball.length; i++) {
      ball[i].draw(g);
    }
  }
}

public class Thread_3 {
  public static void main(String[] args) {
    new MainWindow();
  }
}
