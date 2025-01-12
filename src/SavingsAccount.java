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
     * interest - the amount of interest the account has gained
     */
    private double interest;
    /**
     * interestPeriod - the period at which the account will gain interest
     */
    private double interestPeriod;
    /**
     * scheduler - the scheduler to schedule interest appreciation
     */
    // private Timer timer = new Timer();

    /**
     * @param accountName - name of the account
     * @param accountNumber - number of the account
     * @param balance - balance of the account
     * @param interestRate - rate at which the account will gain interest
     * @return void
     * Constructor for the SavingsAccount class
     */
    public SavingsAccount(String accountName, String accountNumber, double balance, double interestRate, double interestPeriod) {
        super(accountName, accountNumber, balance);
        this.interestRate = interestRate;
        this.interest = 0.0;
        this.interestPeriod = interestPeriod;
        // startInterestAppreciation();
    }
    /**
     * @return double
     * Returns the interest rate of the account
     */
    public double getInterestRate() {
        return interestRate;
    }
    /**
     * @return double
     * Returns the interest of the account
     */
    public double getInterest() {
        return interest;
    }
    /**
     * @return String
     * Returns the account name
     */
    public String getAccountName() {
        return super.getAccountName();
    }
    /**
     * @return String
     * Returns the account number
     */
    public String getAccountNumber() {
        return super.getAccountNumber();
    }
    /**
     * @return double
     * Returns the balance of the account
     */
    public double getBalance() {
        return super.getBalance();
    }
    /**
     * @param accountName - name of the account
     * @return void
     * Sets the account name
     */
    public void setAccountName(String accountName) {
        super.setAccountName(accountName);
    }
    /**
     * @param accountNumber - number of the account
     * @return void
     * Sets the account number
     */
    public void setAccountNumber(String accountNumber) {
        super.setAccountNumber(accountNumber);
    }
    /**
     * @param balance - balance of the account
     * @return void
     * Sets the balance of the account
     */
    public void setBalance(double balance) {
        super.setBalance(balance);
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
     * @param interest - amount of interest the account has gained
     * @return void
     * Sets the interest of the account
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }
    /**
     * @return void
     * Adds interest to the account
     */
    public void addInterest() {
        interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }
    public double getInterestPeriod() {
        return interestPeriod;
    }
    public void setInterestPeriod(double interestPeriod) {
        this.interestPeriod = interestPeriod;
    }
    /**
     * @param directoryName - name of the directory
     * @param accountName - name of the account
     * @param accountNumber - number of the account
     * @param balance - balance of the account
     * @param interestRate - rate at which the account will gain interest
     * @return String
     * Creates a savings account with the given parameters
     */
    public String createSavingsAccount(String directoryName, String accountName, String accountNumber, double balance, double interestRate, double interestPeriod) {
        SavingsAccount savingsAccount = new SavingsAccount(accountName, accountNumber, balance, interestRate, interestPeriod);
        if (!Methods.fileExists(accountName, directoryName)) {
            Methods.createFile(accountName, directoryName);
        }
        Methods.writeToFile(accountName, directoryName, savingsAccount.toString());
        super.addAccountTypes("Savings");
        return "Successfully created or updated " + accountName;
    }
    /**
     * @return String
     * Returns the string representation of the savings account
     */
    @Override
    public String toString() {
        return super.toString() + "Interest Rate: " + interestRate + "\n" + "Interest: " + interest + "\n";
    }
    

    // /**
    //  * @return void
    //  * Starts the interest appreciation
    //  */
    // /**
    //  * @return void
    //  * Updates the balance based on the last interest application date
    //  */
    // public void updateBalanceBasedOnLastInterestDate() {
    //     String lastUpdate = Methods.readInFile(getAccountName(), "lastUpdate.txt");
    //     if (lastUpdate != null && !lastUpdate.isEmpty()) {
    //         LocalDateTime lastUpdateDate = LocalDateTime.parse(lastUpdate);
    //         LocalDateTime currentDate = LocalDateTime.now();
    //         long daysBetween = ChronoUnit.DAYS.between(lastUpdateDate, currentDate);
    //         if (daysBetween >= interestPeriod) {
    //             addInterest();
    //             Methods.writeToFile(getAccountName(), "lastUpdate.txt", currentDate.toString());
    //         }
    //     } else {
    //         Methods.writeToFile(getAccountName(), "lastUpdate.txt", LocalDateTime.now().toString());
    //     }
    // }
    // private void startInterestAppreciation() {
    //     timer.scheduleAtFixedRate(new TimerTask() {
    //         @Override
    //         public void run() {
    //         addInterest();
    //         }
    //     }, 0L, (long) (interestPeriod * 1000));
    // }
    
}
