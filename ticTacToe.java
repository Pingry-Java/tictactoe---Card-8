/*
1.Write API Specification (Javadoc) for the program
2.Write all the methods
3.Write the main program
*/
public class ticTacToe
{
	/**
	*Main function where the game is played. The coding for the game should be here.
	*/
	public static void main ()
	{

	}
	/**
	*Creates a tic tac toe board to use
	*@return a String[][] a 2D string array that is numbered from 0-8
	*/
	public static String[][] buildBoard()
	{
		String [][] pirate = new String[3][3];
		int counter = 0;
		String converted = "asdf";
		for (int row = 0; row < pirate.length; row++)
		{
			for (int col = 0; col < pirate[row].length; col++)
			{
				pirate[row][col] ="" + counter;
				counter++;
			}	
		}
		return pirate;
	}
	/**
	*Prints out the tic tac toe board in a nice format with lines
	*@param s Array which needs to be formatted and printed
	*/
	public static void printBoard(String[][] s)
	{
		for (int i = 0; i < s.length; i++)
		{
			System.out.println("-------");
			for (int z = 0; z < s[i].length; z++)
			{
				System.out.print("|");
				System.out.print(s[i][z]);
			}
			System.out.println("|");
			//System.out.println("");
		}
		System.out.println("-------");
	}
	/**
	*Gets the user's move and updates the String array with the player's symbol
	*@param position The spot where the user wants to move
	*@param userSymbol The symbol a user is using as their "piece"
	*@param board The board before the user's move.
	*@return Updated board with user's piece on it.
	*/
	public static String[][] move(int position, String userSymbol, String[][] board)
	{
		
	}
	/**
	*Checks the current board if there has been a winner (three in a row)
	*
	*@param s Current board which needs to be checked for a win
	*@return Whether or not there is three in a row (true for winner, false for no winner yet)
	*/
	public static boolean winConditions(String[][] s)
	{
		
	}

	
}
