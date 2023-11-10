package be.pxl.h7.oefening4;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H7", exerciseCode = "Oefening 4 - CheckPointGame", sourceCodeRelativeFilePaths = "Player.java")
public class PlayerTest {

	private Player player;

	@BeforeEach
	public void init() {
		player = new Player("Tester");
	}

	@Test
	@DisplayName("Player - total value should be 0 when player has no items")
	public void returnsZeroWhenNoItems() {
		assertEquals(0, player.getTotalValue());
	}

	@Test
	@DisplayName("Player - total value should be sum of all available items")
	public void returnSumOfAllItemValues() {
		player.addItem(new Item("Item 1", 2));
		player.addItem(new Item("Item 2", 4));
		player.addItem(new Item("Item 3", 6));
		player.addItem(new Item("Item 4", 8));
		assertEquals(20, player.getTotalValue());
	}

	@Test
	@DisplayName("Player - should correctly display items in console")
	public void displayItemsTest() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		player.addItem(new Item("Item 1", 20));
		player.addItem(new Item("Item 2", 4));
		player.displayItems();
		System.out.flush();
		String result = baos.toString();
		assertTrue(result.contains("Item 1 (20)"));
		assertTrue(result.contains("Item 2 (4)"));
		assertTrue(result.contains("24"));
	}

	@Test
	@DisplayName("Player - isTotalValueSufficient should return true when item value is sufficient")
	public void isTotalValueSufficientReturnsTrueIfSufficient() {
		player.addItem(new Item("Item 1", 20));
		player.addItem(new Item("Item 2", 4));
		assertTrue(player.isTotalValueSufficient(24));
	}

	@Test
	@DisplayName("Player - isTotalValueSufficient should return false when item value is not sufficient")
	public void isTotalValueSufficientReturnsTrueIfNotSufficient() {
		player.addItem(new Item("Item 1", 20));
		player.addItem(new Item("Item 2", 4));
		assertFalse(player.isTotalValueSufficient(25));
	}

	@Test
	@DisplayName("Player - replaceItem should correctly replace item")
	public void itemCanBeReplacedCorrectly() {
		player.addItem(new Item("Item 1", 2));
		player.addItem(new Item("Item 2", 4));
		Item itemOut = new Item("Item 3", 6);
		player.addItem(itemOut);
		player.addItem(new Item("Item 4", 8));
		assertEquals(20, player.getTotalValue());
		player.replaceItem(itemOut, new Item("Item 5", 12));
		assertEquals(26, player.getTotalValue());
	}

	@Test
	@DisplayName("Player - name should be stored correctly")
	public void getNameTest() {
		assertEquals("Tester", player.getName());
	}

}
