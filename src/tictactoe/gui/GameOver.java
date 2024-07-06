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

    private GameGUI gameGUI;
    private String winner;

    public GameOver(String winner, GameGUI gameGUI) {
        this.gameGUI = gameGUI;
        this.winner = winner;
        this.setTitle("GAMEOVER");
        this.setSize(500, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Creating main panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 40));

        // Create components
        JLabel backgroundImageLabel = this.createBackgroundImageLabel();
        JLabel winnerLabel = this.createWinnerLable();
        JButton rematchButton = this.createRematchButton();
        JButton quitButton = this.createQuitButton();
        
        // Add components to panel
        panel.add(backgroundImageLabel);
        panel.add(winnerLabel);
        panel.add(rematchButton);
        panel.add(quitButton);

        this.add(panel);
    }

    private JLabel createBackgroundImageLabel() {
        JLabel label = new JLabel();
        Image img;
        try {
            img = ImageIO.read(new File("src/assets/ttt-gameover.jpg"));
            label.setIcon(new ImageIcon(img));
            label.setBounds(0, 0, 500, 500);
        } catch (IOException ex) {
            Logger.getLogger(GameOver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return label;
    }

    private JLabel createWinnerLable() {
        JLabel winnerLabel = new JLabel();
        winnerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);
        winnerLabel.setVerticalAlignment(JLabel.NORTH);
        winnerLabel.setPreferredSize(new Dimension(500, 60));
        if (this.winner.equals("tie")) {
            winnerLabel.setText("It's a tie");
        } else {
            winnerLabel.setText(this.winner + " has won the game!");
        }

        return winnerLabel;
    }

    private JButton createRematchButton() {
        JButton button = new JButton("REMATCH");
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(235, 3, 253));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        button.setPreferredSize(new Dimension(100, 30));
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        button.addActionListener((ActionEvent e) -> {
            this.gameGUI.dispose();

            // Dispose this gameover screen
            this.dispose();

            // Create new game screen
            new GameGUI(this.gameGUI.gameMode).setVisible(true);
        });
        return button;
    }

    private JButton createQuitButton() {
        JButton button = new JButton("QUIT");
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(235, 3, 253));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        button.setPreferredSize(new Dimension(100, 30));
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        button.addActionListener((ActionEvent e) -> {
            this.gameGUI.dispose();
            this.dispose();
        });
        return button;
    }
}
