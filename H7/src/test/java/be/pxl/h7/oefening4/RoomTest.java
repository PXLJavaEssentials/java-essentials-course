package be.pxl.h7.oefening4;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H7", exerciseCode = "Oefening 4 - CheckPointGame", sourceCodeRelativeFilePaths = "Room.java")
public class RoomTest {

	private Room kitchen = new Room("Kitchen");
	private Room garage = new Room("Garage");
	private Room livingRoom = new Room("Living Room");

	@BeforeEach
	public void init() {
		kitchen.setDoor(Direction.EAST, garage);
		kitchen.setDoor(Direction.WEST, livingRoom);
	}

	@Test
	@DisplayName("Room - instructions should correctly show room movement possibilities")
	public void getInstructionsTest() {
		String instructions = kitchen.getInstructions();
		assertTrue(instructions.contains("EAST Garage"));
		assertTrue(instructions.contains("WEST Living Room"));
	}

	@Test
	@DisplayName("Room - name should be stored correctly")
	public void getNameTest() {
		assertEquals("Living Room", livingRoom.getName());
	}

}
