# TicTacToe （version 1）

## Description
This project (version 1) is to implement the game Tic-Tac-Toe. This implementation will be a little bit more general than the usual 3x3 grid game. By default, this game will be indeed played on a 3x3 grid, trying to align 3 similar cells horizontally, vertically or diagonally. But the more general implementation will accept 3 parameters n, m and k to play a game on an nxm grid trying to align k similar cells horizontally, vertically or diagonally. Instances of the class TicTacToe represent a game being played. Each object stores the actual board, which is saved in a single dimension array. There is an instance method that can be used to play the next move. The object figures out the player’s turn, so that information is not specified: I simply specify the index to play and the object knows to play either a X or a O. The object also tracks the state of the game automatically.

### Default Game 
In its default conguration, it will look like this: the program rst displayed an empty grid and is prompting the rst player (X) for an input.

```
$ java Main

   |   |
-----------
   |   |
-----------
   |   |

X to play:
```

The first player played the cell 5. The program displays the current game, with cell number ve taken by X, and is prompting the second player (O) for an input. The game will keep going following that pattern.

```
X to play: 5

   |   |
-----------
   | X |
-----------
   |   |

O to play:
```

The user types "2" in the terminal.

```
O to play: 2

   | O |
-----------
   | X |
-----------
   |   |

X to play:
```

The user types "1" in the terminal.

```
X to play: 1

 X | O |
-----------
   | X |
-----------
   |   |

O to play:
```

The user types "9" in the terminal.

```
O to play: 9
 X | O |
-----------
   | X |
-----------
   |   | O

X to play:
```

The user types "4" in the terminal.

```
X to play: 4

 X | O |
-----------
 X | X |
-----------
   |   | O

O to play:
```

The user types "6" in the terminal.

```
O to play: 6

 X | O |
-----------
 X | X | O
-----------
   |   | O

X to play:
```

The user types "7" in the terminal.

```
X to play: 7

 X | O |
-----------
 X | X | O
-----------
 X |   | O

Result: XWIN
```

As can be seen, at each turn the program prints out the current state of the game and then queries the next user (X or O) to provide its next move. We simply assume that the cells are numbered line by line, from top left to bottom right, as follows:

```
 1 | 2 | 3
-----------
 4 | 5 | 6
-----------
 7 | 8 | 9
```

### Custom Game
```
$ java Main 3 4 3
```

```
   |   |   |
---------------
   |   |   |
---------------
   |   |   |

X to play:
```

```
X to play: 2

   | X |   |
---------------
   |   |   |
---------------
   |   |   |

O to play:
```

```
O to play: 6

   | X |   |
---------------
   | O |   |
---------------
   |   |   |

X to play:
```

```
X to play: 7

   | X |   |
---------------
   | O | X |
---------------
   |   |   |

O to play:
```

```
O to play: 4

   | X |   | O
---------------
   | O | X |
---------------
   |   |   |

X to play:
```

```
X to play: 12

   | X |   | O
---------------
   | O | X |
---------------
   |   |   | X

Result: XWIN
```

### GameState

GameState is an enum type which is used to capture the current state of the game. It has four possible values:

* PLAYING: this game is ongoing,
* DRAW: this game is a draw,
* XWIN: this game as been won by the first player,
* OWIN: this game as been won by the second player.