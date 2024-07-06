package tictactoe.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver extends JFrame {
    
    private  GameGUI gameGUI;

    public GameOver(String winner, GameGUI gameGUI) {
        this.gameGUI = gameGUI;
        this.setTitle("GAMEOVER");
        this.setSize(500, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        // Creating main panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 40));
        
        // Creating label to add background image
        JLabel label = new JLabel();
        Image img;
        try {
            img = ImageIO.read(new File("src/assets/ttt-gameover.jpg"));
            label.setIcon(new ImageIcon(img));
            label.setBounds(0, 0, 500, 500);
        } catch (IOException ex) {
            Logger.getLogger(GameOver.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel.add(label);
        
        // Creating a label for displaying winner
        JLabel winnerLabel = new JLabel();
        winnerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);
        winnerLabel.setVerticalAlignment(JLabel.NORTH);
        winnerLabel.setPreferredSize(new Dimension(500, 60));
        if (winner.equals("tie")) {
            winnerLabel.setText("It's a tie");
        } else {
            winnerLabel.setText(winner + " has won the game!");
        }
        panel.add(winnerLabel);
        
        // Create rematch button
        JButton b1 = new JButton("REMATCH");
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(235, 3, 253));
        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        b1.setPreferredSize(new Dimension(100, 30));
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.addActionListener((ActionEvent e) -> {
            this.gameGUI.dispose();

            // Dispose this gameover screen
            this.dispose();

            // Create new game screen
            new GameGUI(this.gameGUI.gameMode).setVisible(true);
        });

        // Create quit button
        JButton b2 = new JButton("QUIT");
        b2.setForeground(Color.BLACK);
        b2.setBackground(new Color(235, 3, 253));
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        b2.setPreferredSize(new Dimension(100, 30));
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.addActionListener((ActionEvent e) -> {
            this.gameGUI.dispose();
            this.dispose();
        });

        panel.add(b1);
        panel.add(b2);

        this.add(panel);
    }
}
