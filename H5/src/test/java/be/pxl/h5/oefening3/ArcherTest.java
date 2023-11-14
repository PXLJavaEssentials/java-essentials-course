package be.pxl.h5.oefening3;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "3 - Battle", sourceCodeRelativeFilePaths = "Archer.java")
public class ArcherTest {

    @Test
    @DisplayName("Archer - should extend Human")
    public void testArcherHumanInheritance() {
        Archer archer = new Archer("");
        assertTrue(archer instanceof Human);
    }

    @Test
    @DisplayName("Archer - constructor should store the character name and set a bow as weapon")
    public void testArcherCreation() {
        Archer archer = new Archer("Legolas");
        assertEquals("Legolas", archer.getName());
        assertTrue(archer.getWeapon() instanceof Bow);
    }

    @Test
    @DisplayName("Archer - setWeapon with Bow should store the weapon")
    public void testArcherSetWeaponValid() {
        Archer archer = new Archer("Robin Hood");
        archer.setWeapon(new Bow(8, 4));
        assertTrue(archer.getWeapon() instanceof Bow);
    }

    @Test
    @DisplayName("Archer - setWeapon with invalid weapon should not be stored")
    public void testArcherSetWeaponInvalid() {
        Archer archer = new Archer("Hawkeye");
        archer.setWeapon(new Bow(8, 4));
        archer.setWeapon(new Sword(10));
        assertTrue(archer.getWeapon() instanceof Bow);
    }

    @Test
    @DisplayName("Archer - findArrows should add arrows to the bow")
    public void testArcherFindArrows() {
        Archer archer = new Archer("Artemis");
        archer.findArrows();
        assertTrue(((Bow) archer.getWeapon()).getNumArrows() >= 1);
    }

    @Test
    @DisplayName("Archer - attack should damage the target")
    public void testArcherAttack_TargetReceivesDamage() {
        Archer archer = new Archer("Cupid");
        Monster target = new Monster("Target", 10);
        double before = target.getHealth();
        archer.attack(target);
        double after = target.getHealth();

        assertEquals(10, before-after, 0.01);
        assertTrue(target.alive());
    }

    @Test
    @DisplayName("Archer - attack should kill the target when target health reaches zero")
    public void testArcherAttack_TargetIsDeadOnZeroHealth() {
        Archer archer = new Archer("Cupid");
        archer.setWeapon(new Bow(100,1));
        Monster target = new Monster("Target", 10);
        archer.attack(target);

        assertFalse(target.alive());
    }

    @Test
    @DisplayName("Archer - attack should do no damage when no arrows are available")
    public void testArcherAttack_TargetReceivesNoDamageWhenNoArrowsAvailable() {
        Archer archer = new Archer("Cupid");
        archer.setWeapon(new Bow(10,0));
        Monster target = new Monster("Target", 10);
        double before = target.getHealth();
        archer.attack(target);
        double after = target.getHealth();

        assertEquals(0, before-after, 0.01);
        assertTrue(target.alive());
    }
}
