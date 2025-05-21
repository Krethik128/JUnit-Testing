import com.gevernova.NumberUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {

    @ParameterizedTest
    @ValueSource(ints ={2,8,6})
    void testEvenNumbers(int number) {
        assertTrue(NumberUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testOddNumbers(int number) {
        assertFalse(NumberUtils.isEven(number));
    }

    //Negative
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 11})
    void testNegativeNumbers(int number) {
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.isEven(number));
    }
}

