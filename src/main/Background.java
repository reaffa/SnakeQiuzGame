package main;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {
    BufferedImage Heart;

    GamePanel gp;
    public Background(GamePanel gp){
        this.gp = gp;
        getResources();
    }

    public void getResources(){
        try {
            Heart = ImageIO.read(getClass().getResourceAsStream("/misc/Heart.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
