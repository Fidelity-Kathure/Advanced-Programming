import java.util.Calendar;

public class BaseTransaction implements TransactionInterface {
    protected double amount;
    protected Calendar date;
    protected String transactionID;

    // Constructor
    public BaseTransaction(double amount, Calendar date, String transactionID) {
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    // Common method to print transaction details
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    // Method to apply the transaction (meant to be overridden by subclasses)
    public void apply(BankAccount ba) {
        System.out.println("Applying transaction...");
    }

    // Default reverse method (can be overridden if needed)
    public boolean reverse(BankAccount ba) {
        System.out.println("Reversal not supported for this transaction.");
        return false;
    }
}
