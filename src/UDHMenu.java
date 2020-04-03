import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UDHMenu extends JFrame{
	private JPanel panel = new JPanel(new GridBagLayout());
	
	private JLabel ucc = new JLabel("Upper Canada College");
	private JButton menuHome = new JButton("Menu Home");
	
	private JLabel udhMenu = new JLabel("Upper Dining Hall Menu");
	private JLabel date = new JLabel("Date:");
	
	private JLabel entre = new JLabel("Entre:");
	private JLabel sides = new JLabel("Sides:");
	private JLabel saladbar = new JLabel("Salad Bar:");
	private JLabel desert = new JLabel("Desert:");
	
	private JLabel entredescription = new JLabel("Description");
	private JLabel sidesdescription = new JLabel("Description");
	private JLabel saladbardescription = new JLabel("Description");
	private JLabel desertdescription = new JLabel("Description");
	
	private JButton previous = new JButton("Previous Day");
	private JButton next = new JButton("Next Day");
	
	public UDHMenu() {
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0; 
		c1.gridy = 0; 
		c1.anchor = GridBagConstraints.WEST;
		panel.add(ucc, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 2; 
		c2.gridy = 0;
		c2.anchor = GridBagConstraints.EAST;
		panel.add(menuHome, c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 1; 
		panel.add(udhMenu, c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 1; 
		c4.gridy = 2; 
		panel.add(date, c4);
		
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 0;
		c5.gridy = 3;
		c5.anchor = GridBagConstraints.WEST;
		panel.add(entre, c5);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 1; 
		c6.gridy = 3; 
		panel.add(entredescription, c6);
		
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 0; 
		c7.gridy = 4; 
		c7.anchor = GridBagConstraints.WEST;
		panel.add(sides, c7);
		
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 1; 
		c8.gridy = 4; 
		panel.add(sidesdescription, c8);
		
		GridBagConstraints c9 = new GridBagConstraints();
		c9.gridx = 0;
		c9.gridy = 5;
		c9.anchor = GridBagConstraints.WEST;
		panel.add(saladbar, c9);
		
		GridBagConstraints c10 = new GridBagConstraints();
		c10.gridx = 1; 
		c10.gridy = 5;
		panel.add(saladbardescription, c10);
		
		GridBagConstraints c11 = new GridBagConstraints();
		c11.gridx = 0; 
		c11.gridy = 6; 
		c11.anchor = GridBagConstraints.WEST;
		panel.add(desert, c11);
		
		GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 1;
		c12.gridy = 6;
		panel.add(desertdescription, c12);
		
		GridBagConstraints c13 = new GridBagConstraints();
		c13.gridx = 0;
		c13.gridy = 7;
		c13.anchor = GridBagConstraints.SOUTHWEST;
		panel.add(previous, c13);
		
		GridBagConstraints c14 = new GridBagConstraints();
		c14.gridx = 2; 
		c14.gridy = 7;
		c14.anchor = GridBagConstraints.EAST;
		panel.add(next, c14);
		
		panel.setBorder(new EmptyBorder(30,30,30,30));
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();//Auto Adjusts everything for size
		this.setVisible(true); //last thing
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UDHMenu m = new UDHMenu();
	}

}