package be.pxl.h8.oefening2;
import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H8", exerciseCode = "2 - Zeeslag", sourceCodeRelativeFilePaths = "Schip.java")
public class SchipTest {

    @Test
    @DisplayName("Schip - Constructor moet alle waarden correct opslaan")
    public void testSchip_Constructor() {
        Schip schip = new Schip(1,2,Alliantie.NOORD,100,5);

        assertEquals(1, schip.getLocatie().getX());
        assertEquals(2, schip.getLocatie().getY());
        assertEquals(Alliantie.NOORD, schip.getAlliantie());
        assertEquals(100, schip.getLevenspunten());
    }

    @Test
    @DisplayName("Schip - beweegNaar verandert locatie van schip bij geldige locatie")
    public void testSchip_BeweegNaarVerandertLocatieBijGeldigeLocatie() {
        Schip schip = new Schip(1,2,Alliantie.NOORD,100,5);
        Punt target = new Punt(3,3);
        schip.beweegNaar(target);

        assertEquals(3, schip.getLocatie().getX());
        assertEquals(3, schip.getLocatie().getY());
    }

    @Test
    @DisplayName("Schip - beweegNaar verandert locatie van schip niet bij nul levenspunten")
    public void testSchip_BeweegNaarVerandertLocatieNietBijNulLevenspunten() {
        Schip schip = new Schip(1,2,Alliantie.NOORD,0,5);
        Punt target = new Punt(3,3);
        schip.beweegNaar(target);

        assertEquals(1, schip.getLocatie().getX());
        assertEquals(2, schip.getLocatie().getY());
    }

    @Test
    @DisplayName("Schip - beweegNaar verandert locatie van schip niet als afstand groter is dan snelheid")
    public void testSchip_BeweegNaarVerandertLocatieNietAlsDoelBuitenBereikIs() {
        Schip schip = new Schip(1,2,Alliantie.NOORD,100,5);
        Punt target = new Punt(30,30);
        schip.beweegNaar(target);

        assertEquals(1, schip.getLocatie().getX());
        assertEquals(2, schip.getLocatie().getY());
    }

    @Test
    @DisplayName("Schip - toString moet locatie en levenspunten bevatten")
    public void testSchip_ToString() {
        Schip schip = new Schip(1,2,Alliantie.NOORD,100,5);

        assertTrue(schip.toString().contains(schip.getLocatie().toString()));
        assertTrue(schip.toString().contains("100"));
    }
}
