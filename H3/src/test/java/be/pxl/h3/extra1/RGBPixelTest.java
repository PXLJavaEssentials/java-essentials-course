package be.pxl.h3.extra1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RGBPixelTest {
    public static final int ROOD = 127;
    public static final int GROEN = 200;
    public static final int BLAUW = 63;
    public static final int GRIJS = (ROOD + GROEN + BLAUW) / 3;

    private RGBPixel pixel;

    @BeforeEach
    public void init() {
        pixel = new RGBPixel(ROOD, GROEN, BLAUW);
    }

    @Test
    public void testPixelRood() {
        assertEquals(ROOD, pixel.getRood());
    }

    @Test
    public void testPixelGroen() {
        assertEquals(GROEN, pixel.getGroen());
    }

    @Test
    public void testPixelBlauw() {
        assertEquals(BLAUW, pixel.getBlauw());
    }

    @Test
    public void testGrijswaarde() {
        pixel.naarGrijswaarde();
        assertEquals(GRIJS, pixel.getRood());
        assertEquals(GRIJS, pixel.getGroen());
        assertEquals(GRIJS, pixel.getBlauw());
    }

    @Test
    public void testToString() {
        assertEquals("(127, 200, 63)", pixel.toString());
    }
}
