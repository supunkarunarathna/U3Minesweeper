package test;

import main.Coordinate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {

    @Test
    public void testFromInput_ValidInput() {
        Coordinate coord = Coordinate.fromInput("A1", 4);
        assertEquals(0, coord.getRow());
        assertEquals(0, coord.getCol());

        coord = Coordinate.fromInput("D4", 4);
        assertEquals(3, coord.getRow());
        assertEquals(3, coord.getCol());
    }

    @Test
    public void testFromInput_InvalidRow() {
        assertThrows(IllegalArgumentException.class, () -> {
            Coordinate.fromInput("E1", 4);
        });
    }

    @Test
    public void testFromInput_InvalidColumn() {
        assertThrows(IllegalArgumentException.class, () -> {
            Coordinate.fromInput("A5", 4);
        });
    }

    @Test
    public void testFromInput_InvalidInputFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            Coordinate.fromInput("11", 4);
        });
    }
}

