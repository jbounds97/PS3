import java.io.*;
/*
 * Custom class for throwing an insufficient funds exception
 * John Bounds
 */
public class InsufficientFundsException extends Exception {
	private double amount;
	
	public InsufficientFundsException(double amount){
		this.amount = amount;
		System.out.print("Error - withdraw amount greater than account balance");
	}
	public double getAmount(){
		return amount;
	}
}
