package snake;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Snake {
    public int x, y;
    public int speed;

    public BufferedImage UpPng, DownPng, LeftPng, RightPng, BodyPngLight, BodyPngDark;
    public char Direction;

    boolean shouldGrow = false;
    GamePanel gp;
    KeyHandler keyHandler;
    public ArrayList<Point> body = new ArrayList<>();

    public Snake(GamePanel gp, KeyHandler keyHandler){

        this.gp = gp;
        this.keyHandler = keyHandler;
        SetDefaultValues();
        getSnakeImage();
    }
    public void SetDefaultValues(){
        body.clear();
        Direction = 'U';
        x = gp.screenWidthCheckboardOffset + gp.tileSize * 4 + 3 * gp.squareDistance + 6;
        y = gp.screenHeightCheckboardOffset + gp.tileSize * 4 + 3 * gp.squareDistance + 6;
//        x = (gp.screenWidth - gp.tileSize - gp.squareDistance)/ 2;
//        y = (gp.screenHeight - gp.tileSize - gp.squareDistance) / 2;
        speed = gp.tileSize + gp.squareDistance;
        body.add(new Point(x, y));
        body.add(new Point(x, y + gp.snakeSquareSide));
        body.add(new Point(x, y + gp.snakeSquareSide*2));

//        body.add(new Point(x, y + gp.snakeSquareSide*3));
//        body.add(new Point(x, y + gp.snakeSquareSide*4));
    }
    public void getSnakeImage(){

        try {

            UpPng = ImageIO.read(getClass().getResourceAsStream("/snake/SnakeHeadUp.png"));
            DownPng = ImageIO.read(getClass().getResourceAsStream("/snake/SnakeHeadDown.png"));
            LeftPng = ImageIO.read(getClass().getResourceAsStream("/snake/SnakeHeadLeft.png"));
            RightPng = ImageIO.read(getClass().getResourceAsStream("/snake/SnakeHeadRight.png"));
            BodyPngLight = ImageIO.read(getClass().getResourceAsStream("/snake/SnakeBody1.png"));
            BodyPngDark = ImageIO.read(getClass().getResourceAsStream("/snake/SnakeBody2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyHandler.upPressed && Direction != 'D'){
            Direction = 'U';
        }
        else if(keyHandler.downPressed && Direction != 'U'){
            Direction = 'D';
        }
        else if(keyHandler.leftPressed && Direction != 'R'){
            Direction = 'L';
        }
        else if(keyHandler.rightPressed && Direction != 'L'){
            Direction = 'R';
        }
        switch (Direction){
            case 'U':
                y -= speed;
                break;
            case 'D':
                y += speed;
                break;
            case 'L':
                x -= speed;
                break;
            case 'R':
                x += speed;
                break;
        }
        // 3. Add the NEW head position to the start of the list
        body.add(0, new Point(x, y));
        // 4. Remove the tail (This keeps the snake the same size for now)
        if(shouldGrow){
            shouldGrow = false;
        } else {
            body.remove(body.size() - 1);
        }
    }

    public void grow(){
        shouldGrow = true;
    }

    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.snakeSquareSide, gp.snakeSquareSide);
        CollisionCheck(x, y);
        BufferedImage Image = switch (Direction) {
            case 'U' -> UpPng;
            case 'D' -> DownPng;
            case 'L' -> LeftPng;
            case 'R' -> RightPng;
            default -> UpPng;
        };
        g2.drawImage(Image, x, y, gp.snakeSquareSide, gp.snakeSquareSide, null);
        for (int i = 1; i < body.size(); i++){
            Point p = body.get(i);
            if(i % 2 == 0){
                g2.drawImage(BodyPngLight, p.x, p.y, gp.snakeSquareSide, gp.snakeSquareSide, null);
            } else {
                g2.drawImage(BodyPngDark, p.x, p.y, gp.snakeSquareSide, gp.snakeSquareSide, null);
            }
        }

    }

    public void CollisionCheck(int x, int y){
        boolean Collided = false;
        int LeftBorder = (gp.screenWidth - gp.checkboardSide) / 2 - gp.squareDistance;
        int RightBorder = (gp.screenWidth - gp.checkboardSide) / 2 + gp.checkboardSide - gp.tileSize;
        int UpBorder = (gp.screenHeight - gp.checkboardSide) / 2 - gp.squareDistance;
        int DownBorder = (gp.screenHeight - gp.checkboardSide) / 2 + gp.checkboardSide - gp.tileSize * 2;
        if(LeftBorder > x || RightBorder < x || UpBorder > y || DownBorder + gp.tileSize < y) {
//            Collided = true;
//            System.out.println("COLLISION");
            gp.GameStateOver = true;
            // YouLostScreen();
        }
        for (int i = 4; i < body.size(); i++){ // We check from 5th body tile (there from the index 4), since it is the shortest body length, when a head-body collision can occur
            Point p = body.get(i);
            if((p.x - 3 < x && p.x + 3 > x) && (p.y - 3 < y && p.y + 3 > y)){  // The range is set just in-case the 'x' or 'y' become offseted by a couple pixels somewhere in the program.
//                Collided = true;
//                System.out.println("COLLISION");
//                YouLostScreen();
                gp.GameStateOver = true;
            }
        }
        /*
        class CollisionLocal {
            public void OuterCollisionCheck(int x, int y){
                int LeftBorder = (gp.screenWidth - gp.checkboardSide) / 2 - gp.squareDistance;
                int RightBorder = (gp.screenWidth - gp.checkboardSide) / 2 + gp.checkboardSide - gp.tileSize;
                int UpBorder = (gp.screenHeight - gp.checkboardSide) / 2 - gp.squareDistance;
                int DownBorder = (gp.screenHeight - gp.checkboardSide) / 2 + gp.checkboardSide - gp.tileSize;
                if(LeftBorder > x || RightBorder < x || UpBorder > y || DownBorder < y){
                    Collided[0] = true;
                    System.out.println("COLLISION");
                };
            }
        }
         */


    }




}
