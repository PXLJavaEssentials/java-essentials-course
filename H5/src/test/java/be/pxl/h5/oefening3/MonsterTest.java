package be.pxl.h5.oefening3;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "3 - Battle", sourceCodeRelativeFilePaths = "Monster.java")
public class MonsterTest {

    @Test
    @DisplayName("Monster - should extend Character")
    public void testMonsterCharacterInheritance() {
        Monster monster = new Monster("", 1);
        assertTrue(monster instanceof Character);
    }

    @Test
    @DisplayName("Monster - constructor should store name and health")
    public void testMonsterConstructor() {
        Monster monster = new Monster("Orc", 20.0);
        assertEquals("Orc", monster.getName());
        assertEquals(50, monster.getHealth(), 0.001);
    }

    @Test
    @DisplayName("Monster - attack does damage to target")
    public void testMonsterAttack_TargetReceivesDamage() {
        Monster monster = new Monster("Dragon", 30.0);
        Warrior target = new Warrior("Hero");
        double before = target.getHealth();
        monster.attack(target);
        double after = target.getHealth();
        assertEquals(30, before-after, 0.001);
    }

    @Test
    @DisplayName("Monster - attack kills target when health drops to zero")
    public void testMonsterAttack_TargetIsDeadOnZeroHealth() {
        Monster monster = new Monster("Dragon", 100.0);
        Warrior target = new Warrior("Hero");
        monster.attack(target);
        assertFalse(target.alive());
    }

    @Test
    @DisplayName("Monster - toString should return name")
    public void testMonsterToString() {
        Monster monster = new Monster("Goblin", 15.0);
        assertEquals("Goblin", monster.toString());
    }
}
