import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel {
    private Board board;
    private Player player;
    private int level;
    private Image emptyTile, wallTile, playerTile, mixedTrashTile, mixedBinTile, mixedTrashInBinTile,
            glassTrashTile, glassBinTile, glassTrashInBinTile, plasticTrashTile, plasticBinTile, plasticTrashInBinTile,
            paperTrashTile, paperBinTile, paperTrashInBinTile, bioTrashTile, bioBinTile, bioTrashInBinTile;

    public GamePanel(Board board, Player player, int level) {
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
        } catch (IOException e) { //przypisywanie zmiennym plików graficznych
            e.printStackTrace();
        }

        JPanel textPanel = new JPanel() { //panel z informacjami
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("Wykonane ruchy: " + player.getMoves(), 10, 30);
                g.drawString("POZIOM: " + level, getWidth() - 150, 30);
                g.drawLine(0, 40, getWidth(), 40);
            }
        };
        textPanel.setPreferredSize(new Dimension(680, 50));
        textPanel.setBackground(Color.decode("#F0F8FF"));
        add(textPanel, BorderLayout.NORTH);

        JPanel mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBoard(g);
            }
        };
        mapPanel.setPreferredSize(new Dimension(680, 560));
        add(mapPanel);
    }

    private void drawBoard(Graphics g) {
        super.paintComponent(g); // Clear the panel before drawing the new board - delete not working
        int tileSize = 40; // Adjusted to size of future textures
        for (int y = 0; y < board.board.length; y++) {
            for (int x = 0; x < board.board[y].length; x++) {
                char tile = board.board[y][x];
                Image img = switch (tile) {
                    case ' ' -> emptyTile;
                    case '#' -> wallTile;
                    case '@' -> playerTile;
                    case 'M' -> mixedTrashTile;
                    case 'G' -> glassTrashTile;
                    case 'P' -> plasticTrashTile;
                    case 'A' -> paperTrashTile;
                    case 'B' -> bioTrashTile;
                    case 'm' -> mixedBinTile;
                    case 'X' -> mixedTrashInBinTile;
                    case 'g' -> glassBinTile;
                    case 'Y' -> glassTrashInBinTile;
                    case 'p' -> plasticBinTile;
                    case 'Z' -> plasticTrashInBinTile;
                    case 'a' -> paperBinTile;
                    case 'J' -> paperTrashInBinTile;
                    case 'b' -> bioBinTile;
                    case 'K' -> bioTrashInBinTile;
                    default -> null;
                };
                if (img != null) {
                    g.drawImage(img, x * tileSize, y * tileSize, tileSize, tileSize, this);
                }
            }
        }
    } // rysowanie planszy

    public void updateBoard(Board board) {
        this.board = board;
        repaint();
    }
}