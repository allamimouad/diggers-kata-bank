package diggers.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;

public class BankingControllerTest {

    private Account account;
    private Scanner scanner;
    private BankingController controller;

    @BeforeEach
    public void setUp() {
        account = mock(Account.class);
        scanner = mock(Scanner.class);
        controller = new BankingController(account, scanner);
    }

    @Test
    public void testRun_DepositChoice() {
        // Simulate user input for deposit choice, deposit amount, and then exit
        when(scanner.nextInt())
                .thenReturn(1)   // First call for choosing 'Deposit'
                .thenReturn(100) // Second call for the deposit amount
                .thenReturn(4);  // Third call for choosing 'Exit'

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the controller
        controller.run();

        // Verify interactions
        verify(scanner, times(3)).nextInt(); // Verify that scanner.nextInt() is called exactly 3 times
        verify(account, times(1)).deposit(100); // Verify that account.deposit(100) is called once

        // Verify the output
        String expectedOutput = "Banking Application Menu:" + System.lineSeparator() +
                "1. Deposit" + System.lineSeparator() +
                "2. Withdraw" + System.lineSeparator() +
                "3. Print Statement" + System.lineSeparator() +
                "4. Exit" + System.lineSeparator() +
                "Enter your choice: " + System.lineSeparator() +
                "Enter deposit amount: " + System.lineSeparator() +
                "Deposit successful." + System.lineSeparator() +
                "Banking Application Menu:" + System.lineSeparator() +
                "1. Deposit" + System.lineSeparator() +
                "2. Withdraw" + System.lineSeparator() +
                "3. Print Statement" + System.lineSeparator() +
                "4. Exit" + System.lineSeparator() +
                "Enter your choice: " + System.lineSeparator() +
                "Exiting the application." + System.lineSeparator();
        assertEquals(expectedOutput.trim(), outContent.toString().trim());

        // Restore original System.out
        System.setOut(originalOut);
    }

    @Test
    public void testRun_WithdrawChoice() {
        // Simulate user input for withdraw choice, withdraw amount, and then exit
        when(scanner.nextInt())
                .thenReturn(2)   // First call for choosing 'Withdraw'
                .thenReturn(50)  // Second call for the withdraw amount
                .thenReturn(4);  // Third call for choosing 'Exit'

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the controller
        controller.run();

        // Verify interactions
        verify(scanner, times(3)).nextInt(); // Verify that scanner.nextInt() is called exactly 3 times
        verify(account, times(1)).withdraw(50); // Verify that account.withdraw(50) is called once

        // Verify the output
        String expectedOutput = "Banking Application Menu:" + System.lineSeparator() +
                "1. Deposit" + System.lineSeparator() +
                "2. Withdraw" + System.lineSeparator() +
                "3. Print Statement" + System.lineSeparator() +
                "4. Exit" + System.lineSeparator() +
                "Enter your choice: " + System.lineSeparator() +
                "Enter withdrawal amount: " + System.lineSeparator() +
                "Withdrawal successful." + System.lineSeparator() +
                "Banking Application Menu:" + System.lineSeparator() +
                "1. Deposit" + System.lineSeparator() +
                "2. Withdraw" + System.lineSeparator() +
                "3. Print Statement" + System.lineSeparator() +
                "4. Exit" + System.lineSeparator() +
                "Enter your choice: " + System.lineSeparator() +
                "Exiting the application." + System.lineSeparator();
        assertEquals(expectedOutput.trim(), outContent.toString().trim());

        // Restore original System.out
        System.setOut(originalOut);
    }

    @Test
    public void testRun_PrintStatementChoice() {
        // Simulate user input for print statement choice and then exit
        when(scanner.nextInt())
                .thenReturn(3)  // First call for choosing 'Print Statement'
                .thenReturn(4); // Second call for choosing 'Exit'

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the controller
        controller.run();

        // Verify interactions
        verify(scanner, times(2)).nextInt(); // Verify that scanner.nextInt() is called exactly 2 times
        verify(account, times(1)).printStatement(any(PrintStream.class)); // Verify that account.printStatement is called once

        // Verify the output
        String expectedOutput = "Banking Application Menu:" + System.lineSeparator() +
                "1. Deposit" + System.lineSeparator() +
                "2. Withdraw" + System.lineSeparator() +
                "3. Print Statement" + System.lineSeparator() +
                "4. Exit" + System.lineSeparator() +
                "Enter your choice: " + System.lineSeparator() +
                "Account Statement:" + System.lineSeparator() +
                "Banking Application Menu:" + System.lineSeparator() +
                "1. Deposit" + System.lineSeparator() +
                "2. Withdraw" + System.lineSeparator() +
                "3. Print Statement" + System.lineSeparator() +
                "4. Exit" + System.lineSeparator() +
                "Enter your choice: " + System.lineSeparator() +
                "Exiting the application." + System.lineSeparator();
        assertEquals(expectedOutput.trim(), outContent.toString().trim());

        // Restore original System.out
        System.setOut(originalOut);
    }

    @Test
    public void testRun_InvalidChoice() {
        // Simulate user input for an invalid choice and then exit
        when(scanner.nextInt())
                .thenReturn(99)  // First call for an invalid choice
                .thenReturn(4);  // Second call for choosing 'Exit'

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the controller
        controller.run();

        // Verify interactions
        verify(scanner, times(2)).nextInt(); // Verify that scanner.nextInt() is called exactly 2 times

        // Verify the output
        String expectedOutput = "Banking Application Menu:" + System.lineSeparator() +
                "1. Deposit" + System.lineSeparator() +
                "2. Withdraw" + System.lineSeparator() +
                "3. Print Statement" + System.lineSeparator() +
                "4. Exit" + System.lineSeparator() +
                "Enter your choice: " + System.lineSeparator() +
                "Invalid choice. Please try again." + System.lineSeparator() +
                "Banking Application Menu:" + System.lineSeparator() +
                "1. Deposit" + System.lineSeparator() +
                "2. Withdraw" + System.lineSeparator() +
                "3. Print Statement" + System.lineSeparator() +
                "4. Exit" + System.lineSeparator() +
                "Enter your choice: " + System.lineSeparator() +
                "Exiting the application." + System.lineSeparator();
        assertEquals(expectedOutput.trim(), outContent.toString().trim());

        // Restore original System.out
        System.setOut(originalOut);
    }
}

