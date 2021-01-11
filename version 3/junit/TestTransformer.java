import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.rules.TestName;
import org.junit.Rule;

import java.util.Arrays;
import static org.junit.Assert.*;

public class TestTransformer {

  @Rule
  public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

  @Rule
  public TestName testName = new TestName();

  @Before
  public void printTestMethod() {
    System.out.println("\t" + testName.getMethodName());
  }

  @Test
  public void test_identity_invalidNumRowsColumns() {
    int[] board = new int[] { 99 };
    assertEquals(false, Transformer.identity(0, 1, board));
    assertEquals(false, Transformer.identity(1, 0, board));
  }

  @Test
  public void test_identity_invalidBoardSize() {
    int[] board = new int[] { 99 };
    assertEquals(false, Transformer.identity(1, 2, board));
  }

  @Test
  public void test_identity_overwriteData() {
    int[] board = new int[] { 98, 99};
    assertEquals(true, Transformer.identity(1, 2, board));
    assertArrayEquals(new int[] { 0, 1 }, board);
  }

  @Test
  public void test_identity_indexValues() {
    int[] board = new int[6];
    assertEquals(true, Transformer.identity(2, 3, board));
    assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5 }, board);
  }

  @Test
  public void test_horizontalFlip_invalidNumRowsColumns() {
    int[] board = new int[] { 99 };
    assertEquals(false, Transformer.horizontalFlip(0, 1, board));
    assertEquals(false, Transformer.horizontalFlip(1, 0, board));
  }

  @Test
  public void test_horizontalFlip_invalidBoardSize() {
    int[] board = new int[] { 99 };
    assertEquals(false, Transformer.horizontalFlip(1, 2, board));
  }

  @Test
  public void test_horizontalFlip_1x1() {
    int[] board = new int[] { 99 };
    assertEquals(true, Transformer.horizontalFlip(1, 1, board));
    assertArrayEquals(new int[] { 99 }, board);
  }

  @Test
  public void test_horizontalFlip_1x2() {
    int[] board = new int[] {
      98, 99
    };

    int[] expected = new int[] {
      98, 99
    };

    assertEquals(true, Transformer.horizontalFlip(1, 2, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_horizontalFlip_2x1() {
    int[] board = new int[] {
      98,
      99
    };

    int[] expected = new int[] {
      99,
      98
    };

    assertEquals(true, Transformer.horizontalFlip(2, 1, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_horizontalFlip_2x2() {
    int[] board = new int[] {
      96, 97,
      98, 99
    };

    int[] expected = new int[] {
      98, 99,
      96, 97
    };

    assertEquals(true, Transformer.horizontalFlip(2, 2, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_horizontalFlip_2x3() {
    int[] board = new int[] {
      94, 95, 96,
      97, 98, 99
    };

    int[] expected = new int[] {
      97, 98, 99,
      94, 95, 96
    };

    assertEquals(true, Transformer.horizontalFlip(2, 3, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_horizontalFlip_3x2() {
    int[] board = new int[] {
      94, 95,
      96, 97,
      98, 99
    };

    int[] expected = new int[] {
      98, 99,
      96, 97,
      94, 95
    };

    assertEquals(true, Transformer.horizontalFlip(3, 2, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_horizontalFlip_3x3() {
    int[] board = new int[] {
      91, 92, 93,
      94, 95, 96,
      97, 98, 99
    };

    int[] expected = new int[] {
      97, 98, 99,
      94, 95, 96,
      91, 92, 93,
    };

    assertEquals(true, Transformer.horizontalFlip(3, 3, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_horizontalFlip_5x5() {
    int[] board = new int[] {
      10, 11, 12, 13, 14,
      20, 21, 22, 23, 24,
      30, 31, 32, 33, 34,
      40, 41, 42, 43, 44,
      50, 51, 52, 53, 54
    };

    int[] expected = new int[] {
      50, 51, 52, 53, 54,
      40, 41, 42, 43, 44,
      30, 31, 32, 33, 34,
      20, 21, 22, 23, 24,
      10, 11, 12, 13, 14
    };

    assertEquals(true, Transformer.horizontalFlip(5, 5, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_horizontalFlip_6x5() {
    int[] board = new int[] {
      10, 11, 12, 13, 14,
      20, 21, 22, 23, 24,
      30, 31, 32, 33, 34,
      40, 41, 42, 43, 44,
      50, 51, 52, 53, 54,
      60, 61, 62, 63, 64
    };

    int[] expected = new int[] {
      60, 61, 62, 63, 64,
      50, 51, 52, 53, 54,
      40, 41, 42, 43, 44,
      30, 31, 32, 33, 34,
      20, 21, 22, 23, 24,
      10, 11, 12, 13, 14
    };

    assertEquals(true, Transformer.horizontalFlip(6, 5, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_horizontalFlip_5x6() {
    int[] board = new int[] {
      10, 11, 12, 13, 14, 15,
      20, 21, 22, 23, 24, 25,
      30, 31, 32, 33, 34, 35,
      40, 41, 42, 43, 44, 45,
      50, 51, 52, 53, 54, 55
    };

    int[] expected = new int[] {
      50, 51, 52, 53, 54, 55,
      40, 41, 42, 43, 44, 45,
      30, 31, 32, 33, 34, 35,
      20, 21, 22, 23, 24, 25,
      10, 11, 12, 13, 14, 15
    };

    assertEquals(true, Transformer.horizontalFlip(5, 6, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_verticalFlip_invalidNumRowsColumns() {
    int[] board = new int[] { 99 };
    assertEquals(false, Transformer.verticalFlip(0, 1, board));
    assertEquals(false, Transformer.verticalFlip(1, 0, board));
  }

  @Test
  public void test_verticalFlip_invalidBoardSize() {
    int[] board = new int[] { 99 };
    assertEquals(false, Transformer.verticalFlip(1, 2, board));
  }

  @Test
  public void test_verticalFlip_1x1() {
    int[] board = new int[] { 99 };
    assertEquals(true, Transformer.verticalFlip(1, 1, board));
    assertArrayEquals(new int[] { 99 }, board);
  }

  @Test
  public void test_verticalFlip_1x2() {
    int[] board = new int[] {
      98, 99
    };

    int[] expected = new int[] {
      99, 98
    };

    assertEquals(true, Transformer.verticalFlip(1, 2, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_verticalFlip_2x1() {
    int[] board = new int[] {
      98,
      99
    };

    int[] expected = new int[] {
      98,
      99
    };

    assertEquals(true, Transformer.verticalFlip(2, 1, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_verticalFlip_2x2() {
    int[] board = new int[] {
      96, 97,
      98, 99
    };

    int[] expected = new int[] {
      97, 96,
      99, 98,
    };

    assertEquals(true, Transformer.verticalFlip(2, 2, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_verticalFlip_2x3() {
    int[] board = new int[] {
      94, 95, 96,
      97, 98, 99
    };

    int[] expected = new int[] {
      96, 95, 94,
      99, 98, 97
    };

    assertEquals(true, Transformer.verticalFlip(2, 3, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_verticalFlip_3x2() {
    int[] board = new int[] {
      94, 95,
      96, 97,
      98, 99
    };

    int[] expected = new int[] {
      95, 94,
      97, 96,
      99, 98
    };

    assertEquals(true, Transformer.verticalFlip(3, 2, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_verticalFlip_3x3() {
    int[] board = new int[] {
      91, 92, 93,
      94, 95, 96,
      97, 98, 99
    };

    int[] expected = new int[] {
      93, 92, 91,
      96, 95, 94,
      99, 98, 97
    };

    assertEquals(true, Transformer.verticalFlip(3, 3, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_verticalFlip_5x5() {
    int[] board = new int[] {
      10, 11, 12, 13, 14,
      20, 21, 22, 23, 24,
      30, 31, 32, 33, 34,
      40, 41, 42, 43, 44,
      50, 51, 52, 53, 54
    };

    int[] expected = new int[] {
      14, 13, 12, 11, 10,
      24, 23, 22, 21, 20,
      34, 33, 32, 31, 30,
      44, 43, 42, 41, 40,
      54, 53, 52, 51, 50
    };

    assertEquals(true, Transformer.verticalFlip(5, 5, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_verticalFlip_6x5() {
    int[] board = new int[] {
      10, 11, 12, 13, 14,
      20, 21, 22, 23, 24,
      30, 31, 32, 33, 34,
      40, 41, 42, 43, 44,
      50, 51, 52, 53, 54,
      60, 61, 62, 63, 64
    };

    int[] expected = new int[] {
      14, 13, 12, 11, 10,
      24, 23, 22, 21, 20,
      34, 33, 32, 31, 30,
      44, 43, 42, 41, 40,
      54, 53, 52, 51, 50,
      64, 63, 62, 61, 60
    };

    assertEquals(true, Transformer.verticalFlip(6, 5, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_verticalFlip_5x6() {
    int[] board = new int[] {
      10, 11, 12, 13, 14, 15,
      20, 21, 22, 23, 24, 25,
      30, 31, 32, 33, 34, 35,
      40, 41, 42, 43, 44, 45,
      50, 51, 52, 53, 54, 55
    };

    int[] expected = new int[] {
      15, 14, 13, 12, 11, 10,
      25, 24, 23, 22, 21, 20,
      35, 34, 33, 32, 31, 30,
      45, 44, 43, 42, 41, 40,
      55, 54, 53, 52, 51, 50
    };

    assertEquals(true, Transformer.verticalFlip(5, 6, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_rotate90_invalidNumRowsColumns() {
    int[] board = new int[] { 99 };
    assertEquals(false, Transformer.rotate90(0, 1, board));
    assertEquals(false, Transformer.rotate90(1, 0, board));
  }

  @Test
  public void test_rotate90_invalidBoardSize() {
    int[] board = new int[] { 99 };
    assertEquals(false, Transformer.rotate90(1, 2, board));
  }

  @Test
  public void test_rotate90_nonSquare() {
    int[] board = new int[] {
      98, 99
    };

    assertEquals(false, Transformer.rotate90(1, 2, board));
  }

  @Test
  public void test_rotate90_1x1() {
    int[] board = new int[] { 99 };
    assertEquals(true, Transformer.rotate90(1, 1, board));
    assertArrayEquals(new int[] { 99 }, board);
  }

  @Test
  public void test_rotate90_2x2() {
    int[] board = new int[] {
      96, 97,
      98, 99
    };

    int[] expected = new int[] {
      98, 96,
      99, 97
    };

    assertEquals(true, Transformer.rotate90(2, 2, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_rotate90_3x3() {
    int[] board = new int[] {
      91, 92, 93,
      94, 95, 96,
      97, 98, 99
    };

    int[] expected = new int[] {
      97, 94, 91,
      98, 95, 92,
      99, 96, 93,
    };

    assertEquals(true, Transformer.rotate90(3, 3, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_rotate90_5x5() {
    int[] board = new int[] {
      10, 11, 12, 13, 14,
      20, 21, 22, 23, 24,
      30, 31, 32, 33, 34,
      40, 41, 42, 43, 44,
      50, 51, 52, 53, 54
    };

    int[] expected = new int[] {
      50, 40, 30, 20, 10,
      51, 41, 31, 21, 11,
      52, 42, 32, 22, 12,
      53, 43, 33, 23, 13,
      54, 44, 34, 24, 14
    };

    assertEquals(true, Transformer.rotate90(5, 5, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_rotate90_6x6() {
    int[] board = new int[] {
      10, 11, 12, 13, 14, 15,
      20, 21, 22, 23, 24, 25,
      30, 31, 32, 33, 34, 35,
      40, 41, 42, 43, 44, 45,
      50, 51, 52, 53, 54, 55,
      60, 61, 62, 63, 64, 65
    };

    int[] expected = new int[] {
      60, 50, 40, 30, 20, 10,
      61, 51, 41, 31, 21, 11,
      62, 52, 42, 32, 22, 12,
      63, 53, 43, 33, 23, 13,
      64, 54, 44, 34, 24, 14,
      65, 55, 45, 35, 25, 15
    };

    assertEquals(true, Transformer.rotate90(6, 6, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_transform_identity() {
    int[] board = new int[] {
      91, 92, 93,
      94, 95, 96,
      97, 98, 99
    };

    int[] expected = new int[] {
      0, 1, 2,
      3, 4, 5,
      6, 7, 8
    };

    assertEquals(true, Transformer.transform(Transformer.Type.IDENTITY, 3, 3, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_transform_unknown() {
    int[] board = new int[] {
      0, 1, 2,
      3, 4, 5,
      6, 7, 8,
    };

    int[] expected = new int[] {
      0, 1, 2,
      3, 4, 5,
      6, 7, 8,
    };

    assertEquals(false, Transformer.transform(Transformer.Type.UNKNOWN, 3, 3, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_transform_invalidInputs() {
    int[] board = new int[] {
      0, 1, 2,
      3, 4, 5,
      6, 7, 8,
    };

    int[] expected = new int[] {
      0, 1, 2,
      3, 4, 5,
      6, 7, 8,
    };

    assertEquals(false, Transformer.transform(Transformer.Type.VERTICAL_SYMMETRY, 4, 3, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_transform_rotation() {
    int[] board = new int[] {
      0, 1, 2,
      3, 4, 5,
      6, 7, 8
    };

    int[] expected = new int[] {
      6, 3, 0,
      7, 4, 1,
      8, 5, 2
    };

    assertEquals(true, Transformer.transform(Transformer.Type.ROTATION, 3, 3, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_transform_horizontal() {
    int[] board = new int[] {
      0, 1, 2,
      3, 4, 5,
      6, 7, 8,
    };

    int[] expected = new int[] {
      6, 7, 8,
      3, 4, 5,
      0, 1, 2
    };

    assertEquals(true, Transformer.transform(Transformer.Type.HORIZONAL_SYMMETRY, 3, 3, board));
    assertArrayEquals(expected, board);
  }

  @Test
  public void test_transform_vertical() {
    int[] board = new int[] {
      0, 1, 2,
      3, 4, 5,
      6, 7, 8,
    };

    int[] expected = new int[] {
      2, 1, 0,
      5, 4, 3,
      8, 7, 6
    };

    assertEquals(true, Transformer.transform(Transformer.Type.VERTICAL_SYMMETRY, 3, 3, board));
    assertArrayEquals(expected, board);
  }



}