import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        Calendar date = Calendar.getInstance();

        // Create DepositTransaction
        DepositTransaction deposit = new DepositTransaction(500.0, date, "D123");
        deposit.apply(account);
        deposit.printTransactionDetails();

        // Create WithdrawalTransaction
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(300.0, date, "W456");
        withdrawal.apply(account);
        withdrawal.printTransactionDetails();

        // Test reversal of withdrawal
        withdrawal.reverse(account);

        // Try to reverse deposit
        deposit.reverse(account);

        System.out.println("Final Balance: " + account.getBalance());
    }
}
