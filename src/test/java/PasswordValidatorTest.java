import com.gevernova.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Strong1Pass"));
    }

    @Test
    void testTooShortPassword() {
        assertFalse(PasswordValidator.isValid("S1p"));
    }

    @Test
    void testMissingUppercase() {
        assertFalse(PasswordValidator.isValid("strong123"));
    }

    @Test
    void testMissingDigit() {
        assertFalse(PasswordValidator.isValid("StrongPass"));
    }
}
