package be.pxl.h5.oefening2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "2 - Sporters", sourceCodeRelativeFilePaths = "Voetballer.java")
public class VoetballerTest {
    @Test
    @DisplayName("Voetballer - Constructor met 2 parameters moet naam opslaan")
    public void testConstructorMet2Parameters() {
        Voetballer voetballer = new Voetballer("Janssen", "Kurt");
        assertTrue("Kurt".equalsIgnoreCase(voetballer.getVoornaam()));
        assertTrue("Janssen".equalsIgnoreCase(voetballer.getNaam()));
        assertTrue("voetbal".equalsIgnoreCase(voetballer.getOmschrijving()));
        assertEquals("onbepaald", voetballer.getClub());
        assertEquals("onbepaald", voetballer.getOpstelling());
    }

    @Test
    @DisplayName("Voetballer - Constructor met 4 parameters moet naam, club en opstelling opslaan. Omschrijving moet standaard 'voetbal' zijn.")
    public void testConstructorMet4Parameters() {
        Voetballer voetballer = new Voetballer("Janssen", "Kurt", "PSV", "verdediger");
        assertTrue("Kurt".equalsIgnoreCase(voetballer.getVoornaam()));
        assertTrue("Janssen".equalsIgnoreCase(voetballer.getNaam()));
        assertTrue("voetbal".equalsIgnoreCase(voetballer.getOmschrijving()));
        assertTrue("PSV".equalsIgnoreCase(voetballer.getClub()));
        assertTrue("verdediger".equalsIgnoreCase(voetballer.getOpstelling()));
    }

    @Test
    @DisplayName("Voetballer - setOpstelling moet de opstelling opslaan als het een geldige opstelling is")
    public void testSetOpstellingJuist() {
        Voetballer voetballer = new Voetballer("Janssen", "Kurt");
        voetballer.setOpstelling("verdediger");
        assertTrue("verdediger".equalsIgnoreCase(voetballer.getOpstelling()));
    }

    @Test
    @DisplayName("Voetballer - setOpstelling moet als opstelling 'onbepaald' opslaan als het geen geldige opstelling is")
    public void testSetOpstellingFout() {
        Voetballer voetballer = new Voetballer("Janssen", "Kurt");
        voetballer.setOpstelling("duivenmelker");
        assertTrue("onbepaald".equalsIgnoreCase(voetballer.getOpstelling()));
    }
}
