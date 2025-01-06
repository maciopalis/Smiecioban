import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Śmiecioban");
        frame.setSize(696, 649);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.decode("#F0F8FF"));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Menus(frame);
    }
}