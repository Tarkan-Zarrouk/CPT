package main;
import java.util.Stack;

/**
 * author: Tarkan Zarrouk
 * date: 2025/01/17
 * TransactionHistory class in charge of managing transactions for any type of account that exists
 */


/**
 * Can allow you to track Transactions made within the account (eg: withdraw, deposit)
 */
public class TransactionHistory {
    /**
     * A stack that stores the transaction history
     */
    private Stack<String> transactions;

    public TransactionHistory() {
        this.transactions = new Stack<>();
    }

    /**
     * Adds a transaction to the history.
     * @param transaction The transaction description to add.
     */
    public void addTransaction(String transaction) {
        transactions.push(transaction);
    }

    /**
     * Removes the most recent transaction from the history.
     * @return The most recent transaction.
     */
    public String removeMostRecentTransaction() {
        if (!transactions.isEmpty()) {
            return transactions.pop();
        }
        return "No transactions to remove.";
    }

    /**
     * Gets the most recent transaction without removing it.
     * @return The most recent transaction.
     */
    public String getMostRecentTransaction() {
        if (!transactions.isEmpty()) {
            return transactions.peek();
        }
        return "No transactions available.";
    }

    /**
     * Returns all transactions as a string.
     * @return A string representation of all transactions.
     */
    @Override
    public String toString() {
        if (transactions.isEmpty()) {
            return "No transactions available.";
        }

        String result = "Transactions (Most Recent First):\n";
        for (String transaction : transactions) {
            result += transaction + "\n";
        }
        return result;
    }
}
