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
  public void testEqualsSymmetricBoardSquare() {
    TicTacToe game = new TicTacToe();
    TicTacToe compareTo;

    game.play(1);

    // Play in a corner
    // X |  |
    //   |  |
    //   |  |

    // Check all corners
    compareTo = new TicTacToe();
    compareTo.play(1);
    assertEquals(true, game.equals(compareTo));

    compareTo = new TicTacToe();
    compareTo.play(3);
    assertEquals(true, game.equals(compareTo));

    compareTo = new TicTacToe();
    compareTo.play(7);
    assertEquals(true, game.equals(compareTo));

    compareTo = new TicTacToe();
    compareTo.play(9);
    assertEquals(true, game.equals(compareTo));

    // Check non corners
    compareTo = new TicTacToe();
    compareTo.play(2);
    assertEquals(false, game.equals(compareTo));

    compareTo = new TicTacToe();
    compareTo.play(4);
    assertEquals(false, game.equals(compareTo));

    compareTo = new TicTacToe();
    compareTo.play(5);
    assertEquals(false, game.equals(compareTo));

    compareTo = new TicTacToe();
    compareTo.play(6);
    assertEquals(false, game.equals(compareTo));

    compareTo = new TicTacToe();
    compareTo.play(8);
    assertEquals(false, game.equals(compareTo));

  }

  @Test
  public void testEqualsResetsTransformations() {
    TicTacToe originalGame = new TicTacToe();
    originalGame.play(1);

    TicTacToe game = new TicTacToe();
    game.play(1);

    TicTacToe compareTo;

    // Check all corners
    compareTo = new TicTacToe();
    compareTo.play(3);
    assertEquals(true, game.equals(compareTo));

    assertEquals(originalGame.toString(), game.toString());
  }

  @Test
  public void testToStringNoRotation() {
    TicTacToe game = new TicTacToe(3, 5, 3);

    game.play(1);
    game.play(2);
    game.play(3);
    game.play(4);
    game.play(5);
    game.play(6);
    game.play(11);
    game.play(15);

    String expected = "" +
      " X | O | X | O | X \n" +
      "-------------------\n" +
      " O |   |   |   |   \n" +
      "-------------------\n" +
      " X |   |   |   | O ";

    assertEquals(expected.trim(), game.toString().trim());
  }

  @Test
  public void testToStringOneRotation() {
    TicTacToe game = new TicTacToe(3, 5, 3);

    game.play(1);
    game.play(2);
    game.play(3);
    game.play(4);
    game.play(5);
    game.play(6);
    game.play(11);
    game.play(15);

    Transformer.horizontalFlip(game.numRows, game.numColumns, game.boardIndexes);

    String expected = "" +
      " X |   |   |   | O \n" +
      "-------------------\n" +
      " O |   |   |   |   \n" +
      "-------------------\n" +
      " X | O | X | O | X \n";

    assertEquals(expected.trim(), game.toString().trim());
  }

  @Test
  public void testToStringMultipleRotation() {
    TicTacToe game = new TicTacToe(3, 5, 3);

    game.play(1);
    game.play(2);
    game.play(3);
    game.play(4);
    game.play(5);
    game.play(6);
    game.play(11);
    game.play(15);

    Transformer.horizontalFlip(game.numRows, game.numColumns, game.boardIndexes);
    Transformer.verticalFlip(game.numRows, game.numColumns, game.boardIndexes);

    String expected = "" +
      " O |   |   |   | X \n" +
      "-------------------\n" +
      "   |   |   |   | O \n" +
      "-------------------\n" +
      " X | O | X | O | X \n";

    assertEquals(expected.trim(), game.toString().trim());
  }

}