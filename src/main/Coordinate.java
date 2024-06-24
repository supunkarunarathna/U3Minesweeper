package main;

/**
 * Represents a coordinate on the Minesweeper game board.
 */
public class Coordinate {
    private final int row;
    private final int col;

    /**
     * Constructs a Coordinate with the specified row and column.
     *
     * @param row the row index
     * @param col the column index
     */
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the row index of this coordinate.
     *
     * @return the row index
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column index of this coordinate.
     *
     * @return the column index
     */
    public int getCol() {
        return col;
    }

    /**
     * Creates a Coordinate from a string input and the grid size.
     *
     * @param input the string input representing the coordinate (e.g., "A1")
     * @param gridSize the size of the grid
     * @return the corresponding Coordinate
     * @throws IllegalArgumentException if the input is invalid or out of bounds
     */
    public static Coordinate fromInput(String input, int gridSize) {
        if (input == null || input.length() < 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        char rowChar = input.charAt(0);
        if (rowChar < 'A' || rowChar >= 'A' + gridSize) {
            throw new IllegalArgumentException("Invalid row input");
        }

        String colString = input.substring(1);
        int col;
        try {
            col = Integer.parseInt(colString) - 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid column input");
        }

        if (col < 0 || col >= gridSize) {
            throw new IllegalArgumentException("Column out of bounds");
        }

        int row = rowChar - 'A';
        return new Coordinate(row, col);
    }
}
