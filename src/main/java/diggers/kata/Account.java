package diggers.kata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactions;

    public Account() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {

    }

    public List<Transaction> getStatement() {
        return null;
    }
}
