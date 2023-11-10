package be.pxl.h7.oefening4;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H7", exerciseCode = "Oefening 4 - CheckPointGame", sourceCodeRelativeFilePaths = "Laboratory.java")
public class LaboratoryTest {

	private Laboratory laboratory;
	private Player player;
	private Item in = new Item("In", 5);

	@BeforeEach
	public void init() {
		laboratory = new Laboratory("MyLab", in, new Item("Out", 10));
		player = new Player("Tester");
	}


	@Test
	@DisplayName("Laboratory - should show instructions properly")
	public void getInstructions() {
		String instructions = laboratory.getInstructions();
		assertTrue(instructions.contains("TRANSFORM In (5) -> Out (10)"));
	}

	@Test
	@DisplayName("Laboratory - should transform item when player has one")
	public void transformWhenPlayerHasItem() {
		player.addItem(in);
		laboratory.transform(player);
		assertEquals(10, player.getTotalValue());
	}

	@Test
	@DisplayName("Laboratory - should not transform item when player doesn't have one")
	public void transformWhenPlayerHasItemNot() {
		player.addItem(new Item("Something", 8));
		laboratory.transform(player);
		assertEquals(8, player.getTotalValue());
	}

}
