package tests;

import org.junit.jupiter.api.Test;
import main.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * author: Tarkan Zarrouk
 * date: 2025/01/19
 * Unit testing
 */


 /**
  * Unit tests for the Account class
  */
public class AccountTest {
    @BeforeEach
    void resetAccountTypes() {
        Account.resetAccountTypes();
    }
    @Test
    void testCreateAccount_1() {
        // Arrange
        String expectedAccountName = "John Doe";
        String expectedAccountNumber = "123456";
        double expectedBalance = 500.0;

        // Act
        Account account1 = new Account(expectedAccountName, expectedAccountNumber, expectedBalance);
        
        // Assert
        String actualAccountName = account1.getAccountName();
        String actualAccountNumber = account1.getAccountNumber();
        double actualBalance = account1.getBalance();

        Assertions.assertEquals(expectedAccountName, actualAccountName);
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    void testCreateAccount_2() {
        // Arrange
        double expectedBalance = 0.0;

        // Act
        Account account2 = new Account("Jane Smith", "654321", expectedBalance);

        // Assert
        double actualBalance = account2.getBalance();
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    /**
     * Tests that the correct account name is returned.
     */
    @Test
    void testGetAccountName_1() {
        // Arrange
        String expectedAccountName = "Alice";

        // Act
        Account account1 = new Account(expectedAccountName, "789101");

        // Assert
        String actualAccountName = account1.getAccountName();
        Assertions.assertEquals(expectedAccountName, actualAccountName);
    }

    @Test
    void testGetAccountName_2() {
        // Arrange
        String expectedAccountName = "";

        // Act
        Account account2 = new Account(expectedAccountName, "111111");

        // Assert
        String actualAccountName = account2.getAccountName();
        Assertions.assertEquals(expectedAccountName, actualAccountName);
    }

    @Test
    void testGetAccountName_3() {
        // Arrange
        String expectedAccountName = "Very Long Name Test";

        // Act
        Account account3 = new Account(expectedAccountName, "222222");

        // Assert
        String actualAccountName = account3.getAccountName();
        Assertions.assertEquals(expectedAccountName, actualAccountName);
    }
    @Test
    void testGetAccountNumber_1() {
        // Arrange
        String expectedAccountNumber = "112233";

        // Act
        Account account1 = new Account("Bob", expectedAccountNumber);

        // Assert
        String actualAccountNumber = account1.getAccountNumber();
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    @Test
    void testGetAccountNumber_2() {
        // Arrange
        String expectedAccountNumber = "";

        // Act
        Account account2 = new Account("No Number", expectedAccountNumber);

        // Assert
        String actualAccountNumber = account2.getAccountNumber();
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    @Test
    void testGetAccountNumber_3() {
        // Arrange
        String expectedAccountNumber = "11-22-33";

        // Act
        Account account3 = new Account("SpecialChar Test", expectedAccountNumber);

        // Assert
        String actualAccountNumber = account3.getAccountNumber();
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
    }
    @Test
    void testGetAccountTypes_1() {
        // Arrange
        String expectedAccountType = "Savings";

        // Act
        Account.addAccountTypes(expectedAccountType);

        // Assert
        String actualAccountTypes = Account.getAccountTypes();
        Assertions.assertTrue(actualAccountTypes.contains(expectedAccountType));
    }

    @Test
    void testGetAccountTypes_2() {
        // Arrange
        String expectedAccountType1 = "Savings";
        String expectedAccountType2 = "Chequing";

        // Act
        Account.addAccountTypes(expectedAccountType1);
        Account.addAccountTypes(expectedAccountType2);

        // Assert
        String actualAccountTypes = Account.getAccountTypes();
        Assertions.assertTrue(actualAccountTypes.contains(expectedAccountType1));
        Assertions.assertTrue(actualAccountTypes.contains(expectedAccountType2));
    }

    @Test
    void testGetAccountTypes_3() {
        // Arrange
        String expectedMessage = "[Savings, Chequing]";

        // Act
        Account.resetAccountTypes();

        // Assert
        String actualAccountTypes = Account.getAccountTypes();
        Assertions.assertEquals(expectedMessage, actualAccountTypes);
    }
    @Test
    void testGetBalance_1() {
        // Arrange
        double expectedBalance = 1000.0;

        // Act
        Account account1 = new Account("Charlie", "445566", expectedBalance);

        // Assert
        double actualBalance = account1.getBalance();
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    void testGetBalance_2() {
        // Arrange
        double expectedBalance = 0.0;

        // Act
        Account account2 = new Account("Zero Test", "556677", expectedBalance);

        // Assert
        double actualBalance = account2.getBalance();
        Assertions.assertEquals(expectedBalance, actualBalance);
    }
    @Test
    void testToString_1() {
        // Arrange
        String expectedAccountName = "Diana";
        String expectedAccountNumber = "778899";
        double expectedBalance = 2500.0;
        String expectedOutput = "Account Number: 778899" 
                                + "\nAccount Name: Diana"
                                + "\n"
                                + "Balance: 2500.0"
                                + "\n"
                                + "Account Types: [Savings]";

        Account.addAccountTypes("Savings");

        // Act
        Account account1 = new Account(expectedAccountName, expectedAccountNumber, expectedBalance);
        String actualOutput = account1.toString();

        // Assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}
