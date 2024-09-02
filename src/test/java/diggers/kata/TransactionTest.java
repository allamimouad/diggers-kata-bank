package diggers.kata;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class TransactionTest {

    @Test
    public void testTransactionCreation() {
        Date date = new Date();
        double amount = 100.0;
        double balanceAfterTransaction = 1000.0;

        Transaction transaction = new Transaction(date, amount, balanceAfterTransaction);

        assertEquals(date, transaction.getDate());
        assertEquals(amount, transaction.getAmount());
        assertEquals(balanceAfterTransaction, transaction.getBalanceAfterTransaction());
    }
}