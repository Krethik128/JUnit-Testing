import com.gevernova.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        // Initialize bankAccount once before each test
        bankAccount = new BankAccount();
    }

    // Positive Test Cases

    @Test
    void testDeposit() {
        bankAccount.deposit(10);
        assertEquals(10, bankAccount.getBalance(), "Balance should be 10 after depositing 10");
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(10);
        bankAccount.withdraw(10);
        assertEquals(0, bankAccount.getBalance(), "Balance should be 0 after withdrawing all funds");
    }

    // Negative Test Cases

    @Test
    void testWithdrawWithInsufficientFunds() {
        bankAccount.deposit(10);
        assertThrows(IllegalArgumentException.class,
                () -> bankAccount.withdraw(100),
                "Withdrawing more than the balance should throw IllegalArgumentException");
    }

    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> bankAccount.deposit(-5),
                "Depositing negative amount should throw IllegalArgumentException");
    }

    @Test
    void testWithdrawNegativeAmount() {
        bankAccount.deposit(20);
        assertThrows(IllegalArgumentException.class,
                () -> bankAccount.withdraw(-10),
                "Withdrawing negative amount should throw IllegalArgumentException");
    }
}