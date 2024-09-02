package diggers.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}