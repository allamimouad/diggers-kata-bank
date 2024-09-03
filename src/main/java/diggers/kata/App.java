package diggers.kata;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        Account account = new Account();
        BankingController app = new BankingController(account, new Scanner(System.in));
        app.run();

    }


}
