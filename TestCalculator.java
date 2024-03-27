import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.stream.Stream;

public class TestCalculator {
    private Calculator calculator;
    private int testNum1;
    private int testNum2;
    private ArrayList<Integer> testNums = new ArrayList<>();
    
    @BeforeEach
    void initCalculator() {
        testNum1 = 90;
        testNum2 = 80;
        testNums.add(90);
        testNums.add(80);
        testNums.add(70);
        testNums.add(60);
        calculator = new Calculator(testNum1, testNum2);
    }
    
    @Test
    void sum() {
        assertEquals(170, calculator.sum());
    }
    
    @Test
    void sumMaxIntegerWithOne() {
        calculator.setNum1(Integer.MAX_VALUE);
        calculator.setNum2(1);
        assertEquals(Integer.MIN_VALUE, calculator.sum());
    }
    
    @Test
    void sumMinIntegerWithMinusOne() {
        calculator.setNum1(Integer.MIN_VALUE);
        calculator.setNum2(-1);
        assertEquals(Integer.MAX_VALUE, calculator.sum());
    }
    
    @Test
    void sumMaxIntegerWithMinInteger() {
        calculator.setNum1(Integer.MAX_VALUE);
        calculator.setNum2(Integer.MIN_VALUE);
        assertEquals(-1, calculator.sum());
    }
    
    // Проверяет также, как и предыдущие тесты, только для метода sum(int num1, int num2)
    @ParameterizedTest
    @MethodSource("numsAndExpectedResultsProvider")
    void sumWithoutCalculatorFields(int expectedResult, int num1, int num2) {
        assertEquals(expectedResult, calculator.sum(num1, num2));
    }
    
    private static Stream<Arguments> numsAndExpectedResultsProvider() {
        return Stream.of(
            Arguments.of(170, 90, 80),
            Arguments.of(Integer.MIN_VALUE, Integer.MAX_VALUE, 1),
            Arguments.of(Integer.MAX_VALUE, Integer.MIN_VALUE, -1),
            Arguments.of(-1, Integer.MAX_VALUE, Integer.MIN_VALUE)
        );
    }
    
    @Disabled
    @Test
    void sumWhenResultWilBeZero() {
        calculator.setNum1(Integer.MAX_VALUE);
        calculator.setNum2(-Integer.MAX_VALUE);
        assertTrue(calculator.sum() == 0);
    }
    
    @Test
    void sumSeveralNums() {
        calculator.setNums(testNums);
        assertEquals(300, calculator.sum());
    }
    
    @Test
    void testArrayList() {
        calculator.setNums(testNums);
        ArrayList<Integer> tester = new ArrayList<>();
        tester.add(90);
        tester.add(80);
        tester.add(70);
        tester.add(60);
        assertEquals(tester, calculator.getNums());
    }
    
    @Test
    void testNullNums() {
        calculator.setNums(null);
        assertNull(calculator.getNums());
        calculator.sum();
    }
}
