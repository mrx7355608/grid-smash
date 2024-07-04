
package gridsmash;

import javax.swing.JFrame;


public class GridSmash {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new MainScreen());
        frame.setSize(1245, 700);
        frame.setTitle("Grid Smash");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
