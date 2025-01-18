package main;
import java.util.ArrayList;

/**
 * author: Tarkan Zarrouk
 * date: 2025/01/19
 * Management class for Bank Account
 */

/**
 * Parent class allowing you to perform actions such as Creating an account, deleting an account, adding money... etc
 */
public class Account {
    /**
     * The account number associated with this account.
     */
    private String accountNumber;
    /**
     * The name of the person who owns this account
     */
    private String accountName;
    /**
     * The balance of the of the actual account
     */
    private double balance;
    /**
     * All of the possible types of accounts that exist within the account 
     */
    private static ArrayList<String> accountTypes = new ArrayList<>();
    
    /**
     * Sets the instances of the accountName, accountNumber, and balance of the Base Account
     * @param accountName Name of the account
     * @param accountNumber Number of the account
     * @param balance Balance of the account
     * */
    public Account(String accountName, String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }
    
    /**
     * Partial constructor that sets the instances of accountName, and accountNumber
     * @param accountName Name of the account
     * @param accountNumber Number of the account
     */
    public Account(String accountName, String accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }
    /**
     * Partial constructor that sets the instances of the accountName
     * @param accountNumber Number associated with the account
     */
    public Account(String accountName) {
        this.accountName = accountName;
    }
    
    /**
     * Given the directory name, account name, account number, and balance, we can create an account
     * @param directoryName Name of the directory
     * @param accountName Name of the account
     * @param accountNumber Number of the account
     * @param balance Balance of the account
     * @return Created Account with message of succession of account name
     */
    public String createAccount(String directoryName, String accountNumber, double balance) {
        Account account = new Account(accountName, accountNumber, balance);
        if (!Methods.fileExists(accountName, directoryName)) {
            Methods.createFile(accountName, directoryName);
        }
        Methods.writeToFile(accountName, directoryName, account.toString());
        return "Successfully created or updated " + accountName;
    }
    
    /**
     * Given the directory name and account name, we can delete the account
     * @param directoryName Name of the directory
     * @param accountName Name of the account
     * @return accountNumber Number of the account
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Get the account number
     * @return Owner of the actual account
     */
    public String getAccountName() {
        return accountName;
    }
    /**
     * Clears the Account Types ArrayList
     * @return Empty Account Types
     */
    public static void resetAccountTypes() {
        accountTypes.clear();
    }
    /**
     * Get the account name
     * @return Balance of the account
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Set the account number
     * @param accountNumber Number of the account
     * Sets the Account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    /**
     * Set the balance
     * @param balance Balance of the account
     * Sets the balance of the account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /**
     * Set the account name
     * @param accountName Name of the account
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    /**
     * Adds the account type to the account
     * @param accountType Type of account
     */
    public static void addAccountTypes(String accountType) {
        accountTypes.add(accountType);
        Methods.createFile("TypeOfAccounts", "Account Types");
        Methods.writeToFile("TypeOfAccounts", "Account Types", accountTypes.toString());
    }
    
    /**
     * Obtains the contents of the text file that contains all the types of existing accounts that has been created before.
     * @return Text file containing the types of accounts created (Savings, Chequing... etc)
     */
    public static String getAccountTypes() {
        return Methods.readInFile("TypeOfAccounts", "Account Types");
    }
    /**
     * Converts all private instances into string
     * @return Converts the general account info to a stringable output
     */
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\n" + "Account Name: " + accountName + "\n" + "Balance: " + balance + "\n" + "Account Types: " + accountTypes;
    }
}
