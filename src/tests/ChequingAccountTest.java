package tests;

import main.ChequingAccount;
import main.TransactionHistory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
/**
 * author: Tarkan Zarrouk
 * date: 2025/01/19
 * Unit testing
 */


 /**
  * Unit tests for the Chequing Account class
  */
public class ChequingAccountTest {
    @Test
    void testCreateChequingAccount_1() {
        // Arrange
        ChequingAccount account = new ChequingAccount("John Doe", "123456", 1000.0);
        String expectedAccountNumber = "123456";
        double expectedBalance = 1000.0;

        // Act
        String actualAccountNumber = account.getAccountNumber();
        double actualBalance = account.getBalance();

        // Assert
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    void testCreateChequingAccount_2() {
        // Arrange
        ChequingAccount account = new ChequingAccount("Jane Doe", "654321", 500.0);
        String expectedAccountNumber = "654321";
        double expectedBalance = 500.0;

        // Act
        String actualAccountNumber = account.getAccountNumber();
        double actualBalance = account.getBalance();

        // Assert
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    void testCreateChequingAccount_3() {
        // Arrange
        ChequingAccount account = new ChequingAccount("Sam Smith", "987654", 0.0);
        String expectedAccountNumber = "987654";
        double expectedBalance = 0.0;

        // Act
        String actualAccountNumber = account.getAccountNumber();
        double actualBalance = account.getBalance();

        // Assert
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    /**
     * Tests account number to make sure it matches the expected value
     * @result The correct account number is returned
     */
    @Test
    void testGetAccountNumber_1() {
        // Arrange
        ChequingAccount account = new ChequingAccount("Alice", "789101");
        String expectedAccountNumber = "789101";

        // Act
        String actualAccountNumber = account.getAccountNumber();

        // Assert
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    @Test
    void testGetAccountNumber_2() {
        // Arrange
        ChequingAccount account = new ChequingAccount("Bob", "112233");
        String expectedAccountNumber = "112233";

        // Act
        String actualAccountNumber = account.getAccountNumber();

        // Assert
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    /**
     * Tests account balance to make sure it matches the expected value
     * @result The correct account balance is returned
     */
    @Test
    void testGetBalance_1() {
        // Arrange
        double expectedBalance = 500.0;
        ChequingAccount account = new ChequingAccount("Bob", "112233", expectedBalance);

        // Act
        double actualBalance = account.getBalance();

        // Assert
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    /**
     * Tests the transaction history to make sure it includes all deposits and withdrawals in the correct order
     * @result The transaction history contains all transactions in reverse chronological order
     */
    @Test
    void testGetTransactionHistory_1() {
        // Arrange
        ChequingAccount account = new ChequingAccount("Charlie", "445566", 1000.0);
        account.deposit("Charlie", 200.0);
        account.withdraw("Charlie", 150.0);
        String expectedTransactionHistory = "Transactions (Most Recent First):" 
                                            + "\n" 
                                            + "Deposited: 200.0 to Chequing Account."
                                            + "\n"
                                            + "Withdrew: 150.0 to Chequing Account."
                                            + "\n";

        // Act
        TransactionHistory actualTransactionHistory = account.getTransactionHistory();

        // Assert
        Assertions.assertEquals(expectedTransactionHistory, actualTransactionHistory.toString());
    }

    @Test
    void testGetTransactionHistory_2() {
        // Arrange
        ChequingAccount account = new ChequingAccount("Alice", "334455", 1000.0);
        account.deposit("Alice", 500.0);
        account.withdraw("Alice", 300.0);
        String expectedTransactionHistory = "Transactions (Most Recent First):" 
                                            + "\n" 
                                            + "Deposited: 500.0 to Chequing Account."
                                            + "\n"
                                            + "Withdrew: 300.0 to Chequing Account."
                                            + "\n";

        // Act
        TransactionHistory actualTransactionHistory = account.getTransactionHistory();

        // Assert
        Assertions.assertEquals(expectedTransactionHistory, actualTransactionHistory.toString());
    }


    /**
     * Tests the toString method to make sure it returns a correctly formatted string with all account details and transactions
     * @result The toString method returns a string containing account details and all transactions
     */
    @Test
    void testToString_1() {
        // Arrange
        ChequingAccount account = new ChequingAccount("Diana", "778899", 2500.0);
        account.deposit("Diana", 300.0);
        account.withdraw("Diana", 100.0);
        String expectedOutput = "Account Name: Chequing Account" 
                                + "\n" 
                                + "Account Number: 778899" 
                                + "\n" 
                                + "Balance: 2700.0" 
                                + "\n" 
                                + "Account Type: Chequing" 
                                + "\n" 
                                + "Transactions (Most Recent First):" 
                                + "\n" 
                                + "Deposited: 300.0 to Chequing Account." 
                                + "\n" 
                                + "Withdrew: 100.0 to Chequing Account." 
                                + "\n";

        // Act
        String actualOutput = account.toString();

        // Assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testToString_2() {
        // Arrange
        ChequingAccount account = new ChequingAccount("Eve", "990011", 1000.0);
        account.deposit("Eve", 500.0);
        account.withdraw("Eve", 200.0);
        String expectedOutput = "Account Name: Chequing Account" 
                                + "\n" 
                                + "Account Number: 990011" 
                                + "\n" 
                                + "Balance: 1300.0" 
                                + "\n" 
                                + "Account Type: Chequing" 
                                + "\n" 
                                + "Transactions (Most Recent First):" 
                                + "\n" 
                                + "Deposited: 500.0 to Chequing Account." 
                                + "\n" 
                                + "Withdrew: 200.0 to Chequing Account." 
                                + "\n";

        // Act
        String actualOutput = account.toString();

        // Assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testToString_3() {
        // Arrange
        ChequingAccount account = new ChequingAccount("Frank", "223344", 500.0);
        account.deposit("Frank", 100.0);
        account.withdraw("Frank", 50.0);
        String expectedOutput = "Account Name: Chequing Account" 
                                + "\n" 
                                + "Account Number: 223344" 
                                + "\n" 
                                + "Balance: 550.0" 
                                + "\n" 
                                + "Account Type: Chequing" 
                                + "\n" 
                                + "Transactions (Most Recent First):" 
                                + "\n" 
                                + "Deposited: 100.0 to Chequing Account." 
                                + "\n" 
                                + "Withdrew: 50.0 to Chequing Account." 
                                + "\n";

        // Act
        String actualOutput = account.toString();

        // Assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}
