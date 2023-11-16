package be.pxl.h8.oefening2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H8", exerciseCode = "2 - Zeeslag", sourceCodeRelativeFilePaths = "Spel.java")
public class SpelTest {

    @Test
    @DisplayName("Spel - Aantal zeeobjecten moet 0 zijn bij aanmaken van Spel")
    public void testSpel_AantalZeeobjectenNulNaConstructor() {
        Spel spel = new Spel();

        assertEquals(0, spel.getAantalZeeObjecten());
    }

    @Test
    @DisplayName("Spel - Aantal zeeobjecten moet stijgen wanneer er elementen worden toegevoegd")
    public void testSpel_AantalZeeobjectenStijgtNaToevoegen() {
        Spel spel = new Spel();

        Schip schip = new Schip(1,2,Alliantie.ZUID,100,5);
        spel.voegZeeObjectToe(schip);
        assertEquals(1, spel.getAantalZeeObjecten());

        GewapendeBoei boei = new GewapendeBoei(2, 3,Alliantie.NOORD,100,10,75);
        spel.voegZeeObjectToe(boei);
        assertEquals(2, spel.getAantalZeeObjecten());
    }

    @Test
    @DisplayName("Spel - vuur moet alle gewapende boeien op vijanden in bereik laten schieten")
    public void testSpel_vuurMoetAlleBoeienOpGeldigeVijandenLatenSchieten() {
        Spel spel = new Spel();

        Schip schip1 = new Schip(1,1,Alliantie.ZUID,100,5);
        spel.voegZeeObjectToe(schip1);
        Schip schip2 = new Schip(3,3,Alliantie.NOORD,100,5);
        spel.voegZeeObjectToe(schip2);
        Schip schip3 = new Schip(3,2,Alliantie.NOORD,100,5);
        spel.voegZeeObjectToe(schip3);
        GewapendeBoei boei1 = new GewapendeBoei(1,3,Alliantie.NOORD,100,10,48);
        spel.voegZeeObjectToe(boei1);
        GewapendeBoei boei2 = new GewapendeBoei(3,1,Alliantie.ZUID,100,10,49);
        spel.voegZeeObjectToe(boei2);
        GewapendeBoei boei3 = new GewapendeBoei(2,2, Alliantie.ZUID,0,10,30);
        spel.voegZeeObjectToe(boei3);
        GewapendeBoei boei4 = new GewapendeBoei(2,3,Alliantie.ZUID,100,10,23);
        spel.voegZeeObjectToe(boei4);

        spel.vuur();

        assertEquals(28, schip2.getLevenspunten());
        assertEquals(28, schip3.getLevenspunten());
        assertEquals(52, schip1.getLevenspunten());
    }
}
