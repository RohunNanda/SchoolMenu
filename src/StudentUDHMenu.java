import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class StudentUDHMenu extends JFrame{

	
	//GUI BITS
	private JPanel panel = new JPanel(new GridBagLayout());

	private JLabel ucc = new JLabel("Upper Canada College");
	private JButton menuHome = new JButton("Menu Home");
	private JLabel udhMenu = new JLabel("Upper Dining Hall Menu");
	
	
	private JTextArea[] meals = new JTextArea[5];
	
	private JLabel[] days = new JLabel[5];
	private static String[] DAYSOFWEEK = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};//Constant array of strings
	
	private JButton next = new JButton("Next");
	private JButton previous = new JButton("Previous");
	private Controller c1;
	//DATA BITS
	private UpperDiningHallMenu[] menus = new UpperDiningHallMenu[10];
	private int currentMenu = 0;
	
	private ActionListener listenPrevious= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			updateDisplay(-5);
		}
		
	};		
	private ActionListener listenNext = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			updateDisplay(5);
		}
		
	};
	
	private ActionListener returnHomeAction = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("TEST");
			c1.activate(0);
		}
		
	};

	public StudentUDHMenu(Controller c) {
		c1 = c;//assignment, never taking the controller
		System.out.println(c1);
		menus = c1.getMenus();
		System.out.println(Arrays.toString(menus));
		
		menuHome.addActionListener(returnHomeAction);
		panel.setBorder(new EmptyBorder(30,30,30,30));

		GridBagConstraints a = new GridBagConstraints();
		a.gridx = 0;
		a.gridy = 0;
		a.anchor = GridBagConstraints.WEST;
		ucc.setFont(c1.title);
		panel.add(ucc, a);
		
		GridBagConstraints b = new GridBagConstraints();
		b.gridx = 4;
		b.gridy = 0; 
		b.anchor = GridBagConstraints.EAST;
		menuHome.setFont(c1.label);
		panel.add(menuHome, b);
		
		GridBagConstraints d = new GridBagConstraints();
		d.gridx = 2; 
		d.gridy = 1 ;
		udhMenu.setFont(c1.title);
		panel.add(udhMenu, d);
		
		
		
		
		//GUI READY
		
		//This happens when the object is first created. 
		//We need an instance method that does this, but without constructing and placing. 
		//This loop creates adds all elements of the array to the calendar-formatted menu
		
		for (int i = 0; i < meals.length; i = i + 1) {
			
			GridBagConstraints c4 = new GridBagConstraints();
			c4.gridy = 3;
			c4.gridx = i;
			c4.insets = new Insets(7,10,10,10);
			meals[i] = new JTextArea();
			meals[i].setPreferredSize(new Dimension(200,100));
			panel.add(meals[i], c4);
			String temp = menus[currentMenu + i].getEntre()+"\n"+menus[currentMenu + i].getSides()+"\n"+menus[currentMenu + i].getSaladbar()+"\n"+menus[currentMenu + i].getDesert();
			//Put in area
			meals[i].setText(temp);
			
			c4.gridy = 2;
			c4.gridx = i;
			days[i] = new JLabel(DAYSOFWEEK[i]);
			panel.add(days[i], c4);
			
			meals[i].setEditable(false);
			meals[i].setFont(c1.label);
			days[i].setFont(c1.label);
			meals[i].setBackground(new Color(188, 217, 255));
		}
		
		//next.setPreferredSize(new Dimension(5,5));
		//previous.setPreferredSize(new Dimension(5,5));
		
		
		
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 4; 
		c7.gridy = 4;
		c7.anchor = GridBagConstraints.EAST;
		next.setFont(c1.label);
		panel.add(next, c7);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0; 
		c2.gridy = 4; 
		c2.anchor = GridBagConstraints.WEST;
		previous.setFont(c1.label);
		panel.add(previous, c2);
		
		next.addActionListener(listenNext);
		previous.addActionListener(listenPrevious);
		
		menus[currentMenu].getEntre();
		menus[currentMenu].getSides();
		menus[currentMenu].getSaladbar();
		menus[currentMenu].getDesert();
		
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setVisible(false);
		
		panel.setBackground(new Color(255,245,199));
		
		
	}
	
	
	public void update() {
		
		for (int i = 0; i < meals.length; i = i + 1) {
			
			String temp = menus[currentMenu + i].getEntre()+"\n"+menus[currentMenu + i].getSides()+"\n"+menus[currentMenu + i].getSaladbar()+"\n"+menus[currentMenu + i].getDesert();
			//Put in area
			meals[i].setText(temp);
			//A variable, temp, is then created to store the strings assigned as the setEntre. For now, the other get methods are empty
			//or filled depending a string has been submitted as a menu item.
			//The "/n" translates to a new line; therefore when printing the string in the mealDisplay textfield, all menu items appear
			//on succeeding lines
			//This function will change the currentMenu "int" and then update the menu's display
			//update function is called in the Controller to officially update the display of the "StudentLDHMenu" class
			
		}
	}
	
	/**
	 * This function will change the currentMenu integer and then update the 
	 * display 
	 * @param dir
	 * 
	 * precondition: direction is 1 or -1, 1 means forward, -1 means backwards
	 */
	public void updateDisplay(int dir) {
		
		currentMenu = currentMenu + dir;
		
		//NULL CHECK
		if (menus[currentMenu] == null || currentMenu < 0 || currentMenu > menus.length) {
			//UPDATE WITH MSG SAYING NO DATA
			System.out.println("error");
		}
		else {
			//DELETE WHAT IS IN THE area
			for (int i = 0; i < 5; i = i +1) {
				meals[i].setText("");
				//Create the new content
				String temp = menus[currentMenu + i].getEntre()+"\n"+menus[currentMenu + i].getSides() + "\n"+menus[currentMenu + i].getSaladbar()+"\n"+menus[currentMenu + i].getDesert();
				//Put in area
				meals[i].setText(temp);
			}
			
		}
		
		
	}

}