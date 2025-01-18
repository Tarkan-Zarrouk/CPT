package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.TransactionHistory;

/**
 * author: Tarkan Zarrouk
 * date: 2025/01/19
 * Unit testing
 */


 /**
  * Unit tests for the TransactionHistory class
  */
public class TransactionHistoryTest {

    // Test cases for "Get Most Recent Transaction"
    @Test
    void testGetMostRecentTransaction_1() {
        // Arrange
        TransactionHistory history = new TransactionHistory();
        history.addTransaction("Deposit $100");
        history.addTransaction("Withdraw $50");

        // Act
        String expected = "Withdraw $50";
        String actual = history.getMostRecentTransaction();

        // Assert
        Assertions.assertEquals(expected, actual);
    }


    // Test cases for "Remove Most Recent Transaction"
    @Test
    void testRemoveMostRecentTransaction_1() {
        // Arrange
        TransactionHistory history = new TransactionHistory();
        history.addTransaction("Deposit $100");
        history.addTransaction("Withdraw $50");

        // Act
        String expectedRemoved = "Withdraw $50";
        String actualRemoved = history.removeMostRecentTransaction();
        String expectedRemaining = "Deposit $100";
        String actualRemaining = history.getMostRecentTransaction();

        // Assert
        Assertions.assertEquals(expectedRemoved, actualRemoved);
        Assertions.assertEquals(expectedRemaining, actualRemaining);
    }

    @Test
    void testRemoveMostRecentTransaction_2() {
        // Arrange
        TransactionHistory history = new TransactionHistory();
        history.addTransaction("Deposit $100");
        history.addTransaction("Withdraw $50");

        // Act
        String expectedRemoved = "Withdraw $50";
        String actualRemoved = history.removeMostRecentTransaction();
        String expectedRemaining = "Deposit $100";
        String actualRemaining = history.getMostRecentTransaction();

        // Assert
        Assertions.assertEquals(expectedRemoved, actualRemoved);
        Assertions.assertEquals(expectedRemaining, actualRemaining);
    }

    @Test
    void testRemoveMostRecentTransaction_3() {
        // Arrange
        TransactionHistory history = new TransactionHistory();
        history.addTransaction("Deposit $100");
        history.addTransaction("Withdraw $50");

        // Act
        String expectedRemoved = "Withdraw $50";
        String actualRemoved = history.removeMostRecentTransaction();
        String expectedRemaining = "Deposit $100";
        String actualRemaining = history.getMostRecentTransaction();

        // Assert
        Assertions.assertEquals(expectedRemoved, actualRemoved);
        Assertions.assertEquals(expectedRemaining, actualRemaining);
    }

    // Test cases for "To String"
    @Test
    void testToString_1() {
        // Arrange
        TransactionHistory history = new TransactionHistory();
        history.addTransaction("Deposit $100");
        history.addTransaction("Withdraw $50");

        String expected = "Transactions (Most Recent First):\nDeposit $100\nWithdraw $50\n";

        // Act
        String actual = history.toString();

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToString_2() {
        // Arrange
        TransactionHistory history = new TransactionHistory();
        history.addTransaction("Deposit $100");
        history.addTransaction("Withdraw $50");

        String expected = "Transactions (Most Recent First):\nDeposit $100\nWithdraw $50\n";

        // Act
        String actual = history.toString();

        // Assert
        Assertions.assertEquals(expected, actual);
    }

}
