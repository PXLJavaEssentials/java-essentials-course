package be.pxl.h8.oefening2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H8", exerciseCode = "2 - Zeeslag", sourceCodeRelativeFilePaths = "Punt.java")
public class PuntTest {

    @Test
    @DisplayName("Punt - eigenschap x en y moeten opgeslagen worden via constructor")
    public void testPunt_GetX() {
        Punt punt = new Punt(3, 5);
        assertEquals(3, punt.getX());
        assertEquals(5, punt.getY());
    }

    @Test
    @DisplayName("Punt - eigenschap x setter")
    public void testPunt_SetX() {
        Punt punt = new Punt(3, 5);
        punt.setX(8);
        assertEquals(8, punt.getX());
    }

    @Test
    @DisplayName("Punt - eigenschap y setter")
    public void testPunt_SetY() {
        Punt punt = new Punt(3, 5);
        punt.setY(10);
        assertEquals(10, punt.getY());
    }

    @Test
    @DisplayName("Punt - berekenAfstand moet de juiste afstand teruggeven")
    public void testPunt_BerekenAfstand() {
        Punt punt1 = new Punt(1, 1);
        Punt punt2 = new Punt(4, 5);
        assertEquals(5, punt1.berekenAfstand(punt2));
    }

    @Test
    @DisplayName("Punt - maximumgrootte moet 99 zijn")
    public void testPunt_ControleerMaximaleGrootte() {
        assertEquals(99, Punt.MAXIMUMGROOTTE);
    }

    @Test
    @DisplayName("Punt - setX moet rekening houden met max grootte")
    public void testPunt_SetXGelimiteerdOpMaxGrootte() {
        Punt punt = new Punt(3, 5);
        punt.setX(100);
        assertEquals(Punt.MAXIMUMGROOTTE, punt.getX());
    }

    @Test
    @DisplayName("Punt - setY moet rekening houden met max grootte")
    public void testPunt_SetYGelimiteerdOpMaxGrootte() {
        Punt punt = new Punt(3, 5);
        punt.setY(100);
        assertEquals(Punt.MAXIMUMGROOTTE, punt.getY());
    }

    @Test
    @DisplayName("Punt - setX mag geen waarde onder nul isntellen")
    public void testPunt_SetXGelimiteerdOpNul() {
        Punt punt = new Punt(3, 5);
        punt.setX(-1);
        assertEquals(0, punt.getX());
    }

    @Test
    @DisplayName("Punt - setY mag geen waarde onder nul instellen")
    public void testPunt_SetYGelimiteerdOpNul() {
        Punt punt = new Punt(3, 5);
        punt.setY(-1);
        assertEquals(0, punt.getY());
    }

    @Test
    @DisplayName("Punt - toString moet coordinaat correct tonen")
    public void testPunt_ToString() {
        Punt punt = new Punt(3, 5);
        assertEquals("[3, 5]", punt.toString());
    }
}
