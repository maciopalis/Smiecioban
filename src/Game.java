import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game {
    private Player player;
    private Board board;
    private GamePanel gamePanel;
    private JFrame frame;
    private Menus menus;

    public Game(int level, JFrame frame) {
        this.frame = frame;
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());
        board = new Board(level);
        player = new Player(board);
        gamePanel = new GamePanel(board, player, level);
        frame.add(gamePanel);
        frame.pack();
        //frame.setSize(696, 569);
        setupKeyListener(frame);
    }

    private void setupKeyListener(JFrame frame) {
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    menus.showPauseMenu();
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
                    JOptionPane.showMessageDialog(null, "You won!");
                    System.exit(0);
                }
            }
        });
        frame.requestFocusInWindow();
    }

    public void restartLevel() {
        player = new Player(board);
        gamePanel.updateBoard(board);
        frame.requestFocusInWindow();
    }

    public void returnToLevelSelection() {
        new Menus(frame);
        frame.dispose();
    }
}
