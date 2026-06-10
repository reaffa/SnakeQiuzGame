package main;
/*
    TODO:
*/
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }

        if(gp.GameStateOver){
            if(code == KeyEvent.VK_SPACE){
                gp.resetGame();
            }
            gp.resetGame();
            return;
        }


        // SPEED CONTROL
        // We check for PLUS or EQUALS (because + is usually Shift+=)
        if (code == KeyEvent.VK_PLUS || code == KeyEvent.VK_EQUALS || code == KeyEvent.VK_ADD) {
            gp.FPS += 0.25; // Increase speed
            System.out.println("Speed Up! FPS: " + gp.FPS);
        }
        if (code == KeyEvent.VK_MINUS || code == KeyEvent.VK_SUBTRACT) {
            if (gp.FPS > 1) {
                gp.FPS -= 0.25; // Decrease speed
                System.out.println("Slow Down! FPS: " + gp.FPS);
            }
        }

        if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
            resetKeys();
            upPressed = true;
        }
        if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
            resetKeys();
            downPressed = true;
        }
        if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
            resetKeys();
            leftPressed = true;
        }
        if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D){
            resetKeys();
            rightPressed = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
//        int code = e.getKeyCode();
//
//        if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
//            upPressed = false;
//        }
//        if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
//            downPressed = false;
//        }
//        if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
//            leftPressed = false;
//        }
//        if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D){
//            rightPressed = false;
//        }
    }

    public void resetKeys(){
        upPressed = false; downPressed = false; leftPressed = false; rightPressed = false;
    }
}
