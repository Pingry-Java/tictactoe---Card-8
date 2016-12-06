/*
1.Write API Specification (Javadoc) for the program
2.Write all the methods
3.Write the main program
*/
import java.util.Scanner;
public class ticTacToe
{
	/**
	*Main function where the game is played. The coding for the game should be here.
	*/
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int player1Move = 0;
		int player2Move = 1;
		String[][] board = buildBoard();
		
		System.out.println("Player 1, enter your 1 character symbol - ");
		String player1Sym = keyboard.nextLine();
		
		System.out.println("Player 2, enter your 1 character symbol - ");
		String player2Sym = keyboard.nextLine();
		
		printBoard(board);
		
		while(winConditions(board, player1Sym, player2Sym) == false)
		{
			System.out.println("Player 1, where do you want to go? (0-8) ");
			player1Move = keyboard.nextInt();
			
			board = move(player1Move, player1Sym, board);
			printBoard(board);
			if (winConditions(board, player1Sym, player2Sym) == true)
				break;
			System.out.println("Player 2, where do you want to go? (0-8) ");
			player2Move = keyboard.nextInt();
			
			board = move(player2Move, player2Sym, board);
			printBoard(board);
		}
		System.out.println("Game over!");
		
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
		int col = position % 3;
		int row = position / 3;

		board[row][col] = userSymbol;

		return board;
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
		int[][] winPossibilities = {{0, 1, 2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
		
		for (int x = 0; x < winPossibilities.length; x++)
		{
			for (int i = 0; i < user1.length; i++)
			{
				while (index < 3)
				{
					if (winPossibilities[x][index] == user1[i])
						wincounter++;
					index++;
				}
				index = 0;
			}
			if (wincounter == 3)
			{
				win = true;
				break;
			}
			wincounter = 0;
		}
		
		return win;
	}
	
	public static int[][] arrayInfo(String[][] arr, String symbol1, String symbol2)
	{
		int[] user1 = new int[9];
		int[] user2 = new int[9];
		int index1;
		int index2;
		int[] checkarr = {0,1,2,3,4,5,6,7,8};
		for (int i = 0; i < arr.length; i++)
		{
			for (int k = 0; k < arr[i].length; k++)
			{
				if (arr[i][k].equals(symbol1))
				{
					index1 = (3 * i) + k;
					//Integer.parseInt(arr[i][k]); //an error here believe they wanted position
					user1[index1]++;
				}
				if (arr[i][k].equals(symbol2))
				{
					index2 = (3*i) + k;
					//Integer.parseInt(arr[i][k]);  //same here
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
