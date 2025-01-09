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
        do {
            System.out.println("Hi, welcome to your personalized banking application");
            System.out.println("Please Choose An Option:");
            System.out.println("[0] - Exit");
            System.out.println("[1] - Create an Account");
            System.out.println("[2] - Deposit Money");
            System.out.println("[3] - Withdraw Money");
            System.out.println("[4] - Transfer Money");
            System.out.println("[5] - View Transaction History");
            choice = input.nextInt();
            input.nextLine(); // flush

            if(choice == 0) {
                System.out.println("Successfully exited program");
                System.exit(0); 
            } else if(choice == 1) {
                // Account class
                System.out.println("Sure! We can create an account for you! 😊");
                System.out.print("What should we call it: ");
                String accountName = input.nextLine();
                Account.createAccount(accountName);

            }
        } while (input.nextInt() != 0);

        // close scanner
        input.close();
    }
}
