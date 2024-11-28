import java.util.Calendar;

public class ConcreteTransaction extends BaseTransaction {

    public ConcreteTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    public void apply(BankAccount ba) {
        System.out.println("Applying transaction...");
    }

    
    public boolean reverse(BankAccount ba) {
        // Implement logic for reversing a transaction if applicable.
        System.out.println("Reversing transaction...");
        return false; // Return true or false based on the logic of your reversal.
    }

   
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }
}
