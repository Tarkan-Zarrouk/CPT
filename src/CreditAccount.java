import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import utils.Methods;

/**
 * Author: Tarkan Zarrouk
 * Date: 2025/01/14
 * Credit Account management class for managing credit payments
 */

 /**
  * Credit Card account information section
  * Allows you to create and keep track of credit expenses
  */
public class CreditAccount extends Account {
    /**
     * Number associated with the account
     */
    private String accountNumber;
    /**
     * Owner of the Credit Account
     */
    private String accountName;
    /**
     * Maximum spending limit on the account itself
     */
    private double creditLimit;
    /**
     * The balance owed to the bank.
     */
    private double balance;
    /**
     * Interest points charged to credit card on a monthly basis
     */
    private double interestRate;
    /**
     * History of deposits and withdraws
     */
    private TransactionHistory transaction = new TransactionHistory();

    /**
     * Total constructor that sets the account name, account number, credit limit, balance and interest rate to the Credit Card Account
     * @param accountName
     * @param accountNumber
     * @param creditLimit
     * @param balance
     * @param interestRate
     */
    public CreditAccount(String accountName, String accountNumber, double creditLimit, double balance, double interestRate) {
        super(accountName);
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.interestRate = interestRate;
    }
    /**
     * Partial constructor that sets the account number, accountName, creditLimit, and balance to the Credit Card Account
     * @param accountNumber
     * @param accountName
     * @param creditLimit
     * @param balance
     */
    public CreditAccount(String accountNumber, String accountName, double creditLimit, double balance) {
        super(accountName, accountNumber);
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.creditLimit = creditLimit;
        this.balance = balance;
    }

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
    /**
     * Returns the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number for this credit account
     * @param accountNumber - The new account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Returns the account owner's name
     * @return accountName - The name of the person who owns this account
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the account holder's name for this credit account
     * @param accountName - The new account holder's name
     */
    public void setaccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Returns the maximum credit balance attainable in the account
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
     * Obtains the double value of the balance
     * @return The balance owed to the bank
     */
    public double getOwedBalance() {
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
     * Retrieves the transaction history for the credit account 
     * @return transaction object that contains the history of transactions associated with the account
     */
    public TransactionHistory getTransactionHistory() {
        return transaction;
    }

    /**
     * Applies monthly interest to the current balance.
     * @param interestRate - The monthly interest rate to be applied
     */
    public void applyMonthlyInterest(double interestRate) {
        if (interestRate > 0 && this.balance > 0) {
            this.balance += this.balance * (interestRate / 100);
            Methods.writeToFile(super.getAccountName(), "Credit", this.toString());
        }
    }
    /**
     * Checks the credit account file to determine the last update date and applies any pending monthly interest if necessary
     * The method ensures that the account is updated for every month that has passed since the last recorded update.
     * @return Monthly interest applied to the balance of the Credit Card Account
     */
    public void checkAndUpdateCreditAccount() {
        String accountName = getAccountName();
        String folderPath = "Credit/" + accountName + ".txt";
        File file = new File(folderPath);
        if(file.exists() && file.isFile()) {
            String content = Methods.readInFile(accountName, "Credit");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String[] parts = content.split("last updated: ");
            if (parts.length >= 2) {
                LocalDateTime lastUpdated = LocalDateTime.parse(parts[1].trim(), formatter);
                LocalDateTime currentTime = LocalDateTime.now();
                long monthsPassed = java.time.temporal.ChronoUnit.MONTHS.between(lastUpdated, currentTime);
                if (monthsPassed > 0) {
                    for (int i = 0; i < monthsPassed; i++) {
                        applyMonthlyInterest(interestRate);
                    }
                    Methods.writeToFile(accountName, "Credit", this.toString() + " last updated: " + currentTime.format(formatter));
                }
            }
        }   
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
                Methods.writeToFile(accountName, "Credit", this.toString());
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
                Methods.writeToFile(accountName, "Credit", this.toString());
            }
        }
    }
    /**
     * Converts the credit account details to a string representation.
     * @return String - String copy of the credit account information
     */
    @Override
    public String toString() {
        return "Account Name: " + accountNumber + 
               "\nAccount Number: " + accountName + 
               "\nCredit Limit: " + creditLimit + 
               "\nBalance: " + balance + 
               "\nTransactions: " + (transaction != null ? transaction.toString() : "No transactions") + 
               "\nAccount Types: " + super.getAccountTypes();
    }
    
}
