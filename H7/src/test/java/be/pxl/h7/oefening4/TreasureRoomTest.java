package be.pxl.h7.oefening4;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H7", exerciseCode = "Oefening 4 - CheckPointGame", sourceCodeRelativeFilePaths = "TreasureRoom.java")
public class TreasureRoomTest {
	private TreasureRoom room;
	private Player player;
	private Item treasure = new Item("Treasure", 5);

	@BeforeEach
	public void init() {
		room = new TreasureRoom("Treasure Room", treasure);
		player = new Player("Tester");
	}


	@Test
	@DisplayName("TreasureRoom - should correctly show instructions to take treasure")
	public void getInstructions() {
		String instructions = room.getInstructions();
		assertTrue(instructions.contains("TAKE Treasure (5)"));
	}

	@Test
	@DisplayName("TreasureRoom - should not show TAKE instruction when item is already taken")
	public void getInstructionsWhenItemIsTaken() {
		room.takeItem(player);
		String instructions = room.getInstructions();
		assertFalse(instructions.contains("TAKE"));
	}

	@Test
	@DisplayName("TreasureRoom - player should be able to pick up item")
	public void playerCanTakeItem() {
		assertEquals(0, player.getTotalValue());
		room.takeItem(player);
		assertEquals(5, player.getTotalValue());
	}

	@Test
	@DisplayName("TreasureRoom - item should be removed when player has taken it")
	public void playerCanTakeItemOnce() {
		assertEquals(0, player.getTotalValue());
		room.takeItem(player);
		assertEquals(5, player.getTotalValue());
		room.takeItem(player);
		assertEquals(5, player.getTotalValue());
	}

	@Test
	@DisplayName("TreasureRoom - toString should show correct info when item is available")
	public void toStringWhenItemAvailable() {
		assertEquals("Treasure Room*", room.toString());
	}

	@Test
	@DisplayName("TreasureRoom - toString should show correct info when item is not available")
	public void toStringWhenItemNotAvailable() {
		room.takeItem(player);
		assertEquals("Treasure Room", room.toString());
	}

}
