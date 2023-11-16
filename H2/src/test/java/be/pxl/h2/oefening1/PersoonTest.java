package be.pxl.h2.oef1;


import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H2", exerciseCode = "1 - Persoon", sourceCodeRelativeFilePaths = "Persoon.java")
public class PersoonTest {

    @Test
    @DisplayName("Test constructor met naam en voornaam")
    public void testConstructorMetNaamEnVoornaam() {
        Persoon persoon = new Persoon("Michael", "Mystery");

        assertEquals("Michael", persoon.getVoornaam());
        assertEquals("Mystery", persoon.getNaam());
    }

    @Test
    @DisplayName("Test default constructor")
    public void testDefaultConstructor() {
        Persoon persoon = new Persoon();

        assertEquals("onbekend", persoon.getVoornaam());
        assertEquals("onbekend", persoon.getNaam());
    }

    @Test
    @DisplayName("Test set-methoden")
    public void testSetMethoden() {
        Persoon persoon = new Persoon();
        persoon.setVoornaam("Jane");
        persoon.setNaam("Doe");
        persoon.setGewicht(65.5);
        persoon.setLengte(1.75);
        persoon.setGeboortejaar(1990);

        assertEquals("Jane", persoon.getVoornaam());
        assertEquals("Doe", persoon.getNaam());
        assertEquals(65.5, persoon.getGewicht(), 0.01);
        assertEquals(1.75, persoon.getLengte(), 0.01);
        assertEquals(1990, persoon.getGeboortejaar());
    }

    @Test
    @DisplayName("Test berekenBmi() methode")
    public void testBerekenBmi() {
        Persoon persoon = new Persoon();
        persoon.setGewicht(70.0);
        persoon.setLengte(1.75);

        assertEquals(22.86, persoon.berekenBmi(), 0.01);
    }

    @Test
    @DisplayName("Test geefOmschrijving() methode")
    public void testGeefOmschrijving() {
        Persoon persoon = new Persoon();
        persoon.setGewicht(60.0);
        persoon.setLengte(1.70);

        assertEquals("normaal", persoon.geefOmschrijving().toLowerCase());
    }

    @Test
    @DisplayName("Test voegVoornamenToe() methode")
    public void testVoegVoornamenToe() {
        Persoon persoon = new Persoon("John", "Doe");
        persoon.voegVoornamenToe(new String[]{"James", "Alice"});

        assertEquals("John James Alice", persoon.getVoornaam());
    }

    @Test
    @DisplayName("Test getLeeftijd() methode")
    public void testGetLeeftijd() {
        Persoon persoon = new Persoon();
        persoon.setGeboortejaar(1990);

        assertEquals(LocalDate.now().getYear()-1990, persoon.getLeeftijd());
    }

    @Test
    @DisplayName("Test setLengte() methode met te grote lengte")
    public void testSetLengteTeGroot() {
        Persoon persoon = new Persoon();
        persoon.setLengte(3.0);

        assertEquals(2.40, persoon.getLengte(), 0.01);
    }

    @Test
    @DisplayName("Persoon zou 1 centimeter moeten groeien met de standaard groei() methode")
    public void testGroeiZonderParameters() {
        Persoon persoon = new Persoon();
        persoon.setLengte(1.5);
        persoon.groei();

        assertEquals(1.51, persoon.getLengte(), 0.01);
    }

    @Test
    @DisplayName("Persoon zou 5 centimeter moeten groeien met de groei() methode met parameters")
    public void testGroeiMetParameters() {
        Persoon persoon = new Persoon();
        persoon.setLengte(1.5);
        persoon.groei(5);

        assertEquals(1.55, persoon.getLengte(), 0.01);
    }

    @Test
    @DisplayName("Persoon mag na gebruik van de groei methode met parameters niet boven de maximumgrootte gaan")
    public void testLengteLimietNaGroeiMetParameters() {
        Persoon persoon = new Persoon();
        persoon.setLengte(2.2);
        persoon.groei(25);

        assertEquals(2.4, persoon.getLengte(), 0.01);
    }

    @Test
    @DisplayName("Persoon mag na gebruik van de groei methode zonder parameters niet boven de maximumgrootte gaan")
    public void testLengteLimietNaGroeiZonderParameters() {
        Persoon persoon = new Persoon();
        persoon.setLengte(2.4);
        persoon.groei(1);

        assertEquals(2.4, persoon.getLengte(), 0.01);
    }
}


