package be.pxl.h4.oef4;


import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H3", exerciseCode = "Oefening 4 - Huwelijk", sourceCodeRelativeFilePaths = "Adres.java")
public class AdresTest {

    public static final String STRAATNAAM = "Nieuwstraat";
    public static final String HUISNUMMER = "156B";

    private Adres adres;

    @BeforeEach
    public void init() {
        adres = new Adres(STRAATNAAM, HUISNUMMER, GemeenteTest.POSTCODE, GemeenteTest.GEMEENTENAAM);
    }

    @Test
    @DisplayName("Adres - Constructor moet waarden voor eigenschappen opslaan")
    public void testWaardenNaConstructor() {
        assertEquals(STRAATNAAM, adres.getStraat());
        assertEquals(HUISNUMMER, adres.getHuisnummer());
    }

    @Test
    @DisplayName("Adres - Constructor moet een Gemeente aanmaken met de juiste waarden")
    public void testGemeenteNaConstructor() {
        assertEquals(GemeenteTest.GEMEENTENAAM, adres.getGemeente().getGemeenteNaam());
        assertEquals(GemeenteTest.POSTCODE, adres.getGemeente().getPostcode());
    }

    @Test
    @DisplayName("Adres - toString moet alle gegevens juist tonen")
    public void testAdresToString() {
        assertEquals(STRAATNAAM + " " + HUISNUMMER + "\r\n" + GemeenteTest.POSTCODE + " " + GemeenteTest.GEMEENTENAAM, adres.toString());
    }
}
