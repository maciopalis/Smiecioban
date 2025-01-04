import javax.swing.*;
import java.awt.*;

public class test {

    public test(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        JLabel controlsLabel = new JLabel("<html>Sterowanie:<br>W - Góra<br>A - Lewo<br>S - Dół<br>D - Prawo</html>");
        controlsLabel.setFont(new Font("Comic Sans", Font.BOLD, 50));
        controlsLabel.setBounds(160, 45, 500, 300);

        JButton backButton = new JButton("Powrót");
        backButton.setBounds(90, 400, 500, 100);
        backButton.setFont(new Font("Comic Sans", Font.BOLD, 30));
        backButton.setFocusable(false);
        backButton.addActionListener(e -> new Menus(frame));

        frame.add(controlsLabel);
        frame.add(backButton);

        frame.setSize(696, 569);
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }
}