package be.pxl.h1.oefening5;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H1", exerciseCode = "Oefening 5 - Spaceship", sourceCodeRelativeFilePaths = "Spaceship.java")
public class SpaceshipTest {

    @Test
    @DisplayName("Ship - name property")
    public void testGetName() {
        Spaceship spaceship = new Spaceship();
        spaceship.setName("Falcon");

        assertEquals("Falcon", spaceship.getName());
    }

    @Test
    @DisplayName("Ship - shield property")
    public void testIsShieldOn() {
        Spaceship spaceship = new Spaceship();
        spaceship.setShieldOn(true);

        assertTrue(spaceship.isShieldOn());
    }

    @Test
    @DisplayName("Target should be hit when shield is not activated")
    public void testGetHits_With_TargetShieldInactive() {
        Spaceship spaceship = new Spaceship();
        Spaceship target = new Spaceship();
        spaceship.fire(target); // Increment hits to 1

        assertEquals(1, target.getHits());
    }

    @Test
    @DisplayName("Attacker should be hit when shield is activated")
    public void testGetHits_With_TargetShieldActive() {
        Spaceship spaceship = new Spaceship();
        Spaceship target = new Spaceship();
        target.setShieldOn(true);
        spaceship.fire(target); // Increment hits to 1

        assertEquals(0, target.getHits());
        assertEquals(1, spaceship.getHits());
    }

    @Test
    @DisplayName("Ship should not be destroyed when hits is below 5")
    public void testIsDestroyed_NotDestroyed() {
        Spaceship spaceship = new Spaceship();
        Spaceship target = new Spaceship();
        spaceship.fire(target); // Increment hits to 1

        assertFalse(target.isDestroyed());
    }

    @Test
    @DisplayName("Ship should be destroyed after 5 hits")
    public void testIsDestroyed_Destroyed() {
        Spaceship spaceship = new Spaceship();
        Spaceship target = new Spaceship();
        spaceship.fire(target); // Increment hits to 1
        spaceship.fire(target); // Increment hits to 2
        spaceship.fire(target); // Increment hits to 3
        spaceship.fire(target); // Increment hits to 4
        spaceship.fire(target); // Increment hits to 5

        assertTrue(target.isDestroyed());
    }

}

