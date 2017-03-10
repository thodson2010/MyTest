import java.util.Scanner;

/**
 * Product
 * 
 *   A simple class framework used to demonstrate the design
 *   of Java classes.
 *   
 *   @author Tim Hodson
 *   @version 031017
 */

public class SimpleProduct implements Productinterface {
	private String name = "";
	private String type = "";
	private double price = 0.00;
	private int quantity = 0;
	private boolean inStock = true;
	
	public SimpleProduct() { 
		
	}
	
	public Boolean equals(SimpleProduct myProd){
		if(myProd.getName() == this.name){
			if(myProd.getType() == this.type){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return "(" + this.name + ", " + this.type + ", " + this.price + ", " + this.quantity + ")" ;
	}
	//toString method
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return this.price;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return this.quantity;
	}
	
	public void setInStock(boolean inStock){
		this.inStock = inStock;
	}
	
	public boolean getInStock(){
		return this.inStock;
	}
	public boolean readNextProduct(Scanner inFile){
		if (inFile.hasNext()){
			return true;
		}
		else{
			return false;
		}
	}

}
