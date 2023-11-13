package be.pxl.h3.oefening2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@GutsFixture(courseCode = "javaEss1", chapterCode = "H3", exerciseCode = "Oefening 2 - Pokemon", sourceCodeRelativeFilePaths = "Pokemon.java")
public class PokemonTest {
    public static final String NAME = "Pikachu";
    public static final String TYPE = "Electrical";

    private Pokemon pokemon;

    @BeforeEach
    public void init() {
        pokemon = new Pokemon(NAME, TYPE);
    }

    @Test
    @DisplayName("Pokemon - naam eigenschap")
    public void testGetNaam() {
        assertEquals(NAME, pokemon.getNaam());
    }

    @Test
    @DisplayName("Pokemon - type eigenschap")
    public void testGetType() {
        assertEquals(TYPE, pokemon.getType());
    }

    @Test
    @DisplayName("Pokemon - toString should include name & type")
    public void testToString() {
        assertEquals(String.format("%s (%s)", NAME, TYPE), pokemon.toString());
    }
}
