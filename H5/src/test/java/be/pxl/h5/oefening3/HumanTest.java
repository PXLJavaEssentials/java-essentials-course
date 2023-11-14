package be.pxl.h5.oefening3;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "3 - Battle", sourceCodeRelativeFilePaths = "Human.java")
public class HumanTest {

    @Test
    @DisplayName("Human - should extends Character")
    public void testHumanCharacterInheritance() {
        Warrior warrior = new Warrior("");
        assertTrue(warrior instanceof Human);
        assertTrue(warrior instanceof Character);
    }

    @Test
    @DisplayName("Human - list of defeated enemies should be empty on creation")
    public void testHumanDefeatedEnemiesListIsCreatedEmpty() {
        Human warrior = new Warrior("");
        assertEquals(0, warrior.getDefeatedEnemies().size());
    }

    @Test
    @DisplayName("Human - defeated enemy should be stored in a list")
    public void testHumanDefeatedEnemyIsStored() {
        Human warrior = new Warrior("");
        warrior.setWeapon(new Sword(100));
        Monster monster = new Monster("orc",10);

        warrior.attack(monster);

        assertEquals(1, warrior.getDefeatedEnemies().size());
        assertEquals("orc", warrior.getDefeatedEnemies().get(0).getName());
    }

    @Test
    @DisplayName("Human - damaged enemy that is not defeated should not be added to the list")
    public void testHumanDamagedEnemyThatWasNotKilledIsNotAddedToDefeatedEnemies() {
        Human warrior = new Warrior("");
        warrior.setWeapon(new Sword(20));
        Monster monster = new Monster("orc",10);

        warrior.attack(monster);

        assertEquals(0, warrior.getDefeatedEnemies().size());
    }
}
