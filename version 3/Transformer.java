public class Transformer {

  /**
   * An static enum  for the types of
   * allowable transformations
   */
  public static enum Type {
    UNKNOWN,
    IDENTITY,
    ROTATION,
    VERTICAL_SYMMETRY,
    HORIZONAL_SYMMETRY,
  }

  /**
   * The list of all allowable symmetries for a n (numRows) x m (numColumns) board
   * by applying the following transformations
   * @param numRows The number of rows in your board
   * @param numColumns The number of columns in your board
   * @return All rotations for a symmetric board
   */
  public static Type[] symmetricTransformations(int numRows, int numColumns) {

    // -------------------
    // IMPLEMENT THIS METHOD
    // TODO: Based on the dimensions there are different allowable transformations
    // HINT: This method will help you determine the `allowable` tranformations
    //       in your TicTacToe game
    // -------------------
    
    if(numRows == numColumns)
  	{
  		//Type[] transformationOperations = new Type[]{IDENTITY, ROTATION, ROTATION, ROTATION, HORIZONAL_SYMMETRY, ROTATION, ROTATION, ROTATION};
  		Type[] transformationOperations = new Type[8];
  		transformationOperations[0] = Type.IDENTITY;
  		transformationOperations[1] = Type.ROTATION;
  		transformationOperations[2] = Type.ROTATION;
  		transformationOperations[3] = Type.ROTATION;
  		transformationOperations[4] = Type.HORIZONAL_SYMMETRY;
  		transformationOperations[5] = Type.ROTATION;
  		transformationOperations[6] = Type.ROTATION;
  		transformationOperations[7] = Type.ROTATION;
  		return transformationOperations;
  	}
  	else
  	{
  		//Type[] transformationOperations = new Type[]{IDENTITY, HORIZONAL_SYMMETRY, VERTICAL_SYMMETRY, HORIZONAL_SYMMETRY};
  		Type[] transformationOperations = new Type[4];
  		transformationOperations[0] = Type.IDENTITY;
  		transformationOperations[1] = Type.HORIZONAL_SYMMETRY;
  		transformationOperations[2] = Type.VERTICAL_SYMMETRY;
  		transformationOperations[3] = Type.HORIZONAL_SYMMETRY;
  		return transformationOperations;
  	}
  }

  /**
   * Applies the transformation specified as parameter
   * to transformedBoard
   *
   * If the transformation was successful return true, if not return false;
   */
  public static boolean transform(Type transformation, int numRows, int numColumns, int[] board) {

    // -------------------
    // WRITE CODE HERE
    // TODO: Implement this method
    // HINT: See assignment details
    // -------------------

	switch(transformation) {
    case IDENTITY:
      return identity(numRows, numColumns, board);
    case ROTATION:
      return rotate90(numRows, numColumns, board);
    case VERTICAL_SYMMETRY:
      return verticalFlip(numRows, numColumns, board);
    case HORIZONAL_SYMMETRY:
      return horizontalFlip(numRows, numColumns, board);
    default:
      return false;
    }
        
  }

  /**
   * Create the identity board, which means do not flip the board at all.
   * Here we ignore the current values within the provided board and
   * populate it with its index value.
   *
   * If we consider a 3x3 board, the identity board would be
   *
   * 0 | 1 | 2
   * ----------
   * 3 | 4 | 5
   * ----------
   * 6 | 7 | 8
   *
   *
   * If the transformation was successful return true, if not return false;
   */
  public static boolean identity(int numRows, int numColumns, int[] board) {

    // -------------------
    // WRITE CODE HERE
    // TODO: Implement this method
    // -------------------

	if(board.length != numRows * numColumns || numRows < 0 || numColumns < 0)
    {
    	return false;
    }

    else
    {
    	int[] newBoard = new int[numRows*numColumns];
    	
    	for(int i=0; i<board.length; i++)
    	{
    		newBoard[i] = i;
    		board[i] = newBoard[i];
    	}

    	return true;
    }

  }

  /**
   * Flip a board horizontally based on the n (numRows) x m (numColumns) grid
   * editing the provided board in place.
   *
   * If we consider a 3x3 board
   *
   * 1 | 2 | 3
   * ----------
   * 4 | 5 | 6
   * ----------
   * 7 | 8 | 9
   *
   * The updated horizontally flipped board would be
   *
   * 7 | 8 | 9
   * ----------
   * 4 | 5 | 6
   * ----------
   * 1 | 2 | 3
   *
   * If the transformation was successful return true, if not return false;
   */
  public static boolean horizontalFlip(int numRows, int numColumns, int[] board) {

    // -------------------
    // WRITE CODE HERE
    // TODO: Implement this method
    // -------------------

	if(board.length != numRows * numColumns || numRows < 0 || numColumns < 0)
    {
    	return false;
    }

    else if(numRows == 1)
    {
    	int[] newBoard1 = new int[numRows*numColumns];
    	for (int i=0; i<board.length; i++)
    	{
    		newBoard1[i] = board[i];
    		board[i] = newBoard1[i];
    	}

    	return true;
    }

    else
    {
    	/*1D-array to 2D array*/
   		int[][] newBoard2 = new int[numRows][numColumns];
    	for(int i=0; i<numRows; i++)
    	{
    		for(int j=0; j<numColumns; j++)
    		{
    			newBoard2[i][j] = board[i*numColumns+j];
    		}
    	}

    	int row = newBoard2.length-1;  	
  
		for(int i=row/2; i>=0; i--)
	    {
	   		int[] temp = newBoard2[i];
	    	newBoard2[i] = newBoard2[row-i];
	    	newBoard2[row-i] = temp;
	    }
    	
    	/*2D-array to 1D array*/
    	for(int i=0; i<numRows; i++)
    	{
    		for(int j=0; j<numColumns; j++)
    		{
    			board[i*numColumns+j] = newBoard2[i][j];
    		}
    	}

    	return true;
    }

  }


 /**
   * Flip a board vertically based on the n (numRows) x m (numColumns) grid
   * editing the provided board in place.
   *
   * If we consider a 3x3 board
   *
   * 1 | 2 | 3
   * ----------
   * 4 | 5 | 6
   * ----------
   * 7 | 8 | 9
   *
   * The updated vertically flipped board would be
   *
   * 3 | 2 | 1
   * ----------
   * 6 | 5 | 4
   * ----------
   * 9 | 8 | 7
   *
   * If the transformation was successful return true, if not return false;
   */
  public static boolean verticalFlip(int numRows, int numColumns, int[] board) {

    // -------------------
    // WRITE CODE HERE
    // TODO: Implement this method
    // -------------------

    if(board.length != numRows * numColumns || numRows < 0 || numColumns < 0)
    {
    	return false;
    }

    else if(numColumns == 1)
    {
    	int[] newBoard1 = new int[numRows*numColumns];
    	for (int i=0; i<board.length; i++)
    	{
    		newBoard1[i] = board[i];
    		board[i] = newBoard1[i];
    	}

    	return true;
    }

    else
    {
    	/*1D-array to 2D array*/
   		int[][] newBoard2 = new int[numRows][numColumns];
    	for(int i=0; i<numRows; i++)
    	{
    		for(int j=0; j<numColumns; j++)
    		{
    			newBoard2[i][j] = board[i*numColumns+j];
    		}
    	}

    	int column = newBoard2[0].length;
    	int middle = column/2; 	

    	for(int i=0; i<numRows; i++)
    	{
    		for(int j=0; j<middle; j++)
    		{
    			int temp = newBoard2[i][column-j-1];
    			newBoard2[i][column-j-1] = newBoard2[i][j];
    			newBoard2[i][j]=temp;
    		}
    	}

    	/*2D-array to 1D array*/
    	for(int i=0; i<numRows; i++)
    	{
    		for(int j=0; j<numColumns; j++)
    		{
    			board[i*numColumns+j] = newBoard2[i][j];
    		}
    	}

    	return true;
    }

  }

 /**
   * Rotate a board 90 degrees based on the n x (numRows) x m (numColumns) grid
   * editing the provided board in place.
   *
   * If we consider a 3x3 board
   *
   * 1 | 2 | 3
   * ----------
   * 4 | 5 | 6
   * ----------
   * 7 | 8 | 9
   *
   * The updated 90 rotated board would be
   *
   * 7 | 4 | 1
   * ----------
   * 8 | 5 | 2
   * ----------
   * 9 | 6 | 3
   *
   * You can only rotate n x n boards.
   *
   * If the transformation was successful return true, if not return false;
   */
  public static boolean rotate90(int numRows, int numColumns, int[] board) {

    // -------------------
    // WRITE CODE HERE
    // TODO: Implement this method
    // -------------------

    if(board.length != numRows * numColumns || numRows < 0 || numColumns < 0)
    {
    	return false;
    }

    else if(numRows != numColumns)
    {
    	return false;
    }

    else if(numRows==1 && numColumns==1)
    {
    	int[] newBoard1 = new int[numRows*numColumns];
    	for (int i=0; i<board.length; i++)
    	{
    		newBoard1[i] = board[i];
    		board[i] = newBoard1[i];
    	}

    	return true;    	
    }

    else
    {	
    	/*1D-array to 2D array*/
   		int[][] newBoard2 = new int[numRows][numColumns];
    	for(int i=0; i<numRows; i++)
    	{
    		for(int j=0; j<numColumns; j++)
    		{
    			newBoard2[i][j] = board[i*numColumns+j];
    		}
    	}

    	/*Horizontally flip first*/
    	int row = newBoard2.length-1;  	
		for(int i=row/2; i>=0; i--)
	    {
	   		int[] temp = newBoard2[i];
	    	newBoard2[i] = newBoard2[row-i];
	    	newBoard2[row-i] = temp;
	    }

	    /*Then main diagonal flip*/
	    int column = newBoard2[0].length;
	    for(int i=0; i<column; i++)
	    {
	    	for(int j=0; j<i; j++)
	    	{
	    		int temp = newBoard2[i][j];
	    		newBoard2[i][j] = newBoard2[j][i];
	    		newBoard2[j][i] = temp;
	    	}
	    }

	    /*2D-array to 1D array*/
	    for(int i=0; i<numRows; i++)
    	{
    		for(int j=0; j<numColumns; j++)
    		{
    			board[i*numColumns+j] = newBoard2[i][j];
    		}
    	}

    	return true;
    }


  }

  private static void test(int numRows, int numColumns) {
    int[] test;
    test = new int[numRows*numColumns];

    System.out.println("testing " + numRows + " numRows and " + numColumns + " numColumns.");

    identity(numRows, numColumns, test);
    System.out.println(java.util.Arrays.toString(test));

    horizontalFlip(numRows,numColumns,test);
    System.out.println("HF => " + java.util.Arrays.toString(test));

    horizontalFlip(numRows,numColumns,test);
    System.out.println("HF => " + java.util.Arrays.toString(test));

    verticalFlip(numRows,numColumns,test);
    System.out.println("VF => " + java.util.Arrays.toString(test));

    verticalFlip(numRows,numColumns,test);
    System.out.println("VF => " + java.util.Arrays.toString(test));

    for(int i = 0; i < 4; i++) {
      boolean didTransform = rotate90(numRows,numColumns,test);
      if (didTransform) {
        System.out.println("ROT => " + java.util.Arrays.toString(test));
      }
    }
  }

  public static void main(String[] args) {
    int[] test;
    int numRows, numColumns;

    test(2,2);
    test(2,3);
    test(3,3);
    test(4,3);
    test(4,4);
  }

}