public class LowerDiningHallMenu {

	private String entre; 
	private String sides;
	private String specialsnacks;
	private String pizza;
	
	//Constructor method used to initialize objects in LowerDiningHallMenu class
	//Entree, sides, special snack, and pizza is are initiated as objects
	
	public LowerDiningHallMenu(String e1, String s1, String ss1, String p1) {
		entre = e1; 
		sides = s1; 
		specialsnacks = ss1; 
		pizza = p1; 
	}
	
	//Set and get methods since objects are encapsulated and can be accessed to similar classes
	//For example, the "getEntre()" allows the entree object to be accessed in other classes
	
	public String getEntre() {
		return this.entre;
	}
	
	public String getSides() {
		return this.sides;
	}
	
	public String getSpecialSnacks() {
		return this.specialsnacks;
	}
	
	public String getPizza() {
		return this.pizza;
	}
	
	//Set methods retrieve and store variables accordingly when accessed between classes
	//Set methods use the "void" modifiers since nothing is returned or there is no output
	//Instead the variable is stored as a memory reference
	
	public void setEntre(String e1) {entre = e1;}
	public void setSides(String s1) {sides = s1;}
	public void setSpecialSnacks(String ss1) {specialsnacks = ss1;}
	public void setPizza(String p1) {pizza = p1;}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



