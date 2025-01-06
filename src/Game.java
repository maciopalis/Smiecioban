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
    public MusicManager musicManager;

    public Game(int level, JFrame frame) {
        this.musicManager = new MusicManager();
        this.frame = frame;
        this.currentLevel = level;
        this.musicManager.playGameMusic();
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
                    musicManager.stopSound();
                    musicManager.playMainMenuMusic();
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
                }
                gamePanel.updateBoard(board);
                if (board.isCompleted()) {
                    musicManager.stopSound();
                    int moves = gamePanel.getPlayerMoves();
                    menus = new Menus(frame);
                    menus.levelCompletedMenu(currentLevel, moves);
                }
            }
        });
        frame.requestFocusInWindow();
    }



    public void restartLevel() {
        System.out.println("Restarting level: " + currentLevel);
        musicManager.stopSound();
        this.musicManager.playGameMusic();
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
        musicManager.stopSound();
        this.musicManager.playGameMusic();
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

        JButton continueButton = createButton("Kontynuuj", 90, 150, 500, 100, 30);
        JButton restartButton = createButton("Zacznij od nowa", 90, 275, 500, 100, 30);
        JButton returnButton = createButton("Powrót do wyboru poziomu", 90, 400, 500, 100, 30);

        continueButton.addActionListener(e -> continueLevel());
        restartButton.addActionListener(e -> restartLevel());
        returnButton.addActionListener(e -> {
            for (KeyListener kl : frame.getKeyListeners()) {
                frame.removeKeyListener(kl);
            }
            musicManager.stopSound();
            menus = new Menus(frame);
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

    private JButton createButton(String text, int x, int y, int width, int height, int fontSize) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Comic Sans", Font.BOLD, fontSize));
        button.setFocusable(false);
        return button;
    }
}
