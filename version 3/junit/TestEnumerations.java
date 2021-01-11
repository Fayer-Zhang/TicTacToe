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
  public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested

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
      "======= level 1 =======: 3 element(s) (3 still playing)\n" +
      "======= level 2 =======: 12 element(s) (12 still playing)\n" +
      "======= level 3 =======: 38 element(s) (38 still playing)\n" +
      "======= level 4 =======: 108 element(s) (108 still playing)\n" +
      "======= level 5 =======: 174 element(s) (153 still playing)\n" +
      "======= level 6 =======: 204 element(s) (183 still playing)\n" +
      "======= level 7 =======: 153 element(s) (95 still playing)\n" +
      "======= level 8 =======: 57 element(s) (34 still playing)\n" +
      "======= level 9 =======: 15 element(s) (0 still playing)\n" +
      "that's 765 games\n" +
      "91 won by X\n" +
      "44 won by O\n" +
      "3 draw";

    assertEquals(expected.trim(), enums.toString().trim());
  }

  @Test
  public void testGenerate332String() {
    TicTacToeEnumerations enums = new TicTacToeEnumerations(3, 3, 2);
    LinkedList<LinkedList<TicTacToe>> games = enums.generateAllGames();

    String expected = "" +
      "======= level 0 =======: 1 element(s) (1 still playing)\n" +
      "======= level 1 =======: 3 element(s) (3 still playing)\n" +
      "======= level 2 =======: 12 element(s) (12 still playing)\n" +
      "======= level 3 =======: 38 element(s) (18 still playing)\n" +
      "======= level 4 =======: 50 element(s) (22 still playing)\n" +
      "======= level 5 =======: 63 element(s) (6 still playing)\n" +
      "======= level 6 =======: 17 element(s) (1 still playing)\n" +
      "======= level 7 =======: 2 element(s) (0 still playing)\n" +
      "that's 186 games\n" +
      "79 won by X\n" +
      "44 won by O\n" +
      "0 draw";

    assertEquals(expected.trim(), enums.toString().trim());
  }

  @Test
  public void testGenerate222String() {
    TicTacToeEnumerations enums = new TicTacToeEnumerations(2, 2, 2);
    LinkedList<LinkedList<TicTacToe>> games = enums.generateAllGames();

    String expected = "" +
      "======= level 0 =======: 1 element(s) (1 still playing)\n" +
      "======= level 1 =======: 1 element(s) (1 still playing)\n" +
      "======= level 2 =======: 2 element(s) (2 still playing)\n" +
      "======= level 3 =======: 2 element(s) (0 still playing)\n" +
      "that's 6 games\n" +
      "2 won by X\n" +
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
      "======= level 1 =======: 1 element(s) (1 still playing)\n" +
      "======= level 2 =======: 2 element(s) (2 still playing)\n" +
      "======= level 3 =======: 2 element(s) (2 still playing)\n" +
      "======= level 4 =======: 2 element(s) (0 still playing)\n" +
      "that's 8 games\n" +
      "0 won by X\n" +
      "0 won by O\n" +
      "2 draw";
    assertEquals(expected.trim(), enums.toString().trim());
  }
}