package be.pxl.guts.test;
import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "TEST", exerciseCode = "Test01", sourceCodeRelativeFilePaths = "Calculator.java")
public class CalculatorTest {

    @Test
    @DisplayName("Calculator needs to be able to add numbers")
    public void addShouldReturnSum() {
        int a = 6;
        int b = 7;

        Assertions.assertEquals(13, Calculator.add(a, b), "Calculator.add(6, 7) should return 13.");
    }

    @Test
    @DisplayName("Calculator needs to be able to subtract numbers")
    public void subtractShouldReturnDifference() {
        int a = 9;
        int b = 6;

        Assertions.assertEquals(3, Calculator.subtract(a, b), "Calculator.add(9, 6) should return 3.");
    }
}
