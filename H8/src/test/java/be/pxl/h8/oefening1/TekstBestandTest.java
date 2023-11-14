package be.pxl.h8.oefening1;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H8", exerciseCode = "1 - File System", sourceCodeRelativeFilePaths = "TekstBestand.java")
public class TekstBestandTest {

    @Test
    @DisplayName("TekstBestand - moet overerven van Bestand")
    public void testTekstBestandIsBestand() {
        TekstBestand t = new TekstBestand("");
        assertTrue(t instanceof Bestand);
    }

    @Test
    @DisplayName("TekstBestand - moet Uitvoerbaar implementeren")
    public void testTekstBestandIsUitvoerbaar() {
        TekstBestand t = new TekstBestand("");
        assertTrue(t instanceof Uitvoerbaar);
    }

    @Test
    @DisplayName("TekstBestand - naam eigenschap")
    public void testTekstBestandNaam() {
        TekstBestand t = new TekstBestand("mysongs.txt");
        assertEquals("mysongs.txt", t.getNaam());
    }

    @Test
    @DisplayName("TekstBestand - bestandsgrootte")
    public void testTekstBestandGrootte() {
        TekstBestand t = new TekstBestand("mysongs.txt");
        assertEquals(11, t.getBestandsGrootte());
    }
}
