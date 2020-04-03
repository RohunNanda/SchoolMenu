public class UpperDiningHallMenu {

	private String entre;
	private String sides;
	private String saladbar;
	private String desert;
	
	public UpperDiningHallMenu(String e, String s, String sb, String d) {
		entre = e;
		sides = s;
		saladbar = sb;
		desert = d;
	}
	/**
	 * Since fields are encapsulated, must use get/accessor method to access them
	 * @return
	 */
	public String getEntre() {
		return this.entre;
	}
	
	public String getSides() {
		return this.sides;
	}
	
	public String getSaladbar() {
		return this.saladbar;
	}
	
	public String getDesert() {
		return this.desert;
	}
	
	public void setEntre(String e) { entre = e;}
	public void setSides(String s) { sides = s; }
	public void setSaladBar(String sb) { saladbar = sb; }
	public void setDesert(String d) { desert = d; }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}