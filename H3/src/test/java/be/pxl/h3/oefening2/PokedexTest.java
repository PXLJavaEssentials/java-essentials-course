package be.pxl.h3.oefening2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H3", exerciseCode = "Oefening 2 - Pokemon", sourceCodeRelativeFilePaths = "Pokedex.java")
public class PokedexTest {
    public static final int SIZE = 8;

    private Pokemon pokemon = new Pokemon("Pikachu", "Electrical");
    private Pokemon pokemon2 = new Pokemon("Charmander", "Fire");
    private Pokedex pokedex;

    @BeforeEach
    public void init() {
        pokedex = new Pokedex(SIZE);
    }

    @Test
    @DisplayName("Pokedex - Array with Pokemon should be created on creation of Pokedex")
    public void testPokedexCreated() {
        assertNotNull(pokedex.getPokemon());
    }

    @Test
    @DisplayName("Pokedex - Array with Pokemon must have the right size on creation of Pokedex")
    public void testPokedexSize() {
        assertEquals(SIZE, pokedex.getPokemon().length);
    }

    @Test
    @DisplayName("Pokedex - First added Pokemon should be added at index 0")
    public void testVoegToeAddsOnFirstIndex() {
        pokedex.voegToe(pokemon);
        assertEquals(pokemon, pokedex.getPokemon()[0]);
    }

    @Test
    @DisplayName("Pokedex - Pokedex should contain Pokemon that was added")
    public void testBevatReturnsTrueWhenPokemonAvailable() {
        pokedex.voegToe(pokemon);
        assertTrue(pokedex.bevat(pokemon));
    }

    @Test
    @DisplayName("Pokedex - Pokedex should not contain Pokemon for empty Pokedex")
    public void testBevatReturnsFalseWhenNoPokemonAvailable() {
        assertFalse(pokedex.bevat(pokemon));
    }

    @Test
    @DisplayName("Pokedex - Pokedex should not contain Pokemon when another Pokemon was added")
    public void testBevatReturnsFalseWhenPokemonNotAvailable() {
        pokedex.voegToe(pokemon);
        assertFalse(pokedex.bevat(pokemon2));
    }
}
