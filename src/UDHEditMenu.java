import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UDHEditMenu extends JFrame{
	
	private JPanel panel = new JPanel(new GridBagLayout());
	
	private JLabel ucc = new JLabel("Upper Canada College");
	
	private JLabel udhMenu = new JLabel("Upper Dining Hall Menu");
	private JLabel date = new JLabel("Date:");
	
	
	private JLabel entre = new JLabel("Entree:");
	private JLabel sides = new JLabel("Sides:");
	private JLabel saladbar = new JLabel("Salad Bar:");
	private JLabel desert = new JLabel("Dessert:");
	
	private JTextField entredescription;
	private JTextField sidesdescription;
	private JTextField saladbardescription;
	private JTextField desertdescription;
	
	private JButton submitentre = new JButton("Submit Entree");
	private JButton submitsides = new JButton("Submit Sides");
	private JButton submitsaladbar = new JButton("Submit Salad Bar");
	private JButton submitdesert = new JButton("Submit Dessert");
	
	private UpperDiningHallMenu item;
	private AdminUpperDiningHallMenu audh;
	private StudentUDHMenu stum;
	private JTextArea mealDisplay;
	
	Font title = new Font("Monospaced", Font.BOLD, 15);
	Font label = new Font("Monospaced", Font.CENTER_BASELINE, 13);
	
	private ActionListener listen = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent z) {
			System.out.println("listenening");
			if (z.getSource() == submitentre) {
				
				item.setEntre(entredescription.getText());
				
				String temp = item.getEntre()+"\n"+item.getSides()+"\n"+item.getSaladbar()+"\n"+item.getDesert();
				
				mealDisplay.setText(temp);
			}
			
			if (z.getSource() == submitsides) {
				item.setSides(sidesdescription.getText());
				
				String temp = item.getEntre()+"\n"+item.getSides()+"\n"+item.getSaladbar()+"\n"+item.getDesert();
				
				mealDisplay.setText(temp);
			}
			if (z.getSource() == submitsaladbar) {
				item.setSaladBar(saladbardescription.getText());
				
				String temp = item.getEntre()+"\n"+item.getSides()+"\n"+item.getSaladbar()+"\n"+item.getDesert();
				
				mealDisplay.setText(temp);
			}
			if (z.getSource() == submitdesert) {
				
				item.setDesert(desertdescription.getText());
				
				String temp = item.getEntre()+"\n"+item.getSides()+"\n"+item.getSaladbar()+"\n"+item.getDesert();
				
				mealDisplay.setText(temp);
			}
			//You need to add this listener for 
			//every button
		}
		
		
	};
	
	public UDHEditMenu(String ent, String side, String sbar, String des, UpperDiningHallMenu mitem, JTextArea md) {
	
		mealDisplay = md;
		item = mitem;
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0; 
		c1.gridy = 0; 
		c1.anchor = GridBagConstraints.WEST;
		ucc.setFont(title);
		panel.add(ucc, c1);
	
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 1; 
		udhMenu.setFont(label);
		panel.add(udhMenu, c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 1; 
		c4.gridy = 2; 
		date.setFont(label);
		panel.add(date, c4);
		
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 0;
		c5.gridy = 3;
		c5.anchor = GridBagConstraints.WEST;
		entre.setFont(label);
		panel.add(entre, c5);
		
		entredescription = new JTextField("Entree:"+ent);
		entredescription.setPreferredSize(new Dimension(220,30));
		entredescription.setFont(label);
		sidesdescription = new JTextField("Sides:"+side);
		sidesdescription.setPreferredSize(new Dimension(220,30));
		sidesdescription.setFont(label);
		saladbardescription = new JTextField("Salad Bar:"+sbar);
		saladbardescription.setPreferredSize(new Dimension(220,30));
		saladbardescription.setFont(label);
		desertdescription = new JTextField("Dessert:"+des);
		desertdescription.setPreferredSize(new Dimension(220,30));
		desertdescription.setFont(label);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 1; 
		c6.gridy = 3; 
		panel.add(entredescription, c6);
		
		
		submitentre.addActionListener(listen);
		GridBagConstraints c6a = new GridBagConstraints();
		c6a.gridx = 2; 
		c6a.gridy = 3;
		c6a.anchor = GridBagConstraints.EAST;
		submitentre.setFont(label);
		panel.add(submitentre, c6a);
		
		

		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 0; 
		c7.gridy = 4; 
		c7.anchor = GridBagConstraints.WEST;
		sides.setFont(label);
		panel.add(sides, c7);
		
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 1; 
		c8.gridy = 4; 
		panel.add(sidesdescription, c8);
		

		submitsides.addActionListener(listen);
		GridBagConstraints c8a = new GridBagConstraints();
		c8a.gridx = 2; 
		c8a.gridy = 4; 
		c8a.anchor = GridBagConstraints.EAST;
		submitsides.setFont(label);
		panel.add(submitsides, c8a);
		
		GridBagConstraints c9 = new GridBagConstraints();
		c9.gridx = 0;
		c9.gridy = 5;
		c9.anchor = GridBagConstraints.WEST;
		saladbar.setFont(label);
		panel.add(saladbar, c9);
		
		GridBagConstraints c10 = new GridBagConstraints();
		c10.gridx = 1; 
		c10.gridy = 5;
		panel.add(saladbardescription, c10);
		
		submitsaladbar.addActionListener(listen);
		GridBagConstraints c10a = new GridBagConstraints();
		c10a.gridx = 2; 
		c10a.gridy = 5; 
		c10a.anchor = GridBagConstraints.EAST;
		submitsaladbar.setFont(label);
		panel.add(submitsaladbar, c10a);
		
		GridBagConstraints c11 = new GridBagConstraints();
		c11.gridx = 0; 
		c11.gridy = 6; 
		c11.anchor = GridBagConstraints.WEST;
		desert.setFont(label);
		panel.add(desert, c11);
		
		GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 1;
		c12.gridy = 6;
		panel.add(desertdescription, c12);
		
		submitdesert.addActionListener(listen);
		GridBagConstraints c12a = new GridBagConstraints();
		c12a.gridx = 2; 
		c12a.gridy = 6;
		c12a.anchor = GridBagConstraints.EAST;
		submitdesert.setFont(label);
		panel.add(submitdesert, c12a);
		
		panel.setBorder(new EmptyBorder(30,30,30,30));
		panel.setBackground(new Color(255,245,199));
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();//Auto Adjusts everything for size
		this.setVisible(true); //last thing
		
	}
	
	
	
}