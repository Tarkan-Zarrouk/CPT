/**
 * Author: Tarkan Zarrouk
 * Date: 2025/01/14
 * Credit Account management class for managing credit payments
 */
public class CreditAccount extends Account {
    /**
     * accountNumber - Number associated with the account
     */
    private String accountNumber;
    /**
     * accountName - Owner of the Credit Account
     */
    private String accountName;
    /**
     * creditLimit - Maximum spending limit on the account itself
     */
    private double creditLimit;
    /**
     * balance - The balance owed to the bank.
     */
    private double balance;

    /**
     * Credit Account Object, pertains to the holder of this account
     * @param accountNumber - Account Number
     * @param accountName - Name of the person who owns this account
     * @param creditLimit - Credit Limit (Maximum limit pertaining to the current account)
     * @param balance - Balance left on the account
     */
    public CreditAccount(String accountName, String accountNumber, double creditLimit, double balance) {
        super(accountName, accountNumber);
        this.creditLimit = creditLimit;
        this.balance = balance;
    }
    /**
     * Credit Account Object, pertains to the holder of this account (Balance of 0 this time)
     * @param accountNumber - Account Number
     * @param accountName - Name of the person who owns this account
     * @param creditLimit - Credit Limit (Maximum limit pertaining to the current account)
     */
    public CreditAccount(String accountNumber, String accountName, double creditLimit) {
        super(accountName, accountNumber);
        this.creditLimit = creditLimit;
        this.balance = 0.0;
    }
    // Removed redundant constructors
    /**
     * Generates a Credit account file
     * @param accountName - Name of the person who owns the account
     * @param accountNumber - Account number associated with the account
     * @param creditLimit - Maximum spending limit on the account
     * @param balance - Current balance of the credit account
     * @return Text file containing the information pertaining to the Credit Account + a return message.
     */
    public String createCreditAccountFile(String accountName, String accountNumber, double creditLimit, double balance) {
        CreditAccount creditAccount = new CreditAccount(accountName, accountNumber, creditLimit, balance);
        if (!Methods.fileExists(accountName, "Credit")) {
            Methods.createFile(accountName, "Credit");
        }
        Methods.writeToFile(accountName, "Credit", creditAccount.toString());
        Account.addAccountTypes("Credit");
        return "Successfully created or updated " + accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number for this credit account.
     * @param accountNumber - The new account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return accountName - The name of the person who owns this account
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the account holder's name for this credit account.
     * @param accountName - The new account holder's name
     */
    public void setaccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * @return creditLimit - The maximum spending limit on the account
     */
    public double getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the credit limit for this credit account.
     * @param creditLimit - The new credit limit
     */
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * @return balance - The balance owed to the bank
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the current balance for this credit account.
     * @param balance - The new current balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Makes a payment to reduce the current balance.
     * @param amount - The amount to be paid
     */
    public void makePayment(double amount) {
        if (amount > 0) {
            if ((this.balance - amount) < 0) {
                System.out.println("Error: Payment amount exceeds current balance.");
            } else {
                this.balance -= amount;
                Methods.writeToFile(super.getAccountName(), "Credit", this.toString());
            }
        }
    }

    /**
     * Charges an amount to the credit account, increasing the current balance.
     * @param amount - The amount to be charged
     */
    public void charge(double amount) {
        if (amount > 0) {
            if ((this.balance + amount) > this.creditLimit) {
                System.out.println("Error: Charge amount exceeds credit limit.");
            } else {
                this.balance += amount;
                Methods.writeToFile(super.getAccountName(), "Credit", this.toString());
            }
        }
    }
    /**
     * Converts the credit account details to a string representation.
     * @return - String copy of the credit account information
     */
    @Override
    public String toString() {
        return "Account Name: " + super.getAccountName() + "\n" + "Account Number: " + super.getAccountNumber() + "\n" + "Balance: " + balance + "\n" + "Credit Limit: " + creditLimit +  "\n" + "Account Types: " + super.getAccountTypes();
    }
}
