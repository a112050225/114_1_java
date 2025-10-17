// Account.java

public class Account {

    public void setAccountNumber(String accountNumber)
    {this.accountNumber = accountNumber;}
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("存款金額必須大於0");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("餘額不足");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("提款金額必須大於0");
        }
        balance -= amount;
    }
}
