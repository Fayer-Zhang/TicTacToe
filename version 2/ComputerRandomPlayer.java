public class ComputerRandomPlayer implements Player{

  // YOUR CODE HERE
	public boolean play(TicTacToe game){
		int[] empty = game.emptyPositions();

		if (empty.length != 0)
		{
			int index = (int)(Math.random()*empty.length);
			int position = empty[index];
			game.play(position);
			
			return true;
		}
		else
		{
			return false;
		}
		
	}

}