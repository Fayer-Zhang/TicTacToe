import java.util.LinkedList;

public class TicTacToeEnumerations {

  // YOUR CODE HERE
  int numRows;
  int numColumns;
  int sizeToWin;

  /**
   * The list of lists of all generated games
   */
  LinkedList<LinkedList<TicTacToe>> allGames;



  /**
   * A constructor where you can specify the dimensions
   * of your game as rows x coluns grid, and a sizeToWin
   * to analyze.
   *
   * @param aNumRows the number of lines in the game
   * @param aNumColumns the number of columns in the game
   * @param aSizeToWin the number of cells that must be aligned to win.
   */
  public TicTacToeEnumerations(int aNumRows, int aNumColumns, int aSizeToWin) {
    // YOUR CODE HERE
    this.numRows = aNumRows;
    this.numColumns = aNumColumns;
    this.sizeToWin = aSizeToWin;

  }



  /**
   * Generate a list of lists of all games, storing the
   * result in the member variables `allGames`.
   */
  @SuppressWarnings("unchecked")
  public LinkedList<LinkedList<TicTacToe>> generateAllGames() {

    // YOUR CODE HERE
    
    TicTacToe game = new TicTacToe(numRows, numColumns, sizeToWin);
    
    LinkedList<TicTacToe> lastLevelGames = new LinkedList<>();
    lastLevelGames.add(game);

    LinkedList<LinkedList<TicTacToe>> allLevelGames = new LinkedList<>();
    allLevelGames.add(lastLevelGames);

    boolean flag = true;
    
    while(flag) // Level
    {

      lastLevelGames = (LinkedList) (allLevelGames.getLast()).clone();
      LinkedList<TicTacToe> generatedNewGames = new LinkedList<>();

      for (int i =0; i<lastLevelGames.size(); i++)
      {
        int[] emptyCells = (lastLevelGames.get(i)).emptyPositions();
        
        if(lastLevelGames.get(i).gameState == GameState.PLAYING)
        {
          for (int j = 0; j<emptyCells.length; j++) 
          {
            TicTacToe newGame = lastLevelGames.get(i).cloneNextPlay(emptyCells[j]);
            
            boolean flag1 = true;
            for(TicTacToe g: generatedNewGames)
            {
              if(g.equals(newGame))
              {
                flag1 = false;
                break;
              }
            }

            if (flag1==true)
            {
              generatedNewGames.add(newGame);
            }

          }
        }
      }

    int numStillPlaying = 0;

      for (TicTacToe g : generatedNewGames) 
      {
        if(g.gameState == GameState.PLAYING)
        {
           numStillPlaying += 1;
        }
      }

      if (numStillPlaying == 0) 
      {
          flag = false;
      }

      allLevelGames.add(generatedNewGames);
    }

    allGames = (LinkedList<LinkedList<TicTacToe>>) allLevelGames.clone();

    return allGames;
  }





  public String toString() 
  {
    if (allGames == null) 
    {
      return "No games generated.";
    }

    StringBuilder s = new StringBuilder();

    int numGames = 0;
    int numXWin = 0;
    int numOWin = 0;
    int numDraw = 0;

    for (int i=0; i<allGames.size(); i++) 
    {
      LinkedList<TicTacToe> games = allGames.get(i);
      int numStillPlaying = 0;

      for (TicTacToe g : games) 
      {
        numGames += 1;

        switch (g.gameState) 
        {
        case PLAYING:
          numStillPlaying += 1;
          break;
        case XWIN:
          numXWin += 1;
          break;
        case OWIN:
          numOWin += 1;
          break;
        case DRAW:
          numDraw += 1;
          break;
        }
      }

      s.append("======= level "+ i +" =======: ");
      s.append(games.size() + " element(s) (");
      s.append(numStillPlaying + " still playing)\n");
    }

    s.append("that's "+ numGames +" games\n");
    s.append(numXWin + " won by X\n");
    s.append(numOWin + " won by O\n");
    s.append(numDraw + " draw");
    return s.toString();
  }

}