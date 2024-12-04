import java.util.Calendar;

/**
 * BaseTransaction represents a financial transaction with details such as amount, date, and a unique transaction ID.
 * This class provides methods to retrieve transaction details and apply the transaction to a bank account.
 *
 * - The amount of the transaction must be a valid positive number (>= 0).
 * - The date must not be null and should accurately reflect the time of the transaction.
 * - The transaction ID must be unique for each transaction.
 */
public class BaseTransaction implements TransactionInterface {
    protected double amount;  // The amount for this transaction
    protected Calendar date;  // The date this transaction occurred
    protected String transactionID;  // Unique identifier for the transaction

    /**
     * Constructs a new BaseTransaction object.
     * @param amount the amount for the transaction, should be >= 0
     * @param date the date of the transaction, must not be null
     * @param transactionID the unique ID for the transaction, must not be null
     */
    public BaseTransaction(double amount, Calendar date, String transactionID) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be greater than or equal to 0");
        }
        if (date == null || transactionID == null) {
            throw new IllegalArgumentException("Date and transaction ID must not be null");
        }
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    /**
     * Returns the amount of the transaction.
     * @return the amount of the transaction
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the date of the transaction.
     * @return the date of the transaction as a Calendar object
     */
    @Override
    public Calendar getDate() {
        return (Calendar) date.clone();  
    }

    /**
     * Returns the unique transaction ID.
     * @return the transaction ID as a String
     */
    @Override
    public String getTransactionID() {
        return transactionID;
    }

    
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    /**
     * Applies the transaction to the specified bank account.
     * - The bank account balance should be updated according to the transaction (e.g., deposit or withdrawal).
     *
     * @param ba the BankAccount to apply the transaction to
     */
    public void apply(BankAccount ba) {
        if (ba == null) {
            throw new IllegalArgumentException("BankAccount must not be null");
        }
        System.out.println("Applying transaction...");
    }
}
