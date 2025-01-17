import java.util.ArrayList;
import utils.Methods;

/**
 * author: Tarkan Zarrouk
 * date: 2025/01/17
 * Management class for Bank Account
 */

/**
 * Parent class allowing you to perform actions such as Creating an account, deleting an account, adding money... et
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
     * Constructor for the Account class
     * @param accountName - name of the account
     * @param accountNumber - number of the account
     * @param balance - balance of the account
     * */
    public Account(String accountName, String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }
    
    /**
     * Constructor for the Account class
     * @param accountName - name of the account
     * @param accountNumber - number of the account
     */
    public Account(String accountName, String accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }
    /**
     * Partial constructor for the account class
     * @param accountNumber
     */
    public Account(String accountName) {
        this.accountName = accountName;
    }
    
    /**
     * @param directoryName - name of the directory
     * @param accountName - name of the account
     * @param accountNumber - number of the account
     * @param balance - balance of the account
     * @return String
     * Given the directory name, account name, account number, and balance, we can create an account
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
     * @return owner of the actual account
     */
    public String getAccountName() {
        return accountName;
    }
    
    /**
     * Get the account name
     * @return Balance of the account
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Set the balance
     * @param accountNumber - number of the account
     * Sets the account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    /**
     * Set the balance
     * @param balance - balance of the account
     * Sets the balance of the account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /**
     * Set the account name
     * @param accountName - name of the account
     * Sets the account name
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    /**
     * Adds the account type to the account
     * @param accountType - type of account
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
     * @return Converts the general account info to a stringable output
     */
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\n" + "Account Name: " + accountName + "\n" + "Balance: " + balance + "\n" + "Account Types: " + getAccountTypes();
    }
}
