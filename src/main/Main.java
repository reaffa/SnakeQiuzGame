/*

    TODO:
        DONE 1) Make it so the player cannot turn back, only to their right or left
        DONE 2) Draw the backgroud tiles
            blue - 0C0159, dark blue - 0C0142, background - 180027
        DONE 3) Make the Snake body and collision
        SORT OF DONE 4) Make the Apple
        5) Make the Dialogue with transition countdown
        6) Make the Life and Score system
        7) You lost screen and start screen

 */

package main;

import javax.swing.JFrame;
import java.awt.*;

public class Main {
    public static JFrame window = new JFrame();
    public static void main(String[] args) {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Snake Game");

        window.setUndecorated(true);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        window.setLocation(0,0);

        window.pack();
        window.setLocationRelativeTo(null);

        window.setVisible(true);

        gamePanel.startGameThread();
    }
}