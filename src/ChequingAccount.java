/**
 * author: Tarkan Zarrouk
 * date: (due date)
 * Management class for Chequing Account
 */

/**
 * A class representing a chequing account with a balance and account number.
 */
public class ChequingAccount extends Account {
    private double balance;
    private String accountNumber;
    // total constructor
    public ChequingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, accountNumber, initialBalance);
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    // partial constructor
    public ChequingAccount(String accountNumber) {
        super(accountNumber, accountNumber);
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public static String createChequingAccount(String accountName, String accountNumber, double balance) {
        ChequingAccount chequingAccount = new ChequingAccount(accountNumber, balance);
        if (!Methods.fileExists(accountName, "Chequing")) {
            Methods.createFile(accountName, "Chequing");
        }
        Methods.writeToFile(accountName, "Chequing", chequingAccount.toString());
        Account.addAccountTypes("Chequing");
        return "Successfully created or updated " + accountName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Account Name: Chequing Account\nAccount Number: " + accountNumber + "\nBalance: " + balance + "\n" + "Account Type: Chequing";
    }
}
