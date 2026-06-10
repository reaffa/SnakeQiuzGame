package main;

import snake.Snake;
import elements.Apple;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
//import java.nio.Buffer;
//import java.security.Key;
//import java.util.Random;
import java.awt.Graphics2D;


public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16;
    public final int scale = 6;

    public final int tileSize = originalTileSize * scale;
    public final int checkboardSideSquares = 8;
    public final int squareDistance = 2 * scale;
    public final int checkboardSide = (checkboardSideSquares - 1) * squareDistance + tileSize * checkboardSideSquares; // 852
    public final int snakeSquareSide = squareDistance + tileSize;
    public final int screenHeight = 1080;
    public final int screenHeightCheckboardOffset = (screenHeight - checkboardSide) / 2;
    public final int screenWidth = 1920;
    public final int screenWidthCheckboardOffset = (screenWidth - checkboardSide) / 2;


    int Score = 0;
    public double FPS = 2;
    // FOR FULLSCREEN
    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;
    BufferedImage tempScreen;
    Graphics2D g2;
    QuizStorage QuizStorage = new QuizStorage();
    int CountdownValue = 3;


    KeyHandler keyHandler = new KeyHandler(this);
    Thread gameThread;
    Snake Snake = new Snake(this, keyHandler);
    Apple Apple = new Apple(this, Snake);

    // set players default position
    int snakeX = screenWidth / 2 - snakeSquareSide / 2;
    int snakeY = screenHeight / 2 - snakeSquareSide / 2;
    int snakeSpeed = snakeSquareSide;

    public int Lives = 3;
    public boolean Paused = false;
    public boolean GameStateOver = false;
    BufferedImage HeartPng;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(0x180027));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        try {
            HeartPng = ImageIO.read(getClass().getResourceAsStream("/misc/Heart.png"));
        }catch (
        IOException e){
            e.printStackTrace();
        }
    }

    public void setFullScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.window);

        screenWidth2 = Main.window.getWidth();
        screenHeight2 = Main.window.getHeight();
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;


        while (gameThread != null) {
            if (Paused){
                lastTime = System.nanoTime();
                try { Thread.sleep(100); }
                catch (InterruptedException e) {}

                continue;
            }

            drawInterval = 1000000000 / FPS;
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                repaint();
                update();
                delta--;
            }
        }
    }

    public void update() {
        if(GameStateOver){
            return;
        }

        Snake.update();

        Point head = Snake.body.get(0);
            if ((Apple.x > head.x - 7 && Apple.x < head.x + 7) && (Apple.y > head.y - 7 && Apple.y < head.y + 7)) {
//                Snake.grow();
//                score++;
//                Apple.respawn();
//                System.out.println("Yummy! " + score);
                TriggerQuiz();
            }
    }



    public void paintComponent(Graphics g) {  // called by "repaint()"

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

//        for (int i = 0; i <= 256; i++) {
//            Random random = new Random();
//            int RandCol = random.nextInt(8);
//            int RandRow = random.nextInt(8);
//            int ColGapsCount;
//            int RowGapsCount;
//            int x1, y1;
//            RandCol = random.nextInt(8);
//            RandRow = random.nextInt(8);
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
//            x1 = this.screenWidthCheckboardOffset + RandCol * this.tileSize + ColGapsCount * (this.squareDistance) - squareDistance / 2;
//            y1 = this.screenHeightCheckboardOffset + RandRow * this.tileSize + RowGapsCount * (this.squareDistance) - squareDistance / 2;
//            g2.drawRect(x1, y1, snakeSquareSide, snakeSquareSide);
//        }
//        Random random = new Random();
//        int x1, y1;
//        for (int i1 = 0; i1 < 256; i1++) {
//            int RandCol = random.nextInt(8);
//            int RandRow = random.nextInt(8);
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
//            x1 = screenWidthCheckboardOffset + RandCol * tileSize + ColGapsCount * squareDistance - squareDistance / 2;
//            y1 = screenHeightCheckboardOffset + RandRow * tileSize + RowGapsCount * squareDistance - squareDistance / 2;
//            g2.drawRect(x1, y1, snakeSquareSide, snakeSquareSide);
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if ((r + c) % 2 == 0) {
                    g2.setColor(new Color(0x0C0142));
                } else {
                    g2.setColor(new Color(0x0C0159));
                }
                g2.fillRect(this.screenWidthCheckboardOffset + c * (this.tileSize + this.squareDistance), this.screenHeightCheckboardOffset + r * (this.tileSize + this.squareDistance), tileSize, tileSize);
            }
        }




        Snake.draw(g2);
        Apple.draw(g2);

        g2.drawImage(HeartPng, 20, 20, 96, 96, null);
        g2.setColor(Color.white);
        g2.setFont(new Font("Helvetica", Font.BOLD, 36));
        g2.drawString("" + Lives, 58, 76);

        g2.setFont(new Font("Consolas", Font.BOLD, 90));
        g2.setColor(Color.YELLOW);
        g2.drawString("" + Score, 1800, 90);



        if (Paused && CountdownValue > 0) {
            g2.setColor(new Color(0, 0, 0, 150)); // Semi-transparent black background
            g2.fillRect(0, 0, screenWidth, screenHeight);

            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Consolas", Font.BOLD, 350)); // BIG FONT

            String text = String.valueOf(CountdownValue);

            // Center the number on screen
            int textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            int x = screenWidth / 2 - textLength / 2;
            int y = screenHeight / 2;

            g2.drawString(text, x, y);
        }

        if(GameStateOver){
            g2.setColor(new Color(0, 0, 0, 150));
            g2.fillRect(0, 0, screenWidth, screenHeight);
            g2.setColor(Color.RED);
            g2.setFont(new Font("Helvetica", Font.BOLD, 300));
            String text = "GAME OVER";
            int tLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            g2.drawString(text, screenWidth/2 - tLen/2, screenHeight/2 - 50);
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 100));
            text = "Skóre: " + Score;
            tLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            g2.drawString(text, screenWidth/2 - tLen/2, screenHeight/2 + 50);
            g2.setColor(Color.YELLOW);
            g2.setFont(new Font("Arial", Font.BOLD, 50));
            text = "Hrát znovu - Zmáčkni SPACE";
            tLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            g2.drawString(text, screenWidth/2 - tLen/2, screenHeight/2 + 120);
        }




        g2.dispose();   // Works without, but is a good practice

    }

    public void TriggerQuiz() {
        Paused = true;


        QuizQuestion CurrentQuestion = QuizStorage.getRandomQuestion();
        SwingUtilities.invokeLater(() -> {
            // 1. Find the parent window (Main.window)
            // We can cast the return of SwingUtilities to JFrame
            JFrame parentWindow = (JFrame) SwingUtilities.getWindowAncestor(this);

            // 2. Create and Show the Dialog
            QuizDialog Quiz = new QuizDialog(parentWindow, CurrentQuestion);
            Quiz.setVisible(true); // Code STOPS here until dialog closes

            // 3. Check Result
            if (Quiz.getResult()) {
                // CORRECT:
                System.out.println("Correct!");
                Snake.grow();       // Grow snake
                Apple.respawn();     // New food
                Score++;         // Add score (Task 6)
            } else {
                // WRONG:
                System.out.println("Wrong!");
                Lives--;            // Lose life
                Apple.respawn();     // Move food anyway so they don't get stuck

                if (Lives <= 0) {
                    // GAME OVER LOGIC
                    GameStateOver = true; // Stop the game loop
                }
            }
            if(!GameStateOver) {
                StartCountdown();
            } else {
                Paused = false;
            }

        });
    }
    void StartCountdown(){
        CountdownValue = 3;

        Timer CountdownTimer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CountdownValue--;

                if (CountdownValue <= 0) {
                    // STOP Countdown, RESUME Game
                    ((Timer)e.getSource()).stop();
                    Paused = false; // Game Loop starts running again
                }
                repaint(); // Force redraw to show new number
            }
        });
        CountdownTimer.setInitialDelay(1000);
        CountdownTimer.start();
        repaint();
    }

    public void resetGame() {
        Score = 0;
        Lives = 3;
        GameStateOver = false;
        Paused = false;

        // Reset Snake and Apple
        Snake.SetDefaultValues();
        Apple.respawn();

        repaint();
    }
}
