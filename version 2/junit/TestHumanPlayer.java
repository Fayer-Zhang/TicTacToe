import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.rules.TestName;
import org.junit.Rule;
import java.io.*;

import java.util.Arrays;
import static org.junit.Assert.*;

public class TestHumanPlayer {

  @Rule
  public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

  @Rule
  public TestName testName = new TestName();

  private final PrintStream originalOut = System.out;
  private final InputStream originalIn = System.in;

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void printTestMethod() {
    System.out.println("\t" + testName.getMethodName());
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setIn(originalIn);
  }

  @Test
  public void testNextPosition() {
    TicTacToe game = new TicTacToe(2, 3, 2);


    String expectedOutput = game.toString()
     + "\n\n"
     + "X to play: ";

    Player p = new HumanPlayer();

    // Capture the input and output
    System.setOut(new PrintStream(outContent));
    ByteArrayInputStream inContent = new ByteArrayInputStream("3\n".getBytes());
    System.setIn(inContent);
    boolean result = p.play(game);
    System.setOut(originalOut);
    System.setIn(originalIn);

    assertEquals(true, result);
    assertEquals(expectedOutput.trim(), outContent.toString().trim());
    assertEquals(3, game.lastPlayedPosition);
  }

  @Test
  public void testBoardFull() {
    TicTacToe game = new TicTacToe(2, 2, 2);
    game.play(1);
    game.play(2);
    game.play(3);
    game.play(4);

    Player p = new HumanPlayer();
    assertEquals(false, p.play(game));
    assertEquals("", outContent.toString().trim());
  }
}