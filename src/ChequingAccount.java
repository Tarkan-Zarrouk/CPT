import utils.Methods;

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

    public ChequingAccount(String accountName, String accountNumber, double initialBalance) {
        super(accountName, accountNumber, initialBalance);
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public ChequingAccount(String accountNumber) {
        super(accountNumber, accountNumber);
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }
    
    /**
     * Generates a Chequing account file
     * @param accountName - Name of the person who owns the account
     * @param accountNumber - Account number associated with the account
     * @param balance - Current balance of the chequing account
     * @return Text file containing the information pertaining to the Chequing Accounbt + a return message.
     */
    public static String createChequingAccount(String accountName, String accountNumber, double balance) {
        ChequingAccount chequingAccount = new ChequingAccount(accountName,accountNumber, balance);
        if (!Methods.fileExists(accountName, "Chequing")) {
            Methods.createFile(accountName, "Chequing");
        }
        Methods.writeToFile(accountName, "Chequing", chequingAccount.toString());
        Account.addAccountTypes("Chequing");
        return "Successfully created or updated " + accountName;
    }
    
    /**
     * Obtains balance of account
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Obtains account number
     * @return accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Deposit money into the Chequing Account
     * @param accountName - Owner of the account
     * @param amount - Added balance to the account
     */
    public void deposit(String accountName, double amount) {
        if (amount > 0) {
            balance += amount;
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
            Methods.writeToFile(accountName, "Chequing", this.toString());
        }
    }

    /**
     * @return Converts the general account info to a stringable output
     */
    @Override
    public String toString() {
        return "Account Name: Chequing Account" + "\n" + "Account Number: " + accountNumber + "\n" + "Balance: " + balance + "\n" + "Account Type: Chequing";
    }
}
