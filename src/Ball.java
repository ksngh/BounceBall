import javax.swing.*;
import java.awt.*;

import static java.awt.Transparency.OPAQUE;

public class Ball {
    private int x;
    private double y;
    private int radius, width = 32, height = 32;
    private int speedX;
    private double speedY;

    private ImageIcon imageIcon = new ImageIcon("images/ball.png");

    public Ball() {
        this.x=100;
        this.y=550;
        this.radius = 16;
        this.speedX= 5;
        this.speedY= (5*Math.sin(y));
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRoundRect(x, (int)y, imageIcon.getIconWidth(), imageIcon.getIconHeight(), 20, 20);
        g.drawImage(imageIcon.getImage(), x,(int)y,null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

}