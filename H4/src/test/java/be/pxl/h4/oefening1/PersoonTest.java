package be.pxl.h4.oefening1;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H4", exerciseCode = "Oefening 3 - Persoon", sourceCodeRelativeFilePaths = "Persoon.java")
public class PersoonTest {

    public static final String VOORNAAM = "Franky";
    public static final String NAAM = "Van der Elst";
    public static final double LENGTE = 1.84;
    public static final double GEWICHT = 71.6;
    public static final LocalDate GEBOORTEDATUM = LocalDate.of(1961, 4, 30);

    Persoon persoon;

    @BeforeEach
    public void init() {
        persoon = new Persoon(NAAM, VOORNAAM);
    }

    @Test
    @DisplayName("Persoon - Default constructor moet 'onbekend' opslaan als voor- en achternaam")
    public void testDefaultConstructor() {
        Persoon p = new Persoon();

        assertEquals("onbekend", p.getNaam());
        assertEquals("onbekend", p.getVoornaam());
    }

    @Test
    @DisplayName("Persoon - Constructor met 2 parameters moet naam opslaan")
    public void testWaardenNaConstructor() {
        assertEquals(VOORNAAM, persoon.getVoornaam());
        assertEquals(NAAM, persoon.getNaam());
    }

    @Test
    @DisplayName("Persoon - Copy constructor moet een exacte kopie van de originele instantie aanmaken")
    public void testCopyConstructor() {
        persoon.setGewicht(GEWICHT);
        persoon.setLengte(LENGTE);
        persoon.setGeboortedatum(GEBOORTEDATUM);

        Persoon p2 = new Persoon(persoon);

        assertEquals(persoon.getVoornaam(), p2.getVoornaam());
        assertEquals(persoon.getNaam(), p2.getNaam());
        assertEquals(persoon.getLengte(), p2.getLengte(), 0.01);
        assertEquals(persoon.getGewicht(), p2.getGewicht(), 0.01);
        assertEquals(persoon.getGeboortedatum(), p2.getGeboortedatum());
    }

    @Test
    @DisplayName("Persoon - setNaam en setVoornaam")
    public void testSetters() {
        persoon.setVoornaam(VOORNAAM+VOORNAAM);
        assertEquals(VOORNAAM+VOORNAAM, persoon.getVoornaam());

        persoon.setNaam(NAAM +NAAM);
        assertEquals(NAAM+NAAM, persoon.getNaam());
    }

    @Test
    @DisplayName("Persoon - setLengte moet lengte opslaan bij geldige waarde")
    public void testSetLengteBijCorrecteWaarde() {
        persoon.setLengte(LENGTE);
        assertEquals(LENGTE, persoon.getLengte(), 0.01);
    }

    @Test
    @DisplayName("Persoon - setLengte moet lengte opslaan als maximum lengte bij te grote waarde")
    public void testSetLengteBijTeGroteWaarde() {
        persoon.setLengte(Persoon.MAX_LENGTE+0.01);
        assertEquals(Persoon.MAX_LENGTE, persoon.getLengte(), 0.01);
    }

    @Test
    @DisplayName("Persoon - groei zondder parameters moet lengte met 1cm verhogen")
    public void testGroeiZonderParameter() {
        persoon.setLengte(LENGTE);
        persoon.groei();
        assertEquals(LENGTE+0.01, persoon.getLengte(), 0.01);
    }

    @Test
    @DisplayName("Persoon - maximum lengte mag niet overschreden worden door aanroep van groei")
    public void testGroeiZonderParameterBijTeHoogResultaat() {
        persoon.setLengte(Persoon.MAX_LENGTE);
        persoon.groei();
        assertEquals(Persoon.MAX_LENGTE, persoon.getLengte(), 0.01);
    }

    @Test
    @DisplayName("Persoon - groei met parameter moet legnte verhogen met meegegeven waarde")
    public void testGroeiMetParameter() {
        persoon.setLengte(LENGTE);
        persoon.groei(0.03);
        assertEquals(LENGTE+0.03, persoon.getLengte(), 0.01);
    }

    @Test
    @DisplayName("Persoon - maximum lengte mag niet overschreden worden door aanroep van groei met parameters")
    public void testGroeiMetParameterBijTeHoogResultaat() {
        persoon.setLengte(Persoon.MAX_LENGTE);
        persoon.groei(0.03);
        assertEquals(Persoon.MAX_LENGTE, persoon.getLengte(), 0.01);
    }

    @Test
    @DisplayName("Persoon - setGewicht")
    public void testSetGewicht() {
        persoon.setGewicht(GEWICHT);
        assertEquals(GEWICHT, persoon.getGewicht(), 0.01);
    }

    @Test
    @DisplayName("Persoon - setGeboortedatum")
    public void testSetGeboortedatum() {
        persoon.setGeboortedatum(GEBOORTEDATUM);
        assertEquals(GEBOORTEDATUM, persoon.getGeboortedatum());
    }

    @Test
    @DisplayName("Persoon - getLeeftijd moet huidige leeftijd teruggeven")
    public void testGetLeeftijd() {
        persoon.setGeboortedatum(GEBOORTEDATUM);
        assertEquals(LocalDate.now().getYear()-GEBOORTEDATUM.getYear(), persoon.getLeeftijd());
    }

    @Test
    @DisplayName("Persoon - BMI moet correct berekend worden op basis van lengte en gewicht")
    public void testBerekenBmiMetJuisteAfronding() {
        persoon.setLengte(LENGTE);
        persoon.setGewicht(GEWICHT);

        assertEquals(Math.round((GEWICHT/(LENGTE*LENGTE))*10)/10.0, persoon.berekenBmi(), 0.01);
    }

    @Test
    @DisplayName("Persoon - getOmschrijving moet juiste waarde teruggeven op basis van BMI")
    public void testBmiOmschrijvingen() {
        persoon.setLengte(1);
        persoon.setGewicht(17);
        assertEquals("ondergewicht", persoon.geefOmschrijving());
        persoon.setGewicht(18);
        assertEquals("normaal", persoon.geefOmschrijving());
        persoon.setGewicht(25);
        assertEquals("overgewicht", persoon.geefOmschrijving());
        persoon.setGewicht(30);
        assertEquals("obesitas", persoon.geefOmschrijving());
        persoon.setGewicht(40);
        assertEquals("morbide obesitas", persoon.geefOmschrijving());
    }

    @Test
    @DisplayName("Persoon - extra voornamen via voegVoornamenToe moeten toegevoegd worden")
    public void testVoegVoornamenToe() {
        persoon.voegVoornamenToe(new String[]{"Bert", "Sam"});
        assertEquals(VOORNAAM + " Bert Sam", persoon.getVoornaam());
    }

    @Test
    @DisplayName("Persoon - geefNaamAfgekort moet de voornaam afkorten naar de eerste letter, gevolgd door een punt")
    public void testAfgekorteNaam() {
        assertEquals("F.Van der elst", persoon.geefNaamAfgekort());
    }

    @Test
    @DisplayName("Persoon - naam moet correct geëncrypteerd worden door encrypteerNaam")
    public void testEncrypteerNaam() {
        assertEquals("G/Wbo!efs!fmtu", persoon.encrypteerNaam(1));
        assertEquals("O7_jw)mn{)nu|}", persoon.encrypteerNaam(9));
        assertEquals("Q/Mbohlpvt", new Persoon("Langkous", "Pipi").encrypteerNaam(1));
    }
}
