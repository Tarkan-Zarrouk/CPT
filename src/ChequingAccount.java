/**
 * author: Tarkan Zarrouk
* date: 2025/01/17
 * Management class for Chequing Account
 */

/**
 * A class representing a chequing account with a balance and account number.
 */
public class ChequingAccount extends Account {
    private double balance;
    private String accountNumber;
    // total constructor
    public ChequingAccount(String accountName, String accountNumber, double initialBalance) {
        super(accountName, accountNumber, initialBalance);
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
        ChequingAccount chequingAccount = new ChequingAccount(accountName,accountNumber, balance);
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

    public void deposit(String accountName, double amount) {
        if (amount > 0) {
            // add amount to the current balance
            balance += amount;
            Methods.writeToFile(accountName, "Chequing", this.toString());
        }
    }
    public void withdraw(String accountName, double amount) {
        if (amount > 0) {   
            // add amount to the current balance
            balance -= amount;
            Methods.writeToFile(accountName, "Chequing", this.toString());
        }
    }

    @Override
    public String toString() {
        return "Account Name: Chequing Account" + "\n" + "Account Number: " + accountNumber + "\n" + "Balance: " + balance + "\n" + "Account Type: Chequing";
    }
}
