public class Board {
    public char[][] board;
    public int playerStartX, playerStartY;
    private int playerX, playerY;
    private boolean onGoalbuf = false;
    private char onGoal = '0';
    private char trashPushed = '0';
    private char miTf = 'X', glTf = 'Y', plTf = 'Z', paTf = 'J', biTf = 'K';
    private char miTe = 'm', glTe = 'g', plTe = 'p', paTe = 'a', biTe = 'b';
    private char miT = 'M', glT = 'G', plT = 'P', paT = 'A', biT = 'B';

    public Board(int level) {
        Levels.setLevel(level);
        this.board = Levels.currentLevel;
        this.playerStartX = Levels.playerStartX;
        this.playerStartY = Levels.playerStartY;
        playerX = Levels.playerStartX;
        playerY = Levels.playerStartY;
    }

    public boolean canMove(int x, int y) {
        if (board[y][x] == miTe || board[y][x] == glTe || board[y][x] == plTe || board[y][x] == paTe || board[y][x] == biTe) {
            return true;
        } else if (board[y][x] == miT || board[y][x] == glT || board[y][x] == plT || board[y][x] == paT || board[y][x] == biT ||
                board[y][x] == miTf || board[y][x] == glTf || board[y][x] == plTf || board[y][x] == paTf || board[y][x] == biTf) { // Check if the player can push the box
            int dx = x - playerX;
            int dy = y - playerY;
            int newBoxX = x + dx;
            int newBoxY = y + dy;
            if (Character.toLowerCase(board[y][x]) == board[newBoxY][newBoxX]){
                return true;
            }
            else return board[newBoxY][newBoxX] == ' ';
        }
        else return board[y][x] == ' ';
    }

    public void updatePlayerPosition(int x, int y) { // Set new player position

        if (board[y][x] == miTe || board[y][x] == glTe || board[y][x] == plTe || board[y][x] == paTe || board[y][x] == biTe) { //emptyBin rules
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
        if (board[y][x] == miTf || board[y][x] == glTf || board[y][x] == plTf || board[y][x] == paTf || board[y][x] == biTf) { // Push the box
            switch (board[y][x]) {
                case 'X': //miTf
                    trashPushed = miT;
                    break;
                case 'Y': //glTf
                    trashPushed = glT;
                    break;
                case 'Z': //plTf
                    trashPushed = plT;
                    break;
                case 'J': //paTf
                    trashPushed = paT;
                    break;
                case 'K': //biTf
                    trashPushed = biT;
                    break;
                default:
                    System.out.println("ERROR_Board.updatePlayerPosition.1");
                    break;
            }
            board[newBoxY][newBoxX] = trashPushed;
            onGoal = Character.toLowerCase(trashPushed);
            onGoalbuf = true;
            board[y][x] = ' ';
        }
        if (board[y][x] == miT || board[y][x] == glT || board[y][x] == plT || board[y][x] == paT || board[y][x] == biT){
            trashPushed = board[y][x];
            switch (board[newBoxY][newBoxX]) {
                case 'm': //miTe
                    board[newBoxY][newBoxX] = miTf;
                    trashPushed = miT;
                    break;
                case 'g': //glTe
                    board[newBoxY][newBoxX] = glTf;
                    trashPushed = glT;
                    break;
                case 'p': //plTe
                    board[newBoxY][newBoxX] = plTf;
                    trashPushed = plT;
                    break;
                case 'a': //paTe
                    board[newBoxY][newBoxX] = paTf;
                    trashPushed = paT;
                    break;
                case 'b': //biTe
                    board[newBoxY][newBoxX] = biTf;
                    trashPushed = biT;
                    break;
                default:
                    board[newBoxY][newBoxX] = trashPushed;
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
                if (board[i][j] == miTe || board[i][j] == glTe || board[i][j] == plTe || board[i][j] == paTe || board[i][j] == biTe) {
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