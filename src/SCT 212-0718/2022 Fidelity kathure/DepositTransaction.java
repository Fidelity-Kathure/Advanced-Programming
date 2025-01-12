import java.util.Calendar;




public class DepositTransaction extends BaseTransaction {

    /**
     * Constructs a new DepositTransaction object.
     * @param amount the amount to be deposited, must be > 0
     * @param date the date of the deposit, must not be null
     * @param transactionID the unique ID for the transaction, must not be null
     */
    public DepositTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }
    }

    /**
     * Applies the deposit transaction to the specified bank account by increasing the balance.
     *
     * Preconditions:
     * - The BankAccount provided must not be null.
     * - The amount to be deposited must be greater than 0 (checked in the constructor).
     *
     * Postcondition:
     * - The bank account balance is increased by the amount of the deposit.
     * - A message is printed confirming the deposit and the amount.
     *
     * @param ba the BankAccount to apply the deposit to
     */
    @Override
    public void apply(BankAccount ba) {
        if (ba == null) {
            throw new IllegalArgumentException("BankAccount must not be null");
        }
        ba.deposit(amount);
        System.out.println("Deposit successful: " + amount);
    }
}
