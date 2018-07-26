package hometask07.task1;

public final class Account {
    private String id;
    private volatile int balance;

    public Account(String id, int balance) {
        setId(id);
        setBalance(balance);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }


    public boolean doTransaction(int amount) {
        boolean isComplete = false;
        if (Math.abs(amount) <= getBalance()) {
            setNewBalance(getBalance() + amount);
            isComplete = true;
        }
        return isComplete;
    }

    private void setNewBalance(int newBalance) {
        balance = newBalance;
    }
}
