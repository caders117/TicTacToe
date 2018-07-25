package minimax;

import java.io.File;

import javax.swing.JFrame;

public class GUITest {
	

	public static void main(String[] args) {
		TicComputer comp = new TicComputer('O');
		TicGame game = new TicGame();
		TicGUI gui = new TicGUI(game, comp);
		
		JFrame frame = new JFrame("Tic tac toe?");
		//frame.add(gui);
		frame.add(new MenuScreen());
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
}
