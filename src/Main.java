/**
 * author: Tarkan Zarrouk
 * date: (due date)
 * Main class to do basic startup, processing, and output
 */

import java.util.Scanner;

/**
 * This is the Main class... Essentially the heart of the whole project
 * This class will be in charge for running the actual methods,updating account info and other items.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice; // create initial choice value... not 0 or anything else
        // initalize basic composition
        Account bankAccount = new Account("Tarkan's Bank Account", "4506-1125-2455-9084");
        do {
            System.out.println("Hi, welcome to your personalized banking application");
            System.out.println("Please Choose an Option:");
            System.out.println("[1] - Exit");
            System.out.println("[2] - Account");
            System.out.println("[3] Chequeing");
            choice = Integer.parseInt(input.nextLine());
            if(choice != 0) {
                break;
            }
        } while(choice == 0);
        do {
            if(choice == 1) {
                System.out.println("Successfully exited program");
                System.exit(0); 
            } else if(choice == 2) {
                // Account class
                System.out.println("Welcome to Your Account Section!");
                System.out.println("Please Choose an Option Below:");
                System.out.println("[A] - Exit");
                System.out.println("[B] - Add Account");
                // @TODO: Implement Remove Account
                System.out.println("[C] - Remove Account");
                System.out.println("[B] - Account information");
                // TODO: Implement Transaction history
                System.out.println("[C] - Transaction History");
                if(input.nextLine().equals("A")) {
                    break;
                }
                if(input.nextLine().equals("B")) {
                    System.out.println(bankAccount.toString());
                    choice = 0;
                }

                if(choice == 0) {
                    break;
                }
                // System.out.println("Sure! We can create an account for you! 😊");
                // System.out.print("What    should we call it: ");
                // String accountName = input.nextLine();
                // Account.createAccount(accountName);
                // System.out.println("Please Choose An Option:");
                // System.out.println("[5] - View Transaction History");
            }
        } while (Integer.parseInt(input.nextLine()) != 0);
        // close scanner
        input.close();
    }
}
