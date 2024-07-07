package brickbreaker.gui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Levels {

    private ArrayList<ImageIcon> brickImages;

    public Levels() {
        brickImages = new ArrayList();
        // Load all brick images
        try {
            Image orangeBrick = ImageIO.read(new File("src/assets/bricks/orange.png")).getScaledInstance(70, 30, Image.SCALE_SMOOTH);
            Image blueBrick = ImageIO.read(new File("src/assets/bricks/blue.png")).getScaledInstance(70, 30, Image.SCALE_SMOOTH);
            Image pinkBrick = ImageIO.read(new File("src/assets/bricks/pink.png")).getScaledInstance(70, 30, Image.SCALE_SMOOTH);
            Image skyblueBrick = ImageIO.read(new File("src/assets/bricks/skyblue.png")).getScaledInstance(70, 30, Image.SCALE_SMOOTH);
            Image redBrick = ImageIO.read(new File("src/assets/bricks/red.png")).getScaledInstance(70, 30, Image.SCALE_SMOOTH);
            Image greenBrick = ImageIO.read(new File("src/assets/bricks/green.png")).getScaledInstance(70, 30, Image.SCALE_SMOOTH);
            Image yellowBrick = ImageIO.read(new File("src/assets/bricks/yellow.png")).getScaledInstance(70, 30, Image.SCALE_SMOOTH);
            Image brownBrick = ImageIO.read(new File("src/assets/bricks/brown.png")).getScaledInstance(70, 30, Image.SCALE_SMOOTH);
            Image greyBrick = ImageIO.read(new File("src/assets/bricks/grey.png")).getScaledInstance(70, 30, Image.SCALE_SMOOTH);

            brickImages.add(new ImageIcon(orangeBrick));
            brickImages.add(new ImageIcon(blueBrick));
            brickImages.add(new ImageIcon(greenBrick));
            brickImages.add(new ImageIcon(brownBrick));
            brickImages.add(new ImageIcon(pinkBrick));
            brickImages.add(new ImageIcon(skyblueBrick));
            brickImages.add(new ImageIcon(redBrick));
            brickImages.add(new ImageIcon(yellowBrick));
            brickImages.add(new ImageIcon(greyBrick));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Brick> createLevelOneBrickPattern() {
        ArrayList<Brick> bricks = new ArrayList();

        int xPos = 0;
        int yPos = 50;
        int index = 0;

        for (int i = 0; i < 28; i++) {
            if (i % 7 == 0 && i != 0) {
                index += 1;
                xPos = 0;
                yPos = yPos + 40;
            }

            Brick brick = new Brick(brickImages.get(index));

            brick.setBounds(xPos, yPos, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
            bricks.add(brick);
            xPos = xPos + brick.getBRICK_WIDTH() + 20;
        }

        return bricks;
    }

    public ArrayList<Brick> createLevelTwoBrickPattern() {
        ArrayList<Brick> bricks = new ArrayList();

        int xPos = 70;
        int yPos = 50;
        int index = 0;

        for (int i = 1; i <= 8; i++) {

            for (int j = 1; j <= 8; j++) {

                // For every even row
                if (i % 2 == 0) {
                    Brick brick = new Brick(brickImages.get(index));

                    // If the column number is even, only then create a brick
                    if (j % 2 == 0) {
                        brick.setBounds(xPos, yPos, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                        bricks.add(brick);
                        xPos = xPos + brick.getBRICK_WIDTH();
                        continue;
                    }

                    xPos = xPos + brick.getBRICK_WIDTH();
                } else {
                    Brick brick = new Brick(brickImages.get(index));

                    // For every odd row, ignore the even columns
                    if (j % 2 == 0) {
                        xPos = xPos + brick.getBRICK_WIDTH();
                        continue;
                    }

                    // Add brick to array
                    brick.setBounds(xPos, yPos, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                    bricks.add(brick);
                    xPos = xPos + brick.getBRICK_WIDTH();
                }

            }

            // After creating bricks for a row
            xPos = 70;  // Reset X position
            yPos = yPos + 30;  // Update Y position
            index += 1;
            
            if (i % 3 == 0) {
                index += 1;
            } else {
                index -= 1;
            }

        }

        return bricks;
    }

    public ArrayList<Brick> createLevelThreeBrickPattern() {
        ArrayList<Brick> bricks = new ArrayList();

        // Box 1
        int xPos1 = 30;
        int yPos1 = 20;
        int borderImagesIndex = 0;
        int centerImageIndex = 1;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                Brick brick;
                if (i != 0 && i < 6) {
                    brick = new Brick(brickImages.get(centerImageIndex));
                } else {
                    brick = new Brick(brickImages.get(borderImagesIndex));
                }
                
                brick.setBounds(xPos1, yPos1, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                xPos1 += brick.getBRICK_WIDTH();
            }
            xPos1 = 30;
            yPos1 += 30;
        }

        // Box 2
        int xPos2 = 400;
        int yPos2 = 20;
        centerImageIndex += 1;
        borderImagesIndex += 1;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                Brick brick;
                if (i != 0 && i < 6) {
                    brick = new Brick(brickImages.get(centerImageIndex));
                } else {
                    brick = new Brick(brickImages.get(borderImagesIndex));
                }
                brick.setBounds(xPos2, yPos2, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                xPos2 += brick.getBRICK_WIDTH();
            }
            xPos2 = 400;
            yPos2 += 30;
        }

        return bricks;
    }

    public ArrayList<Brick> createLevelFourBrickPattern() {
        ArrayList<Brick> bricks = new ArrayList();

        int xPos = 120;
        int yPos = 20;
        int nextXPos = 120;
        int bricksCount = 8;

        while (bricksCount != 0) {

            for (int i = 0; i < bricksCount; i++) {
                Brick brick;
                
                if (bricksCount == 8) {
                    brick = new Brick(brickImages.get(1));
                } else if (i > 0 && i <= bricksCount - 2) {
                    brick = new Brick(brickImages.get(0));
                } else {
                    brick = new Brick(brickImages.get(1));
                }
                
                brick.setBounds(xPos, yPos, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                xPos += brick.getBRICK_WIDTH();
            }

            bricksCount -= 1;
            nextXPos += 35;
            xPos = nextXPos;
            yPos += 30;
        }

        return bricks;
    }

    public ArrayList<Brick> createLevelFiveBrickPattern() {
        ArrayList<Brick> bricks = new ArrayList();

        // Triangle one
        int xPos = 150;
        int yPos = 50;
        int nextXPos = 150;
        int bricksCount = 1;
        int index = 0;

        while (bricksCount <= 5) {
            for (int i = 0; i < bricksCount; i++) {
                Brick brick = new Brick(brickImages.get(index));
                brick.setBounds(xPos, yPos, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                xPos += brick.getBRICK_WIDTH();
                index += 1;
            }

            bricksCount += 1;
            nextXPos -= 35;
            xPos = nextXPos;
            yPos += 30;
            index = 0;
        }

        // Triangle two
        int xPos2 = 550;
        int yPos2 = 50;
        int nextXPos2 = 550;
        int bricksCount2 = 1;
        index = 0;

        while (bricksCount2 <= 5) {
            for (int i = 0; i < bricksCount2; i++) {
                Brick brick = new Brick(brickImages.get(index));
                brick.setBounds(xPos2, yPos2, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                xPos2 += brick.getBRICK_WIDTH();
                index += 1;
            }

            bricksCount2 += 1;
            nextXPos2 -= 35;
            xPos2 = nextXPos2;
            yPos2 += 30;
            index = 0;
        }

        return bricks;
    }
}
