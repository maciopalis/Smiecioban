import java.util.Scanner;

public class Game {
    private Player player;
    private Board board;

    public Game() { //fix the crash after entering level that does not exist
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter level (1,2,3): ");
        int level = keyboard.nextInt();
        switch (level) {
            case 1:
                board = new Board(level);
                player = new Player(board);
                break;
            case 2:
                board = new Board(2);
                player = new Player(board);
                break;
            case 3:
                board = new Board(3);
                player = new Player(board);
                break;
            default:
                System.out.println("Invalid level!");
        }
    }

    public void start() { // Game loop
        while (true) {
            board.printBoard();
            player.move();
            if (board.isCompleted()) {
                board.printBoard();
                System.out.println("You won!");
                break;
            }
        }
    }

}
