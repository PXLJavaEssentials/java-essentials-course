package be.pxl.h5.oefening3;
import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "3 - Battle", sourceCodeRelativeFilePaths = "Axe.java")
public class AxeTest {

    @Test
    @DisplayName("Axe - constructor should save attack power, total damage should be attack power x sharpness, default sharpness should be max")
    public void testAxeConstructor() {
        Axe zibit = new Axe(44);
        assertEquals(44*Axe.MAX_SHARPNESS, zibit.doDamage());
    }

    @Test
    @DisplayName("Axe - doing damage should decrease axe sharpness and damage")
    public void testAxeDamageDecreasesDueToSharpness() {
        Axe zibit = new Axe(44);
        zibit.doDamage();
        assertEquals(44 * (Axe.MAX_SHARPNESS - 0.02), zibit.doDamage());
    }

    @Test
    @DisplayName("Axe - decrease in sharpness should be limited to minimum sharpness")
    public void testAxeDamageDecreaseIsLimitedToMinimumSharpness() {
        Axe zibit = new Axe(44);
        for(int i=0;i<100;i++) zibit.doDamage();
        assertEquals(44 * (Axe.MIN_SHARPNESS), zibit.doDamage());
    }
}
