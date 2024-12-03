import java.util.Scanner; //delete this later after implementing the graphic menu
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game {
    private Player player;
    private Board board;
    private GamePanel gamePanel;

    public Game() {
        JFrame frame = new JFrame("Smiecioban");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // just in case might not be needed

        board = new Board(3); //testing - delete this later (auto set to level 3)
        player = new Player(board);
        gamePanel = new GamePanel(board, player);
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);
        setupKeyListener(frame);

        /*Scanner keyboard = new Scanner(System.in);    //uncomment this later
        System.out.print("Enter level (1,2,3): ");
        int level = keyboard.nextInt();
        switch (level) {
            case 1:
                board = new Board(1);
                player = new Player(board);
                gamePanel = new GamePanel(board, player);
                frame.add(gamePanel);
                frame.pack();
                frame.setVisible(true);
                setupKeyListener(frame);
                break;
            case 2:
                board = new Board(2);
                player = new Player(board);
                gamePanel = new GamePanel(board, player);
                frame.add(gamePanel);
                frame.pack();
                frame.setVisible(true);
                setupKeyListener(frame);
                break;
            case 3:
                board = new Board(3);
                player = new Player(board);
                gamePanel = new GamePanel(board, player);
                frame.add(gamePanel);
                frame.pack();
                frame.setVisible(true);
                setupKeyListener(frame);
                break;
            default:
                System.out.println("Invalid level!");
                System.exit(0);
        }*/
    }

    private void setupKeyListener(JFrame frame) {
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'w':
                        player.move('w');
                        System.out.println("w");//testing delete this
                        break;
                    case 'a':
                        player.move('a');
                        System.out.println("a");//testing delete this
                        break;
                    case 's':
                        player.move('s');
                        System.out.println("s");//testing delete this
                        break;
                    case 'd':
                        player.move('d');
                        System.out.println("d");//testing delete this
                        break;
                }
                gamePanel.updateBoard(board);
                if (board.isCompleted()) {
                    JOptionPane.showMessageDialog(null, "You won!"); //change this to graphic form
                    System.exit(0); //change this after adding graphic menu
                }
            }
        });
        frame.requestFocusInWindow();
    }
}
