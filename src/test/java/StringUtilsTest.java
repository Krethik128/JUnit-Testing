import com.gevernova.StringUtility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    StringUtility stringUtility = new StringUtility();

    // Positive test
    @Test
    void testReverse() {
        assertEquals("ahtihkil", stringUtility.reverse("likhitha"));
    }

    //  Negative tests for reverse
    @Test
    void testReverseWithEmptyString() {
        assertEquals("", stringUtility.reverse(""));
    }

    //  Positive test
    @Test
    void testPalindrome() {
        assertTrue(stringUtility.isPalindrome("mom"));
    }

    //  Negative tests for palindrome
    @Test
    void testIsPalindromeFalseCase() {
        assertFalse(stringUtility.isPalindrome("hello"));
    }

    @Test
    void testIsPalindromeWithEmptyString() {
        assertTrue(stringUtility.isPalindrome("")); // Empty string is technically a palindrome
    }

    @Test
    void testIsPalindromeWithNull() {
        assertThrows(NullPointerException.class, () -> stringUtility.isPalindrome(null));
    }

    //  Positive test
    @Test
    void testUpperCase() {
        assertEquals("HI", stringUtility.upperCase("hi"));
    }

    //  Negative tests for uppercase
    @Test
    void testUpperCaseWithEmptyString() {
        assertEquals("", stringUtility.upperCase(""));
    }

    @Test
    void testUpperCaseWithNull() {
        assertThrows(NullPointerException.class, () -> stringUtility.upperCase(null));
    }

    @Test
    void testUpperCaseWithNumbersAndSymbols() {
        assertEquals("123@#ABC", stringUtility.upperCase("123@#abc"));
    }
}
