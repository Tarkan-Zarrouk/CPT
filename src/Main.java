import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // default value of invalid option
        int choice = -1;
        Account bankAccount = new Account("Tarkan Zarrouk", "1234-5678-9101-2445", 0.0);
        SavingsAccount savingsAccount = new SavingsAccount("Tarkan Zarrouk", "1234-1234-1234-1234", 0.0, 4.5);
        callMain(choice, bankAccount, savingsAccount, input);
    }
    
    public static void callMain(int choice, Account bankAccount, SavingsAccount savingsAccount, Scanner input) {
        do {
            System.out.println("Hi, welcome to your personalized banking application");
            System.out.println("Please Choose an Option:");
            System.out.println("[1] - Exit");
            System.out.println("[2] - Account (This is where you can create, delete, and view your accounts and their information)");
            System.out.println("[3] - Savings (This is where you can view your savings account information)");
            System.out.println("[4] - Chequeing (This is where you can view your chequeing account information)");
            System.out.println("[5] - Credit (This is where you can view your credit account information)");
            System.out.println("[6] - Investment (This is where you can view your investment account information)");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Successfully exited program");
                    System.exit(0);
                    break;
                case 2:
                    accountSection(input, bankAccount, savingsAccount);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 1);
    }
    public static void accountSection(Scanner input, Account bankAccount, SavingsAccount savingsAccount) {
        String accountChoice;
        String accountName;
        String folderName;
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
                    return;
                case "B":
                    System.out.println("Sure we can create the account for you!");
                    System.out.println("What type of account would you like to create: ");
                    System.out.println("[1] - Savings");
                    System.out.println("[2] - Chequeing");
                    System.out.println("[3] - Credit");
                    System.out.println("[4] - Investment");

                    String accountType = input.nextLine();
                    switch (accountType) {
                        case "1":
                            System.out.print("What would you like it to be called: ");
                            accountName = input.nextLine();
                            System.out.print("What would the folder name that this would be stored in called: ");
                            folderName = input.nextLine();
                            savingsAccount.createSavingsAccount(folderName, savingsAccount.getAccountName(), savingsAccount.getAccountNumber(), savingsAccount.getBalance(), savingsAccount.getInterestRate());
                            System.out.println("Successfully created account! 😊");
                        break;
                        case "2":
                            System.out.println("Chequeing section is under construction.");
                        break;
                        case "3":
                            System.out.println("Credit section is under construction.");
                        break;
                        case "4":
                            System.out.println("Investment section is under construction.");
                        break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                break;
                case "C":
                    System.out.print("Are you sure? Confirm by typing yes if you'd like to go back (between Y or N): ");
                    if(input.nextLine().toUpperCase() == "Y") {
                        System.out.print("Awesome! What directory is the account stored in: ");
                        folderName = input.nextLine();
                        System.out.print("What is the account name: ");
                        accountName = input.nextLine();
                        Methods.deleteFile(accountName, folderName);
                        System.out.println("Successfully deleted account! 😊");
                    }
                break;
                case "D":
                    System.out.println(bankAccount.toString());
                break;
                case "E":
                    System.out.println("Transaction History functionality is under construction.");
                break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!accountChoice.equals("A"));
    }
    public static void savingsSection() {

    }
}
