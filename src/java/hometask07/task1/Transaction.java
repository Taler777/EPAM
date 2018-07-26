package hometask07.task1;

public final class Transaction extends Thread {
    Account fromAccount;
    Account toAccount;
    int amount;

    public static void main(String[] args) {
        Account acc1 = new Account("#1", 100);
        Account acc2 = new Account("#2", 300);

        Thread t1 = new Transaction(acc1, acc2, 150);
        Thread t2 = new Transaction(acc1, acc2, 50);
        Thread t3 = new Transaction(acc1, acc2, 50);
        Thread t4 = new Transaction(acc1, acc2, 50);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Transaction(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName() + " начал работу");
        boolean isComplete = false;
        synchronized (fromAccount) {
            //System.out.println(Thread.currentThread().getName() + " готов списать $");
            isComplete = fromAccount.doTransaction(-amount);

            if (isComplete) {
                System.out.println(fromAccount.getId() + " balance: " + fromAccount.getBalance());
                synchronized (toAccount) {
                    isComplete = toAccount.doTransaction(amount);
                    System.out.println(toAccount.getId() + " balance: " + toAccount.getBalance());
                }
                if (!isComplete) {
                    fromAccount.doTransaction(-amount);
                    System.out.println("Transactions is not complete.");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Not enough money. Come tomorrow.");
            }
        }
    }
}
