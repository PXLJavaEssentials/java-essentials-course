package be.pxl.h5.oefening3;
import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "3 - Battle", sourceCodeRelativeFilePaths = "Bow.java")
public class BowTest {

    @Test
    @DisplayName("Axe - constructor should save attack power and number of arrows")
    public void testBowConstructor() {
        Bow bowow = new Bow(12, 5);
        assertEquals(5, bowow.getNumArrows());
        assertEquals(12, bowow.doDamage());
    }

    @Test
    @DisplayName("Axe - doing damage should decrease number of arrows by 1")
    public void testBowNumberOfArrowsDecreasesWhenDamageIsDone() {
        Bow bowow = new Bow(12, 5);
        bowow.doDamage();
        assertEquals(4, bowow.getNumArrows());
    }

    @Test
    @DisplayName("Axe - no damage should be done when no arrows are available through constructor")
    public void testBowNoDamageWhenNoArrowsAvailableFromStart() {
        Bow bowow = new Bow(12, 0);
        assertEquals(0, bowow.doDamage());
    }

    @Test
    @DisplayName("Axe - no damage should be done after last arrow has been used")
    public void testBowNoDamageWhenNoArrowsAvailableAfterShooting() {
        Bow bowow = new Bow(12, 1);
        assertEquals(12, bowow.doDamage());
        assertEquals(0, bowow.doDamage());
    }

    @Test
    @DisplayName("Axe - adding arrows should increase the arrow count")
    public void testBowAddArrowsIncreasesArrowCount() {
        Bow bowow = new Bow(12, 5);
        bowow.addArrows(5);
        assertEquals(10, bowow.getNumArrows());
    }

    @Test
    @DisplayName("Axe - damage should be done when new arrows are added through addArrows")
    public void testBowDoesDamageAfterWhenArrowsAreAdded() {
        Bow bowow = new Bow(12, 0);
        bowow.addArrows(5);
        assertEquals(12, bowow.doDamage());
    }
}
