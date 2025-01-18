package tests;

import main.Account;
import main.CreditAccount;
import main.TransactionHistory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class CreditAccountTest {

    @BeforeEach
    void resetAccounTypes() {
        Account.resetAccountTypes();
    }

    @Test
    void testCreateCreditAccountFile_1() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("John Doe", "123456", 10000.0, 500.0, 5.0);
        String expectedMessage = "Successfully created John Doe";

        // Act
        String actualMessage = creditAccount.createCreditAccountFile("John Doe", "123456", 10000.0, 500.0);

        // Assert
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testCreateCreditAccountFile_2() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("Jane Smith", "654321", 15000.0, 200.0, 3.0);
        String expectedMessage = "Successfully created Jane Smith";

        // Act
        String actualMessage = creditAccount.createCreditAccountFile("Jane Smith", "654321", 15000.0, 200.0);

        // Assert
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testCreateCreditAccountFile_3() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("Sam Green", "789101", 12000.0, 700.0, 4.0);
        String expectedMessage = "Successfully created Sam Green";

        // Act
        String actualMessage = creditAccount.createCreditAccountFile("Sam Green", "789101", 12000.0, 700.0);

        // Assert
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testGetAccountName_1() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("John Doe", "123456", 10000.0, 500.0, 5.0);
        String expectedAccountName = "John Doe";

        // Act
        String actualAccountName = creditAccount.getAccountName();

        // Assert
        Assertions.assertEquals(expectedAccountName, actualAccountName);
    }

    @Test
    void testGetAccountName_2() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("Alice Brown", "112233", 8000.0, 300.0, 6.0);
        String expectedAccountName = "Alice Brown";

        // Act
        String actualAccountName = creditAccount.getAccountName();

        // Assert
        Assertions.assertEquals(expectedAccountName, actualAccountName);
    }

    @Test
    void testGetAccountName_3() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("Bob White", "445566", 5000.0, 100.0, 4.0);
        String expectedAccountName = "Bob White";

        // Act
        String actualAccountName = creditAccount.getAccountName();

        // Assert
        Assertions.assertEquals(expectedAccountName, actualAccountName);
    }

    @Test
    void testGetAccountNumber_1() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("John Doe", "123456", 10000.0, 500.0, 5.0);
        String expectedAccountNumber = "123456";

        // Act
        String actualAccountNumber = creditAccount.getAccountNumber();

        // Assert
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    @Test
    void testGetAccountNumber_2() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("Jane Smith", "654321", 15000.0, 200.0, 3.0);
        String expectedAccountNumber = "654321";

        // Act
        String actualAccountNumber = creditAccount.getAccountNumber();

        // Assert
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    @Test
    void testGetAccountNumber_3() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("Sam Green", "789101", 12000.0, 700.0, 4.0);
        String expectedAccountNumber = "789101";

        // Act
        String actualAccountNumber = creditAccount.getAccountNumber();

        // Assert
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    @Test
    void testGetCreditLimit_1() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("John Doe", "123456", 10000.0, 500.0, 5.0);
        double expectedCreditLimit = 10000.0;

        // Act
        double actualCreditLimit = creditAccount.getCreditLimit();

        // Assert
        Assertions.assertEquals(expectedCreditLimit, actualCreditLimit);
    }

    @Test
    void testGetCreditLimit_2() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("Alice Brown", "112233", 8000.0, 300.0, 6.0);
        double expectedCreditLimit = 8000.0;

        // Act
        double actualCreditLimit = creditAccount.getCreditLimit();

        // Assert
        Assertions.assertEquals(expectedCreditLimit, actualCreditLimit);
    }

    @Test
    void testGetCreditLimit_3() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("Bob White", "445566", 5000.0, 100.0, 4.0);
        double expectedCreditLimit = 5000.0;

        // Act
        double actualCreditLimit = creditAccount.getCreditLimit();

        // Assert
        Assertions.assertEquals(expectedCreditLimit, actualCreditLimit);
    }

    @Test
    void testGetOwedBalance_1() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("John Doe", "123456", 10000.0, 500.0, 5.0);
        double expectedOwedBalance = 500.0;

        // Act
        double actualOwedBalance = creditAccount.getOwedBalance();

        // Assert
        Assertions.assertEquals(expectedOwedBalance, actualOwedBalance);
    }

    @Test
    void testGetTransactionHistory_1() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("John Doe", "123456", 10000.0, 500.0, 5.0);
        String expectedTransactionHistory = "No transactions available.";

        // Act
        TransactionHistory actualTransactionHistory = creditAccount.getTransactionHistory();

        // Assert
        Assertions.assertEquals(expectedTransactionHistory, actualTransactionHistory.toString());
    }

    @Test
    void testGetTransactionHistory_2() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("Alice Brown", "112233", 8000.0, 300.0, 6.0);
        String expectedTransactionHistory = "No transactions available.";

        // Act
        TransactionHistory actualTransactionHistory = creditAccount.getTransactionHistory();

        // Assert
        Assertions.assertEquals(expectedTransactionHistory, actualTransactionHistory.toString());
    }

    @Test
    void testToString_1() {
        Account.resetAccountTypes();
        // Arrange
        CreditAccount creditAccount = new CreditAccount("John Doe", "123456", 10000.0, 500.0, 5.0);
        String expectedOutput = "Account Name: 123456" 
                                + "\n" 
                                + "Account Number: John Doe" 
                                + "\n" 
                                + "Credit Limit: 10000.0" 
                                + "\n" 
                                + "Balance: 500.0" 
                                + "\n" 
                                + "Transactions: No transactions available." 
                                + "\n" 
                                + "Account Types: [Credit]";
        // Act
        String actualOutput = creditAccount.toString();

        // Assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testToString_2() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("Alice Brown", "112233", 8000.0, 300.0, 6.0);
        String expectedOutput = "Account Name: 112233" 
                                + "\n" 
                                + "Account Number: Alice Brown" 
                                + "\n" 
                                + "Credit Limit: 8000.0" 
                                + "\n" 
                                + "Balance: 300.0" 
                                + "\n" 
                                + "Transactions: No transactions available." 
                                + "\n" 
                                + "Account Types: [Credit]";

        // Act
        String actualOutput = creditAccount.toString();

        // Assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testToString_3() {
        // Arrange
        CreditAccount creditAccount = new CreditAccount("Bob White", "445566", 5000.0, 100.0, 4.0);
        String expectedOutput = "Account Name: 445566" 
                                + "\n" 
                                + "Account Number: Bob White" 
                                + "\n" 
                                + "Credit Limit: 5000.0" 
                                + "\n" 
                                + "Balance: 100.0" 
                                + "\n" 
                                + "Transactions: No transactions available." 
                                + "\n" 
                                + "Account Types: [Credit]";

        // Act
        String actualOutput = creditAccount.toString();

        // Assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}
