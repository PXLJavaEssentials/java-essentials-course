package be.pxl.h4.oef2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@GutsFixture(courseCode = "javaEss1", chapterCode = "H3", exerciseCode = "Oefening 2 - Pokemon", sourceCodeRelativeFilePaths = "Trainer.java")
public class TrainerTest {
    public static final String NAME = "SAM";
    public static final int DEFAULT_POKEDEX_SIZE = 10;

    private Trainer trainer;
    private Pokemon pokemon = new Pokemon("Pikachu", "Electrical");

    @BeforeEach
    public void init() {
        trainer = new Trainer(NAME);
    }

    @Test
    @DisplayName("Trainer - naam property")
    public void testGetNaam() {
        assertEquals(NAME, trainer.getNaam());
    }

    @Test
    @DisplayName("Trainer - Pokedex is created when Trainer is created")
    public void testPokedexCreatedWithCorrectDefaultSize() {
        assertNotNull(trainer.getPokedex());
        assertEquals(DEFAULT_POKEDEX_SIZE, trainer.getPokedex().getPokemon().length);
    }

    @Test
    @DisplayName("Trainer - VangPokemon should add the Pokemon to the Pokedex")
    public void testVangPokemonAddsPokemonIfNotAvailableYet() {
        trainer.vangPokemon(pokemon);
        assertNotNull(trainer.getPokedex().getPokemon()[0]);
    }

    @Test
    @DisplayName("Trainer - VangPokemon should not add the Pokemon to the Pokedex if it is already added")
    public void testVangPokemonDoesNotAddPokemonIfAlreadyAvailable() {
        trainer.vangPokemon(pokemon);
        trainer.vangPokemon(pokemon);
        assertNull(trainer.getPokedex().getPokemon()[1]);
    }

    @Test
    @DisplayName("Trainer - toString should return trainer name")
    public void testToString() {
        assertEquals(NAME, trainer.toString());
    }
}
