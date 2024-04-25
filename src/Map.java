import java.awt.*;

public class Map {
    static final int BLOCK_WIDTH = 64;
    static final int BLOCK_HEIGHT = 64;
    int col = 10 ;
    int row = 20;
    public Block[][] blocks = new Block[col][row];

    boolean[][] checkBlock = new boolean[col][row];

    public Map(){
        checkBlock[9][0] = true;
        checkBlock[9][1] = true;
        checkBlock[9][2] = true;
        checkBlock[9][3] = true;
        checkBlock[8][0] = true;
        checkBlock[8][3] = true;
        checkBlock[7][0] = true;
        checkBlock[6][0] = true;
        checkBlock[7][5] = true;
        checkBlock[7][6] = true;
        checkBlock[6][8] = true;
        checkBlock[6][9] = true;
        checkBlock[5][9] = true;
        checkBlock[6][12] = true;
        checkBlock[7][15] = true;
        checkBlock[7][16] = true;
        checkBlock[6][17] = true;
        checkBlock[5][18] = true;
        checkBlock[5][19] = true;
    }

    public void makeBlock(Graphics g) {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                blocks[i][j] = new Block();
                if (checkBlock[i][j]){
                    blocks[i][j].setX((BLOCK_WIDTH) * j);
                    blocks[i][j].setY((BLOCK_HEIGHT) * i);
                    blocks[i][j].setWidth(BLOCK_WIDTH);
                    blocks[i][j].setHeight(BLOCK_HEIGHT);
                    g.drawImage(blocks[i][j].getImageIcon().getImage(), blocks[i][j].getX(), blocks[i][j].getY(), null);
                }
            }
        }
    }

}

