package tests;

import main.Account;
import main.SavingsAccount;
import main.TransactionHistory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

public class SavingsAccountTest {

    private SavingsAccount savingsAccount;

    /**
     * reset account types to prevent corrupted testcases
     * init savings object per test case cause... I'm not doing all that
     * https://junit.org/junit5/docs/5.0.2/api/org/junit/jupiter/api/BeforeEach.html
     */
    @BeforeEach
    void setUp() {
        // Reset account types before each test to prevent accumulation
        Account.resetAccountTypes();
        // makes it easier to reduces code duplication... I don't care
        savingsAccount = new SavingsAccount("John Doe", "123456", 1000.0, 2.5, "M");
    }
    @Test
    void testCreateSavingsAccount_1() {
        // Arrange
        String expected = "Successfully created or updated John Doe";
        
        // Act
        String actual = savingsAccount.createSavingsAccount("John Doe", "123456", 1000.0, 2.5, "M");

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCreateSavingsAccount_2() {
        // Arrange
        String expected = "Successfully created or updated John Doe";
        
        // Act
        String actual = savingsAccount.createSavingsAccount("John Doe", "123456", 1000.0, 2.5, "M");

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCreateSavingsAccount_3() {
        // Arrange
        String expected = "Successfully created or updated John Doe";
        
        // Act
        String actual = savingsAccount.createSavingsAccount("John Doe", "123456", 1000.0, 2.5, "M");

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetAccountName_1() {
        // Arrange
        String expected = "John Doe";
        
        // Act
        String actual = savingsAccount.getAccountName();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetAccountName_2() {
        // Arrange
        String expected = "John Doe";
        
        // Act
        String actual = savingsAccount.getAccountName();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetAccountName_3() {
        // Arrange
        String expected = "John Doe";
        
        // Act
        String actual = savingsAccount.getAccountName();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetAccountNumber_1() {
        // Arrange
        String expected = "123456";
        
        // Act
        String actual = savingsAccount.getAccountNumber();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetAccountNumber_2() {
        // Arrange
        String expected = "123456";
        
        // Act
        String actual = savingsAccount.getAccountNumber();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetAccountNumber_3() {
        // Arrange
        String expected = "123456";
        
        // Act
        String actual = savingsAccount.getAccountNumber();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetBalance_1() {
        // Arrange
        double expected = 1000.0;
        
        // Act
        double actual = savingsAccount.getBalance();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetBalance_2() {
        // Arrange
        double expected = 1000.0;
        
        // Act
        double actual = savingsAccount.getBalance();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetBalance_3() {
        // Arrange
        double expected = 1000.0;
        
        // Act
        double actual = savingsAccount.getBalance();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetInterestRate_1() {
        // Arrange
        double expected = 2.5;
        
        // Act
        double actual = savingsAccount.getInterestRate();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetInterestRate_2() {
        // Arrange
        double expected = 2.5;
        
        // Act
        double actual = savingsAccount.getInterestRate();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetInterestRate_3() {
        // Arrange
        double expected = 2.5;
        
        // Act
        double actual = savingsAccount.getInterestRate();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetInterestPeriod_1() {
        // Arrange
        String expected = "M";
        
        // Act
        String actual = savingsAccount.getInterestPeriod();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetInterestPeriod_2() {
        // Arrange
        String expected = "M";
        
        // Act
        String actual = savingsAccount.getInterestPeriod();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetTransactionHistory_1() {
        // Arrange
        TransactionHistory expected = new TransactionHistory();
    
        // Act
        TransactionHistory actual = savingsAccount.getTransactionHistory();
    
        // Assert
        // https://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
        Assertions.assertEquals(expected.toString().trim(), actual.toString().trim());
    }

    @Test
    void testGetTransactionHistory_2() {
        // Arrange
        TransactionHistory expected = new TransactionHistory();
    
        // Act
        TransactionHistory actual = savingsAccount.getTransactionHistory();
    
        // Assert
        Assertions.assertEquals(expected.toString().trim(), actual.toString().trim());
    }

    @Test
    void testToString_1() {
        // Arrange
        String expected = "Account Number: 123456"
                        + "\n" 
                        + "Account Name: John Doe"
                        + "\n" 
                        + "Balance: 1000.0"
                        + "\n" 
                        +"Account Types: []"
                        + "\n" 
                        +"Interest Rate: 2.5"
                        + "\n" 
                        +"Appreciation Period: M"
                        + "\n" 
                        +"Transactions: "
                        + "\n" 
                        +"No transactions available."
                        + "\n" 
                        +"Account Created at: " 
                        + savingsAccount.getAccountCreationDate() 
                        + "\n" 
                        + "last updated: " 
                        + savingsAccount.getAccountCreationDate() 
                        + "\n";
        
        // Act
        String actual = savingsAccount.toString();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToString_2() {
        // Arrange
        String expected = "Account Number: 123456" 
                        + "\n"
                        +"Account Name: John Doe"
                        + "\n" 
                        +"Balance: 1000.0"
                        + "\n" 
                        +"Account Types: []"
                        + "\n"  
                        +"Interest Rate: 2.5"
                        + "\n" 
                        +"Appreciation Period: M"
                        + "\n"
                        +"Transactions: "
                        + "\n"
                        +"No transactions available."
                        + "\n"
                        +"Account Created at: " 
                        + savingsAccount.getAccountCreationDate() 
                        + "\n"
                        +"last updated: " 
                        + savingsAccount.getAccountCreationDate() 
                        + "\n";
        
        // Act
        String actual = savingsAccount.toString();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToString_3() {
        // Arrange
        String expected = "Account Number: 123456" 
                        + "\n" 
                        +"Account Name: John Doe"
                        + "\n" 
                        +"Balance: 1000.0"
                        + "\n" 
                        +"Account Types: []"
                        + "\n" 
                        + "Interest Rate: 2.5"
                        + "\n" 
                        +"Appreciation Period: M"
                        + "\n" 
                        +"Transactions: "
                        + "\n" 
                        +"No transactions available."
                        + "\n" 
                        +"Account Created at: " 
                        + savingsAccount.getAccountCreationDate() 
                        + "\n" 
                        + "last updated: " 
                        + savingsAccount.getAccountCreationDate() 
                        + "\n";
        
        // Act
        String actual = savingsAccount.toString();
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }
}
