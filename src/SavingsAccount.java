// thank you for adding this java... ;3
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.time.temporal.*;

// import java.time.LocalDateTime;
// import java.time.temporal.ChronoUnit;
// import java.util.Timer;
// import java.util.TimerTask;

/**
 * author: Tarkan Zarrouk
 * date: (due date)
 * Management class for Savings Account
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
     * @return double - interest rate
     * Returns the interest rate of the account
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * @return String - account name
     * Returns the account name
     */
    public String getAccountName() {
        return super.getAccountName();
    }

    /**
     * @return String - account number
     * Returns the account number
     */
    public String getAccountNumber() {
        return super.getAccountNumber();
    }

    /**
     * @return double - balance
     * Returns the balance of the account
     */
    public double getBalance() {
        return super.getBalance();
    }

    /**
     * @param accountName - name of the account
     * Sets the account name
     */
    public void setAccountName(String accountName) {
        super.setAccountName(accountName);
    }

    /**
     * @param accountNumber - number of the account
     * Sets the account number
     */
    public void setAccountNumber(String accountNumber) {
        super.setAccountNumber(accountNumber);
    }

    /**
     * @param balance - balance of the account
     * Sets the balance of the account
     */
    public void setBalance(double balance) {
        super.setBalance(balance);
    }

    /**
     * @return String - interest period
     * Method that returns the interest period
     */
    public String getInterestPeriod() {
        return interestPeriod;
    }

    /**
     * @param interestRate - rate at which the account will gain interest
     * @return void
     * Sets the interest rate of the account
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
    /**
     * @return Covnersion of period to years regardless of unit
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
     * W
     */
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
     * @param accountName - Name of Savings Account to be under
     * @param accountNumber - Savings Account number
     * @param balance - Initial Investment balance
     * @param interestRate - Interest rate of the Savings Account
     * @param interestPeriod - How many times should it be compounded over a period of time
     * @return Message of successful with the account name 
     */
    public String createSavingsAccount(String accountName, String accountNumber, double balance, double interestRate, String interestPeriod) {
        SavingsAccount savingsAccount = new SavingsAccount(accountName, accountNumber, balance, interestRate, interestPeriod);
        if (!Methods.fileExists(accountName, "Savings")) {
            Methods.createFile(accountName, "Savings");
        }
        now = LocalDateTime.now();
        String accountDetails = savingsAccount.toString() + "Account Created at: " + accountCreationDate.format(now) + "\n" + "last updated: " + accountCreationDate.format(now) + "\n";
        Methods.writeToFile(accountName, "Savings", accountDetails);
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
     */

    public void checkAndUpdateSavingsAccount() {
        String accountName = getAccountName();
        String folderPath = "Savings/" + accountName + ".txt";
        File file = new File(folderPath);

        if (file.exists() && file.isFile()) {
            String filePath = file.getPath();
            try {
                String content = new String(Files.readAllBytes(Paths.get(filePath)));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
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
                        for (long i = 0; i < periodsPassed; i++) {
                            addInterest();
                        }
                        lastUpdated = lastUpdated.plus(periodsPassed, getChronoUnit());
                        String updatedContent = content.replace("last updated: " + lastUpdated.format(formatter), "last updated: " + currentTime.format(formatter));
                        updatedContent = updatedContent.replaceFirst("Balance: \\d+\\.\\d+", "Balance: " + getBalance());
                        Files.write(Paths.get(filePath), updatedContent.getBytes());
                        String initialCreationTime = parts[0].split("Account Created at: ")[1].split("\n")[0].trim();
                        String accountDetails = super.getAccountName() + "\n" + super.getAccountNumber() + "\n" + "Balance: " + super.getBalance() + "\n" + "Account Created at: " + initialCreationTime + "\n" + "last updated: " + accountCreationDate.format(currentTime) + "\n";
                        Methods.writeToFile(accountName, "Savings", accountDetails);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Folder does not exist at all... wake up");
        }
    }
    
    /**
     * Returns the corresponding {@link ChronoUnit} based on the interest period.
     * The interest period is expected to be one of the following:
     * "BW" - Biweekly, returns {@link ChronoUnit#WEEKS}
     * "M" - Monthly, returns {@link ChronoUnit#MONTHS}
     * "Y" - Yearly, returns {@link ChronoUnit#YEARS}</li>
     * "min" - Minute, returns {@link ChronoUnit#MINUTES}
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
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "Interest Rate: " + interestRate + "\n" + "Appreciation Period: " + interestPeriod + "\n";
    }
}
