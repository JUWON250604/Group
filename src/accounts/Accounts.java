package accounts;

public class Accounts {
    private float balance;

    public Accounts() {
        this.balance = 100000;
    }

    public float withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
    }else {
        }
        return amount;
    }
        public float getBalance() {
            return balance;
        }

}