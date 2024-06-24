package test;

import main.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {

    @Test
    public void testSquareInitialization() {
        Square square = new Square();
        assertFalse(square.isMine());
        assertFalse(square.isRevealed());
        assertEquals(0, square.getAdjacentMines());
    }

    @Test
    public void testSetAndGetMine() {
        Square square = new Square();
        square.setMine(true);
        assertTrue(square.isMine());
    }

    @Test
    public void testSetAndGetRevealed() {
        Square square = new Square();
        square.setRevealed(true);
        assertTrue(square.isRevealed());
    }

    @Test
    public void testSetAndGetAdjacentMines() {
        Square square = new Square();
        square.setAdjacentMines(3);
        assertEquals(3, square.getAdjacentMines());
    }

    @Test
    public void testToString() {
        Square square = new Square();
        assertEquals("_", square.toString());

        square.setMine(true);
        square.setRevealed(true);
        assertEquals("*", square.toString());

        square.setMine(false);
        square.setAdjacentMines(2);
        assertEquals("2", square.toString());
    }
}

