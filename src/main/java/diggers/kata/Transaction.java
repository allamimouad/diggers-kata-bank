package diggers.kata;

import java.util.Date;

public class Transaction {
    private Date date;
    private double amount;
    private double balanceAfterTransaction;

    public Transaction(Date date, double amount, double balanceAfterTransaction) {
        this.date = date;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }
}
