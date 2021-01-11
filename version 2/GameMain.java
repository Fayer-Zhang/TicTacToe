
public class GameMain {

  /**
   * <b>main</b> of the application. Creates the instance of  TicTacToe
   * and starts the game. If two parameters lines  and columns
   * are passed, they are used. If the paramters lines, columns
   * and win are passed, they are used.
   * Otherwise, a default value is used. Defaults values (3) are also
   * used if the paramters are too small (less than 2).
   * Here, we assume that the command lines arguments are indeed integers
   *
   * @param args command lines parameters
   */
  public static void main(String[] args) {

    Player p1 = validatePlayer(args, 0, "h");
    Player p2 = validatePlayer(args, 1, "ic");

    int lines = validateInt(args, 2);
    int columns = validateInt(args, 3);
    int wins = validateInt(args, 4);

    if (args.length > 5){
        System.out.println("Too many arguments. Only the first 5 are used.");
    }

    TicTacToe game = new TicTacToe();
    Player[] players = new Player[] {p1, p2};

    // YOUR CODE HERE
    boolean continueRounds = true;
    boolean continuePlay = true;

    int startFirst = (int)(Math.random()*players.length);

    while(continueRounds)
    {
      game = new TicTacToe(lines, columns, wins);
      continuePlay = true;

      int currentplay = startFirst;
      startFirst = nextPlayer(startFirst);

      while (continuePlay)
      {
        System.out.println("Player " + (currentplay+1) + "'s turn.");

        if (currentplay == 0)
        {
          System.out.print("\n");
          boolean p = p1.play(game);

        }
        else
        {
          boolean q = p2.play(game);
        }

        currentplay = nextPlayer(currentplay);


        if (game.gameState == GameState.PLAYING)
        {
          continuePlay = true;
        }
        else if(game.gameState == GameState.OWIN || game.gameState == GameState.XWIN||game.gameState == GameState.DRAW)
        {

          System.out.println("Game over" + "\n");
          System.out.println(game.toString() + "\n");
          System.out.println("Result: " + game.gameState);

          continuePlay = false;

          System.out.print("Play again (Y)?:");
          String input = System.console().readLine();

          if ("n".equals(input)||("N".equals(input)))
          {
            continueRounds = false;
          }
          else if ("y".equals(input)||("Y".equals(input)))
          {
            continueRounds = true;
          }
          else
          {
            System.out.print("Play again (Y)?:");
            input = System.console().readLine();
          }

        }
      }      
    }

  }

  /**
   * Toggle the current player to be the next player
   * @param currentPlayer the current player index (0 or 1)
   * @return The next player index (1 or 0)
   */
  private static int nextPlayer(int currentPlayer) {
    return currentPlayer == 1 ? 0 : 1;
  }

  /**
   * Extract the player from the arguments
   * "h" for HumanPlayer
   * "ic" for ComputerInOrderPlayer
   * "rc" for ComputerRandomPlayer
   *
   * @param args The command lines parameters
   * @param index Which index to parse
   * @param defaultIfMissing Default value if no input at that index
   * @return String The value at that position of the default if not available
   */
  private static Player validatePlayer(String[] args, int index, String defaultIfMissing) {
    String player;
    if (index >= 0 && index < args.length) {
      player = args[index];
    } else {
      player = defaultIfMissing;
    }

    switch (player) {
    case "h":
      return new HumanPlayer();
    case "ic":
      return new ComputerInOrderPlayer();
    case "rc":
      return new ComputerRandomPlayer();
    default:
      System.out.println("Unknown player " + player + " expected 'h', 'ic' or 'rc', defaulting to Human.");
      return new HumanPlayer();
    }
  }

  /**
   * Extract an integer from the provided argument
   * it must be 2 or more.
   *
   * @param args The command lines parameters
   * @param index Which index to parse
   */
  private static int validateInt(String[] args, int index) {
    if (index >= 0 && index < args.length) {
      int num = Integer.parseInt(args[index]);
      if(num >= 2){
        return num;
      } else {
        System.out.println("Invalid argument, using default...");
      }
    }
    return 3;
  }

}