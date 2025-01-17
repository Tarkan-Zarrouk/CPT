import utils.Methods;

/**
 * author: Tarkan Zarrouk
 * date: 2025/01/17
 * Chequing Account Class Implementation
 */

/**
 * A class representing a chequing account with a balance and account number.
 */
public class ChequingAccount extends Account {
    /**
     * Current balance of the Chequing Account
     */
    private double balance;
    /**
     * Account number for the Chequing Account
     */
    private String accountNumber;
    /**
     * LinkedList of transaction history for the account it's under
     */
    private TransactionHistory transaction;

    public ChequingAccount(String accountName, String accountNumber, double balance) {
        super(accountName, accountNumber);
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transaction = new TransactionHistory();
    }    
    public ChequingAccount(String accountName, String accountNumber) {
        super(accountName, accountNumber);
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transaction = new TransactionHistory();
    }
    /**
     * Generates a Chequing account file
     * @param accountName - Name of the person who owns the account
     * @param accountNumber - Account number associated with the account
     * @param balance - Current balance of the chequing account
     * @return Text file containing the information pertaining to the Chequing Accounbt + a return message.
     */
    public static String createChequingAccount(String accountName, String accountNumber, double balance) {
        if (!Methods.fileExists(accountName, "Chequing")) {
            Methods.createFile(accountName, "Chequing");
        }
        ChequingAccount account = new ChequingAccount(accountName, accountNumber, balance);
        Methods.writeToFile(accountName, "Chequing", account.toString());
        Account.addAccountTypes("Chequing");
        return "Successfully created or updated " + accountName;
    }
    
    /**
     * Obtains balance of account
     * @return balance
     */
    public double getBalance() {
        return this.balance;
    }
    
    /**
     * Obtains account number
     * @return accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Set the account number to a specific value 
     * @param accountNumber - Sets the account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    /**
     * 
     * @return List of the transactions in the Chequing Account 
     */
    public TransactionHistory getTransactionHistory() {
        return transaction;
    }
    
    /**
     * Deposit money into the Chequing Account
     * @param accountName - Owner of the account
     * @param amount - Added balance to the account
     */
    public void deposit(String accountName, double amount) {
        if (amount > 0) {
            balance += amount;
            transaction.addTransaction("Deposited: " + amount + " to Chequing Account.");
            Methods.writeToFile(accountName, "Chequing", this.toString());
        }
    }
    
    /**
     * Withdraw money from the Chequing Account
     * @param accountName - Owner of the account
     * @param amount - Amount to remove from existing balance
     */
    public void withdraw(String accountName, double amount) {
        if (amount > 0) {   
            // remove the amount from the balance
            balance -= amount;
            // rewrite file to contain updated information
            transaction.addTransaction("Withdrew: " + amount + " to Chequing Account.");
            Methods.writeToFile(accountName, "Chequing", this.toString());
        }
    }


    /**
     * @return Converts the general account info to a stringable output
     */
    @Override
    public String toString() {
        return "Account Name: Chequing Account" 
        + "\n" + 
        "Account Number: " 
        + getAccountNumber() + 
        "\n" + 
        "Balance: " + 
        getBalance() + 
        "\n" + 
        "Account Type: Chequing" + 
        "\n" + 
        (transaction != null ? transaction.toString() : "No transactions");
    }
}
