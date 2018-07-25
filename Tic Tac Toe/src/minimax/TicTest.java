package minimax;

import java.util.Scanner;

public class TicTest {

	public static void main(String[] args) {
		char[] board = {'X', '\0', '\0', 
						'O', 'O', '\0',
						'\0', '\0', 'X'};
		TicComputer c = new TicComputer('O');
		TicGame g = new TicGame();
		Scanner scan = new Scanner(System.in);
		while(true) {
			printBoard(g.getBoard());
			int ans = scan.nextInt();
			g.move(ans);
			g.move(c.chooseBestMove(g.getBoard()));
		}
	}
	
	public static void printBoard(char[] board) {
		System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]
						 + "\n---+---+---"
						 + "\n " + board[3] + " | " + board[4] + " | " + board[5]
						 + "\n---+---+---"
						 + "\n " + board[6] + " | " + board[7] + " | " + board[8]);
	}
}
