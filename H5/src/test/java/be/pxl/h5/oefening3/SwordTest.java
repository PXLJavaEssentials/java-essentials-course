package be.pxl.h5.oefening3;
import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "3 - Battle", sourceCodeRelativeFilePaths = "Sword.java")
public class SwordTest {

    @Test
    @DisplayName("Sword - constructor should store attack power, damage should be attackpower x sharpness, sharpness should have default value of max sharpness")
    public void testSwordConstructor() {
        Sword fish = new Sword(44);
        assertEquals(44*Sword.MAX_SHARPNESS, fish.doDamage());
    }

    @Test
    @DisplayName("Sword - sharpness should decrease after every damage done, as should damage")
    public void testSwordDamageDecreasesDueToSharpness() {
        Sword fish = new Sword(44);
        fish.doDamage();
        assertEquals(44 * (Sword.MAX_SHARPNESS - 0.1), fish.doDamage());
    }

    @Test
    @DisplayName("Sword - decrease in sharpness should be limited to minimum sharpness")
    public void testSwordDamageDecreaseIsLimitedToMinimumSharpness() {
        Sword fish = new Sword(44);
        for(int i=0;i<100;i++) fish.doDamage();
        assertEquals(44 * (Sword.MIN_SHARPNESS), fish.doDamage());
    }
}
