import javax.swing.*;
import java.awt.*;

public class Menus extends JFrame {
    private Game game;
    private JFrame frame;

    public Menus(JFrame frame) {
        this.frame = frame;
        showMainMenu();
    }

    public void showMainMenu() {

        frame.getContentPane().removeAll();
        frame.setLayout(null);

        ImageIcon radek = new ImageIcon(new ImageIcon("graphics/garbageman/radek_menu.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel titleLabel = new JLabel("Śmiecioban");
        titleLabel.setFont(new Font(("Comic Sans MS"), Font.BOLD, 50));
        titleLabel.setBounds(160,45,500,100);
        titleLabel.setIcon(radek);
        titleLabel.setIconTextGap(20);
        titleLabel.setHorizontalTextPosition(SwingConstants.LEFT);

        JButton levelButton = new JButton("Wybierz poziom");
        levelButton.setBounds(90,150,500,100);
        levelButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        levelButton.setFocusable(false);

        JButton controlsButton = new JButton("Sterowanie");
        controlsButton.setBounds(90,275,500,100);
        controlsButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        controlsButton.setFocusable(false);

        JButton informationButton = new JButton("Informacje");
        informationButton.setBounds(90,400,500,100);
        informationButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        informationButton.setFocusable(false);

        levelButton.addActionListener(e -> showLevelSelection());
        controlsButton.addActionListener(e -> showControls());
        informationButton.addActionListener(e -> showInformation());

        frame.add(titleLabel);
        frame.add(levelButton);
        frame.add(controlsButton);
        frame.add(informationButton);

        //pack();
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    private void showLevelSelection() {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(4, 1));

        String[] levels = {"Level 1", "Level 2", "Level 3"};
        for (int i = 0; i < levels.length; i++) {
            int level = i + 1;
            JButton levelButton = new JButton(levels[i]);
            levelButton.addActionListener(e -> {
                new Game(level, frame); // do testow
                dispose();
            });
            frame.add(levelButton);
        }

        JButton backButton = new JButton("Powrót");
        backButton.addActionListener(e -> showMainMenu());
        frame.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    private void showControls() {
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        JLabel controlsLabel = new JLabel("<html>Sterowanie:<br>W - Góra<br>A - Lewo<br>S - Dół<br>D - Prawo</html>");
        controlsLabel.setFont(new Font(("Comic Sans"), Font.BOLD, 50));
        controlsLabel.setBounds(160,45,500,300);

        JButton backButton = new JButton("Powrót");
        backButton.setBounds(90,400,500,100);
        backButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        backButton.setFocusable(false);
        backButton.addActionListener(e -> showMainMenu());

        frame.add(controlsLabel);
        frame.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    private void showInformation() {
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        JLabel informationLabel = new JLabel("<html>Gra stworzona w ramach projektu JPWP.<br><br><br><br><br><br><br>Autor: Maciej Paliwoda</html>");
        informationLabel.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        informationLabel.setBounds(60,20,600,350);

        JButton backButton = new JButton("Powrót");
        backButton.setBounds(90,400,500,100);
        backButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        backButton.setFocusable(false);
        backButton.addActionListener(e -> showMainMenu());

        frame.add(informationLabel);
        frame.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    public void showPauseMenu() {
        JDialog pauseDialog = new JDialog(frame, "Pause Menu", true);
        pauseDialog.setLayout(new GridLayout(3, 1));

        JButton restartButton = new JButton("Restart Level");
        JButton returnButton = new JButton("Return to Level Selection");
        JButton continueButton = new JButton("Continue");

        restartButton.addActionListener(e -> {
            game.restartLevel();
            pauseDialog.dispose();
        });

        returnButton.addActionListener(e -> {
            new Menus(frame);
            pauseDialog.dispose();
        });

        continueButton.addActionListener(e -> pauseDialog.dispose());

        pauseDialog.add(restartButton);
        pauseDialog.add(returnButton);
        pauseDialog.add(continueButton);

        pauseDialog.pack();
        pauseDialog.setLocationRelativeTo(frame);
        pauseDialog.setVisible(true);
    }
}