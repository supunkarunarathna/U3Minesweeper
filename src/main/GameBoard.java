package main;

import java.util.Random;

/**
 * Represents the Minesweeper game board.
 */

public class GameBoard {
    private final int size;
    private final int mineCount;
    public final Square[][] board;
    private boolean gameOver;
    private boolean win;

    /**
     * Constructs a GameBoard with the specified size and number of mines.
     *
     * @param size the size of the game board (width and height)
     * @param mineCount the number of mines to place on the board
     */
    public GameBoard(int size, int mineCount) {
        this.size = size;
        this.mineCount = mineCount;
        this.board = new Square[size][size];
        this.gameOver = false;
        this.win = false;

        initializeBoard();
        placeMines();
        calculateAdjacentMines();
    }

    /**
     * Initializes the game board by creating Square objects for each cell.
     */
    private void initializeBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Square();
            }
        }
    }

    /**
     * Randomly places mines on the game board.
     */
    private void placeMines() {
        Random random = new Random();
        int placedMines = 0;
        while (placedMines < mineCount) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            if (!board[row][col].isMine()) {
                board[row][col].setMine(true);
                placedMines++;
            }
        }
    }

    /**
     * Calculates the number of adjacent mines for each cell on the game board.
     */
    private void calculateAdjacentMines() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!board[row][col].isMine()) {
                    board[row][col].setAdjacentMines(countAdjacentMines(row, col));
                }
            }
        }
    }

    /**
     * Counts the number of mines adjacent to a given cell.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return the number of adjacent mines
     */
    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isInBounds(row + i, col + j) && board[row + i][col + j].isMine()) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Checks if a given cell is within the bounds of the game board.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return true if the cell is within bounds, false otherwise
     */
    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    /**
     * Displays the current state of the game board.
     */
    public void displayBoard() {
        System.out.print("  ");
        for (int col = 1; col <= size; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < size; row++) {
            System.out.print((char) ('A' + row) + " ");
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Reveals the square at the specified coordinate.
     *
     * @param coordinate the coordinate of the square to reveal
     */
    public void revealSquare(Coordinate coordinate) {
        if (gameOver || win) {
            return;
        }

        int row = coordinate.getRow();
        int col = coordinate.getCol();

        if (board[row][col].isRevealed()) {
            return;
        }

        if (board[row][col].isMine()) {
            gameOver = true;
            revealAllMines();
            return;
        }

        reveal(row, col);

        if (checkWin()) {
            win = true;
            gameOver = true;
        }
    }

    /**
     * Recursively reveals squares starting from the specified cell.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     */
    private void reveal(int row, int col) {
        if (!isInBounds(row, col) || board[row][col].isRevealed()) {
            return;
        }

        board[row][col].setRevealed(true);

        if (board[row][col].getAdjacentMines() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    reveal(row + i, col + j);
                }
            }
        }
    }

    /**
     * Checks if the player has won the game.
     *
     * @return true if the player has won, false otherwise
     */
    private boolean checkWin() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!board[row][col].isMine() && !board[row][col].isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Reveals all the mines on the game board.
     */
    private void revealAllMines() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col].isMine()) {
                    board[row][col].setRevealed(true);
                }
            }
        }
    }

    /**
     * Checks if the game is over.
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Checks if the player has won the game.
     *
     * @return true if the player has won, false otherwise
     */
    public boolean isWin() {
        return win;
    }
}