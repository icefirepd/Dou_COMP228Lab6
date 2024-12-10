package ATMTransactions;

class Account {
    //First define the private variables for account number and balance
    private double balance;

//constructor to initialize account number and balance
    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    //Create an Account class and implement both deposit and withdraw operations.
    // Synchronize the operations to allow thread synchronization.
    public synchronized boolean withdraw(double amount) {
        if (balance >= amount) { //to determine if the withdrawal amount is less than or equal to the balance
            System.out.println(Thread.currentThread().getName() + " withdrawed $" + amount);
            balance -= amount;
            System.out.println("Current balance after the withdrawal: $" + balance+"\n");
            return true;
        }
        System.out.println("Insufficient funds for " + Thread.currentThread().getName());
        return false;
    }
    public synchronized void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + " deposited $" + amount);
        balance += amount;
        System.out.println("Current balance after the deposit: $" + balance + "\n");
    }
//Getter methods to get the account number and balance
    public double getBalance() {
        return balance;
    }
}
