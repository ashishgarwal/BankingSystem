package banking;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	
	private static Long acc = new Long(1);

	public Bank() {
		// complete the function
		accounts = new LinkedHashMap<Long, Account>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		acc = acc + 1;
		CommercialAccount account = new CommercialAccount(company, acc, pin, startingDeposit);
		accounts.put(acc, account);
        return acc;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		acc = acc + 1;
		ConsumerAccount account = new ConsumerAccount(person, acc, pin, startingDeposit);
		accounts.put(acc, account);
        return acc;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
        return this.getAccount(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		Account account  = this.getAccount(accountNumber);
		account.creditAccount(amount);
		
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		Account account  = this.getAccount(accountNumber);
		if(account.getBalance()<amount) {
			return false;
		}
	     
		account.debitAccount(amount);
        return true;
	}
}
