package test;

import main.Coordinate;
import main.GameBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {
    private GameBoard gameBoard;

    @BeforeEach
    public void setUp() {
        gameBoard = new GameBoard(4, 4);
    }

    @Test
    public void testInitialization() {
        assertNotNull(gameBoard);
        assertFalse(gameBoard.isGameOver());
        assertFalse(gameBoard.isWin());
    }

    @Test
    public void testMineCount() {
        int mineCount = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
//                if (gameBoard.isMine(row, col)) {
//                    mineCount++;
//                }
                if (gameBoard.board[row][col].isMine()) {
                    mineCount++;
                }
            }
        }
        assertEquals(4, mineCount);
    }

    @Test
    public void testRevealSquare_Mine() {
        Coordinate coord = findFirstMine();
        gameBoard.revealSquare(coord);
        assertTrue(gameBoard.isGameOver());
    }

    @Test
    public void testRevealSquare_Empty() {
        Coordinate coord = findFirstEmpty();
        gameBoard.revealSquare(coord);
        assertFalse(gameBoard.isGameOver());
//        assertTrue(gameBoard.isRevealed(coord.getRow(), coord.getCol()));
        assertTrue(gameBoard.board[coord.getRow()][coord.getCol()].isRevealed());
    }

    private Coordinate findFirstMine() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (gameBoard.board[row][col].isMine()) {
                    return new Coordinate(row, col);
                }
            }
        }
        return null;
    }

    private Coordinate findFirstEmpty() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (!gameBoard.board[row][col].isMine()) {
                    return new Coordinate(row, col);
                }
            }
        }
        return null;
    }
}

