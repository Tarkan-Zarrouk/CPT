/**
 * author: Tarkan Zarrouk
 * date: (due date)
 * Management class for Bank Account
 */

import java.io.File;
import java.io.IOException;

/**
 * Bank account allowing you to perform actions such as Creating an account, deleting an account, adding money... etc
 */
public class Account {
    private String accountNumber;
    private String accountName;
    private double balance;
    // 
    public Account(String accountName, String accountNumber) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = 0.00;
    }
    // File creation object... (W3 Schools - https://www.w3schools.com/java/java_files_create.asp);
    public static String createAccount(String accountName) {
        try {
            String userName = accountName;
            File fileName = new File("accounts/" + userName + ".txt");
            fileName.getParentFile().mkdirs(); // Create directories if they do not exist
            if(fileName.createNewFile()) {
                return "Account Successfully Created";
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return "Successfully created " + accountName;
    }
    
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\n" + "Account Name: " + accountName + "\n" + "Balance: " + balance + "\n";
    }
}
