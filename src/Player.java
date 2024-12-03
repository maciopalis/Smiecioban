// Player.java
import java.util.Scanner;

public class Player {
    private Board board;
    private int x, y;
    private int moves;

    public Player(Board board) {
        this.board = board;
        this.x = Levels.playerStartX;
        this.y = Levels.playerStartY;
        this.moves = 0;
    }

    public void move(char direction) {
        int newX = x, newY = y;
        switch (direction) { // Player movement
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
                moves++;
            } else if (!board.canMove(newX, newY)) {//delete this line later
                System.out.println("Invalid move!");
            }
        }

    }
    public int getMoves() {
        return moves;
    }
}