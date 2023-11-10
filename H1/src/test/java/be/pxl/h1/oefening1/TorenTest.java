package be.pxl.h1.oefening1;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H1", exerciseCode = "Oefening 1 - Toren", sourceCodeRelativeFilePaths = "Toren.java")
public class TorenTest {

    @Test
    @DisplayName("Toren - naam eigenschap")
    public void testGetNaam() {
        Toren toren = new Toren();
        toren.setNaam("Toren A");

        assertEquals("Toren A", toren.getNaam());
    }

    @Test
    @DisplayName("Toren - voltooid eigenschap")
    public void testGetVoltooid() {
        Toren toren = new Toren();
        toren.setVoltooid(2023);

        assertEquals(2023, toren.getVoltooid());
    }

    @Test
    @DisplayName("Toren - locatie eigenschap")
    public void testGetLocatie() {
        Toren toren = new Toren();
        toren.setLocatie("Stad X");

        assertEquals("Stad X", toren.getLocatie());
    }

    @Test
    @DisplayName("Toren - hoogte eigenschap")
    public void testGetHoogte() {
        Toren toren = new Toren();
        toren.setHoogte(300.5);

        assertEquals(300.5, toren.getHoogte(), 0.01);
    }

    @Test
    @DisplayName("Toren - verdiepingen eigenschap")
    public void testGetVerdiepingen() {
        Toren toren = new Toren();
        toren.setVerdiepingen(50);

        assertEquals(50, toren.getVerdiepingen());
    }

    @Test
    @DisplayName("Toren - afbeelding eigenschap")
    public void testGetAfbeelding() {
        Toren toren = new Toren();
        toren.setAfbeelding("toren_afbeelding.jpg");

        assertEquals("toren_afbeelding.jpg", toren.getAfbeelding());
    }
}