package be.pxl.h1.oefening6;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H1", exerciseCode = "Oefening 6 - Phone", sourceCodeRelativeFilePaths = "Phone.java")
public class PhoneTest {

    @Test
    @DisplayName("Phone - number property")
    public void testGetNumber() {
        Phone phone = new Phone();
        phone.setNumber("123456789");

        assertEquals("123456789", phone.getNumber());
    }

    @Test
    @DisplayName("Phone - provider property")
    public void testGetProvider() {
        Phone phone = new Phone();
        phone.setProvider("Floximus");

        assertEquals("Floximus", phone.getProvider());
    }

    @Test
    @DisplayName("Phone - number of calls should increase when a call is made")
    public void testGetNumberOfPaidCalls() {
        Phone phone = new Phone();
        phone.call("123456789");

        assertEquals(1, phone.getNumberOfCalls());
    }

    @Test
    @DisplayName("Phone - number of free calls should increase for all registered phone numbers")
    public void testGetNumberOfFreeCalls() {
        Phone phone = new Phone();
        phone.call("112");
        phone.call("102");
        phone.call("070245245");

        assertEquals(3, phone.getNumberOfFreeCalls());
    }

    @Test
    @DisplayName("Phone - number of calls and free calls should be reset to 0 when reset() is called")
    public void testReset() {
        Phone phone = new Phone();
        phone.call("123456789");
        phone.call("112");
        phone.call("102");
        phone.reset();

        assertEquals(0, phone.getNumberOfCalls());
        assertEquals(0, phone.getNumberOfFreeCalls());
    }

    @Test
    @DisplayName("Phone - calculate price for more than 20 Floximus calls")
    public void testGetCost_Floximus_MoreThan20Calls() {
        Phone phone = new Phone();
        phone.setProvider("Floximus");
        int calls = 25;
        for (int i = 0; i < calls; i++) {
            phone.call("123456789");
        }

        assertEquals(calls * 0.25 * 0.95, phone.getCost(), 0.01);
    }

    @Test
    @DisplayName("Phone - calculate price for less than 20 Floximus calls")
    public void testGetCost_Floximus_20OrFewerCalls() {
        Phone phone = new Phone();
        phone.setProvider("Floximus");
        int calls = 15;
        for (int i = 0; i < calls; i++) {
            phone.call("123456789");
        }

        assertEquals(calls * 0.25, phone.getCost(), 0.01);
    }

    @Test
    @DisplayName("Phone - calculate price for non-Floximus calls")
    public void testGetCost_NonFloximus() {
        Phone phone = new Phone();
        phone.setProvider("TelecomCo");
        int calls = 10;
        for (int i = 0; i < calls; i++) {
            phone.call("123456789");
        }

        assertEquals(calls * 0.21, phone.getCost(), 0.01);
    }
}

