import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel {
    private Board board;
    private Player player;
    private int moves;
    private int level;
    private Image emptyTile, wallTile, playerTile, mixedTrashTile, mixedBinTile, mixedTrashInBinTile;

    public GamePanel(Board board, Player player) {
        this.board = board;
        this.player = player;
        this.level = level;
        setLayout(new BorderLayout());

        try {
            emptyTile = ImageIO.read(new File("graphics/background/empty.png"));
            wallTile = ImageIO.read(new File("graphics/background/wall.png"));
            playerTile = ImageIO.read(new File("graphics/garbageman/radek.png"));
            mixedTrashTile = ImageIO.read(new File("graphics/garbage/paper_trash.png"));
            mixedBinTile = ImageIO.read(new File("graphics/bins/empty/paper_bin_empty.png"));
            mixedTrashInBinTile = ImageIO.read(new File("graphics/bins/full/paper_bin_full.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel textPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("Wykonane ruchy: " + player.getMoves(), 10, 30);
                g.drawString("POZIOM: " + level, getWidth() - 150, 30);
                g.drawLine(0, 40, getWidth(), 40); // Draw a line below the text
            }
        };
        textPanel.setPreferredSize(new Dimension(640, 50)); // Adjust size as needed
        add(textPanel, BorderLayout.NORTH);

        JPanel mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBoard(g);
            }
        };
        mapPanel.setPreferredSize(new Dimension(640, 462)); // Adjust size as needed
        add(mapPanel, BorderLayout.CENTER); //Not centered
    }

    private void drawBoard(Graphics g) {
        int tileSize = 40; // Adjusted to size of future textures
        for (int y = 0; y < board.board.length; y++) {
            for (int x = 0; x < board.board[y].length; x++) {
                char tile = board.board[y][x];
                Image img = null;
                switch (tile) {
                    case ' ':
                        img = emptyTile;
                        break;
                    case '#':
                        img = wallTile;
                        break;
                    case '@':
                        img = playerTile;
                        break;
                    case 'X':
                        img = mixedTrashTile;
                        break;
                    case 'O':
                        img = mixedBinTile;
                        break;
                    case 'G':
                        img = mixedTrashInBinTile;
                        break;
                }
                //g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
                //g.setColor(Color.GRAY);
                //g.drawRect(x * tileSize, y * tileSize, tileSize, tileSize);
                if (img != null) {
                    g.drawImage(img, x * tileSize, y * tileSize, tileSize, tileSize, this);
                }
            }
        }
    }

    public void updateBoard(Board board) {
        this.board = board;
        repaint();
    }
}