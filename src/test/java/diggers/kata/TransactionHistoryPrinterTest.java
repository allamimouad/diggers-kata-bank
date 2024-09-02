package diggers.kata;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionHistoryPrinterTest {

    @Test
    public void testPrintStatement() {
        // Prepare test data
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(new Date(), 100.0, 1000.0));
        transactions.add(new Transaction(new Date(), -50.0, 950.0));

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Print the statement
        TransactionHistoryPrinter.print(transactions);

        // Restore the original System.out
        System.setOut(System.out);

        // Verify the output
        String output = outputStream.toString();
        assertTrue(output.contains("Date"));
        assertTrue(output.contains("Amount"));
        assertTrue(output.contains("Balance"));
        assertTrue(output.contains("100.0"));
        assertTrue(output.contains("-50.0"));
        assertTrue(output.contains("1000.0"));
        assertTrue(output.contains("950.0"));
    }
}