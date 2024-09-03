package diggers.kata;

import java.util.Scanner;

public class BankingController {

    private final Account account;
    private final Scanner scanner;

    public BankingController(Account account, Scanner scanner) {
        this.account = account;
        this.scanner = scanner;
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getChoice();
            running = executeChoice(choice);
        }
    }

    private void printMenu() {
        System.out.println("Banking Application Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Print Statement");
        System.out.println("4. Exit");
    }

    private int getChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private boolean executeChoice(int choice) {
        System.out.print(System.lineSeparator());
        switch (choice) {
            case 1:
                handleDeposit();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println("Exiting the application.");
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    private void handleDeposit() {
        System.out.print("Enter deposit amount: ");
        int amount = scanner.nextInt();
        account.deposit(amount);
        System.out.print(System.lineSeparator());
        System.out.println("Deposit successful.");
    }

}
