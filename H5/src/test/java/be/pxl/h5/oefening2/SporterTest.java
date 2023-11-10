package be.pxl.h5.oefening2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "Oefening 2 - Sporters", sourceCodeRelativeFilePaths = "Sporter.java")
public class SporterTest {
    @Test
    @DisplayName("Sporter - Constructor met 2 parameters moet naam opslaan")
    public void testConstructorMet2Parameters() {
        Sporter sporter = new Sporter("Janssen", "Kurt");
        assertTrue("Kurt".equalsIgnoreCase(sporter.getVoornaam()));
        assertTrue("Janssen".equalsIgnoreCase(sporter.getNaam()));
        assertEquals("onbepaald", sporter.getOmschrijving());
    }

    @Test
    @DisplayName("Sporter - Constructor met 3 parameters moet naam en sport opslaan")
    public void testConstructorMet3Parameters() {
        Sporter sporter = new Sporter("Janssen", "Kurt", "Basketbal");
        assertTrue("Kurt".equalsIgnoreCase(sporter.getVoornaam()));
        assertTrue("Janssen".equalsIgnoreCase(sporter.getNaam()));
        assertTrue("Basketbal".equalsIgnoreCase(sporter.getOmschrijving()));
    }

    @Test
    @DisplayName("Sporter - Totaal aantal sporter instanties moet opgevraagd kunnen worden")
    public void testCountSporterObjecten() {
        int before = Sporter.getAantal();
        new Sporter("", "");
        new Sporter("", "");
        new Persoon("", "");
        int later = Sporter.getAantal();
        assertEquals(2, later - before);
    }
}
