import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.rules.TestName;
import org.junit.Rule;

import java.util.Arrays;
import static org.junit.Assert.*;

public class TestComputerRandomPlayer {

  @Rule
  public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

  @Rule
  public TestName testName = new TestName();

  @Before
  public void printTestMethod() {
    System.out.println("\t" + testName.getMethodName());
  }

  @Test
  public void testRandomPosition() {

    TicTacToe game;
    Player p = new ComputerRandomPlayer();

    int firstPlay;
    int nextPlay;

    game = new TicTacToe(500, 500, 2);
    assertEquals(true, p.play(game));
    firstPlay = game.lastPlayedPosition;

    int numDups = 0;
    for (int i=0; i<100; i++) {
      game = new TicTacToe(500, 500, 2);
      assertEquals(true, p.play(game));
      nextPlay = game.lastPlayedPosition;
      if (firstPlay == nextPlay) {
        numDups += 1;
      }
    }

    assertTrue(numDups < 70);
  }

  @Test
  public void testFindAvailablePosition() {
    TicTacToe game = new TicTacToe(2, 2, 2);

    Player p = new ComputerRandomPlayer();
    assertEquals(true, p.play(game));
    assertEquals(true, p.play(game));
    assertEquals(true, p.play(game));
    assertEquals(true, p.play(game));
    assertNotEquals(GameState.PLAYING, game.gameState);
  }

  @Test
  public void testBoardFull() {
    TicTacToe game = new TicTacToe(2, 2, 2);
    game.play(1);
    game.play(2);
    game.play(3);
    game.play(4);

    Player p = new ComputerRandomPlayer();
    assertEquals(false, p.play(game));
  }
}