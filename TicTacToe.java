import java.util.*;

/**
 * The class <b>TicTacToe</b> is the
 * class that implements the Tic Tac Toe Game.
 * It contains the grid and tracks its progress.
 * It automatically maintain the current state of
 * the game as players are making moves.
 *
 * Originally written by Guy-Vincent Jourdan, University of Ottawa
 */
public class TicTacToe {

  public int numRows;
  public int numColumns;
  public int numRounds;
  public int sizeToWin;
  public GameState gameState;
  public CellValue currentPlayer;
  public CellValue[] board;

  private boolean alreadyWon; 

  /**
   * The default empty constructor.  The default game
   * should be a 3x3 grid with 3 cells in a row to win.
   */
  public TicTacToe() 
  {
    // YOUR CODE HERE
    this.numRows = 3;
    this.numColumns = 3;
    this.sizeToWin = 3;
    this.alreadyWon = false;
    this.board = new CellValue[numRows*numColumns];
    Arrays.fill(board, CellValue.EMPTY);


    this.currentPlayer = CellValue.EMPTY;
  }



  /**
   * A constructor where you can specify the dimensions
   * of your game as rows x coluns grid, and a sizeToWin
   *
   * @param aNumRows the number of lines in the game
   * @param aNumColumns the number of columns in the game
   * @param aSizeToWin the number of cells that must be aligned to win.
   */
  public TicTacToe(int aNumRows, int aNumColumns, int aSizeToWin) 
  {
    // YOUR CODE HERE
    this.numRows = aNumRows;
    this.numColumns = aNumColumns;
    this.sizeToWin = aSizeToWin;
    this.alreadyWon = false;
    this.board = new CellValue[aNumRows*aNumColumns];
    Arrays.fill(board, CellValue.EMPTY);

    this.currentPlayer = CellValue.EMPTY;
  }



  /**
   * Who should play next (X or O).
   *
   * This method does not modify the state of the game.
   * Instead it tells you who should play next.
   *
   * @return The player that should play next.
   */
  public CellValue nextPlayer() 
  {
    // YOUR CODE HERE
    if(currentPlayer == CellValue.EMPTY)
    {
      return CellValue.X;
    }
    else if(currentPlayer == CellValue.X)
    {
      return CellValue.O;
    }
    else
    {
      return CellValue.X;
    }
  }



  /**
   * What is the value at the provided cell based on the
   * grid of numRows x numColumns as illustrated below.
   *
   *  1  |  2  | 3  | 4
   * --------------------
   *  5  |  6  | 7  | 8
   * --------------------
   *  9  | 10  | 11 | 12
   *
   * Note that the input is 1-based (HINT: arrays are 0-based)
   *
   * If the position is invalid, return CellValue.INVALID.
   *
   * @param position The position on the board to look up its current value
   * @return The CellValue at that position
   */
  public CellValue valueAt(int position) 
  {
    // YOUR CODE HERE
    if (position < 1 || position > numRows*numColumns){
      return CellValue.INVALID;
    }
    else{
      return board[position-1];
    }   
  }



  /**
   * What is the value at the provided row and column number.
   *
   *  [1,1]  | [1,2]  | [1,3]  | [1,4]
   * ----------------------------------
   *  [2,1]  | [2,2]  | [2,3]  | [2,4]
   * ----------------------------------
   *  [3,1]  | [3,2]  | [3,3] | [2,4]
   *
   * Note that the input is 1-based (HINT: arrays are 0-based)
   *
   * If the row/column is invalid, return CellValue.INVALID.
   *
   * @param position The position on the board to look up its current value
   * @return The CellValue at that row/column
   */
  public CellValue valueAt(int row, int column) 
  {
    // YOUR CODE HERE
    int givenPosition = (row-1)*numColumns+column;

    if (givenPosition < 1 || givenPosition > numRows*numColumns)
    {
      return CellValue.INVALID;
    }
    else
    {
      return board[givenPosition-1];
    }   
  }



  /**
   * Display the state of the board and ask the next player to play.
   * Return the messages as an array of Strings so that the caller can decide
   * how to display them (and it makes things easier to test)
   * @return An array of messages to display.
   */
  public String[] show()
  {

    String[] display = new String[2];
    display[0] = toString();

    if (currentPlayer == CellValue.EMPTY)
    {
      display[1] = "X to play: ";
    }
    else if(currentPlayer == CellValue.X)
    {
      display[1] = "O to play: ";
    }
    else
    {
      display[1] = "X to play: ";
    }

    return display;
  }



  /**
   * The next player has decided their move to the
   * provided position.
   *
   *
   *  1  |  2  | 3  | 4
   * --------------------
   *  5  |  6  | 7  | 8
   * --------------------
   *  9  | 10  | 11 | 12
   *
   * A position is invalid if:
   * a) It's off the board (e.g. based on the above < 1 or > 12)
   * b) That cell is not empty (i.e. it's no longer available)
   * If the position is invalid, an error should be printed out.
   *
   * If the position is valid, then
   * a) Update the board
   * b) Update the state of the game
   * c) Allow the next player to play.
   *
   * A game can continue even after a winner is declared.
   * If that is the case, a message should be printed out
   * (that the game is infact over), but the move should
   * still be recorded.
   *
   * The winner of the game is the player who won first.
   * @param position The position that has been selected by the next player.
   * @return A message about the current play (see tests for details)
   */
  public String play(int position) 
  {
    // YOUR CODE HERE
    // HINT: use checkForWinner(position)
    String message = new String();

    if(valueAt(position) == CellValue.INVALID)
    {
      message = "The value should be between 1 and " + String.valueOf(numRows*numColumns); 
    } 
    else if(valueAt(position) == CellValue.X) 
    {
      message = "Cell " + String.valueOf(position) + " has already been played with X";
    }
    else if(valueAt(position) == CellValue.O)
    {
      message = "Cell " + String.valueOf(position) + " has already been played with O";
    }
    else if(valueAt(position) == CellValue.EMPTY)
    {
      // update player
      currentPlayer = nextPlayer();

      // update board  
      board[position-1] = currentPlayer;

      // update the state of the game
      GameState flag = checkForWinner(position);
      if (flag == GameState.XWIN)
      {
        message = "Result: XWIN"; 
      }
      else if (flag == GameState.OWIN)
      {
        message = "Result: OWIN";   
      }
      else if(flag == GameState.DRAW)
      {
        message = "Result: DRAW";
      }
      else
      {
        message = null;
      }
    }

    return message;
  }


  @SuppressWarnings("unchecked")
  private int[][] indexing()
  {

    int[][] playerIndex = new int[numRows][numColumns];

    for(int i=1; i<numRows+1; i++)
    {
      for(int j=1; j<numColumns+1; j++)
      {

        if (valueAt(i, j) == currentPlayer)
        {
          playerIndex[i-1][j-1] = 1;
        }
        else
        {
          playerIndex[i-1][j-1] = 0;
        }

      }
    } 
    return playerIndex;
  }

  
  /*Method to check the board has empty cells or not*/
  private boolean emptyCheck(){
    boolean boardNotEmpty;
    int count = 0;

    for(int i=0; i<numRows*numColumns; i++)
    {
      if(board[i] == CellValue.EMPTY){
        count = count;
      }
      else
      {
        count++;
      }
    }

    if(count == numRows*numColumns)
    {
      boardNotEmpty = true;
    }
    else
    {
      boardNotEmpty = false;
    }

    return boardNotEmpty;
  }

  /*Method to check win or not*/
  private boolean winCheck()
  {
    int checkRow = 0;
    int checkColumn = 0;
    int checkDiagonal = 0;
    int checkAntiDiagonal = 0;

    int[][] currentIndex = indexing();

    // check row
    for (int i=0; i<numRows; i++)
    {
      for (int j=0; j<numColumns-sizeToWin+1; j++)
      {
        int sum = 0;

        for (int k = 0; k<sizeToWin; k++)
        {
          sum = sum + currentIndex[i][j+k];
        }

        if (sum == sizeToWin)
        {
          checkRow = 1;
        }
      }
    }
    
    // check columns
    for (int i=0; i<numRows-sizeToWin+1; i++)
    {
      for (int j=0; j<numColumns; j++)
      {
        int sum = 0;

        for (int k = 0; k<sizeToWin; k++)
        {
          sum = sum + currentIndex[i+k][j];
        }
        
        if (sum == sizeToWin)
        {
          checkColumn = 1;
        }
      }
    }

    // check diagonal
    for (int i=0; i<numRows-sizeToWin+1; i++)
    {
      for (int j=0; j<numColumns-sizeToWin+1; j++)
      {
        int sum = 0;

        for (int k = 0; k<sizeToWin; k++)
        {
          sum = sum + currentIndex[i+k][j+k];
        }

        if (sum == sizeToWin)
        {
          checkDiagonal = 1;
        }
      }

    }

    // check anti-diagonal
    for (int i=0; i<numRows-sizeToWin+1; i++)
    {
      for (int j=numColumns-1; j>sizeToWin-2; j--)
      {
        int sum = 0;

        for (int k = 0; k<sizeToWin; k++)
        {
          sum = sum + currentIndex[i+k][j-k];
        }

        if (sum == sizeToWin)
        {
          checkAntiDiagonal = 1;
        }
      }

    }


    if ((checkDiagonal+checkAntiDiagonal+checkColumn+checkRow) !=0)
    {
      return true;
    }
    else
    {
      return false;
    }

  }


 /**
   * A help method to determine if the game has been won
   * to be called after a player has played
   *
   * This method is called after the board has been updated
   * and provides the last position that was played
   * (to help you analyze the board).
   *
   * @param position The middle position to start our check
   * @return GameState to show if XWIN or OWIN.  If the result was a DRAW, or if
   *         the game is still being played.
   */
  private GameState checkForWinner(int position)
  {
    // YOUR CODE HERE
    // HINT: call this within your `play` method
    if (alreadyWon == false)
    {
      boolean checkWin = winCheck();

      if (checkWin == true)
      {
        alreadyWon = true;

        if(currentPlayer== CellValue.X)
        {
          return GameState.XWIN;
        }
        else
        {
          return GameState.OWIN;
        }
      }
      else
      {
        boolean checkDraw = emptyCheck();

        if (checkDraw==true)
        {
          return GameState.DRAW;
        }
        else
        {
          return GameState.PLAYING;
        }
      }

    }
    else
    {
      return null;
    }
   
  } 



  /**
   * A text based representation of the 2D grid, and
   * should include all played Xs and Os.  For example
   * On a 3x3 board.  (HINT: \n for newlines)
   *
   *    | X |
   * -----------
   *  O |   |
   * -----------
   *    |   |
   *
   * @return String representation of the game
   */
  public String toString() 
  {

    // YOUR CODE HERE
    StringBuilder str_board = new StringBuilder();
   
    for (int i=1; i<numRows+1; i++){
      for (int j=1; j<numColumns+1; j++){

        str_board.append(" ");

        if (valueAt(i, j) == CellValue.EMPTY){str_board.append(" ");}
        else if(valueAt(i, j) == CellValue.X){str_board.append("X");}
        else if(valueAt(i, j) == CellValue.O){str_board.append("O");}

        str_board.append(" ");

        if(j!=numColumns){str_board.append("|");}
      }

      if(i!=numRows)
      {
        str_board.append("\n");
        for(int k=1; k<4*numColumns; k++)
        {
          str_board.append("-");
        }
        str_board.append("\n");
        
      }
    }

    String output = str_board.toString();
   //output.substring(0,output.length()-1);
    return output;    
  }



  /**
   * Expose all internal data for debugging purposes.
   *
   * @return String representation of the game
   */
  public String toDebug() 
  {
    StringBuilder b = new StringBuilder();
    b.append("Grid (rows x columns): " + numRows + " x " + numColumns);
    b.append("\n");
    b.append("Size To Win: " + sizeToWin);
    b.append("\n");
    b.append("Num Rounds: " + numRounds);
    b.append("\n");
    b.append("Game State: " + gameState);
    b.append("\n");
    b.append("Current Player: " + currentPlayer);
    b.append("\n");
    b.append("Next Player: " + nextPlayer());
    b.append("\n");

    b.append("Board (array): [");
    for (int i=0; i<board.length; i++) 
    {
      if (i > 0) 
      {
        b.append(",");
      }
      b.append(board[i]);
    }
    b.append("]\n");

    return b.toString();
  } 

}
