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
    private Image emptyTile, wallTile, playerTile, mixedTrashTile, mixedBinTile, mixedTrashInBinTile,
            glassTrashTile, glassBinTile, glassTrashInBinTile, plasticTrashTile, plasticBinTile, plasticTrashInBinTile,
            paperTrashTile, paperBinTile, paperTrashInBinTile, bioTrashTile, bioBinTile, bioTrashInBinTile;

    public GamePanel(Board board, Player player) {
        this.board = board;
        this.player = player;
        this.level = level;
        setLayout(new BorderLayout());

        try {
            emptyTile = ImageIO.read(new File("graphics/background/empty.png"));
            wallTile = ImageIO.read(new File("graphics/background/wall.png"));
            playerTile = ImageIO.read(new File("graphics/garbageman/radek.png"));
            mixedTrashTile = ImageIO.read(new File("graphics/garbage/mixed_trash.png"));
            mixedBinTile = ImageIO.read(new File("graphics/bins/empty/mixed_bin_empty.png"));
            mixedTrashInBinTile = ImageIO.read(new File("graphics/bins/full/mixed_bin_full.png"));
            glassTrashTile = ImageIO.read(new File("graphics/garbage/glass_trash.png"));
            glassBinTile = ImageIO.read(new File("graphics/bins/empty/glass_bin_empty.png"));
            glassTrashInBinTile = ImageIO.read(new File("graphics/bins/full/glass_bin_full.png"));
            plasticTrashTile = ImageIO.read(new File("graphics/garbage/plastic_trash.png"));
            plasticBinTile = ImageIO.read(new File("graphics/bins/empty/plastic_bin_empty.png"));
            plasticTrashInBinTile = ImageIO.read(new File("graphics/bins/full/plastic_bin_full.png"));
            paperTrashTile = ImageIO.read(new File("graphics/garbage/paper_trash.png"));
            paperBinTile = ImageIO.read(new File("graphics/bins/empty/paper_bin_empty.png"));
            paperTrashInBinTile = ImageIO.read(new File("graphics/bins/full/paper_bin_full.png"));
            bioTrashTile = ImageIO.read(new File("graphics/garbage/bio_trash.png"));
            bioBinTile = ImageIO.read(new File("graphics/bins/empty/bio_bin_empty.png"));
            bioTrashInBinTile = ImageIO.read(new File("graphics/bins/full/bio_bin_full.png"));
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
                    case 'M':
                        img = mixedTrashTile;
                        break;
                    case 'G':
                        img = glassTrashTile;
                        break;
                    case 'P':
                        img = plasticTrashTile;
                        break;
                    case 'A':
                        img = paperTrashTile;
                        break;
                    case 'B':
                        img = bioTrashTile;
                        break;
                    case 'm':
                        img = mixedBinTile;
                        break;
                    case 'X':
                        img = mixedTrashInBinTile;
                        break;
                    case 'g':
                        img = glassBinTile;
                        break;
                    case 'Y':
                        img = glassTrashInBinTile;
                        break;
                    case 'p':
                        img = plasticBinTile;
                        break;
                    case 'Z':
                        img = plasticTrashInBinTile;
                        break;
                    case 'a':
                        img = paperBinTile;
                        break;
                    case 'J':
                        img = paperTrashInBinTile;
                        break;
                    case 'b':
                        img = bioBinTile;
                        break;
                    case 'K':
                        img = bioTrashInBinTile;
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