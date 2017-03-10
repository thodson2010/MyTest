/*
 * Customer class to access customer data
 * @author Tim Hodson
 */
public class Customer {
	private String lastName = "";
	private String firstName = "";
	private String address = "";
	private String city = "";
	private String state = "";
	private String zip = "";
	private double tax = 0.0;
	
	public Customer() {
	}

	public void setLastName(String lastName){ //sets customer last name
		this.lastName = lastName;
	}
	public String getLastName(){ //gets customer last name
		return this.lastName;
	}	
	
	public void setFirstName(String firstName){ //sets customer first name
		this.firstName = firstName;
	}
	public String getFirstName(){ //gets customer first name
		return this.firstName;
	}
	
	public void setAddress(String address){ //sets customer address
		this.address = address;
	}
	public String getAddress(){ //gets customer address
		return this.address;
	}
	
	public void setCity(String city){ //sets customer city
		this.city = city;
	}
	public String getCity(){ //gets customer city
		return this.city;
	}
	
	public void setState(String state){ //sets customer state
		this.state = state;
	}
	public String getState(){ //gets customer state
		return this.state;
	}
	
	public void setZip(String zip){ //sets customer zip code
		this.zip = zip;
	}
	public String getZip(){ //gets customer zipcode
		return this.zip;
	}
	
	public void setTax(double tax){ //set customer tax rate
		this.tax = tax;
	}
	public double getTax(){ //gets customer tax
		return this.tax;
	}
	
	
}
