package diggers.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
    }

    @Test
    public void testDeposit() {

        account.deposit(1000);
        assertFalse(account.getStatement().isEmpty());
        assertEquals(1000, account.getStatement().get(0).getBalanceAfterTransaction());
    }

    @Test
    public void testWithdraw() {

        account.deposit(1000);
        account.withdraw(200);
        assertEquals(800, account.getStatement().get(1).getBalanceAfterTransaction());
    }

    @Test
    public void testInsufficientFunds() {

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100);
        });
    }

    @Test
    public void testWithdrawNegativeAmount() {

        account.deposit(1000);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-100);
        });
    }

    @Test
    public void testGetStatement() {
        // Arrange
        account.deposit(1000);
        account.withdraw(200);
        account.deposit(500);

        // Act
        List<Transaction> statement = account.getStatement();

        // Assert
        assertEquals(3, statement.size());
        assertEquals(1000, statement.get(0).getBalanceAfterTransaction());
        assertEquals(800, statement.get(1).getBalanceAfterTransaction());
        assertEquals(1300, statement.get(2).getBalanceAfterTransaction());

        // Check the amounts
        assertEquals(1000, statement.get(0).getAmount());
        assertEquals(-200, statement.get(1).getAmount());
        assertEquals(500, statement.get(2).getAmount());
    }

    @Test
    public void testPrintStatement() {
        // Create example transactions
        Date date1 = new Date();
        Date date2 = new Date();
        account.deposit(1000); // Depositing 1000, balance should be 1000
        account.withdraw(200); // Withdrawing 200, balance should be 800

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);

        // Call printStatement method with the captured PrintStream
        account.printStatement(printStream);

        // Expected output format
        String expectedOutput = "Date\t\t\tAmount\t\tBalance" + System.lineSeparator() +
                date1 + "\t1000.0\t\t1000.0" + System.lineSeparator() +
                date2 + "\t-200.0\t\t800.0" + System.lineSeparator();

        // Compare expected output to actual output
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

}