import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    /**
     * Constructs a new WithdrawalTransaction object.
     * @param amount the amount to be withdrawn, must be > 0
     * @param date the date of the withdrawal, must not be null
     * @param transactionID the unique ID for the transaction, must not be null
     */
    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        }
    }

    /**
     * Applies the withdrawal transaction to the specified bank account by decreasing the balance.
     *
     * Preconditions:
     * - The BankAccount provided must not be null.
     * - The amount to be withdrawn must be greater than 0 (checked in the constructor).
     * - The account must have sufficient funds for the withdrawal.
     * @param ba the BankAccount to apply the withdrawal to
     */
    @Override
    public void apply(BankAccount ba) {
        if (ba == null) {
            throw new IllegalArgumentException("BankAccount must not be null");
        }
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

    /**
     * Reverses the withdrawal by depositing the same amount back to the bank account.
     * @param ba the BankAccount to reverse the withdrawal on
     * @return true if the reversal is successful
     */
    @Override
    public boolean reverse(BankAccount ba) {
        if (ba == null) {
            throw new IllegalArgumentException("BankAccount must not be null");
        }
        ba.deposit(amount);
        System.out.println("Withdrawal reversed: " + amount);
        return true;
    }
}
