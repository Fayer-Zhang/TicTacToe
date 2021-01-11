# TicTacToe (version 3)

This version is continuing with the work of version 2. In the previous version, the symmetric games are allowed to be processed. In this version, those symmetric games are removed to make the search space smaller.

### Symmetries and Iterators
In Transfomer.java, there are all possible rotations by creating a enum: UNKNOWN, IDENTITY, ROTATION, VERTICAL_SYMMETRY, HORIZONTAL_SYMMETRY. The UNKNOWN is useful for testing, and the IDENTITY does no rotation at all.

#### Identity
```java
public static boolean identity(int numRows, int numColumns, int[] board) {
```
Sets the board to the identity board where the value at each index is the index itself (in other words do a "no flip" flip).
For example, the identity board of a 3x3 game is

```
 0 | 1 | 2
----------
 3 | 4 | 5
----------
 6 | 7 | 8
```

#### Horizonal Flip

```java
public static boolean horizontalFlip(int numRows, int numColumns, int[] board)
```

Performs a horizontal symmetry on the elements in the n (numRows) x m (numColumns) grid stored in the array reference by board. The elements in the array referenced by board are modified accordingly (see example below).

If we consider a 3x3 board.

```
 1 | 2 | 3
----------
 4 | 5 | 6
----------
 7 | 8 | 9
```

The updated horizontally flipped board would be

```
 7 | 8 | 9
----------
 4 | 5 | 6
----------
 1 | 2 | 3
```

#### Vertical Flip

```java
public static boolean verticalFlip(int numRows, int numColumns, int[] board)
```

Performs a vertical symmetry on the elements in the n (numRows) x m (numColumns) grid stored in the array reference by boardIndexes. The elements in the array referenced by boardIndexes are modified accordingly (see example below).

If we consider a 3x3 board

```
 1 | 2 | 3
----------
 4 | 5 | 6
----------
 7 | 8 | 9
```

The updated vertically flipped board would be

```
 3 | 2 | 1
----------
 6 | 5 | 4
----------
 9 | 8 | 7
```

#### Rotate 90 Degrees

```java
public static boolean rotate(int numRows, int numColumns, int[] board);
```

Rotates clockwise by 90 degrees the elements in the n (numRows) x m (numColumns) grid stored in the array reference by boardIndexes. The elements in the array referenced by boardIndexes are modified accordingly (see example below).

If we consider a 3x3 board

```
 1 | 2 | 3
----------
 4 | 5 | 6
----------
 7 | 8 | 9
```

The updated 90 rotated board would be

```
 7 | 4 | 1
 ----------
 8 | 5 | 2
 ----------
 9 | 6 | 3
```

### Update TicTacToe to support transformations
Add all the necessary instance variables to implement the methods:

* `hasNext`,
* `next`, and
* `reset`

Update the `equals` method which returns true if and only if this instance of `TicTacToe` and `other` are identical including symmetrical boards using those methods above.