import java.util.*;

public class ComputerMenacePlayer extends Player {

  // WRITE CODE HERE
  // Hint: if you need to track something about this player
  //       then you need instance variables
	private LinkedList<LinkedList<TicTacToe>> games;
  	private LinkedList<LinkedList<MenaceGame>> menaceable;
  	private LinkedList<MenaceGame> stepwiseGames;
  	private ComputerRandomPlayer backup;

  /**
   * A menace player needs to know the size of the game before starting
   * Only optimized for a 3x3 board
   *
   * @param aNumRows the number of lines in the game
   * @param aNumColumns the number of columns in the game
   * @param aSizeToWin the number of cells that must be aligned to win.
   */
  public ComputerMenacePlayer(int aNumRows, int aNumColumns, int aSizeToWin) {

    // WRITE CODE HERE
    // Hint: look at ComputerPerfectPlayer
  	TicTacToeEnumerations enums = new TicTacToeEnumerations(aNumRows, aNumColumns, aSizeToWin);
    games = enums.generateAllGames();
    int numLevels = games.size();

    // Populate the list of lists with Menace Games
    menaceable = new LinkedList<LinkedList<MenaceGame>>();
    for (int i = 0; i < numLevels; i++) {
      	LinkedList<MenaceGame> levelMenace = new LinkedList<MenaceGame>();
      	menaceable.add(levelMenace);
      	for (TicTacToe game : games.get(i)) {
     		MenaceGame menace = new MenaceGame(game);
        	levelMenace.add(menace);
      	}
    }

    backup = new ComputerRandomPlayer();
  }

  // Hint: You might need to overwrite
  //       endGame to help tell your MenanceGame
  //       about the outcome of the game
  //       (so it can learn)

  public boolean play(TicTacToe game) {

    // WRITE CODE HERE
    // Hint: look at ComputerPerfectPlayer
    //       BUT DO NOT use PerfectGame (use MenaceGame)

    for (MenaceGame menaceGame : menaceable.get(game.numRounds)) {
      if (menaceGame.game.alignAndEquals(game)) {

        stepwiseGames.add(menaceGame);
        int position = menaceGame.pickCurrentPosition();

        if (isDebug) {
          System.out.println("Menace rolled "+ menaceGame.currentRoll +" on board: ");
          System.out.println(menaceGame);
          System.out.println("");
        }


        if (position == 0) {
          return false;
        } else {
            game.play(position);
            return true;
        }
      }
    }

    // Nothing found, so play randomly
    return backup.play(game);
    
  }

  @Override
  public void startGame(boolean isFirst) {
    super.startGame(isFirst);
    stepwiseGames = new LinkedList<MenaceGame>();
  }

  @Override
  public GameOutcome endGame(GameState game) {
    GameOutcome result = super.endGame(game);
    for (MenaceGame step : stepwiseGames) {
      step.setOutcome(result);
    }
    return result;
  }


}