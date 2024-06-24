package test;

import main.Minesweeper;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MinesweeperTest {

    String newLine = System.getProperty("line.separator");

    @Test
    public void testStartGame() {
        String input = "2\n1\nA1\nB1\nB2\nA2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Minesweeper minesweeper = new Minesweeper();
        minesweeper.startGame();
    }
}

