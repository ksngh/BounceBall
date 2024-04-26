import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

public class GamePanel extends JPanel implements Runnable {


    long groundMsec = System.currentTimeMillis();
    long msec = System.currentTimeMillis();
    Thread thread;
    int tempY = 550;
    private boolean isLeft, isRight;
    static int GAME_WIDTH = 1280;
    static int GAME_HEIGHT = 640;
    private Map map = new Map();
    private Flag flag = new Flag();

    private Ball ball = new Ball();

    public GamePanel() {

        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setLeft(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    setRight(true);
                }
            }


            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setLeft(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    setRight(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    ball.setX(150);
                    ball.setY(550);
                    Thread thread;
                    thread = new Thread(GamePanel.this);
                    thread.start();
                }
            }
        });
        thread = new Thread(GamePanel.this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.
                setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.draw(g);
        map.makeBlock(g);
        flag.makeFlag(g);
    }


    public boolean isLeft() {
        return isLeft;
    }

    public boolean isRight() {
        return isRight;
    }

    private void setLeft(boolean left) {
        isLeft = left;
    }

    private void setRight(boolean right) {
        isRight = right;
    }

    private void keyProcess() {

        if (isRight()) {
            ball.setSpeedX(7);
        }
        if (isLeft()) {
            ball.setSpeedX(-7);
        }

    }

    private void ballMove() {
        msec = System.currentTimeMillis();
        ball.setX(ball.getSpeedX() + ball.getX());
        double degree = (msec - groundMsec) * 3.14 * 0.002;
        if (degree > 3.14) {
            ball.setSpeedY(ball.getSpeedY() + 10);
        } else {
            ball.setSpeedY(-120 * Math.abs(Math.sin(degree)));
        }
        ball.setY(tempY + ball.getSpeedY());
        if (ball.getY()>1000){
            thread.interrupt();
        }
    }



    private boolean hitObject(Rectangle rect01, Rectangle rect02) {
        return rect01.intersects(rect02);
    }

    private void crushBlock() {
        for (int i = 0; i < map.col; i++) {
            for (int j = 0; j < map.row; j++) {
                if (map.checkBlock[i][j]) {
                    map.blocks[i][j] = new Block();
                    map.blocks[i][j].setX((Map.BLOCK_WIDTH) * j);
                    map.blocks[i][j].setY((Map.BLOCK_HEIGHT) * i );
                    map.blocks[i][j].setWidth(Map.BLOCK_WIDTH);
                    map.blocks[i][j].setHeight(Map.BLOCK_HEIGHT);

                    if (hitObject(
                            new Rectangle(ball.getX(), (int) ball.getY(), ball.getRadius(), ball.getRadius()),
                            new Rectangle(map.blocks[i][j].getX(), map.blocks[i][j].getY(), map.blocks[i][j].getWidth(), map.blocks[i][j].getHeight()))) {
                        if (map.blocks[i][j].getY()-(map.blocks[i][j].getHeight())/2.0 <= ball.getY()+ball.getRadius()){
                            tempY = (int) ball.getY();
                            groundMsec = System.currentTimeMillis();
                        }
                        if (ball.getSpeedX() > 0) ball.setSpeedX(-2);
                        else ball.setSpeedX(2);
                    }
                }
            }
        }
    }

    private void finish(){
        if (hitObject(
                new Rectangle(ball.getX(), (int) ball.getY(), ball.getRadius(), ball.getRadius()),
                new Rectangle(flag.getX(), flag.getY(),flag.getWidth(),flag.getHeight()))){
                        thread.interrupt();
                }
    }


    @Override
    public void run() {
        while (true) {
            keyProcess();
            ballMove();
            crushBlock();
            repaint();
            finish();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
