package minimax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TicComputer {
	
	private char letter;
	private char opponent;
	
	public TicComputer(char startLetter) {
		letter = startLetter;
		opponent = letter == 'O' ? 'X' : 'O';
	}
	
	public char getLetter() {
		return letter;
	}
	
	public int chooseBestMove(char[] board) {
		if(getPossibleMoves(board).length != 0) {
			ArrayList<Integer> scores = new ArrayList<Integer>();
			ArrayList<Integer> moves = new ArrayList<Integer>();
			for(int move : getPossibleMoves(board)) {
				scores.add(scoreMove(board, move, letter));
				moves.add(move);
			}
			System.out.println("Move chosen: " + moves.get(scores.indexOf(Collections.max(scores))));
			System.out.println("With score: " + Collections.max(scores));
		//	System.out.println(scores.toString());
		//	System.out.println(moves.toString());
			return moves.get(scores.indexOf(Collections.max(scores)));
		} else {
			System.err.println("No moves available.");
			return -1;
		}
	}
		
	/**
	 * Uses minimax algorithm.  I think.
	 */
	public int scoreMove(char[] board, int spot, char letter) {
		if(score(board) != 0 || getPossibleMoves(board).length == 0) {
			return score(board);
		} else {
			ArrayList<Integer> scores = new ArrayList<Integer>();
			char[] newBoard = board.clone();
			newBoard[spot] = letter;
			char newLetter = (letter == 'X') ? 'O' : 'X';
			if(getPossibleMoves(newBoard).length != 0) {
				for(int move : getPossibleMoves(newBoard)) {
					scores.add(scoreMove(newBoard, move, newLetter));
				}
			} else {
				scores.add(score(newBoard));
			}
			if(letter == this.letter)
				return Collections.min(scores);
			else
				return Collections.max(scores);
		}
	}

	public int score(char[] board) {
		if(TicGame.checkWin(board, letter))
			return 1;
		else if(TicGame.checkWin(board, opponent))
			return -1;
		else
			return 0;
	}
	
	public int[] getPossibleMoves(char[] board) {
		ArrayList<Integer> moves = new ArrayList<Integer>();
		for(int i = 0; i < board.length; i++) 
			if(board[i] == '\0')
				moves.add(i);
		
		int[] ary = new int[moves.size()];
		for(int i = 0; i < moves.size(); i++)
			ary[i] = moves.get(i);
		return ary;
	}
}
