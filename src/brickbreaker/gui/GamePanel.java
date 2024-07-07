package brickbreaker.gui;

import brickbreaker.AudioPlayback;
import brickbreaker.Settings;
import brickbreaker.screens.GameOverSc;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 500;
    private final Base base;
    private final Ball ball;
    ArrayList<Brick> bricks = new ArrayList();
    private final BackgroundImageLabel backgroundImageLabel;
    private final Timer timer;
    private final Settings gameSettings;
    private final int level;
    private final Levels gameLevels;

    public GamePanel(int level) {
        this.level = level;
        super.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        super.setLayout(new BorderLayout());

        
        gameLevels = new Levels();
        backgroundImageLabel = new BackgroundImageLabel();
        base = new Base();
        ball = new Ball();
        backgroundImageLabel.add(ball);
        backgroundImageLabel.add(base);

        switch (level) {
            case 1 -> {
                for (Brick brick : gameLevels.createLevelOneBrickPattern()) {
                    bricks.add(brick);
                    backgroundImageLabel.add(brick);
                }
            }
            case 2 -> {
                for (Brick brick : gameLevels.createLevelTwoBrickPattern()) {
                    bricks.add(brick);
                    backgroundImageLabel.add(brick);
                }
            }
            case 3 -> {
                for (Brick brick : gameLevels.createLevelThreeBrickPattern()) {
                    bricks.add(brick);
                    backgroundImageLabel.add(brick);
                }
            }
            case 4 -> {
                for (Brick brick : gameLevels.createLevelFourBrickPattern()) {
                    bricks.add(brick);
                    backgroundImageLabel.add(brick);
                }
            }
            case 5 -> {
                for (Brick brick : gameLevels.createLevelFiveBrickPattern()) {
                    bricks.add(brick);
                    backgroundImageLabel.add(brick);
                }
            }
        }

        super.add(backgroundImageLabel, BorderLayout.NORTH);

        // Game settings
        gameSettings = Settings.getInstance();
        System.out.println(gameSettings.isBackgroundMusicOn());
        System.out.println(gameSettings.isSoundEffectsOn());

        // Start gameloop
        timer = new Timer(16, this);
        timer.start();
    }

    /**
     * Main game-loop method. It repaints the game after every 16 milliseconds
     * (60 FPS)
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.repaint();

        base.move();
        ball.moveBall();
        ball.checkCollisionsWithBase(base);
        Brick collidedBrick = ball.checkCollisionsWithBricks(bricks);
        if (collidedBrick != null) {
            if (gameSettings.isSoundEffectsOn()) {
                AudioPlayback.playSoundEffect();
            }
            backgroundImageLabel.remove(collidedBrick);
        }

        this.checkGameover();
    }

    /**
     * Displays a game-over dialog box if ball has gone all the way down, below
     * the base
     *
     * @param
     * @return
     */
    private void checkGameover() {
        if (ball.y >= 500) {
            timer.stop();
            AudioPlayback.closeBackgroundMusic();
            
            JFrame frame = new JFrame();
            frame.setTitle("Gameover");
            frame.setSize(760, 400);
            frame.add(new GameOverSc(this.level));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }

}
