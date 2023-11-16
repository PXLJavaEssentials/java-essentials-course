package be.pxl.h8.oefening2;
import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H8", exerciseCode = "2 - Zeeslag", sourceCodeRelativeFilePaths = "GewapendeBoei.java")
public class GewapendeBoeiTest {

    @Test
    @DisplayName("GewapendeBoei - Constructor moet alle waarden correct opslaan")
    public void testGewapendeBoei_Constructor() {
        GewapendeBoei boei = new GewapendeBoei(1,2,Alliantie.NOORD,100,10,75);

        assertEquals(1, boei.getLocatie().getX());
        assertEquals(2, boei.getLocatie().getY());
        assertEquals(Alliantie.NOORD, boei.getAlliantie());
        assertEquals(100, boei.getLevenspunten());
    }

    @Test
    @DisplayName("GewapendeBoei - doeSchade moet schade doen op een geldig doelwit")
    public void testGewapendeBoei_doeSchadeDoetSchadeBijGeldigDoelwit() {
        GewapendeBoei boei = new GewapendeBoei(1,2,Alliantie.NOORD,100,10,75);
        GewapendeBoei target = new GewapendeBoei(2,2,Alliantie.ZUID,100,10,75);

        boei.doeSchade(target);

        assertEquals(25, target.getLevenspunten());
    }

    @Test
    @DisplayName("GewapendeBoei - doeSchade moet geen schade doen als de boei niet meer genoeg levenspunten heeft")
    public void testGewapendeBoei_doeSchadeDoetGeenSchadeBijNulLevenspunten() {
        GewapendeBoei boei = new GewapendeBoei(1,2,Alliantie.NOORD,0,10,75);
        GewapendeBoei target = new GewapendeBoei(2,2,Alliantie.ZUID,100,10,75);

        boei.doeSchade(target);

        assertEquals(100, target.getLevenspunten());
    }

    @Test
    @DisplayName("GewapendeBoei - doeSchade moet geen schade doen als het doelwit in dezelfde Alliantie zit")
    public void testGewapendeBoei_doeSchadeDoetGeenSchadeBijZelfdeAlliantie() {
        GewapendeBoei boei = new GewapendeBoei(1,2,Alliantie.NOORD,100,10,75);
        GewapendeBoei target = new GewapendeBoei(2,2,Alliantie.NOORD,100,10,75);

        boei.doeSchade(target);

        assertEquals(100, target.getLevenspunten());
    }

    @Test
    @DisplayName("GewapendeBoei - doeSchade moet geen schade doen als het doelwit buiten bereik ligt")
    public void testGewapendeBoei_doeSchadeDoetGeenSchadeAlsDoelwitBuitenBereikIs() {
        GewapendeBoei boei = new GewapendeBoei(1,2,Alliantie.NOORD,100,1,100);
        GewapendeBoei target = new GewapendeBoei(5,5,Alliantie.ZUID,100,10,75);

        boei.doeSchade(target);

        assertEquals(100, target.getLevenspunten());
    }

    @Test
    @DisplayName("GewapendeBoei - toString moet locatie en levenspunten bevatten")
    public void testGewapendeBoei_ToString() {
        GewapendeBoei boei = new GewapendeBoei(1,2,Alliantie.NOORD,100,10,75);

        assertTrue(boei.toString().contains(boei.getLocatie().toString()));
        assertTrue(boei.toString().contains("100"));
    }
}
