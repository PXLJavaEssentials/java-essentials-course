package be.pxl.h6.oefening2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H6", exerciseCode = "2 - Kaartspel", sourceCodeRelativeFilePaths = "Waarde.java")
public class WaardeTest {

    @Test
    @DisplayName("Waarde - should contain all card values")
    public void testCorrectNumberOfCardValues() {
        assertEquals(13, Waarde.values().length);
    }

    @Test
    @DisplayName("Waarde - should be ordered from 2 to ace")
    public void testCorrectOrderOfCardValues() {
        assertEquals(Waarde.TWEE, Waarde.values()[0]);
        assertEquals(Waarde.DRIE, Waarde.values()[1]);
        assertEquals(Waarde.VIER, Waarde.values()[2]);
        assertEquals(Waarde.VIJF, Waarde.values()[3]);
        assertEquals(Waarde.ZES, Waarde.values()[4]);
        assertEquals(Waarde.ZEVEN, Waarde.values()[5]);
        assertEquals(Waarde.ACHT, Waarde.values()[6]);
        assertEquals(Waarde.NEGEN, Waarde.values()[7]);
        assertEquals(Waarde.TIEN, Waarde.values()[8]);
        assertEquals(Waarde.BOER, Waarde.values()[9]);
        assertEquals(Waarde.DAME, Waarde.values()[10]);
        assertEquals(Waarde.HEER, Waarde.values()[11]);
        assertEquals(Waarde.AAS, Waarde.values()[12]);
    }
}
