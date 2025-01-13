// thank you for adding this java... ;3
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.time.temporal.*;

/**
 * author: Tarkan Zarrouk
 * date: 2025/01/17
 * Management class for Savings Account
 */

 /**
  * @TODO: use stack for transaction history
  */
/**
 * Savings account class that extends the Account class and adds an interest rate and interest to the account
 */
public class SavingsAccount extends Account {
    /**
     * interestRate - the rate at which the account will gain interest
     */
    private double interestRate;
    /**
     * interestPeriod - the period at which the account will gain interest
     */
    private String interestPeriod;
    /**
     * The current date and time.
     */
    private LocalDateTime now;
    /**
     * The date and time when the interest was last added to the savings account.
     */
    private LocalDateTime lastInterestAddedDate;
    /**
     * formatter for the account creation date.
     * The date is formatted as "dd-MM-yyyy HH:mm:ss".
     */
    private DateTimeFormatter accountCreationDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    /**
     * @param accountName - Account owner name
     * @param accountNumber - Account owner number
     * @param balance - Total balance
     * @param interestRate - Interest rate applied to savings account (can be 0,+♾️)
     * @param interestPeriod - Period for which the interest gets compounded (biweekly, monthly, minutes, yearly)
     */
    public SavingsAccount(String accountName, String accountNumber, double balance, double interestRate, String interestPeriod) {
        super(accountName, accountNumber, balance);
        this.interestRate = interestRate;
        this.interestPeriod = interestPeriod;
        this.lastInterestAddedDate = LocalDateTime.now();
    }

    /**
     * Returns the interest rate of the account
     * @return double - interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Returns the account name
     * @return String - account name
     */
    public String getAccountName() {
        return super.getAccountName();
    }

    /**
     * Returns the account number
     * @return String - account number
     */
    public String getAccountNumber() {
        return super.getAccountNumber();
    }

    /**
     * Returns the balance of the account
     * @return double - balance
     */
    public double getBalance() {
        return super.getBalance();
    }

    /**
     * Sets the account name
     * @param accountName - name of the account
     */
    public void setAccountName(String accountName) {
        super.setAccountName(accountName);
    }

    /**
     * Sets the account number
     * @param accountNumber - number of the account
     */
    public void setAccountNumber(String accountNumber) {
        super.setAccountNumber(accountNumber);
    }

    /**
     * Sets the balance of the account
     * @param balance - balance of the account
     */
    public void setBalance(double balance) {
        super.setBalance(balance);
    }

    /**
     * Method that returns the interest period
     * @return String - interest period
     */
    public String getInterestPeriod() {
        return interestPeriod;
    }

    /**
     * Sets the interest rate of the account
     * @param interestRate - rate at which the account will gain interest
     * @return void
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Compound interest formula
     * A(t) = (balance)(1+(interestrate/100))^period - balance
     * Will return interest dollar amount, not applying balance
     * We then apply the balance to the account afterwards.
     */
    public void addInterest() {
        double balance = super.getBalance();
        double interest = (balance * (Math.pow(1 + (interestRate / 100), getPeriodInYears()))) - balance;
        balance += interest;
        setBalance(balance);
        lastInterestAddedDate = LocalDateTime.now();
    }

    public void deposit(String accountName, double amount) {
        if (amount > 0) {
            // add amount to the current balance
            setBalance(getBalance() + amount);
            checkAndUpdateSavingsAccount();
            Methods.writeToFile(accountName, "Savings", this.toString());
        }
    }

    public void withdraw(String accountName, double amount) {
        if (amount > 0) {   
            // add amount to the current balance
            setBalance(getBalance() - amount);
            Methods.writeToFile(accountName, "Savings", this.toString());
        }
    }
    
    /**
     * Converts the unit of time (Bi-weekly, Monthly, Yearly, Minutes)
     * @return Unit of time measured in years;
     */
    public double getPeriodInYears() {
        switch (interestPeriod) {
            case "BW":
                return 14.0 / 365;
            case "M":
                return 1.0 / 12;
            case "Y":
                return 1;
            case "min":
                return 1.0 / (24 * 60 * 365);
            default:
                return 0;
        }
    }
    /**
     * Schedules a task to specific period check and add interest to the savings account.
     * The task runs at a fixed rate of every minute and checks the time elapsed since
     * the last interest was added.
     * periods:
     * - "BW": Bi-weekly (every two weeks)
     * - "M": Monthly
     * - "Y": Yearly
     * - "min": Every minute (this is used for simple debugging purposes)
     */
    public void checkAndAddInterest() {
        Timer timer = new Timer(true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                long period = 0;
                switch (interestPeriod) {
                    case "BW":
                        // Calculate the number of weeks till then... divide by 2 to convert to biweekly payments
                        period = ChronoUnit.WEEKS.between(lastInterestAddedDate, now) / 2;
                        break;
                    case "M":
                        period = ChronoUnit.MONTHS.between(lastInterestAddedDate, now);
                        break;
                    case "Y":
                        period = ChronoUnit.YEARS.between(lastInterestAddedDate, now);
                        break;
                    case "min":
                        period = ChronoUnit.MINUTES.between(lastInterestAddedDate, now);
                        break;
                }
                if (period > 0) {
                    addInterest();
                    Methods.writeToFile(getAccountName(), "Savings", "Interest added at " + accountCreationDate.format(now) + "\n");
                }
            }
        };
        // run every minute
        timer.scheduleAtFixedRate(task, 0, 60 * 1000);
    }
    /**
     * Generates a text-file called savings based off the accountName that is provided in the fixed directory of "Savings"
     * @param accountName - Name of Savings Account to be under
     * @param accountNumber - Savings Account number
     * @param balance - Initial Investment balance
     * @param interestRate - Interest rate of the Savings Account
     * @param interestPeriod - How many times should it be compounded over a period of time
     * @return Message of successful with the account name 
     */
    public String createSavingsAccount(String accountName, String accountNumber, double balance, double interestRate, String interestPeriod) {
        // initialize standard savings account object
        // SavingsAccount savingsAccount = new SavingsAccount(accountName, accountNumber, balance, interestRate, interestPeriod);
        if (!Methods.fileExists(accountName, "Savings")) {
            Methods.createFile(accountName, "Savings");
        }
        now = LocalDateTime.now();
        // contents of file
        String accountDetails = toString();
        Methods.writeToFile(accountName, "Savings", accountDetails);
        // add to the ArrayList<String>
        super.addAccountTypes("Savings");
        return "Successfully created or updated " + accountName;
    }
    /**
     * Definitely an interesting method here...
     * Checks and updates the savings account based on the last updated time.
     * This method performs the following steps:
     * 1. Retrieves the account name and constructs the file path for the account.
     * 2. After we obtain the info we need it checks if the account file exists and is a valid file.
     *      i - If there is no folder at all, we return a print statement indicating no file exists
     * 3. Reads the content of the account file.
     * 4. Breaks down the file to find the last updated time from the file content.
     * 5. Calculates the number of interest periods that have passed since the last update.
     * 6. Adds interest for each period that has passed.
     * 7. Updates the last updated time and balance in the file content.
     * 8. Writes the updated content back to the file.
     * 9. Updates the account details in the file.
     * @throws IOException if an I/O error occurs reading from the file or writing to it.
     * @return Updated balance, and updated date for "last updated: " section in text file
     * This has been AI generated.. Simply the prompt was "Create a method such that I am able to compare within the textFile that is attatched the current to the last updated time and then if it exceeds the period, then we can add interest"
     * Though it did not create this... it took about 3 (unfortunate) hours of debugging and modifying to get it to actually work... not a fan of it but if it works it works
     */
    public void checkAndUpdateSavingsAccount() {
        String accountName = getAccountName();
        String folderPath = "Savings/" + accountName + ".txt";
        File file = new File(folderPath);
        if (file.exists() && file.isFile()) {
            // read in file
            String content = Methods.readInFile(accountName, "Savings");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            // after read in file, we split after the contents of the "last updated: " line has been discovered
            String[] parts = content.split("last updated: ");
            if (parts.length >= 1) {
                LocalDateTime lastUpdated = LocalDateTime.parse(parts[1].trim(), formatter);
                LocalDateTime currentTime = LocalDateTime.now();
                long periodsPassed = 0;
                switch (interestPeriod) {
                    case "BW":
                        periodsPassed = ChronoUnit.WEEKS.between(lastUpdated, currentTime) / 2;
                        break;
                    case "M":
                        periodsPassed = ChronoUnit.MONTHS.between(lastUpdated, currentTime);
                        break;
                    case "Y":
                        periodsPassed = ChronoUnit.YEARS.between(lastUpdated, currentTime);
                        break;
                    case "min":
                        periodsPassed = ChronoUnit.MINUTES.between(lastUpdated, currentTime);
                        break;
                }
                if (periodsPassed > 0) {
                    // periods passed * interest = interest added to account
                    for (long i = 0; i < periodsPassed; i++) {
                        addInterest();
                    }
                    /**
                     * Update the "last updated: " line with the current time that it is 
                     * this is allowable since this will only update when period is >= 1 (essentially when it is the time or exceeds the maximum time for interest)
                     */
                    lastUpdated = lastUpdated.plus(periodsPassed, getChronoUnit());
                    // after the interest has been calcualted over the number of periods passed
                    // we can simply just update the text file's last updated section with the current time that it has been updated
                    // simply using currentTime as it's been updated each time the program has been run (hence calling in main)
                    String updatedContent = content.replace("last updated: " + lastUpdated.format(formatter), "last updated: " + currentTime.format(formatter));
                    // how to replace the first instance of a specific item https://www.w3schools.com/java/ref_string_replacefirst.asp
                    // we check for a "Balance: " followed by a digit more then once, plus a decimal since it's a double 
                    updatedContent = updatedContent.replaceFirst("Balance: \\d+\\.\\d+", "Balance: " + getBalance());
                    Methods.writeToFile(accountName, "Savings", updatedContent);
                    /**
                     * the next to lines simply are a recreation of a toString method
                     */
                    String initialCreationTime = parts[0].split("Account Created at: ")[1].split("\n")[0].trim();
                    String accountDetails =  super.toString() + "Account Created at: " + initialCreationTime + "\n" + "last updated: " + accountCreationDate.format(currentTime) + "\n";
                    // super.getAccountName() + "\n" + super.getAccountNumber() + "\n" + "Balance: " + super.getBalance() + "\n" +
                    Methods.writeToFile(accountName, "Savings", accountDetails);
                }
            }
        } else {
            System.out.println("Folder does not exist at all...");
        }
    }
    
    /**
     * Returns the corresponding date based on the interest period.
     * The interest period is expected to be one of the following:
     * "BW" - Biweekly
     * "M" - Monthly
     * "Y" - Yearly
     * "min" - Minute
     * @return the corresponding for the interest period
     * @throws IllegalArgumentException if the interest period is not recognized
     * source: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/temporal/ChronoUnit.html?is-external=true
     */
    public ChronoUnit getChronoUnit() {
        switch (interestPeriod) {
            case "BW":
                return ChronoUnit.WEEKS;
            case "M":
                return ChronoUnit.MONTHS;
            case "Y":
                return ChronoUnit.YEARS;
            case "min":
                return ChronoUnit.MINUTES;
            default:
                throw new IllegalArgumentException("Please enter a specified interest period... Not: " + interestPeriod);
        }
    }
    /**
     * conversion of parent class account names, numbers, balance then the output of the interest rate, and appreciation period to a string output
     * @return - String copy of the parent class information, interest rate, and appreciation period
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "Interest Rate: " + interestRate + "\n" + "Appreciation Period: " + interestPeriod + "\n" + "Account Created at: " + "\n" + accountCreationDate.format(now) + "\n" + "last updated: " + accountCreationDate.format(now) + "\n";
    }
}
