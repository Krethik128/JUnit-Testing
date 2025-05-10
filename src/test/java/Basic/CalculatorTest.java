package Basic;

import org.example.basic.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
        Calculator calc=new Calculator();

        @Test
        public void testAdd() {
            assertEquals(5, calc.add(2, 3));
        }
        @Test
        public void testSubtract() {
            assertEquals(1, calc.subtract(4, 3));
        }

        @Test
        public void testMultiply() {
            assertEquals(12, calc.multiply(3, 4));
        }

        @Test
        public void testDivide() {
            assertEquals(2, calc.divide(10, 5));
        }

        // Bonus: Test division by zero
        @Test
        public void testDivideByZero() {
            Exception exception = assertThrows(ArithmeticException.class, () -> {
                calc.divide(5, 0);
            });
            assertEquals("Division by zero is not allowed", exception.getMessage());
        }
}
