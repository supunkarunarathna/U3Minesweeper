package main;

import java.util.Scanner;

/**
 * The Minesweeper class to handle the game logic and user interactions.
 */
public class Minesweeper {

    /**
     * Starts the Minesweeper game, handles user input, and manages game state.
     */
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Minesweeper!");

        int size = getSizeInput(scanner);
        int mineCount = getMineCountInput(scanner, size);

        GameBoard gameBoard = new GameBoard(size, mineCount);
        gameBoard.displayBoard();

        while (!gameBoard.isGameOver()) {
            System.out.print("Select a square to reveal (e.g. A1): ");
            String input = scanner.next();
            try {
                Coordinate coordinate = Coordinate.fromInput(input, size);
                gameBoard.revealSquare(coordinate);
                gameBoard.displayBoard();
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect input.");
            }
        }

        if (gameBoard.isWin()) {
            System.out.println("Congratulations, you have won the game!");
        } else {
            System.out.println("Oh no, you detonated a mine! Game over.");
        }

        System.out.println("Press any key to play again...");
        scanner.next();
    }

    /**
     * Gets the size of the game grid from user input.
     *
     * @param scanner the Scanner object to read user input
     * @return the size of the grid
     */
    private int getSizeInput(Scanner scanner) {
        int size = 0;
        while (size < 2 || size > 10) {
            System.out.print("Enter the size of the grid (e.g. 4 for a 4x4 grid): ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size < 2) {
                    System.out.println("Minimum size of grid is 2.");
                } else if (size > 10) {
                    System.out.println("Maximum size of grid is 10.");
                }
            } else {
                System.out.println("Incorrect input.");
                scanner.next();
            }
        }
        return size;
    }

    /**
     * Gets the number of mines to place on the game grid from user input.
     *
     * @param scanner the Scanner object to read user input
     * @param size the size of the grid
     * @return the number of mines
     */
    private int getMineCountInput(Scanner scanner, int size) {
        int maxMines = (int) (size * size * 0.35);
        int mineCount = -1;
        while (mineCount < 1 || mineCount > maxMines) {
            System.out.print("Enter the number of mines to place on the grid (maximum is 35% of the total squares): ");
            if (scanner.hasNextInt()) {
                mineCount = scanner.nextInt();
                if (mineCount < 1) {
                    System.out.println("There must be at least 1 mine.");
                } else if (mineCount > maxMines) {
                    System.out.println("Maximum number is 35% of total squares.");
                }
            } else {
                System.out.println("Incorrect input.");
                scanner.next();
            }
        }
        return mineCount;
    }
}
