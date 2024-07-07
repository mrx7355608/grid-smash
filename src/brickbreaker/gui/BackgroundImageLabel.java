
package brickbreaker.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class BackgroundImageLabel extends JLabel {
    public BackgroundImageLabel() {
        super.setPreferredSize(new Dimension(800, 500));
        super.setBounds(0, 0, 800, 500);
        
        // Load background image
        Image backgroundImage;
        try {
            backgroundImage = ImageIO.read(new File("src/assets/bg.jpeg")).getScaledInstance(900, 500, Image.SCALE_SMOOTH);
            super.setIcon(new ImageIcon(backgroundImage));
            super.setHorizontalAlignment(JLabel.CENTER);
        } catch (IOException ex) {
            System.out.println("[ERROR] Unable to load background image");
        }
        
    }
}
