import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.rules.TestName;
import org.junit.Rule;

import java.util.Arrays;
import java.util.LinkedList;
import static org.junit.Assert.*;

import java.util.LinkedList;

public class TestEnumerations {

  @Rule
  public Timeout globalTimeout = Timeout.seconds(3); // 1 seconds max per method tested

  @Rule
  public TestName testName = new TestName();

  @Before
  public void printTestMethod() {
    System.out.println("\t" + testName.getMethodName());
  }

  @Test
  public void testGenerate333String() {
    TicTacToeEnumerations enums = new TicTacToeEnumerations(3, 3, 3);
    LinkedList<LinkedList<TicTacToe>> games = enums.generateAllGames();

    String expected = "" +
      "======= level 0 =======: 1 element(s) (1 still playing)\n" +
      "======= level 1 =======: 9 element(s) (9 still playing)\n" +
      "======= level 2 =======: 72 element(s) (72 still playing)\n" +
      "======= level 3 =======: 252 element(s) (252 still playing)\n" +
      "======= level 4 =======: 756 element(s) (756 still playing)\n" +
      "======= level 5 =======: 1260 element(s) (1140 still playing)\n" +
      "======= level 6 =======: 1520 element(s) (1372 still playing)\n" +
      "======= level 7 =======: 1140 element(s) (696 still playing)\n" +
      "======= level 8 =======: 390 element(s) (222 still playing)\n" +
      "======= level 9 =======: 78 element(s) (0 still playing)\n" +
      "that's 5478 games\n" +
      "564 won by X\n" +
      "316 won by O\n" +
      "78 draw";

    assertEquals(expected.trim(), enums.toString().trim());
  }

  @Test
  public void testGenerate332String() {
    TicTacToeEnumerations enums = new TicTacToeEnumerations(3, 3, 2);
    LinkedList<LinkedList<TicTacToe>> games = enums.generateAllGames();

    String expected = "" +
      "======= level 0 =======: 1 element(s) (1 still playing)\n" +
      "======= level 1 =======: 9 element(s) (9 still playing)\n" +
      "======= level 2 =======: 72 element(s) (72 still playing)\n" +
      "======= level 3 =======: 252 element(s) (112 still playing)\n" +
      "======= level 4 =======: 336 element(s) (136 still playing)\n" +
      "======= level 5 =======: 436 element(s) (40 still playing)\n" +
      "======= level 6 =======: 116 element(s) (4 still playing)\n" +
      "======= level 7 =======: 12 element(s) (0 still playing)\n" +
      "that's 1234 games\n" +
      "548 won by X\n" +
      "312 won by O\n" +
      "0 draw";
    assertEquals(expected.trim(), enums.toString().trim());
  }

  @Test
  public void testGenerate222String() {
    TicTacToeEnumerations enums = new TicTacToeEnumerations(2, 2, 2);
    LinkedList<LinkedList<TicTacToe>> games = enums.generateAllGames();

    String expected = "" +
      "======= level 0 =======: 1 element(s) (1 still playing)\n" +
      "======= level 1 =======: 4 element(s) (4 still playing)\n" +
      "======= level 2 =======: 12 element(s) (12 still playing)\n" +
      "======= level 3 =======: 12 element(s) (0 still playing)\n" +
      "that's 29 games\n" +
      "12 won by X\n" +
      "0 won by O\n" +
      "0 draw";
    assertEquals(expected.trim(), enums.toString().trim());
  }

  @Test
  public void testGenerate223String() {
    TicTacToeEnumerations enums = new TicTacToeEnumerations(2, 2, 3);
    LinkedList<LinkedList<TicTacToe>> games = enums.generateAllGames();

    String expected = "" +
      "======= level 0 =======: 1 element(s) (1 still playing)\n" +
      "======= level 1 =======: 4 element(s) (4 still playing)\n" +
      "======= level 2 =======: 12 element(s) (12 still playing)\n" +
      "======= level 3 =======: 12 element(s) (12 still playing)\n" +
      "======= level 4 =======: 6 element(s) (0 still playing)\n" +
      "that's 35 games\n" +
      "0 won by X\n" +
      "0 won by O\n" +
      "6 draw";
    assertEquals(expected.trim(), enums.toString().trim());
  }
}