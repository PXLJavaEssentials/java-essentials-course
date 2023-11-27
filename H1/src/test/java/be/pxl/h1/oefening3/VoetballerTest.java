package be.pxl.h1.oefening3;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H1", exerciseCode = "Oefening 3 - Voetbal", sourceCodeRelativeFilePaths = "Voetballer.java")
public class VoetballerTest {

    @Test
    @DisplayName("Voetballer - test alle getters en setters")
    public void testSettersAndGetters() {
        Voetballer voetballer = new Voetballer();
        voetballer.setNaam("Lionel Messi");
        voetballer.setBeoordeling(9);
        voetballer.setLeeftijd(34);
        voetballer.setPositie("Aanvaller");
        voetballer.setDoelpunten(30);

        assertEquals("Lionel Messi", voetballer.getNaam());
        assertEquals(9, voetballer.getBeoordeling());
        assertEquals(34, voetballer.getLeeftijd());
        assertEquals("Aanvaller", voetballer.getPositie());
        assertEquals(30, voetballer.getDoelpunten());
    }

    @Test
    @DisplayName("Voetballer - Prijs - Aanvaller onder 25 jaar, minder dan 5 doelpunten")
    public void testGetPrijs_Aanvaller_MinderDan25Jaar_MinderDan5Doelpunten() {
        Voetballer voetballer = new Voetballer();
        voetballer.setPositie("Aanvaller");
        voetballer.setLeeftijd(22);
        voetballer.setDoelpunten(3);
        voetballer.setBeoordeling(8);

        assertEquals(63000, voetballer.getPrijs(), 0.01);
    }

    @Test
    @DisplayName("Voetballer - Prijs - Middenvelder ouder dan 30 jaar")
    public void testGetPrijs_Middenvelder_OuderDan30Jaar() {
        Voetballer voetballer = new Voetballer();
        voetballer.setPositie("Middenvelder");
        voetballer.setLeeftijd(32);
        voetballer.setDoelpunten(5);
        voetballer.setBeoordeling(7);

        assertEquals(96600, voetballer.getPrijs(), 0.01);
    }

    @Test
    @DisplayName("Voetballer - Prijs - Verdediger tussen 25 en 30 jaar")
    public void testGetPrijs_Verdediger_Tussen25en30Jaar() {
        Voetballer voetballer = new Voetballer();
        voetballer.setPositie("Verdediger");
        voetballer.setLeeftijd(25);
        voetballer.setDoelpunten(8);
        voetballer.setBeoordeling(6);

        assertEquals(89000, voetballer.getPrijs(), 0.01);
    }

    @Test
    @DisplayName("Voetballer - Prijs - Doelman tussen 25 en 30 jaar, 20 doelpunten")
    public void testGetPrijs_Doelman_20Doelpunten() {
        Voetballer voetballer = new Voetballer();
        voetballer.setPositie("Doelman");
        voetballer.setLeeftijd(28);
        voetballer.setDoelpunten(20);
        voetballer.setBeoordeling(8);

        assertEquals(96000, voetballer.getPrijs(), 0.01);
    }
}
