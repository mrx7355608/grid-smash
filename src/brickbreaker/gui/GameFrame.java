package brickbreaker.gui;

import brickbreaker.AudioPlayback;
import brickbreaker.Settings;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    private final int SCREEN_WIDTH = 800;
    private final int SCREEN_HEIGHT = 500;
    private final Settings gameSettings;

    public GameFrame(int level) {
        setTitle("Brick Breaker");
        super.setResizable(false);
        super.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        super.setLocationRelativeTo(null);
        super.setIconImage(new ImageIcon("src/assets/icon.png").getImage());
        super.add(new GamePanel(level));
        
        // Game settings
        gameSettings = Settings.getInstance();
        
        if (gameSettings.isBackgroundMusicOn()) {
            this.playBackgroundMusic();
        }
    }

    /**
     * Plays background music loop in a separate thread
     */
    private void playBackgroundMusic() {
        new Thread(() -> {
            AudioPlayback.playMusic();
        }).start();
    }
}
