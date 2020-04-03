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

public class StudentLDHMenu extends JFrame{
	
	//GUI BITS
		private JPanel panel = new JPanel(new GridBagLayout());

		private JLabel ucc = new JLabel("Upper Canada College");
		private JButton menuHome = new JButton("Menu Home");
		private JLabel ldhMenu = new JLabel("Lower Dining Hall Menu");
		
		private JTextArea[] meals = new JTextArea[5];
		
		private JLabel[] days = new JLabel[5];
		private static String[] DAYSOFWEEK = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};//Constant array of strings
		
		private JButton next = new JButton("Next");
		private JButton previous = new JButton("Previous");
		
		//DATA BITS
		private LowerDiningHallMenu[] menus = new LowerDiningHallMenu[10];
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
				System.out.println("TESTer");
				c.activate(0);
			}
			
		};
		
		private Controller c;

		public StudentLDHMenu(Controller c7) {
			c = c7;
			System.out.println(c);
			menus = c.getMenusL();
			System.out.println(Arrays.toString(menus));
			
			menuHome.addActionListener(returnHomeAction);
			panel.setBorder(new EmptyBorder(30,30,30,30));
			
			GridBagConstraints a = new GridBagConstraints();
			a.gridx = 0;
			a.gridy = 0; 
			a.anchor = GridBagConstraints.WEST;
			ucc.setFont(c.title);
			panel.add(ucc, a);
			
			GridBagConstraints b = new GridBagConstraints();
			b.gridx = 4;
			b.gridy = 0; 
			b.anchor = GridBagConstraints.EAST;
			menuHome.setFont(c.label);
			panel.add(menuHome, b);
			
			GridBagConstraints d = new GridBagConstraints();
			d.gridx = 2; 
			d.gridy = 1 ;
			ldhMenu.setFont(c.title);
			panel.add(ldhMenu, d);
			
			
			//GUI READY
			
			
			for (int i = 0; i < meals.length; i = i + 1) {
				
				GridBagConstraints cz = new GridBagConstraints();
				cz.gridy = 3;
				cz.gridx = i;
				cz.insets = new Insets(7,10,10,10);
				meals[i] = new JTextArea();
				meals[i].setPreferredSize(new Dimension(200,100));
				panel.add(meals[i], cz);
				String temp = menus[currentMenu + i].getEntre()+"\n"+menus[currentMenu + i].getSides()+"\n"+menus[currentMenu + i].getSpecialSnacks()+"\n"+menus[currentMenu + i].getPizza();
				//Put in area
				meals[i].setText(temp);
				
				cz.gridy = 2;
				cz.gridx = i;
				days[i] = new JLabel(DAYSOFWEEK[i]);
				panel.add(days[i], cz);
				
				meals[i].setEditable(false);
				meals[i].setFont(c.label);
				days[i].setFont(c.label);
				meals[i].setBackground(new Color(188,217,255));
				
			}
			
			//next.setPreferredSize(new Dimension(5,5));
			//previous.setPreferredSize(new Dimension(5,5));
			
			
			
			
			GridBagConstraints c1 = new GridBagConstraints();
			c1.gridx = 4; 
			c1.gridy = 4; 
			c1.anchor = GridBagConstraints.EAST;
			next.setFont(c.label);
			panel.add(next, c1);
			
			GridBagConstraints c2 = new GridBagConstraints();
			c2.gridx = 0; 
			c2.gridy = 4; 
			c2.anchor = GridBagConstraints.WEST;
			previous.setFont(c.label);
			panel.add(previous, c2);
			
			next.addActionListener(listenNext);
			previous.addActionListener(listenPrevious);
			
			menus[currentMenu].getEntre();
			menus[currentMenu].getSides();
			menus[currentMenu].getSpecialSnacks();
			menus[currentMenu].getPizza();
			
			//Add first menu item
			//area.setText(temp);
			
			
			this.add(panel);
			//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.pack();
			this.setVisible(false);
			
			panel.setBackground(new Color(255,245,199));
			
			
		}
		
		public void updatelower() {
			for (int i = 0; i < meals.length; i = i + 1) {
				
				String temp = menus[currentMenu + i].getEntre()+"\n"+menus[currentMenu + i].getSides()+"\n"+menus[currentMenu + i].getSpecialSnacks()+"\n"+menus[currentMenu + i].getPizza();
				//Put in area
				meals[i].setText(temp);
			}
		}
		
		/**
		 * This function will change the currentMenu int and then update teh 
		 * display 
		 * @param dir
		 * 
		 * precondition: direction is 1 or -1, 1 means forward, -1 means backwards
		 */
		public void updateDisplay(int dir) {
			
			currentMenu = currentMenu + dir;
			
			//NULL CHECK
			if (menus[currentMenu] == null || currentMenu < 0 || currentMenu > 99) {
				//UPDATE WITH MSG SAYING NO DATA
				System.out.println("error");
			}
			else {
				//DELETE WHAT IS IN THE area
				for (int i = 0; i < 5; i = i +1) {
					meals[i].setText("");
					//Create the new content
					String temp = menus[currentMenu + i].getEntre()+"\n"+menus[currentMenu + i].getSides() + "\n"+menus[currentMenu + i].getSpecialSnacks()+"\n"+menus[currentMenu + i].getPizza();
					//Put in area
					meals[i].setText(temp);
				}
				
			}
			
			
		}
		
	
}