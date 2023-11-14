package be.pxl.h5.oefening3;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "3 - Battle", sourceCodeRelativeFilePaths = "Warrior.java")
public class WarriorTest {

    @Test
    @DisplayName("Warrior - should extend Human")
    public void testWarriorHumanInheritance() {
        Warrior warrior = new Warrior("");
        assertTrue(warrior instanceof Human);
    }

    @Test
    @DisplayName("Warrior - constructor should store name and create Sword as default weapon")
    public void testWarriorConstructor() {
        Warrior warrior = new Warrior("Wallace");
        assertEquals("Wallace", warrior.getName());
        assertTrue(warrior.getWeapon() instanceof Sword);
    }

    @Test
    @DisplayName("Warrior - setWeapon should store valid weapon")
    public void testWarriorSetWeaponValid() {
        Warrior warrior = new Warrior("Gimli");
        warrior.setWeapon(new Axe(40));
        assertTrue(warrior.getWeapon() instanceof Axe);
        warrior.setWeapon(new Sword(15));
        assertTrue(warrior.getWeapon() instanceof Sword);
    }

    @Test
    @DisplayName("Warrior - setWeapon should not store invalid weapon")
    public void testWarriorSetWeaponInvalid() {
        Warrior warrior = new Warrior("Hercules");
        warrior.setWeapon(new Bow(8, 4));
        assertTrue(warrior.getWeapon() instanceof Sword);
    }

    @Test
    @DisplayName("Warrior - attack damages the target")
    public void testWarriorAttack_TargetReceivesDamage() {
        Warrior warrior = new Warrior("Aragorn");
        Monster target = new Monster("Orc", 10);
        double before = target.getHealth();
        warrior.attack(target);
        double after = target.getHealth();

        assertEquals(10, before-after, 0.01);
        assertTrue(target.alive());
    }

    @Test
    @DisplayName("Warrior - attack kills the target when health drops to zero")
    public void testWarriorAttack_TargetIsDeadOnZeroHealth() {
        Warrior warrior = new Warrior("Aragorn");
        Sword anduril = new Sword(100);
        warrior.setWeapon(anduril);
        Monster target = new Monster("Orc", 10);
        warrior.attack(target);

        assertFalse(target.alive());
    }
}

