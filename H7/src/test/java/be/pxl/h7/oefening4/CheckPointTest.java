package be.pxl.h7.oefening4;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H7", exerciseCode = "Oefening 4 - CheckPointGame", sourceCodeRelativeFilePaths = "CheckPoint.java")
public class CheckPointTest {

	private Player player;
	private CheckPoint checkPoint;

	@BeforeEach
	public void init() {
		checkPoint = new CheckPoint("Charlie", 120);
		player = new Player("Tester");
	}

	@Test
	@DisplayName("CheckPoint - checkPointControl Should return false if not enough items were collected")
	public void checkPointControlReturnsFalseIfNotEnoughItemsCollected() {
		assertFalse(checkPoint.checkPointControl(player));
	}


	@Test
	@DisplayName("CheckPoint - checkPointControl Should return true if enough items were collected")
	public void checkPointControlReturnsTrueIfEnoughItemsCollected() {
		player.addItem(new Item("Item", 120));
		assertTrue(checkPoint.checkPointControl(player));
	}
}
