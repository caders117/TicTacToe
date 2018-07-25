package minimax;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class TicGUI extends JPanel {
	
	private JButton btns[] = new JButton[9];
	TicGame game;
	TicComputer comp;
	
	public TicGUI(TicGame tg, TicComputer tc) {
		setDefaultSize(100);
		initBtns();
		initBoard();
		game = tg;
		comp = tc;
	}
	
	public void initBtns() {
		for(int i = 0; i < 9; i++) {
			btns[i] = new JButton();
			btns[i].addActionListener(new TicListener());
			btns[i].setActionCommand(String.valueOf(i));
		}
	}
	
	public void initBoard() {
		this.setLayout(new GridLayout(3, 3));
		for(int i = 0; i < btns.length; i++) {
			this.add(btns[i]);
		}
	}
	
	private class TicListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton srcBtn = (JButton) e.getSource();
			srcBtn.setText(String.valueOf(game.getCurrentLetter()));
			srcBtn.setEnabled(false);
			game.move(Integer.valueOf(srcBtn.getActionCommand()));
			if(game.isOver()) {
				setDefaultSize(30);
				for(JButton btn : btns)
					btn.setEnabled(false);
				if(game.getWinner() == 'D')
					JOptionPane.showMessageDialog(getParent(), "Cat's Game", "Result", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(getParent(), "    " + game.getWinner() + " wins!", "Result", JOptionPane.INFORMATION_MESSAGE);
			}
			if(game.getCurrentLetter() == comp.getLetter()) {
				int compMove = comp.chooseBestMove(game.getBoard());
				if(compMove >= 0) btns[compMove].doClick();
			}
		}
		
	}
	
	/*
	 * Deals with hiDPI swing scaling problems
	 * Taken from http://stackoverflow.com/questions/26877517/java-swing-on-high-dpi-screen
	 */
	public static void setDefaultSize(int size) {
	
		Set<Object> keySet = UIManager.getLookAndFeelDefaults().keySet();
		Object[] keys = keySet.toArray(new Object[keySet.size()]);
		
		for (Object key : keys) {
			
			if (key != null && key.toString().toLowerCase().contains("font")) {
				
				//System.out.println(key);
				Font font = UIManager.getDefaults().getFont(key);
				if (font != null) {
				font = font.deriveFont((float)size);
				UIManager.put(key, font);
				}
			}
		}
	}
}
