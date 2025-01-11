/**
 * author: Tarkan Zarrouk
 * date: (due date)
 * Management class for Bank Account
 */

/**
 * Bank account allowing you to perform actions such as Creating an account, deleting an account, adding money... etc
 */
public class Account {
    private String accountNumber;
    private String accountName;
    private double balance;
    // total constructor 
    public Account(String accountName, String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }
    // partial constructor
    public Account(String accountName, String accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }
    // File creation object... (W3 Schools - https://www.w3schools.com/java/java_files_create.asp);
    public static String createAccount(String directoryName, String accountName, String accountNumber, double balance) {
        String accountContents = accountName + "\n" + accountNumber + "\n" + Double.toString(balance) + "\n";
        Methods.createFile(accountName,directoryName);
        Methods.writeToFile(accountName, directoryName, accountContents);
        return "Successfully created " + accountName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountName() {
        return accountName;
    }
    public double getBalance() {
        return balance;
    }
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\n" + "Account Name: " + accountName + "\n" + "Balance: " + balance + "\n";
    }
}
