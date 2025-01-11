/**
 * Savings account class that extends the Account class and adds an interest rate and interest to the account
 */
public class SavingsAccount extends Account {
    private double interestRate;
    private double interest;

    public SavingsAccount(String accountName, String accountNumber, double balance, double interestRate) {
        super(accountName, accountNumber, balance);
        this.interestRate = interestRate;
        this.interest = 0.0;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public double getInterest() {
        return interest;
    }
    public String getAccountName() {
        return super.getAccountName();
    }
    public String getAccountNumber() {
        return super.getAccountNumber();
    }
    public double getBalance() {
        return super.getBalance();
    }
    public void setAccountName(String accountName) {
        super.setAccountName(accountName);
    }
    public void setAccountNumber(String accountNumber) {
        super.setAccountNumber(accountNumber);
    }
    public void setBalance(double balance) {
        super.setBalance(balance);
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public void setInterest(double interest) {
        this.interest = interest;
    }
    public void addInterest() {
        interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }
    public String createSavingsAccount(String directoryName, String accountName, String accountNumber, double balance, double interestRate) {
        SavingsAccount savingsAccount = new SavingsAccount(accountName, accountNumber, balance, interestRate);
        if (!Methods.fileExists(accountName, directoryName)) {
            Methods.createFile(accountName, directoryName);
        }
        Methods.writeToFile(accountName, directoryName, savingsAccount.toString());
        return "Successfully created or updated " + accountName;
    }
    @Override
    public String toString() {
        return super.toString() + "Interest Rate: " + interestRate + "\n" + "Interest: " + interest + "\n";
    }
    
}
