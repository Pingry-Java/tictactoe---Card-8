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
	public static void main (String[] args)
	{
		
	}
	/**
	*Creates a tic tac toe board to use
	*@return a String[][] a 2D string array that is numbered from 0-8
	*/
	public static String[][] buildBoard()
	{
		
	}
	/**
	*Prints out the tic tac toe board in a nice format with lines
	*@param s Array which needs to be formatted and printed
	*/
	public static void printBoard(String[][] s)
	{
		
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
	*@param symbol1
	*@param symbol2
	*@return Whether or not there is three in a row (true for winner, false for no winner yet)
	*/
	public static boolean winConditions(String[][] s, String symbol1, String symbol2)
	{
		int[][] positions = arrayInfo(s, symbol1, symbol2);
		int[] user1 = positions[0];
		int[] user2 = positions[1];
		
		int wincounter = 0;
		
		int index = 0;
		boolean win = false;
		int[][] winPossibilities = [[0, 1, 2], [3,4,5], [6,7,8], [0,3,6], [1,4,7], [2,5,8], [0,4,8], [2,4,6]];
		for (int x = 0; x < winPossibilities.length; x++)
		{
			for (int i = 0; i < user1.length; i++)
			{
				index = 0;
				while (index < 3)
				{
					if (winPossibiliites[x][index] == user1[i])
						wincounter++;
					index++;
				}
				if (wincounter == 3)
					break;
			}
			if (wincounter == 3)
			{
				win = true;
				break;
			}
		}
		
		return win;
	}
	
	public static int[][] arrayInfo(String[][] arr, String symbol1, String symbol2)
	{
		int[] user1 = new int[9];
		int[] user2 = new int[9];
		int index1;
		int index2;
		for (int i = 0; i < arr.length; i++)
		{
			for (int k = 0; k < arr[i].length; k++)
			{
				if (arr[i][k].equals(symbol1)
				{
					index1 = Integer.parseInt(arr[i][k]);
					user1[index1]++;
				}
				if (arr[i][k].equals(symbol2)
				{
					index2 = Integer.parseInt(arr[i][k]);
					user2[index2]++;
				}
			}
		}
		
		index1 = 0;
		index2 = 0;
		for (int j = 0; j < user1.length; j++)
		{
			if (user1[j] == 1)
				index1++;
		}
		
		for (int x = 0; x < user2.length; x++)
		{
			if (user2[x] == 1)
				index2++;
		}
		
		int[] positions1 = new int[index1];
		int[] positions2 = new int[index2];
		
		int counter1 = 0;
		int counter2 = 0;
		for (int c = 0; c < user1.length; c++)
		{
			if (user1[c] == 1)
			{
				positions1[counter1] += c;
				counter1++;
			}
			if (user2[c] == 1)
			{
				positions2[counter2] += c;
				counter2++;
			}
		}
		
		int[][] answer = {positions1, positions2};
		
		return answer;
	}
	
}
