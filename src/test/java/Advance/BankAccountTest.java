package Advance;

import org.example.advance.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    BankAccount account;
    @BeforeEach void setup(){
        account=new BankAccount();
    }
    @Test
    void testDepositBalance() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
        System.out.print("Test is executed");
    }
    @Test
    void testWithdrawBalance() {
        account.deposit(200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance());
    }
    @Test
    void testThrowsIfInsufficientFunds() {
        account.deposit(50.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0));
    }
}
