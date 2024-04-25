import javax.swing.*;
import java.awt.*;

public class Block {
    private int x;
    private int y;
    private int width ;
    private int height ;

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    private final ImageIcon imageIcon = new ImageIcon("images/block.png") ;

    public Block() {

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


}
