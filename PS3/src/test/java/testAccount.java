import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;

public class testAccount {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
	}
	static Account account1 = new Account(1122, 20000, .045);
	
	@Test
	public void testId() {
		System.out.println("Test getId()");
		int bExpectedResult = 1122;
		int bActualResult = account1.getId();
		assertEquals("test getId() failed", bExpectedResult, bActualResult);
	}
	
	@Test
	public void testBalance(){
		System.out.println("Test getBalance()");
		double bExpectedResult = 20000;
		double bActualResult = account1.getBalance();
		assertEquals("test getBalance() failed", bExpectedResult, bActualResult,.0001);
	}
	
	@Test
	public void testAnnualInterestRate(){
		System.out.println("Test getAnnualInterestRate()");
		double bExpectedResult = .045;
		double bActualResult = account1.getAnnualInterestRate();
		assertEquals("test getAnnualInterestRate() failed", bExpectedResult, bActualResult,.000001);
	}
	
	@Test
	public void testWithdrawNoError(){
		System.out.println("Test withdraw()");
		double bExpectedResult = 17500;
		try {
			account1.withdraw(2500);
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot withdraw " +e.getAmount() + " from account. Funcs Insufficient.");
		}
		double bActualResult = account1.getBalance();
		assertEquals("test withdraw() failed", bExpectedResult, bActualResult,.000001);
	}
	
	@Test
	public void testWithdrawError(){
		System.out.println("Test withdraw()");
		//
		boolean bExpectedResult = true;
		boolean bActualResult = false;
		
		try {
			account1.withdraw(21000);
		} catch (InsufficientFundsException e) {
			// TODO: handle exception
			bActualResult= true;
			System.out.println("Cannot withdraw " +e.getAmount() + " from account. Funcs Insufficient.");
		}
		assertEquals("test withdraw() failed", bExpectedResult, bActualResult);
	}
	
	@Test
	public void testDeposit(){
		System.out.println("Test deposit()");
		double bExpectedResult = 23000;
		account1.deposit(3000);
		double bActualResult = account1.getBalance();
		assertEquals("test deposit() failed", bExpectedResult, bActualResult,.00001);
	}
	
	@Test
	public void printStuff(){
		System.out.println("Account balance: " + account1.getBalance());
		System.out.println("Account monthly interest: " + account1.getMonthlyInterestRate());
		System.out.println("Account date created: " + account1.getDateCreated());
	}
}
