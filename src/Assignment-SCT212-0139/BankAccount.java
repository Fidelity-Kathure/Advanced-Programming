public class BankAccount {
    private double balance;

    /**
     * Constructor to initialize the bank account with an initial balance.
     * @param initialBalance The initial balance of the account.
     * @throws IllegalArgumentException if initialBalance is negative.
     * Precondition: initialBalance >= 0
     * Postcondition: The balance of the account is set to initialBalance.
     */
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    /**
     * Returns the current balance of the account.
     * Precondition: None
     * Postcondition: The current balance is returned, which should be >= 0.
     * @return The current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param amount The amount to deposit. Must be positive.
     * Precondition: amount > 0
     * Postcondition: The balance is increased by the deposit amount (balance = balance + amount).
     * @throws IllegalArgumentException if the amount is not positive.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    /**
     * @param amount The amount to withdraw. Must be positive and less than or equal to the current balance.
     * Precondition: amount > 0 and amount <= balance
     * Postcondition: The balance is decreased by the withdrawal amount (balance = balance - amount).
     * @throws IllegalArgumentException if the amount is not positive or exceeds the current balance.
     * @throws InsufficientFundsException if there are insufficient funds for the withdrawal.
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
    }
}
