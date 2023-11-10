package be.pxl.h4.oef4;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H3", exerciseCode = "Oefening 4 - Huwelijk", sourceCodeRelativeFilePaths = "Persoon.java")
public class PersoonTest {

    public static final String VOORNAAM = "Ann";
    public static final String NAAM = "Vandewalle";
    public static final LocalDate BIRTHDAY = LocalDate.of(1991, 9, 8);

    private Persoon persoon1;
    private Persoon persoon2;

    @BeforeEach
    public void init() {
        persoon1 = new Persoon(NAAM, VOORNAAM,  BIRTHDAY.getDayOfMonth(), BIRTHDAY.getMonthValue(), BIRTHDAY.getYear(), AdresTest.STRAATNAAM, AdresTest.HUISNUMMER, GemeenteTest.POSTCODE, GemeenteTest.GEMEENTENAAM);
        persoon2 = new Persoon(NAAM, VOORNAAM, BIRTHDAY, new Adres(AdresTest.STRAATNAAM, AdresTest.HUISNUMMER, GemeenteTest.POSTCODE, GemeenteTest.GEMEENTENAAM));
    }

    @Test
    @DisplayName("Persoon - Voor- en achternaam moet opgeslagen worden door constructor met 9 parameters")
    public void testNamenNaConstructor1() {
        assertEquals(VOORNAAM, persoon1.getVoornaam());
        assertEquals(NAAM, persoon1.getNaam());
    }

    @Test
    @DisplayName("Persoon - Geboortedatum moet opgeslagen worden door constructor met 9 parameters")
    public void testGeboortedatumNaConstructor1() {
        assertEquals(BIRTHDAY, persoon1.getGeboortedatum());
    }

    @Test
    @DisplayName("Persoon - Adres moet worden opgeslagen door constructor met 9 parameters")
    public void testAdresNaConstructor1() {
        assertEquals(AdresTest.STRAATNAAM, persoon1.getAdres().getStraat());
        assertEquals(AdresTest.HUISNUMMER, persoon1.getAdres().getHuisnummer());
        assertEquals(GemeenteTest.POSTCODE, persoon1.getAdres().getGemeente().getPostcode());
        assertEquals(GemeenteTest.GEMEENTENAAM, persoon1.getAdres().getGemeente().getGemeenteNaam());
    }

    @Test
    @DisplayName("Persoon - Voor- en achternaam moet opgeslagen worden door constructor met 4  parameters")
    public void testNamenNaConstructor2() {
        assertEquals(VOORNAAM, persoon2.getVoornaam());
        assertEquals(NAAM, persoon2.getNaam());
    }

    @Test
    @DisplayName("Persoon - Voor- en achternaam moet opgeslagen worden door constructor met 4 parameters")
    public void testGeboortedatumNaConstructor2() {
        assertEquals(BIRTHDAY, persoon2.getGeboortedatum());
    }

    @Test
    @DisplayName("Persoon - Voor- en achternaam moet opgeslagen worden door constructor met 4 parameters")
    public void testAdresNaConstructor2() {
        assertEquals(AdresTest.STRAATNAAM, persoon2.getAdres().getStraat());
        assertEquals(AdresTest.HUISNUMMER, persoon2.getAdres().getHuisnummer());
        assertEquals(GemeenteTest.POSTCODE, persoon2.getAdres().getGemeente().getPostcode());
        assertEquals(GemeenteTest.GEMEENTENAAM, persoon2.getAdres().getGemeente().getGemeenteNaam());
    }

    @Test
    @DisplayName("Persoon - toString moet juiste gegevens tonen")
    public void testPersoonToString() {
        String expected = VOORNAAM + " " + NAAM + "\r\n" + AdresTest.STRAATNAAM + " " + AdresTest.HUISNUMMER + "\r\n" + GemeenteTest.POSTCODE + " " + GemeenteTest.GEMEENTENAAM;
        assertEquals(expected, persoon1.toString());
    }
}
