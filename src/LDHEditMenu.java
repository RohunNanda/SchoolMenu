import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.zip.CRC32;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LDHEditMenu extends JFrame{
	
	private JPanel panel = new JPanel(new GridBagLayout());
	
	private JLabel ucc = new JLabel("Upper Canada College");

	
	private JLabel ldhMenu = new JLabel("Lower Dining Hall Menu");
	private JLabel date = new JLabel("Date:");
	
	
	private JLabel entre = new JLabel("Entree:");
	private JLabel sides = new JLabel("Sides:");
	private JLabel specialsnacks = new JLabel("Special Snacks:");
	private JLabel pizza = new JLabel("Pizza:");
	
	private JTextField entredescription;
	private JTextField sidesdescription;
	private JTextField specialsnacksdescription;
	private JTextField pizzadescription;
	
	private JButton submitentre = new JButton("Submit Entree");
	private JButton submitsides = new JButton("Submit Sides");
	private JButton submitspecialsnacks = new JButton("Submit Special Snacks");
	private JButton submitpizza = new JButton("Submit Pizza");
	
	private LowerDiningHallMenu item;
	private AdminLowerDiningHallMenu aldh;
	private StudentLDHMenu stlm;
	private JTextArea mealDisplay;
	
	private Controller xx;
	
	Font title = new Font("Monospaced", Font.BOLD, 15);
	Font label = new Font("Monospaced", Font.CENTER_BASELINE, 13);
	
	
	private ActionListener listen = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent w) {
			// TODO Auto-generated method stub
			System.out.print("listening");
			if (w.getSource() == submitentre) {
				//When the submit button is pressed, the string is stored to the Entree variable in the LowerDiningHallMenu class
				item.setEntre(entredescription.getText());
				String temp = item.getEntre()+"\n"+item.getSides()+"\n"+item.getSpecialSnacks()+"\n"+item.getPizza();
				//A variable, temp, is then created to store the strings assigned as the setEntre. For now, the other get methods are empty
				//or filled depending a string has been submitted as a menu item.
				//The "/n" translates to a new line; therefore when printing the string in the mealDisplay textfield, all menu items appear
				//on succeeding lines
				mealDisplay.setText(temp);
				//The temp variable, which stores all submitted menu item Strings, is printed to the mealDisplay textfield for a specific day.
				//This step repeats for each individual menu item when the actionlistener for its corresponding button is executed.
			}
			if (w.getSource() == submitsides) {
				item.setSides(sidesdescription.getText());
				String temp = item.getEntre()+"\n"+item.getSides()+"\n"+item.getSpecialSnacks()+"\n"+item.getPizza();
				mealDisplay.setText(temp);
			}
			if (w.getSource() == submitspecialsnacks) {
				item.setSpecialSnacks(specialsnacksdescription.getText());
				String temp = item.getEntre()+"\n"+item.getSides()+"\n"+item.getSpecialSnacks()+"\n"+item.getPizza();
				mealDisplay.setText(temp);
			}
			if (w.getSource() == submitpizza) {
				item.setPizza(pizzadescription.getText());
				String temp = item.getEntre()+"\n"+item.getSides()+"\n"+item.getSpecialSnacks()+"\n"+item.getPizza();
				mealDisplay.setText(temp);
			}
		}
		
	};
	
	
	public LDHEditMenu(String entr3, String side, String spsnk, String piz, LowerDiningHallMenu litem, JTextArea md) {

		mealDisplay = md;
		item = litem;
		
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0; 
		c1.gridy = 0; 
		c1.anchor = GridBagConstraints.WEST;
		ucc.setFont(title);
		panel.add(ucc, c1);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 1; 
		ldhMenu.setFont(label);
		panel.add(ldhMenu, c3);
		
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
		
		entredescription = new JTextField("Entree:"+entr3);
		entredescription.setPreferredSize(new Dimension(220,30));
		entredescription.setFont(label);
		sidesdescription = new JTextField("Sides:"+side);
		sidesdescription.setPreferredSize(new Dimension(220,30));
		sidesdescription.setFont(label);
		specialsnacksdescription = new JTextField("Special Snack:"+spsnk);
		specialsnacksdescription.setPreferredSize(new Dimension(220,30));
		specialsnacksdescription.setFont(label);
		pizzadescription = new JTextField("Pizza:"+piz);
		pizzadescription.setPreferredSize(new Dimension(220,30));
		pizzadescription.setFont(label);
		
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
		specialsnacks.setFont(label);
		panel.add(specialsnacks, c9);
		
		GridBagConstraints c10 = new GridBagConstraints();
		c10.gridx = 1; 
		c10.gridy = 5;
		panel.add(specialsnacksdescription, c10);
		
		submitspecialsnacks.addActionListener(listen);
		GridBagConstraints c10a = new GridBagConstraints();
		c10a.gridx = 2; 
		c10a.gridy = 5; 
		c10a.anchor = GridBagConstraints.EAST;
		submitspecialsnacks.setFont(label);
		panel.add(submitspecialsnacks, c10a);
		
		GridBagConstraints c11 = new GridBagConstraints();
		c11.gridx = 0; 
		c11.gridy = 6; 
		c11.anchor = GridBagConstraints.WEST;
		pizza.setFont(label);
		panel.add(pizza, c11);
		
		GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 1;
		c12.gridy = 6;
		panel.add(pizzadescription, c12);
		
		submitpizza.addActionListener(listen);
		GridBagConstraints c12a = new GridBagConstraints();
		c12a.gridx = 2; 
		c12a.gridy = 6;
		c12a.anchor = GridBagConstraints.EAST;
		submitpizza.setFont(label);
		panel.add(submitpizza, c12a);
		
		panel.setBorder(new EmptyBorder(30,30,30,30));
		panel.setBackground(new Color(255,245,199));
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();//Auto Adjusts everything for size
		this.setVisible(true); //last thing	
	
	}
	
	

}