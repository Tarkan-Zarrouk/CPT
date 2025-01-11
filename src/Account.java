/**
 * author: Tarkan Zarrouk
 * date: (due date)
 * Management class for Bank Account
 */

import java.util.ArrayList;

/**
 * Bank account allowing you to perform actions such as Creating an account, deleting an account, adding money... etc
 */
public class Account {
    private String accountNumber;
    private String accountName;
    private double balance;
    private ArrayList<String> accountTypes = new ArrayList<>();
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
    public String createAccount(String directoryName, String accountName, String accountNumber, double balance) {
        Account account = new Account(accountName, accountNumber, balance);
        if (!Methods.fileExists(accountName, directoryName)) {
            Methods.createFile(accountName, directoryName);
        }
        Methods.writeToFile(accountName, directoryName, account.toString());
        return "Successfully created or updated " + accountName;
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
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String addAccountTypes(String accountType) {
        accountTypes.add(accountType);
        return "Successfully added " + accountType + " to the list of account types.";
    }
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\n" + "Account Name: " + accountName + "\n" + "Balance: " + balance + "\n";
    }
}
