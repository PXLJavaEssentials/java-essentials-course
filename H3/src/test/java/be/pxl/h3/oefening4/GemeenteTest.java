package be.pxl.h3.oefening4;


import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H3", exerciseCode = " 4 - Huwelijk", sourceCodeRelativeFilePaths = "Gemeente.java")
public class GemeenteTest {

    public static final String GEMEENTENAAM = "Hasselt";
    public static final int POSTCODE = 3500;

    private Gemeente gemeente;

    @BeforeEach
    public void init() {
        gemeente = new Gemeente(POSTCODE, GEMEENTENAAM);
    }

    @Test
    @DisplayName("Gemeente - naam moet opgeslagen worden door constructor")
    public void testGemeenteNaamNaConstructor() {
        assertEquals(GEMEENTENAAM, gemeente.getGemeenteNaam());
    }

    @Test
    @DisplayName("Gemeente - postcode moet opgeslagen worden door constructor")
    public void testJuistePostcodeNaConstructor() {
        assertEquals(POSTCODE, gemeente.getPostcode());
    }

    @Test
    @DisplayName("Gemeente - postcode moet gecorrigeerd worden als deze te kort is in constructor")
    public void testPostcodeCorrectieTeKortBijConstructor() {
        Gemeente g1 = new Gemeente(35, "Hasselt");
        Gemeente g2 = new Gemeente(350, "Hasselt");
        assertEquals(POSTCODE, g1.getPostcode());
        assertEquals(POSTCODE, g2.getPostcode());
    }

    @Test
    @DisplayName("Gemeente - postcode moet gecorrigeerd worden als deze te lang is in constructor")
    public void testPostcodeCorrectieTeLangBijConstructor() {
        Gemeente g1 = new Gemeente(350000, "Hasselt");
        Gemeente g2 = new Gemeente(35000, "Hasselt");
        assertEquals(POSTCODE, g1.getPostcode());
        assertEquals(POSTCODE, g2.getPostcode());
    }

    @Test
    @DisplayName("Gemeente - postcode moet gecorrigeerd worden in setPostcode")
    public void testSetPostCodeCorrecties() {
        gemeente.setPostcode(35);
        assertEquals(POSTCODE, gemeente.getPostcode());
        gemeente.setPostcode(3500000);
        assertEquals(POSTCODE, gemeente.getPostcode());
    }

    @Test
    @DisplayName("Gemeente - toString moet de juiste gegevens tonen")
    public void testGemeenteToString() {
        assertEquals(POSTCODE + " " + GEMEENTENAAM, gemeente.toString());
    }
}

