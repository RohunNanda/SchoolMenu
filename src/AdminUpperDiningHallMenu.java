import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class AdminUpperDiningHallMenu extends JFrame{
	private JPanel panel = new JPanel(new GridBagLayout());
	
	private JLabel ucc = new JLabel("Upper Canada College");
	private JButton adminHome = new JButton("Adminstration Home");
	private JLabel udhMenu = new JLabel("Upper Dining Hall Menu");
	
	private JTextArea[] meals = new JTextArea[5];
	
	private JLabel[] days = new JLabel[5];
	private static String[] DAYSOFWEEK = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
	private JButton[] editdays = new JButton[5];
	private static String[] EDITDAYSOFWEEK = {"Edit Monday", "Edit Tuesday", "Edit Wednesday", "Edit Thursday", "Edit Friday"};
	
	private JButton next = new JButton("Next");
	private JButton previous = new JButton("Previous");
	
	private UpperDiningHallMenu[] menus;
	private int currentMenu = 0;
	
	private ActionListener listenPrevious = new ActionListener() {

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
	
	private ActionListener returnToAdminHomeAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			x.activate(2);
		}
		
	};
	

	private ActionListener alisten = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getSource()); //gets the reference of the object that was clicked
			//DUPLICATE THIS IF FOR EACH BUTTON
			if (e.getSource() == editdays[0]) {
				
				String temp = meals[currentMenu].getText();
				String[] temparr = temp.split("\n");
				
				UDHEditMenu tempUDH= new UDHEditMenu(temparr[0],temparr[1],temparr[2],temparr[3],menus[currentMenu],meals[0]);
				
			}
			if (e.getSource() == editdays[1]) {
				
				String temp = meals[currentMenu].getText();
				String[] temparr = temp.split("\n");
				
				UDHEditMenu tempUDH= new UDHEditMenu(temparr[0],temparr[1],temparr[2],temparr[3],menus[currentMenu + 1],meals[1]);
				
			}
			if (e.getSource() == editdays[2]) {
				
				String temp = meals[currentMenu].getText();
				String[] temparr = temp.split("\n");
				
				UDHEditMenu tempUDH= new UDHEditMenu(temparr[0],temparr[1],temparr[2],temparr[3],menus[currentMenu + 2],meals[2]);
				
			}
			if (e.getSource() == editdays[3]) {
				
				String temp = meals[currentMenu].getText();
				String[] temparr = temp.split("\n");
				
				UDHEditMenu tempUDH= new UDHEditMenu(temparr[0],temparr[1],temparr[2],temparr[3],menus[currentMenu + 3],meals[3]);
				
			}
			if (e.getSource() == editdays[4]) {
				
				String temp = meals[currentMenu].getText();
				String[] temparr = temp.split("\n");
				
				UDHEditMenu tempUDH= new UDHEditMenu(temparr[0],temparr[1],temparr[2],temparr[3],menus[currentMenu + 4],meals[4]);
				
			}
			
		}
		 
		
	};
	
	
	private Controller x;
	
	public AdminUpperDiningHallMenu(Controller x1) {
		x = x1;
		System.out.println(x);
		//becasue I am passing the reference into here any chances to menu will
		//change the menu field in the controller. 
		menus = x.getMenus();

		System.out.println(Arrays.toString(menus));
		
		adminHome.addActionListener(returnToAdminHomeAction);
		
		panel.setBorder(new EmptyBorder(30,30,30,30));
		
		GridBagConstraints a = new GridBagConstraints();
		a.gridx = 0;
		a.gridy = 0; 
		a.anchor = GridBagConstraints.WEST;
		ucc.setFont(x.title);
		panel.add(ucc, a);
		
		GridBagConstraints b = new GridBagConstraints();
		b.gridx = 4;
		b.gridy = 0; 
		b.anchor = GridBagConstraints.EAST;
		adminHome.setFont(x.label);
		panel.add(adminHome, b);
		
		GridBagConstraints d = new GridBagConstraints();
		d.gridx = 2; 
		d.gridy = 1 ;
		udhMenu.setFont(x.title);
		panel.add(udhMenu, d);
		
		
		
		//GUI READY
		
		
		for (int i = 0; i < meals.length; i = i + 1) {
			
			GridBagConstraints c = new GridBagConstraints();
			c.gridy = 3;
			c.gridx = i;
			c.insets = new Insets(7,10,10,10);
			meals[i] = new JTextArea();
			meals[i].setPreferredSize(new Dimension(200,100));
			panel.add(meals[i], c);
			String temp = menus[currentMenu + i].getEntre()+"\n"+menus[currentMenu + i].getSides()+"\n"+menus[currentMenu + i].getSaladbar()+"\n"+menus[currentMenu + i].getDesert();
			//Put in area
			meals[i].setText(temp);
			
			c.gridy = 2;
			c.gridx = i;
			days[i] = new JLabel(DAYSOFWEEK[i]);
			panel.add(days[i], c);
			
			c.gridy = 4; 
			c.gridx = i;
			editdays[i] = new JButton(EDITDAYSOFWEEK[i]);
			panel.add(editdays[i],c);
			editdays[i].addActionListener(alisten);
			editdays[i].setFont(x.label);
			meals[i].setFont(x.label);
			days[i].setFont(x.label);
			meals[i].setEditable(false);
			meals[i].setBackground(new Color(188, 217, 255));
		}
		
		//next.setPreferredSize(new Dimension(5,5));
		//previous.setPreferredSize(new Dimension(5,5));
		
		
		
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 4; 
		c1.gridy = 5;
		c1.anchor = GridBagConstraints.EAST;
		next.setFont(x.label);
		panel.add(next, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0; 
		c2.gridy = 5;
		c2.anchor = GridBagConstraints.WEST;
		previous.setFont(x.label);
		panel.add(previous, c2);
		
		next.addActionListener(listenNext);
		previous.addActionListener(listenPrevious);
		
		menus[currentMenu].getEntre();
		menus[currentMenu].getSides();
		menus[currentMenu].getSaladbar();
		menus[currentMenu].getDesert();
		
		
		this.add(panel);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(false);
		
		panel.setBackground(new Color(255,245,199));
		
	}
	
	public void updateDisplay(int dir) {
		currentMenu = currentMenu + dir;
		
		if (menus[currentMenu] == null || currentMenu < 0 || currentMenu > 11) {
			System.out.println("error");
		}
		else {
			for (int i = 0; i < 5; i = i + 1) {
				meals[i].setText("");
				String temp = menus[currentMenu + i].getEntre()+"\n"+menus[currentMenu + i].getSides() + "\n"+menus[currentMenu + i].getSaladbar()+"\n"+menus[currentMenu + i].getDesert();
				meals [i].setText(temp);
			}
		}
	}
	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AdminUpperDiningHallMenu a = new AdminUpperDiningHallMenu();
	//}

}