package be.pxl.h7.oefening2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H7", exerciseCode = "2 - Bingo", sourceCodeRelativeFilePaths = "BingoKaart.java")
public class BingoKaartTest {

    @Test
    @DisplayName("BingoKaart - Constructor should create empty list")
    public void testBingoKaart_ConstructorMaaktLegeLijstAan() {
        BingoKaart kaart = new BingoKaart("irma");
        for(int i=0;i<100;i++) {
            assertFalse(kaart.hasNumber(i));
        }
    }

    @Test
    @DisplayName("BingoKaart - hasNumber should return true for all added numbers")
    public void testBingoKaart_HasNumberTrueForAddednumbers() {
        BingoKaart kaart = new BingoKaart("irma");
        kaart.addNumber(23);
        kaart.addNumber(42);
        assertTrue(kaart.hasNumber(23));
        assertTrue(kaart.hasNumber(42));
        assertFalse(kaart.hasNumber(31));
    }

    @Test
    @DisplayName("BingoKaart - toString should contain name")
    public void testBingoKaart_ToStringShouldContainName() {
        BingoKaart kaart = new BingoKaart("irma");
        kaart.addNumber(23);
        assertTrue(kaart.toString().contains("irma"));
    }

    @Test
    @DisplayName("BingoKaart - toString should contain added numbers")
    public void testBingoKaart_ToStringShouldContainAddedNumbers() {
        BingoKaart kaart = new BingoKaart("irma");
        kaart.addNumber(23);
        kaart.addNumber(42);
        assertTrue(kaart.toString().contains("23"));
        assertTrue(kaart.toString().contains("42"));
    }
}
