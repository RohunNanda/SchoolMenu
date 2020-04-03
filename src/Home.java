import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {

	private JPanel panel = new JPanel(new GridBagLayout());
	
	private JLabel ucc = new JLabel ("  Upper Canada College");
	private JButton menuHome = new JButton("Menu Home");
	
	//THIS OBJECT IS CREATED RIGHT AWAY:
	//	The menu that is being displayed is set at this point. 
	//	The admin window changes the menu list, but you have to then signal to the UDHMenu an update so it can update the disaply
	private JButton UDHMenu = new JButton ("Upper Dining Hall Menu");
	private JButton LDHMenu = new JButton ("Lower Dining Hall Menu");
	private JButton adminLogin = new JButton ("Administration Login");
	private JButton feedbackForm = new JButton("Feedback Form");
	
	Controller c1;
	
	private ActionListener loginAction = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			c1.activate(1);
		}
		
	};
	
	private ActionListener StudentUDHMenuAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			c1.activate(3);
			
		}
		
	};
	
	private ActionListener StudentLDHMenuAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			c1.activate(4);
		}
		
	};
	
	MouseListener uccURL = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Desktop browser = Desktop.getDesktop();
			
			try {
				browser.browse(new URI("https://www.ucc.on.ca/"));
			}
			catch(IOException err) {}
			
			catch (URISyntaxException err) {}
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};

	
	MouseListener feedbackFormHyperLink = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Desktop browser = Desktop.getDesktop();
			
			try {
				browser.browse(new URI("https://forms.gle/FhXoTue7H32HtQWN7"));
			}
			catch(IOException err) {}
			
			catch (URISyntaxException err) {}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public Home(Controller c) {
		c1 = c;
		adminLogin.addActionListener(loginAction);
		UDHMenu.addActionListener(StudentUDHMenuAction);
		LDHMenu.addActionListener(StudentLDHMenuAction);
		ucc.addMouseListener(uccURL);
		feedbackForm.addMouseListener(feedbackFormHyperLink);
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 0;
		c1.anchor = GridBagConstraints.WEST;
		ucc.setFont(c.title);
		panel.add(ucc, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 2;
		c2.gridy = 0;
		c2.anchor = GridBagConstraints.EAST;
	
		menuHome.setFont(c.label);
		panel.add(menuHome, c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 0; 
		c3.gridy = 1; 
		UDHMenu.setFont(c.label);
		panel.add(UDHMenu, c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 1;
		c4.gridy = 1;
		LDHMenu.setFont(c.label);
		panel.add(LDHMenu, c4);
		
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 2;
		c5.gridy = 1;
		adminLogin.setFont(c.label);
		panel.add(adminLogin, c5);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 0; 
		c6.gridy = 2; 
		c6.gridwidth = 3;
		c6.fill = GridBagConstraints.HORIZONTAL;
		feedbackForm.setFont(c.label);
		panel.add(feedbackForm, c6);
		
		panel.setBorder(new EmptyBorder(30,30,30,30));
		panel.setBackground(new Color(255,245,199));
		//UDHMenu.setBorder(new RoundedBorder(8));
		//LDHMenu.setBorder(new RoundedBorder(8));
		//adminLogin.setBorder(new RoundedBorder(8));
		//feedbackForm.setBorder(new RoundedBorder(8));
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();//Auto Adjusts everything for size
		this.setVisible(true); //last thing
		
		//menuHome.setBorder(new RoundedBorder(10));
		//UDHMenu.setBorder(new RoundedBorder(10));
		//LDHMenu.setBorder(new RoundedBorder(10));
		//adminLogin.setBorder(new RoundedBorder(10));
		//feedbackForm.setBorder(new RoundedBorder(10));
		
		
		
	}
	
	
	 public static void main(String[] args) {
	        
	 }
}