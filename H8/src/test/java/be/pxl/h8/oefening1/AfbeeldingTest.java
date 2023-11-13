package be.pxl.h8.oefening1;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H8", exerciseCode = "Oefening 1 - File System", sourceCodeRelativeFilePaths = "Afbeelding.java")
public class AfbeeldingTest {

    @Test
    @DisplayName("Afbeelding - moet overerven van Bestand")
    public void testAfbeeldingIsBestand() {
        Afbeelding a = new Afbeelding("test.png", new int[]{10, 10});
        assertTrue(a instanceof Bestand);
    }

    @Test
    @DisplayName("Afbeelding - moet Uitvoerbaar implementeren")
    public void testAfbeeldingIsUitvoerbaar() {
        Afbeelding a = new Afbeelding("test.png", new int[]{10, 10});
        assertTrue(a instanceof Uitvoerbaar);
    }

    @Test
    @DisplayName("Afbeelding - naam eigenschap")
    public void testAfbeeldingNaam() {
        Afbeelding a = new Afbeelding("test.png", new int[]{10, 10});
        assertEquals("test.png", a.getNaam());
    }

    @Test
    @DisplayName("Afbeelding - bestandsgrootte")
    public void testAfbeeldingBestandsGrootte() {
        Afbeelding a = new Afbeelding("test.png", new int[]{10, 10});
        assertEquals(300, a.getBestandsGrootte());
    }
}