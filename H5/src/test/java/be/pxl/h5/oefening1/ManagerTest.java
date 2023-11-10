package be.pxl.h5.oefening1;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "Oefening 1 - Werknemers", sourceCodeRelativeFilePaths = "Manager.java")
public class ManagerTest {
	
	@Test
	@DisplayName("Manager - Constructor met 4 parameters moet naam en functie opslaan")
	public void testConstructor4NaamVoornaamSalarisFunctie() {
		Manager manager = new Manager("Doe", "John", "Manager", 2500.5);
		assertTrue("John".equalsIgnoreCase(manager.getVoornaam()));
		assertTrue("Doe".equalsIgnoreCase(manager.getNaam()));
		assertTrue("Manager".equalsIgnoreCase(manager.getFunctie()));
		assertEquals(50, manager.getBonus(),  0);
	}

	@Test
	@DisplayName("Manager - Constructor met 5 parameters moet naam, functie en bonus opslaan")
	public void testConstructor5NaamVoornaamSalarisFunctieEnBonus() {
		Manager manager = new Manager("Doe", "John", "Manager", 2500.5, 600.5);
		assertTrue("John".equalsIgnoreCase(manager.getVoornaam()));
		assertTrue("Doe".equalsIgnoreCase(manager.getNaam()));
		assertTrue("Manager".equalsIgnoreCase(manager.getFunctie()));
		assertEquals(600.5, manager.getBonus(),  0);
	}

	@Test
	@DisplayName("Manager - Bonus eigenschap")
	public void testGetBonus() {
		Manager manager = new Manager("Doe", "John", "Manager", 2500.5, 600.5);
		assertEquals(600.5, manager.getBonus(),  0);
	}

	@Test
	@DisplayName("Manager - setBonus")
	public void testSetBonus() {
		Manager manager = new Manager("Doe", "John", "Manager", 2500.5, 600.5);
		manager.setBonus(1000.5);
		assertEquals(1000.5, manager.getBonus(),  0);
	}

	@Test
	@DisplayName("Manager - Salaris eigenschap")
	public void testGetSalaris() {
		Manager manager = new Manager("Doe", "John", "Manager", 2500.5, 600.5);
		assertEquals( 2500.5 + 600.5, manager.getSalaris(), 0);
	}

	@Test
	@DisplayName("Manager - Aantal Manager instanties moet geteld worden")
	public void testCountManagerObjecten() {
		int telBefore = Manager.getAantal();
		new Manager("", "", "", 0, 0);
		new Manager("", "", "", 0, 0);
		int telAfter = Manager.getAantal();
		assertEquals(2, telAfter - telBefore);

	}

	@Test
	@DisplayName("Manager - Procentueel aandeel van managers moet opgevraagd kunnen worden t.o.v. het totaal aantal werknemers")
	public void testGetProcAandeelManagers() {
		int telBeforeManager = Manager.getAantal();
		int telBeforeWerknemer = Werknemer.getAantal();
		new Manager("", "", "", 0, 0);
		new Manager("", "", "", 0, 0);
		new Werknemer("", "");
		new Werknemer("", "");
		new Werknemer("", "");
		int telAfterManager = Manager.getAantal();
		int telManager = telAfterManager - telBeforeManager;
		int telAfterWerknemer = Werknemer.getAantal();
		int telWerknemer = telAfterWerknemer - telBeforeWerknemer;
		double percentage = (double) telManager / telWerknemer;
		assertTrue(0.4 == percentage || 40 == percentage * 100);

	}
}