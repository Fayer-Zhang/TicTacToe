public class MenaceGame {

  TicTacToe game;
  int[] boardOdds;
  int totalOdds;
  int currentPosition;

  /**
   * A menace game keeps an instance of a TicTacToe game
   * instead of extending it. We can chat about why
   * during our Monday meetups.
   *
   * Hint: Take a look at the implementation of a PerfectGame
   *       for ideas on how to structure a MenaceGame.
   */
  public MenaceGame(TicTacToe aGame) {

    // WRITE CODE HERE
    game = aGame;
    currentPosition = 0;
    boardOdds = new int[]{8,8,4,4,2,2,1,1,1};

    for(int i=0; i<game.board.length; i++)
    {
      if(game.valueAt(i+1) != CellValue.EMPTY)
      {
        boardOdds[i] = 0;
      }

      else
      {
        boardOdds=boardOdds;
      }
    }

    for(int i=0; i<boardOdds.length; i++)
    {
      totalOdds = totalOdds + boardOdds[i];
    }

  }

  /**
   * The game is over.
   * If you won, then add three beads to the current position's odds.
   * If you tied, only add 1 bead
   * If you lost, then remove a bead.
   *
   * Note: You can never have 0 beads in a game
   *       and do not forget to correctly update your totalOdds
   * @param outcome The outcome of the game.
   */
  public void setOutcome(GameOutcome outcome) {

    // WRITE CODE HERE
    if(outcome == GameOutcome.WIN)
    {
      boardOdds[currentPosition-1] = boardOdds[currentPosition-1] + 3;
      totalOdds = totalOdds + 3;
    }

    else if(outcome == GameOutcome.DRAW)
    {
      boardOdds[currentPosition-1] = boardOdds[currentPosition-1] + 1;
      totalOdds = totalOdds + 1;
    }

    else
    {

      if(boardOdds[currentPosition-1] == 1 || boardOdds[currentPosition-1] == 0)
      {
        boardOdds[currentPosition-1] = boardOdds[currentPosition-1];
      }

      else
      {
        boardOdds[currentPosition-1] = boardOdds[currentPosition-1] - 1;
        totalOdds = totalOdds - 1;
      }
    }

  }

  public String toString(){
    StringBuilder b = new StringBuilder();
    int maxRowsIndex = game.numRows - 1;
    int maxColumnsIndex = game.numColumns - 1;

    String lineSeparator = Utils.repeat("---", game.numColumns) + Utils.repeat("-", game.numColumns - 1);
  
    b.append("POSITION: " + currentPosition + " (Odds "+ totalOdds +")\n");
    for (int i = 0; i < game.numRows; i++) {
      for (int j = 0; j < game.numColumns; j++) {
        int index = i*game.numColumns + j;

        b.append(" ");
        b.append(toString(index));
        b.append(" ");

        if (j < maxColumnsIndex) {
          b.append("|");
        }
      }

      // Line separator after each row, except the last
      if (i < maxRowsIndex) {
        b.append("\n");
        b.append(lineSeparator);
        b.append("\n");
      }
    }
    return b.toString();
  }

  private String toString(int index) {
    int lookupIndex = game.boardIndexes[index];
    CellValue cell = game.valueAt(lookupIndex+1);
    switch (cell) {
      case X:
        return "X";
      case O:
        return "O";
      case EMPTY:
        return boardOdds[lookupIndex] + "";
      default:
        return game.board[lookupIndex] + "";
    }
  }



  /**
   * Roll the dice, and set the current position
   * If no positions are available, then return 0
   * (which is an invalid position)
   *
   * @return The current positionThe random number rolled.
   */
  public int pickCurrentPosition() {

    // WRITE CODE HERE;
    int[] positionArray = new int[game.board.length];
    int count = 0;

    if(totalOdds == 0)
    {
      return 0;
    }

    for(int i=0; i<game.board.length; i++)
    {
      if(game.valueAt(i+1) != CellValue.EMPTY)
      {
        positionArray[i] = i+1;
      }
    }

    int index = (int)(Math.random()*positionArray.length);
    int pickPosition = positionArray[index];
    currentPosition = pickPosition;

    return pickPosition;
  }

  /**
   * Generate a random number.
   *
   * Consider the following 3x3 board.
   *
   *    | X |
   * -----------
   *  O |   |
   * -----------
   *    |   |
   *
   * If we had the following beads (I left the Xs and Os off)
   *
   *  5 |  | 6
   * -----------
   *    | 1 | 1
   * -----------
   *  3 | 4 | 8
   *
   * Then our total odds are 28 (5+6+1+1+3+4+8) and we
   * want our random number generator to generate numbers
   * between 1 and 28.
   *
   * @return The random number rolled.
   */
  public int rollDice() {
    // (OVER) WRITE CODE HERE
    int random = (int)(Math.random()*totalOdds + 1);
    if(totalOdds == 0)
    {
      random = 0;
    }
    return random;
  }

  /**
   * Based on the diceRoll, calculate which position
   * on the board should be played based on the current odds (beads)
   * in each available cell.
   *
   * On a 3x3 board.
   *
   *    | X |
   * -----------
   *  O |   |
   * -----------
   *    |   |
   *
   * If we had the following beads (I left the Xs and Os off)
   *
   *  5 |  | 6
   * -----------
   *    | 1 | 1
   * -----------
   *  3 | 4 | 8
   *
   * Here are some expected outputs based on sample diceRolls
   *
   * diceRoll 3 => returns 1
   * diceRoll 11 => returns 3
   * diceRoll 12 => returns 5
   * diceRoll 14 => return 7
   *
   * @return int which position on the board should we choose
   */
  public int calculatePosition(int diceRoll) {

    // (OVER) WRITE CODE HERE
    int position = 0;
    int count = 0;

    for(int i=0; i<game.board.length; i++)
    {
      if(game.valueAt(i+1) != CellValue.EMPTY)
      {
        count ++;
        if(count == game.board.length)
        {
          return 0;
        }
      }
    }

    if(diceRoll > totalOdds)
    {
      return 0;
    }

    else
    {
      int boundaryDiceRollFirst = 1;
      for (int i=0; i<boardOdds.length; i++)
      {
        int boundaryDiceRollSec = boundaryDiceRollFirst + boardOdds[i] - 1;
        if(diceRoll >= boundaryDiceRollFirst && diceRoll <= boundaryDiceRollSec)
        {
          position = i+1;
          break;
        }
        boundaryDiceRollFirst = boundaryDiceRollSec+1;
      }
    }
    return position;

  }

  /**
   * Reset the odds back to an un-trained set based on
   * Menace algorithm.
   */
  public void resetOdds() {

    // WRITE CODE HERE
    boardOdds = new int[]{8,8,4,4,2,2,1,1,1};

    for(int i=0; i<game.board.length; i++)
    {
      if(game.valueAt(i+1) != CellValue.EMPTY)
      {
        boardOdds[i] = 0;
      }
      else
      {
        boardOdds=boardOdds;
      }
    }
  }

}