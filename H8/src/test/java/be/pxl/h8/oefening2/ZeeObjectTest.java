package be.pxl.h8.oefening2;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H8", exerciseCode = "2 - Zeeslag", sourceCodeRelativeFilePaths = "ZeeObject.java")
public class ZeeObjectTest {

    class DummyZeeObject extends ZeeObject {

        public DummyZeeObject(int x, int y, Alliantie alliantie, int levenspunten) {
            super(x, y, alliantie, levenspunten);
        }
    }

    @Test
    @DisplayName("ZeeObject - 4 eigenschappen moeten opgeslagen worden via constructor")
    public void testZeeObject_Constructor() {
        DummyZeeObject zeeObject = new DummyZeeObject(1, 2, Alliantie.NOORD, 100);
        assertEquals(1, zeeObject.getLocatie().getX());
        assertEquals(2, zeeObject.getLocatie().getY());
        assertEquals(Alliantie.NOORD, zeeObject.getAlliantie());
        assertEquals(100, zeeObject.getLevenspunten());
    }

    @Test
    @DisplayName("ZeeObject - schade moet geregistreerd worden")
    public void testZeeObject_OntvangSchade() {
        DummyZeeObject zeeObject = new DummyZeeObject(1, 2, Alliantie.NOORD, 100);
        zeeObject.ontvangSchade(50);

        assertEquals(50, zeeObject.getLevenspunten());
    }

    @Test
    @DisplayName("ZeeObject - toString moet positie en levenspunten bevatten")
    public void testZeeObject_ToString() {
        DummyZeeObject zeeObject = new DummyZeeObject(1, 2, Alliantie.NOORD, 100);

        assertTrue(zeeObject.toString().contains(zeeObject.getLocatie().toString()));
        assertTrue(zeeObject.toString().contains("100"));
    }
}
