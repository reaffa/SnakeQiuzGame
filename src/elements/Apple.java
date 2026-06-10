package elements;

import main.GamePanel;
import snake.Snake;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Apple{
    BufferedImage ApplePng;
    GamePanel gp;
    Snake snake;
    public int x,y;
    Random random = new Random();

    public Apple(GamePanel gp, Snake snake){
        this.gp = gp;
        this.snake = snake;
        respawn();
    }

    public void getAppleImage() {

        try {

            ApplePng = ImageIO.read(getClass().getResourceAsStream("/misc/Apple.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void respawn(){
        boolean c = true;
        while(c) {
            int RandCol = random.nextInt(16);
            int RandRow = random.nextInt(8);
//            int ColGapsCount;
//            int RowGapsCount;
//            if (RandCol == 0) {
//                ColGapsCount = 0;
//            } else {
//                ColGapsCount = RandCol;
//            }
//            if (RandRow == 0) {
//                RowGapsCount = 0;
//            } else {
//                RowGapsCount = RandRow;
//            }
//            RandCol == 0 ? ColGapsCount = 0 : ColGapsCount = RandCol - 1;
//            RandRow == 0 ? RowGapsCount = 0 : RowGapsCount = RandCol - 1;
            this.x = gp.screenHeightCheckboardOffset + gp.snakeSquareSide * RandCol - gp.squareDistance;
            this.y = gp.screenHeightCheckboardOffset + gp.snakeSquareSide * RandRow - gp.squareDistance;
            for (int i = 0; i < snake.body.size(); i++) {
                Point p = snake.body.get(i);
                if (!((this.x > p.x - 7 && this.x < p.x + 7) && (this.y > p.y - 7 && this.y < p.y + 7))) {
                    if (!(gp.screenWidthCheckboardOffset - gp.tileSize > x || gp.screenWidth - (gp.screenWidth - gp.screenWidthCheckboardOffset) / 2 + gp.tileSize < x)){
                        c = false;
                    }
                }
            }
        }

    }

    public void draw(Graphics2D g2){
        getAppleImage();
        g2.drawImage(ApplePng, this.x - 5, this.y + 6, gp.snakeSquareSide, gp.snakeSquareSide,null);
    }

}