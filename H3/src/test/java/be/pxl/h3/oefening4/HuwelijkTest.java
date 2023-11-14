package be.pxl.h3.oefening4;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H3", exerciseCode = "4 - Huwelijk", sourceCodeRelativeFilePaths = "Huwelijk.java")
public class HuwelijkTest {

    private static final Persoon PARTNER1 = new Persoon("Vervoort", "Jos", LocalDate.of(1974,2,15), new Adres("Nieuwstraat", "156B", 3500, "Hasselt"));
    private static final Persoon PARTNER2 = new Persoon("Bex", "Jeanne", LocalDate.of(1972, 12, 3), new Adres("Vlierstraat", "14", 3600, "Genk"));
    private static final LocalDate DATUM = LocalDate.of(2001, 8, 4);
    private static final Adres NIEUW_ADRES = new Adres("Dorpsstraat", "53", 3590, "Diepenbeek");

    private Huwelijk huwelijk;

    @BeforeEach
    public void init() {
        huwelijk = new Huwelijk(PARTNER1, PARTNER2, DATUM.getDayOfMonth(), DATUM.getMonthValue(), DATUM.getYear());
    }

    @Test
    @DisplayName("Huwelijk - partners moeten opgeslagen worden door constructor")
    public void testPartnersNaConstructor() {
        assertEquals(PARTNER1.getNaam(), huwelijk.getPartner1().getNaam());
        assertEquals(PARTNER1.getVoornaam(), huwelijk.getPartner1().getVoornaam());

        assertEquals(PARTNER2.getNaam(), huwelijk.getPartner2().getNaam());
        assertEquals(PARTNER2.getVoornaam(), huwelijk.getPartner2().getVoornaam());
    }

    @Test
    @DisplayName("Huwelijk - datum moet opgeslagen worden door constructor")
    public void testDatumWaardeNaConstructor() {
        assertEquals(DATUM, huwelijk.getHuwelijksdatum());
    }

    @Test
    @DisplayName("Huwelijk - adres van partners moet worden gelijkgesteld door constructor")
    public void testAdresAanpassingNaConstructor() {
        assertEquals(huwelijk.getPartner2().getAdres(), huwelijk.getPartner1().getAdres());
    }

    @Test
    @DisplayName("Huwelijk - adreswijziging moet adres van partner 1 aanpassen")
    public void testAdresWijzigingPartner1() {
        huwelijk.adresWijziging(NIEUW_ADRES.getStraat(), NIEUW_ADRES.getHuisnummer(), NIEUW_ADRES.getGemeente().getPostcode(), NIEUW_ADRES.getGemeente().getGemeenteNaam());
        assertEquals(NIEUW_ADRES.getStraat(), huwelijk.getPartner1().getAdres().getStraat());
        assertEquals(NIEUW_ADRES.getHuisnummer(), huwelijk.getPartner1().getAdres().getHuisnummer());
        assertEquals(NIEUW_ADRES.getGemeente().getPostcode(), huwelijk.getPartner1().getAdres().getGemeente().getPostcode());
        assertEquals(NIEUW_ADRES.getGemeente().getGemeenteNaam(), huwelijk.getPartner1().getAdres().getGemeente().getGemeenteNaam());
    }

    @Test
    @DisplayName("Huwelijk - adreswijziging moet adres van partner 2 aanpassen")
    public void testAdresWijzigingPartner2() {
        huwelijk.adresWijziging(NIEUW_ADRES.getStraat(), NIEUW_ADRES.getHuisnummer(), NIEUW_ADRES.getGemeente().getPostcode(), NIEUW_ADRES.getGemeente().getGemeenteNaam());
        assertEquals(NIEUW_ADRES.getStraat(), huwelijk.getPartner2().getAdres().getStraat());
        assertEquals(NIEUW_ADRES.getHuisnummer(), huwelijk.getPartner2().getAdres().getHuisnummer());
        assertEquals(NIEUW_ADRES.getGemeente().getPostcode(), huwelijk.getPartner2().getAdres().getGemeente().getPostcode());
        assertEquals(NIEUW_ADRES.getGemeente().getGemeenteNaam(), huwelijk.getPartner2().getAdres().getGemeente().getGemeenteNaam());
    }
}