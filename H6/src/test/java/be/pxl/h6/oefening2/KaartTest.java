package be.pxl.h6.oefening2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H6", exerciseCode = "2 - Kaartspel", sourceCodeRelativeFilePaths = "Kaart.java")
public class KaartTest {

    @Test
    @DisplayName("Kaart - should store color and value correctly when using constructor")
    public void testConstructorValues() {
        Kaart kaart = new Kaart(Soort.SCHOPPEN, Waarde.AAS);
        assertEquals(Soort.SCHOPPEN, kaart.getSoort());
        assertEquals(Waarde.AAS, kaart.getWaarde());
    }

    @Test
    @DisplayName("Kaart - setSoort")
    public void testKaartSetSoort() {
        Kaart kaart = new Kaart(Soort.SCHOPPEN, Waarde.AAS);
        kaart.setSoort(Soort.HARTEN);
        assertEquals(Soort.HARTEN, kaart.getWaarde());
    }

    @Test
    @DisplayName("Kaart - setWaarde")
    public void testKaartSetWaarde() {
        Kaart kaart = new Kaart(Soort.SCHOPPEN, Waarde.AAS);
        kaart.setWaarde(Waarde.BOER)
        assertEquals(Waarde.BOER, kaart.getWaarde());
    }
}
