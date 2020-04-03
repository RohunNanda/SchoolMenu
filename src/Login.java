import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame{
	
	private JPanel panel = new JPanel(new GridBagLayout());
	
	private JLabel ucc = new JLabel("Upper Canada College");
	private JButton menuHome = new JButton ("Menu Home");
			
	private JLabel titleLabel = new JLabel("Administration Login");
	private JLabel usernameLabel = new JLabel("Username:");
	private JLabel passwordLabel = new JLabel("Password:");
	
	private JTextField usernameField = new JTextField("",20);
	private JPasswordField passwordField = new JPasswordField("",20);
	
	private JButton loginButton = new JButton("Login");
	
	private Controller c1;
	private ActionListener returnHomeAction = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			c1.activate(0);
		}
		
	};
	private ActionListener loginAction = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Login Action");
			
			String user;
			String pass;
			user = usernameField.getText();
			pass = passwordField.getText();
			
			if (user.equals("Administration") && pass.equals("Password")) {
				c1.activate(2);
				usernameField.setText(null);
				passwordField.setText(null);
			}
			else {
				JOptionPane.showMessageDialog(loginButton, "Invalid login credentials. Please try again.");
				usernameField.setText(null);
				passwordField.setText(null);
			}
		}
		
	};
	
	public Login(Controller c) {
		
		c1=c;
		
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 0;
		c7.gridy = 0;
		c7.anchor = GridBagConstraints.WEST;
		ucc.setFont(c.title);
		panel.add(ucc, c7);
		
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 2;
		c8.gridy = 0;
		c8.anchor = GridBagConstraints.EAST;
		menuHome.setFont(c.label);
		panel.add(menuHome, c8);
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 2;
		c1.gridy = 5;
		c1.anchor = GridBagConstraints.EAST;
		titleLabel.setFont(c.label);
		panel.add(titleLabel,c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 2;
		c2.anchor = GridBagConstraints.WEST;
		usernameLabel.setFont(c.label);
		panel.add(usernameLabel, c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 0;
		c3.gridy = 3;
		c3.anchor = GridBagConstraints.WEST;
		passwordLabel.setFont(c.label);
		panel.add(passwordLabel, c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 1;
		c4.gridy = 2;
		c4.gridwidth = 2;
		panel.add(usernameField, c4);
		
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 1;
		c5.gridy = 3;
		c5.gridwidth = 2;
		passwordField.setEchoChar('●');
		panel.add(passwordField, c5);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 1;
		c6.gridy = 4;
		loginButton.setFont(c.label);
		panel.add(loginButton, c6);
		
		menuHome.addActionListener(returnHomeAction);
		loginButton.addActionListener(loginAction);
		
		panel.setBorder(new EmptyBorder(30,30,30,30));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();//Auto Adjusts everything for size
		this.setVisible(false); //last thing
		
		panel.setBackground(new Color(255,245,199));
		
		
	}

}