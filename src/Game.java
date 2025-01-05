import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {
    private Player player;
    private Board board;
    private GamePanel gamePanel;
    private JFrame frame;
    private Menus menus;
    public int currentLevel;

    public Game(int level, JFrame frame) {
        this.frame = frame;
        this.currentLevel = level;
        System.out.println("Level: " + currentLevel); //delete later - testing
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());
        board = new Board(currentLevel);
        player = new Player(board);
        gamePanel = new GamePanel(board, player, currentLevel);
        frame.add(gamePanel);
        frame.pack();
        setupKeyListener(frame);
    }

    private void setupKeyListener(JFrame frame) {

        for (KeyListener kl : frame.getKeyListeners()) {
            frame.removeKeyListener(kl);
        }

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    menus = new Menus(frame); // Initialize menus object
                    showPauseMenu(frame, currentLevel);
                    return;
                }
                switch (Character.toLowerCase(e.getKeyChar())) {
                    case 'w':
                        player.move('w');
                        break;
                    case 'a':
                        player.move('a');
                        break;
                    case 's':
                        player.move('s');
                        break;
                    case 'd':
                        player.move('d');
                        break;
                    case 'r':
                        player.move('w');
                        break;
                }
                gamePanel.updateBoard(board);
                if (board.isCompleted()) {
                    JOptionPane.showMessageDialog(null, "You won!");
                    System.exit(0);
                }
            }
        });
        frame.requestFocusInWindow();
    }

    public void restartLevel() {
        System.out.println("Restarting level: " + currentLevel);

        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());

        board = new Board(currentLevel);
        player = new Player(board);
        gamePanel = new GamePanel(board, player, currentLevel);

        frame.add(gamePanel);

        frame.pack();
        frame.revalidate();
        frame.repaint();

        setupKeyListener(frame);
    }

    public void continueLevel() {
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());
        gamePanel = new GamePanel(board, player, currentLevel);
        frame.add(gamePanel);
        frame.pack();
        frame.requestFocusInWindow();
    }

    public void showPauseMenu(JFrame frame, int level) {
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        ImageIcon radek = new ImageIcon(new ImageIcon("graphics/garbageman/radek_menu.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel titleLabel = new JLabel("PAUZA");
        titleLabel.setFont(new Font(("Comic Sans"), Font.BOLD, 50));
        titleLabel.setBounds(160,45,500,100);
        titleLabel.setIcon(radek);
        titleLabel.setIconTextGap(20);
        titleLabel.setHorizontalTextPosition(SwingConstants.LEFT);

        JButton continueButton = new JButton("Kontynuuj");
        continueButton.setBounds(90,150,500,100);
        continueButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        continueButton.setFocusable(false);

        JButton restartButton = new JButton("Zacznij od nowa");
        restartButton.setBounds(90,275,500,100);
        restartButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        restartButton.setFocusable(false);

        JButton returnButton = new JButton("Powrót do wyboru poziomu");
        returnButton.setBounds(90,400,500,100);
        returnButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        returnButton.setFocusable(false);

        continueButton.addActionListener(e -> {
            continueLevel();
        });
        restartButton.addActionListener(e -> {
            restartLevel();;
        });
        returnButton.addActionListener(e -> {
            menus.showLevelSelection();
        });


        frame.add(titleLabel);
        frame.add(continueButton);
        frame.add(restartButton);
        frame.add(returnButton);

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }
}
