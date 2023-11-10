package be.pxl.h2.oefening3;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H2", exerciseCode = "Oefening 3 - Game of Thrones", sourceCodeRelativeFilePaths = "Character.java")
public class CharacterTest {

    @Test
    @DisplayName("Character should store data from 4 param constructor")
    void testCreateCharacterWithConstructor4() {
        Character character = new Character("Petyr", "Baelish", "Baelish", "Aidan Gillen");
        assertEquals("Petyr Baelish of house Baelish\nPlayed by: Aidan Gillen", character.toString());
    }

    @Test
    @DisplayName("Character should store data from 5 param constructor")
    void testCreateCharacterWithConstructor5() {
        Character character = new Character("Petyr", "Baelish", "Littlefinger", "Baelish", "Aidan Gillen");
        assertEquals("Petyr \"Littlefinger\" Baelish of house Baelish\nPlayed by: Aidan Gillen", character.toString());
    }

    @Test
    @DisplayName("Character should store data from 8 param constructor")
    void testCreateCharacterWithConstructor8() {
        Character character = new Character("Tyrion", "Lannister", "The Imp", "Lannister", 1, 8, 67, "Peter Dinklage");
        assertEquals("Tyrion \"The Imp\" Lannister of house Lannister\nPlayed by: Peter Dinklage in season 1-8 (67 episodes)", character.toString());
    }

    @Test
    @DisplayName("Character should add extra titles")
    void testCreateCharacterWithTitles() {
        Character character = new Character("Tyrion", "Lannister", "The Imp", "Lannister", "Peter Dinklage");
        character.addTitle("Hand of the King");
        character.addTitle("Warden of the West");
        character.addTitle("Lord of Casterly Rock");

        assertEquals("Tyrion \"The Imp\" Lannister of house Lannister\n" +
                "*** \"Hand of the King\"\n" +
                "*** \"Warden of the West\"\n" +
                "*** \"Lord of Casterly Rock\"\n" +
                "Played by: Peter Dinklage", character.toString());
    }

    @Test
    @DisplayName("Extra titles should only be added if the maximum amount of titles is not reached")
    void testCreateCharacterWithTooManyTitles() {
        Character character = new Character("Tyrion", "Lannister", "The Imp", "Lannister", "Peter Dinklage");
        character.addTitle("Hand of the King");
        character.addTitle("Warden of the West");
        character.addTitle("Lord of Casterly Rock");
        character.addTitle("Lord of the Flames");

        assertEquals("Tyrion \"The Imp\" Lannister of house Lannister\n" +
                "*** \"Hand of the King\"\n" +
                "*** \"Warden of the West\"\n" +
                "*** \"Lord of Casterly Rock\"\n" +
                "Played by: Peter Dinklage", character.toString());
    }

    @Test
    @DisplayName("Character should store data from setData method")
    void testSetDataMethod() {
        Character character = new Character("Tyrion", "Lannister", "The Imp", "Lannister", "Peter Dinklage");
        character.setData(1, 8, 67);

        assertEquals("Tyrion \"The Imp\" Lannister of house Lannister\nPlayed by: Peter Dinklage in season 1-8 (67 episodes)", character.toString());
    }

    @Test
    @DisplayName("Full toString method with all character data should produce the right toString result")
    void testToStringMethod() {
        Character character = new Character("Tyrion", "Lannister", "The Imp", "Lannister", 1, 8, 67, "Peter Dinklage");
        character.addTitle("Hand of the King");
        character.addTitle("Warden of the West");
        character.addTitle("Lord of Casterly Rock");

        String expectedOutput = "Tyrion \"The Imp\" Lannister of house Lannister\n" +
                "*** \"Hand of the King\"\n" +
                "*** \"Warden of the West\"\n" +
                "*** \"Lord of Casterly Rock\"\n" +
                "Played by: Peter Dinklage in season 1-8 (67 episodes)";

        assertEquals(expectedOutput, character.toString());
    }

    @Test
    @DisplayName("Amount of created Characters should be counted")
    void testGetCountMethod() {
        int a = Character.getCount();

        new Character("Petyr", "Baelish", "Baelish", "Aidan Gillen");
        new Character("Tyrion", "Lannister", "The Imp", "Lannister", 1, 8, 67, "Peter Dinklage");
        new Character("Catelyn", "Stark", null, "Tully", 1, 3, 26, "Michelle Fairley");

        int b = Character.getCount();

        assertEquals(3, (b-a));
    }
}

