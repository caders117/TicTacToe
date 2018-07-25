package minimax;

public class TicGame {

	private char[] board = new char[9];
	private char currentLetter;
	private static char[][] winCombos = {	{0, 1, 2},	// Horizontals
								{3, 4, 5},
								{6, 7, 8},
								{0, 3, 6},	// Verticals
								{1, 4, 7},
								{2, 5, 8},
								{0, 4, 8},	// Diagonals
								{2, 4, 6}
							};
	private boolean gameOver;
	private char winner;
	
	public TicGame() {
		currentLetter = 'X';
		gameOver = false;
		winner = '\0';
	}
	
	public char getWinner() {
		return winner;
	}
	
	public char[] getBoard() {
		return board;
	}
	
	public char getCurrentLetter() {
		return currentLetter;
	}
	
	public boolean isOver() {
		return gameOver;
	}
	
	public boolean isBoardFull() {
		for(char c : board) {
			if(c == '\0')
				return false;
		}
		return true;
	}
	
	public void move(int spot) {
		if(board[spot] == '\0') {
			board[spot] = currentLetter;
			currentLetter = (currentLetter == 'X') ? 'O' : 'X';
			if(checkWin(board, 'X') || checkWin(board, 'O') || isBoardFull()) {
				if(checkWin(board, 'X')) 
					winner = 'X'; 
				else if(checkWin(board, 'O') )
					winner = 'O';
				else
					winner = 'D';
				gameOver = true;
			}
		} else {
			System.err.println("Spot " + spot + " not available.");
		}
	}
	
	public static boolean checkWin(char[] board, char letter) {
		for(char[] c : winCombos)
			for(int i = 0; i < c.length; i += 3)
				if(board[c[i]] == board[c[i + 1]] && board[c[i + 1]] == board[c[i + 2]] && board[c[i]] == letter)
					return true;
		return false;
	}
}
