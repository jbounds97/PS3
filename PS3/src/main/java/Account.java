import java.util.Date;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	private void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	private void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public Account(){
		setId(0);
		setBalance(0);
		setAnnualInterestRate(0);
	}
	
	public Account(int id, double balance, double annualInterestRate){
		setId(id);
		setBalance(balance);
		setAnnualInterestRate(annualInterestRate);
	}
	
	public double getMonthlyInterestRate(){
		double monthlyInterestRate = getAnnualInterestRate() / 12;
		return monthlyInterestRate;
	}
	public void withdraw(double amount) throws InsufficientFundsException{
			double new_amount = getBalance() - amount;
			
			if(new_amount < 0){
				throw new InsufficientFundsException(amount);
			}
			else
				setBalance(new_amount);
		
	}
	public void deposit(double amount){
		double new_amount = amount + getBalance();
		setBalance(new_amount);
	}

}
