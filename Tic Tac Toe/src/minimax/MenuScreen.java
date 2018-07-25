package minimax;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuScreen() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{506, 0};
		gridBagLayout.rowHeights = new int[]{77, 167, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel.add(panel_3);
		
		JLabel label = new JLabel("");
		panel_3.add(label);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JButton btnNewButton = new JButton("HVH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		
		JLabel lblTicTacToe = new JLabel("Tic Tac Toe");
		panel_1.add(lblTicTacToe);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HVC");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CVC");
		panel.add(btnNewButton_2);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		BufferedImage img = null;
		try{
			img = ImageIO.read(this.getClass().getResource("res/TopLeftX.png"));
		} catch (Exception e){
			e.printStackTrace();
		}
		//Image scaledImg = img.getScaledInstance(panel_3.preferredSize().getWidth(), panel_3.getPreferredSize().getHeight(), 0);
		//panel_3.add(new JLabel(new ImageIcon(scaledImg)));
	}
}
