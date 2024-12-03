public class Board {
    public char[][] board;
    public int playerStartX, playerStartY;
    private int playerX, playerY;
    private boolean onGoalbuf = false, onGoal = false;

    public Board(int level) {
        Levels.setLevel(level);
        this.board = Levels.currentLevel;
        this.playerStartX = Levels.playerStartX;
        this.playerStartY = Levels.playerStartY;
        playerX = Levels.playerStartX;
        playerY = Levels.playerStartY;
    }

    public boolean canMove(int x, int y) {
        if (board[y][x] == 'O') {
            onGoal = true;
            return true;
        } else if (board[y][x] == 'X' || board[y][x] == 'G') { // Check if the player can push the box
            int dx = x - playerX;
            int dy = y - playerY;
            int newBoxX = x + dx;
            int newBoxY = y + dy;
            return board[newBoxY][newBoxX] == ' ' || board[newBoxY][newBoxX] == 'O';
        }
        else return board[y][x] == ' ';
    }

    public void updatePlayerPosition(int x, int y) { // Set new player position
        if (onGoal && !onGoalbuf) { //onGoal == true && onGoalbuf == false
            board[playerY][playerX] = ' ';
            onGoalbuf = true;
        }else if (onGoal && onGoalbuf) { // On goal tweaks
            board[playerY][playerX] = 'O';
            if (board[y][x] == 'O') {
                onGoal = true;
            }
            else {
                onGoal = false;
                onGoalbuf = false;
            }
        }
        else board[playerY][playerX] = ' ';

        if (board[y][x] == 'X' || board[y][x] == 'G') { // Push the box
            int dx = x - playerX;
            int dy = y - playerY;
            int newBoxX = x + dx;
            int newBoxY = y + dy;
            if (board[newBoxY][newBoxX] == 'O') {
                board[newBoxY][newBoxX] = 'G'; // Box changes to 'G' - reached goal
            } else {
                board[newBoxY][newBoxX] = 'X';
            }
            if (board[y][x] == 'G') {
                onGoal = true;
                onGoalbuf = true;
                board[y][x] = 'O';
            }
            board[y][x] = ' ';
        }
        playerX = x;
        playerY = y;
        board[playerY][playerX] = '@';
        System.out.println("Player position: " + playerX + ", " + playerY); // testing delete this line
    }

    public boolean isCompleted() {
        boolean completed = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    completed = false;
                }
            }
        }
        if (onGoal == true) {
            completed = false;
        }
        return completed;
    }
}