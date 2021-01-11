import java.util.Scanner;
public class HumanPlayer implements Player{
	
	// YOUR CODE HERE
	public boolean play(TicTacToe game){
		int[] empty = game.emptyPositions();

		if (empty.length != 0)
		{

      		String presentation = game.toString() +"\n\n";
                  String message = new String();

      		if(game.currentPlayer == CellValue.X)
      		{
      			message = "O to play: ";
      		}
      		else if (game.currentPlayer == CellValue.O)
      		{
      			message = "X to play: ";
      		}
      		else if (game.currentPlayer == CellValue.EMPTY)
      		{
      			message = "X to play: ";
      		}


      		String display = presentation;
      		System.out.print(display);

                  while(true)
                  {
                        System.out.print(message);
                        Scanner sc = new Scanner(System.in); 
                        int input = sc.nextInt();

                        String s = game.play(input);

                        if (s ==null)
                        {
                              break;
                        }
                        else
                        {
                              System.out.println(s+"\n");
                        }

                  }

                  return true;
            }
		else
		{
                  return false;
		} 
		
	}

}