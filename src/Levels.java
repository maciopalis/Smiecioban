import java.util.Scanner;

public class Levels {
    private static char[][] level1, level2, level3;
    public static char[][] currentLevel;
    public static int playerStartX, playerStartY;

    static {
        level1 = new char[][] {
                    {'#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', '#'},
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
                {'#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', 'O', 'X', '@', ' ', ' ', ' ', '#'},
                {'#', ' ', 'O', 'X', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };

    }

    public static void setLevel(int level) {
        switch (level) {
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

