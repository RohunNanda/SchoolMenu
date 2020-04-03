import java.awt.Color;
import java.awt.Font;

public class Controller {

	Home home;
	Login login;
	AdminHome aHome;
	StudentUDHMenu sum;
	StudentLDHMenu lum;
	AdminUpperDiningHallMenu adminUDHMenu;
	AdminLowerDiningHallMenu adminLDHMenu;
	Font title = new Font("Monospaced", Font.BOLD, 15);
	Font label = new Font("Monospaced", Font.CENTER_BASELINE, 13);

	
	
	//Data Fields

	//When you start your class you would load the entire menu into this array. 
	//This represents one day of menu

	private UpperDiningHallMenu[] menusUpper = new UpperDiningHallMenu[10];
	private LowerDiningHallMenu[] menusLower = new LowerDiningHallMenu[10];
	
	
	
	public Controller() {
		
		for (int i = 0; i < menusUpper.length; i = i + 1) {
			menusUpper[i] = new UpperDiningHallMenu("Entree"+i, "Side"+i,"Salad Bar"+i,"Dessert"+i);
		}
		
		for (int i = 0; i < menusLower.length; i = i +1) {
			menusLower[i] = new LowerDiningHallMenu("Entree"+i, "Side"+i, "Special Snacks"+i,"Pizza"+i);
		}
		
		
		home = new Home(this);
		login = new Login(this);
		aHome = new AdminHome(this);
		sum = new StudentUDHMenu(this);
		lum = new StudentLDHMenu(this);
		adminUDHMenu = new AdminUpperDiningHallMenu(this);
		adminLDHMenu = new AdminLowerDiningHallMenu(this);
		
		
	}
	/**
	 * Accessor method that gets the upper DiningHallMenu array
	 * 
	 * @return
	 */
	public UpperDiningHallMenu[] getMenus() { return menusUpper; }
	public LowerDiningHallMenu[] getMenusL() { return menusLower; }
	
	public void activate(int n) {
		login.setVisible(false);
		aHome.setVisible(false);
		home.setVisible(false);
		sum.setVisible(false);
		
		if (n == 0) {
			home.setVisible(true);
		}
		if (n == 1) {
			login.setVisible(true);
		}
		if (n == 2) {
			aHome.setVisible(true);
		}
		if (n == 3) {
			sum.update();
			
			sum.setVisible(true);
		}
		if (n == 4){
			lum.updatelower();
			
			lum.setVisible(true);
		}
		if (n == 5) {
			adminUDHMenu.setVisible(true);
		}
		if (n == 6) {
			adminLDHMenu.setVisible(true);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Controller c = new Controller();
		
	}

}