package diggers.kata;

import java.util.List;

public class TransactionHistoryPrinter {

    public static void print(List<Transaction> transactions) {
        System.out.println("Date\t\t\tAmount\t\tBalance");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDate() + "\t" +
                    transaction.getAmount() + "\t\t" +
                    transaction.getBalanceAfterTransaction());
        }
    }
}
