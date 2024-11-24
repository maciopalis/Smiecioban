// Player.java
import java.util.Scanner;

public class Player {
    private Board board;
    private int x, y;

    public Player(Board board) {
        this.board = board;
        this.x = Levels.playerStartX;
        this.y = Levels.playerStartY;
    }

    public void move() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter move (WASD): ");
        char move = keyboard.next().charAt(0); //.charAt(0) takes only the first character

        int newX = x, newY = y;
        switch (move) { // Player movement
            case 'w':
                newY = y - 1;
                break;
            case 'a':
                newX = x - 1;
                break;
            case 's':
                newY = y + 1;
                break;
            case 'd':
                newX = x + 1;
                break;
            default:
                System.out.println("Invalid key!");
        }

        if (newX != x || newY != y) { // Only if the player moved
            if (board.canMove(newX, newY)) {
                x = newX;
                y = newY;
                board.updatePlayerPosition(x, y);
            } else if (!board.canMove(newX, newY)) {
                System.out.println("Invalid move!");
            }
        }
    }
}