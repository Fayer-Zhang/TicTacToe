public class ComputerInOrderPlayer implements Player {

  // YOUR CODE HERE
	public boolean play(TicTacToe game){
		int[] empty = game.emptyPositions();

		if (empty.length != 0)
		{
			
			for (int i=0; i<empty.length; i++)
			{
				int input = empty[i];
				game.play(input);
				break;
			}
			
			return true;
		}
		else
		{
			return false;
		}
	}
}