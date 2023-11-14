package be.pxl.h5.oefening3;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "3 - Battle", sourceCodeRelativeFilePaths = "Weapon.java")
public class WeaponTest {

    class DummyWeapon extends Weapon {

        public DummyWeapon(int attackPower) {
            super(attackPower);
        }
    }

    @Test
    @DisplayName("Weapon - constructor should store attack power")
    public void testWeaponConstructor() {
        DummyWeapon dummy = new DummyWeapon(34);
        assertEquals(34, dummy.doDamage());
    }
}
