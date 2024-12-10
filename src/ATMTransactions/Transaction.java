package ATMTransactions;

//Use Java Runnable interface to implement a Transaction class.
public class Transaction implements Runnable {
    private Account account;
    private String transType;
    private double amount;

//constructor to initialize account, transaction type and amount.
    public Transaction(Account account, String transactionType, double amount) {
        this.account = account;
        this.transType = transactionType;
        this.amount = amount;
    }

//Perform withdraw and deposit operations in run method.
    @Override public void run() {
        if (transType.equalsIgnoreCase("withdraw")) {
            account.withdraw(amount);
        } else if (transType.equalsIgnoreCase("deposit")) {
            account.deposit(amount);
        }
    }
}
