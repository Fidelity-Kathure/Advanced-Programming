import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {

    public DepositTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) {
        ba.deposit(amount);
        System.out.println("Deposit successful: " + amount);
    }

    @Override
    public boolean reverse(BankAccount ba) {
        System.out.println("Deposits cannot be reversed.");
        return false;
    }
}
