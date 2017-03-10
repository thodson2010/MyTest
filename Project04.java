/*
 * Project 04 - Inventory Management System
 * I also implemented a customer class for extra credit
 * @author Tim Hodson
 * @version 031017
 * 
 * /home/tim/workspace/Project04/src/ProductList
 */
import java.util.*;
import java.io.*;

public class Project04{
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a database filename: ");
		String fileName = keyboard.nextLine();
		keyboard.close();
		Customer myCust = new Customer();
		System.out.println();
		openFile(fileName, myCust);
	}
	
	public static void openFile(String fileName, Customer myCust){
		Queue<SimpleProduct> myQueue = new LinkedList<SimpleProduct>();
		Stack<SimpleProduct> myStack = new Stack<SimpleProduct>();
		try{
			File inputFile = new File(fileName);
			Scanner readFile = new Scanner(inputFile);
			myCust.setLastName(readFile.nextLine());
			myCust.setFirstName(readFile.nextLine());
			myCust.setAddress(readFile.nextLine());
			myCust.setCity(readFile.nextLine());
			myCust.setState(readFile.nextLine());
			myCust.setZip(readFile.nextLine());
			myCust.setTax(Double.parseDouble(readFile.nextLine()));
			while(readFile.hasNext()){
				SimpleProduct myProduct = new SimpleProduct();
				myProduct.setName(readFile.nextLine());
				myProduct.setType(readFile.nextLine());
				myProduct.setPrice(Double.parseDouble(readFile.nextLine()));
				myProduct.setQuantity(Integer.parseInt(readFile.nextLine()));
				myProduct.setInStock(Boolean.parseBoolean(readFile.nextLine()));
				if(myProduct.getInStock() == true){
					myQueue.add(myProduct);
				}
				else{
					myStack.add(myProduct);
				}
			}
			readFile.close();
		}
		catch(IOException e){
			System.out.print("There was an error reading from file");
		}
		printOrder(myQueue, myStack, myCust);
	}
	
	public static void printOrder(Queue<SimpleProduct> myQueue, Stack<SimpleProduct> myStack, Customer myCust){
		Queue<SimpleProduct> cQueue = new LinkedList<SimpleProduct>(); //used to transfer items to new queue or stack as we print them.
		Stack<SimpleProduct> cStack = new Stack<SimpleProduct>(); //same as above
		double[] shipped = new double[4];
		System.out.println("Shipping To: ");		
		printCustomer(myCust);
		Iterator<SimpleProduct> iter = myQueue.iterator();
		while(iter.hasNext()){
			SimpleProduct myProd = myQueue.remove();
			System.out.printf(" " + "%d %s %-30s \t %s %s %s \t %6.2f \n",myProd.getQuantity(), "x", myProd.getName(),"(", myProd.getType(),")",(myProd.getPrice())*myProd.getQuantity());
			cQueue.add(myProd);	
		}
		shipped = calcQueue(cQueue, myCust);
		printMiniDash();
		System.out.printf("%s \t\t\t\t\t\t %6.2f  \n"," Subtotal: ", shipped[0]);
		System.out.printf("%s %.2f %s \t\t\t\t\t %6.2f \n"," Sales Tax: (", myCust.getTax(), ")",shipped[1]);
		System.out.printf("%s \t\t\t\t\t\t %6.2f \n"," Shipping: ",shipped[2]);
		printMiniDash();
		System.out.printf("%s \t\t\t\t\t\t %6.2f \n"," Total: ", shipped[3]);
		printDash();
		System.out.println();
		System.out.println("Orders Outstanding For: ");
		printCustomer(myCust);
		Iterator<SimpleProduct> Stackiter = myStack.iterator();
		while(Stackiter.hasNext()){
			SimpleProduct myProd = myStack.pop();
			System.out.printf(" " + "%d %s %-35s %s %s %s \t %6.2f \n",myProd.getQuantity(), "x", myProd.getName(),"(", myProd.getType(),")",(myProd.getPrice()*myProd.getQuantity()));
			cStack.add(myProd);
		}
		printMiniDash();
		System.out.printf("%s \t\t\t\t\t %6.2f \n"," Outstanding Balance: ", calcStack(cStack));
		printDash();
	}

	public static void printCustomer(Customer myCust){ //Print's customer information
		System.out.printf("\t %s \n",myCust.getFirstName() + " " +myCust.getLastName());
		System.out.printf("\t %s \n",myCust.getAddress());
		System.out.printf("\t %s \n",myCust.getCity() + ", " + myCust.getState() + " " + myCust.getZip());
		printDash();
	}
	
	public static double[] calcQueue(Queue<SimpleProduct> myQueue, Customer myCust){
		double[] myTotals = new double[4];
		double subtotal = 0.0;
		double salesTax = 0.0;
		double shipping = 0;
		Iterator igor = myQueue.iterator();
		while(igor.hasNext()){
			SimpleProduct myProd = myQueue.remove();
			subtotal += (myProd.getPrice() * myProd.getQuantity());
		}
		salesTax = (subtotal*(myCust.getTax()));
		if(subtotal>=25){
			 //free shipping
		}
		else if(subtotal >= 10){
			shipping = subtotal*(0.05);
		}
		else{
			shipping = subtotal*(0.15);
		}
		myTotals[0] = subtotal;
		myTotals[1] = salesTax;
		myTotals[2] = shipping;
		myTotals[3] = (subtotal + salesTax + shipping);
		return myTotals;
	}

	public static double calcStack(Stack<SimpleProduct> myStack){
		double subtotal = 0;
		Iterator igot = myStack.iterator();
		while(igot.hasNext()){
			SimpleProduct myProd = myStack.pop();
			subtotal += (myProd.getPrice() * myProd.getQuantity());
		}
		return subtotal;
	}
	
	public static void printDash(){
		System.out.println("-------------------------------------------------------------------------------");
	}
	public static void printMiniDash(){
		System.out.println(" ---------------------------------------------------------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
