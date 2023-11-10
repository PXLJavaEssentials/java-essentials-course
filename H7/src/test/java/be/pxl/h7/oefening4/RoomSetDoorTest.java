package be.pxl.h7.oefening4;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H7", exerciseCode = "Oefening 4 - CheckPointGame", sourceCodeRelativeFilePaths = "Room.java")
public class RoomSetDoorTest {

	private Room kitchen = new Room("Kitchen");
	private Room garage = new Room("Garage");
	private Room livingRoom = new Room("Living Room");


	@Test
	@DisplayName("Room - door should enable passage in both directions")
	public void doorPassageIsSetInBothDirections() {
		kitchen.setDoor(Direction.NORTH, garage);
		assertEquals(garage, kitchen.explore(Direction.NORTH));
		assertEquals(kitchen, garage.explore(Direction.SOUTH));
	}

	@Test
	@DisplayName("Room - only one door per room can be allowed in the same direction")
	public void doorPassageNotSetIfItsAlreadyTaken() {
		kitchen.setDoor(Direction.NORTH, garage);
		kitchen.setDoor(Direction.NORTH, livingRoom);
		assertEquals(garage, kitchen.explore(Direction.NORTH));
		assertEquals(kitchen, garage.explore(Direction.SOUTH));
	}

	@Test
	@DisplayName("Room - door can not be allowed if opposing direction is already taken in other room")
	public void doorPassageNotSetIfOpositeDirectionOfOpositeRoomIsAlreadyTaken() {
		kitchen.setDoor(Direction.NORTH, garage);
		// garage's south door leads to kitchen
		// so it's south door cannot lead to living room, therefore the following setDoor is invalid
		livingRoom.setDoor(Direction.NORTH, garage);
		assertEquals(garage, kitchen.explore(Direction.NORTH));
		assertEquals(kitchen, garage.explore(Direction.SOUTH));
		assertNull(livingRoom.explore(Direction.NORTH));
	}

}
