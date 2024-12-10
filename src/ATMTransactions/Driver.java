package ATMTransactions;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static void main(String[] args) {
        //first initial the account balance
        Account account = new Account(10000.0);
        //println;
        System.out.println("Initial balance: $" + account.getBalance() + "\n");

       //create and using array list to store transactions
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, "withdraw", 100.0));
        transactions.add(new Transaction(account, "deposit", 900.0));
        transactions.add(new Transaction(account, "withdraw", 5000.0));
        transactions.add(new Transaction(account, "deposit", 3000.0));
        transactions.add(new Transaction( account, "withdraw", 999.0));

        // Create an ExecutorService with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //using for loop to execute all transactions
        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        // Shutdown the executor
        executor.shutdown();

        try {
// Wait for all transactions to complete or 5 seconds
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //final println;
        System.out.println("Final balance: $" + account.getBalance());
    }
}
