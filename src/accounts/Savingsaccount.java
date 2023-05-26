package accounts;

public class Savingsaccount extends Accounts {
    private float withdrawalLimit;

    public Savingsaccount() {
        super();
        this.withdrawalLimit = 20000;
    }

    @Override
    public float withdraw(float amount) {
        if (amount <= withdrawalLimit) {
            super.withdraw(amount);
        } else {

        }
        return amount;
    }
}
