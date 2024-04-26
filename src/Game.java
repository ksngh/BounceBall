import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    GamePanel gamePanel = new GamePanel();
    public Game() throws HeadlessException {
        this.setTitle("BOUNCEBALL");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(gamePanel);
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Game();
    }
}
