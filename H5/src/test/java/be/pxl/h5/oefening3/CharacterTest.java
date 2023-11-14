package be.pxl.h5.oefening3;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "3 - Battle", sourceCodeRelativeFilePaths = "Character.java")
public class CharacterTest {

    class DummyCharacter extends Character {

        public DummyCharacter(String name, double health) {
            super(name, health);
        }

        @Override
        public void attack(Character target) {

        }
    }

    @DisplayName("Character - constructor should store name and health")
    @Test
    public void testCharacterConstructor() {
        DummyCharacter dummy = new DummyCharacter("mj", 23);
        assertEquals("mj", dummy.getName());
        assertEquals(23, dummy.getHealth());
    }

    @Test
    @DisplayName("Character - should be alive by default")
    public void testCharacterIsAliveByDefault() {
        DummyCharacter dummy = new DummyCharacter("mj", 23);
        assertTrue(dummy.alive());
    }

    @Test
    @DisplayName("Character - decreaseHealth should lower health points")
    public void testCharacterDecreaseHealthLowersHealth() {
        DummyCharacter dummy = new DummyCharacter("mj", 23);
        dummy.decreaseHealth(2);
        assertEquals(21, dummy.getHealth());
    }

    @Test
    @DisplayName("Character - should stay alive when damage is done but health is above zero")
    public void testCharacterDecreaseHealthDoesntKillCharacterIfResultAboveZero() {
        DummyCharacter dummy = new DummyCharacter("mj", 23);
        dummy.decreaseHealth(2);
        assertTrue(dummy.alive());
    }

    @Test
    @DisplayName("Character - should be killed when health reaches zero")
    public void testCharacterDecreaseHealthKillsCharacterIfZero() {
        DummyCharacter dummy = new DummyCharacter("mj", 23);
        dummy.decreaseHealth(23);
        assertEquals(0, dummy.getHealth());
        assertFalse(dummy.alive());
    }

    @Test
    @DisplayName("Character - should be killed when health drops below zero")
    public void testCharacterDecreaseHealthKillsCharacterBelowZero() {
        DummyCharacter dummy = new DummyCharacter("mj", 23);
        dummy.decreaseHealth(100);
        assertEquals(0, dummy.getHealth());
        assertFalse(dummy.alive());
    }

    @Test
    @DisplayName("Character - heal should increase health points")
    public void testCharacterHealIncreasesHealth() {
        DummyCharacter dummy = new DummyCharacter("mj", 23);
        dummy.heal(2);
        assertEquals(25, dummy.getHealth());
    }

    @Test
    @DisplayName("Character - heal should limit healing to a maximum of 100 health points")
    public void testCharacterHealIncreasesHealthToMax100() {
        DummyCharacter dummy = new DummyCharacter("mj", 23);
        dummy.heal(100);
        assertEquals(100, dummy.getHealth());
    }
}
