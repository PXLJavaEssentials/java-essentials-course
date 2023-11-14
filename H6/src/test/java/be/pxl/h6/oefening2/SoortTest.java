package be.pxl.h6.oefening2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H6", exerciseCode = "2 - Kaartspel", sourceCodeRelativeFilePaths = "Soort.java")
public class SoortTest {

    public static final List<String> otherList = Arrays.asList("HARTEN", "RUITEN", "SCHOPPEN", "KLAVEREN");

    @Test
    @DisplayName("Waarde - should contain exactly 4 card colors")
    public void testCorrectNumberOfCardColors() {
        assertEquals(4, Soort.values().length);
    }

    @Test
    @DisplayName("Waarde - should contain only valid card colors")
    public void testCorrectNumberOfCardValues() {
        for(Soort s:Soort.values()) {
            assertTrue(otherList.contains(s.name()));
        }
    }
}
