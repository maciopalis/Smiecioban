import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Board board;
    private Player player;

    public GamePanel(Board board, Player player) {
        this.board = board;
        this.player = player;
        setPreferredSize(new Dimension(1280, 512)); // Adjust size as needed
    }

    @Override // because we are extending JPanel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
    }

    private void drawBoard(Graphics g) {
        int tileSize = 40; // Adjusted to size of future textures
        for (int y = 0; y < board.board.length; y++) {
            for (int x = 0; x < board.board[y].length; x++) {
                char tile = board.board[y][x];
                switch (tile) {
                    case ' ':
                        g.setColor(Color.WHITE);
                        break;
                    case '#':
                        g.setColor(Color.BLACK);
                        break;
                    case '@':
                        g.setColor(Color.BLUE);
                        break;
                    case 'X':
                        g.setColor(Color.RED);
                        break;
                    case 'O':
                        g.setColor(Color.GREEN);
                        break;
                    case 'G':
                        g.setColor(Color.ORANGE);
                        break;
                }
                g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
                g.setColor(Color.GRAY);
                g.drawRect(x * tileSize, y * tileSize, tileSize, tileSize);
            }
        }
    }

    public void updateBoard(Board board) {
        this.board = board;
        repaint();
    }
}