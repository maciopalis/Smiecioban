public class Board {
    public char[][] board;
    public int playerStartX, playerStartY;
    private int playerX, playerY;
    private boolean onGoalbuf = false;
    private char onGoal = '0';
    private char trashPushed = '0';

    public Board(int level) {
        Levels.setLevel(level);
        this.board = Levels.currentLevel;
        this.playerStartX = Levels.playerStartX;
        this.playerStartY = Levels.playerStartY;
        playerX = Levels.playerStartX;
        playerY = Levels.playerStartY;
    }

    public boolean canMove(int x, int y) {
        if (board[y][x] == 'm' || board[y][x] == 'g' || board[y][x] == 'p' || board[y][x] == 'a' || board[y][x] == 'b') {
            return true;
        } else if (board[y][x] == 'M' || board[y][x] == 'G' || board[y][x] == 'P' || board[y][x] == 'A' || board[y][x] == 'B' ||
                board[y][x] == 'X' || board[y][x] == 'Y' || board[y][x] == 'Z' || board[y][x] == 'J' || board[y][x] == 'K') { // Check if the player can push the box
            int dx = x - playerX;
            int dy = y - playerY;
            int newBoxX = x + dx;
            int newBoxY = y + dy;
            if (Character.toLowerCase(board[y][x]) == board[newBoxY][newBoxX]){ //zmienic wszystkie nazwy mała duza litera to ma byc smiec mała to pusty smietnik, duza to pełny
                return true;
            }
            else return board[newBoxY][newBoxX] == ' ';
        }
        else return board[y][x] == ' ';
    }

    public void updatePlayerPosition(int x, int y) { // Set new player position

        if (board[y][x] == 'm' || board[y][x] == 'g' || board[y][x] == 'p' || board[y][x] == 'a' || board[y][x] == 'b') { //emptyBin rules
            if (onGoal != '0' && !onGoalbuf) { //onGoal = onBin && onGoalbuf = false
                onGoal = board[y][x];
                board[playerY][playerX] = ' ';
                onGoalbuf = true;
            }else if (onGoal != '0' && onGoalbuf) { // On goal tweaks
                board[playerY][playerX] = onGoal;
                onGoal = board[y][x];
            } else {
                onGoal = board[y][x];
                board[playerY][playerX] = ' ';
                onGoalbuf = true;
            }
        }else {
            if (onGoal != '0') {
                board[playerY][playerX] = onGoal;
                onGoal = '0';
                onGoalbuf = false;
            } else {
                board[playerY][playerX] = ' ';
            }
        }
        int dx = x - playerX;
        int dy = y - playerY;
        int newBoxX = x + dx;
        int newBoxY = y + dy;
        if (board[y][x] == 'X' || board[y][x] == 'Y' || board[y][x] == 'Z' || board[y][x] == 'J' || board[y][x] == 'K') { // Push the box
            switch (board[y][x]) {
                case 'X':
                    //board[newBoxY][newBoxX] = 'M';
                    trashPushed = 'M';
                    break;
                case 'Y':
                    //board[newBoxY][newBoxX] = 'G';
                    trashPushed = 'G';
                    break;
                case 'Z':
                    //board[newBoxY][newBoxX] = 'P';
                    trashPushed = 'P';
                    break;
                case 'J':
                    //board[newBoxY][newBoxX] = 'A';
                    trashPushed = 'A';
                    break;
                case 'K':
                    //board[newBoxY][newBoxX] = 'B';
                    trashPushed = 'B';
                    break;
                default:
                    System.out.println("ERROR_Board.updatePlayerPosition.1");
                    //trashPushed = '0';s
                    break;
                }
            board[newBoxY][newBoxX] = trashPushed;
            onGoal = Character.toLowerCase(trashPushed);
            onGoalbuf = true;
            board[y][x] = ' ';
        }
        if (board[y][x] == 'M' || board[y][x] == 'G' || board[y][x] == 'P' || board[y][x] == 'A' || board[y][x] == 'B'){
            trashPushed = board[y][x];
            switch (board[newBoxY][newBoxX]) {
                case 'm':
                    board[newBoxY][newBoxX] = 'X';
                    trashPushed = 'M';
                    break;
                case 'g':
                    board[newBoxY][newBoxX] = 'Y';
                    trashPushed = 'G';
                    break;
                case 'p':
                    board[newBoxY][newBoxX] = 'Z';
                    trashPushed = 'P';
                    break;
                case 'a':
                    board[newBoxY][newBoxX] = 'J';
                    trashPushed = 'A';
                    break;
                case 'b':
                    board[newBoxY][newBoxX] = 'K';
                    trashPushed = 'B';
                    break;
                default:
                    System.out.println("ERROR_Board.updatePlayerPosition.2");
                    break;
            }
        }
        playerX = x;
        playerY = y;
        board[playerY][playerX] = '@';
        //System.out.println("Player position: " + playerX + ", " + playerY); // testing delete this line
        System.out.println("onGoal = " + onGoal); // testing delete this line
        System.out.println("onGoalbuf = " + onGoalbuf); // testing delete this line
    }

    public boolean isCompleted() {
        boolean completed = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'm' || board[i][j] == 'g' || board[i][j] == 'p' || board[i][j] == 'a' || board[i][j] == 'b') {
                    completed = false;
                }
            }
        }
        if (onGoal != '0') {
            completed = false;
        }
        return completed;
    }
}