package be.pxl.h7.oefening3;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H7", exerciseCode = "3 - TypingGame", sourceCodeRelativeFilePaths = "Result.java")
public class ResultTest {

    public static final String NAME = "Guido";
    public static final LocalDateTime DATETIME = LocalDateTime.of(1991, 3, 3, 20, 15, 15);
    public static final double RESULT = 5.15;
    public static final String FILEOUTPUT = "1991-03-03-20:15:15#Guido#5,150";

    @Test
    @DisplayName("Result - Result should be saved to file correctly when using param constructor")
    public void testToFileWithParamConstructor() {
       Result result = new Result(NAME, DATETIME, RESULT);

       assertEquals(RESULT, result.getResult(), 0.001);
       assertEquals(FILEOUTPUT, result.toFile());
    }

    @Test
    @DisplayName("Result - REsult should be saved to file correctly when using array constructor")
    public void testToFileWithArrayConstructor() {
        String data[] = new String[]{"1991-03-03-20:15:15", "Guido", "5.150"};
        Result result = new Result(data);

        assertEquals(RESULT, result.getResult(), 0.001);
        assertEquals(FILEOUTPUT, result.toFile());
    }

}
