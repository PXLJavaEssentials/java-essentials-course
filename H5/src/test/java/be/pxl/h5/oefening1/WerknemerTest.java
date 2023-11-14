package be.pxl.h5.oefening1;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H5", exerciseCode = "1 - Werknemers", sourceCodeRelativeFilePaths = "Werknemer.java")
public class WerknemerTest {

	@Test
	@DisplayName("Werknemer - Constructor met 2 parameters moet naam en functie opslaan, standaard functie moet 'Algemeen bediende' zijn")
	public void testConstructorNaamVoornaam() {
		Werknemer werknemer = new Werknemer("Doe", "John");
		assertTrue("John".equalsIgnoreCase(werknemer.getVoornaam()));
		assertTrue("Doe".equalsIgnoreCase(werknemer.getNaam()));
		assertTrue("Algemeen bediende".equalsIgnoreCase(werknemer.getFunctie()));
		assertEquals(1800, werknemer.getSalaris(), 0);
	}

	@Test
	@DisplayName("Werknemer - Constructor met 4 parameters moet naam, salaris en functie opslaan")
	public void testConstructorNaamVoornaamSalarisFunctie() {
		Werknemer werknemer = new Werknemer("Doe", "John", "bediende", 2500.5);
		assertTrue("John".equalsIgnoreCase(werknemer.getVoornaam()));
		assertTrue("Doe".equalsIgnoreCase(werknemer.getNaam()));
		assertTrue("bediende".equalsIgnoreCase(werknemer.getFunctie()));
		assertEquals(2500.5, werknemer.getSalaris(), 0);
	}

	@Test
	@DisplayName("Werknemer - Minimum salaris moet gerespecteerd worden bij initialisatie via constructor")
	public void testConstructorMinimumSalaris() {
		Werknemer werknemer = new Werknemer("Doe", "John", "Manager", 950.5);
		assertTrue("John".equalsIgnoreCase(werknemer.getVoornaam()));
		assertTrue("Doe".equalsIgnoreCase(werknemer.getNaam()));
		assertTrue("Manager".equalsIgnoreCase(werknemer.getFunctie()));
		assertEquals(Werknemer.getMinimumSalaris(), werknemer.getSalaris(), 0);

	}

	@Test
	@DisplayName("Werknemer - setNaam")
	public void testSetterNaam() {
		Werknemer werknemer = new Werknemer("Doe", "John");
		String naam = "De Belie";
		werknemer.setNaam(naam);
		assertEquals(naam, werknemer.getNaam());
	}

	@Test
	@DisplayName("Werknemer - getNaam")
	public void testGetterNaam() {
		Werknemer werknemer = new Werknemer("Doe", "John");
		assertEquals("Doe", werknemer.getNaam());
	}

	@Test
	@DisplayName("Werknemer - setVoornaam")
	public void testSetterVoornaam() {
		Werknemer werknemer = new Werknemer("Doe", "John");
		String voornaam = "Ann";
		werknemer.setVoornaam(voornaam);
		assertEquals(voornaam, werknemer.getVoornaam());
	}

	@Test
	@DisplayName("Werknemer - getVoornaam")
	public void testGetterVoornaam() {
		Werknemer werknemer = new Werknemer("Doe", "John");
		assertEquals("John", werknemer.getVoornaam());
	}

	@Test
	@DisplayName("Werknemer - setSalaris")
	public void testSetterSalaris() {
		Werknemer werknemer = new Werknemer("Doe", "John");
		double salaris = 3500.25;
		werknemer.setSalaris(salaris);
		assertEquals(salaris, werknemer.getSalaris(), 0);
	}

	@Test
	@DisplayName("Werknemer - minimum salaris moet gerespeceerd worden via setSalaris")
	public void testSetterSalarisTeLaag() {
		Werknemer werknemer = new Werknemer("Doe", "John");
		double salaris = 500.25;
		werknemer.setSalaris(salaris);
		assertEquals(Werknemer.getMinimumSalaris(), werknemer.getSalaris(), 0);
	}

	@Test
	@DisplayName("Werknemer - getSalaris")
	public void testGetterSalaris() {
		Werknemer werknemer = new Werknemer("Doe", "John", "bediende", 2500.5);
		assertEquals(2500.5, werknemer.getSalaris(), 0);
	}

	@Test
	@DisplayName("Werknemer - getFunctie")
	public void testGetterFunctie() {
		Werknemer werknemer = new Werknemer("Doe", "John", "bediende", 2500.5);
		assertEquals("bediende", werknemer.getFunctie());
	}

	@Test
	@DisplayName("Werknemer - setFunctie")
	public void testSetterFunctie() {
		Werknemer werknemer = new Werknemer("Doe", "John");
		werknemer.setFunctie("verkoper");
		assertEquals("verkoper", werknemer.getFunctie());
	}

	@Test
	@DisplayName("Werknemer - totaal aantal Werknemer instanties moet opgevraag kunnen worden")
	public void testCountWerknemerObjecten() {
		int before = Werknemer.getAantal();
		new Werknemer("", "");
		new Werknemer("", "");
		new Persoon("", "");
		int later = Werknemer.getAantal();
		assertEquals(2, later - before);
	}

}
