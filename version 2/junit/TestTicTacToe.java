import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.rules.TestName;
import org.junit.Rule;

import java.util.Arrays;
import static org.junit.Assert.*;

public class TestTicTacToe {

  @Rule
  public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

  @Rule
  public TestName testName = new TestName();

  @Before
  public void printTestMethod() {
    System.out.println("\t" + testName.getMethodName());
  }

  @Test
  public void testEqualsNull() {
    TicTacToe game = new TicTacToe();
    assertEquals(false, game.equals(null));
  }

  @Test
  public void testEqualsNotAGame() {
    TicTacToe game = new TicTacToe();
    assertEquals(false, game.equals("invalid input"));
  }

  @Test
  public void testEqualsDifferentInputs() {
    TicTacToe game = new TicTacToe(5,4,3);
    TicTacToe compareTo;

    compareTo = new TicTacToe(10,4,3);
    assertEquals(false, game.equals(compareTo));

    compareTo = new TicTacToe(5,10,3);
    assertEquals(false, game.equals(compareTo));

    compareTo = new TicTacToe(5,4,2);
    assertEquals(false, game.equals(compareTo));
  }

  @Test
  public void testEqualsSameInputs() {
    TicTacToe game = new TicTacToe(5,4,3);
    TicTacToe compareTo;

    compareTo = new TicTacToe(5,4,3);
    assertEquals(true, game.equals(compareTo));
  }

  @Test
  public void testEqualsCheckBoard() {
    TicTacToe game = new TicTacToe();
    TicTacToe compareTo;

    compareTo = new TicTacToe();
    game.play(5);
    game.play(4);
    game.play(3);
    game.play(2);
    assertEquals(false, game.equals(compareTo));

    compareTo.play(3);
    assertEquals(false, game.equals(compareTo));

    compareTo.play(2);
    assertEquals(false, game.equals(compareTo));

    compareTo.play(5);
    assertEquals(false, game.equals(compareTo));

    compareTo.play(4);
    assertEquals(true, game.equals(compareTo));
  }

  @Test
  public void testCloneNextPlayGameOver() {
    TicTacToe game = new TicTacToe(2,2,2);
    game.play(1);
    game.play(2);
    game.play(3);

    assertEquals(GameState.XWIN, game.gameState);
    assertEquals(null, game.cloneNextPlay(4));
  }

  @Test
  public void testCloneNextPlayInvalid() {
    TicTacToe game = new TicTacToe(2,2,2);
    assertEquals(null, game.cloneNextPlay(99));
  }

  @Test
  public void testCloneNextPlayCopyFields() {
    TicTacToe game = new TicTacToe(2,2,2);
    game.play(3);

    TicTacToe cloned = game.cloneNextPlay(4);

    assertEquals(1, game.numRounds);
    assertEquals(2, cloned.numRounds);

    assertEquals(3, game.lastPlayedPosition);
    assertEquals(4, cloned.lastPlayedPosition);

    assertEquals(CellValue.EMPTY, game.board[0]);
    assertEquals(CellValue.EMPTY, game.board[1]);
    assertEquals(CellValue.X, game.board[2]);
    assertEquals(CellValue.EMPTY, game.board[3]);

    assertEquals(CellValue.EMPTY, cloned.board[0]);
    assertEquals(CellValue.EMPTY, cloned.board[1]);
    assertEquals(CellValue.X, cloned.board[2]);
    assertEquals(CellValue.O, cloned.board[3]);
  }

  @Test
  public void testEmptyPositionsNewGame()
  {
    TicTacToe game = new TicTacToe(2,2,2);
    assertArrayEquals(new int[] {1,2,3,4}, game.emptyPositions());
  }

  @Test
  public void testEmptyPositionsGamePlayed()
  {
    TicTacToe game = new TicTacToe(2,2,2);

    game.play(2);
    assertArrayEquals(new int[] {1,3,4}, game.emptyPositions());

    game.play(1);
    assertArrayEquals(new int[] {3,4}, game.emptyPositions());

    game.play(4);
    assertArrayEquals(new int[] {3}, game.emptyPositions());

    game.play(3);
    assertArrayEquals(new int[0], game.emptyPositions());
  }

}