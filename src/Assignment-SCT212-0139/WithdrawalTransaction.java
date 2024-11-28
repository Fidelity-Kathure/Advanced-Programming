import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) {
        try {
            if (ba.getBalance() < amount) {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }
            ba.withdraw(amount);
            System.out.println("Withdrawal successful: " + amount);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean reverse(BankAccount ba) {
        ba.deposit(amount);
        System.out.println("Withdrawal reversed: " + amount);
        return true;
    }
}
