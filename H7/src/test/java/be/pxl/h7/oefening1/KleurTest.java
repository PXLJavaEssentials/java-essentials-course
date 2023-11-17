package be.pxl.h7.oefening1;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H7", exerciseCode = "1 - Color Converter", sourceCodeRelativeFilePaths = "Kleur.java")
public class KleurTest {

    @Test
    @DisplayName("Kleur - Constructor met hex parameter moet hex en RGB waarden correct initialiseren")
    public void testKleur_HexConstructor() {
        Kleur kleur = new Kleur("#123456");
        assertEquals("#123456 (18, 52, 86)", kleur.toString());
    }

    @Test
    @DisplayName("Kleur - Constructor met RGB parameter moet hex en RGB waarden correct initialiseren")
    public void testKleur_RGBConstructor() {
        Kleur kleur = new Kleur(18, 52, 86);
        assertEquals("#123456 (18, 52, 86)", kleur.toString());
    }

    @Test
    @DisplayName("Kleur - Constructor met ongeldige hex parameter moet foutboodschap tonen en geen waarden opslaan")
    public void testKleur_HexConstructorMetOngeldigeHexWaarde() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Kleur kleur = new Kleur("123456");

        System.out.flush();
        String result = baos.toString();

        assertFalse(result.isEmpty());
        assertEquals("null (0, 0, 0)", kleur.toString());
    }

    @Test
    @DisplayName("Kleur - setHex met ongeldige hex parameter moet foutboodschap tonen en geen waarden opslaan")
    public void testKleur_SetHexMetOngeldigeHexWaarde() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Kleur kleur = new Kleur("#123456");
        kleur.setHex("234567");

        System.out.flush();
        String result = baos.toString();

        assertFalse(result.isEmpty());
        assertEquals("#123456 (18, 52, 86)", kleur.toString());
    }
}
