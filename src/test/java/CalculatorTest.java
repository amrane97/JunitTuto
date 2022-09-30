import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.function.Predicate.isEqual;
import static junit.framework.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;
    private static Instant startedAt;

    @BeforeEach
    void createInstanceCalculator() {
        calculator = new Calculator();

    }



    @BeforeAll
    static void debutDesTests() {
        startedAt = Instant.now();
        System.out.println("les tests debutent maintenant: "+ startedAt);
    }
    @AfterAll
    public static void FinDesTests() {
        final Instant endedAt = Instant.now();
        final long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println("les tests sont finis maintenant: "+ endedAt);
    }

    @Test
    void testAddTwoPositiveNumbers() {
        //ARRANGE
        int a = 2;
        int b = 3;


        //ACT
        int somme = this.calculator.add(a, b);

        //ASSERTS
        // un seul assert par test est conseiller par les developpeurs
        assertThat(somme).isEqualTo(5);
    }

    @Test
    void testMultiplyTwoPositiveNumbers() {
        int a = 3;
        int b = 2;

        int results = this.calculator.multiply(a, b);

        assertThat(results).isEqualTo(6);
    }
    @ParameterizedTest(name = "{0} x 0 doit etre egal à 0")
    @ValueSource(ints = {1, 30 , -5, 123859})
    public void testMultiplyByZero(int arg) {

        int results = this.calculator.multiply(arg, 0);

        assertEquals(0, results);
    }

    @ParameterizedTest
    @CsvSource({"1,1,2", "3, 5, 8", "-6, 4, -2", "1028, 3000, 4028"})
    void testAddMultiplePositiveNumbers(int arg1, int arg2, int expectResults) {

        //ACT
        int actualResults = this.calculator.add(arg1, arg2);

        //ASSERTS
        // un seul assert par test est conseiller par les developpeurs
        assertEquals(expectResults, actualResults);
    }

    @Test
    @Timeout(1)
    public void testLongCalcule() {

        this.calculator.longCalculation();
    }

    @Test
    public void testExtractEachNumber() {
        //GIVEN
        int number = 95872;

        //WHEN
        Set<Integer> actual = this.calculator.extractEachNumber(number);

        //THEN
        assertThat(actual).containsExactly(2,5,7,8,9);
    }

    @Test
    public void testExtractEachNumber2() {
        //GIVEN
        int number = 45932;
        //WHEN
        Set<Integer> actual = this.calculator.extractEachNumber(number);
        //THEN
        Set<Integer> expected = actual.stream().collect(Collectors.toSet());
        assertEquals(actual, expected);
    }

    @Test
    public void testExtractEachNumberZero() {
        //GIVEN
        int number = 0;
        //WHEN
        Set<Integer> actual = this.calculator.extractEachNumber(number);
        //THEN
        assertThat(actual).containsExactly(0);
    }
    @Test
    public void testExtractEachNumberNegative() {
        //GIVEN
        int number = -32540;
        //WHEN
        Set<Integer> actual = this.calculator.extractEachNumber(number);
        //THEN
        assertThat(actual).containsExactly(0, 2, 3,4,5);
    }

    @Test
    public void testAddDoubles() {
        //GIVE
        double a = 2.2;
        double b = 1.4;
        //WHEN
        double actual = this.calculator.add(a, b);
        //THEN
        assertThat(actual).isEqualTo(3.6);
    }

    @Test
    public void testMultiplyDoubles() {
        //GIVE
        double a = 2.2;
        double b = 1.4;
        //WHEN
        double actual = this.calculator.multiply(a, b);
        //THEN
        assertThat(actual).isEqualTo(3.08);
    }
}
