import java.util.Scanner;

public class Levels {
    private static char[][] leveltest, level1, level2, level3;
    public static char[][] currentLevel;
    public static int playerStartX, playerStartY;

    static {
        leveltest = new char[][] {
                {'X', 'Y', 'Z', 'J', 'K'},
                {'M', 'G', 'P', 'A', 'B'},
                {'m', 'g', 'p', 'a', 'b'},
                {' ', ' ', '@', ' ', ' '},
                {'#', '#', '#', '#', '#'}
        };
        level1 = new char[][] {
                {'#', '#', '#', '#', '#'},
                {'#', 'O', ' ', ' ', '#'},
                {'#', ' ', '@', ' ', '#'},
                {'#', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#'}
        };
        level2 = new char[][] {
                {'#', '#', '#', '#', '#', '#'},
                {'#', 'O', ' ', ' ', ' ', '#'},
                {'#', 'O', 'X', '@', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#'}
        };
        level3= new char[][] {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'#', ' ', ' ', 'X', '@', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'#', ' ', ' ', 'X', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'M', 'G', 'P', 'A', 'B', ' ', ' ', ' ', ' ', ' '},
                {' ', 'X', 'Y', 'Z', 'J', 'K', ' ', 'm', 'g', 'p', 'a', 'b', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

    }

    public static void setLevel(int level) {
        switch (level) {
            case 0:
                currentLevel = leveltest;
                playerStartX = 3;
                playerStartY = 4;
                break;
            case 1:
                currentLevel = level1;
                playerStartX = 2;
                playerStartY = 2;
                break;
            case 2:
                currentLevel = level2;
                playerStartX = 3;
                playerStartY = 2;
                break;
            case 3:
                currentLevel = level3;
                playerStartX = 4;
                playerStartY = 3;
                break;
            default:
                System.out.println("Invalid level!");
        }
    }
}

