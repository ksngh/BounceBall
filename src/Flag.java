import javax.swing.*;
import java.awt.*;

public class Flag {
    private int x = 1200;
    private int y = 240;
    private int width=64;
    private int height=64;

    private final ImageIcon imageIcon = new ImageIcon("images/flag.png");

    public void makeFlag(Graphics g) {
        g.drawImage(imageIcon.getImage(), x, y, null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }
}
