import java.util.Scanner;
/**
 * author: Tarkan Zarrouk
 * date: 2025/01/17
 * Main class where we run our program
 */
public class Main {
    /**
     * Main method that runs the program
     * @param args - arguments
     * @return void
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // default value of invalid option
        int choice = -1;
        Account bankAccount = new Account("Tarkan Zarrouk", "1234-5678-9101-2445", 0.0);
        SavingsAccount savingsAccount = new SavingsAccount("Tarkan Zarrouk", "1234-1234-1234-1234", 10,4.5, "min");
        ChequingAccount chequingAccount = new ChequingAccount("Tarkan Zarrouk","1234-1234-1234", 45.00);
        CreditAccount creditAccount = new CreditAccount("Tarkan Zarrouk", "1234-5678-9101-2445", 5000.0, 10.0);
        savingsAccount.checkAndUpdateSavingsAccount();
        callMain(choice, bankAccount, savingsAccount,chequingAccount, creditAccount, input);
    }
    /**
     * Method that calls the main method and allows the user to choose an option to navigate through the program
     * @param choice - choice
     * @param bankAccount - account
     * @param savingsAccount - savings account
     * @param input - scanner
     * @return void
     */
    public static void callMain(int choice, Account bankAccount, SavingsAccount savingsAccount, ChequingAccount chequingAccount, CreditAccount creditAccount, Scanner input) {
        do {
            System.out.println("Hi, welcome to your personalized banking application");
            System.out.println("Please Choose an Option:");
            System.out.println("[1] - Exit");
            System.out.println("[2] - Account (This is where you can create, delete, and view your accounts and their information)");
            System.out.println("[3] - Savings (This is where you can view your savings account information)");
            System.out.println("[4] - Chequeing (This is where you can view your chequeing account information)");
            System.out.println("[5] - Credit (This is where you can view your credit account information)");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Successfully exited program");
                    System.exit(0);
                break;
                case 2:
                    accountSection(input, bankAccount, savingsAccount, creditAccount);
                break;
                case 3:
                    savingsAccountSection(input, savingsAccount);
                break;
                case 4:
                    chequingAccountSection(input, chequingAccount);
                break;
                case 5:
                    creditAccountSection(input, creditAccount);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 1);
    }
    /**
     * Method that allows the user to navigate through the account section of the program and create, delete, and view their accounts
     * @param input - scanner
     * @param bankAccount - account
     * @param savingsAccount - savings account
     * @return void
     */
    public static void accountSection(Scanner input, Account bankAccount, SavingsAccount savingsAccount, CreditAccount creditAccount) {
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

                    String accountType = input.nextLine();
                    switch (accountType) {
                        case "1":
                            System.out.println("Remember: The account name is fixed to your legal name with the directory of the type of account you're creating! 😊");
                            savingsAccount.createSavingsAccount(savingsAccount.getAccountName(), savingsAccount.getAccountNumber(), savingsAccount.getBalance(), savingsAccount.getInterestRate(),savingsAccount.getInterestPeriod());
                            System.out.println("Successfully created account! 😊");
                        break;
                        case "2":
                            System.out.println("Remember: The account name is fixed to your legal name with the directory of the type of account you're creating! 😊");
                            ChequingAccount.createChequingAccount(bankAccount.getAccountName(), bankAccount.getAccountNumber(), bankAccount.getBalance());
                            // chequingAccount.createChequingAccount(folderName, accountName, chequingAccount.getAccountNumber(), chequingAccount.getBalance());
                            System.out.println("Successfully created account! 😊");
                            // System.out.println(account.getAccountTypes());
                        break;
                        case "3":
                            System.out.println("Remember the account name is fixed to your legal name witht the directory of the type of account you're creating! ");
                            creditAccount.createCreditAccountFile(bankAccount.getAccountName(), bankAccount.getAccountNumber(), creditAccount.getCreditLimit(), creditAccount.getBalance());
                        break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                break;
                case "C":
                    System.out.print("Are you sure? Confirm by typing yes if you'd like to go back (between Y or N): ");
                    if(input.nextLine().toUpperCase().equals("Y")) {
                        System.out.print("Awesome! What directory is the account stored in: ");
                        folderName = input.nextLine();
                        System.out.print("What is the account name: ");
                        accountName = input.nextLine();
                        Methods.deleteFile(folderName, accountName);
                        System.out.println("Successfully deleted account! 😊");
                    }
                break;
                case "D":
                    System.out.println(bankAccount.getAccountTypes());
                    // System.out.println(bankAccount.toString());
                break;
                case "E":
                break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!accountChoice.equals("A"));
    }
    /**
     * Method that allows the user to navigate through the savings account section of the program and view their savings account information
     * @param input - scanner
     * @param savingsAccount - savings account
     * @return void
     */
    public static void savingsAccountSection(Scanner input, SavingsAccount savingsAccount) {
        String savingsChoice;
        double currencyAmount;
        do {
            System.out.println("Welcome to Your Savings Account Section!");
            System.out.println("Please Choose an Option Below:");
            System.out.println("[A] - Exit");
            System.out.println("[B] - Deposit");
            System.out.println("[C] - Withdraw");
            System.out.println("[D] - History");
            
            savingsChoice = input.nextLine().toUpperCase();
            
            switch (savingsChoice) {
                case "A":
                return;
                case "B":
                    System.out.print("How much would you like to deposit: ");
                    currencyAmount = input.nextDouble();
                    input.nextLine(); // Consume the leftover newline character
                    savingsAccount.deposit(savingsAccount.getAccountName(), currencyAmount);
                // System.out.println(savingsAccount.toString());
                break;
                case "C":
                    System.out.print("How much would you like to withdraw: ");
                    currencyAmount = input.nextDouble();
                    input.nextLine(); // Consume the leftover newline character
                    savingsAccount.withdraw(savingsAccount.getAccountName(), currencyAmount);
                // System.out.println(savingsAccount.toString());
                break;
                case "D":
                System.out.println("Currently under construction");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!savingsChoice.equals("A"));
    }
    /**
     * Method that allows the user to navigate through the savings account section of the program and view their savings account information
     * @param input - scanner
     * @param savingsAccount - savings account
     * @return void
     */
    public static void chequingAccountSection(Scanner input, ChequingAccount chequingAccount) {
        String savingsChoice;
        double currencyAmount;
        do {
            System.out.println("Welcome to Your Savings Account Section!");
            System.out.println("Please Choose an Option Below:");
            System.out.println("[A] - Exit");
            System.out.println("[B] - Deposit");
            System.out.println("[C] - Withdraw");
            System.out.println("[C] - History");
            
            savingsChoice = input.nextLine().toUpperCase();
            
            switch (savingsChoice) {
                case "A":
                return;
                case "B":
                    System.out.print("How much would you like to deposit: ");
                    currencyAmount = input.nextDouble();
                    input.nextLine();
                    chequingAccount.deposit(chequingAccount.getAccountName(), currencyAmount);
                // System.out.println(chequingAccount.toString());
                break;
                case "C":
                    System.out.print("How much would you like to withdraw: ");
                    currencyAmount = input.nextDouble();
                    input.nextLine(); 
                    chequingAccount.withdraw(chequingAccount.getAccountName(), currencyAmount);
                // System.out.println(chequingAccount.toString());
                break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!savingsChoice.equals("A"));
    }
    /**
     * Allows the user to navigate through the savings account section of the program and view their savings account information
     * @param input - The user input
     * @param creditAccount - Savings account object containing their info for this account
     */
    public static void creditAccountSection(Scanner input, CreditAccount creditAccount) {
        String savingsChoice;
        double currencyAmount;
        do {
            System.out.println("Welcome to Your Savings Account Section!");
            System.out.println("Please Choose an Option Below:");
            System.out.println("[A] - Exit");
            System.out.println("[B] - Make Payment");
            System.out.println("[C] - Withdraw Money");
            System.out.println("[D] - History");
            
            savingsChoice = input.nextLine().toUpperCase();
            
            switch (savingsChoice) {
                case "A":
                return;
                case "B":
                    System.out.print("How much would you like to deposit: ");
                    currencyAmount = input.nextDouble();
                    input.nextLine();
                    creditAccount.makePayment(currencyAmount);
                break;
                case "C":
                    System.out.print("How much would you like to withdraw: ");
                    currencyAmount = input.nextDouble();
                    input.nextLine();
                    creditAccount.charge(currencyAmount);
                break;
                case "D":
                    System.out.println("meow - Still under work, come back later ;3");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!savingsChoice.equals("A"));
    }
}
