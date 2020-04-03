import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminHome extends JFrame{
	//comment

	private JPanel panel = new JPanel(new GridBagLayout());
	
	private JLabel ucc = new JLabel("  Upper Canada College");
	private JButton menuHome = new JButton("Menu Home");
	
	private JButton UDH = new JButton("Edit Menu for Upper Dining Hall");
	private JButton LDH = new JButton("Edit Menu for Lower Dining Hall");
	
	private Controller c1;
	
	private ActionListener returnHomeAction = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			c1.activate(0);
		}
		
	};
	
	private ActionListener EditUDHMenuAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			c1.activate(5);
		}
		
	};
	
	private ActionListener EditLDHMenuAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			c1.activate(6);
		}
		
	};
	public AdminHome(Controller c) {
		
		c1 = c;
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 0;
		c1.anchor = GridBagConstraints.WEST;
		ucc.setFont(c.title);
		panel.add(ucc, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 1;
		c2.gridy = 0;
		c2.anchor = GridBagConstraints.EAST;
		menuHome.setFont(c.label);
		panel.add(menuHome, c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 0;
		c3.gridy = 1;
		c1.anchor = GridBagConstraints.WEST;
		UDH.setFont(c.label);
		panel.add(UDH, c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 1;
		c4.gridy = 1;
		c2.anchor = GridBagConstraints.EAST;
		LDH.setFont(c.label);
		panel.add(LDH, c4);
		
		menuHome.addActionListener(returnHomeAction);
		UDH.addActionListener(EditUDHMenuAction);
		LDH.addActionListener(EditLDHMenuAction);
		panel.setBorder(new EmptyBorder(30,30,30,30));
		panel.setBackground(new Color(255,245,199));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();//Auto Adjusts everything for size
		this.setVisible(false); //last thing
	}
	

}