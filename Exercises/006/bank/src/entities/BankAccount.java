package entities;

public class BankAccount {

	private Integer accountNumber;
	private String name;
	private Double balance;

	public BankAccount() {
		super();
	}

	public BankAccount(int accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = (double) 0;
	}

	public BankAccount(int accountNumber, String name, Double balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public void deposit(double value) {
		balance += value;
	}

	public void withdraw(double value) {
		if (value > 0) {
			balance -= value + 5;
		}
	}

	@Override
	public String toString() {
		return "\n\tAccount Data\n" + "Account:  " + accountNumber + "   /   Holder: " + name
				+ String.format("\nBalance:  $%.2f\n", balance);
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

}
