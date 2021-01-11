import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.rules.TestName;
import org.junit.Rule;

import java.util.Arrays;
import static org.junit.Assert.*;

public class TestComputerInOrderPlayer {

  @Rule
  public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

  @Rule
  public TestName testName = new TestName();

  @Before
  public void printTestMethod() {
    System.out.println("\t" + testName.getMethodName());
  }

  @Test
  public void testNextPosition() {
    TicTacToe game = new TicTacToe(2, 3, 2);

    Player p = new ComputerInOrderPlayer();
    assertEquals(true, p.play(game));
    assertEquals(1, game.lastPlayedPosition);
    assertEquals(CellValue.X, game.valueAt(1));

    game.play(3);

    assertEquals(true, p.play(game));
    assertEquals(2, game.lastPlayedPosition);
    assertEquals(CellValue.X, game.valueAt(2));

    game.play(4);

    assertEquals(true, p.play(game));
    assertEquals(5, game.lastPlayedPosition);
    assertEquals(CellValue.X, game.valueAt(5));
  }

  @Test
  public void testBoardFull() {
    TicTacToe game = new TicTacToe(2, 2, 2);
    game.play(1);
    game.play(2);
    game.play(3);
    game.play(4);

    Player p = new ComputerInOrderPlayer();
    assertEquals(false, p.play(game));
  }
}