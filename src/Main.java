import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1; // initialize choice with an invalid value
        Account bankAccount = new Account("Tarkan's Bank Account", "4506-1125-2455-9084");

        do {
            System.out.println("Hi, welcome to your personalized banking application");
            System.out.println("Please Choose an Option:");
            System.out.println("[1] - Exit");
            System.out.println("[2] - Account");
            System.out.println("[3] - Chequeing");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Successfully exited program");
                    System.exit(0);
                    break;
                case 2:
                    accountSection(input, bankAccount);
                    break;
                case 3:
                    // Implement Chequeing section here
                    System.out.println("Chequeing section is under construction.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 1);
    }

    private static void accountSection(Scanner input, Account bankAccount) {
        String accountChoice;
        do {
            System.out.println("Welcome to Your Account Section!");
            System.out.println("Please Choose an Option Below:");
            System.out.println("[A] - Exit");
            System.out.println("[B] - Add Account");
            System.out.println("[C] - Remove Account");
            System.out.println("[D] - Account information");
            System.out.println("[E] - Transaction History");

            accountChoice = input.nextLine().toUpperCase();

            switch (accountChoice) {
                case "A":
                    return; // Exit to the main menu
                case "B":
                    // Implement Add Account functionality
                    System.out.println("Add Account functionality is under construction.");
                    break;
                case "C":
                    // Implement Remove Account functionality
                    System.out.println("Remove Account functionality is under construction.");
                    break;
                case "D":
                    System.out.println(bankAccount.toString());
                    break;
                case "E":
                    // Implement Transaction History functionality
                    System.out.println("Transaction History functionality is under construction.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!accountChoice.equals("A"));
    }
}
