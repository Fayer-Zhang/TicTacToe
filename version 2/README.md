# TicTacToe (version 2)

This version is continuing with the work of version 1. In the previous version, a basic implementation of the game was completed, that can be played by two humans. This time, a "computer player" is created which isn't very smart at all but can at least play the game according to the rules. Then enumerating all possible games to generate games.

### Human vs (Dumb) Machine
Three kinds of players: the human player, and two dumb computer players.
![avatar](/images/players.png)

The game can have human vs human, human vs dumb computer, smart vs dumb computer players, or any combination of players, this does not impact the way the game is played: we have two players, and they alternate playing a move on the game until the game is over. The requirement to be able to do this is that all Player implement the same method, say play(), which can be called when it is that player's turn to play.

The following printout shows a typical game:

```
$ java GameMain
Player 2's turn.
Player 1's turn.

 X |   |
-----------
   |   |
-----------
   |   |

O to play:
```
Here, player 2 (the computer) was selected to start for the first game.
And then.

```
O to play: 6
Player 2's turn.
Player 1's turn.

 X | O | X
-----------
 X |   | O
-----------
   |   |

O to play: 7
Player 2's turn.
Player 1's turn.

 X | O | X
-----------
 X | X | O
-----------
 O |   |

O to play: 9
Player 2's turn.
Game over

 X | O | X
-----------
 X | X | O
-----------
 O | X | O

Result: DRAW
Play again (y)?:
```

### TicTacToe Enumerations
The goal of this implementation is to generate games, and create a list of lists: each list will have all the different games for a given level.
Here are a few typical runs:

```
$ java EnumerationsMain
======= level 0 =======: 1 element(s) (1 still playing)
======= level 1 =======: 9 element(s) (9 still playing)
======= level 2 =======: 72 element(s) (72 still playing)
======= level 3 =======: 252 element(s) (252 still playing)
======= level 4 =======: 756 element(s) (756 still playing)
======= level 5 =======: 1260 element(s) (1140 still playing)
======= level 6 =======: 1520 element(s) (1372 still playing)
======= level 7 =======: 1140 element(s) (696 still playing)
======= level 8 =======: 390 element(s) (222 still playing)
======= level 9 =======: 78 element(s) (0 still playing)
that's 5478 games
564 won by X
316 won by O
78 draw
```

Here is a small 2x2 grid.

```
$ java EnumerationsMain 2 2 2
======= level 0 =======: 1 element(s) (1 still playing)
======= level 1 =======: 4 element(s) (4 still playing)
======= level 2 =======: 12 element(s) (12 still playing)
======= level 3 =======: 12 element(s) (0 still playing)
that's 29 games
12 won by X
0 won by O
0 draw
```