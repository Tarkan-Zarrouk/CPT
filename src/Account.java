/**
 * author: Tarkan Zarrouk
* date: 2025/01/17
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

    private static ArrayList<String> accountTypes = new ArrayList<>();
    // total constructor 
    /**
     * @param accountName - name of the account
     * @param accountNumber - number of the account
     * @param balance - balance of the account
     * @return void
     * Constructor for the Account class
     * */
    public Account(String accountName, String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }
    /**
     * @param accountName - name of the account
     * @param accountNumber - number of the account
     * @return void
     * Constructor for the Account class
     */
    public Account(String accountName, String accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }
    // File creation object... (W3 Schools - https://www.w3schools.com/java/java_files_create.asp);
    /**
     * @param directoryName - name of the directory
     * @param accountName - name of the account
     * @param accountNumber - number of the account
     * @param balance - balance of the account
     * @return String
     * Given the directory name, account name, account number, and balance, we can create an account
     */
    public String createAccount(String directoryName, String accountName, String accountNumber, double balance) {
        Account account = new Account(accountName, accountNumber, balance);
        if (!Methods.fileExists(accountName, directoryName)) {
            Methods.createFile(accountName, directoryName);
        }
        Methods.writeToFile(accountName, directoryName, account.toString());
        return "Successfully created or updated " + accountName;
    }
    /**
     * @param directoryName - name of the directory
     * @param accountName - name of the account
     * @return String
     * Given the directory name and account name, we can delete the account
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    /**
     * Get the account number
     * @return String
     */
    public String getAccountName() {
        return accountName;
    }
    /**
     * Get the account name
     * @return String
     */
    public double getBalance() {
        return balance;
    }
    /**
     * Set the balance
     * @param accountNumber - number of the account
     * @return void
     * Sets the account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    /**
     * Set the balance
     * @param balance - balance of the account
     * @return void
     * Sets the balance of the account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    /**
     * Set the account name
     * @param accountName - name of the account
     * @return void
     * Sets the account name
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    /**
     * @param accountType - type of account
     * @return void
     * Adds the account type to the account
     */
    public static void addAccountTypes(String accountType) {
        accountTypes.add(accountType);
        Methods.createFile("TypeOfAccounts", "Account Types");
        Methods.writeToFile("TypeOfAccounts", "Account Types", accountTypes.toString());
    }
    public String getAccountTypes() {
        return Methods.readInFile("TypeOfAccounts", "Account Types");
    }
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\n" + "Account Name: " + accountName + "\n" + "Balance: " + balance + "\n" + "Account Types: " + getAccountTypes();
    }
}
