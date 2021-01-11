# TicTacToe (version 4)

In this version, Menace is implemented to finish an automated system learning how to play Tic-Tac-Toe.

### Training MENANCE Player
Here is a sample run of the system.
```
java GameMain
(1) Menace against a human player
(2) Train Menace against perfect player
(3) Train Menace against random player
(4) Train Menace against another menace
(5) Delete (both) Menace training sets
(6) Human to play perfect player
(7) Perfect player to play human
(8) Human against a menace player
(Q)uit
```

And start its first training againt a human ("1"):
```
1
```

Then the result:
```
   | X |
-----------
   |   |
-----------
   |   |

O to play: 1
 O | X |
-----------
 X |   |
-----------
   |   |

O to play: 5
 O | X |
-----------
 X | O |
-----------
   |   | X

O to play: 3
 O | X | O
-----------
 X | O |
-----------
   | X | X

O to play: 7

Result: OWIN
 O | X | O
-----------
 X | O |
-----------
 O | X | X

Player 1 has won 0 games, lost 1 games, and 0 were draws.

Player 2 has won 1 games, lost 0 games, and 0 were draws.
```

As can be seen, so far MENACE is not really good and lost twice in a row despite being first player. Let’s now train it against a perfect player.
```
(1) Menace against a human player
(2) Train Menace against perfect player
(3) Train Menace against random player
(4) Train Menace against another menace
(5) Delete (both) Menace training sets
(6) Human to play perfect player
(7) Perfect player to play human
(8) Human against a menace player
(Q)uit
2
```

The result (Player 1 is MENACE) is
```
About to train with 500 games.
Player 1 has won 0 games, lost 182 games, and 318 were draws.
Over the last 50 games, this player has won 0, lost 4, and tied 46.

Player 2 has won 182 games, lost 0 games, and 318 were draws.
Over the last 50 games, this player has won 4, lost 0, and tied 46.
```

Then try again as a human player against a trained MENACE:
```

```