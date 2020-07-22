# TicTacToe 
### Date created
May 21st, 2020

### Project Title
TicTacToe

### Description
This project is to implement the game Tic-Tac-Toe. This implementation will be a little bit more general than the usual 3x3 grid game. By default, this game will be indeed played on a 3x3 grid, trying to align 3 similar cells horizontally, vertically or diagonally. But the more general implementation will accept 3 parameters n, m and k to play a game on an nxm grid trying to align k similar cells horizontally, vertically or diagonally. Instances of the class TicTacToe represent a game being played. Each object stores the actual board, which is saved in a single dimension array. There is an instance method that can be used to play the next move. The object figures out the player’s turn, so that information is not specified: I simply specify the index to play and the object knows to play either a X or a O. The object also tracks the state of the game automatically.

### Game Status Graphs 

This plot shows the game initialization:<br>
![avatar](/images/1.png)

This plot shows the game result is DRAW:<br>
![avatar](/images/DRAW.png)

This plot shows the one player win the game:<br> 
![avatar](/images/WIN.png)
